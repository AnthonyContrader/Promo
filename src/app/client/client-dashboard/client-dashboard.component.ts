import { Component, OnInit } from '@angular/core';
import { DeviceDTO } from 'src/dto/devicedto';
import { ClientDTO } from 'src/dto/clientdto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-client-dashboard',
  templateUrl: './client-dashboard.component.html',
  styleUrls: ['./client-dashboard.component.css']
})
export class ClientDashboardComponent implements OnInit {

  device: DeviceDTO;
  client: ClientDTO;

  constructor() { }

  ngOnInit() {
    this.device = JSON.parse(localStorage.getItem('currentDevice'));
    this.client = JSON.parse(localStorage.getItem('currentClient'));
  }

}
