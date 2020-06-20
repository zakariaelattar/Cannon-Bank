import { Component, OnInit } from '@angular/core';
import {TransactionService} from "../../../Services/transactions/transaction.service";
import {AccountService} from "../../../Services/account.service";
import {Recharge} from "../../../models/recharge";
import {Account} from "../../../models/Account";
import {ClientService} from "../../../Services/client.service";

@Component({
  selector: 'app-recharge',
  templateUrl: './recharge.component.html',
  styleUrls: ['./recharge.component.scss']
})
export class RechargeComponent implements OnInit {

  result : boolean;
  accounts : Account[] = [];
  recharges : Recharge[] = [];

  totalSendedRecharges : number = 0;

  accountNumber : string;
  receiverPhoneNumber : string;
  amount : number;

  success : boolean;
  failure : boolean;

  constructor(private transactionService : TransactionService,
              private accountService : AccountService,
              private clientService : ClientService) { }

  ngOnInit(): void {
    /**
     *  Total sended recharges
     * */
    this.transactionService.getTotalSendedRecharges().subscribe(
      res =>{
        this.totalSendedRecharges = res;
        console.log(res);
      }
    );
    this.clientService.getClientRecharges().subscribe(
      res =>{
        this.recharges = res["_embedded"]["recharges"];
        console.log(this.recharges[0].receiverPhoneNumber);
      }
    );

    this.clientService.getClientAccounts().subscribe(
      res =>{
        this.accounts = res["_embedded"]["accounts"];
        console.log("getting all accounts of the client");
      }
    );
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
    this.success = false;
    this.failure = false;
    this.transactionService.recharge(accountNumber,receiverPhoneNumber,amount).subscribe(
      res =>{
        this.result = res;
        this.success = true;

        console.log("recharge succeed from: "+ accountNumber+",to phone number "+receiverPhoneNumber+", amount: "+amount);
      },
      err => {
        this.failure = true;
        console.log(err);
      })
  }

}
