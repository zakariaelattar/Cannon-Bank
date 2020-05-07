import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {ToastrModule} from 'ngx-toastr';

import {AppComponent} from "./app.component";
import {AdminLayoutComponent} from "./layouts/admin-layout/admin-layout.component";
import {AuthLayoutComponent} from './layouts/auth-layout/auth-layout.component';

import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

import {AppRoutingModule} from "./app-routing.module";
import {ComponentsModule} from "./components/components.module";
import {ProductDashboardComponent} from './pages/products/productDashboard/ProductDashboard.component';


import {ProfileComponent} from "./pages/profile/profile.component";
import {BoardModeratorComponent} from "./pages/board-moderator/board-moderator.component";
import {BoardUserComponent} from "./pages/board-user/board-user.component";
import {BoardAdminComponent} from "./pages/board-admin/board-admin.component";
import {HomeComponent} from "./pages/home/home.component";
import {RegisterComponent} from "./pages/register/register.component";
import {LoginComponent} from "./pages/login/login.component";
import {Account_managementComponent} from "./pages/account_management/account_management.component";
import {Request_managementComponent} from "./pages/request_management/request_management.component";
import {OperationsComponent} from "./pages/operations/operations.component";
//import { CostumerCreateComponent } from './pages/operations/costumer_create/costumer-create/costumer-create.component';
import { TransferComponent } from './pages/operations/transfer/transfer.component';
import { RechargeComponent } from './pages/operations/recharge/recharge.component';
import { SettingsComponent } from './pages/settings/settings.component';
import { CreditCardComponent } from './pages/request_management/credit-card/credit-card.component';
import { CheckbookComponent } from './pages/request_management/checkbook/checkbook.component';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ComponentsModule,
    NgbModule,
    RouterModule,
    AppRoutingModule,
    ToastrModule.forRoot()
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    AuthLayoutComponent,
    ProductDashboardComponent,
    AppComponent,
    LoginComponent,
    Account_managementComponent,
    OperationsComponent,
    Request_managementComponent,
    RegisterComponent,
    HomeComponent,
    BoardAdminComponent,
    BoardUserComponent,
    BoardModeratorComponent,
    ProfileComponent,
    TransferComponent,
    RechargeComponent,
    SettingsComponent,
    CreditCardComponent,
    CheckbookComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}