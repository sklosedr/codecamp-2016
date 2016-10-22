import { Component, OnInit } from '@angular/core';
import { Login } from './login.model';
import { LoginService } from './login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginModel : Login;
  errorMessage: string;
    
  constructor(private loginService: LoginService) { }

      login($event) {
      let login: Login;
      this.loginService.login(this.loginModel)
        .subscribe(

            error => this.errorMessage = <any>error);
      
  }
  ngOnInit() {
    this.loginModel = new Login('username', 'password');
  }

}
