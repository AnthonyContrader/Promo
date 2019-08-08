import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AreariservataRoutingModule } from './areariservata-routing.module';
import { AreariservataComponent } from './areariservata.component';

@NgModule({
  declarations: [AreariservataComponent],
  imports: [
    CommonModule,
    AreariservataRoutingModule
  ]
})
export class AreariservataModule { }
