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
	try {
	    CharStream input = new ANTLRFileStream(args[0]);
	    BailMicroLexer lexer = new BailMicroLexer(input);
	    TokenStream tokenStream = new CommonTokenStream(lexer);
	    MicroParser parser = new MicroParser(tokenStream);
	    parser.setErrorHandler(new BailErrorStrategy());
	    parser.program();
	    System.out.println("Accepted");

	}
	catch (Exception e) {
	    System.out.println("Not Accepted");
	}
    }
}
