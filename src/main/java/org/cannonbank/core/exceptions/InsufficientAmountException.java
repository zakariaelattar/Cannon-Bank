package org.cannonbank.core.exceptions;

public class InsufficientAmountException extends Exception {
	
	private String message;
	public String getMessage()
	{
		return message;
	}
	public InsufficientAmountException()
	{
		message="insufficent ammount";
	}

}
