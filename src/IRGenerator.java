import java.util.LinkedList;

import org.antlr.runtime.tree.BaseTree;
import org.antlr.runtime.tree.CommonTree;

public class IRGenerator {
    int reg_index;
    int label_index;
    SymbolTable globalSymTab;
    SymbolTable curSymTable;
    LinkedList<IRnode> irList;

    IRGenerator(SymbolTable tab) {
	reg_index = 1;
	label_index = 1;
	globalSymTab = tab;
	curSymTable = globalSymTab;
	irList = new LinkedList();
    }

    void addToList(String code) {
	irList.add(new IRnode(code));
	System.out.println(';' + code);
    }

    String getSymbolType(String symName) {
	SymbolObject s = curSymTable.getSymbol(symName);
	return s.getType();
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
	case MicroParser.PROGRAM :     program(astTree);        break;
	case MicroParser.FUNC_DECL_LIST: func_decl_list(astTree); break;
	case MicroParser.FUNCTION:     function(astTree);       break;
	case MicroParser.STMT_LIST :     stmt_list(astTree);      break;
	case MicroParser.EXPR_LIST :     expr_list(astTree);      break;
	case MicroParser.IF :            if_stmt(astTree);      break;
	case MicroParser.DO :            do_while_stmt(astTree);   break;
	case MicroParser.ADD :           operator(astTree, null);       break;
	case MicroParser.SUB :           operator(astTree, null);       break;
	case MicroParser.MULT:           operator(astTree, null);       break;
	case MicroParser.DIV :           operator(astTree, null);       break;
	case MicroParser.READ:         read(astTree); break;
	case MicroParser.WRITE:        write(astTree); break;
	case MicroParser.ASSIGN:         assign_gen(astTree, null);   break;
	default: System.out.println("ERROR TOKEN!-----> "+astTree.getToken().getText());
	}
    }

    public void program(CommonTree astTree) {
	for(int i = 0; i < astTree.getChildren().size(); i++) {
	    genIRcode(getChild(astTree, i));
	}
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
	    SymbolObject symbol = globalSymTab.getSymbol(res[0]);
	    res[1] = symbol.getType();
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
	} else {
	    // :=, + , - , * , /
	    String[] leftNode = new String[2];
	    String[] rightNode = new String[2];
	    assign_gen(getChild(astTree, 0), leftNode);
	    assign_gen(getChild(astTree, 1), rightNode);
	    String type = "";
	    String code = "";
	    if (leftNode[1].equals("INT") && rightNode[1].equals("INT")) {
		res[1] = "INT";
		type = "I ";
	    } else if (leftNode[1].equals("FLOAT") || rightNode[1].equals("FLOAT")) {
		res[1] = "FLOAT";
		type = "F ";
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
	if (getChildTokenTxt(astTree, 1).equals("main")) {
	    addToList("IR code");
	}
	genIRcode(getChild(astTree, 2));
    }

    public void stmt_list(CommonTree astTree) {
	for(int i = 0; i < astTree.getChildren().size(); i++)
	    genIRcode( getChild(astTree, i) );
    }

    public void expr_list(CommonTree astTree) {
	for(int i = 0; i < astTree.getChildren().size(); i++)
	    genIRcode( getChild(astTree, i) );
    }

    public void read(CommonTree astTree) {
	String type = "";
	String op = "READ";
	astTree = (CommonTree)astTree.getChild(0);
	for(int i = 0; i < astTree.getChildren().size(); i ++) {
	    type = globalSymTab.getSymbol(getChildTokenTxt(astTree, i)).getType();
	    if(type == "INT")
		addToList(op + "I " + getChildTokenTxt(astTree, i));
	    else if(type == "FLOAT")
		addToList(op + "F "+ getChildTokenTxt(astTree, i));
	}
    }

    public void write(CommonTree astTree) {
	String type = "";
	String op = "WRITE";
	astTree = (CommonTree)astTree.getChild(0);
	for(int i = 0; i < astTree.getChildren().size(); i ++) {
	    type = globalSymTab.getSymbol(getChildTokenTxt(astTree, i)).getType();
	    if(type == "INT")
		addToList(op+"I "+getChildTokenTxt(astTree, i));
	    else if(type == "FLOAT")
		addToList(op+"F "+getChildTokenTxt(astTree, i));
	}
    }

    public void operator(CommonTree astTree, String[] res) {
	assign_gen(astTree, res);
    }
}
