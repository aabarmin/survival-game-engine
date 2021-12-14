import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LayerStaticComponent } from '../layer-static/layer-static.component';
import { SceneLayer } from '../scene-layer';
import { SceneModel } from '../scene-model';
import { SceneService } from '../scene.service';

@Component({
  selector: 'app-scene-view',
  templateUrl: './scene-view.component.html',
  styleUrls: ['./scene-view.component.css']
})
export class SceneViewComponent implements OnInit {

  currentScene!: SceneModel
  layerType: string = 'unknown';
  loading = true;

  constructor(
    private sceneService: SceneService, 
    private router: Router, 
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params.id;
      this.sceneService.findOne(id).subscribe(model => {
        this.currentScene = model;
        this.loading = false;
      })
    })
  }

  onLayerSelect(layer: SceneLayer) {
    this.layerType = layer.type;
    this.router.navigate(["scenes", this.currentScene.id, layer.type.toLowerCase(), layer.id])
  }
}
