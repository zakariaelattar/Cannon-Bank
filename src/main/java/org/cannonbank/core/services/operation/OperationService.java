package org.cannonbank.core.services.operation;

import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Transaction;

public interface OperationService {

	public abstract boolean transfertMoney(String account_number_src, String account_number_dst, float amount);
	//public abstract boolean payment(float amount, int account_id);
	public abstract boolean deposit(String account_number, float amount);
	public abstract boolean withdraw(String account_number, float amount);


}
