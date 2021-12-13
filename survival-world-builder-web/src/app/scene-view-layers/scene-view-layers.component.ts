import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SceneLayer } from '../scene-layer';
import { SceneModel } from '../scene-model';
import { SceneService } from '../scene.service';

@Component({
  selector: 'app-scene-view-layers',
  templateUrl: './scene-view-layers.component.html',
  styleUrls: ['./scene-view-layers.component.css']
})
export class SceneViewLayersComponent implements OnInit {

  loading = true;
  scene: SceneModel = new SceneModel();
  layers: SceneLayer[] = []

  constructor(
    private route: ActivatedRoute, 
    private sceneService: SceneService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params.id;
      this.sceneService.findOne(id).subscribe(model => {
        this.loading = false;
        this.scene = model;
        this.layers = model.layers;
      })
    })
  }

}
