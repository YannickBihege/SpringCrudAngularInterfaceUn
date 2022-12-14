import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchDeleteComponent } from './search-delete/search-delete.component';
import { HttpClientModule } from '@angular/common/http';
import { UserRegistrationService } from './user-registration.service';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RestapiService } from './restapi.service';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    SearchDeleteComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserRegistrationService, RestapiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
