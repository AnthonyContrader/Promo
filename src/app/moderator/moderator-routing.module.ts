import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ModeratorLayoutComponent } from '../layout/moderator-layout/moderator-layout.component';
import { ModeratorDashboardComponent } from './moderator-dashboard/moderator-dashboard.component';
import { UsersComponent } from './users/users.component';
import { ClientsComponent } from './clients/clients.component';
import { DeviceDsComponent } from './deviceDs/deviceDs.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see DoctorLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'moderator-dashboard', component: ModeratorLayoutComponent, children:[
    { path: '', component: ModeratorDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'clients', component: ClientsComponent},
    { path: 'deviceDs', component: DeviceDsComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ModeratorRoutingModule { }