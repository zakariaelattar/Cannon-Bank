package org.cannonbank.core.third_party.services;

import org.cannonbank.core.third_party.exceptions.RechargeException;
import org.springframework.stereotype.Service;

@Service
public class OperatorApiImpl implements OperatorApi {



    public boolean sendRecharge(String account_number, String phone_number, float amount) throws RechargeException {


        /**
         *  send to service provider
         * */
        return false;
    }
}
