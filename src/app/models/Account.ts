import {Client} from "./Client";
import {CategoryAccount} from "./category-account";
import {AccountStatus} from "./account-status";
import {Checkbook} from "./Checkbook";
import {CreditCard} from "./credit-card";
import {Transaction} from "./transaction";

export interface Account
{

  idAccount : number;
  categoryAccount : CategoryAccount;
  client : Client;
  accountNumber : string;
  bic : string;
  iban : string;
  balance : number;
  creationDate : Date;
  status : AccountStatus;
  creditCards : Array<CreditCard>;
  checkbook : Array<Checkbook>;
  transactionsForIdS : Array<Transaction>;
  transactionsForIdR : Array<Transaction>;

}
