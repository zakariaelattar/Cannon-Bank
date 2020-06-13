package org.cannonbank.core.services.request;

import org.cannonbank.core.Entities.*;
import org.cannonbank.core.Repositories.*;
import org.cannonbank.core.services.card.CardService;
import org.cannonbank.core.services.checkbook.CheckbookService;
import org.cannonbank.core.services.document.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private Category_RequestRepository categoryRequestRepository;

	@Autowired
	private CheckbookService checkbookService;

	@Autowired
	private CardService cardService;

	@Autowired
	private DocumentService documentService;


	Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);
	@Override
	public void makeRequest(String accountNumber, String requestType, RequestPayload args) {

		Account account;
		Client client;
		Request request;


		try
		{
			account = accountRepository.findByAccountNumber(accountNumber);
			client = account.getClient();
			CategoryRequest type = categoryRequestRepository.findByName(requestType);
			request = new Request(0,type,client,new Date(),true,new RequestPayload()); // boolean isOpen attribut is to tell us if the request still pending

			requestRepository.save(request);
			logger.info("The client with name: "+client.getLname()+",CNI: "+client.getCni()+" has requested for a "+type.getName()+" with success.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	/***
	 * This method is executed when the chief grant the request, it turn the isOpen value of request to 0, and creating the instance of:
	 *  - checkbook or
	 *  -credit card or
	 *  -document
	 *
	 * */

	@Override
	public void validateRequest(Request request) {

		logger.info("the Request of "+ request.getCategoryRequest().getName()+" is granted.");

		String type_of_request = request.getCategoryRequest().getName();


		/**
		 *  From the type_of_request we will generate , checkbook, or card, or document ??
		 * **/

		switch (type_of_request)
		{
			case "checkbook":
				try {
					checkbookService.generateCheckbook(request);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case "card":
				try {
					cardService.generateCard(request);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "document":
				try {
					documentService.generateDocument(request);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;



		}

	}
}
