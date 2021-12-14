import { Component, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSelectionList } from '@angular/material/list';
import { ActivatedRoute } from '@angular/router';
import { LayerNewDialogComponent } from '../layer-new-dialog/layer-new-dialog.component';
import { NewLayerRequest } from '../layer-new-dialog/layer-new-request';
import { LayerService } from '../layer.service';
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

  selectedLayer: string[] = [];

  @Output()
  onLayerSelect = new EventEmitter<SceneLayer>();

  constructor(
    private dialog: MatDialog,
    private route: ActivatedRoute, 
    private layerService: LayerService, 
    private sceneService: SceneService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.sceneId = params.id;
      this.loadLayers(this.sceneId);
    })
  }

  createNewLayer(): void {
    const dialogRef = this.dialog.open(LayerNewDialogComponent)
    dialogRef.afterClosed().subscribe((data: NewLayerRequest) => {
      if (!data) {
        return;
      }
      this.loading = true;
      this.layerService.addLayer(this.scene, data).subscribe(response => {
        this.loadLayers(this.sceneId);
      })
    })
  }

  private loadLayers(sceneId: string): void {
    this.sceneService.findOne(sceneId).subscribe(model => {
      this.loading = false;
      this.scene = model;
      this.layers = model.layers;
    })
  }

  public whenLayerSelected(): void {
    if (this.selectedLayer.length == 0) {
      return;
    }
    if (this.selectedLayer.length > 1) {
      // unexpected behavior but still possible
    }
    const selected = this.selectedLayer[0];
    const selectedLayer = this.layers.filter(layer => layer.id == selected)[0];
    this.onLayerSelect.emit(selectedLayer);
  }
}
