import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {TokenStorageService} from "../../pages/_services/token-storage.service";
import {Request} from "../../models/Request";
import {RequestCheckbookPayload} from "../../models/request-checkbook-payload";
import {RequestCardPayload} from "../../models/request-card-payload";

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

  /**
   *  Request for a checkbook via api
   * */
  sendCheckbookRequest(requestCheckbookPayload : RequestCheckbookPayload) {

    console.log(this.token.getUser().username)
    return this.http.post(this.BASE_URL+this.token.getUser().username+"/RequestForCheckbook",requestCheckbookPayload, this.httpOptions);
  }

  /**
   *  Request for a card via api
   * */
  sendCardRequest(requestCardPayload: RequestCardPayload) {
    console.log(requestCardPayload.categoryCcName);
    return this.http.post(this.BASE_URL+this.token.getUser().username+"/RequestForCard",requestCardPayload, this.httpOptions);


  }
}
