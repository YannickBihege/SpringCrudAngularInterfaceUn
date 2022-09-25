import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchDeleteComponent } from './search-delete/search-delete.component';

const routes: Routes = [
  // { path: "", redirectTo: "register", pathMatch: "full" },
  { path: "", redirectTo: "login", pathMatch: "full" }, //login is default
  { path: "login", component: LoginComponent },
  { path: "home", component: HomeComponent },
  { path: "register", component: RegistrationComponent },
  { path: "search", component: SearchDeleteComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }





