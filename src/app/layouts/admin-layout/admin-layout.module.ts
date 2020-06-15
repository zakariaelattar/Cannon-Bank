import {NgModule} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";

import {AdminLayoutRoutes} from "./admin-layout.routing";
import {DashboardComponent} from "../../pages/dashboard/dashboard.component";
import {Request_managementComponent} from "../../pages/request_management/request_management.component";
import {NotificationsComponent} from "../../pages/notifications/notifications.component";
import {CreateProductComponent} from "../../pages/products/createProduct/createProduct.component";
import {TablesComponent} from "../../pages/tables/tables.component";
import {TypographyComponent} from "../../pages/typography/typography.component";
// import { RtlComponent } from "../../pages/rtl/rtl.component";

import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {OperationsComponent} from "../../pages/operations/operations.component";
import {SupportComponent} from "../../pages/Support/support.component";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    HttpClientModule,
    NgbModule,
  ],
  declarations: [
    DashboardComponent,
    CreateProductComponent,
    TablesComponent,
    Request_managementComponent,
    TypographyComponent,
    OperationsComponent,
    NotificationsComponent,
    SupportComponent,
    OperationsComponent
    // RtlComponent
  ]
})
export class AdminLayoutModule {
}
