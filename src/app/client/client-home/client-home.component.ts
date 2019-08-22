import { Component, OnInit } from '@angular/core';
import { Client } from 'src/dto/client';
import { ClientService } from 'src/service/client.service';
import { Router } from '@angular/router';
import { Device } from 'src/dto/device';

@Component({
  selector: 'app-client-home',
  templateUrl: './client-home.component.html',
  styleUrls: ['./client-home.component.css']
})
export class ClientHomeComponent implements OnInit {

  client : Client;
  idclient : number;
  devices : Array<Device>

  constructor(private clientService : ClientService, private router: Router) { }

  ngOnInit() {

    
    this.client = JSON.parse(sessionStorage.getItem ("client"));
    console.log("client ID: "+ this.client.idclient)
    
  }

  showDevices(idclient: number){
    sessionStorage.setItem("idclient",JSON.stringify(idclient));
    console.log("client ID: "+ this.idclient)
    this.router.navigateByUrl('/deviceManagement/'+ idclient);

  }

}


