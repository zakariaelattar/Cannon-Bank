package org.cannonbank.core.controllers;//package org.cannonbank.core.controllers;


import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Entities.Support;
import org.cannonbank.core.Repositories.SupportRepository;
import org.cannonbank.core.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ContactApi")
public class ContactServiceController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "send" , method = RequestMethod.POST)
    public boolean sendMessage(@RequestBody Support support)
    {
        try
        {
        contactService.sendMessage(support);
           return true;
        }
        catch (Exception e)
        {

        }

        return false;
    }


}

