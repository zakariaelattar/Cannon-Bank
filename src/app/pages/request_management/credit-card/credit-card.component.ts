import { Component, OnInit } from '@angular/core';
import {TransactionService} from "../../../Services/transactions/transaction.service";
import {AccountService} from "../../../Services/account.service";
import {ClientService} from "../../../Services/client.service";
import {Account} from "../../../models/Account";
import {RequestCheckbookPayload} from "../../../models/request-checkbook-payload";
import {RequestHandlerService} from "../../../Services/request/request-handler.service";
import {TokenStorageService} from "../../_services/token-storage.service";
import {RequestCardPayload} from "../../../models/request-card-payload";

@Component({
  selector: 'app-credit-card',
  templateUrl: './credit-card.component.html',
  styleUrls: ['./credit-card.component.scss']
})
export class CreditCardComponent implements OnInit {

  accountNumber : String;
  accounts : Account[] = [];

  success : boolean;
  failure : boolean;
  requestCardPayload: RequestCardPayload = {
    "accountNumber" :"",
    "categoryCcName" :""
  };

  constructor(
              private accountService : AccountService,
              private clientService : ClientService,
              private requestHandlerService : RequestHandlerService,
              private tokenStorageService : TokenStorageService) { }


  selectChangeHandlerAccountNumber (event: any)
  {
    this.requestCardPayload.accountNumber = event.target.value;
    console.log(this.requestCardPayload.accountNumber);
  }
  selectChangeHandlerCategoryCardName (event: any)
  {
    this.requestCardPayload.categoryCcName = event.target.value;
    console.log(this.requestCardPayload.categoryCcName);
  }


  ngOnInit(): void {
    this.clientService.getClientAccounts().subscribe(
      res =>{
        this.accounts = res["_embedded"]["accounts"];
        console.log("getting all accounts of the client");
      }
    );
  }

  sendCardRequest(requestCardPayload : RequestCardPayload) {
    this.failure = false;
    this.success = false;
    this.requestHandlerService.sendCardRequest(requestCardPayload).subscribe(
      res => {

        this.success = true;
      },
      err => {
        this.failure = true;
      })

  }

}
