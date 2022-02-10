import { Route } from '@angular/router';
import { BauxComponent } from 'app/user/baux/baux.component';

export const bauxRoute: Route = {
  path: 'baux',
  component: BauxComponent,
  data: {
    pageTitle: 'paperlabsApp.baux.title'
  }
};
