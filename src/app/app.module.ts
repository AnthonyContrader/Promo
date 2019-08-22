import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login/login.module';
import { HttpClientModule } from '@angular/common/http';
import { LayoutModule } from './layout/layout.module';
import { AdminModule } from './admin/admin.module';
import { FreeModule } from './free/free.module';
import { HomepageModule } from './homepage/homepage.module';
import { AreariservataModule } from './areariservata/areariservata.module';
import { FormsModule } from '@angular/forms';

import { ModeratorModule } from './moderator/moderator.module';

import { RegisteruserModule } from './registeruser/registeruser.module';
import { ClientLoginComponent } from './client/client-login/client-login.component';
import { ClientHomeComponent } from './client/client-home/client-home.component';
import { DeviceComponent } from './client/device/device.component';
import { ClientService } from 'src/service/client.service';




/** 
 * Modulo principale dell'applicazione. Qui vengono importati i moduli secondari. L'UNICA component
 * da dichiare qui è l'AppComponent, tutte le altre devono essere dichiarate nel loro modulo e questo importato
 * qui.
 * 
 * @author Vittorio Valent
*/
@NgModule({
  declarations: [
    AppComponent,
    ClientLoginComponent,
    ClientHomeComponent,
    DeviceComponent,   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginModule,
    HttpClientModule,
    LayoutModule,
    AdminModule,
    FreeModule,
    HomepageModule,
    AreariservataModule,
    FormsModule,

    ModeratorModule,
    

    RegisteruserModule,
   


  ],
  providers: [ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
