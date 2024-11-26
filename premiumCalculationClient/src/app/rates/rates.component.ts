// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-rates',
//   imports: [],
//   templateUrl: './rates.component.html',
//   styleUrl: './rates.component.css'
// })
// export class RatesComponent {

// }
import { Component, OnInit } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RatesService } from './rateservice.service';

@Component({
  selector: 'app-rates',
  standalone: true, 
  imports: [ HttpClientModule , FormsModule , CommonModule], 
  templateUrl: './rates.component.html',
  styleUrls: ['./rates.component.css'],
})
export class RatesComponent implements OnInit {
  ages = [
    { label: '10 to 30'},
    { label: '31 to 50'},
    { label: '51 to 99', maleRate: '', femaleRate: ''},
    { label: '190 to 199', maleRate: '', femaleRate: '' },
  ];

  constructor(private rateservice: RatesService) {}

  ngOnInit(): void {
    this.getRates();
  }

  getRates(): void {
    this.rateservice.getRates().subscribe(
      (data) => {
        this.ages = data;
      },
      (error) => {
        console.error('Error fetching rates:', error);
      }
    );
  }

  updateRates(): void {
    this.rateservice.updateRates(this.ages).subscribe(
      () => {
        alert('Rates updated successfully!');
      },
      (error) => {
        console.error('Error updating rates:', error);
      }
    );
  }
}
