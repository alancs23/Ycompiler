import java.util.*;

public class TinyTranslator {
    int reg_index;
    int lines;
    String res = "";

    Function curFunc;
    Map<String, SymbolObject> curSymbolTab;

    public TinyTranslator(int line) {
	reg_index = 0;
	curFunc = null;
	lines = line;
    }

    void print(String code) {
	System.out.println(code);
    }

    String getRegister() {
	return "r"+Integer.toString(reg_index++);
    }

    public void translate(IRGenerator irGen, LinkedList<IRnode> irList){
	curSymbolTab = irGen.getGlobalTab();
	HashSet symbols = new HashSet(curSymbolTab.keySet());
	Iterator it = symbols.iterator();
	while(it.hasNext()) {
	    String var = (String)it.next();
	    SymbolObject symbol = curSymbolTab.get(var);
	    if (symbol.getType().equals("INT") || symbol.getType().equals("FLOAT"))
		System.out.println("var "+(String)it.next());
	    else if (symbol.getType().equals("STRING"))
		System.out.println("str " + var + " " + symbol.getStr());
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
	    String tinyCode = "";
	    String irCode = new String(node.getCode());
	    String[] irSplit = irCode.split(" ");
	    String[] irSplit_backup = irCode.split(" ");
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

		if (irSplit[i].startsWith("$L")) {
		    int regNum = Integer.parseInt(irSplit[i].substring(2));
		    irSplit[i] = "$" + Integer.toString(regNum * -1);
		} else if (irSplit[i].startsWith("$P")) {
		    int regNum = Integer.parseInt(irSplit[i].substring(2));
		    irSplit[i] = "$" + Integer.toString(6 + paramVarNum - regNum);
		} else if (irSplit[i].startsWith("$R")) {
		    irSplit[i] = "$" + Integer.toString(6 + paramVarNum);
		}
	    }

	    if (irCode.startsWith("STORE")) {
		String res = "";
		String op = "";
		if (irSplit[1].startsWith("$T")) {
		    op = registerMap.get(irSplit[1]);
		    res = irSplit[2];
		    print(tinyCode + " " + op + " " + res);
		} else if (irSplit[2].startsWith("$T")) {
		    op = irSplit[1];
		    res = getRegister();
		    registerMap.put(irSplit[2], res);
		    print(tinyCode + " " + op + " " + res);
		} else {
		    res = getRegister();
		    op = irSplit[1];
		    print(tinyCode + " " + op + " " + res);
		    op = res;
		    res = irSplit[2];
		    print(tinyCode + " " + op + " " + res);
		}
	    } else if (irCode.startsWith("ADD") || irCode.startsWith("MUL") || irCode.startsWith("DIV") || irCode.startsWith("SUB")) {
		String op = "";
		String res = "";
		if (irSplit[1].startsWith("$T") && irSplit[2].startsWith("$T")) {
		    res = registerMap.get(irSplit[1]);
		    op = registerMap.get(irSplit[2]);
		    print(tinyCode + " " + op + " " + res);
		    registerMap.put(irSplit[3], res);
		} else if (irSplit[1].startsWith("$T") || irSplit[2].startsWith("$T")) {
		    if (irSplit[1].startsWith("$T")) {
			res = registerMap.get(irSplit[1]);
			op = irSplit[2];
			print(tinyCode + " " + op + " " + res);
			registerMap.put(irSplit[3], res);
		    } else {
			op = registerMap.get(irSplit[2]);
			res = getRegister();
			print("move " + irSplit[1] + " " + res);
			print(tinyCode + " " + op + " " + res);
			registerMap.put(irSplit[3], res);
		    }
		} else {
		    res = getRegister();
		    op = irSplit[2];
		    print("move " + irSplit[1] + " " + res);
		    //different order
		    print(tinyCode + " " + op + " " + res);
		    registerMap.put(irSplit[3], res);
		}
	    } else if (irCode.startsWith("READ") || irCode.startsWith("WRITE")) {
		print(tinyCode + " " + irSplit[1]);
	    } else if (irCode.startsWith("GE") || irCode.startsWith("GT") || irCode.startsWith("LT")
		       || irCode.startsWith("LE") || irCode.startsWith("EQ") || irCode.startsWith("NE")) {
		String tinyReg = registerMap.get(irSplit[2]);

		if (tinyReg == null) {
		    tinyReg = getRegister();
		    registerMap.put(irSplit[2], tinyReg);
		    print("move " + irSplit[2] + " " + tinyReg);
		}
		if (curSymbolTab.get(irSplit_backup[1]).getType().equals("INT")) {
		    print("cmpi " + irSplit[1] + " " + tinyReg);
		    print(tinyCode + " " + irSplit[3]);
		} else if (curSymbolTab.get(irSplit_backup[1]).getType().equals("FLOAT")) {
		    print("cmpr " + irSplit[1] + " " + tinyReg);
		    print(tinyCode + " " + irSplit[3]);
		}
	    } else if (irCode.startsWith("JUMP")) {
		print(tinyCode + " " + irSplit[1]);
	    } else if (irCode.startsWith("LABEL")) {
		print(tinyCode + " " + irSplit[1]);
		Function tmp_func = irGen.getFuncTable().get(irSplit[1]);
		if (tmp_func != null) {
		    curFunc = tmp_func;
		    curSymbolTab = curFunc.getSymbolTab();
		}
	    } else if (irCode.startsWith("LINK")) {
		print(tinyCode + " " + Integer.toString(curFunc.getLocalVarNum()));
	    } else if (irCode.startsWith("PUSH")) {
		if (irCode.equals("PUSH")) {
		    print(tinyCode);
		} else {
		    if(registerMap.get(irSplit[1]) != null)
			print(tinyCode + " " + registerMap.get(irSplit[1]));
		    else
			print(tinyCode + " " + irSplit[1]);
		}
	    } else if (irCode.startsWith("POP")) {
		if(irCode.equals("POP")) {
		    print(tinyCode);
		} else {
		    String newReg = getRegister();
		    print(tinyCode + " " + newReg);
		    registerMap.put(irSplit[1], newReg);
		}
	    } else if (irCode.startsWith("JSR")) {
		print("push r0");
		print("push r1");
		print("push r2");
		print("push r3");
		print(tinyCode + " " + irSplit[1]);
		print("pop r3");
		print("pop r2");
		print("pop r1");
		print("pop r0");
	    } else if (irCode.startsWith("RET")) {
		print("unlnk");
		print("ret");
	    }
	}
	print("sys halt");
    }

}
