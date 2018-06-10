import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwitchWindowsComponent } from './switchWindows.component';

describe('SwitchWindowsComponent', () => {
  let component: SwitchWindowsComponent;
  let fixture: ComponentFixture<SwitchWindowsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwitchWindowsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwitchWindowsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
