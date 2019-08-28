import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ClientRoutingModule } from './client-routing.module';
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';
import { DevicesComponent } from './devices/devices.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { ClientsComponent } from './clients/clients.component';


/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see DeviceRoutingModule
 */
@NgModule({
  declarations: [ClientDashboardComponent, DevicesComponent, WorkInProgressComponent, ClientsComponent],
  imports: [
    CommonModule,
    ClientRoutingModule,
    FormsModule
  ]
})
export class ClientModule { }
