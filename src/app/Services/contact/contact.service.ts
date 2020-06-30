import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http : HttpClient) { }

  public sendMessage() {
    this.http.post("http://localhost/8001/",null,null);
  }
}
