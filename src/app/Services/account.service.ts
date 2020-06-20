import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../pages/products/model/Product";
import {Account} from "../models/Account";
import {TokenStorageService} from "../pages/_services/token-storage.service";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})


export class AccountService {
  private BASE_URL = environment.HOST+"accounts";


  constructor(private http : HttpClient,
              private token: TokenStorageService) {

  }
   httpOptions = {
    headers: new HttpHeaders({ 'Authorization' :'Bearer ' + this.token.getToken()})
  };

  /**
   *  Get all accounts, authorized for the agent
   * */

  getAll(): Observable<Account[]> {
    return this.http.get<Account[]>(this.BASE_URL, this.httpOptions);
  }




}
