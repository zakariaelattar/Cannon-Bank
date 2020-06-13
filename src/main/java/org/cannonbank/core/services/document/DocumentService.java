package org.cannonbank.core.services.document;

import org.cannonbank.core.Entities.Document;
import org.cannonbank.core.Entities.Request;

public interface DocumentService {

    public Document generateDocument(Request request);
}
