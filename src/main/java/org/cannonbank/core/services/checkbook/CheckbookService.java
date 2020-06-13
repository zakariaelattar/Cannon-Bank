package org.cannonbank.core.services.checkbook;

import org.cannonbank.core.Entities.Checkbook;
import org.cannonbank.core.Entities.Request;

public interface CheckbookService {

    public abstract Checkbook generateCheckbook(Request request);

}
