import { Route } from '@angular/router';
import { DocumentsComponent } from 'app/user/documents/documents.component';

export const documentsRoute: Route = {
  path: 'documents',
  component: DocumentsComponent,
  data: {
    pageTitle: 'paperlabsApp.documents.title'
  }
};
