import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Country} from "../pages/products/model/Country";
import {environment} from "../../environments/environment";
import {CategoryAccount} from "../models/category-account";
import {TokenStorageService} from "../pages/_services/token-storage.service";
import {CategoryCC} from "../models/category-cc";
import {CategoryCB} from "../models/category-cb";
import {CategoryRequest} from "../models/category-request";
import {AccountStatus} from "../models/account-status";
import {CreditCard} from "../models/credit-card";

@Injectable({
  providedIn: 'root'
})
export class HelpersService {
  private BASE_URL = environment.HOST;
  private ACCOUNT = this.BASE_URL + "accounts";

  private CATEGORY_ACCOUNT = this.BASE_URL + "categoryAccounts";
  private CATEGORY_CREDIT_CARD = this.BASE_URL + "categoryCcs";
  private CATEGORY_CHECKBOOK = this.BASE_URL + "categoryCbs";
  private CATEGORY_REQUEST = this.BASE_URL + "categoryRequests";

  private ACCOUNT_STATUS = this.BASE_URL + "accountStatuses";
//  private CLIENT_STATUS = this.BASE_URL + "clientStatuses";

  constructor(private http: HttpClient, private token : TokenStorageService) {
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Authorization' :'Bearer ' + this.token.getToken()})
  };
  /**
   *  Account category calls
   * */
  getAllCategoriesAccount()
  {
    return this.http.get<CategoryAccount>(this.CATEGORY_ACCOUNT, this.httpOptions);
  }

  getCategoryAccount(id_account : string)
  {
    return this.http.get<CategoryAccount>(this.CATEGORY_ACCOUNT+"/"+id_account, this.httpOptions);
  }
  /**
   *  Credit Cards category calls
   * */
  getAllCategoriesCreditCard()
  {
    return this.http.get<CategoryCC>(this.CATEGORY_CREDIT_CARD, this.httpOptions);
  }

  getCategoryCreditCard(id_creditCard : string)
  {
    return this.http.get<CategoryCC>(this.CATEGORY_CREDIT_CARD+"/"+id_creditCard, this.httpOptions);
  }

  /**
   *  Checkbook category calls
   * */

  getAllCategoriesCheckbook()
  {
    return this.http.get<CategoryCB>(this.CATEGORY_CHECKBOOK, this.httpOptions);
  }

  getCategoryCheckbook(id_checkbook : string)
  {
    return this.http.get<CategoryCB>(this.CATEGORY_CHECKBOOK+"/"+id_checkbook, this.httpOptions);
  }

  /**
   *  Checkbook category calls
   * */

  getAllCategoriesRequest()
  {
    return this.http.get<CategoryRequest>(this.CATEGORY_REQUEST, this.httpOptions);
  }

  getCategoryRequest(id_request : string)
  {
    return this.http.get<CategoryRequest>(this.CATEGORY_REQUEST+"/"+id_request, this.httpOptions);
  }

  findCategoryByAccount(accountId: number) {
    return this.http.get<CategoryAccount>(this.ACCOUNT+"/"+accountId+"categoryAccount", this.httpOptions);

  }
  findStateByAccount(accountId: number)  {

  }
  findCreditCardByAccount(accountId: number) {
    return this.http.get<CreditCard>(this.ACCOUNT+"/"+accountId+"creditCards", this.httpOptions);

  }

  getAccountState(accountNumber: String) {
    return this.http.get<String>("http://localhost:8001/accountStatuses/search/findStatusByAccountNumber?accountNumber="+accountNumber, this.httpOptions);
  }
  getAccountCategory(accountNumber: String) {
    return this.http.get<String>("http://localhost:8001/categoryAccounts/search/findCategoryAccountByAccountNumber?accountNumber="+accountNumber, this.httpOptions);
  }
}