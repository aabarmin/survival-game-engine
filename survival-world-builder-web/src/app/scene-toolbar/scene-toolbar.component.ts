import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-scene-toolbar',
  templateUrl: './scene-toolbar.component.html',
  styleUrls: ['./scene-toolbar.component.css']
})
export class SceneToolbarComponent implements OnInit {

  constructor() { }

  @Output()
  onSave = new EventEmitter<string>()

  name: string = "introScene";

  ngOnInit(): void {
  }

  save(): void {
    this.onSave.emit(this.name);
  }
}
