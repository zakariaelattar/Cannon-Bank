package org.cannonbank.core.services.operation;

import org.cannonbank.core.Entities.CategoryAccount;
import org.cannonbank.core.Repositories.AccountRepository;
import org.cannonbank.core.Repositories.TransactionRepository;
import org.cannonbank.core.exceptions.InsufficientAmountException;
import org.cannonbank.core.exceptions.SameAccountException;
import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	 TransactionRepository transactionRepository;
	@Autowired
	 AccountRepository accountRepository;

	Logger logger = LoggerFactory.getLogger(OperationServiceImpl.class);

	@Override
	public boolean transfertMoney(float amount, int src, int dst) {

		Account sender;
		Account receiver;
		Transaction transaction;

		try {
			sender =  accountRepository.findByIdAccount(src);  // sender account from id
			receiver = accountRepository.findByIdAccount(dst);  // receiver account from id

			if(src == dst)
				throw new SameAccountException();

			if(sender.getBalance() - amount <= 0)
				throw new InsufficientAmountException();

			transaction = new Transaction(sender, receiver, amount, sender.getBalance(), receiver.getBalance(),new Date());

			receiver.setBalance(sender.getBalance() + amount);
			sender.setBalance(sender.getBalance() - amount);



			accountRepository.save(sender);
			accountRepository.save(receiver);
			transactionRepository.save(transaction);


			logger.info("account: "+sender.getIdAccount()+ "have sent: "+amount +" to the account:"+receiver.getIdAccount());

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
			accountRepository.save(account);
			
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
