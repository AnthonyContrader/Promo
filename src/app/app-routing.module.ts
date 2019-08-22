import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientLoginComponent } from './client/client-login/client-login.component';
import { ClientHomeComponent } from './client/client-home/client-home.component';
import { DeviceComponent } from './client/device/device.component';

/**
 * Questo è un modulo di routing. Essendo il modulo principale deve UNICAMENTE 
 * eseguire il redirect sul persorso /login (modulo di login) e NON DEVE contenere
 * altri percorsi: questi vanno specificati nei vari sotto-moduli di routing.
 * 
 * @see LoginRoutingModule
 * 
 * @author Vittorio Valent
 */
const routes: Routes = [
  { path: '', redirectTo:'/homepage', pathMatch: 'full' },
  { path: 'client', component: ClientLoginComponent},
  { path: 'clientHome', component : ClientHomeComponent},
  { path: 'deviceManagement/: idClient', component : DeviceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
