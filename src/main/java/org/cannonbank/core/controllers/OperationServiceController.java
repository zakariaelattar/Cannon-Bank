package org.cannonbank.core.controllers;

import java.util.Date;

import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Entities.Transaction;
import org.cannonbank.core.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/OperationApi")
public class OperationServiceController {
	@Autowired
	   OperationService operationService;
	   @RequestMapping(value = "/makeTransaction" , method = RequestMethod.POST)
	   public boolean makeTransaction(@RequestBody Transaction transaction ) {
	       try { 
	    	   operationService.transfertMoney(transaction);
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

