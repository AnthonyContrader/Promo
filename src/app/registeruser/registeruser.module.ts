import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisteruserRoutingModule } from './registeruser-routing.module';
import { RegisteruserComponent } from './registeruser.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [RegisteruserComponent],
  imports: [
    CommonModule,
    RegisteruserRoutingModule,
    FormsModule,
  ]
})
export class RegisteruserModule { }
