import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http: HttpClient) { }


  public injectHeaders() {
    let username = 'user';
    let password = 'password';
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return headers;
  }


  private url!: string;

  public doRegistration_old(user: any) {
    return this.http.post("http://localhost:8080/register", user, { responseType: 'text' as 'json' });
  }

  /*

  public save(user: User) {
    return this.http.post<User>(this.url, user);
  }
  */

  public doRegistration(user: User) {
    let username = 'user';
    let password = 'password';
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password), responseType: 'text' as 'json' });
    return this.http.post<User>("http://localhost:8080/register", user, { headers });

    // return this.http.post<User>("http://localhost:8080/register", user, { responseType: 'text' as 'json' });
  }

  public getUserByEmail(email: string) {
    let username = 'user';
    let password = 'password';
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get("http://localhost:8080//findUser/" + email, { headers });
  }

  public deleteUser(id: string | number) {
    let username = 'user';
    let password = 'password';
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.delete("http://localhost:8080/cancel/" + id, { headers });
  }

  // update

  public getUsers() {
    let username = 'user';
    let password = 'password';
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get("http://localhost:8080/getAllUsers", { headers });
  }



}
