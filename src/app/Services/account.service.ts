import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../pages/products/model/Product";
import {Account} from "../models/Account";

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private BASE_URL = "http://localhost:8001/accounts";


  constructor(private http : HttpClient) {

  }
  getAll(): Observable<Account[]> {
    return this.http.get<Account[]>(this.BASE_URL);
  }


}
