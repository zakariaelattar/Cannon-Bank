import { Component, OnInit } from '@angular/core';
import {ClientService} from "../../Services/client.service";
import {AccountService} from "../../Services/account.service";
import {Observable} from "rxjs";
import {Account} from "../../models/Account";
import {Client} from "../../models/Client";
import {AuthInterceptor} from "../_helpers/auth.interceptor";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  accounts : Account[] = [];
  account : Account;


  constructor(private clientService : ClientService,
              private accountService : AccountService,

              ) { }

  ngOnInit(): void {

  }

  /**
  *  Get all accounts
  * */
  public getAll(){
    this.accountService.getAll().subscribe(
      res =>{
        this.accounts = res['_embedded']['accounts'];
        console.log("getting all accounts: " +this.accounts);
      },
      err => {
        console.log(err);
      })
  }

  /**
   *  Get all accounts of a specific client
   * */
  public getClientAccounts(client : Client){
    this.clientService.findAccountsByClient(client).subscribe(
      res =>{
        this.accounts = res;
        console.log("getting all accounts of the client");
      },
      err => {
        console.log(err);
      })
  }




}
