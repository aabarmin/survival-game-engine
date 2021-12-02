import { Component, OnInit, ViewChild } from '@angular/core';
import { SceneCell } from '../scene-cell';
import { SceneService } from '../scene.service';
import { SceneComponent } from '../scene/scene.component'

@Component({
  selector: 'app-scene-page',
  templateUrl: './scene-page.component.html',
  styleUrls: ['./scene-page.component.css']
})
export class ScenePageComponent implements OnInit {

  constructor(
    private sceneService: SceneService
  ) { }

  @ViewChild("scene")
  child!: SceneComponent

  ngOnInit(): void {
  }

  onSave(sceneName: string) {
    // need to get data from child component
    const data: Array<Array<number>> = this.child.data;
    const forSave: SceneCell[] = [];
    for (let i = 0; i < data.length; i++) {
      const row = data[i];
      for (let j = 0; j < row.length; j++) {
        forSave.push({
          rowNumber: i, 
          cellNumber: j,
          cellValue: row[j]
        })
      }
    }

    this.sceneService.save(sceneName, forSave).subscribe(() => {
      alert("Saved");
    })
  }

}
