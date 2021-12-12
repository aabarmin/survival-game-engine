import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  templateUrl: './app-toolbar.component.html',
  styleUrls: ['./app-toolbar.component.css']
})
export class AppToolbarComponent implements OnInit {

  @Output()
  onSidebarToggle = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  sidebarToggle(): void {
    this.onSidebarToggle.emit();
  }
}
