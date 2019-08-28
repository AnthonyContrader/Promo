import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ClientDTO } from 'src/dto/clientdto';
import { ClientService } from 'src/service/client.service';
import { Router } from '@angular/router';
import { LoginDTO } from 'src/dto/logindto';

@Component({
  selector: 'app-client-login',
  templateUrl: './client-login.component.html',
  styleUrls: ['./client-login.component.css']
})
export class ClientLoginComponent implements OnInit {

  clientDTO: ClientDTO;
  loginDTO: LoginDTO;

  constructor(private clientService: ClientService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.clientService.login(this.loginDTO).subscribe((client) => {

      if (client != null) {
        localStorage.setItem('currentClient', JSON.stringify(client));
        this.router.navigate(['/client-dashboard']);
        
      }
    });
}

}
