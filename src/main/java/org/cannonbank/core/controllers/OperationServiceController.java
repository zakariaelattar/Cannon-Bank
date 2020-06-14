package org.cannonbank.core.controllers;

import org.cannonbank.core.Entities.Transaction;
import org.cannonbank.core.services.account.AccountServiceImpl;
import org.cannonbank.core.services.operation.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/OperationApi")
public class OperationServiceController {
	@Autowired
	   OperationService operationService;

	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	/**
	 * Endpoint that make a transfer of money from sender account to a receiver account
	 *
	 * */
	   @RequestMapping(value = "/transfer/{sender}/{receiver}/{amount}" , method = RequestMethod.POST)
	   public boolean transfer(@PathVariable float amount, @PathVariable String receiver, @PathVariable String sender ) {
		   logger.info("trying to transfer the sum : "+amount+ "from account :"+sender+ "to account: "+receiver  +"...");
	       try {

	    	   operationService.transfertMoney(sender, receiver, amount);
	    		return true;		
	       }
	       catch(Exception e)
	       {
	    	    e.printStackTrace();
	    	    return false;
	       }
	       finally 
	       {   
	    	    return false;
	       }
	       
	       }

	/**
	 * Endpoint that make a withdraw of money from an account by client concerned
	 *
	 * */
	@RequestMapping(value = "/withdraw/{account_number}/{amount}" , method = RequestMethod.POST)
	public boolean withdraw( @PathVariable String account_number,@PathVariable float amount ) {
		logger.info("trying to withdraw the sum: "+amount + " from the account :" + account_number +"..." );
		try {

			operationService.withdraw(account_number,amount);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			return false;
		}

	}

	/**
	 * Endpoint that make a deposit of money in an account by client concerned
	 *
	 * */
	@RequestMapping(value = "/deposit/{account_number}/{amount}" , method = RequestMethod.POST)
	public boolean deposit( @PathVariable String account_number,@PathVariable float amount ) {
		logger.info("trying to deposit the sum: "+amount + " to the account :" + account_number +"..." );
		try {

			operationService.deposit(account_number,amount);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			return false;
		}

	}

	/**
	 * Endpoint that allow recharging a phone number from an active account
	 *
	 * */

	@RequestMapping(value = "/recharge/{account_number}/{phone_number}/{amount}" , method = RequestMethod.POST)
	public void recharge (@PathVariable String account_number, @PathVariable String phone_number, @PathVariable float amount )
	{
		logger.info("trying to send "+amount + " to the mobile number :" + phone_number +" from account"+account_number+" ..." );

		try{
			operationService.recharge(account_number, phone_number, amount);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

