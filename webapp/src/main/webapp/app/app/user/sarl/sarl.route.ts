import { Route } from '@angular/router';
import { SarlComponent } from 'app/user/sarl/sarl.component';

export const sarlRoute: Route = {
  path: 'sarl',
  component: SarlComponent,
  data: {
    pageTitle: 'paperlabsApp.sarl.title'
  }
};
