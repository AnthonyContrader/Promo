import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login/login.module';
import { HttpClientModule } from '@angular/common/http';
import { LayoutModule } from './layout/layout.module';
import { AdminModule } from './admin/admin.module';
import { ModeratorModule } from './moderator/moderator.module';
import { ClientModule } from './client/client.module';
import { HomepageModule } from './homepage/homepage.module';
import { AreariservataModule } from './areariservata/areariservata.module';
import { ClientLoginModule } from './client/client-login/client-login.module';
import { ScreenModule } from './screen/screen.module';


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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginModule,
    HttpClientModule,
    LayoutModule,
    AdminModule,
    ModeratorModule,
    ClientModule,
    ScreenModule,
    HomepageModule,
    AreariservataModule,
    ClientLoginModule,
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
