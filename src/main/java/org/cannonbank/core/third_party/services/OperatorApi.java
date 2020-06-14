package org.cannonbank.core.third_party.services;


import org.cannonbank.core.third_party.exceptions.RechargeException;

public interface OperatorApi {

    public abstract boolean sendRecharge(String account_number,String phone_number, float amount) throws RechargeException;
}
