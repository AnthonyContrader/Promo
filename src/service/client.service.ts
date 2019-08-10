import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { HttpParams, HttpClient } from '@angular/common/http';
import { Client } from 'src/dto/client';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

  

  login(username: string, password: string): Observable<Client> {
    const params = new HttpParams().set('username', username).set('password', password);
    return this.http.post<Client>('http://localhost:8080/Client/loginClient', params)
  }

}
