import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AreariservataComponent } from './areariservata.component';

const routes: Routes = [
  { path: "areariservata", component: AreariservataComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AreariservataRoutingModule { }
