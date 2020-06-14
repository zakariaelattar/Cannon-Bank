package org.cannonbank.core.third_party.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RechargeException extends Exception{

        Logger logger = LoggerFactory.getLogger(RechargeException.class);

    public RechargeException(String message){

        logger.error(message);
    }
}
