import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncrementarDecrementarComponent } from './incrementar-decrementar.component';

describe('IncrementarDecrementarComponent', () => {
  let component: IncrementarDecrementarComponent;
  let fixture: ComponentFixture<IncrementarDecrementarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IncrementarDecrementarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IncrementarDecrementarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
