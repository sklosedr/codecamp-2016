import { Component, OnInit } from '@angular/core';

import { RegisterService } from './register.service';
import { Register } from './register.model';

import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public registerModel : Register;
  errorMessage: string;
  mode = 'Observable';
  
  constructor(private registerService: RegisterService, private router: Router) { }
  
  register($event) {
      let registration: Register;
      this.registerService.register(this.registerModel).subscribe(
                                              success => this.router.navigate(['/login']),
                                              error => this.errorMessage = <any>error);
  }

  redirectToLogin($event){
    this.router.navigate(['/login']);
  }
  
  ngOnInit() {
    this.registerModel = new Register();
    this.registerModel.userRole = "USER";
  	//this.registerModel = new Register(0, 'muster', 'strongpass', 'USER', 'Hans', 'ball', 'nice doggy dog', true);
  }
}
