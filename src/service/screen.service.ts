import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ScreenDTO } from 'src/dto/screendto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate i metodi ereditati dall'Abstract(in mirror con il backend).
 * 
 * @author PattyGè
 * 
 * @see AbstractService
 */
@Injectable({
    providedIn: 'root'
})
export class ScreenService extends AbstractService<ScreenDTO>{
   
    constructor(http: HttpClient) {
        super(http);
        this.nome = 'micro1';
        this.type = 'screens';
        this.port = '8080';
    }
    auth() {
      const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;
  
      console.log(user.authorities + 'user');
      if (user) {
        return 'Bearer ' + user.authorities;
      } else {
        return '';
      }
    }

    userLogged(username: string) {
      // console.log('qua: ', this.auth());
       console.log(this.auth());
       return this.http.get('http://localhost:8080/api/users/' + username, {
         headers: {
           Authorization: this.auth()
         }
       });
      }


}
