import {Component, OnInit} from "@angular/core";

declare interface RouteInfo {
  path: string;
  title: string;
  rtlTitle: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  {
    path: "/dashboard",
    title: "Dashboard",
    rtlTitle: "لوحة القيادة",
    icon: "icon-chart-pie-36",
    class: ""
  },
  {
    path: "/accounts",
    title: "Accounts management",
    rtlTitle: "خرائط",
    icon: "icon-components",
    class: ""
  },
 /* {
    path: "/operations",
    title: "Operations",
    rtlTitle: "الرموز",
    icon: "icon-single-02",
    class: ""
  },*/
  {
    path: "/transfer",
    title: "Transfer money",
    rtlTitle: "الرموز",
    icon: "icon-single-02",
    class: ""
  },
  {
    path: "/recharge",
    title: "Recharge your phone",
    rtlTitle: "الرموز",
    icon: "icon-single-02",
    class: ""
  },
  {
    path: "/request_card",
    title: "Request for a credit card",
    rtlTitle: "الرموز",
    icon: "icon-single-02",
    class: ""
  },
  {
    path: "/request_checkbook",
    title: "Request for a checkbook",
    rtlTitle: "الرموز",
    icon: "icon-single-02",
    class: ""
  },
  {
    path: "/settings",
    title: "Settings",
    rtlTitle: "الرموز",
    icon: "icon-settings",
    class: ""
  },

  {
    path: "/support",
    title: "Support",
    rtlTitle: "خرائط",
    icon: "icon-components",
    class: ""
  },

/*
  {
    path: "/typography",
    title: "Setting",
    rtlTitle: "طباعة",
    icon: "icon-settings",
    class: ""
  }*/
];

@Component({
  selector: "app-sidebar",
  templateUrl: "./sidebar.component.html",
  styleUrls: ["./sidebar.component.css"]
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() {
  }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

  isMobileMenu() {
    return window.innerWidth <= 991;

  }
}
