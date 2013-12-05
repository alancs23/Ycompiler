import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class IRnode {
    String irCode;
    String[] tinycode;
    HashSet<String> liveVars;
    public Map<String, String> liveVar;
    public IRnode next;
    public IRnode pre;
    IRnode next2;
    IRnode pre2;
    int killNum;
    int genNum;
    String killVar;
    public String[] genVars;
    boolean boundry;

    public IRnode(String ir) {
	irCode = ir;
	killNum = 0;
	genNum = 0;
	boundry = false;
	genVars = new String[2];
	killVar = null;
	next = null;
	pre = null;
	next2 = null;
	pre2 = null;
	liveVar = new LinkedHashMap<String, String>();
	liveVars = new HashSet<String>();
    }

    public void printLiveVar() {
	System.out.print("; " + getCode() + "   live vars---> ");
	for (String s : liveVars)
	    System.out.print(s + " ");
	System.out.println();
    }

    public boolean isBoundry() {
	return boundry;
    }

    public void setBoundry(boolean var) {
	boundry = var;
    }

    public HashSet<String> getLiveVars() {
	return liveVars;
    }

    public void addLiveVars(String var) {
	liveVars.add(var);
    }

    public boolean isLive(String var) {
	return liveVars.contains(var);
    }

    public void setKillNum(int num) {
	killNum = num;
    }

    public void removeKillVar(String var) {
	liveVars.remove(var);
    }

    public void setGenVarNum(int num) {
	genNum = num;
    }

    public int getKillNum() {
	return killNum;
    }

    public String getKillVar() {
	return killVar;
    }

    public String[] getGenVars() {
	return genVars;
    }

    public int getGenNum() {
	return genNum;
    }

    public void addGen(int i, String var) {
	genVars[i] = var;
    }

    public void addKill(String var) {
	killVar = var;
    }

    public String getCode() {
	return irCode;
    }
}
