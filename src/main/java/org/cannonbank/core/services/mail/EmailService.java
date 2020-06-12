package org.cannonbank.core.services.mail;

public interface EmailService {

    public void sendSimpleMessage(String to, String subject, String text);
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
}
