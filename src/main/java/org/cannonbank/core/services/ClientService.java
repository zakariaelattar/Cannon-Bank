package org.cannonbank.core.services;

import java.util.Collection;

import org.cannonbank.core.Entities.Client;

public interface ClientService {

//	   public abstract void createClient(Client client);
//	   public abstract void updateClient(Client client);
//	   public abstract void deleteClient();
//	   public abstract Collection<Client> getClients();
	   public abstract boolean suspendRestoreClient(Client client, int suspend);
}
