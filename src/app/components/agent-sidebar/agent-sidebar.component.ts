import { Component, OnInit } from '@angular/core';
import {ROUTES} from "../sidebar/sidebar.component";


declare interface RouteInfo {
  path: string;
  title: string;
  rtlTitle: string;
  icon: string;
  class: string;
}

export const ROUTES1: RouteInfo[] = [

];
@Component({
  selector: 'app-agent-sidebar',
  templateUrl: './agent-sidebar.component.html',
  styleUrls: ['./agent-sidebar.component.scss']
})
export class AgentSidebarComponent implements OnInit {

  menuItems: any[];

  constructor() {
  }

  ngOnInit() {
    this.menuItems = ROUTES1.filter(menuItem => menuItem);
  }

  isMobileMenu() {
    return window.innerWidth <= 991;

  }


}
