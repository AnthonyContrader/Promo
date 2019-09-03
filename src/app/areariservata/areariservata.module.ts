import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AreariservataRoutingModule } from './areariservata-routing.module';
import { AreariservataComponent } from './areariservata.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AreariservataComponent],
  imports: [
    CommonModule,
    AreariservataRoutingModule,
    FormsModule,
  ]
})
export class AreariservataModule { }
