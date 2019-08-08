import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FreeComponent } from './free.component';

/**
 * Routing del LoginModule. gestisce il routing per le pagine di login 
 * (ed eventualmente di registrazione). Come ogni modulo di routing, viene 
 * importato nel suo modulo.
 * 
 * @see FreeModule
 * 
 * @author Vittorio Valent
 */
const routes: Routes = [
  { path:'free', component: FreeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class FreeRoutingModule { }