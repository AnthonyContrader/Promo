import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ScreenRoutingModule } from './screen-routing.module';
import { ScreenDashboardComponent } from './screen-dashboard/screen-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { ScreensComponent } from './screens/screens.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see ScreenRoutingModule
 */
@NgModule({
  declarations: [ScreenDashboardComponent, UsersComponent, WorkInProgressComponent, ScreensComponent],
  imports: [
    CommonModule,
    ScreenRoutingModule,
    FormsModule
  ]
})
export class ScreenModule { }
