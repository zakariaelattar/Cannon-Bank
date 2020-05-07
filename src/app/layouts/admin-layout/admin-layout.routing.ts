import {Routes} from "@angular/router";

import {DashboardComponent} from "../../pages/dashboard/dashboard.component";
import {Request_managementComponent} from "../../pages/request_management/request_management.component";
import {Account_managementComponent} from "../../pages/account_management/account_management.component";
import {NotificationsComponent} from "../../pages/notifications/notifications.component";
import {ProductDashboardComponent} from "../../pages/products/productDashboard/ProductDashboard.component";
import {TablesComponent} from "../../pages/tables/tables.component";
import {TypographyComponent} from "../../pages/typography/typography.component";
import {CreateProductComponent} from "../../pages/products/createProduct/createProduct.component";
import {Costumer_managementComponent} from "../../pages/costumer_management/costumer_management.component";
import {SupportComponent} from "../../pages/Support/support.component";
// import { RtlComponent } from "../../pages/rtl/rtl.component";

export const AdminLayoutRoutes: Routes = [
  {path: "dashboard", component: DashboardComponent},
  {path: "icons", component: Request_managementComponent},
  {path: "maps", component: Account_managementComponent},
  {path: "notifications", component: NotificationsComponent},
  {path: "products", component: ProductDashboardComponent},
  {path: "tables", component: TablesComponent},
  {path: "typography", component: TypographyComponent},
  {path: "products/create", component: CreateProductComponent},
  {path: "account_management", component: Account_managementComponent},
  {path: "request_management", component: Request_managementComponent},
  {path: "costumer_management", component: Costumer_managementComponent},
  {path: "support", component: SupportComponent}

  // { path: "rtl", component: RtlComponent }
];
