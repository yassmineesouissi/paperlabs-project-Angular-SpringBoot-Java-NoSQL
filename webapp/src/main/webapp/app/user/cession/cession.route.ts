import { Route } from '@angular/router';
import { CessionComponent } from 'app/user/cession/cession.component';

export const cessionRoute: Route = {
  path: 'cession',
  component: CessionComponent,
  data: {
    pageTitle: 'paperlabsApp.cession.title'
  }
};
