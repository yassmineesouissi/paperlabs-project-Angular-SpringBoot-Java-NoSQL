import { Component, OnInit } from '@angular/core';
import { ILegalDocument } from 'app/shared/model/legal-document.model';
import { ActivatedRoute } from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
@Component({
  selector: 'jhi-legal-document-description',
  templateUrl: './legal-document-description.component.html',
  styleUrls: ['./legal-document-description.component.scss']
})
export class LegalDocumentDescriptionComponent implements OnInit {
  legalDocument: ILegalDocument;

  constructor(protected activatedRoute: ActivatedRoute, private accountService: AccountService) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ legalDocument }) => {
      this.legalDocument = legalDocument;
    });
  }

  isAuthenticated() {
    return this.accountService.isAuthenticated();
  }
}
