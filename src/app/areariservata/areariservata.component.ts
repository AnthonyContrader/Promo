import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { AreariservataDTO } from 'src/dto/areariservatadto';
import { UserDTO } from 'src/dto/userdto';
import { NgForOf } from '@angular/common';

@Component({
  selector: 'app-areariservata',
  templateUrl: './areariservata.component.html',
  styleUrls: ['./areariservata.component.css']
})
export class AreariservataComponent implements OnInit {

  areariservataDTO: AreariservataDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  areariservata(f: NgForm): void {
    this.areariservataDTO = new AreariservataDTO(f.value.username, f.value.password);

    this.service.login(this.areariservataDTO).subscribe((token : any) => {
      localStorage.setItem("AUTOKEN", JSON.stringify({ "authorities": token.id_token }));
      localStorage.setItem("currentUser", JSON.stringify({ "authorities": token.id_token }));
      this.service.userLogged(this.areariservataDTO.username).subscribe((user:UserDTO)=>{

      if (user != null) {
        localStorage.setItem('AUTOKEN', JSON.stringify(user));
        console.log(user.authorities);
        if(user.authorities == "ROLE_ADMIN" ) {
          this.router.navigate(['/admin-dashboard']);
        }
        if(user.authorities == "ROLE_MODERATOR") {
          this.router.navigate(['/moderator-dashboard']);
        }
        
      }else{
          alert("Wrong username or password");
        }
      });
    });
    }
}