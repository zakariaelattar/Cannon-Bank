package org.cannonbank.core.services;//package org.cannonbank.core.services;


import org.cannonbank.core.Entities.Support;

import org.cannonbank.core.Repositories.SupportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    Logger logger = LoggerFactory.getLogger(ContactService.class);
    @Autowired
    SupportRepository supportRepository;



    @Override
    public boolean sendMessage(Support support) {

        Support support1 = new Support(support.getClient(),
                support.getSubject(),
                support.getMessage(),
                support.getReplyMethod());

        try
        {
        supportRepository.save(support);
        logger.info("client :"+support.getClient().getLname()+" have send a message to the support");
        return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean replyMessage(Support support) {
        return false;
    }
}
