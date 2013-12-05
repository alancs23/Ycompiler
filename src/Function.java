import java.util.Map;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Function {
    String name;
    int localVarNum;
    int parameterNum;
    public int index;
    String type;
    public LinkedList<IRnode> irList = new LinkedList<IRnode>();
    private Map<String, SymbolObject> symbolTab = new LinkedHashMap<String, SymbolObject>();

    public Function() {
	this.name = null;
	localVarNum = 0;
	parameterNum = 0;
	index = 1;
    }

    public Function(String type, String name) {
	this.name = name;
	this.type = type;
	localVarNum = 0;
	parameterNum = 0;
	index = 1;
    }

    public Map<String, SymbolObject> getSymbolTab() {
	return symbolTab;
    }

    public String getName() {
	return name;
    }

    public String getType() {
	return type;
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
