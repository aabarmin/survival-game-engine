import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { NewLayerRequest } from './layer-new-request';

@Component({
  selector: 'app-layer-new-dialog',
  templateUrl: './layer-new-dialog.component.html',
  styleUrls: ['./layer-new-dialog.component.css']
})
export class LayerNewDialogComponent implements OnInit {
  data: NewLayerRequest = {
    name: '',
    type: ''
  }

  types = {
    'STATIC': "Static layer",
    'DYNAMIC': "Dynamic layer"
  }

  constructor(public dialogRef: MatDialogRef<LayerNewDialogComponent>) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.dialogRef.close();
  }
}
