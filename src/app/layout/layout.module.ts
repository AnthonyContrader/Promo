import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { AdminMenuComponent } from './admin-layout/admin-menu/admin-menu.component';
import { ModeratorLayoutComponent } from './moderator-layout/moderator-layout.component';
import { ModeratorMenuComponent } from './moderator-layout/moderator-menu/moderator-menu.component';
import { ClientLayoutComponent } from './client-layout/client-layout.component';
import { ClientMenuComponent } from './client-layout/client-menu/client-menu.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';

/**
 * Modulo di layout. Viene caricato nel rputer outlet padre e poi 
 * non viene più ricaricato. Quando clicchiamo su un link ricarichiamo solo l'outlet
 * che sta dentro AdminLayoutComponent
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 */
@NgModule({
  declarations: [AdminLayoutComponent, AdminMenuComponent, ModeratorLayoutComponent, ModeratorMenuComponent, ClientLayoutComponent, ClientMenuComponent, HeaderComponent],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class LayoutModule { }
