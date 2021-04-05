import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AccountService } from 'app/core/auth/account.service';
import { StepEntity } from 'app/entities/StepEntity';
import { StepperEventManagerService } from 'app/stepper/stepper/stepper-event-manager.service';
import { IOrder } from 'app/shared/model/order.model';
import { PreviewModalService } from 'app/stepper/preview/preview.service';
import { LegalDocument } from 'app/shared/model/legal-document.model';

@Component({
  selector: 'jhi-step-ar',
  templateUrl: './step-ar.component.html',
  styleUrls: ['./step-ar.component.scss']
})
export class StepArComponent implements OnInit {
  @Input() step: StepEntity;
  @Input() isFirstStep: boolean;
  @Input() isFinalStep: boolean;
  @Input() isConfirmGenerationStep: boolean;
  @Input() legalDocument: LegalDocument;
  @Output() downloadPDFEvent = new EventEmitter<IOrder>();
  orderIsPurchased = false;
  order: IOrder;

  constructor(
    private accountService: AccountService,
    private stepperEventManager: StepperEventManagerService,
    private previewModalService: PreviewModalService
  ) {}

  ngOnInit() {}

  isAuthenticated() {
    return this.accountService.isAuthenticated();
  }

  hasPreview(): boolean {
    if (this.legalDocument !== null && this.legalDocument !== undefined) {
      return (
        'Concession de dette' === this.legalDocument.shortName ||
        "Stage d'initiation à la vie professionnelle" === this.legalDocument.shortName
      );
    } else {
      return false;
    }
  }

  displayModal() {
    this.previewModalService.open(this.legalDocument.shortName);
  }

  nextPrev(currentStepId: string, action: number, orderId: string) {
    this.stepperEventManager.sendNextPrev(currentStepId, action, orderId);
  }

  purchase(order: IOrder) {
    this.order = order;
    this.orderIsPurchased = true;
  }
}
