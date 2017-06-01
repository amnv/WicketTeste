package br.com.itep.exception;

/**
 * Throws when the entity doesn't exist
 * @author allyson.manoel
 *
 */

public class NonExistentException extends RuntimeException {
	
	public NonExistentException() {
		super("This person doesn't exist");
	}
	
	public NonExistentException(String message)
	{
		super(message);
	}
}
