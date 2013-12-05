import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.HashSet;
import java.util.Iterator;

public class RegAllocation {
    LinkedList<IRnode> irList;
    int maxRegNum;
    IRGenerator irGen;
    Function curFunc;
    Map<String, SymbolObject> curSymbolTab;
    Map<String, String> regVar;
    Map<String, String> varReg;
    Map<String, String> varAddr;

    public RegAllocation(int maxRegNum, IRGenerator irGen) {
	this.maxRegNum = maxRegNum;
	this.irGen = irGen;
	irList = irGen.getIrList();
	curFunc = null;
	regVar = new LinkedHashMap<String, String>();
	varReg = new LinkedHashMap<String, String>();
	varAddr = new LinkedHashMap<String, String>();
    }

    String getRegister() {
	return "r"+Integer.toString(1);
    }

    private void print(String str) {
	System.out.println(str);
    }

    public void EstCFG() {
	IRnode preNode = null;
	Map<String, IRnode> jumper = new LinkedHashMap<String, IRnode>();
	Map<String, IRnode> jmpDes = new LinkedHashMap<String, IRnode>();

	for (IRnode curNode : irList) {
	    //check if curNode is leader
	    if (preNode!=null && !preNode.getCode().startsWith("JUMP") && !preNode.getCode().startsWith("RET")) {
		curNode.pre = preNode;
		preNode.next = curNode;
	    }
	    if (curNode.getCode().startsWith("LABEL")) {
		curNode.setBoundry(true);
		String irSplit[] = curNode.getCode().split(" ");
		if (jumper.get(irSplit[1]) != null) {
		    IRnode jmper = jumper.get(irSplit[1]);
		    curNode.pre2 = jmper;
		    jmper.next2 = curNode;
		} else {
		    jmpDes.put(irSplit[1], curNode);
		}
	    } else if (curNode.getCode().startsWith("JUMP")) {
		curNode.setBoundry(true);
		String irSplit[] = curNode.getCode().split(" ");
		if (jmpDes.get(irSplit[1]) != null) {
		    IRnode jmpTarget = jmpDes.get(irSplit[1]);
		    curNode.next2 = jmpTarget;
		    jmpTarget.pre2 = curNode;

		} else {
		    jumper.put(irSplit[1], curNode);
		}
	    } else if (curNode.getCode().startsWith("GE") || curNode.getCode().startsWith("NE")
		       || curNode.getCode().startsWith("LE") || curNode.getCode().startsWith("GT")
		       || curNode.getCode().startsWith("LT") || curNode.getCode().startsWith("EQ")) {

		curNode.setBoundry(true);
		String irSplit[] = curNode.getCode().split(" ");
		if (jmpDes.get(irSplit[3]) != null) {
		    IRnode jmper = jumper.get(irSplit[3]);
		    curNode.next2 = jmper;
		    jmper.pre2 = curNode;
		} else {
		    jumper.put(irSplit[3], curNode);
		}
	    }
	    preNode = curNode;
	}

	//debug
	for (IRnode curNode : irList) {
	    String code = "; " + curNode.getCode();
	    String preCode = "{PRE nodes : ";
	    String nextCode = "{NEXT node : ";

	    if (curNode.pre != null) preCode += curNode.pre.getCode();
	    preCode += " }";
	    if (curNode.next != null) nextCode += curNode.next.getCode();
	    nextCode += " }";
	    code += " " + preCode + " " + nextCode;
	    //print(code);
	}
    }

    //establish kill an gen for each irCode
    public void EstKillGen() {
	String irCode;
	IRnode node;
	ListIterator<IRnode> it = irList.listIterator();
	String[] irSplit;
	int curGenNum;

	while (it.hasNext())
	    it.next();

	//bottom up
	while (it.hasPrevious()) {
	    node = it.previous();
	    irCode = node.getCode();
	    irSplit = irCode.split(" ");

	    //start set kill and gen for each IRnode
	    if (irCode.startsWith("READ") || irCode.startsWith("WRITE")) {
		curGenNum = node.getGenNum();
		node.addGen(curGenNum, irSplit[1]);
		curGenNum++;
		node.setGenVarNum(curGenNum);
	    } else if (irCode.startsWith("STORE")) {
		if (irSplit[1].startsWith("$T") || irSplit[1].startsWith("$L")) {
		    curGenNum = node.getGenNum();
		    node.addGen(curGenNum, irSplit[1]);
		    curGenNum++;
		    node.setGenVarNum(curGenNum);
		}
		node.setKillNum(1);
		node.addKill(irSplit[2]);
	    } else if (irCode.startsWith("ADD") || irCode.startsWith("SUB") || irCode.startsWith("MULT") || irCode.startsWith("DIV")) {
		curGenNum = node.getGenNum();
		node.addGen(curGenNum, irSplit[1]);
		curGenNum++;
		node.addGen(curGenNum, irSplit[2]);
		curGenNum++;
		node.setGenVarNum(curGenNum);
		node.addKill(irSplit[3]);
		node.setKillNum(1);
	    } else if (irCode.startsWith("GE") || irCode.startsWith("NE")
		       || irCode.startsWith("LE") || irCode.startsWith("GT")
		       || irCode.startsWith("LT") || irCode.startsWith("EQ")) {

		curGenNum = node.getGenNum();
		node.addGen(curGenNum, irSplit[1]);
		curGenNum++;
		node.addGen(curGenNum, irSplit[2]);
		curGenNum++;
		node.setGenVarNum(curGenNum);
	    }
	}
    }

    public void LivenessAnalysis() {
	IRnode node;
	ListIterator<IRnode> it = irList.listIterator();

	while(it.hasNext())
	    it.next();
	while (it.hasPrevious()) {
	    node = it.previous();
	    if (node.pre == null && node.pre2 == null)
		continue;
	    //HashSet<String> curLiveVars = node.getLiveVars();
	    Map<String, String> tmp = new LinkedHashMap<String, String>();
	    if (!node.liveVar.isEmpty())
		tmp.putAll(node.liveVar);
	    // if (!curLiveVars.isEmpty() && node.getKillNum() > 0) {
	    // 	node.removeKillVar(node.getKillVar());
	    // 	node.setKillNum(0);
	    // }
	    if (node.getKillNum() > 0)
		tmp.remove(node.getKillVar());
	    for (int i=0; i<node.getGenNum(); ++i) {
		if (!tmp.containsKey(node.genVars[i]))
		    tmp.put(node.genVars[i], node.genVars[i]);
	    }
	    // String[] genVars = node.getGenVars();
	    // for (int i=0; i<genVars.length; ++i) {
	    // 	node.addLiveVars(genVars[i]);
	    // }
	    if (node.pre != null)
		node.pre.liveVar.putAll(tmp);
	    if (node.pre2 != null)
		node.pre2.liveVar.putAll(tmp);
	}
	//debug
	// while(it.hasNext()) {
	//     node = it.next();
	//     node.printLiveVar();
	// }
    }

    private String Allocate(String var, IRnode curNode) {
	String reg = null;
	//if find a free reg, return it
	//print("allocate var--> " + var);
	//here
	for (int i=maxRegNum-1; i>=0; i--) {
	    reg = "r" + Integer.toString(i);
	    if (!regVar.containsKey(reg)) {
		regVar.put(reg, var);
		varReg.put(var, reg);
		return reg;
	    }
	}

	//if there is no free regs, find the farthest one and get spill out

	//HashSet<String> varsInRegs = new HashSet<String>();
	String[] varsInRegs = new String[maxRegNum];
	int remainRegNum = maxRegNum;
	for (int i=0; i<maxRegNum; i++)
	    varsInRegs[i] = regVar.get("r"+Integer.toString(i));
	for (IRnode node=curNode; node!=null; node=node.next) {
	    //String gens[] = node.getGenVars();
	    for (int i=0; i<node.getGenNum(); i++) {
		// if (varsInRegs.contains(gens[i])) {
		//     varsInRegs.remove(gens[i]);
		//     remainRegNum--;
		//     break;
		// }
		for (int j=0; j<maxRegNum; j++) {
		    if (node.genVars[i].equals(null))
			continue;
		    if (node.genVars[i].equals(varsInRegs[j])) {
			varsInRegs[j] = null;
			remainRegNum--;
			break;
		    }
		}
		if (remainRegNum == 1)
		    break;
	    }
	    if (remainRegNum == 1)
		break;
	}
	//free the reg
	// String[] freeRegs = varsInRegs.toArray(new String[varsInRegs.size()]);
	// reg = varReg.get(freeRegs[0]);
	for(int i=0; i <maxRegNum; i++) {
	    if(varsInRegs[i] != null) {
		reg = "r" + Integer.toString(i);
		break;
	    }
	}
	//spill
	if (reg == null)
	    print("error in allocation--> reg == null");
	String spillVar = regVar.get(reg);
	if (spillVar == null)
	    print("error in allocation--> spillVar == null");
	if (spillVar.startsWith("$"))
	    print("move " + reg + " " + varAddr.get(spillVar));
	else
	    print("move " + reg + " " + regVar.get(reg));

	Free(reg);
	varReg.put(spillVar, reg);
	regVar.put(reg, spillVar);

	return reg;
    }

    public String Ensure(String var, String varTiny, IRnode node) {
	String reg = null;
	//if var exists, return reg
	 // for (Map.Entry<String, String> e : varReg.entrySet())
	 //      print("varReg in Ensure--> " + e.getKey() + " " + e.getValue());
	if (varReg.containsKey(var)) {
	    reg = varReg.get(var);
	    return reg;
	}
	//if not, allocate one
	reg = Allocate(var, node);
	regVar.put(reg, var);
	varReg.put(var, reg);
	if (varTiny != null) {
	    if (varTiny.startsWith("$T"))
		print("move " + varAddr.get(varTiny) + " " + reg);
	    else
		print("move " + varTiny + " " + reg);
	}
	return reg;
    }

    public String FreeDeadReg(String var, IRnode node) {
	if (var == null)
	    return null;
	if (node.liveVar.containsKey(var))
	    return null;
	String reg = varReg.get(var);
	Free(reg);
	return reg;
    }

    public void Free(String reg) {
	if (reg == null)
	    return ;
	//print("move " + reg + " " + regVar.get(reg));
	String var = regVar.get(reg);
	regVar.remove(reg);
	varReg.remove(var);
    }

    public void Translate(){
	curSymbolTab = irGen.getGlobalTab();
	HashSet symbols = new HashSet(curSymbolTab.keySet());
	Iterator it = symbols.iterator();
	while(it.hasNext()) {
	    String var = it.next().toString();
	    SymbolObject symbol = curSymbolTab.get(var);
	    if (symbol.getType().equals("INT") || symbol.getType().equals("FLOAT"))
		print("var "+ var);
	    else if (symbol.getType().equals("STRING"))
		print("str " + var + " " + symbol.getStr());
	}

	print("push");
	print("push r0");
	print("push r1");
	print("push r2");
	print("push r3");
	print("jsr main");
	print("sys halt");

	HashMap<String, String> registerMap = new HashMap<String, String>();
	for(IRnode node : irList){
	    print(";----------------");
	    print("; " + node.getCode());
	    String tinyCode = "";
	    String irCode = new String(node.getCode());
	    String[] irSplit = irCode.split(" ");
	    String[] irSplit_bak = irCode.split(" ");
	    if (irSplit[0].equals("ADDI"))
		tinyCode = "addi";
	    else if (irSplit[0].equals("ADDF"))
		tinyCode = "addr";
	    else if (irSplit[0].equals("SUBI"))
		tinyCode = "subi";
	    else if (irSplit[0].equals("SUBF"))
		tinyCode = "subr";
	    else if (irSplit[0].equals("MULTI"))
		tinyCode = "muli";
	    else if (irSplit[0].equals("MULTF"))
		tinyCode = "mulr";
	    else if (irSplit[0].equals("DIVI"))
		tinyCode = "divi";
	    else if (irSplit[0].equals("DIVF"))
		tinyCode = "divr";
	    else if (irSplit[0].equals("STOREI"))
		tinyCode = "move";
	    else if (irSplit[0].equals("STOREF"))
		tinyCode = "move";
	    else if (irSplit[0].equals("READI"))
		tinyCode = "sys readi";
	    else if (irSplit[0].equals("READF"))
		tinyCode = "sys readr";
	    else if (irSplit[0].equals("WRITEI"))
		tinyCode = "sys writei";
	    else if (irSplit[0].equals("WRITEF"))
		tinyCode = "sys writer";
	    else if (irSplit[0].equals("WRITES"))
		tinyCode = "sys writes";
	    //conditional
	    else if (irSplit[0].equals("GT"))
		tinyCode = "jgt";
	    else if (irSplit[0].equals("GE"))
		tinyCode = "jge";
	    else if (irSplit[0].equals("LT"))
		tinyCode = "jlt";
	    else if (irSplit[0].equals("LE"))
		tinyCode = "jle";
	    else if (irSplit[0].equals("EQ"))
		tinyCode = "jeq";
	    else if (irSplit[0].equals("NE"))
		tinyCode = "jne";
	    else if (irSplit[0].equals("JUMP"))
		tinyCode = "jmp";
	    else if (irSplit[0].equals("LABEL"))
		tinyCode = "label";
	    //function
	    else if (irSplit[0].equals("PUSH"))
		tinyCode = "push";
	    else if (irSplit[0].equals("POP"))
		tinyCode = "pop";
	    else if (irSplit[0].equals("LINK"))
		tinyCode = "link";
	    else if (irSplit[0].equals("RET"))
		tinyCode = "ret";
	    else if (irSplit[0].equals("JSR"))
		tinyCode = "jsr";
	    //
	    //renew register

	    for (int i=0; i<irSplit.length; i++) {
		if (curFunc == null)
		    break;

		int localVarNum = curFunc.getLocalVarNum();
		int paramVarNum = curFunc.getParameterNum();

		if (irSplit[i].startsWith("$T")) {
		    int regNum = Integer.parseInt(irSplit[i].substring(2));
		    varAddr.put(irSplit_bak[i], "$" + Integer.toString(-1 * localVarNum - regNum));
		} else if(irSplit[i].startsWith("$L")) {
		    int regNum = Integer.parseInt(irSplit[i].substring(2));
		    irSplit[i] = "$" + Integer.toString(regNum * -1);
		    varAddr.put(irSplit_bak[i], irSplit[i]);
		} else if (irSplit[i].startsWith("$P")) {
		    int regNum = Integer.parseInt(irSplit[i].substring(2));
		    irSplit[i] = "$" + Integer.toString(6 + paramVarNum - regNum);
		    varAddr.put(irSplit_bak[i], irSplit[i]);
		} else if (irSplit[i].startsWith("$R")) {
		    irSplit[i] = "$" + Integer.toString(6 + paramVarNum);
		    varAddr.put(irSplit_bak[i], irSplit[i]);
		}
	    }

	    if (irCode.startsWith("STORE")) {
		// store rx, ry
		String res = "";
		String op = "";

		if (irSplit[1].startsWith("$T")) {
		    // for (Map.Entry<String, String> entry : regVar.entrySet()) {
		    // 	print("Before Map---> " + entry.getKey() + " " + entry.getValue());
		    // }
		    op = Ensure(irSplit_bak[1], null, node);
		    FreeDeadReg(irSplit_bak[1], node);
		    res = Ensure(irSplit_bak[2], null, node);
		    FreeDeadReg(irSplit_bak[2], node);

		    if (!op.equals(res)) {
			print("move " + op + " " + res);
		    } // else
		      // 	print("eeeeeee");
		    if (!node.isLive(irSplit_bak[2]) || irSplit_bak[2].equals("$R")) {
			print("move " + op + " " + irSplit[2]);
		    }
		    // for (Map.Entry<String, String> entry : regVar.entrySet()) {
		    // 	print("After Map---> " + entry.getKey() + " " + entry.getValue());
		    // }
		} else {
		    res = Ensure(irSplit_bak[2], null, node);
		    FreeDeadReg(irSplit_bak[2], node);
		    print("move " + irSplit[1] + " " + res);
		    if (irSplit_bak[2].equals("$R"))
			print("move " + res + " " + irSplit[2]);
		}
	    } else if (irCode.startsWith("ADD") || irCode.startsWith("MUL")) {
		String op = "";
		String res = "";
		op = Ensure(irSplit_bak[1], irSplit[1], node);
		res = Ensure(irSplit_bak[2], irSplit[2], node);
		FreeDeadReg(irSplit_bak[1], node);
		FreeDeadReg(irSplit_bak[2], node);
		String real_res = Ensure(irSplit_bak[3], null, node);
		//debug
		//print("addd---> " + op + " " + res + " " + real_res);
		if (real_res.equals(op)) {
		    print(tinyCode + " " + res + " " + real_res);
		} else if (real_res.equals(res)) {
		    print(tinyCode + " " + op + " " + real_res);
		} else {
		    print("move " + op + " " + real_res);
		    print(tinyCode + " " + res + " " + real_res);
		}
	    } else if (irCode.startsWith("SUB") || irCode.startsWith("DIV")) {
		String op = null;
		String res = null;
		String real_res = null;
		op = Ensure(irSplit_bak[1], irSplit[1], node);
		res = Ensure(irSplit_bak[2], irSplit[2], node);
		real_res = FreeDeadReg(irSplit_bak[1], node);
		FreeDeadReg(irSplit_bak[2], node);
		if (op.equals(real_res)) {
		    varReg.put(irSplit_bak[3], op);
		    regVar.put(op,irSplit_bak[3]);
		} else {
		    //if (node.isLive(irSplit_bak[1]))
		    if (node.liveVar.containsKey(irSplit_bak[1]))
			print("move " + op + " " + irSplit[1]);
		    regVar.put(op, irSplit_bak[3]);
		    varReg.put(irSplit_bak[3], op);
		}
		print(tinyCode + " " + res + " " + op);
	    } else if (irCode.startsWith("READ")) {
		String res;
		if (irGen.getGlobalTab().containsKey(irSplit_bak[1])) {
		    SymbolObject symbol = irGen.getGlobalTab().get(irSplit_bak[1]);
		    if (symbol.getType().equals("STRING")) {
			print(tinyCode + " " + irSplit_bak[1]);
		    } else {
			res = Ensure(irSplit_bak[1], irSplit[1], node);
			FreeDeadReg(irSplit_bak[1], node);
			print(tinyCode + " " + res);
		    }
		} else if (irSplit_bak[1].equals(irSplit[1])){
		    res = Ensure(irSplit_bak[1], irSplit[1], node);
		    FreeDeadReg(irSplit_bak[1], node);
		    print(tinyCode + " " + res);
		} else {
		    print(tinyCode + " " + irSplit[1]);
		}
	    } else if (irCode.startsWith("WRITE")) {
		String res;
		if (irGen.getGlobalTab().containsKey(irSplit_bak[1])) {
		    SymbolObject symbol = irGen.getGlobalTab().get(irSplit_bak[1]);
		    if (symbol.getType().equals("STRING")) {
			print(tinyCode + " " + irSplit_bak[1]);
		    } else {
			res = Ensure(irSplit_bak[1], irSplit[1], node);
			FreeDeadReg(irSplit_bak[1], node);
			print(tinyCode + " " + res);
		    }
		} else {
		    res = Ensure(irSplit_bak[1], irSplit[1], node);
		    FreeDeadReg(irSplit_bak[1], node);
		    print(tinyCode + " " + res);
		}
	    } else if (irCode.startsWith("GE") || irCode.startsWith("GT") || irCode.startsWith("LT")
		       || irCode.startsWith("LE") || irCode.startsWith("EQ") || irCode.startsWith("NE")) {
		//String tinyReg = registerMap.get(irSplit[2]);
		String op1 = Ensure(irSplit_bak[1], irSplit[1], node);
		String op2 = Ensure(irSplit_bak[2], irSplit[2], node);
		String label = irSplit[3];
		SymbolObject symbol = curSymbolTab.get(irSplit_bak[1]);
		if (symbol == null)
		    symbol = irGen.getGlobalTab().get(irSplit_bak[1]);
		if (symbol == null)
		    print("ERRRRROR--> no symbol in table -> " + curSymbolTab);
		if (symbol.getType().equals("INT")) {
		    print("cmpi " + op1 + " " + op2);
		} else if (symbol.getType().equals("FLOAT")) {
		    print("cmpr " + op1 + " " + op2);
		}
	    } else if (irCode.startsWith("LABEL")) {
		String label = irSplit[1];
		Function tmp_func = irGen.getFuncTable().get(label);
		if (tmp_func != null) {
		    curFunc = tmp_func;
		    curSymbolTab = curFunc.getSymbolTab();
		    //debug
		    // print("function---> " + curFunc.getName() + " Tab " + curSymbolTab);
		    // for (Map.Entry<String, SymbolObject> e : curSymbolTab.entrySet()) {
		    // 	print("curSymbol content --> " + e.getKey() + " " + e.getValue().getIRname());
		    // }
		    print(tinyCode + " " + label);
		    varAddr.clear();
		}
	    } else if (irCode.startsWith("LINK")) {
		print(tinyCode + " " + Integer.toString(curFunc.getLocalVarNum() + curFunc.index - 1));
	    } else if (irCode.startsWith("PUSH")) {
		if (irCode.equals("PUSH")) {
		    print(tinyCode);
		} else {
		    String op = Ensure(irSplit_bak[1], irSplit[1], node);
		    FreeDeadReg(irSplit_bak[1], node);
		    print(tinyCode + " " + op);
		}
	    } else if (irCode.startsWith("POP")) {
		if(irCode.equals("POP")) {
		    print(tinyCode);
		} else {
		    String op = Ensure(irSplit_bak[1], null, node);
		    print(tinyCode + " " + op);
		}
	    } else if (irCode.startsWith("RET")) {
		print("unlnk");
		print("ret");
	    }
	    if (node.next2 != null || node.pre2 != null || irCode.startsWith("JSR")) {
		String activeVar;
		for (int i=0; i<maxRegNum; i++) {
		    String r = "r" + Integer.toString(i);
		    activeVar = regVar.get(r);
		    if (activeVar == null)
			continue;
		    //debug
		    // for(Map.Entry<String, String> e : regVar.entrySet()) {
		    // 	print("regVar at last --> " + e.getKey() + " " + e.getValue());
		    // }
		    //print("activeVar---> " + activeVar + " " + r);
		    if (varAddr.containsKey(activeVar)) {
			print("move " + r + " " + varAddr.get(activeVar));
		    } else if (curSymbolTab.containsKey(activeVar) || irGen.getGlobalTab().containsKey(activeVar) || !activeVar.startsWith("$")) {
			print("move " + r + " " + activeVar);
		    } else if (node.isLive(activeVar)) {
			print("move " + r + " " + activeVar);
		    }
		}
		regVar.clear();
		varReg.clear();
	    }
	    if (irCode.startsWith("JSR")) {
		print("push r0");
		print("push r1");
		print("push r2");
		print("push r3");
		print(tinyCode + " " + irSplit[1]);
		print("pop r3");
		print("pop r2");
		print("pop r1");
		print("pop r0");
	    } else if (irCode.startsWith("JUMP")) {
		print(tinyCode + " " + irSplit[1]);
	    } else if (irCode.startsWith("LABEL")) {
		if (irGen.getFuncTable().get(irSplit[1]) == null) {
		    print(tinyCode + " " + irSplit[1]);
		}
	    } else if ((irCode.startsWith("GE") || irCode.startsWith("GT") || irCode.startsWith("LT")
			|| irCode.startsWith("LE") || irCode.startsWith("EQ") || irCode.startsWith("NE"))) {
		print(tinyCode + " " + irSplit[3]);
	    }
	}

	print("sys halt");
    }

    public void Run() {
	EstCFG();
	EstKillGen();
	LivenessAnalysis();
	Translate();
    }
}
