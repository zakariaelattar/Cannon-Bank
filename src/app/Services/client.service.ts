import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Account} from "../models/Account";
import {Product} from "../pages/products/model/Product";
import {Client} from "../models/Client";
import {environment} from "../../environments/environment";
import {TokenStorageService} from "../pages/_services/token-storage.service";
import {Recharge} from "../models/recharge";

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private BASE_URL = environment.HOST+"clients/";



  constructor(private http: HttpClient,
  private token: TokenStorageService) {
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Authorization' :'Bearer ' + this.token.getToken()})
  };

  findAll(): Observable<Client[]> {
    return this.http.get<Client[]>(this.BASE_URL, this.httpOptions);
  }

  /**
   * Add a client
   */
  postClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.BASE_URL, client, this.httpOptions);
  }

  /**
   *  Get client by id
   */
  findById(id : number): Observable<Client> {
    return this.http.get<Client>(this.BASE_URL, this.httpOptions);
  }

  /**
   *  Get client accounts
   */

  findAccountsByClient(client : Client): Observable<Account[]> {
    return this.http.get<Account[]>(this.BASE_URL+client.id_client+"/accounts");
  }
  /**
   *  Get specific client accounts
   */

  findAccountByClient(client : Client , account : Account): Observable<Account> {
    return this.http.get<Account>(this.BASE_URL+client.id_client+"/accounts/"+account.idAccount);
  }

  /**
   *  Get all transactions of a specific client
   * */
  getClientTransactions() {
    return this
      .http
      .get<Account>("http://localhost:8001/" +
        "transactions/" +
        "search/" +
        "findByAccountSrc_Client_UsernameOrAccountRcv_Client_Username?" +
        "username1="+this.token.getUser().username+
        "&username2="+this.token.getUser().username,
        this.httpOptions);
  }
  /**
   *  Get all accounts of a specific client
   * */

  getClientAccounts() : Observable<Account[]>{

    return this.http.get<Account[]>(this.BASE_URL+this.token.getUser().id+"/accounts", this.httpOptions);
  }
  /**
   *  Get all accounts of a specific client
   * */
  getClientRecharges() : Observable<Recharge[]>{

    return this.http.get<Recharge[]>("http://localhost:8001/recharges/search/findByAccount_Client_Username?username="+this.token.getUser().username, this.httpOptions);
  }
}
