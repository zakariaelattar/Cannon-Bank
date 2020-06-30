import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestHandlerComponent } from './request-handler.component';

describe('RequestHandlerComponent', () => {
  let component: RequestHandlerComponent;
  let fixture: ComponentFixture<RequestHandlerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestHandlerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestHandlerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
