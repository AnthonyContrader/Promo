import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientLayoutComponent } from '../layout/client-layout/client-layout.component';
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';
import { DevicesComponent } from './devices/devices.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { ClientsComponent } from '../moderator/clients/clients.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see DeviceLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'client-dashboard', component: ClientLayoutComponent, children:[
    { path: '', component: ClientDashboardComponent},
    { path: 'devices', component: DevicesComponent},
    { path: 'clients', component: ClientsComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule { }