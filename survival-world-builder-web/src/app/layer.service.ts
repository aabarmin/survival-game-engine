import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewLayerRequest } from './layer-new-dialog/layer-new-request';
import { SceneModel } from './scene-model';

@Injectable({
  providedIn: 'root'
})
export class LayerService {

  constructor(private http: HttpClient) { }

  /**
   * Add a new layer to the existing scene. 
   * @param scene 
   * @param request 
   * @returns 
   */
  public addLayer(scene: SceneModel, request: NewLayerRequest): Observable<SceneModel> {
    const url = `/api/scenes/${scene.id}/layers`;
    return this.http.post<SceneModel>(url, request);
  }
}
