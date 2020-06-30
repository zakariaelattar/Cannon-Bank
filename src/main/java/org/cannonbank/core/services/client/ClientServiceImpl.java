package org.cannonbank.core.services.client;

import org.cannonbank.core.Repositories.ClientRepository;
import org.cannonbank.core.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl  implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	


	@Override
	public boolean suspendRestoreClient(Client client, int suspend) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
//	@Override
//	public void createClient(Client client) {
//	
//		clientRepository.save(client);
//	}
//
//	@Override
//	public void updateClient(long id, Client client) {
//
//		clientRepository.delete(id);
//		client.setId_client(id);
//		clientRepository.save(client);
//	}
//
//	@Override
//	public void deleteClient(long id) {
//		
//		clientRepository.delete(id);
//	}
//
//	@Override
//	public Collection<Client> getClients() {
//		clientRepository.findAll();
//		return null;
//	}



	 
	
}
