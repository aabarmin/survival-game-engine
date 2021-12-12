import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SceneComponent } from './scene/scene.component';
import { SceneToolbarComponent } from './scene-toolbar/scene-toolbar.component';
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

@NgModule({
  declarations: [
    AppComponent,
    SceneComponent,
    SceneToolbarComponent,
    ScenePageComponent,

    AppToolbarComponent,
    AppProgressorComponent, 
    AppDashboardComponent, 
    AppSidebarComponent, 

    SceneListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppAngularModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
