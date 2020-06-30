import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Support} from "../../models/support";
import {TokenStorageService} from "../../pages/_services/token-storage.service";
import {Observable} from "rxjs";
import {Account} from "../../models/Account";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http : HttpClient,
              private token : TokenStorageService) { }
  httpOptions = {
    headers: new HttpHeaders({ 'Authorization' :'Bearer ' + this.token.getToken()})
  };

  public sendMessage(support : Support): Observable<boolean>
  {
    return this.http.post<boolean>("http://localhost/8001/ContactApi/send",support,this.httpOptions);
  }
}
