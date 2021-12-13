import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppDashboardComponent } from './app-dashboard/app-dashboard.component';
import { SceneListComponent } from './scene-list/scene-list.component';
import { ScenePageComponent } from './scene-page/scene-page.component';
import { SceneViewComponent } from './scene-view/scene-view.component';

const routes: Routes = [
  {
    "path": "",
    "component": AppDashboardComponent
  },
  {
    "path": "scenes",
    "component": ScenePageComponent,
    "children": [
      {
        "path": "",
        "component": SceneListComponent
      },
      {
        "path": ":id",
        "component": SceneViewComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
