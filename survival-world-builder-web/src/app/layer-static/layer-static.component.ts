import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BinaryService } from '../binary.service';
import { PixelColor } from '../pixel-color';
import { SceneLayer } from '../scene-layer';

@Component({
  selector: 'app-layer-static',
  templateUrl: './layer-static.component.html',
  styleUrls: ['./layer-static.component.css']
})
export class LayerStaticComponent implements OnInit {

  private sceneId!: string;
  private layerId!: string;
  
  loading = true;
  colorData: PixelColor[][] = [];

  constructor(
    private binaryService: BinaryService, 
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.parent?.params.subscribe(parentParams => {
      this.route.params.subscribe(params => {
        this.sceneId = parentParams["id"];
        this.layerId = params["layerId"];

        this.loadContent();
      })
    })
  }

  private loadContent(): void {
    this.loading = true;
    this.binaryService.load({type: "LAYER", name: this.layerId}).subscribe(data => {
      this.colorData = data; 
      this.loading = false;
    })
  }
}
