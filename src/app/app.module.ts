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
import {Request_managementComponent} from "./pages/request_management/request_management.component";
import {OperationsComponent} from "./pages/operations/operations.component";

import { TransferComponent } from './pages/operations/transfer/transfer.component';
import { RechargeComponent } from './pages/operations/recharge/recharge.component';
import { SettingsComponent } from './pages/settings/settings.component';
import { CreditCardComponent } from './pages/request_management/credit-card/credit-card.component';
import { CheckbookComponent } from './pages/request_management/checkbook/checkbook.component';
import { AccountComponent } from './pages/account/account.component';
import { RequestHandlerComponent } from './Services/request-handler/request-handler.component';
import { AgentDashboardComponent } from './pages/agent-dashboard/agent-dashboard.component';
import { AgentLayoutComponent } from './layouts/agent-layout/agent-layout.component';
import { ContactComponent } from './Services/contact/contact/contact.component';

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
    CheckbookComponent,
    AccountComponent,
    RequestHandlerComponent,
    AgentDashboardComponent,
    AgentLayoutComponent,
    ContactComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
