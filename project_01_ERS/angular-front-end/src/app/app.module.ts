import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EmployeeSigninComponent } from './employee-signin/employee-signin.component';
import { CreateNewAccountComponent } from './create-new-account/create-new-account.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeSigninComponent,
    CreateNewAccountComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
