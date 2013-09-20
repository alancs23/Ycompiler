import java.io.IOException;
import java.io.FileReader;

import org.antlr.v4.runtime.*;


public class Micro {
    public static void main(String[] args) throws IOException {
	try {
	    CharStream charStream = new ANTLRFileStream(args[0]);
	    MicroLexer lexer = new MicroLexer(charStream);
	    TokenStream tokenStream = new CommonTokenStream(lexer);
	    MicroParser parser = new MicroParser(tokenStream);
	    parser.program();
	    System.out.println("Accepted");

	}
	catch (Exception e) {
	    System.out.println("Not accepted");
	}
    }
}
