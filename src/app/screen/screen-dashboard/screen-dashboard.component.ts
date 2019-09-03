import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { ScreenDTO } from 'src/dto/screendto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-screen-dashboard',
  templateUrl: './screen-dashboard.component.html',
  styleUrls: ['./screen-dashboard.component.css']
})
export class ScreenDashboardComponent implements OnInit {

  user: UserDTO;
  screen: ScreenDTO;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.screen = JSON.parse(localStorage.getItem('currentScreen'));
  }

}
