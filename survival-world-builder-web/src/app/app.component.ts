import { Component, ElementRef, TemplateRef, ViewChild } from '@angular/core';
import { MatDrawer } from '@angular/material/sidenav';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'survival-scene-builder-web';

  @ViewChild("drawer")
  sidebar!: MatDrawer

  onSidebarToggle(): void {
    this.sidebar.toggle();
  }
}
