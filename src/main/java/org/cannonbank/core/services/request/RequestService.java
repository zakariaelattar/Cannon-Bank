package org.cannonbank.core.services.request;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Entities.Request;
import org.cannonbank.core.Entities.RequestPayload;

public interface RequestService {

	   public void makeRequest(String accountNumber, String requestType, RequestPayload args);
	   public void validateRequest(Request request);

}
