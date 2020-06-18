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

To be continued ...
