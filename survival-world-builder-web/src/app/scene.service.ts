import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { SceneCell } from './scene-cell';
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
    // return this.http.get<string[]>("/api/scenes");
    return of([
      {
        id: "first-row",
        name: "First scene"
      },
      {
        id: "second-scene",
        name: "Second scene"
      }
    ])
  }

  public save(name: string, data: SceneCell[]): Observable<any> {
    const request = {
      "name": name, 
      "data": data
    };

    return this.http.post<any>("/scene", request);
  }
}
