import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SceneCell } from './scene-cell';

@Injectable({
  providedIn: 'root'
})
export class SceneService {

  constructor(
    private http: HttpClient
  ) { }

  public save(name: string, data: SceneCell[]): Observable<any> {
    const request = {
      "name": name, 
      "data": data
    };

    return this.http.post<any>("/scene", request);
  }
}
