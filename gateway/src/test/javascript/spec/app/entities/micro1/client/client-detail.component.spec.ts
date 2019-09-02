/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { ClientDetailComponent } from 'app/entities/micro1/client/client-detail.component';
import { Client } from 'app/shared/model/micro1/client.model';

describe('Component Tests', () => {
    describe('Client Management Detail Component', () => {
        let comp: ClientDetailComponent;
        let fixture: ComponentFixture<ClientDetailComponent>;
        const route = ({ data: of({ client: new Client(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [ClientDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(ClientDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(ClientDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.client).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
