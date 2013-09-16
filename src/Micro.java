import java.io.IOException;
import java.io.FileReader;

import org.antlr.v4.runtime.*;

public class Micro {
    public static void main(String[] args) throws IOException {
	ANTLRInputStream input = new ANTLRInputStream(new FileReader(args[0]));
	MicroLexer lexer = new MicroLexer(input);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	MicroParser p = new MicroParser(tokens);

	    /*
	    if(tokens.getType() == -1) {
		break;
	    }
	    switch(tokens.getType()) {
	    case 1:
		;break;
	    case 2:
		System.out.println("Token Type: KEYWORD");
		System.out.println("Value: " + tokens.getText());
		} */

    }
}
