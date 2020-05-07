package org.cannonbank.core.exceptions;

public class InsuffisentAmountException extends Exception {
	
	private String message;
	public String getMessage()
	{
		return message;
	}
	InsuffisentAmountException()
	{
		message="insufficent ammount";
	}

}
