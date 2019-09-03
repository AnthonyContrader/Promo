import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientLoginRoutingModule } from './client-login-routing.module';
import { ClientLoginComponent } from './client-login.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [ClientLoginComponent],
  imports: [
    CommonModule,
    ClientLoginRoutingModule,
    FormsModule,
  ]
})
export class ClientLoginModule { }
