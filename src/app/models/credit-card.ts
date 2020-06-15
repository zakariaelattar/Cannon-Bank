import {Account} from "./Account";
import {CategoryCC} from "./category-cc";

export interface CreditCard {

  idCard : number;
   account : Account;
   categoryCc : CategoryCC;
   cardNumber : number;
   cardHolder : string;
   cvv : number;
   expiresDate : Date;
   balance : number;

}
