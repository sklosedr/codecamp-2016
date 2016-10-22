import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';


import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { DogsComponent } from './dogs/dogs.component';
import { UsersComponent } from './users/users.component';

import { RouterModule } from '@angular/router';

import { DogsService } from './dogs/dogs.service';
import { RegisterService } from './register/register.service';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    DogsComponent,
    UsersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterialModule.forRoot(),
    RouterModule.forRoot([
        { path: 'register', component: RegisterComponent },
        { path: 'dogs', component: DogsComponent },
        { path: 'users', component: UsersComponent }
    ])
  ],
  providers: [DogsService, RegisterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
