import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http: HttpClient) { }

  //url!: string;

  //url = "localhost";
  private url!: string;

  public doRegistration_old(user: any) {
    return this.http.post("http://localhost:8080/register", user, { responseType: 'text' as 'json' });
  }


  public save(user: User) {
    return this.http.post<User>(this.url, user);
  }

  public doRegistration(user: User) {
    return this.http.post<User>("http://localhost:8080/register", user);
  }

  public getUserByEmail(email: string) {
    return this.http.get("http://localhost:8080//findUser/" + email);
  }

  public deleteUser(id: string | number) {
    return this.http.delete("http://localhost:8080/cancel/" + id);
  }

  // update

  public getUsers() {
    let username = 'user';
    let password = 'password';
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get("http://localhost:8080/getAllUsers", { headers });
    //return this.http.get("http://localhost:8080/getAllUsers")
  }



}
