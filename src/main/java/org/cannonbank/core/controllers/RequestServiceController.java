package org.cannonbank.core.controllers;

import org.cannonbank.core.Entities.Request;
import org.cannonbank.core.Repositories.AccountRepository;
import org.cannonbank.core.Repositories.ClientRepository;
import org.cannonbank.core.Repositories.RequestRepository;
import org.cannonbank.core.services.card.CardService;
import org.cannonbank.core.services.request.RequestService;
import org.cannonbank.core.Entities.RequestCardPayload;
import org.cannonbank.core.Entities.RequestCheckbookPayload;
import org.cannonbank.core.Entities.RequestDocumentPayload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/RequestApi")
public class RequestServiceController {

		@Autowired
		RequestService requestService;

		@Autowired
		AccountRepository accountRepository;

		@Autowired
		ClientRepository clientRepository;

		@Autowired
	RequestRepository requestRepository;

		@Autowired
	CardService cardService;

		Logger logger = LoggerFactory.getLogger(RequestServiceController.class);


	/**
	 *
	 * This endpoint is used to make a request for:
	 * Checkbook
	 * credit card, or debit card
	 * document or attestation
	 **/
	   @RequestMapping(value = "/{username}/RequestForCheckbook", method = RequestMethod.POST)
	   public boolean makeCheckbookRequest(@PathVariable String username,
								  @RequestBody RequestCheckbookPayload args) {

	   	   logger.info("the client: " + clientRepository.findByUsername(username).getLname() + " is trying to send a request for a checkbook ...");

		   /***
			*  Ags may be for the checkbook:
			*  	- number of paper max 50
			*  	- quantity max 5
			*
			*  Ags may be for the credit card:
			*  	- ?
			*  	- ?
			***/
		   try {

					   requestService.makeCheckbookRequest(username, args);
					   logger.info("saved payload as : checkbook payload");


	    		return true;
	       }
	       catch(Exception e) {
	    	    e.printStackTrace();
	    	    return false;
	       }
	   }

	@RequestMapping(value = "/{username}/RequestForCard", method = RequestMethod.POST)
	public boolean makeCardRequest(@PathVariable String username,
										@RequestBody RequestCardPayload args) {

		logger.info("the client: " + clientRepository.findByUsername(username).getLname() + " is trying to send a request for a card ...");

		/***
		 *  Ags may be for the checkbook:
		 *  	- number of paper max 50
		 *  	- quantity max 5
		 *
		 *  Ags may be for the credit card:
		 *  	- ?
		 *  	- ?
		 ***/
		try {

			requestService.makeCardRequest(username, args);
			logger.info("saved payload as : card payload");


			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping(value = "/{username}/RequestForDocument", method = RequestMethod.POST)
	public boolean makeDocumentRequest(@PathVariable String username,
										   @RequestBody RequestDocumentPayload args) {

		logger.info("the client: " + clientRepository.findByUsername(username).getLname() + " is trying to send a request for a document ...");

		/***
		 *  Ags may be for the checkbook:
		 *  	- number of paper max 50
		 *  	- quantity max 5
		 *
		 *  Ags may be for the credit card:
		 *  	- ?
		 *  	- ?
		 ***/
		try {

			requestService.makeDocumentRequest(username, args);
			logger.info("saved payload as : checkbook payload");


			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping(value = "/generateCard/{requestId}", method = RequestMethod.POST)
	public boolean generateCard(@PathVariable int requestId){

		Request request = requestRepository.findById(requestId);
		cardService.generateCard(request);
		return true;
	}

}

