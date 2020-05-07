package org.cannonbank.core.controllers;

import java.util.Date;


import org.cannonbank.core.Entities.Request;
import org.cannonbank.core.Services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/RequestApi")
public class RequestServiceController {
	@Autowired
	RequestService requestService;
	   @RequestMapping(value = "/makeRequest" , method = RequestMethod.POST)
	   public boolean makeRequest(@RequestBody Request request ) {
	       try { 
	    		requestService.makeRequest(request);
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

