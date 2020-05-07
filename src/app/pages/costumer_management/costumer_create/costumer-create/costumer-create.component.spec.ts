import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CostumerCreateComponent } from './costumer-create.component';

describe('CostumerCreateComponent', () => {
  let component: CostumerCreateComponent;
  let fixture: ComponentFixture<CostumerCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CostumerCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CostumerCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
