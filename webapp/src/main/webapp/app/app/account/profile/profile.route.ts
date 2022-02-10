import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ProfileComponent } from './profile.component';
import { passwordRoute } from 'app/account/password/password.route';
import { settingsRoute } from 'app/account/settings/settings.route';
import { userOrderRoute } from 'app/account/user-order/user-order.route';
import { employersRoute } from 'app/account/employers/employers.route';
import { Routes } from '@angular/router';

const PROFILE_ROUTES = [passwordRoute, settingsRoute];

export const profileRoute: Routes = [
  {
    path: 'profile',
    component: ProfileComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Profile'
    },
    canActivate: [UserRouteAccessService],
    children: [...userOrderRoute, ...PROFILE_ROUTES, ...employersRoute]
  }
];
