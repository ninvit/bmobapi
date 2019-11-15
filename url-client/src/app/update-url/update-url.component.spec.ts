import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateUrlComponent } from './update-url.component';

describe('UpdateUrlComponent', () => {
  let component: UpdateUrlComponent;
  let fixture: ComponentFixture<UpdateUrlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateUrlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateUrlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
