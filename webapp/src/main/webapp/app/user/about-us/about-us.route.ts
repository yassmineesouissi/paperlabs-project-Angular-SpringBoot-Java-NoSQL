import { Route } from '@angular/router';
import { AboutUsComponent } from 'app/user/about-us/about-us.component';

export const aboutRoute: Route = {
  path: 'about-us',
  component: AboutUsComponent,
  data: {
    pageTitle: 'paperlabsApp.about-us.title'
  }
};
