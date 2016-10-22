import { Component, OnInit } from '@angular/core';
import { Login } from './login.model';
import { LoginService } from './login.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginModel : Login;
  errorMessage: string;
    
  constructor(private loginService: LoginService, private router: Router) { }

  login($event) {
      let login: Login;
      this.loginService.login(this.loginModel)
        .subscribe(
            success => this.router.navigate(['/dogs']),
            error => this.errorMessage = <any>error);
      
  }
  ngOnInit() {
    this.loginModel = new Login('', '');
  }
    
  goToRegister() {
      this.router.navigate(['/register']) 
  }

}
