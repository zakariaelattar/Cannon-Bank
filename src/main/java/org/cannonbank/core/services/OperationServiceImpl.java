package org.cannonbank.core.services;

import java.util.Collection;
import java.util.Date;

import org.cannonbank.core.Repositories.AccountRepository;
import org.cannonbank.core.Repositories.ClientRepository;
import org.cannonbank.core.Repositories.TransactionRepository;
import org.cannonbank.core.exceptions.InsufficientAmountException;
import org.cannonbank.core.exceptions.SameAccountException;
import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {
	@Autowired
	private TransactionRepository transactionrepository;
	@Autowired
	private AccountRepository accountrepository;


	@Override
	public boolean transfertMoney(Transaction transaction) {
		
		
	
		Account src =  (Account)accountrepository.findById(transaction.getAccountByIdS().getIdAccount());
		Account dst =  (Account)accountrepository.findById(transaction.getAccountByIdR().getIdAccount());
		try {
			if(src.getIdAccount()==src.getIdAccount())
			throw new SameAccountException();
			
			if(transaction.getOldBalanceS()-transaction.getAmount()<=0)
			throw new InsufficientAmountException();
			
			
			dst.setBalance((float) (transaction.getAmount()+transaction.getOldBalanceR()));
			src.setBalance((float) (transaction.getOldBalanceS()-transaction.getAmount()));
			
			accountrepository.save(dst);
			accountrepository.save(src);
			
			transactionrepository.save(transaction);
			
				
			return true;

		}
		catch (InsufficientAmountException  | SameAccountException ee )
		{
			System.out.println(ee.getMessage());
			return false;

		}

		
	}


	@Override
	public boolean payment(float amount , Account account) {
		
		try
		{
			account.setBalance(account.getBalance()+amount);
			accountrepository.save(account);
			
		}
		catch(Exception e)
		{
			
		}
		
		return false;
		
		
	}


	@Override
	public boolean withdraw(float amount , Account account) {
		return false;
		// TODO Auto-generated method stub
		
	}



//	@Override
//	public void manageTransaction(Transaction transaction) {
//		// TODO Auto-generated method stub
//		
//	}

	

//	@Override
//	public void createTransaction(Transaction transaction) {
//	
//		transactionRepository.
//	}
//
//	@Override
//	public void updateTransaction(Transaction transaction) {
//
//		transactionRepository.save(transaction);
//	}
//
//	@Override
//	public void deleteTransaction(Transaction transaction) {
//		
//		transactionRepository.delete(transaction.getId_Transaction());
//	}
//
//	@Override
//	public Collection<Transaction> getTransactions() {
//		transactionRepository.findAll();
//		return null;
//	}

	 
	
}
