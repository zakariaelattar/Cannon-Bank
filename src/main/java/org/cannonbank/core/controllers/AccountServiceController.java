package org.cannonbank.core.controllers;

import org.cannonbank.core.Entities.Account;

import org.cannonbank.core.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/AccountApi")
public class AccountServiceController {
	@Autowired
	AccountService accountService;
	   @RequestMapping(value = "/Action/{enable}" , method = RequestMethod.POST)
	   public boolean enableAccount(@RequestBody Account account,@PathVariable("enable") int enable ) {
	       try { 
	    		accountService.enableDisableAccount(account,enable);
	    		return true;		
	       }
	       catch(Exception e)
	       {
	    	    e.printStackTrace();
	    	    return false;
	       }
	       finally 
	       {   
	    	    return false;
	       }
	       
	       }
	}

