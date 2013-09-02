import java.io.IOException;
import java.io.FileReader;

import org.antlr.v4.runtime.*;

public class Micro {
    public static void main(String[] args) throws IOException {
	ANTLRInputStream input = new ANTLRInputStream(new FileReader(args[0]));
	MicroLexer lexer = new MicroLexer(input);
	while(true) {
	    Token tokens = lexer.nextToken();
	    if(tokens.getType() == -1) {
		break;
	    }
	    switch(tokens.getType()) {
	    case 1:
		;break;
	    case 2:
		System.out.println("Token Type: KEYWORD");
		System.out.println("Value: " + tokens.getText());
		break;
	    case 3:
		System.out.println("Token Type: IDENTIFIER");
		System.out.println("Value: " + tokens.getText());
		break;
	    case 4:
		System.out.println("Token Type: INTLITERAL");
		System.out.println("Value: " + tokens.getText());
		break;
	    case 5:
		System.out.println("Token Type: FLOATLITERAL");
		System.out.println("Value: " + tokens.getText());
		break;
	    case 6:
		System.out.println("Token Type: OPERATOR");
		System.out.println("Value: " + tokens.getText());
		break;
	    case 7:
		System.out.println("Token Type: STRINGLITERAL");
		System.out.println("Value: " + tokens.getText());
		break;

	    }

	}
    }
}
