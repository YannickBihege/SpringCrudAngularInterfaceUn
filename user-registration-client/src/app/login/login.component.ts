import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  username!: string;
  password!: string;
  message: any

  constructor(private service: RestapiService, private router: Router) { }

  // constructor(private service: RestapiService) { }


  ngOnInit() {
  }

  doLogin() {
    let resp = this.service.login(this.username, this.password);
    resp.subscribe(data => {
      this.message = data;
      this.router.navigate(["/home"]);
      console.log(data);
    });
  }
}