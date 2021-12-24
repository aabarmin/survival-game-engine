import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatButtonToggleChange } from '@angular/material/button-toggle';
import { ActivatedRoute } from '@angular/router';
import { ColorFormat } from '@ng-matero/extensions/colorpicker';
import { throttleTime } from 'rxjs/operators';
import { BinaryService } from '../binary.service';
import { CanvasHandler } from '../canvas/canvas-handler';
import { CanvasHandlerDraw } from '../canvas/canvas-handler-draw';
import { CanvasComponent } from '../canvas/canvas.component';
import { PixelColor } from '../pixel-color';

@Component({
  selector: 'app-layer-static',
  templateUrl: './layer-static.component.html',
  styleUrls: ['./layer-static.component.css']
})
export class LayerStaticComponent implements OnInit, AfterViewInit {

  private sceneId!: string;
  private layerId!: string;

  selectedToolName: string = "draw";
  availableTools: {[key: string]: CanvasHandler} = {
    "draw": new CanvasHandlerDraw(),
    "erase": new CanvasHandler()
  };
  
  loading = true;
  saving = false;
  colorData: PixelColor[][] = [];

  colorPickerFormat: ColorFormat = "rgb";
  colorPickerSelected = '';

  @ViewChild("staticLayerCanvas")
  layerContentCanvas!: CanvasComponent

  constructor(
    private binaryService: BinaryService, 
    private route: ActivatedRoute) { }

  ngAfterViewInit(): void {
    /**
     * Subscribing to the onDataChange event to save data when changed.
     */
    this.layerContentCanvas.onDataChange.pipe(
      throttleTime(1000)
    ).subscribe(data => {
      this.saving = true;
      this.binaryService.save({type: "LAYER", name: this.layerId}, data).subscribe(done => {
        this.saving = false;
      })
    })
    /**
     * Setting a defaultl tool. 
     */
    this.layerContentCanvas.canvasHandler = this.availableTools["draw"];
  }

  ngOnInit(): void {
    this.route.parent?.params.subscribe(parentParams => {
      this.route.params.subscribe(params => {
        this.sceneId = parentParams["id"];
        this.layerId = params["layerId"];

        this.loadContent();
      })
    });
  }

  private loadContent(): void {
    this.loading = true;
    this.binaryService.load({type: "LAYER", name: this.layerId}).subscribe(data => {
      this.colorData = data; 
      this.loading = false;
    })
  }

  onToolChange(event: MatButtonToggleChange) {
    /**
     * Changing the current drawing tool.
     */
    alert(1);
    this.layerContentCanvas.canvasHandler = this.availableTools[this.selectedToolName];
  }
}
