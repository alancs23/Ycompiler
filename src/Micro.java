import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.LinkedList;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.*;

import antlr.ANTLRException;

public class Micro {
    /*
    public static class BailMicroLexer extends MicroLexer {
	public BailMicroLexer(CharStream input) { super(input); }
	public void recover(LexerNoViableAltException e) {
	    throw new RuntimeException(e);
	}
    }
*/
    public static void main(String[] args) throws IOException, RecognitionException {
	//BufferedReader br = new BufferedReader(new FileReader(args[0]));
	int cnt = 0;
	boolean fm = false;
	boolean fa = false;
	boolean fi = false;
	String str;
	CharStream charStream = new ANTLRFileStream(args[0]);
	MicroLexer lexer = new MicroLexer(charStream);
	TokenStream tokenStream = new CommonTokenStream(lexer);
	MicroParser parser = new MicroParser(tokenStream);
	SymbolTable globalSymTab = new SymbolTable();
	MicroParser.program_return r = parser.program();
	CommonTree ast = (CommonTree)r.getTree();
	IRGenerator IRGen = new IRGenerator();
	IRGen.genIRcode(ast);
	LinkedList<IRnode> irList = IRGen.irList;
	RegAllocation regAllo = new RegAllocation(4, IRGen);
	regAllo.Run();
	TinyTranslator IRtoTiny = new TinyTranslator(cnt);
	IRtoTiny.translate(IRGen,irList);
    }
}
