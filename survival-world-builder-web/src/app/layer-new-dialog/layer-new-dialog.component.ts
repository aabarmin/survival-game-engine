import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-layer-new-dialog',
  templateUrl: './layer-new-dialog.component.html',
  styleUrls: ['./layer-new-dialog.component.css']
})
export class LayerNewDialogComponent implements OnInit {
  data = {}

  constructor(public dialogRef: MatDialogRef<LayerNewDialogComponent>) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.dialogRef.close();
  }
}
