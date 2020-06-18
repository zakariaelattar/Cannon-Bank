package org.cannonbank.core.services.request;

import com.fasterxml.jackson.core.util.RequestPayload;
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
import java.util.List;
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

	@Autowired
	private RequestCheckbookPayloadRepository requestCheckbookPayloadRepository;

	@Autowired
	private RequestCardPayloadRepository requestCardPayloadRepository;

	@Autowired
	private RequestDocumentPayloadRepository requestDocumentPayloadRepository;



	Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);
	@Override
	public void makeRequest(String accountNumber,
							String requestType,
							RequestCheckbookPayload requestCheckbookPayload) {



		logger.info("in service 1, request payload is :"+requestCheckbookPayload);
		requestCheckbookPayloadRepository.save(new RequestCheckbookPayload(0,55,2));
		logger.info("done");

		try
		{

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
