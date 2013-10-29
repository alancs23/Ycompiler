public class IRnode {
    IRnode(String ir) {
	irCode = ir;
    }
    String irCode;
    public String[] tinycode;

    public String getCode() {
	return irCode;
    }
}
