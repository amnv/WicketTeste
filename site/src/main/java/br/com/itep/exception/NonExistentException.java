package br.com.itep.exception;

public class NonExistentException extends RuntimeException {
	
	public NonExistentException() {
		super("This person doesn't exist");
	}
	
	public NonExistentException(String message)
	{
		super(message);
	}
}
