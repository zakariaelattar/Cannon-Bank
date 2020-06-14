package org.cannonbank.core.services.client;

import java.util.Collection;

import org.cannonbank.core.Entities.Client;

public interface ClientService {


	   public abstract boolean suspendRestoreClient(Client client, int suspend);
}
