import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Client } from 'src/dto/client';
import { ClientService } from 'src/service/client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-login',
  templateUrl: './client-login.component.html',
  styleUrls: ['./client-login.component.css']
})
export class ClientLoginComponent implements OnInit {

  client: Client;

  constructor(private clientService: ClientService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    console.log('mi arrivano username=' + f.value.username + ' password= ' + f.value.password);
    this.clientService.login(f.value.username, f.value.password).subscribe((response) => {
        console.log('Risposta ricevuta');
        if (response != null) {
            this.client = response;
            sessionStorage.setItem('client', JSON.stringify(this.client));
            console.log('Username: ' + this.client.username);
            console.log('client id: ' + this.client.idclient);

            this.router.navigateByUrl("/clientHome");
        }
    });
}

}
