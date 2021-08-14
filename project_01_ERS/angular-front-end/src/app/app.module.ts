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
//import { AuthGuard } from './site/auth.guard';

const routes:Routes = [
 {path: '', component: HomeComponent},
 {path: 'login', component: EmployeeSigninComponent},
 {path: 'create', component: CreateNewAccountComponent},
 {path: 'adminlogin', component: AdminloginComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    EmployeeSigninComponent,
    CreateNewAccountComponent,
    HomeComponent,
    AdminloginComponent,
    EmployeehomeComponent
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
