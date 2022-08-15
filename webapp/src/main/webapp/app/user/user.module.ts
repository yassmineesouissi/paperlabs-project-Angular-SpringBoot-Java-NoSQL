import { NgModule } from '@angular/core';
import { LegalDocumentDescriptionComponent } from './legal-document-description/legal-document-description.component';
import { RouterModule } from '@angular/router';
import { PaperlabsSharedModule } from 'app/shared/shared.module';
import { ContactComponent } from 'app/user/contact/contact.component';
import { HowItWorksComponent } from 'app/user/how-it-works/how-it-works.component';
import { userRoutes } from 'app/user/user.route';
import { TeamComponent } from './team/team.component';
import { TermsAndConditionsComponent } from './terms-and-conditions/terms-and-conditions.component';
import { LegalNoticeComponent } from './legal-notice/legal-notice.component';
import { PrivacyPolicyComponent } from './privacy-policy/privacy-policy.component';
import { DocumentsAndLegalServicesComponent } from './documents-and-legal-services/documents-and-legal-services.component';
import { LegalGuidesComponent } from './legal-guides/legal-guides.component';
import { FaqComponent } from './faq/faq.component';

import { AboutUsComponent } from './about-us/about-us.component';
import { DocumentsComponent } from './documents/documents.component';
import { SarlComponent } from './sarl/sarl.component';
import { SuarlComponent } from './suarl/suarl.component';
import { BauxComponent } from './baux/baux.component';
import { CommercialComponent } from './commercial/commercial.component';
import { SocialComponent } from './social/social.component';
import { TarifsComponent } from './tarifs/tarifs.component';
import { CessionComponent } from './cession/cession.component';
import { SureteComponent } from './surete/surete.component';

@NgModule({
  declarations: [
    HowItWorksComponent,
    ContactComponent,
    LegalDocumentDescriptionComponent,
    TeamComponent,
    TermsAndConditionsComponent,
    LegalNoticeComponent,
    PrivacyPolicyComponent,
    DocumentsAndLegalServicesComponent,
    LegalGuidesComponent,
    FaqComponent,
    AboutUsComponent,
    DocumentsComponent,
    SarlComponent,
    SuarlComponent,
    BauxComponent,
    CommercialComponent,
    SocialComponent,
    TarifsComponent,
    CessionComponent,
    SureteComponent
  ],
  imports: [PaperlabsSharedModule, RouterModule.forChild(userRoutes)]
})
export class UserModule {}
