import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/service/client.service';
import { ClientDTO } from 'src/dto/clientdto';

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
  }

  getClients() {
    this.service.getAll().subscribe(clients => this.clients = clients);
  }

  delete(client: ClientDTO) {
    this.service.delete(client.id).subscribe(() => this.getClients());
  }

  update(client: ClientDTO) {
    this.service.update(client).subscribe(() => this.getClients());
  }

  insert(client: ClientDTO) {
    this.service.insert(client).subscribe(() => this.getClients());
  }

  clear(){
    this.clienttoinsert = new ClientDTO();
  }
}