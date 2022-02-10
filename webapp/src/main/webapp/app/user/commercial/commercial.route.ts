import { Route } from '@angular/router';
import { CommercialComponent } from 'app/user/commercial/commercial.component';

export const commercialRoute: Route = {
  path: 'commercial',
  component: CommercialComponent,
  data: {
    pageTitle: 'paperlabsApp.commercial.title'
  }
};
