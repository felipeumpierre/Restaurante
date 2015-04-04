package exception;

public class InvalidStatusCode extends Exception
{
	private static final long serialVersionUID = 6033378703448101508L;

	public InvalidStatusCode( String message )
	{
		super( message );
	}
}
