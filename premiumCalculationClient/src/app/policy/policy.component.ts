import { NgClass, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { interval } from 'rxjs';

@Component({
  selector: 'app-policy',
  templateUrl: './policy.component.html',
  styleUrls: ['./policy.component.css'],
  standalone: true,
  imports: [ReactiveFormsModule, NgClass, NgIf],
})
export class PolicyComponent implements OnInit {
  policyForm!: FormGroup;
  policyData: any;
  categoryData: any;

  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.policyForm = this.fb.group({
      schemeName: ['', Validators.required],
      schemeNumber: ['', Validators.required],
      premium: [0, [Validators.required, Validators.min(0)]],
      state: ['', Validators.required],
      effectiveDate: ['', Validators.required],
      anniversary: ['', Validators.required],
      businessSource: ['', Validators.required],
      taxId: ['', Validators.required],
      country: ['', Validators.required],
      employerContractInfo: ['', Validators.required],
      address1: ['', Validators.required],
      address2: [''],
      address3: [''],
      city: ['', Validators.required],
      zip: ['', Validators.required],
      employerPhone: ['', Validators.required],
      employerExt: [''],
      employerFax: ['']
    });

    this.policyData = history.state.policyData;
    if (this.policyData) {
      this.policyForm.patchValue(this.policyData);
    }
    this.categoryData = history.state.categoryData;

    interval(30000).subscribe(() => {
      this.autoSave();
    });
  }

  isInvalid(controlName: string): boolean {
    const control = this.policyForm.get(controlName);
    return !!control && control.invalid && (control.dirty || control.touched);
  }

  onSubmit(): void {
    if (this.policyForm.valid) {
      this.router.navigate(['/category'], {
        state: {
          policyData: this.policyForm.value,
          categoryData: this.categoryData,
        },
      });
    } else {
      this.policyForm.markAllAsTouched();

      const invalidFields: string[] = [];
      Object.keys(this.policyForm.controls).forEach((field) => {
        const control = this.policyForm.get(field);
        if (control?.invalid) {
          invalidFields.push(field);
        }
      });

     
    }
  }

  autoSave(): void {
    localStorage.setItem('policyData', JSON.stringify(this.policyForm.value));
    console.log('Form data auto-saved');
  }
}