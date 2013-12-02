import java.util.HashSet;

public class IRnode {
    String irCode;
    String[] tinycode;
    HashSet<String> liveVars;
    public IRnode next;
    public IRnode pre;
    int killNum;
    int genNum;
    String killVar;
    String[] genVars;
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
	liveVars = new HashSet<String>();
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
