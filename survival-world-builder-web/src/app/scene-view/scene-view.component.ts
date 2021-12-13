import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SceneService } from '../scene.service';

@Component({
  selector: 'app-scene-view',
  templateUrl: './scene-view.component.html',
  styleUrls: ['./scene-view.component.css']
})
export class SceneViewComponent implements OnInit {

  sceneName: string = '';
  loading = true;

  constructor(
    private sceneService: SceneService, 
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params.id;
      this.sceneService.findOne(id).subscribe(model => {
        this.sceneName = model.name;
        this.loading = false;
      })
    })
  }

}
