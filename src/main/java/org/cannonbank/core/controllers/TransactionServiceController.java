package org.cannonbank.core.controllers;

import java.util.Date;

import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Entities.Transaction;

import org.cannonbank.core.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/TransactionApi")
public class TransactionServiceController {
	@Autowired
	TransactionService transactionService;
	   @RequestMapping(value = "/makeTransaction" , method = RequestMethod.POST)
	   public boolean makeTransaction(@RequestBody Transaction transaction ) {
	       try { 
	    		transactionService.transformMoney(transaction);
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

