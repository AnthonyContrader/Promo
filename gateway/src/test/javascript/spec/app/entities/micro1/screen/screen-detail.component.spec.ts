/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { ScreenDetailComponent } from 'app/entities/micro1/screen/screen-detail.component';
import { Screen } from 'app/shared/model/micro1/screen.model';

describe('Component Tests', () => {
    describe('Screen Management Detail Component', () => {
        let comp: ScreenDetailComponent;
        let fixture: ComponentFixture<ScreenDetailComponent>;
        const route = ({ data: of({ screen: new Screen(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [ScreenDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(ScreenDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(ScreenDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.screen).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
