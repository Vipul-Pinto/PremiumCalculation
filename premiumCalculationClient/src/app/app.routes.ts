import { Routes } from '@angular/router';
import { PolicyComponent } from './policy/policy.component';
import { CategoryComponent } from './category/category.component';
import { SummaryComponent } from './summary/summary.component';
import { RatesComponent } from './rates/rates.component';
import { DiscountComponent } from './discount/discount.component';

export const routes: Routes = [
  { path: '', component: PolicyComponent },
  { path: 'category', component: CategoryComponent },
  { path: 'summary', component: SummaryComponent },
  { path: 'rates', component: RatesComponent },
  { path: 'discount', component: DiscountComponent },
];
