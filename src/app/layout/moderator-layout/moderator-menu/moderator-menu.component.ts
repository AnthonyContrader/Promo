import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-moderator-menu',
  templateUrl: './moderator-menu.component.html',
  styleUrls: ['./moderator-menu.component.css']
})
export class ModeratorMenuComponent implements OnInit {

  isAccountCollapsed = false;
  isClientCollapsed = false;
  isDeviceCollapsed = false;
  
  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  clientscollapse() {
    if (this.isClientCollapsed === false) {
      this.isClientCollapsed = true;
    } else { this.isClientCollapsed = false; }
  }

  devicescollapse() {
    if (this.isDeviceCollapsed === false) {
      this.isDeviceCollapsed = true;
    } else { this.isDeviceCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }
}
