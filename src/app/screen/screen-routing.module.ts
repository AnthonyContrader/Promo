import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ScreenLayoutComponent } from '../layout/screen-layout/screen-layout.component';
import { ScreenDashboardComponent } from './screen-dashboard/screen-dashboard.component';
import { UsersComponent } from './users/users.component';
import { ScreensComponent } from './screens/screens.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see ScreenLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'screen-dashboard', component: ScreenLayoutComponent, children:[
    { path: '', component: ScreenDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'screens', component: ScreensComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ScreenRoutingModule { }