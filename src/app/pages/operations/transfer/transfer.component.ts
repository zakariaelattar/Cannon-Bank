import { Component, OnInit } from '@angular/core';
import {Client} from "../../../models/Client";
import {Transaction} from "../../../models/transaction";
import {ClientService} from "../../../Services/client.service";
import {Account} from "../../../models/Account";
import {TransactionService} from "../../../Services/transactions/transaction.service";
import {AccountService} from "../../../Services/account.service";

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.scss']
})
export class TransferComponent implements OnInit {
  receiverAccountNumber : string;
  amount : number ;
  senderAccountNumber : string;
  accounts : Account[] = [];

  transactions : Transaction[] = [];
  transaction : Transaction;

  totalSended : number = 0;
  totalReceived : number = 0;

  result : boolean;
  success : boolean;
  failure : boolean;

  constructor(private transactionService : TransactionService,
              private accountService : AccountService,
              private clientService : ClientService) { }

  ngOnInit(): void {
    /**
     *  Total sended transfers
     * */
    this.transactionService.getTotalSendedTransfers().subscribe(
      res =>{
        this.totalSended = res;
        console.log(res);
      }
    );
    /**
     *  Total received transfers
     * */
    this.transactionService.getTotalReceivedTransfers().subscribe(
      res =>{
        this.totalSended = res;
        console.log(this.transactions[0].accountRcv.accountNumber);
      }
    );
    this.clientService.getClientTransactions().subscribe(
      res =>{
        this.transactions = res["_embedded"]["transactions"];
        console.log(this.transactions[0].accountRcv.accountNumber);
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
    this.senderAccountNumber = event.target.value;
    console.log(this.senderAccountNumber);
  }
  /**
   *  Transfer method
   * */

  public transfer(accountSrc : string,
                  accountDst : string,
                  amount : number
                  ){
    this.failure = false;
    this.success = false;
    this.transactionService.transfer(accountSrc,accountDst,amount).subscribe(
      res =>{
        this.result = res;
        this.success = true;
        console.log("transfer succeed from: "+ accountSrc+",to "+accountDst+", amount: "+amount);
      },
      err => {
        this.failure = true;
        console.log(err);
      })
  }



}
