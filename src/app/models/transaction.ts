import {Account} from "./Account";

export interface Transaction {

  idTransaction : number;
  accountByIdS : Account;
  accountByIdR : Account;
  amount : number;
  oldBalanceS : number;
  oldBalanceR : number;
  date : Date;

}
