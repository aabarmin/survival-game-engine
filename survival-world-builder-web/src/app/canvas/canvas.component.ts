import { Component, ElementRef, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, ViewChild } from '@angular/core';
import { colorCopy, PixelColor } from '../pixel-color';

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
  private renderingContext!: CanvasRenderingContext2D

  private isDrawing: boolean = false;
  private currentColor: PixelColor = {
    red: 0,
    green: 0,
    blue: 0,
    transparency: 0
  };
  private currentContent: PixelColor[][] = [];
  private drawGrid: boolean = false;

  constructor() { }

  private get context(): CanvasRenderingContext2D {
    if (this.renderingContext == null) {
      this.renderingContext = this.canvas.getContext('2d')!
    }
    return this.renderingContext;
  }

  private get canvas(): HTMLCanvasElement {
    return this.contentCavasRef.nativeElement;
  }

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

  /**
   * Draw a single pixel. 
   * 
   * @param row 
   * @param cell 
   * @returns 
   */
  private drawSingle(row: number, cell: number): void {
    // checking if nothing is changed
    if (!this.shouldDraw(row, cell)) {
      return;
    }
    
    // getting the actual color
    const color = this.data[row][cell];

    // calculating actual position of the pixel
    const x = cell * this.PIXEL_SIZE;
    const y = row * this.PIXEL_SIZE;

    // drawing and adding to the cache
    this.currentContent[row][cell] = colorCopy(color);
    this.context.fillStyle = `rgb(${color.red}, ${color.green}, ${color.blue})`
    this.context.fillRect(x, y, this.PIXEL_SIZE, this.PIXEL_SIZE)
  }

  /**
   * Draw the whole content.
   */
  private drawContent(): void {
    for (let rowNum = 0; rowNum < this.data.length; rowNum++) {
      const row = this.data[rowNum];
      for (let cellNum = 0; cellNum < row.length; cellNum++) {
        this.drawSingle(rowNum, cellNum);
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
          this.currentContent[rowNum][cellNum] = colorCopy(color);
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
    this.drawSingle(coordinate.row, coordinate.col);
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