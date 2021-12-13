import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { LayerNewDialogComponent } from '../layer-new-dialog/layer-new-dialog.component';
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
  sceneId = '';

  constructor(
    private dialog: MatDialog,
    private route: ActivatedRoute, 
    private sceneService: SceneService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.sceneId = params.id;
      this.loadLayers(this.sceneId);
    })
  }

  createNewLayer(): void {
    const dialogRef = this.dialog.open(LayerNewDialogComponent)
    dialogRef.afterClosed().subscribe(data => {
      if (!data) {
        return;
      }
    })
  }

  private loadLayers(sceneId: string): void {
    this.sceneService.findOne(sceneId).subscribe(model => {
      this.loading = false;
      this.scene = model;
      this.layers = model.layers;
    })
  }
}
