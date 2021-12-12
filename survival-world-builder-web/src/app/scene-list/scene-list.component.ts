import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { SceneNewDialogComponent } from '../scene-new-dialog/scene-new-dialog.component';
import { SceneRow } from '../scene-row';
import { SceneService } from '../scene.service';

@Component({
  selector: 'app-scene-list',
  templateUrl: './scene-list.component.html',
  styleUrls: ['./scene-list.component.css']
})
export class SceneListComponent implements OnInit {

  loading: boolean = true;
  scenes: SceneRow[] = [];

  constructor(    
    private dialog: MatDialog,
    private sceneService: SceneService) { }

  ngOnInit(): void {
    this.loadScenes();
  }

  openCreateNewSceneDialog(): void {
    const dialogRef = this.dialog.open(SceneNewDialogComponent);
    dialogRef.afterClosed().subscribe((scene: SceneRow) => {
      if (!scene) {
        return
      }
      this.loading = true;
      this.sceneService.createScene(scene).subscribe(created => {
        this.loadScenes();
      })
    })
  }

  private loadScenes(): void {
    this.loading = true;
    this.scenes = [];
    this.sceneService.findAll().subscribe(scenes => {
      this.loading = false;
      this.scenes = scenes;
    })
  }
}
