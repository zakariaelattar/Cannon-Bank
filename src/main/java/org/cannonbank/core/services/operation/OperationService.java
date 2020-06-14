package org.cannonbank.core.services.operation;

import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Transaction;
import org.cannonbank.core.exceptions.InsufficientAmountException;
import org.cannonbank.core.third_party.exceptions.RechargeException;

public interface OperationService {

	public abstract boolean transfertMoney(String account_number_src, String account_number_dst, float amount);
	public abstract boolean deposit(String account_number, float amount);
	public abstract boolean withdraw(String account_number, float amount) throws InsufficientAmountException;
	public abstract boolean recharge(String account_number, String mobile, float amount) throws RechargeException;



}
