import { Component, ElementRef, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, ViewChild } from '@angular/core';
import { PixelColor } from '../pixel-color';

@Component({
  selector: 'app-canvas',
  templateUrl: './canvas.component.html',
  styleUrls: ['./canvas.component.css']
})
export class CanvasComponent implements OnChanges {
  @Input()
  data: PixelColor[][] = [];

  @Output()
  onDataChange = new EventEmitter<PixelColor[][]>();

  private PIXEL_SIZE: number = 8;
  @ViewChild("contentCanvas")
  private contentCavasRef!: ElementRef<HTMLCanvasElement>

  private isDrawing: boolean = false;
  private currentColor: PixelColor = {
    red: 0,
    green: 0,
    blue: 0, 
    transparency: 0
  }
  private currentContent: PixelColor[][] = [];
  private drawGrid: boolean = false;

  constructor() { }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.data && this.contentCavasRef) {
      this.draw();
    }
  }

  public onMouseDown(event: MouseEvent): void {
    this.isDrawing = true;
    this.paint(this.extractToCoordinate(event));
  }

  public onMouseUp(event: MouseEvent): void {
    this.isDrawing = false;
  }

  public onMouseMove(event: MouseEvent): void {
    if (this.isDrawing) {
      this.paint(this.extractToCoordinate(event));
    }
  }

  private draw(): void {
    this.setSize();
    this.drawContent();
  }

  private drawContent(): void {
    const canvas = this.contentCavasRef.nativeElement;
    const context = canvas.getContext('2d');

    context!.strokeStyle = 'black'

    for (let rowNum = 0; rowNum < this.data.length; rowNum++) {
      const row = this.data[rowNum];
      for (let cellNum = 0; cellNum < row.length; cellNum++) {
        const color = row[cellNum];

        const x = cellNum * this.PIXEL_SIZE;
        const y = rowNum * this.PIXEL_SIZE;

        if (this.drawGrid) {
          context!.strokeRect(x, y, this.PIXEL_SIZE, this.PIXEL_SIZE)
        }

        if (this.shouldDraw(rowNum, cellNum)) {
          this.currentContent[rowNum][cellNum] = {
            red: color.red,
            green: color.green,
            blue: color.blue,
            transparency: color.transparency
          };

          context!.fillStyle = `rgb(${color.red}, ${color.green}, ${color.blue})`
          context!.fillRect(x, y, this.PIXEL_SIZE, this.PIXEL_SIZE)
        }
      }
    }
  }

  private shouldDraw(rowNum: number, cellNum: number): boolean {
    if (this.currentContent.length == 0) {
      // this is the first run
      for (let rowNum = 0; rowNum < this.data.length; rowNum++) {
        const row = this.data[rowNum];
        this.currentContent[rowNum] = [];
        for (let cellNum = 0; cellNum < row.length; cellNum++) {
          const color = row[cellNum]
          this.currentContent[rowNum][cellNum] = {
            red: color.red,
            green: color.green,
            blue: color.blue,
            transparency: color.transparency
          };
        }
      }
    }

    const expectedColor = this.data[rowNum][cellNum];
    return this.currentContent[rowNum][cellNum] != expectedColor;
  }

  private setSize(): void {
    const canvas = this.contentCavasRef.nativeElement;
    canvas.height = this.data.length * this.PIXEL_SIZE;
    if (this.data.length > 0) {
      const firstRow = this.data[0];
      canvas.width = firstRow.length * this.PIXEL_SIZE;
    }
  }

  private paint(coordinate: Coordinate): void {
    this.data[coordinate.row][coordinate.col] = this.currentColor;
    this.onDataChange.emit(this.data);
    this.draw();
  }

  private extractToCoordinate(event: MouseEvent): Coordinate {
    return {
      row: this.offsetToCoordinate(event.offsetY),
      col: this.offsetToCoordinate(event.offsetX)
    }
  }

  private offsetToCoordinate(offset: number): number {
    return Math.floor(offset / this.PIXEL_SIZE);
  }
}

type Coordinate = {
  row: number
  col: number
}