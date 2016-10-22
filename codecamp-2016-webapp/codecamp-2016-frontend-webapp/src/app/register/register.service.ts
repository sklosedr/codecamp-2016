import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';

import { Observable }     from 'rxjs/Observable';

import { Register } from './register.model';

@Injectable()
export class RegisterService {
        
  private url = 'http://localhost:8080/register';
    
  private headers = new Headers({'Content-Type': 'application/json', 'Access-Control-Allow-Origin ': 'http://localhost:8082'});

  constructor(private http: Http) { }
    
  register(register: Register): Observable<Register> {
    return this.http
        .post(this.url, JSON.stringify(register), {headers: this.headers})
        .map(this.extractData)
        .catch(this.handleError);
  }
    
  private extractData(res: Response) {
    let body = res.json();
    return body || { };
  }
    
  private handleError (error: any) {
    // In a real world app, we might use a remote logging infrastructure
    // We'd also dig deeper into the error to get a better message
    let errMsg = (error.message) ? error.message :
      error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    console.error(errMsg); // log to console instead
    return Observable.throw(errMsg);
  }

}
