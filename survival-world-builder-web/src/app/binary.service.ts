import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BinaryObject } from './binary-object';
import { PixelColor } from './pixel-color';

@Injectable({
  providedIn: 'root'
})
export class BinaryService {

  constructor(private http: HttpClient) { }

  /**
   * Load some binary color content from the backend. 
   * 
   * @param content 
   * @returns 
   */
  public load(content: BinaryObject): Observable<PixelColor[][]> {
    const url = `/api/content/${content.type}/${content.name}`;
    return this.http.get<PixelColor[][]>(url);
  }

  /**
   * Save binary color content to backend. 
   * 
   * @param content 
   * @param data 
   * @returns 
   */
  public save(content: BinaryObject, data: PixelColor[][]): Observable<PixelColor[][]> {
    const url = `/api/content/${content.type}/${content.name}`;
    return this.http.post<PixelColor[][]>(url, data);
  }
}
