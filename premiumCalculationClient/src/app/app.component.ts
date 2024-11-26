// import { Component } from '@angular/core';
// import { RouterOutlet } from '@angular/router';

// @Component({
//   selector: 'app-root',
//   imports: [RouterOutlet],
//   templateUrl: './app.component.html',
//   styleUrl: './app.component.css'
// })
// export class AppComponent {
//   title = 'premiumCalculationClient';
// }
import { NgClass, NgSwitch, NgSwitchCase } from '@angular/common';
import { Component } from '@angular/core';
import { ROUTER_CONFIGURATION, ROUTES, RouterLink, RouterOutlet, withRouterConfig } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,RouterLink],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  selectedTab: string = 'policyInfo';

  selectTab(tab: string) {
    this.selectedTab = tab;
  }
}
