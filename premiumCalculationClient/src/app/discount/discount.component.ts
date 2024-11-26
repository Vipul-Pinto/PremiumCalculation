// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-discount',
//   imports: [],
//   templateUrl: './discount.component.html',
//   styleUrl: './discount.component.css'
// })
// export class DiscountComponent {

// }
import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { DiscountsService } from './discountsservice.service';

@Component({
  selector: 'app-discounts',
  standalone: true, 
  imports: [ FormsModule , CommonModule], 
  templateUrl: './discount.component.html',
  styleUrls: ['./discount.component.css'],
  providers: [DiscountsService], 
})
export class DiscountsComponent {
  slabs = [
    { label: '1 to 200', maleCount: 0, femaleCount: 0 },
    { label: '201 to 400', maleCount: 0, femaleCount: 0 },
    { label: '401 to Max', maleCount: 0, femaleCount: 0 },
  ];

  constructor(private discountservice: DiscountsService) {}

  getDiscounts(): void {
    this.discountservice.getDiscounts().subscribe(
      (data) => {
        this.slabs = data;
      },
      (error) => {
        console.error('Error fetching discounts:', error);
      }
    );
  }

  updateDiscounts(): void {
    this.discountservice.updateDiscounts(this.slabs).subscribe(
      () => {
        alert('Discounts updated successfully!');
      },
      (error) => {
        console.error('Error updating discounts:', error);
      }
    );
  }
}
