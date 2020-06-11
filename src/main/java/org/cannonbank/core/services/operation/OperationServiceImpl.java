package org.cannonbank.core.services.operation;

import org.cannonbank.core.Entities.CategoryAccount;
import org.cannonbank.core.Repositories.AccountRepository;
import org.cannonbank.core.Repositories.TransactionRepository;
import org.cannonbank.core.exceptions.AccountStatException;
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
	public boolean transfertMoney(String account_number_src, String account_number_dst,float amount) {

		Account sender;
		Account receiver;
		Transaction transaction;

		try {

			sender =  accountRepository.findByAccountNumber(account_number_src);  // sender account from id
			receiver = accountRepository.findByAccountNumber(account_number_dst);  // receiver account from id

			if(account_number_dst == account_number_src)
				throw new SameAccountException();

			if(sender.getBalance() - amount <= 0)
				throw new InsufficientAmountException();

			receiver.setBalance(receiver.getBalance() + amount);
			sender.setBalance(sender.getBalance() - amount);


			/**
			 * Creation of a new transaction that will be added to database
			 * */

			transaction = new Transaction(0,sender, receiver, amount, sender.getBalance(), receiver.getBalance(),new Date());

			accountRepository.save(sender);
			accountRepository.save(receiver);
			transactionRepository.save(transaction);


			logger.info("account: "+sender.getIdAccount()+ "have sent: "+amount +" to the account:"+receiver.getIdAccount());

			return true;

		}
		catch (   InsufficientAmountException | SameAccountException ee )
		{
			System.out.println(ee.getMessage());
			return false;

		}
	}



	@Override
	public boolean deposit(String account_number, float amount) {

		Account account;

		try
		{
			account = accountRepository.findByAccountNumber(account_number);

			/**
			 * Check if the account is already active
			 */

			if (account.getStatus().getCode() == 0)
				throw new AccountStatException("The account :"+ account_number + "is desactivated. For more information, please contact your banker");

			float old_balance = account.getBalance();
			account.setBalance(old_balance + amount);
			accountRepository.save(account);
			logger.info("The account: "+account_number+ "has been alimented with: "+ amount +"successfully, by the banker:"+ account.getClient().getBanker().getFname());
			return true;
		}
		catch (AccountStatException e)
		{

		}
		return false;
	}

	@Override
	public boolean withdraw(String account_number, float amount) {
		Account account;

		try
		{
			account = accountRepository.findByAccountNumber(account_number);

			/**
			 * Check if the account is already active
			 */

			if (account.getStatus().getCode() == 0)
				throw new AccountStatException("The account :"+ account_number + "is desactivated. For more information, please contact your banker");

			/**
			 * Check if the account have already more than what the client require
			 */

			if (account.getBalance() < amount)
				throw new InsufficientAmountException();
			/**
			 * If all is good, than withdraw
			 */
			float old_balance = account.getBalance();
			account.setBalance(old_balance - amount);
			accountRepository.save(account);
			logger.info("The client: "+account.getClient().getFname()+" withdrew the sum : "+ amount +" from the account: "+account_number+" successfully.");

			return true;
		}
		catch (AccountStatException  |InsufficientAmountException e)
		{

		}
		return false;
	}


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
