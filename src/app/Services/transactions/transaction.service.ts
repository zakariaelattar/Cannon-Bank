import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Client} from "../../models/Client";
import {Observable} from "rxjs";
import {Transaction} from "../../models/transaction";
import {Account} from "../../models/Account";
import {TokenStorageService} from "../../pages/_services/token-storage.service";

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private BASE_URL = "http://localhost:8001/OperationApi/";

  private TRANSFER_URL = this.BASE_URL+"transfer/";
  private RECHARGE_URL = this.BASE_URL+"recharge/";
  private DEPOSIT_URL = this.BASE_URL+"deposit/";
  private WITHDRAW_URL = this.BASE_URL+"withdraw/";


  constructor(private http : HttpClient,
              private token : TokenStorageService) { }


  httpOptions = {
    headers: new HttpHeaders({ 'Authorization' :'Bearer ' + this.token.getToken()})
  };

  /**
   *  TRANSFER CALL TO THE ENDPOINT /TRANSFER
   * */

  transfer(accountSrc : string, accountDst : string, amount : number) {

    let src = accountSrc;
    let dst = accountDst;
    return this.http.post<boolean>(this.TRANSFER_URL+src+"/"+dst+"/"+amount,null,this.httpOptions);
  }

  /**
   * RECHARGE CALL TO THE ENDPOINT /RECHARGE
   * */

  recharge(accountNumber: string, receiverPhoneNumber: string, amount: number) {
    return this.http.post<boolean>(this.RECHARGE_URL+accountNumber+"/"+receiverPhoneNumber+"/"+amount,null,this.httpOptions);
  }

  /**
   * DEPOSIT CALL TO THE ENDPOINT /DEPOSIT
   * */

  deposit(accountNumber: string, amount: number) {
    return this.http.post<boolean>(this.DEPOSIT_URL+accountNumber+"/"+amount,null,this.httpOptions);
  }

  /**
   * WITHDRAW CALL TO THE ENDPOINT /RECHARGE
   * */

  withdraw(accountNumber: string, amount: number) {
    return this.http.post<boolean>(this.WITHDRAW_URL+accountNumber+"/"+amount,null,this.httpOptions);
  }
}
