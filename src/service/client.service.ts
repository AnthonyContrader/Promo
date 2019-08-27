import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ClientDTO } from 'src/dto/clientdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

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
export class ClientService extends AbstractService<ClientDTO>{
   
    constructor(http: HttpClient) {
        super(http);
        this.type = 'client';
    }

}