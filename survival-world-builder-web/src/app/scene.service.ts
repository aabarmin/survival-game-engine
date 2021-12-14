import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { SceneModel } from './scene-model';
import { SceneRow } from './scene-row';

@Injectable({
  providedIn: 'root'
})
export class SceneService {

  constructor(private http: HttpClient) { }

  public createScene(data: SceneRow): Observable<SceneRow> {
    const url = `/api/scenes/${data.id}`;
    return this.http.post<SceneRow>(url, data)
  }

  public findAll(): Observable<SceneRow[]> {
    return this.http.get<SceneRow[]>("/api/scenes");
  }

  public findOne(id: string): Observable<SceneModel> {
    const url = `/api/scenes/${id}`;
    return this.http.get<SceneModel>(url);
  }
}
