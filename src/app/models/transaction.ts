import {Account} from "./Account";

export interface Transaction {

  idTransaction : number;
  accountSrc : Account;
  accountRcv : Account;
  amount : number;
  oldBalanceS : number;
  oldBalanceR : number;
  date : Date;


}
