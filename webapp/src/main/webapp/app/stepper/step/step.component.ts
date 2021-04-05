import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AccountService } from 'app/core/auth/account.service';
import { StepEntity } from 'app/entities/StepEntity';
import { StepperEventManagerService } from 'app/stepper/stepper/stepper-event-manager.service';
import { IOrder } from 'app/shared/model/order.model';
import { PreviewModalService } from 'app/stepper/preview/preview.service';
import { LegalDocument } from 'app/shared/model/legal-document.model';

@Component({
  selector: 'jhi-step',
  templateUrl: './step.component.html',
  styleUrls: ['step.scss']
})
export class StepComponent implements OnInit {
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
        'Contrat à durée déterminée' === this.legalDocument.shortName ||
        'Contrat à durée indéterminée' === this.legalDocument.shortName ||
        'Solde de tout compte' === this.legalDocument.shortName ||
        'Accord de résiliation amiable' === this.legalDocument.shortName ||
        'Lettre de démission' === this.legalDocument.shortName ||
        'Formulaire status' === this.legalDocument.shortName ||
        'Lettre de demission gérant' === this.legalDocument.shortName ||
        'Convocation assemblée générale ordinaire' === this.legalDocument.shortName ||
        'Accord de confidentialité' === this.legalDocument.shortName ||
        'Lettre de démission' === this.legalDocument.shortName ||
        'Caution solidaire' === this.legalDocument.shortName ||
        'Contrat de prestation de services' === this.legalDocument.shortName ||
        'Reconnaissance de dette' === this.legalDocument.shortName ||
        'Contrat de cession de créance' === this.legalDocument.shortName ||
        'Contrat de bail commercial' === this.legalDocument.shortName ||
        'Contrat de bail' === this.legalDocument.shortName ||
        'Approbation des comptes' === this.legalDocument.shortName ||
        'Quitance de loyer' === this.legalDocument.shortName ||
        'Contrat de sous-location' === this.legalDocument.shortName ||
        'Nantissement PS' === this.legalDocument.shortName ||
        'Nantissement F.D.C' === this.legalDocument.shortName ||
        'Nantissement meuble incorporel' === this.legalDocument.shortName ||
        'Nantissement equipement' === this.legalDocument.shortName ||
        "Contrat d'agent commercial" === this.legalDocument.shortName ||
        'Nantissement Actions' === this.legalDocument.shortName ||
        'Gage meuble corporel' === this.legalDocument.shortName ||
        'Formulaire statuts' === this.legalDocument.shortName ||
        "AGO SUARL PV constatation décès du CAC et nommination d'un nouveau CAC" === this.legalDocument.shortName ||
        "AGO SUARL PV nommination d'un nouveau CAC" === this.legalDocument.shortName ||
        'AGO SUARL PV renouvellement du mandat du CAC' === this.legalDocument.shortName ||
        "AGO SUARL PV nommination d'un nouveau gérant" === this.legalDocument.shortName ||
        'AGO SUARL PV renouvellement du mandat du gérant' === this.legalDocument.shortName ||
        "AGO SUARL PV démission du gérant et nommination d'un nouveau gérant" === this.legalDocument.shortName ||
        "AGO SUARL PV démission du gérant et nommination d'un nouveau gérant statutaire" === this.legalDocument.shortName ||
        "AGE SUARL PV révocation du gérant et nommination d'un nouveau gérant statutaire" === this.legalDocument.shortName ||
        "AGO SUARL PV révocation du gérant et nommination d'un nouveau gérant" === this.legalDocument.shortName ||
        "AGE SUARL PV nommination d'un nouveau gérant statutaire" === this.legalDocument.shortName ||
        'AGE SUARL PV renouvellement du mandat gérant statutaire' === this.legalDocument.shortName ||
        "AGO SUARL PV constatation décés du gérant et nommination d'un nouveau gérant" === this.legalDocument.shortName ||
        "AGE SUARL PV constatation décés du gérant et nommination d'un nouveau gérant statutaire" === this.legalDocument.shortName ||
        'pv révocation de gérant et nommination nouveau gérant' === this.legalDocument.shortName ||
        'pv démission de gérant et nommination nouveau gérant' === this.legalDocument.shortName ||
        'ago sarl pv constatation décés  de gérant et nommination nouveau gérant' === this.legalDocument.shortName ||
        'pv révocation de gérant et nommination nouveau gérant statutaire' === this.legalDocument.shortName ||
        'pv sarl nommination nouveau gérant statutaire' === this.legalDocument.shortName ||
        'pv sarl démission de gérant et nommination nouveau gérant statutaire' === this.legalDocument.shortName ||
        'age sarl pv constatation décés  de gérant et nommination nouveau gérant statutaire' === this.legalDocument.shortName ||
        'AGO SARL PV renouvellement du mandat du gérant' === this.legalDocument.shortName ||
        'AGO SARL PV renouvellement du mandat CAC' === this.legalDocument.shortName ||
        'AGO SARL PV nommination du nouveau CAC' === this.legalDocument.shortName ||
        'AGO SARL PV constatation du décés CAC et nommination du nouveau CAC' === this.legalDocument.shortName ||
        'AGE SARL PV renouvellement du mandat du gérant statutaire' === this.legalDocument.shortName ||
        'AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau avec distribution des dividendes' ===
          this.legalDocument.shortName ||
        'AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau' === this.legalDocument.shortName ||
        'AGO Approbation des états financiers avec résultat bénéficiaire et distribution des dividendes' === this.legalDocument.shortName ||
        "AGO SARL pv nomination d'un nouveau gérant à la constitution" === this.legalDocument.shortName ||
        'AGO Approbation des états Financiers avec Resultat déficitaire avec report à nouveau' === this.legalDocument.shortName ||
        'AGO Approbation des états Financiers avec Resultat déficitaire et distribution des dividendes' === this.legalDocument.shortName ||
        'AGO Approbation des états Financiers avec Resultat déficitaire avec report nouveau avec distribution des dividendes' ===
          this.legalDocument.shortName ||
        'Proces verbal augmentataion de capital par conversion de créance' === this.legalDocument.shortName ||
        'PV AGE Augmentataion de capital numéraire' === this.legalDocument.shortName
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
