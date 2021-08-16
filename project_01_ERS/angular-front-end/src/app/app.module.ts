import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EmployeeSigninComponent } from './employee-signin/employee-signin.component';
import { CreateNewAccountComponent } from './create-new-account/create-new-account.component';
import {FormsModule}   from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { RouterModule, Routes} from '@angular/router';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { EmployeehomeComponent } from './employeehome/employeehome.component';
import { CreateticketComponent } from './createticket/createticket.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { TicketapprovalComponent } from './ticketapproval/ticketapproval.component';

const routes:Routes = [
 {path: '', component: HomeComponent},
 {path: 'login', component: EmployeeSigninComponent},
 {path: 'create', component: CreateNewAccountComponent},
 {path: 'adminlogin', component: AdminloginComponent},
 {path: 'employeehome', component: EmployeehomeComponent},
 {path: 'createticket', component: CreateticketComponent},
 {path: 'adminhome', component: AdminhomeComponent},
 {path: 'ticketapproval', component: TicketapprovalComponent}

]

@NgModule({
  declarations: [
    AppComponent,
    EmployeeSigninComponent,
    CreateNewAccountComponent,
    HomeComponent,
    AdminloginComponent,
    EmployeehomeComponent,
    CreateticketComponent,
    AdminhomeComponent,
    TicketapprovalComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
