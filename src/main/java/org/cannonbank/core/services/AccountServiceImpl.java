package org.cannonbank.core.services;

import java.util.Collection;
import org.cannonbank.core.Repositories.AccountRepository;
import org.cannonbank.core.Entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public boolean enableDisableAccount(Account account , int enable) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public void createAccount(Account account) {
//	
//		accountRepository.
//	}
//
//	@Override
//	public void updateAccount(Account account) {
//
//		accountRepository.save(account);
//	}
//
//	@Override
//	public void deleteAccount(Account account) {
//		
//		accountRepository.delete(account.getId_Account());
//	}
//
//	@Override
//	public Collection<Account> getAccounts() {
//		accountRepository.findAll();
//		return null;
//	}

	 
	
}
