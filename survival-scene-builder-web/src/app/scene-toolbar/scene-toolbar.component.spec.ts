import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SceneToolbarComponent } from './scene-toolbar.component';

describe('SceneToolbarComponent', () => {
  let component: SceneToolbarComponent;
  let fixture: ComponentFixture<SceneToolbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SceneToolbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SceneToolbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
