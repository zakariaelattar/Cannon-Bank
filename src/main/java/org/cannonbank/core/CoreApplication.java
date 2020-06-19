package org.cannonbank.core;

import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Agency;
import org.cannonbank.core.Entities.Banker;
import org.cannonbank.core.Entities.Client;
import org.cannonbank.core.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication

public class CoreApplication implements CommandLineRunner {
        @Autowired
        BankerRepository bankerRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    Category_AccountRepository categoryAccountRepository;
    @Autowired
    AccountStatusRepository accountStatusRepository;
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Client client = clientRepository.findByCni("EE524156");
        Account account = new Account(0,
                categoryAccountRepository.findByName("Courant"),
                client,
                "1234567899876543",
                "BIC123",
                "IBAN123",
                100000,
                new Date(),
                accountStatusRepository.findByCode(1),
                null,
                null,
                null,
                null
                );
        accountRepository.save(account);


    }
}
