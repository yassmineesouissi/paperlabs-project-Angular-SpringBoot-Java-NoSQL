import { Route } from '@angular/router';
import { SureteComponent } from 'app/user/surete/surete.component';

export const sureteRoute: Route = {
  path: 'surete',
  component: SureteComponent,
  data: {
    pageTitle: 'paperlabsApp.surete.title'
  }
};
