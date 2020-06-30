import { Component, OnInit } from '@angular/core';
import {RequestHandlerService} from "../../../Services/request/request-handler.service";
import {RequestCheckbookPayload} from "../../../models/request-checkbook-payload";
import {TokenStorageService} from "../../_services/token-storage.service";

@Component({
  selector: 'app-checkbook',
  templateUrl: './checkbook.component.html',
  styleUrls: ['./checkbook.component.scss']
})
export class CheckbookComponent implements OnInit {

  success : boolean;
  failure : boolean;

  quantity : number;
  paper_number : number;

  requestCheckbookPayload :  RequestCheckbookPayload = {"quantity" : 0,"paper_number" : 0};





  constructor(private requestHandlerService : RequestHandlerService,
              private tokenStorageService : TokenStorageService) { }

  ngOnInit(): void {
  }
  selectChangeHandler1 (event: any)
  {
    this.paper_number = event.target.value;
    this.requestCheckbookPayload.paper_number = this.paper_number;

    console.log(this.requestCheckbookPayload.paper_number);
  }
  selectChangeHandler2 (event: any)
  {
    this.requestCheckbookPayload.quantity = event.target.value;

    console.log(this.requestCheckbookPayload.quantity);
  }

  sendCheckbookRequest(requestCheckbookPayload : RequestCheckbookPayload) {
    this.failure = false;
    this.success = false;
    this.requestHandlerService.sendCheckbookRequest(requestCheckbookPayload).subscribe(
      res => {

        this.success = true;
      },
      err => {
        this.failure = true;
      }
    )

  }
}
