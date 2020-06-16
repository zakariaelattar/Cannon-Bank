import { Component, OnInit } from '@angular/core';
import {TransactionService} from "../../../Services/transactions/transaction.service";
import {AccountService} from "../../../Services/account.service";
import {Recharge} from "../../../models/recharge";
import {Account} from "../../../models/Account";

@Component({
  selector: 'app-recharge',
  templateUrl: './recharge.component.html',
  styleUrls: ['./recharge.component.scss']
})
export class RechargeComponent implements OnInit {

  result : boolean;
  accounts : Account[] = [];
  recharges : Recharge[] = [];
  accountNumber : string;
  receiverPhoneNumber : string;
  amount : number;

  constructor(private transactionService : TransactionService,
              private accountService : AccountService) { }

  ngOnInit(): void {
    this.accountService.getAll().subscribe(
      res =>{
        this.accounts = res["_embedded"]["accounts"];
        console.log("getting all accounts");
      }
    )
  }
  selectChangeHandler (event: any)
  {
    this.accountNumber = event.target.value;
    console.log(this.accountNumber);
  }
  /**
   *  Recharging method
   * */

  public recharge(accountNumber : string,
                  receiverPhoneNumber : string,
                  amount : number
  ){
    this.transactionService.recharge(accountNumber,receiverPhoneNumber,amount).subscribe(
      res =>{
        this.result = res;

        console.log("recharge succeed from: "+ accountNumber+",to phone number "+receiverPhoneNumber+", amount: "+amount);
      },
      err => {
        console.log(err);
      })
  }

}
