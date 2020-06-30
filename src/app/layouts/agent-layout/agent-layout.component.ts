import {Component, OnInit} from "@angular/core";
import {TokenStorageService} from "../../pages/_services/token-storage.service";

@Component({
  selector: "app-agent-layout",
  templateUrl: "./agent-layout.component.html",
  styleUrls: ["./agent-layout.component.scss"]
})
export class AgentLayoutComponent implements OnInit {
  public sidebarColor: string = "red";
  currentUser: any;
  constructor(private token: TokenStorageService) {
  }

  changeSidebarColor(color) {
    var sidebar = document.getElementsByClassName('sidebar')[0];
    var mainPanel = document.getElementsByClassName('main-panel')[0];

    this.sidebarColor = color;

    if (sidebar != undefined) {
      sidebar.setAttribute('data', color);
    }
    if (mainPanel != undefined) {
      mainPanel.setAttribute('data', color);
    }
  }

  changeDashboardColor(color) {
    var body = document.getElementsByTagName('body')[0];
    if (body && color === 'white-content') {
      body.classList.add(color);
    } else if (body.classList.contains('white-content')) {
      body.classList.remove('white-content');
    }
  }

  ngOnInit() {
    this.currentUser = this.token.getUser();
    this.changeDashboardColor('white-content');
  }
}
