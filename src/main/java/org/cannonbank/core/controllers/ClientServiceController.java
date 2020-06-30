package org.cannonbank.core.controllers;

import org.cannonbank.core.services.client.ClientService;
import org.cannonbank.core.Entities.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ClientApi")
public class ClientServiceController {
	@Autowired
    ClientService clientService;
		Logger logger = LoggerFactory.getLogger(ClientServiceController.class);
	@RequestMapping(value = "/hello" , method = RequestMethod.POST)

	public boolean hello() {

		logger.trace("hello path");
		logger.info("hello path");
		logger.error("hello path");

		return true;

	}

	@RequestMapping(value = "/Action/{enable}" , method = RequestMethod.POST)
	   public boolean suspendClient(@RequestBody Client client,@PathVariable("enable") int enable ) {
	       try { 
	    		clientService.suspendRestoreClient(client,enable);
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
