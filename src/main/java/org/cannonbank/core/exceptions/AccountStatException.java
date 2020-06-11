package org.cannonbank.core.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountStatException extends Exception {

    Logger logger = LoggerFactory.getLogger(AccountStatException.class);
    public AccountStatException(String message)
    {
        logger.error(message);
    }
}

