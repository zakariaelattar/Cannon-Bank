package org.cannonbank.core.services.account;

import org.cannonbank.core.Entities.AccountStatus;
import org.cannonbank.core.Repositories.AccountRepository;
import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Repositories.AccountStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cannonbank.core.exceptions.AccountStatException;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountStatusRepository accountStatusRepository;

	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


	@Override
	public boolean enableDisableAccount(String accountNumber , int enable) {

		Account account;

		try{
			account = accountRepository.findByAccountNumber(accountNumber);
			/**
			 * get the status object using a code (0 or 1)
			 * */

			AccountStatus account_status = account.getStatus();

			logger.info("passed query statut is: "+ enable);
		logger.info("account statut is: "+ account_status);

			if (account_status.getCode() == enable)
			{
				if(enable == 0)
					throw new AccountStatException("Account:"+accountNumber+" is already suspended");
				if(enable == 1)
					throw new AccountStatException("Account:"+accountNumber+"  already activated");
			}
			/**
			 * Changing the status from 0 -> 1 or 1 -> 0
			 * */
			AccountStatus new_stat = accountStatusRepository.findByCode(enable);
			account.setStatus(new_stat);

			accountRepository.save(account);


			logger.info("The account :"+account.getAccountNumber()+"has been "+new_stat.getName()+"d by the agent:"+account.getClient().getBanker().getFname());
		}
		catch ( AccountStatException e)
		{
			e.getMessage();
		}
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
