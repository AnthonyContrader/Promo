import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { AreariservataDTO } from 'src/dto/areariservatadto';
import { Observable } from 'rxjs';
import { LoginDTO } from 'src/dto/logindto';


/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UserService extends AbstractService<UserDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'user';
  }

  areariservata(areariservataDTO: AreariservataDTO): Observable<UserDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/areariservata', areariservataDTO)
  }

  login(loginDTO: LoginDTO): Observable<UserDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)
  }

}
