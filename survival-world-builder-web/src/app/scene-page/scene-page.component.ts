import { Component, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { SceneCell } from '../scene-cell';
import { SceneNewDialogComponent } from '../scene-new-dialog/scene-new-dialog.component';
import { SceneRow } from '../scene-row';
import { SceneService } from '../scene.service';

@Component({
  selector: 'app-scene-page',
  templateUrl: './scene-page.component.html',
  styleUrls: ['./scene-page.component.css']
})
export class ScenePageComponent {
  constructor() { }
}
