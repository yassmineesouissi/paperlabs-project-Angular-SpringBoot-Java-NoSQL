import { Route } from '@angular/router';
import { TarifsComponent } from './tarifs.component';
export const TarifsRoute: Route = {
  path: 'tarifs',
  component: TarifsComponent,
  data: {
    pageTitle: 'paperlabsApp.tarifs.title'
  }
};
