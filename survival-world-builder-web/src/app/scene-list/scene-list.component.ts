import { Component, OnInit } from '@angular/core';
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

  constructor(private sceneService: SceneService) { }

  ngOnInit(): void {
    this.sceneService.findAll().subscribe(scenes => {
      this.loading = false;
      this.scenes = scenes;
    })
  }

}
