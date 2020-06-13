package org.cannonbank.core.services.card;

import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Request;

public interface CardService {

    public abstract void generateCard(Request request);
}
