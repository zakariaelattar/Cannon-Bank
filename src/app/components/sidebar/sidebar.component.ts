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
    path: "/costumer_management",
    title: "Costumers management",
    rtlTitle: "الرموز",
    icon: "icon-single-02",
    class: ""
  },
  {
    path: "/account_management",
    title: "Accounts management",
    rtlTitle: "خرائط",
    icon: "icon-components",
    class: ""
  },
  {
    path: "/request_management",
    title: "Request management",
    rtlTitle: "خرائط",
    icon: "icon-components",
    class: ""
  },
  {
    path: "/support",
    title: "Support",
    rtlTitle: "إخطارات",
    icon: "icon-link-72",
    class: ""
  },

  {
    path: "/typography",
    title: "Setting",
    rtlTitle: "طباعة",
    icon: "icon-settings",
    class: ""
  }
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
