import { Route } from '@angular/router';
import { SuarlComponent } from 'app/user/suarl/suarl.component';

export const suarlRoute: Route = {
  path: 'suarl',
  component: SuarlComponent,
  data: {
    pageTitle: 'paperlabsApp.suarl.title'
  }
};
