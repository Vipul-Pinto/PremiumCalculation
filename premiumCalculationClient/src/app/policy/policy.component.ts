import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-policy',
  imports: [ReactiveFormsModule],
  templateUrl: './policy.component.html',
  styleUrl: './policy.component.css',
})
export class PolicyComponent implements OnInit {
  policyForm!: FormGroup;
  policyData: any;
  categoryData: any;
  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.policyForm = this.fb.group({
      schemeName: [''],
      schemeNumber: [''],
      premium: [0],
      state: [''],
      effectiveDate: [''],
      anniversary: [''],
      businessSource: [''],
      taxId: [''],
      country: [''],
      employerContractInfo: [''],
      address1: [''],
      address2: [''],
      address3: [''],
      city: [''],
      zip: [''],
      employerPhone: [''],
      employerExt: [''],
      employerFax: [''],
    });
    this.policyData = history.state.policyData;
    if (this.policyData) {
      this.policyForm.patchValue(this.policyData);
    }
    this.categoryData = history.state.categoryData;
  }

  onSubmit(): void {
    this.router.navigate(['/category'], {
      state: {
        policyData: this.policyForm.value,
        categoryData: this.categoryData,
      },
    });
  }
}
