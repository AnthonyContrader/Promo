import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Screen } from 'app/shared/model/micro1/screen.model';
import { ScreenService } from './screen.service';
import { ScreenComponent } from './screen.component';
import { ScreenDetailComponent } from './screen-detail.component';
import { ScreenUpdateComponent } from './screen-update.component';
import { ScreenDeletePopupComponent } from './screen-delete-dialog.component';
import { IScreen } from 'app/shared/model/micro1/screen.model';

@Injectable({ providedIn: 'root' })
export class ScreenResolve implements Resolve<IScreen> {
    constructor(private service: ScreenService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((screen: HttpResponse<Screen>) => screen.body));
        }
        return of(new Screen());
    }
}

export const screenRoute: Routes = [
    {
        path: 'screen',
        component: ScreenComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'gatewayApp.micro1Screen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'screen/:id/view',
        component: ScreenDetailComponent,
        resolve: {
            screen: ScreenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'gatewayApp.micro1Screen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'screen/new',
        component: ScreenUpdateComponent,
        resolve: {
            screen: ScreenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'gatewayApp.micro1Screen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'screen/:id/edit',
        component: ScreenUpdateComponent,
        resolve: {
            screen: ScreenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'gatewayApp.micro1Screen.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const screenPopupRoute: Routes = [
    {
        path: 'screen/:id/delete',
        component: ScreenDeletePopupComponent,
        resolve: {
            screen: ScreenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'gatewayApp.micro1Screen.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
