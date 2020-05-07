import {Routes} from "@angular/router";

import {DashboardComponent} from "../../pages/dashboard/dashboard.component";
import {Request_managementComponent} from "../../pages/request_management/request_management.component";
import {Account_managementComponent} from "../../pages/account_management/account_management.component";
import {NotificationsComponent} from "../../pages/notifications/notifications.component";
import {ProductDashboardComponent} from "../../pages/products/productDashboard/ProductDashboard.component";
import {TablesComponent} from "../../pages/tables/tables.component";
import {TypographyComponent} from "../../pages/typography/typography.component";
import {CreateProductComponent} from "../../pages/products/createProduct/createProduct.component";
import {OperationsComponent} from "../../pages/operations/operations.component";
import {SupportComponent} from "../../pages/Support/support.component";
import {RechargeComponent} from "../../pages/operations/recharge/recharge.component";
import {TransferComponent} from "../../pages/operations/transfer/transfer.component";
import {SettingsComponent} from "../../pages/settings/settings.component";
import {CheckbookComponent} from "../../pages/request_management/checkbook/checkbook.component";
import {CreditCardComponent} from "../../pages/request_management/credit-card/credit-card.component";
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

  {path: "operations", component: OperationsComponent},
  {path: "recharge", component: RechargeComponent},
  {path: "transfer", component: TransferComponent},

  {path: "settings", component: SettingsComponent},
  {path: "support", component: SupportComponent},
  {path: "request_checkbook", component: CheckbookComponent},
  {path: "request_card", component: CreditCardComponent}




  // { path: "rtl", component: RtlComponent }
];
