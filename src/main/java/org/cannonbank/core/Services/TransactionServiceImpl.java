package org.cannonbank.core.Services;

import java.util.Collection;
import java.util.Date;

import org.cannonbank.core.Repositories.AccountRepository;
import org.cannonbank.core.Repositories.ClientRepository;
import org.cannonbank.core.Repositories.TransactionRepository;
import org.cannonbank.core.exceptions.InsuffisentAmountException;
import org.cannonbank.core.exceptions.SameAccountException;
import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountrepository;


	@Override
	public boolean transfertMoney(Transaction transaction) {
		
		
	
		Account src =  accountrepository.findById(transaction.getAccount_src().getId_Account());
		Account dst =  accountrepository.findById(transaction.getAccount_dst().getId_Account());
		try {
			dst.setBalance(transaction.getAmount()+transaction.getOldbalance_dst());
			src.setBalance(transaction.getOldbalance_src()-transaction.getAmount());
			return true;

		}
		catch(InsuffisentAmountException e | SameAccountException ee)
		{
			e.getMessage();
			ee.getMessage();
			return false;
		}
		return false;
		
	}


	@Override
	public void payment() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void withdraw() {
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
