import {Account} from "../../../models/Account";

export interface Transfer
{

   id_transaction : number;
  account_src : Account;
    account_dst : Account;
    amount : number;
    oldbalance_src : number;
    oldbalance_dst : number;

    date ; Date

 //   type : Category_Transaction;

}

