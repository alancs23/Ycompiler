import java.io.IOException;
import java.io.FileReader;

import org.antlr.v4.runtime.*;


public class Micro {

    public static class BailMicroLexer extends MicroLexer {
	public BailMicroLexer(CharStream input) { super(input); }
	public void recover(LexerNoViableAltException e) {
	    throw new RuntimeException(e);
	}
    }

    public static void main(String[] args) throws IOException {
	    CharStream input = new ANTLRFileStream(args[0]);
	    BailMicroLexer lexer = new BailMicroLexer(input);
	    TokenStream tokenStream = new CommonTokenStream(lexer);
	    MicroParser parser = new MicroParser(tokenStream);
	    SymbolTable globalSymTab = new SymbolTable();
	    parser.program();
    }
}
