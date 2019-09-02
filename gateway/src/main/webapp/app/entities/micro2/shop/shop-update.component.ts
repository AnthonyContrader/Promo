import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IShop } from 'app/shared/model/micro2/shop.model';
import { ShopService } from './shop.service';

@Component({
    selector: 'jhi-shop-update',
    templateUrl: './shop-update.component.html'
})
export class ShopUpdateComponent implements OnInit {
    private _shop: IShop;
    isSaving: boolean;

    constructor(private shopService: ShopService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ shop }) => {
            this.shop = shop;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.shop.id !== undefined) {
            this.subscribeToSaveResponse(this.shopService.update(this.shop));
        } else {
            this.subscribeToSaveResponse(this.shopService.create(this.shop));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IShop>>) {
        result.subscribe((res: HttpResponse<IShop>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get shop() {
        return this._shop;
    }

    set shop(shop: IShop) {
        this._shop = shop;
    }
}
