import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { throttleTime } from 'rxjs/operators';
import { BinaryService } from '../binary.service';
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
  
  loading = true;
  saving = false;
  colorData: PixelColor[][] = [];

  @ViewChild("staticLayerCanvas")
  layerContentCanvas!: CanvasComponent

  constructor(
    private binaryService: BinaryService, 
    private route: ActivatedRoute) { }

  ngAfterViewInit(): void {
    this.layerContentCanvas.onDataChange.pipe(
      throttleTime(1000)
    ).subscribe(data => {
      this.saving = true;
      this.binaryService.save({type: "LAYER", name: this.layerId}, data).subscribe(done => {
        this.saving = false;
      })
    })
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
}
