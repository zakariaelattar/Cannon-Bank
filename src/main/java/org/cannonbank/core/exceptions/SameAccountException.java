package org.cannonbank.core.exceptions;

public class SameAccountException extends Exception {

	private String message;
	public String getMessage()
	{
		return message;
	}
	public SameAccountException( )
	{
		message="Same account";
	}

}