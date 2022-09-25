import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  users: any;

  constructor(private service: UserRegistrationService) { }

  ngOnInit() {

  }

  getUsers() {
    let resp = this.service.getUsers();
    resp.subscribe((data) => this.users = data);
  }

}
