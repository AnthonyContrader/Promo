import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IScreen } from 'app/shared/model/micro1/screen.model';
import { ScreenService } from './screen.service';

@Component({
    selector: 'jhi-screen-update',
    templateUrl: './screen-update.component.html'
})
export class ScreenUpdateComponent implements OnInit {
    private _screen: IScreen;
    isSaving: boolean;

    constructor(private screenService: ScreenService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ screen }) => {
            this.screen = screen;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.screen.id !== undefined) {
            this.subscribeToSaveResponse(this.screenService.update(this.screen));
        } else {
            this.subscribeToSaveResponse(this.screenService.create(this.screen));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IScreen>>) {
        result.subscribe((res: HttpResponse<IScreen>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get screen() {
        return this._screen;
    }

    set screen(screen: IScreen) {
        this._screen = screen;
    }
}
