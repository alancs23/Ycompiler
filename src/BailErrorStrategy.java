import org.antlr.v4.runtime.*;

public class BailErrorStrategy extends DefaultErrorStrategy {

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        throw new RuntimeException(e);
    }

    @Override
    public Token recoverInline(Parser recognizer)
        throws RecognitionException
    {
        throw new RuntimeException(new InputMismatchException(recognizer));
    }

    @Override
    public void sync(Parser recognizer) { }

    @Override
    public void reportNoViableAlternative(Parser parser,
					  NoViableAltException e)
	throws RecognitionException
    {}
}
