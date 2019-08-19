import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { AreariservataDTO } from 'src/dto/areariservatadto';

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

    this.service.areariservata(this.areariservataDTO).subscribe((user) => {

      if (user != null) {
        localStorage.setItem('currentUser', JSON.stringify(user));

        switch (user.usertype.toString()) {
          case 'ADMIN': {
            this.router.navigate(['/admin-dashboard']);
            break;
          }
          case 'MODERATOR': {
            this.router.navigate(['/moderator-dashboard']);
            break;
          }
          default:
            this.router.navigate(['/login']);
        }
      }
    });
  }
}
