package org.cannonbank.core.services.mail;


import org.cannonbank.core.Entities.MailTempl;
import org.cannonbank.core.controllers.MailController;
import org.cannonbank.core.email.EmailConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailConfig emailConfig;

    Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Override
    public boolean sendEmail(MailTempl mailTempl, String clientMail) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());


        try
        {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom("support@cannon.com");
            mailMessage.setTo(clientMail);
            mailMessage.setSubject(mailTempl.getSubject());
            mailMessage.setText(mailTempl.getMessage());

            mailSender.send(mailMessage);

            logger.info("Email sended to :" + clientMail+ "with subject:"+mailTempl.getSubject());
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
