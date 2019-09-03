import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AreariservataComponent } from './areariservata.component';

describe('AreariservataComponent', () => {
  let component: AreariservataComponent;
  let fixture: ComponentFixture<AreariservataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AreariservataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AreariservataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
