import { Component, OnInit } from '@angular/core';
import { DeviceService } from 'src/service/device.service';
import { DeviceDTO } from 'src/dto/devicedto';
import { ClientDTO } from 'src/dto/clientdto';
import { ClientService } from 'src/service/client.service';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.css']
})
export class DevicesComponent implements OnInit {

  devices: DeviceDTO[];
  devicetoinsert: DeviceDTO = new DeviceDTO();
  clients: ClientDTO[];
  client: ClientDTO = new ClientDTO;

  constructor(private service: DeviceService, private clientService: ClientService) { }

  ngOnInit() {
    this.client = JSON.parse(localStorage.getItem('currentClient'));
    this.getDevices();
    this.devicetoinsert = new DeviceDTO();
    this.devicetoinsert.clientDTO = new ClientDTO();
    this.devicetoinsert.clientDTO = this.client;
  }

  getDevices() {
    this.service.getAll().subscribe(data => {
      console.log(data);
      this.devices = data;
    });
  }

  delete(device: DeviceDTO) {
    this.service.delete(device.id).subscribe(() => this.getDevices());
  }

  update(device: DeviceDTO) {
    this.service.update(device).subscribe(() => this.getDevices());
  }

  insert(device: DeviceDTO) {
    console.log(device);
    this.service.insert(device).subscribe(() => this.getDevices());
    console.log();
  }

  clear(){
    this.devicetoinsert = new DeviceDTO();
  }
}
