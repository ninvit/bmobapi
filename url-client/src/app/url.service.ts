import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UrlService {

  private baseUrl = 'http://localhost:8080/bmobapi/urls/';

  constructor(private http: HttpClient) { }

  getUrl(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/id/${id}`);
  }

  createUrl(url: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, url);
  }

  updateUrl(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteUrl(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getUrlsList(): Promise<any> {
    return this.http.get(`${this.baseUrl}`).toPromise();
  }

  getUrlByAlias(alias: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${alias}`);
  }

}
