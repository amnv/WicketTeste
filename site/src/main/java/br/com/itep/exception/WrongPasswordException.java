package br.com.itep.exception;

public class WrongPasswordException extends RuntimeException {
	public WrongPasswordException() {
		super("Password don't match");
	}
	
	public WrongPasswordException(String messege) {
		super(messege);
	}
}
