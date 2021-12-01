import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-scene',
  templateUrl: './scene.component.html',
  styleUrls: ['./scene.component.css']
})
export class SceneComponent implements OnInit {

  data: Array<Array<number>> = [];

  constructor() { }

  ngOnInit(): void {
    // initializing arrays
    for (let i = 0; i < 96; i++) {
      const row = [];
      for (let j = 0; j < 128; j++) {
        row[j] = 0;
      }
      this.data[i] = row;
    }    
  }

  onCellClick(row: number, cell: number): void {
    this.data[row][cell] = 1;
  }
}
