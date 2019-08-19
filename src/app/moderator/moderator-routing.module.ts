import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ModeratorLayoutComponent } from '../layout/moderator-layout/moderator-layout.component';
import { ModeratorDashboardComponent } from './moderator-dashboard/moderator-dashboard.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see ModeratorLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'moderator-dashboard', component: ModeratorLayoutComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ModeratorRoutingModule { }