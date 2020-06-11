package org.cannonbank.core.controllers;

import org.cannonbank.core.Entities.Transaction;
import org.cannonbank.core.services.operation.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/OperationApi")
public class OperationServiceController {
	@Autowired
	   OperationService operationService;
	/**
	 * Endpoint that make a transfer of money from sender account to a receiver account
	 *
	 * */
	   @RequestMapping(value = "/transfer/{amount}/{receiver}/{sender}" , method = RequestMethod.POST)
	   public boolean transfer(@PathVariable float amount, @PathVariable int receiver, @PathVariable int sender ) {
	       try {

	    	   operationService.transfertMoney(amount, sender, receiver);
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

