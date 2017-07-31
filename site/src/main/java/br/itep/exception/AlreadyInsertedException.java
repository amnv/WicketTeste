package br.itep.exception;
/**
 * @author allyson.manoel
 */
public class AlreadyInsertedException extends RuntimeException {
	
	public AlreadyInsertedException()
	{
		super("Person has been already inserted");
	}
	
	public AlreadyInsertedException(String message) {
		super(message);
	}
	
	
}
