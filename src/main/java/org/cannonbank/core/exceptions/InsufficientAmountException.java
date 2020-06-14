package org.cannonbank.core.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsufficientAmountException extends Exception {

	String message = "Insufficient amount in your balance, try to deposit";
	Logger logger = LoggerFactory.getLogger(AccountStatException.class);
	public InsufficientAmountException()
	{
		logger.error(message);
	}

}
