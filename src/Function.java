import java.util.Map;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Function {
    public String name;
    public int localVarNum;
    public int parameterNum;
    public int index;

    public LinkedList<IRnode> irList = new LinkedList<IRnode>();
    private Map<String, SymbolObject> symbolTab = new LinkedHashMap<String, SymbolObject>();

    public Function() {
	this.name = null;
	localVarNum = 0;
	parameterNum = 0;
	index = 1;
    }

    public Function(String name) {
	this.name = name;
	localVarNum = 0;
	parameterNum = 0;
	index = 1;
    }

    public Map<String, SymbolObject> getSymbolTab() {
	return symbolTab;
    }

    public void setParameterNum(int n) {
	this.parameterNum = n;
    }

    public int getParameterNum() {
	return this.parameterNum;
    }

    public int getLocalVarNum() {
	return this.localVarNum;
    }

    public void setLocalVarNum(int n) {
	this.localVarNum = n;
    }
}
