import org.antlr.v4.runtime.*;
public class MyErrorHandler extends DefaultErrorStrategy {

    @Override
    public void reportError(Parser parser,
			    RecognitionException e) throws RecognitionException
    {
	System.out.println("Not Accept");
    }

}
