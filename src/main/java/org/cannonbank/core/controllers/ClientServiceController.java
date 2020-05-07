package org.cannonbank.core.controllers;

import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.services.ClientService;
import org.cannonbank.core.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
