import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SceneNewDialogComponent } from './scene-new-dialog.component';

describe('SceneNewDialogComponent', () => {
  let component: SceneNewDialogComponent;
  let fixture: ComponentFixture<SceneNewDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SceneNewDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SceneNewDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
