package org.cannonbank.core.services.request;

import org.cannonbank.core.Entities.Request;
import org.cannonbank.core.Entities.RequestCardPayload;
import org.cannonbank.core.Entities.RequestCheckbookPayload;
import org.cannonbank.core.Entities.RequestDocumentPayload;

public interface RequestService {

	   public void makeCheckbookRequest(String username,
							   RequestCheckbookPayload requestCheckbookPayload);
	public void makeCardRequest(String username,
							RequestCardPayload requestCardPayload);
	public void makeDocumentRequest(String username,
							RequestDocumentPayload requestDocumentPayload);

	   public void validateRequest(Request request);

}
