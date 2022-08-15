import { Route } from '@angular/router';
import { LegalDocumentDescriptionComponent } from 'app/user/legal-document-description/legal-document-description.component';
import { LegalDocumentResolve } from 'app/entities/legal-document/legal-document.route';

export const legalDocumentDescriptionRoute: Route = {
  path: 'documents/legal-document-description/:id',

  component: LegalDocumentDescriptionComponent,
  resolve: {
    legalDocument: LegalDocumentResolve
  },
  data: {
    pageTitle: 'paperlabsApp.legalDocumentDescription.title'
  }
};

export const legalDocumentDescriptionRoute1: Route = {
  path: 'sarl/legal-document-description/:id',
  component: LegalDocumentDescriptionComponent,
  resolve: {
    legalDocument: LegalDocumentResolve
  },
  data: {
    pageTitle: 'paperlabsApp.legalDocumentDescription.title'
  }
};
export const legalDocumentDescriptionRoute2: Route = {
  path: 'suarl/legal-document-description/:id',
  component: LegalDocumentDescriptionComponent,
  resolve: {
    legalDocument: LegalDocumentResolve
  },
  data: {
    pageTitle: 'paperlabsApp.legalDocumentDescription.title'
  }
};
export const legalDocumentDescriptionRoute3: Route = {
  path: 'baux/legal-document-description/:id',
  component: LegalDocumentDescriptionComponent,
  resolve: {
    legalDocument: LegalDocumentResolve
  },
  data: {
    pageTitle: 'paperlabsApp.legalDocumentDescription.title'
  }
};
export const legalDocumentDescriptionRoute4: Route = {
  path: 'commercial/legal-document-description/:id',
  component: LegalDocumentDescriptionComponent,
  resolve: {
    legalDocument: LegalDocumentResolve
  },
  data: {
    pageTitle: 'paperlabsApp.legalDocumentDescription.title'
  }
};

export const legalDocumentDescriptionRoute5: Route = {
  path: 'cession/legal-document-description/:id',
  component: LegalDocumentDescriptionComponent,
  resolve: {
    legalDocument: LegalDocumentResolve
  },
  data: {
    pageTitle: 'paperlabsApp.legalDocumentDescription.title'
  }
};

export const legalDocumentDescriptionRoute6: Route = {
  path: 'social/legal-document-description/:id',
  component: LegalDocumentDescriptionComponent,
  resolve: {
    legalDocument: LegalDocumentResolve
  },
  data: {
    pageTitle: 'paperlabsApp.legalDocumentDescription.title'
  }
};

export const legalDocumentDescriptionRoute7: Route = {
  path: 'surete/legal-document-description/:id',
  component: LegalDocumentDescriptionComponent,
  resolve: {
    legalDocument: LegalDocumentResolve
  },
  data: {
    pageTitle: 'paperlabsApp.legalDocumentDescription.title'
  }
};
