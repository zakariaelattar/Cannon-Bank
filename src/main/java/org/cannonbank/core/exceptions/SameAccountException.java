package org.cannonbank.core.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SameAccountException extends Exception {

	String message = "Illegal action, trying to make transaction from an to the same account";
	Logger logger = LoggerFactory.getLogger(AccountStatException.class);
	public SameAccountException()
	{
		logger.error(message);
	}

}
