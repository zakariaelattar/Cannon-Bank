import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckbookComponent } from './checkbook.component';

describe('CheckbookComponent', () => {
  let component: CheckbookComponent;
  let fixture: ComponentFixture<CheckbookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckbookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
