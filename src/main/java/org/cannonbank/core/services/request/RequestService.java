package org.cannonbank.core.services.request;

import org.cannonbank.core.Entities.Request;
import org.cannonbank.core.Entities.RequestCheckbookPayload;

public interface RequestService {

	   public void makeRequest(String accountNumber, String requestType, RequestCheckbookPayload args);
	   public void validateRequest(Request request);

}
