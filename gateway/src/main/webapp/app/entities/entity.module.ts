import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { GatewayClientModule as Micro1ClientModule } from './micro1/client/client.module';
import { GatewayDeviceModule as Micro1DeviceModule } from './micro1/device/device.module';
import { GatewayScreenModule as Micro1ScreenModule } from './micro1/screen/screen.module';
import { GatewayShopModule as Micro2ShopModule } from './micro2/shop/shop.module';
import { GatewayMessageModule as Micro2MessageModule } from './micro2/message/message.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        Micro1ClientModule,
        Micro1DeviceModule,
        Micro1ScreenModule,
        Micro2ShopModule,
        Micro2MessageModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayEntityModule {}
