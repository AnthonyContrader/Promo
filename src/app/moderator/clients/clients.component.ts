import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/service/client.service';
import { ClientDTO } from 'src/dto/clientdto';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients: ClientDTO[];
 clienttoinsert: ClientDTO = new ClientDTO();
 users: UserDTO[];
 user: UserDTO = new UserDTO;

  constructor(private service: ClientService, private userService: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getClients();
    this.clienttoinsert = new ClientDTO();
    this.clienttoinsert.userDTO = new UserDTO();
    this.clienttoinsert.userDTO=this.user;
    
    this.userService.getAll().subscribe(
      usersList => this.users = usersList 
    );
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
    console.log(client);
    this.service.insert(client).subscribe(() => this.getClients());
    console.log();
  }

  clear(){
    this.clienttoinsert = new ClientDTO();
  }
}
