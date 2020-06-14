package org.cannonbank.core.services.account;

import java.util.Collection;

import org.cannonbank.core.Entities.Account;

public interface AccountService {


	   public abstract boolean enableDisableAccount(String accountNumber, int enable);
}
