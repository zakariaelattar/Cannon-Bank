package org.cannonbank.core.controllers;

import org.cannonbank.core.Entities.Request;
import org.cannonbank.core.Entities.RequestPayload;
import org.cannonbank.core.Repositories.AccountRepository;
import org.cannonbank.core.services.request.RequestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/RequestApi")
public class RequestServiceController {
	@Autowired
	   RequestService requestService;

	@Autowired
	AccountRepository accountRepository;

	Logger logger = LoggerFactory.getLogger(RequestServiceController.class);

	/**
	 * This endpoint is used to make a request for:
	 * Checkbook,
	 * credit card, or debit card
	 * document or attestation
	 *
	 *
	 * */
	   @RequestMapping(value = "/{accountNumber}/RequestFor/{requestType}" , method = RequestMethod.POST)
	   public boolean makeRequest(@PathVariable String accountNumber, @PathVariable String requestType, @RequestBody RequestPayload args) {

	   	logger.info("the client: "+accountRepository.findByAccountNumber(accountNumber).getClient().getLname()+"is trying to send a request for a "+requestType+" ...");
	       try {
	       	/***
			 *  Ags may be for the checkbook:
			 *  	- number of paper max 50
			 *  	- quantity max 2
			 *
			 *  Ags may be for the credit card:
			 *  	- ?
			 *  	- ?
			 * */
	    		requestService.makeRequest(accountNumber, requestType, args);
	    		return true;		
	       }
	       catch(Exception e)
	       {
	    	    e.printStackTrace();
	    	    return false;
	       }

	       }
	}

