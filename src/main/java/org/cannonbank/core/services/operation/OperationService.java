package org.cannonbank.core.services.operation;

import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Transaction;

public interface OperationService {

	public abstract boolean transfertMoney( float amount, int src, int dst);
	public abstract boolean payment(float amount, Account account);
	public abstract boolean withdraw(float amount, Account account);


}
