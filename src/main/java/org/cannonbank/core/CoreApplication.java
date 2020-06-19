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
    AgencyRepository agencyRepository;
    @Autowired
    Category_AccountRepository categoryAccountRepository;
    @Autowired
    AccountStatusRepository accountStatusRepository;
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Agency agency1 = new Agency("cannon01",
                "Abdelkarim khettabi bv 1",
                "Morocco",
                "cannon01@yahoo.com",
                "05142684421",
                "0652147966554");
        Agency agency2 = new Agency("cannon02",
                "Abdelkarim khettabi bv 2",
                "Morocco",
                "cannon02@yahoo.com",
                "05142684421",
                "0652147966554");
        Agency agency3 = new Agency("cannon03",
                "Abdelkarim khettabi bv 3",
                "Morocco",
                "cannon03@yahoo.com",
                "05142684421",
                "0652147966554");



        Banker banker1 = new Banker("banker01",
                "banker01@yahoo.com",
                encoder.encode("testtest"),
                agency1,
                "Larim",
                "wail",
                "95 lot daoudiat",
                "065263244",
                new Date(),
                new Date()
                );
        Banker banker2 = new Banker("banker02",
                "banker02@yahoo.com",
                encoder.encode("testtest"),
                agency1,
                "Mohammed",
                "Bachir",
                "19 lot mohammadi",
                "06125489600",
                new Date(),
                new Date()
        );
        Banker banker3 = new Banker("banker03",
                "banker03@yahoo.com",
                encoder.encode("testtest"),
                agency2,
                "rafik",
                "naim",
                "55 lot targa",
                "0654485",
                new Date(),
                new Date()
        );

            Client client1 = new Client("mouadino",
                    "mouad@yahoo.com",
                    encoder.encode("testtest"),
                    "mouad",
                    "el attar",
                    "91 lot essakina rte casa",
                    "EE542893",
                    "065221456",
                    banker1,
                    new Date(),
                    new Date());
        Client client2 = new Client("zakimaro",
                "elattarz@yahoo.com",
                encoder.encode("test"),
                "zakaria",
                "el attar",
                "91 lot essakina rte casa",
                "EE12345",
                "0605564641",
                banker2,
                new Date(),
                new Date());
        Client client3 = new Client("karimos",
                "khad@yahoo.com",
                encoder.encode("test"),
                "khadija",
                "aitim",
                "91 lot daoudiate",
                "EJ655542",
                "0555416963",
                banker3,
                new Date(),
                new Date());
        Account account1 = new Account(0,
                categoryAccountRepository.findByName("Courant"),
                client1,
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
        Account account2 = new Account(0,
                categoryAccountRepository.findByName("Courant"),
                client1,
                "1234567892222222",
                "BIC456",
                "IBAN456",
                266584,
                new Date(),
                accountStatusRepository.findByCode(1),
                null,
                null,
                null,
                null
        );
        Account account3 = new Account(0,
                categoryAccountRepository.findByName("Courant"),
                client1,
                "1234567893333333",
                "BIC789",
                "IBAN789",
                1000,
                new Date(),
                accountStatusRepository.findByCode(1),
                null,
                null,
                null,
                null
        );

        agencyRepository.save(agency1);
        agencyRepository.save(agency2);
        agencyRepository.save(agency3);


        bankerRepository.save(banker1);
        bankerRepository.save(banker2);
        bankerRepository.save(banker3);


        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);

        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.save(account3);


    }
}
