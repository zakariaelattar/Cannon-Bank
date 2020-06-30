import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {TokenStorageService} from "../../pages/_services/token-storage.service";
import {Request} from "../../models/Request";
import {RequestCheckbookPayload} from "../../models/request-checkbook-payload";

@Injectable({
  providedIn: 'root'
})
export class RequestHandlerService {

  private BASE_URL = environment.HOST+"RequestApi/";


  constructor(private http : HttpClient,
              private token: TokenStorageService) {

  }
  httpOptions = {
    headers: new HttpHeaders({ 'Authorization' :'Bearer ' + this.token.getToken()})
  };

  getAllRequest()
  {
    //this.http.get<Request>(this.BASE_URL)
  }

  sendCheckbookRequest(requestCheckbookPayload : RequestCheckbookPayload) {

    console.log(this.token.getUser().username)
    return this.http.post(this.BASE_URL+this.token.getUser().username+"/RequestForCheckbook",requestCheckbookPayload, this.httpOptions);
  }
  /**sendCheckbookRequest() {
    return this.http.post(this.BASE_URL+"RequestForCheckbook", this.httpOptions);
  }
  sendCheckbookRequest() {
    return this.http.post(this.BASE_URL+"RequestForCheckbook", this.httpOptions);
  }*/
}
