import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './app-sidebar.component.html',
  styleUrls: ['./app-sidebar.component.css']
})
export class AppSidebarComponent implements OnInit {
  @Output()
  onMenuItemSelected = new EventEmitter<any>();

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goHome(): void {
    this.router.navigate(["/"])
    this.onMenuItemSelected.emit()
  }

  goScenes(): void {
    this.router.navigate(["/scenes"])
    this.onMenuItemSelected.emit()
  }

}
