import { Component, OnInit } from '@angular/core';
import {ClientService} from "../../Services/client.service";
import {AccountService} from "../../Services/account.service";
import {Observable} from "rxjs";
import {Account} from "../../models/Account";
import {Client} from "../../models/Client";
import {AuthInterceptor} from "../_helpers/auth.interceptor";
import {CategoryAccount} from "../../models/category-account";
import {HelpersService} from "../../Services/helpers.service";
import {AccountStatus} from "../../models/account-status";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  accounts : Account[] = [];
  account : Account;

  accountCategories : CategoryAccount[] = [];
  accountStatuses : AccountStatus[] = [];


  constructor(private clientService : ClientService,
              private accountService : AccountService,
              private helpersService : HelpersService
              ) { }

  ngOnInit(): void {
  this.getAllClientAccounts();
  }

  /**
  *  Get all accounts
  * */
  public getAllClientAccounts(){
    console.log("try getting all accounts of the user ");
     this.clientService.getClientAccounts().subscribe(
      res =>{
            this.accounts = res['_embedded']['accounts'];
            console.log("getting all accounts of the user ");

        // get account category
        this.helpersService.getAllCategoriesAccount().subscribe(
          res =>{
            this.accountCategories = res['_embedded']['categoryAccounts'];
            console.log("getting all accounts categ ");

          },
          err => {
            console.log(err);
          })
        // get account status
        this.helpersService.getAllAccountStatuses().subscribe(
          res =>{
            this.accountStatuses = res['_embedded']['accountStatuses'];
            console.log("getting all accounts statuses ");

          },
          err => {
            console.log(err);
          })

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
