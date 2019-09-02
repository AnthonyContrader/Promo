import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IShop } from 'app/shared/model/micro2/shop.model';

@Component({
    selector: 'jhi-shop-detail',
    templateUrl: './shop-detail.component.html'
})
export class ShopDetailComponent implements OnInit {
    shop: IShop;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ shop }) => {
            this.shop = shop;
        });
    }

    previousState() {
        window.history.back();
    }
}
