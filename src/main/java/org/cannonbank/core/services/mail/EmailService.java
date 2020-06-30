package org.cannonbank.core.services.mail;

import org.cannonbank.core.Entities.MailTempl;

public interface EmailService {

public abstract boolean  sendEmail(MailTempl mailTempl, String clientMail);
}
