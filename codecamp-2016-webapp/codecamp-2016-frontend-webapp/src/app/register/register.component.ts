import { Component, OnInit } from '@angular/core';

import { RegisterService } from './register.service';
import { Register } from './register.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public registerModel : Register;
  errorMessage: string;
  mode = 'Observable';

  constructor(private registerService: RegisterService) { }

  register($event) {
      let registration: Register;
      this.registerService.register(this.registerModel)
        .subscribe(

            error => this.errorMessage = <any>error);
      
  }

  

  ngOnInit() {
  	this.registerModel = new Register(0, 'muster', 'strongpass', 'USER', 'Hans', 'ball', 'nice doggy dog', true);
  }


}
