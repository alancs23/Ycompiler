import java.util.LinkedList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.HashSet;

public class RegAllocation {
    LinkedList<IRnode> irList;
    int maxRegNum;
    IRGenerator irGen;
    Function curFunc;
    Map<String, SymbolObject> curSymTab;
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
		    curNode.pre = jmper;
		    jmper.next = curNode;
		} else {
		    jmpDes.put(irSplit[1], curNode);
		}
	    } else if (curNode.getCode().startsWith("JUMP")) {
		curNode.setBoundry(true);
		String irSplit[] = curNode.getCode().split(" ");
		if (jmpDes.get(irSplit[1]) != null) {
		    IRnode jmpTarget = jmpDes.get(irSplit[1]);
		    curNode.next = jmpTarget;
		    jmpTarget.pre = curNode;

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
		    curNode.next = jmper;
		    jmper.pre = curNode;
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
	    print(code);
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
	    if (node.pre == null)
		continue;
	    HashSet<String> curLiveVars = node.getLiveVars();

	    if (!curLiveVars.isEmpty() && node.getKillNum() > 0) {
		node.removeKillVar(node.getKillVar());
		node.setKillNum(0);
	    }
	    String[] genVars = node.getGenVars();
	    for (int i=0; i<genVars.length; ++i) {
		node.addLiveVars(genVars[i]);
	    }
	}
    }

    private String Allocate(String var, IRnode curNode) {
	String reg = null;
	//if find a free reg, return it
	for (int i=0; i<maxRegNum; i++) {
	    reg = "r" + Integer.toString(i);
	    if (!regVar.containsKey(reg)) {
		regVar.put(reg, var);
		varReg.put(var, reg);
		return reg;
	    }
	}
	//if there is no free regs, find the farthest one and get spill out
	HashSet<String> varsInRegs = new HashSet<String>();
	int remainRegNum = maxRegNum;
	for (int i=0; i<maxRegNum; i++)
	    varsInRegs.add(regVar.get("r"+Integer.toString(i)));
	for (IRnode node=curNode; node!=null && !node.isBoundry(); node=node.next) {
	    String gens[] = node.getGenVars();
	    for (int i=0; i<node.getGenNum(); i++) {
		if (varsInRegs.contains(gens[i])) {
		    varsInRegs.remove(gens[i]);
		    remainRegNum--;
		    break;
		}
		if (remainRegNum == 1)
		    break;
	    }
	    if (remainRegNum == 1)
		break;
	}
	//free the reg
	String[] freeRegs = varsInRegs.toArray(new String[varsInRegs.size()]);
	reg = freeRegs[0];
	//spill
	String spillVar = regVar.get(reg);
	if (var.startsWith("$"))
	    print("move " + reg + " " + varAddr.get(spillVar));
	else
	    print("move " + reg + " " + regVar.get(reg));

	//Free(reg);
	varReg.put(spillVar, reg);
	regVar.put(reg, spillVar);
	return reg;
    }

    public void Run() {
	EstCFG();
	EstKillGen();
	LivenessAnalysis();
    }
}
