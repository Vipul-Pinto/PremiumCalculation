// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class DiscountsserviceService {

//   constructor() { }
// }
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class DiscountsService {
  private apiUrl = 'http://localhost:8080/api/discounts';

  constructor(private http: HttpClient) {}

  getDiscounts(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  updateDiscounts(slabs: any[]): Observable<void> {
    return this.http.post<void>(this.apiUrl, slabs);
  }
}