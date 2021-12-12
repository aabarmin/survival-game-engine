import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { SceneRow } from '../scene-row';

@Component({
  selector: 'app-scene-new-dialog',
  templateUrl: './scene-new-dialog.component.html',
  styleUrls: ['./scene-new-dialog.component.css']
})
export class SceneNewDialogComponent implements OnInit {

  data: SceneRow = {
    id: "",
    name: ""
  }

  constructor(
    public dialogRef: MatDialogRef<SceneNewDialogComponent>
  ) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.dialogRef.close();
  }
}
