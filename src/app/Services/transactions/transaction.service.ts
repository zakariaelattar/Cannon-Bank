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
   *  Transfer method
   * */

  transfer(accountSrc : string,
           accountDst : string,
           amount : number): Observable<boolean> {

    let src = accountSrc;
    let dst = accountDst;
    let url = this.TRANSFER_URL+src+"/"+dst+"/"+amount;

    return this.http.post<boolean>(url,null,this.httpOptions);
  }
}
