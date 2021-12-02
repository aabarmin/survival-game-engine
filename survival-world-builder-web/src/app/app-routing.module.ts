import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ScenePageComponent } from './scene-page/scene-page.component';

const routes: Routes = [
  {
    "path": "",
    "component": ScenePageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
