import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { DogsComponent } from './dogs/dogs.component';
import { UsersComponent } from './users/users.component';

import { RouterModule } from '@angular/router';

import { DogsService } from './dogs/dogs.service';

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
    RouterModule.forRoot([
        { path: 'register', component: RegisterComponent },
        { path: 'dogs', component: DogsComponent },
        { path: 'users', component: UsersComponent }
    ])
  ],
  providers: [DogsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
