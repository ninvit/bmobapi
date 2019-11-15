import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigateUrlComponent } from './navigate-url.component';

describe('NavigateUrlComponent', () => {
  let component: NavigateUrlComponent;
  let fixture: ComponentFixture<NavigateUrlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavigateUrlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigateUrlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
