package br.itep.exception;
/**
 * @author allyson.manoel
 */
public class WrongPasswordException extends RuntimeException {
	public WrongPasswordException() {
		super("Password don't match");
	}
	
	public WrongPasswordException(String messege) {
		super(messege);
	}
}
