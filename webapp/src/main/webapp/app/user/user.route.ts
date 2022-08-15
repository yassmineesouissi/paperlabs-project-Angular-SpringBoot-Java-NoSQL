import { Routes } from '@angular/router';
import { legalDocumentDescriptionRoute } from 'app/user/legal-document-description/legal-document-description.route';
import { legalDocumentDescriptionRoute1 } from 'app/user/legal-document-description/legal-document-description.route';
import { legalDocumentDescriptionRoute2 } from 'app/user/legal-document-description/legal-document-description.route';
import { legalDocumentDescriptionRoute3 } from 'app/user/legal-document-description/legal-document-description.route';
import { legalDocumentDescriptionRoute4 } from 'app/user/legal-document-description/legal-document-description.route';
import { legalDocumentDescriptionRoute5 } from 'app/user/legal-document-description/legal-document-description.route';
import { legalDocumentDescriptionRoute6 } from 'app/user/legal-document-description/legal-document-description.route';
import { legalDocumentDescriptionRoute7 } from 'app/user/legal-document-description/legal-document-description.route';

import { howItWorksRoute } from 'app/user/how-it-works/how-it-works.route';
import { contactRoute } from 'app/user/contact/contact.route';
import { faqRoute } from 'app/user/faq/faq.route';
import { legalGuidesRoute } from 'app/user/legal-guides/legal-guides.route';
import { legalNoticeRoute } from 'app/user/legal-notice/legal-notice.route';
import { privacyPolicyRoute } from 'app/user/privacy-policy/privacy-policy.route';
import { teamRoute } from 'app/user/team/team.route';
import { termsAndConditionsRoute } from 'app/user/terms-and-conditions/terms-and-conditions.route';
import { aboutRoute } from './about-us/about-us.route';
import { documentsRoute } from 'app/user/documents/documents.route';
import { sarlRoute } from 'app/user/sarl/sarl.route';
import { suarlRoute } from 'app/user/suarl/suarl.route';
import { bauxRoute } from 'app/user/baux/baux.route';
import { commercialRoute } from 'app/user/commercial/commercial.route';
import { socialRoute } from 'app/user/social/social.route';
import { TarifsRoute } from './tarifs/tarifs.route';
import { cessionRoute } from './cession/cession.route';
import { sureteRoute } from './surete/surete.route';

const USER_ROUTES = [
  howItWorksRoute,
  contactRoute,
  legalDocumentDescriptionRoute,
  legalDocumentDescriptionRoute1,
  legalDocumentDescriptionRoute2,
  legalDocumentDescriptionRoute3,
  legalDocumentDescriptionRoute4,
  legalDocumentDescriptionRoute5,
  legalDocumentDescriptionRoute6,
  legalDocumentDescriptionRoute7,
  faqRoute,
  legalGuidesRoute,
  legalNoticeRoute,
  privacyPolicyRoute,
  teamRoute,
  termsAndConditionsRoute,
  aboutRoute,
  documentsRoute,
  sarlRoute,
  suarlRoute,
  bauxRoute,
  commercialRoute,
  socialRoute,
  TarifsRoute,
  cessionRoute,
  sureteRoute
];

export const userRoutes: Routes = [
  {
    path: '',
    children: USER_ROUTES
  }
];
