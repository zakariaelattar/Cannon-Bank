package org.cannonbank.core.Services;

import java.util.Collection;
import java.util.Date;

import org.cannonbank.core.Repositories.RequestRepository;
import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Entities.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	private RequestRepository requestRepository;

	@Override
	public void makeRequest(Request request) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void manageRequest(Request request) {
//		// TODO Auto-generated method stub
//		
//	}

	

//	@Override
//	public void createRequest(Request request) {
//	
//		requestRepository.
//	}
//
//	@Override
//	public void updateRequest(Request request) {
//
//		requestRepository.save(request);
//	}
//
//	@Override
//	public void deleteRequest(Request request) {
//		
//		requestRepository.delete(request.getId_Request());
//	}
//
//	@Override
//	public Collection<Request> getRequests() {
//		requestRepository.findAll();
//		return null;
//	}

	 
	
}
