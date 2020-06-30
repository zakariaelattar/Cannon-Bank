package org.cannonbank.core.controllers;


import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Entities.MailTempl;
import org.cannonbank.core.Repositories.ClientRepository;
import org.cannonbank.core.email.EmailConfig;
import org.cannonbank.core.services.mail.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/MailApi")
public class MailController {


    @Autowired
    EmailService emailService;

    @Autowired
    ClientRepository clientRepository;


    Logger logger = LoggerFactory.getLogger(MailController.class);

    @RequestMapping(value = "send/{username}", method = RequestMethod.POST)
    public void sendMail(@RequestBody MailTempl mailTempl,
                         @PathVariable String username,
                         BindingResult bindingResult) throws ValidationException {


        Client client = clientRepository.findByUsername(username);
        String client_email = client.getEmail();

        logger.info("sending mail to "+ client_email);
        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback is not valid");
        }



    }
}
