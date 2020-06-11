package org.cannonbank.core.services.account;

import java.util.Collection;

import org.cannonbank.core.Entities.Account;

public interface AccountService {

//	   public abstract void createAccount(Account account);
//	   public abstract void updateAccount(Account account);
//	   public abstract void deleteAccount(Account account);
//	   public abstract Collection<Account> getAccounts();
	   public abstract boolean enableDisableAccount(Account account, int enable);
}
