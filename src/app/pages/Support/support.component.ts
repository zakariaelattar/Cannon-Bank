import {Component, OnInit} from "@angular/core";
import {ToastrService} from 'ngx-toastr';
import {ContactService} from "../../Services/contact/contact.service";
import {Contact} from "../../models/contact";
import {Support} from "../../models/support";
import {TokenStorageService} from "../_services/token-storage.service";

@Component({
  selector: "app-notifications",
  templateUrl: "support.component.html"
})
export class SupportComponent implements OnInit {
  staticAlertClosed = false;
  staticAlertClosed1 = false;
  staticAlertClosed2 = false;
  staticAlertClosed3 = false;
  staticAlertClosed4 = false;
  staticAlertClosed5 = false;
  staticAlertClosed6 = false;
  staticAlertClosed7 = false;


subject : String ="";
message : String;
replyMethod : String;

support : Support = {

  client:null,
  subject:"t",
  message:"",
  replyMethod:""
};
  private success: boolean;
  private failure: boolean;

  constructor(private toastr: ToastrService,
              private contactService : ContactService,
              private token : TokenStorageService) {
  }

  showNotification(from, align) {

    const color = Math.floor((Math.random() * 5) + 1);

    switch (color) {
      case 1:
        this.toastr.info('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Welcome to <b>Black Dashboard Angular</b> - a beautiful freebie for every web developer.', '', {
          disableTimeOut: true,
          closeButton: true,
          enableHtml: true,
          toastClass: "alert alert-info alert-with-icon",
          positionClass: 'toast-' + from + '-' + align
        });
        break;
      case 2:
        this.toastr.success('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Welcome to <b>Black Dashboard Angular</b> - a beautiful freebie for every web developer.', '', {
          disableTimeOut: true,
          closeButton: true,
          enableHtml: true,
          toastClass: "alert alert-success alert-with-icon",
          positionClass: 'toast-' + from + '-' + align
        });
        break;
      case 3:
        this.toastr.warning('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Welcome to <b>Black Dashboard Angular</b> - a beautiful freebie for every web developer.', '', {
          disableTimeOut: true,
          closeButton: true,
          enableHtml: true,
          toastClass: "alert alert-warning alert-with-icon",
          positionClass: 'toast-' + from + '-' + align
        });
        break;
      case 4:
        this.toastr.error('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Welcome to <b>Black Dashboard Angular</b> - a beautiful freebie for every web developer.', '', {
          disableTimeOut: true,
          enableHtml: true,
          closeButton: true,
          toastClass: "alert alert-danger alert-with-icon",
          positionClass: 'toast-' + from + '-' + align
        });
        break;
      case 5:
        this.toastr.show('<span class="tim-icons icon-bell-55" [data-notify]="icon"></span> Welcome to <b>Black Dashboard Angular</b> - a beautiful freebie for every web developer.', '', {
          disableTimeOut: true,
          closeButton: true,
          enableHtml: true,
          toastClass: "alert alert-primary alert-with-icon",
          positionClass: 'toast-' + from + '-' + align
        });
        break;
      default:
        break;
    }
  }



  selectChangeHandlerReplyMethod (event: any)
  {
    this.support.replyMethod = event.target.value;
   console.log(this.subject);




    console.log(this.support.replyMethod);


  }



  ngOnInit() {
  }

  sendMessage(){
    this.support.client = this.token.getUser();
    this.support.subject = this.subject;
    this.support.message = this.message;
    this.support.replyMethod = this.replyMethod;

    console.log(this.support.subject);
    console.log(this.support.message);
    this.success = false;
    this.failure = false;
  this.contactService.sendMessage(this.support).subscribe(
    res =>{
      this.success = true;
    },
    err =>{
      this.failure = true;
      console.log(err)
    }
  );
  }
}