import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ScenePageComponent } from './scene-page/scene-page.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppToolbarComponent } from './app-toolbar/app-toolbar.component';
import { AppAngularModule } from './app.angular.module';
import { AppSidebarComponent } from './app-sidebar/app-sidebar.component';
import { AppDashboardComponent } from './app-dashboard/app-dashboard.component';
import { SceneListComponent } from './scene-list/scene-list.component';
import { AppProgressorComponent } from './app-progressor/app-progressor.component';
import { SceneNewDialogComponent } from './scene-new-dialog/scene-new-dialog.component';
import { MAT_DIALOG_DEFAULT_OPTIONS } from '@angular/material/dialog';
import { SceneViewComponent } from './scene-view/scene-view.component';
import { SceneViewLayersComponent } from './scene-view-layers/scene-view-layers.component';

@NgModule({
  declarations: [
    AppComponent,

    AppToolbarComponent,
    AppProgressorComponent, 
    AppDashboardComponent, 
    AppSidebarComponent, 

    ScenePageComponent,
    SceneListComponent,
    SceneNewDialogComponent, 
    SceneViewComponent,
    SceneViewLayersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppAngularModule
  ],
  providers: [
    {
      provide: MAT_DIALOG_DEFAULT_OPTIONS, 
      useValue: {
        hasBackdrop: false
      }
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
