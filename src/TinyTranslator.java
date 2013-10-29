import java.util.*;

public class TinyTranslator {
    int reg_index;
    int lines;
    String res = "";

    public TinyTranslator() {
	reg_index = 0;
    }

    void print(String code) {
	System.out.println(code);
    }

    String getRegister() {
	return "r"+Integer.toString(reg_index++);
    }

    public void translate(SymbolTable symTable, LinkedList<IRnode> irList){
	HashSet symbols = new HashSet(symTable.getSymbols().keySet());
	Iterator it = symbols.iterator();
	while(it.hasNext())
	    System.out.println("var "+(String)it.next());

	print("push");
	print("push r0");
	print("push r1");
	print("push r2");
	print("push r3");

	HashMap<String, String> registerMap = new HashMap<String, String>();
	for(IRnode node : irList){
	    String tinyCode = "";
	    String irCode = new String(node.getCode());
	    String[] irSplit = irCode.split(" ");
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

	    //
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
		if (symTable.getSymbol(irSplit[1]).getType() == "INT") {
		    print("cmpi " + irSplit[1] + " " + tinyReg);
		    print(tinyCode + " " + irSplit[3]);
		} else if (symTable.getSymbol(irSplit[1]).getType() == "FLOAT") {
		    print("cmpr " + irSplit[1] + " " + tinyReg);
		    print(tinyCode + " " + irSplit[3]);
		}
	    } else if (irCode.startsWith("JUMP")) {
		print(tinyCode + " " + irSplit[1]);
	    } else if (irCode.startsWith("LABEL")) {
		print(tinyCode + " " + irSplit[1]);
	    }
	}
	print("sys halt");
    }
}
