import { NgFor, NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-summary',
  imports: [NgFor, NgIf],
  templateUrl: './summary.component.html',
  styleUrl: './summary.component.css',
})
export class SummaryComponent implements OnInit {
  completePolicyData: any;
  calculatedPremium: string;
  rates: any;

  constructor(private http: HttpClient) {
    this.calculatedPremium = '';
  }

  ngOnInit(): void {
    this.completePolicyData = history.state.policyData;
    this.http
      .get(`${environment.apiUrl}/rates`)
      .subscribe((res) => console.log(res));
  }

  calculatePremium(schemeNumber: any) {
    this.http
      .get(`${environment.apiUrl}/summary/${schemeNumber}`)
      .subscribe((res) => {
        this.calculatedPremium = res.toString();
        console.log(typeof this.calculatedPremium);
      });
  }
}
