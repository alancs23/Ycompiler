public class SymbolObject {

    private String id;
    private String type;
    private String strLiteral;
    private String IRname;

    public SymbolObject(String id) {
	this.id = id;
    }
    public SymbolObject(String id, String type) {
	this.id = id;
	this.type = type;
    }
    public SymbolObject(String id, String type, String strLiteral) {
	this.id = id;
	this.type = type;
	this.strLiteral = strLiteral;
    }
    public String getId() {
	return id;
    }
    public String getType() {
	return type;
    }

    public void setIRname(String str) {
	this.IRname = str;
    }

    public String getIRname() {
	return this.IRname;
    }

    public String getStr() {
	return this.strLiteral;
    }

    public String print() {
	return "name " + id + " type " + type + "\n";
    }
    public String printStr() {
	return "name " + id + " type " + type + " value " + strLiteral + "\n";
    }
}
