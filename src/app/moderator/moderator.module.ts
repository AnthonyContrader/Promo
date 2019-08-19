import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ModeratorRoutingModule } from './moderator-routing.module';
import { ModeratorDashboardComponent } from './moderator-dashboard/moderator-dashboard.component';


/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see ModeratorRoutingModule
 */
@NgModule({
  declarations: [ModeratorDashboardComponent],
  imports: [
    CommonModule,
    ModeratorRoutingModule,
    FormsModule
  ]
})
export class ModeratorModule { }
