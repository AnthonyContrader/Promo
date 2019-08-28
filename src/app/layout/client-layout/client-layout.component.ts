import { Component, OnInit } from '@angular/core';
import { DeviceDTO } from 'src/dto/devicedto';
import { ClientDTO } from 'src/dto/clientdto';

@Component({
  selector: 'app-client-layout',
  templateUrl: './client-layout.component.html',
  styleUrls: ['./client-layout.component.css']
})
export class ClientLayoutComponent implements OnInit {

  device: DeviceDTO;
  client: ClientDTO;

  constructor() { }

  ngOnInit() {

    this.device = JSON.parse(localStorage.getItem('currentDevice'));
    this.client = JSON.parse(localStorage.getItem('currentClient'));
  }

}
