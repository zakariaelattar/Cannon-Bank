package org.cannonbank.core.services.client;

import org.cannonbank.core.Entities.Client;

public interface ClientService {


	   public abstract boolean suspendRestoreClient(Client client, int suspend);
}
