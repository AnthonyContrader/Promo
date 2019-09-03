
import { Component, OnInit } from '@angular/core';
import { ScreenService } from 'src/service/screen.service';
import { ScreenDTO } from 'src/dto/screendto';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';

@Component({
  selector: 'app-screens',
  templateUrl: './screens.component.html',
  styleUrls: ['./screens.component.css']
})
export class ScreensComponent implements OnInit {

  screens: ScreenDTO[];
  screentoinsert: ScreenDTO = new ScreenDTO();
  users: UserDTO[];
 user: UserDTO = new UserDTO;

  constructor(private service: ScreenService, private userService: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getScreens();
    this.screentoinsert = new ScreenDTO();
    this.screentoinsert.userDTO = new UserDTO();
    this.screentoinsert.userDTO=this.user;
  }

  getScreens() {
    this.service.getAll().subscribe(data => {
      console.log(data);
      this.screens = data;
    });
  }

  delete(screen: ScreenDTO) {
    this.service.delete(screen.id).subscribe(() => this.getScreens());
  }

  update(screen: ScreenDTO) {
    this.service.update(screen).subscribe(() => this.getScreens());
  }

  insert(screen: ScreenDTO) {
    console.log(this.screentoinsert);
    this.service.insert(this.screentoinsert).subscribe(() => this.getScreens());
    console.log();
  }

  clear(){
    this.screentoinsert = new ScreenDTO();
  }
}