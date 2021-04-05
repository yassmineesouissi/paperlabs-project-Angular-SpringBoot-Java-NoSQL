import { Route } from '@angular/router';

import { HomeComponent } from './home.component';
import { PasswordResetInitComponent } from 'app/account/password-reset/init/password-reset-init.component';
import { PasswordResetFinishComponent } from 'app/account/password-reset/finish/password-reset-finish.component';

export const HOME_ROUTE: Route = {
  path: '',
  component: HomeComponent,
  data: {
    pageTitle: 'home.title'
  },
  children: [
    {
      path: 'reset/request',
      component: PasswordResetInitComponent,
      data: {
        pageTitle: 'home.title'
      }
    },
    {
      path: 'reset/finish',
      component: PasswordResetFinishComponent,
      data: {
        pageTitle: 'home.title'
      }
    }
  ]
};
