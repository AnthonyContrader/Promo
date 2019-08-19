import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisteruserComponent } from './registeruser.component';

const routes: Routes = [
  { path: 'registeruser', component: RegisteruserComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RegisteruserRoutingModule { }
