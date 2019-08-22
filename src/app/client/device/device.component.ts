import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/service/client.service';
import { Router } from '@angular/router';
import { Device } from 'src/dto/device';

@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: ['./device.component.css']
})
export class DeviceComponent implements OnInit {

  public devices : Array<Device>
  public idclient :number

  constructor(private clientService : ClientService, private router : Router) { }

  ngOnInit() {
    this.idclient=parseInt(sessionStorage.getItem("idclient"))
    console.log('id client: ' + this.idclient)
    this.clientService.readDevices(this.idclient).subscribe((response) => {
      this.devices = response;
      console.log('device: ' + this.devices.length)
    }) 
    

    
  }

}
