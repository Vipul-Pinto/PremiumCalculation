import { NgFor, NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-summary',
  imports: [NgFor, NgIf],
  templateUrl: './summary.component.html',
  styleUrl: './summary.component.css',
})
export class SummaryComponent implements OnInit {
  completePolicyData: any;
  calculatedPremium: any | null = null;
  rates: any;

  // constructor(private http: HttpClient) {
    
  // }
  constructor(
    private router: Router,
    //private fb: FormBuilder,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.completePolicyData = history.state.policyData;
    this.http
      .get(`${environment.apiUrl}/rates`)
      .subscribe((res) => console.log(res));
  }

  calculatePremium() {
    
  }
  goBack() {
    this.router.navigate(['/category'], {
      state: {
       // policyData: this.policyData,
        // categoryData: this.categoryForm.value,
      },
    });
  }
  goNext() {
    this.router.navigate(['/rates'], {
      state: {
       // policyData: this.policyData,
        // categoryData: this.categoryForm.value,
      },
    });
  }

  
}
