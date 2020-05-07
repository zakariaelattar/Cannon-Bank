package org.cannonbank.core.exceptions;

public class SameAccountException {

	private String message;
	public String getMessage()
	{
		return message;
	}
	SameAccountException( )
	{
		message="Same account";
	}

}