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

	@Autowired
	private RequestCheckbookPayloadRepository requestCheckbookPayloadRepository;

	@Autowired
	private RequestCardPayloadRepository requestCardPayloadRepository;

	@Autowired
	private RequestDocumentPayloadRepository requestDocumentPayloadRepository;

	@Autowired
	private ClientRepository clientRepository;



	Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);

	@Override
	public void makeCheckbookRequest(String username,
							RequestCheckbookPayload requestCheckbookPayload) {

		Request request;

		CategoryRequest categoryRequest = categoryRequestRepository.findByName("checkbook");
		Client client;
		client = clientRepository.findByUsername(username);
		logger.info("in service ,the request type is: checkbook request  is :"+requestCheckbookPayload);
		logger.info("in service ,the client is : "+ client.getLname());


		try
		{
		request = new Request(categoryRequest,client,requestCheckbookPayload);
		requestCheckbookPayloadRepository.save(requestCheckbookPayload);
		requestRepository.save(request);
			logger.info("saved");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void makeCardRequest(String username,
									 RequestCardPayload requestCardPayload) {

		Request request;
		CategoryRequest categoryRequest = categoryRequestRepository.findByName("card");
		Client client;
		client = clientRepository.findByUsername(username);
		logger.info("in service ,the request type is: card request  is :"+requestCardPayload);
		logger.info("in service ,the client is : "+ client.getLname());


		try
		{
			request = new Request(categoryRequest,client,requestCardPayload);
			requestCardPayloadRepository.save(requestCardPayload);
			requestRepository.save(request);
			logger.info("saved");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void makeDocumentRequest(String username,
								RequestDocumentPayload requestDocumentPayload) {

		Request request;
		CategoryRequest categoryRequest = categoryRequestRepository.findByName("document");
		Client client;
		client = clientRepository.findByUsername(username);
		logger.info("in service ,the request type is: document request  is :"+requestDocumentPayload);
		logger.info("in service ,the client is : "+ client);


		try
		{
			request = new Request(categoryRequest,client,requestDocumentPayload);
			requestDocumentPayloadRepository.save(requestDocumentPayload);
			requestRepository.save(request);
			logger.info("saved");

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
