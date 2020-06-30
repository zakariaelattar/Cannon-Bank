package org.cannonbank.core.services.card;

import org.cannonbank.core.Entities.*;
import org.cannonbank.core.Repositories.AccountRepository;
import org.cannonbank.core.Repositories.Category_CCRepository;
import org.cannonbank.core.Repositories.Credit_CardRepository;
import org.cannonbank.core.Repositories.RequestCardPayloadRepository;
import org.cannonbank.core.services.mail.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class CardServiceImpl implements CardService {

    @Autowired
    RequestCardPayloadRepository requestCardPayloadRepository;

    @Autowired
    Credit_CardRepository creditCardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    Category_CCRepository categoryCcRepository;

    @Autowired
    EmailService emailService;

    Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);


    @Override
    public void generateCard(Request request) {

        Client client = request.getClient();
        String cardHolderFirstName = client.getFname();
        String cardHolderLastName = client.getLname();

        RequestCardPayload requestCardPayload = requestCardPayloadRepository.findById(request.getRequestPayload().getId());

        String accountNumber = requestCardPayload.getAccountNumber();
        String categoryCcName = requestCardPayload.getCategoryCc();

        Account account = accountRepository.findByAccountNumber(accountNumber);
        CategoryCc categoryCc = categoryCcRepository.findByName(categoryCcName);

        logger.info("system is trying to generate credit card for client "+cardHolderFirstName+"...");

        String cardNumber = "";
        String cvv = "";
        Date expireDate;


        /**
         *  Generate card number 16 digits
         * */
        for(int i = 0; i<16; i++)
        {
             cardNumber += String.valueOf((int)(Math.random() * 10));
        }
        logger.info("generated card number :" +cardNumber);

        /**
         *  Generate cvv 16 digits
         * */
        for(int j = 0; j < 3; j++)
        {
            cvv += String.valueOf((int)(Math.random() * 10));
        }
        logger.info("generated cvv :" +cvv);

        /**
         *  Generate expire date
         * */

        expireDate = new Date();
        logger.info("generated cvv :" +cvv);

        /**
         *  Generate expire date
         * */

        CreditCard creditCard = new CreditCard(account,
                cardHolderFirstName,cardHolderLastName,
                categoryCc,cardNumber,cvv,expireDate);

        creditCardRepository.save(creditCard);
        logger.info("generated card sucessfully: "+ creditCard);

        MailTempl mailTempl = new MailTempl("your card is available in your agency, please consult it.\n","Credit card available");
        emailService.sendEmail(mailTempl,client.getEmail());





    }
}
