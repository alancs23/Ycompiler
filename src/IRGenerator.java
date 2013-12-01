import java.util.LinkedList;
import java.util.Map;
import java.util.LinkedHashMap;

import org.antlr.runtime.tree.BaseTree;
import org.antlr.runtime.tree.CommonTree;

public class IRGenerator {
    int reg_index;
    int label_index;
    Map<String, SymbolObject> globalSymTab;
    Map<String, SymbolObject> curSymTable;
    Map<String, Function> funcTable;
    LinkedList<IRnode> irList;
    Function curFunction;

    public IRGenerator() {
	reg_index = 1;
	label_index = 1;
	globalSymTab = new LinkedHashMap<String, SymbolObject>();
	funcTable = new LinkedHashMap<String, Function>();
	curSymTable = globalSymTab;
	irList = new LinkedList();
	curFunction = null;
    }

    Map<String, SymbolObject> getGlobalTab() {
	return globalSymTab;
    }

    void addToList(String code) {
	irList.add(new IRnode(code));
	System.out.println(';' + code);
    }

    Map<String, Function> getFuncTable() {
	return this.funcTable;
    }

    SymbolObject getSymbol(String id) {
	SymbolObject res = this.curSymTable.get(id);
	if (res != null)
	    return res;
	else
	    return this.globalSymTab.get(id);
    }

    String changeName(SymbolObject symbol) {
	String IRname = symbol.getIRname();
	if (IRname != null)
	    return IRname;
	else
	    return symbol.getId();
    }

    int getTokenType(CommonTree astTree) {
	return astTree.getToken().getType();
    }

    String getTokenTxt(CommonTree astTree) {
	return astTree.getToken().getText();
    }

    CommonTree getChild(BaseTree astTree, int i) {
	return  (CommonTree)astTree.getChild(i);
    }

    String getChildToken(BaseTree astTree, int i) {

	return getChild(astTree, i).getText().toString();
    }

    String getChildTokenTxt(BaseTree astTree, int i) {
	return getChild(astTree,i).getToken().getText();
    }

    String getRegister() {
	String res = "$T" + Integer.toString(reg_index);
	reg_index++;
	return res;
    }

    String getLabel() {
	String res = "label" + Integer.toString(label_index);
	label_index++;
	return res;
    }

    public void genIRcode(CommonTree astTree) {
	switch(astTree.getToken().getType()) {
	case MicroParser.PROGRAM :          program(astTree);              break;
	case MicroParser.PGM_BODY:          pgm_body(astTree);             break;
	case MicroParser.DECL :             decl(astTree);                 break;
	case MicroParser.FUNC_DECL_LIST:    func_decl_list(astTree);       break;
	case MicroParser.FUNCTION:          function(astTree);             break;
	case MicroParser.FUNC_BODY:         func_body(astTree);            break;
	case MicroParser.PARAM_DECL_LIST :  param_decl_list(astTree);      break;
	case MicroParser.CALL_EXPR :        call_expr(astTree);            break;
	case MicroParser.VAR_DECL :         var_decl(astTree);             break;
	case MicroParser.RETURN:            return_stmt(astTree);          break;
	case MicroParser.STMT_LIST :        stmt_list(astTree);            break;
	case MicroParser.EXPR_LIST :        expr_list(astTree);            break;
	case MicroParser.STRING :           string_decl(astTree);          break;
	case MicroParser.IF :               if_stmt(astTree);              break;
	case MicroParser.DO :               do_while_stmt(astTree);        break;
	case MicroParser.ADD :              operator(astTree, null);       break;
	case MicroParser.SUB :              operator(astTree, null);       break;
	case MicroParser.MULT:              operator(astTree, null);       break;
	case MicroParser.DIV :              operator(astTree, null);       break;
	case MicroParser.READ:              read(astTree);                 break;
	case MicroParser.WRITE:             write(astTree);                break;
	case MicroParser.ASSIGN:            assign_gen(astTree, null);     break;
	default: System.out.println("ERROR TOKEN!-----> "+astTree.getToken().getText());
	}
    }

    public void program(CommonTree astTree) {
	for(int i = 0; i < astTree.getChildren().size(); i++) {
	    genIRcode(getChild(astTree, i));
	}
    }

    public void pgm_body(CommonTree astTree) {
	for(int i = 0; i < astTree.getChildren().size(); i++) {
	    genIRcode(getChild(astTree, i));
	}
    }

    public void decl(CommonTree astTree) {
	for(int i = 0; astTree.getChildren()!=null && i<astTree.getChildren().size(); i++) {
	    genIRcode(getChild(astTree, i));
	}
    }

    public void var_decl(CommonTree astTree) {
	if (astTree.getChildren() == null)
	    return ;
	String varType = getChildTokenTxt(astTree, 0);
	for (int i=1; i<astTree.getChildren().size(); i++) {
	    SymbolObject symbol = new SymbolObject(getChildTokenTxt(astTree, i), varType);

	    if (curFunction != null)
		symbol.setIRname("$L" + Integer.toString(curFunction.getLocalVarNum() + 1));

	    curFunction.setLocalVarNum(curFunction.getLocalVarNum() + 1);
	    curSymTable.put(getChildTokenTxt(astTree, i), symbol);
	    curSymTable.put(symbol.getIRname(), symbol);
	}

	if (curFunction != null) {
	    int tmp_newlocalVarNum = astTree.getChildren().size()-1 + curFunction.getLocalVarNum();
	    curFunction.setLocalVarNum(tmp_newlocalVarNum);
	}
    }

    public String call_expr(CommonTree astTree) {
	int para_num = getChild(astTree, 1).getChildren().size();
	String parameters[] = new String[para_num];
	String assign_res[] = new String[2];

	for (int i=0; i<para_num; i++) {
	    CommonTree tmp = getChild(astTree, 1);
	    assign_gen(getChild(tmp, i), assign_res);
	    parameters[i] = assign_res[0];
	}

	addToList("PUSH");

	for (int i=0; i<para_num; i++)
	    addToList("PUSH " + parameters[i]);

	addToList("JSR " + getChildTokenTxt(astTree, 0));

	for(int i=0; i < para_num; i++){
	    addToList("POP");
	}

	String ret_reg = getRegister();

	addToList("POP "+ ret_reg);

	return ret_reg;
    }

    public void return_stmt(CommonTree astTree) {
	String store_type = null;
	String res[] = new String[2];
	assign_gen(getChild(astTree, 0), res);

	if (res[1].equals("INT"))
	    store_type = "STOREI ";
	else if (res[1].equals("FLOAT"))
	    store_type = "STOREF ";
	else
	    System.out.println("Unknow return type  " + res[1]);
	addToList(store_type + res[0] + " $R");
	addToList("RET\n");
    }

    public void func_decl_list(CommonTree astTree) {
	for(int i = 0; i < astTree.getChildren().size(); i++)
	    genIRcode( getChild(astTree, i) );
    }

    public void assign_gen(CommonTree astTree, String[] res) {
	/*
	  res[0] ---> result
	  res[1] ---> type
	  res[2] ---> temp result
	*/
	if (res == null)
	    res = new String[2];
	if (getTokenType(astTree) == MicroParser.IDENTIFIER) {
	    res[0] = getTokenTxt(astTree);
	    SymbolObject symbol = getSymbol(res[0]);
	    res[1] = symbol.getType();
	    res[0] = changeName(symbol);
	} else if (getTokenType(astTree) == MicroParser.INTLITERAL) {
	    String operand = getTokenTxt(astTree);
	    res[1] = "INT";
	    String reg = getRegister();
	    addToList("STOREI " + operand + ' ' + reg);
	    res[0] = reg;
	} else if (getTokenType(astTree) == MicroParser.FLOATLITERAL) {
	    String operand = getTokenTxt(astTree);
	    res[1] = "FLOAT";
	    String reg = getRegister();
	    addToList("STOREF " + operand + ' ' + reg);
	    res[0] = reg;
	} else if (getTokenType(astTree) == MicroParser.CALL_EXPR) {
	    //System.out.println("call----> " + getChildTokenTxt(astTree, 0));
	    res[1] = "CALL";
	    res[0] = call_expr(astTree);
	} else {
	    // :=, + , - , * , /
	    String[] leftNode = new String[2];
	    String[] rightNode = new String[2];
	    assign_gen(getChild(astTree, 0), leftNode);
	    assign_gen(getChild(astTree, 1), rightNode);
	    String type = "";
	    String code = "";

	    if (leftNode[1].equals("INT") || rightNode[1].equals("INT")) {
		res[1] = "INT";
		type = "I ";
	    } else if (leftNode[1].equals("FLOAT") || rightNode[1].equals("FLOAT")) {
		res[1] = "FLOAT";
		type = "F ";
	    } else if (rightNode[1].equals("CALL")) {
		System.out.println("leftNode--> " + leftNode[1] + " rightNode---> " + rightNode[1]);
	    }

	    switch(getTokenType(astTree)) {
	    case(MicroParser.ASSIGN):
		code = "STORE" + type + rightNode[0] + ' ' + leftNode[0];

		break;
	    case(MicroParser.ADD):
		code = "ADD" + type;
		break;
	    case(MicroParser.SUB):
		code = "SUB" + type;
		break;
	    case(MicroParser.MULT):
		code = "MULT" + type;
		break;
	    case(MicroParser.DIV):
		code = "DIV" + type;
		break;
	    }
	    if (getTokenType(astTree) != MicroParser.ASSIGN) {
		res[0] = getRegister();
		code += leftNode[0] + " " + rightNode[0] + " " + res[0];
	    }
	    addToList(code);
	}
    }

    public void do_while_stmt(CommonTree astTree) {
	String inLabel = getLabel();
	String outLabel = getLabel();

	addToList("LABEL " + inLabel);
	genIRcode(getChild(astTree, 0));
	cond(getChild(astTree, 1), outLabel);
	addToList("JUMP " + inLabel);
	addToList("LABEL " + outLabel);
    }

    public void if_stmt(CommonTree astTree) {
	String outLabel = getLabel();
	String endLabel = getLabel();
	cond(getChild(astTree, 0), outLabel);
	for (int i=1; i<astTree.getChildren().size(); i++) {
	    if (getTokenType(getChild(astTree, i)) == MicroParser.ELSIF) {
		outLabel = elsif(getChild(astTree, i), outLabel, endLabel);
	    } else {
		genIRcode(getChild(astTree, i));
		addToList("JUMP " + endLabel);
	    }
	}
	addToList("LABEL " + outLabel);
	addToList("LABEL " + endLabel);
    }

    public String elsif(CommonTree astTree, String inLabel, String endLabel) {
	String outLabel = getLabel();
	addToList("LABEL " + inLabel);
	cond(getChild(astTree, 0), outLabel);
	for (int i=1; i<astTree.getChildren().size(); ++i) {
	    if (getTokenType(getChild(astTree, i)) == MicroParser.ELSIF) {
		outLabel = elsif(getChild(astTree, i), outLabel, endLabel);
	    } else {
		genIRcode(getChild(astTree, i));
		addToList("JUMP " + endLabel);
	    }
	}
	return outLabel;
    }

    public void cond(CommonTree astTree,  String outLabel) {
	String cond_code = null;
	String left_res[] = {null, null};
	String right_res[] = {null, null};
	//true || false
	if (getTokenType(astTree) == MicroParser.TRUE)
	    return ;
	else if (getTokenType(astTree) == MicroParser.FALSE) {
	    addToList("JUMP " + outLabel);
	}
	//gen cond code
	operator(getChild(astTree, 0), left_res);
	operator(getChild(astTree, 1), right_res);

	//condition
	if (getTokenType(astTree) == MicroParser.L)
	    cond_code = "GE ";
	else if (getTokenType(astTree) == MicroParser.LE)
	    cond_code = "GT ";
	else if (getTokenType(astTree) == MicroParser.G)
	    cond_code = "LE ";
	else if (getTokenType(astTree) == MicroParser.GE)
	    cond_code = "LT ";
	else if (getTokenType(astTree) == MicroParser.EQ)
	    cond_code = "NE ";
	else
	    cond_code = "EQ ";
	addToList(cond_code + left_res[0] + " " + right_res[0] + " " + outLabel);
    }

    public void function(CommonTree astTree) {
	// if (getChildTokenTxt(astTree, 1).equals("main")) {
	//     addToList("IR code");
	// }
	// genIRcode(getChild(astTree, 2));
	//System.out.println("function nam :  " + getChildTokenTxt(astTree, 0));
	String funcName = getChildTokenTxt(astTree, 1);
	Function func = new Function(funcName);
	curFunction = func;
	curSymTable = func.getSymbolTab();
	funcTable.put(funcName, func);

	String isPara = getChildTokenTxt(astTree, 2);
	if (isPara.equals("PARAM_DECL_LIST")) {
	    //function contains parameters
	    genIRcode(getChild(astTree, 2));
	    addToList("LABEL " + funcName);
	    addToList("LINK ");
	    //function body
	    genIRcode(getChild(astTree, 3));
	} else {
	    //function do NOT contains parameters
	    addToList("LABEL " + funcName);
	    addToList("LINK ");
	    //function body
	    genIRcode(getChild(astTree, 2));
	}

	//check RET at the end
    }

    public void param_decl_list(CommonTree astTree) {
	if (astTree.getChildren() == null)
	    return ;

	curFunction.setParameterNum(astTree.getChildren().size() / 2);
	for (int i=0; astTree.getChildren()!=null && i<astTree.getChildren().size(); i+=2) {
	    SymbolObject symbol = new SymbolObject(getChildToken(astTree, i+1), getChildToken(astTree, i));
	    symbol.setIRname("$P" + Integer.toString(i/2+1));
	    curSymTable.put(getChildToken(astTree, i+1), symbol);
	    curSymTable.put(symbol.getIRname(), symbol);
	}
    }

    public void stmt_list(CommonTree astTree) {
	for(int i = 0; i < astTree.getChildren().size(); i++)
	    genIRcode( getChild(astTree, i) );
    }

    public void func_body(CommonTree astTree) {
	for (int i=0; astTree.getChildren()!=null && i<astTree.getChildren().size(); i++) {
	    genIRcode(getChild(astTree, i));
	}
    }

    public void expr_list(CommonTree astTree) {
	for(int i = 0; i < astTree.getChildren().size(); i++)
	    genIRcode( getChild(astTree, i) );
    }

    public void string_decl(CommonTree astTree) {
	SymbolObject symbol = new SymbolObject(getChildTokenTxt(astTree, 0), "STRING", getChildTokenTxt(astTree, 1));
	curSymTable.put(getChildTokenTxt(astTree, 0), symbol);
    }

    public void read(CommonTree astTree) {
	String type = "";
	String op = "READ";
	astTree = (CommonTree)astTree.getChild(0);
	for(int i = 0; i < astTree.getChildren().size(); i ++) {
	    SymbolObject symbol = getSymbol(getChildTokenTxt(astTree, i));
	    type = symbol.getType();
	    String irname = changeName(symbol);

	    if(type.equals("INT"))
		addToList(op + "I "+ irname);
	    else if(type.equals("FLOAT"))
		addToList(op + "F "+ irname);
	    else if (type.equals("STRING"))
		addToList(op + "S " + irname);
	}
    }

    public void write(CommonTree astTree) {
	String type = "";
	String op = "WRITE";
	astTree = (CommonTree)astTree.getChild(0);
	for(int i = 0; i < astTree.getChildren().size(); i ++) {
	    SymbolObject symbol = getSymbol(getChildTokenTxt(astTree, i));
	    type = symbol.getType();
	    String irname = changeName(symbol);

	    if(type.equals("INT"))
		addToList(op + "I "+ irname);
	    else if(type.equals("FLOAT"))
		addToList(op + "F "+ irname);
	    else if (type.equals("STRING"))
		addToList(op + "S " + irname);
	}
    }

    public void operator(CommonTree astTree, String[] res) {
	assign_gen(astTree, res);
    }
}
