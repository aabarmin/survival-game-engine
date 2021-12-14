import { Component, Input, OnInit } from '@angular/core';
import { PixelColor } from '../pixel-color';

@Component({
  selector: 'app-canvas',
  templateUrl: './canvas.component.html',
  styleUrls: ['./canvas.component.css']
})
export class CanvasComponent implements OnInit {

  @Input()
  data: PixelColor[][] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
