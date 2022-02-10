import { Route } from '@angular/router';
import { SocialComponent } from 'app/user/social/social.component';

export const socialRoute: Route = {
  path: 'social',
  component: SocialComponent,
  data: {
    pageTitle: 'paperlabsApp.social.title'
  }
};
