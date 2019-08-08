import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FreeComponent } from './free.component';
import { FreeRoutingModule } from './free-routing.module';
import { FormsModule } from '@angular/forms';

/**
 * Questo modulo serve unicamente Login e Registrazione (non implementata)
 * Importa il suo modulo di routing
 * 
 * @author Vittorio Valent
 */
@NgModule({
  declarations: [FreeComponent],

  imports: [
    CommonModule,
    FreeRoutingModule,
    FormsModule
  ]
  
})
export class FreeModule { }