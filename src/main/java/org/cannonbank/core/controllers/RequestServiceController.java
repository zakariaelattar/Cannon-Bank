package org.cannonbank.core.controllers;

import org.cannonbank.core.Entities.RequestCardPayload;
import org.cannonbank.core.Entities.RequestCheckbookPayload;
import org.cannonbank.core.Entities.RequestDocumentPayload;
import org.cannonbank.core.Repositories.AccountRepository;
import org.cannonbank.core.Repositories.ClientRepository;
import org.cannonbank.core.services.request.RequestService;

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
		Logger logger = LoggerFactory.getLogger(RequestServiceController.class);

	/**
	 *
	 * This endpoint is used to make a request for:
	 * Checkbook
	 * credit card, or debit card
	 * document or attestation
	 **/
	   @RequestMapping(value = "/{cni}/RequestForCheckbook", method = RequestMethod.POST)
	   public boolean makeCheckbookRequest(@PathVariable String cni,
								  @RequestBody RequestCheckbookPayload args) {

	   	   logger.info("the client: " + clientRepository.findByCni(cni).getLname() + " is trying to send a request for a checkbook ...");

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

					   requestService.makeCheckbookRequest(cni, args);
					   logger.info("saved payload as : checkbook payload");


	    		return true;
	       }
	       catch(Exception e) {
	    	    e.printStackTrace();
	    	    return false;
	       }
	   }

	@RequestMapping(value = "/{cni}/RequestForCard", method = RequestMethod.POST)
	public boolean makeCardRequest(@PathVariable String cni,
										@RequestBody RequestCardPayload args) {

		logger.info("the client: " + clientRepository.findByCni(cni).getLname() + " is trying to send a request for a card ...");

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

			requestService.makeCardRequest(cni, args);
			logger.info("saved payload as : card payload");


			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping(value = "/{cni}/RequestForDocument", method = RequestMethod.POST)
	public boolean makeDocumentRequest(@PathVariable String cni,
										@RequestBody RequestDocumentPayload args) {

		logger.info("the client: " + clientRepository.findByCni(cni).getLname() + " is trying to send a request for a document ...");

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

			requestService.makeDocumentRequest(cni, args);
			logger.info("saved payload as : checkbook payload");


			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

