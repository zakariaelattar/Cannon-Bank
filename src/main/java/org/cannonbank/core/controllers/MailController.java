package org.cannonbank.core.controllers;


import org.cannonbank.core.services.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/MailApi")
public class MailController {
    @Autowired
    public SimpleMailMessage template;

    @Autowired
    EmailService emailService;

    public void sendMail(String to, String subject){

        Map<String, String> templateArgs = null;

        /**
         *  We need to put our mail arguments into the templateArgs map
         *
         */


        String text = String.format(template.getText(), templateArgs);
        emailService.sendSimpleMessage(to, subject, text);
    }
}
