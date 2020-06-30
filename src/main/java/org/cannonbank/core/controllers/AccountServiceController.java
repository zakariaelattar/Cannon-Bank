package org.cannonbank.core.controllers;

import org.cannonbank.core.services.account.AccountService;
import org.cannonbank.core.services.account.AccountServiceImpl;
import org.cannonbank.core.services.operation.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/AccountApi")
public class AccountServiceController {

	@Autowired
    AccountService accountService;

	@Autowired
    OperationService operationService;

	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	/**
	 *  Enable disable an account
	 * */

	   @RequestMapping(value = "/{accountNumber}/{enable}" , method = RequestMethod.POST)
	   public boolean enableAccount(@PathVariable("enable") int enable, @PathVariable("accountNumber") String accountNumber ) {
		   logger.info("trying to change status if the account :"+accountNumber+"...");
	       try { 
	    		accountService.enableDisableAccount(accountNumber, enable);
	    		return true;		
	       }
	       catch(Exception e)
	       {
	    	    e.printStackTrace();
	    	    return false;
	       }

	       
	       }





	}

