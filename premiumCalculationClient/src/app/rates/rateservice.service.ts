// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class RateserviceService {

//   constructor() { }
// }
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RatesService {
  private apiUrl = 'http://localhost:8080/api/rates';

  constructor(private http: HttpClient) {}

  getRates(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  updateRates(rates: any[]): Observable<void> {
    return this.http.post<void>(this.apiUrl, rates);
  }
}
