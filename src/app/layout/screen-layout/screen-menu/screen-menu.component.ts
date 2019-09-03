import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-screen-menu',
  templateUrl: './screen-menu.component.html',
  styleUrls: ['./screen-menu.component.css']
})
export class ScreenMenuComponent implements OnInit {

  isUserCollapsed = false;
  isAccountCollapsed = false;
  isScreenCollapsed = false;
  

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  screenscollapse() {
    if (this.isScreenCollapsed === false) {
      this.isScreenCollapsed = true;
    } else { this.isScreenCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
