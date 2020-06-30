# Cannon bank

## Documentation
Api specification available on : /swagger-ui.html

![Documentation](https://github.com/zakariaelattar/Cannon-Bank/tree/new/documentation-swagger.jpg?raw=true)

## Introduction
   Cannon bank is an application based on the latest technologies, and which allows customers to be brought closer to their
 bank thanks to a multitude of services (online bill payment, check request, transfer ...).
 
the project is divided into 4 parts:
* 2 are angular client 9 (client and banker platform)
* 1 under SpringMVC using the Thymeleaf template, and the backend for API calls.
Calls are made with specific endpoint, to see in the swagger documentation of the project
 
## Technologies
The project work under:
 * Java 1.8
 * Spring boot 2.2.6
 * Angular 9
 * Docker
 * Lombok
 * Slf4j
 * Swagger
 
## Pre-requirement

### Mysql tables:
After running the project for the first time, tables will be created empty, so we need to run those lines:

#### Role table
````````
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_AGENT');
````````
#### Account category (categorie de compte)
````````
INSERT INTO category_account(name,description) VALUES('Courant','Compte courant');
INSERT INTO category_account(name,description) VALUES('Epargne','Compte epargne');
````````
#### Request category (categorie de demande)
````````
INSERT INTO category_request(name,description) VALUES('card','for 4 days business');
INSERT INTO category_request(name,description) VALUES('checkbook','for 7 days business');
INSERT INTO category_request(name,description) VALUES('document','Immediatly');

### Account status
INSERT INTO account_status(code,name) VALUES(0,'Desactive');
INSERT INTO account_status(code,name) VALUES(1,'Activate');
````````
### Credit card category
````
INSERT INTO category_cc (description, name) VALUES (NULL, 'Visa', 'VISA');
INSERT INTO category_cc (description, name) VALUES (NULL, 'Master card', 'MASTER CARD')
````

### request reply methods
``````
INSERT INTO reply_method (name`) VALUES (SMS);
INSERT INTO reply_method (name`) VALUES (EMAIL);
``````

### test values
````````
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
````````
## Installation
#### Using docker
 
 To run every thing, use:
````````
$ docker-compose -f docker-compose.yml up -d
````````

 To shutdown, use:
 ````````
 $ docker-compose docker-compose.yml down 
 ````````
 
## Global see of the project
````````
└───org
    └───cannonbank
        └───core
            ├───Business
            ├───controllers
            ├───email
            ├───Entities
            ├───exceptions
            ├───Repositories
            ├───Security
            │   ├───controllers
            │   ├───models
            │   ├───payload
            │   │   ├───request
            │   │   └───response
            │   ├───repository
            │   └───security
            │       ├───jwt
            │       └───services
            ├───services
            │   ├───account
            │   ├───client
            │   ├───mail
            │   ├───operation
            │   └───request
            └───swagger
````````

## Basics functionalities
### Request for a specific object:
You can request for :
* Checkbook with some limits
*  card 
* documents and attestations

by passing an arguments from front client into a RequestPayload object

## Features
   Here are the most attractive features: 
   

### Generation of document
That feature allow to client, to have his documents such as receipts, invoices .. in the form of PDF file, and also for
the banker, he can download an EXCEL and CSV file for data.

The library used for that is:

### Mail
The application can send an mail to a client for many reasons:
most of them are for confirmation, and success message

* confirm a transaction
* confirm a recharge
* success of transaction

The library used for that is: spring-boot-starter-mail

## Errors and solutions:

#### Error
 The most recurrent error was about getting data from resource A related to resource B, this error block us from the case:
 in client angular app, we cant list the client accounts, but in the account resource we can get the proper client.
 ````````
ERROR org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/].[dispatcherServlet] [http-nio-8001-exec-1] Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Handler dispatch failed; nested exception is java.lang.StackOverflowError] with root cause
java.lang.StackOverflowError: null
	at java.base/sun.net.www.protocol.file.Handler.parseURL(Handler.java:67)
	at java.base/java.net.URL.<init>(URL.java:686)
	at java.base/java.net.URL.<init>(URL.java:553)
	at java.base/jdk.internal.loader.URLClassPath$FileLoader.getResource(URLClassPath.java:1222)
	at java.base/jdk.internal.loader.URLClassPath.getResource(URLClassPath.java:317)
	at java.base/jdk.internal.loader.BuiltinClassLoader.findClassOnClassPathOrNull(BuiltinClassLoader.java:718)
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:644)
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:602)
````````
##### Solution
Replace Lombok @Data with @Getter and @Setter
