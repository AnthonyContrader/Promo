import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/service/client.service';
import { ClientDTO } from 'src/dto/clientdto';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients: ClientDTO[];
 clienttoinsert: ClientDTO = new ClientDTO();

  constructor(private service: ClientService) { }

  ngOnInit() {
    this.getClients();
    this.clienttoinsert = new ClientDTO();
    this.clienttoinsert.userDTO = new UserDTO();
  }

  getClients() {
    this.service.getAll().subscribe(data => {
      console.log(data);
      this.clients = data;
    });
  }

  delete(client: ClientDTO) {
    this.service.delete(client.id).subscribe(() => this.getClients());
  }

  update(client: ClientDTO) {
    this.service.update(client).subscribe(() => this.getClients());
  }

  insert(client: ClientDTO) {
    console.log(this.clienttoinsert);
    this.service.insert(this.clienttoinsert).subscribe(() => this.getClients());
    console.log();
  }

  clear(){
    this.clienttoinsert = new ClientDTO();
  }
}
