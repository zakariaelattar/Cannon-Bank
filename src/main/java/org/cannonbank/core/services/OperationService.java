package org.cannonbank.core.services;

import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Transaction;

public interface OperationService {

	public abstract boolean transfertMoney(Transaction transaction);
	public abstract boolean payment(float amount, Account account);
	public abstract boolean withdraw(float amount, Account account);
	
	
}
