package org.cannonbank.core.services;//package org.cannonbank.core.services;


import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Entities.Support;

public interface ContactService{

    public abstract boolean sendMessage(Support support);
    public abstract boolean replyMessage(Support support);


}
