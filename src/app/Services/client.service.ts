import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Account} from "../models/Account";
import {Product} from "../pages/products/model/Product";
import {Client} from "../models/Client";

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private BASE_URL = "http://localhost:8001/clients/";


  constructor(private http: HttpClient) {
  }

  findAll(): Observable<Client[]> {
    return this.http.get<Client[]>(this.BASE_URL);
  }

  /**
   * Add a client
   */
  postClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.BASE_URL, client);
  }

  /**
   *  Get client by id
   */
  findById(id : number): Observable<Client> {
    return this.http.get<Client>(this.BASE_URL);
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


  findTransactionByClient(client: Client) {
    return this.http.get<Account>(this.BASE_URL+client.id_client+"/accounts/"+client.id_client);
  }
}
