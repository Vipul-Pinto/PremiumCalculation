import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { state } from '@angular/animations';

@Component({
  selector: 'app-category',
  imports: [ReactiveFormsModule],
  templateUrl: './category.component.html',
  styleUrl: './category.component.css',
})
export class CategoryComponent implements OnInit {
  policyData: any;
  categoryForm!: FormGroup;
  completePolicyData: any;
  categoryData: any;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.policyData = history.state.policyData;
    this.categoryForm = this.fb.group({
      maleNumber1: [0],
      femaleNumber1: [0],
      maleNumber2: [0],
      femaleNumber2: [0],
      maleNumber3: [0],
      femaleNumber3: [0],
    });
    this.categoryData = history.state.categoryData;
    if (this.categoryData) {
      this.categoryForm.patchValue(this.categoryData);
    }
  }

  onSubmit() {
    const formValues = this.categoryForm.value;

    this.completePolicyData = {
      ...this.policyData,
      categories: [
        {
          categoryName: '10_TO_25',
          maleNumber: formValues.maleNumber1,
          femaleNumber: formValues.femaleNumber1,
        },
        {
          categoryName: '26_TO_50',
          maleNumber: formValues.maleNumber2,
          femaleNumber: formValues.femaleNumber2,
        },
        {
          categoryName: '51_TO_99',
          maleNumber: formValues.maleNumber3,
          femaleNumber: formValues.femaleNumber3,
        },
      ],
    };
    console.log(this.completePolicyData);
    this.http
      .post('http://localhost:8081/policies', this.completePolicyData)
      .subscribe((res: any) => {
        console.log(res);
      });
    this.router.navigate(['/summary'], {
      state: { policyData: this.completePolicyData },
    });
  }

  goBack() {
    this.router.navigate(['/'], {
      state: {
        policyData: this.policyData,
        categoryData: this.categoryForm.value,
      },
    });
  }
}
