import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { ClientDTO } from 'src/dto/clientdto';
import { DeviceDTO } from 'src/dto/devicedto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-moderator-dashboard',
  templateUrl: './moderator-dashboard.component.html',
  styleUrls: ['./moderator-dashboard.component.css']
})
export class ModeratorDashboardComponent implements OnInit {

  user: UserDTO;
  client: ClientDTO;
  device: DeviceDTO;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.client = JSON.parse(localStorage.getItem('currentClient'));
    this.device = JSON.parse(localStorage.getItem('currentDevice'));
  }

}
