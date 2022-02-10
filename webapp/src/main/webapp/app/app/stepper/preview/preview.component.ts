import { Component, OnInit } from '@angular/core';
import { PreviewModalService } from 'app/stepper/preview/preview.service';
import { ActivatedRoute } from '@angular/router';
import { ILegalDocument } from 'app/shared/model/legal-document.model';

@Component({
  selector: 'jhi-preview',
  templateUrl: './preview.component.html',
  styleUrls: ['./preview.component.scss']
})
export class PreviewComponent implements OnInit {
  legalDocument: ILegalDocument;

  constructor(protected previewModalService: PreviewModalService, protected route: ActivatedRoute) {}

  ngOnInit() {
    this.route.data.subscribe(({ legalDocument }) => {
      this.legalDocument = legalDocument;
    });
  }

  displayModal() {
    if (this.legalDocument.shortName === 'Contrat à durée déterminée') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Contrat à durée indéterminée') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Solde de tout compte') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Accord de résiliation amiable') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Lettre de démission') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Formulaire status') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Lettre de demission gérant') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Convocation assemblée générale ordinaire')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Accord de confidentialité') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Lettre de démission') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Caution solidaire') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Contrat de prestation de services')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Reconnaissance de dette') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Contrat de cession de créance') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Contrat de bail commercial') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Contrat de bail') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Approbation des comptes') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Concession de dette') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "Stage d'initiation à la vie professionnelle")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Quitance de loyer') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Contrat de sous-location') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Nantissement PS') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Nantissement F.D.C') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Nantissement meuble incorporel') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Nantissement equipement') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "Contrat d'agent commercial") this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Nantissement Actions') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Gage meuble corporel') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Formulaire statuts') this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGO SUARL PV constatation décès du CAC et nommination d'un nouveau CAC")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGO SUARL PV nommination d'un nouveau CAC")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'AGO SUARL PV renouvellement du mandat du CAC')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGO SUARL PV nommination d'un nouveau gérant")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'AGO SUARL PV renouvellement du mandat du gérant')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGO SUARL PV révocation du gérant et nommination d'un nouveau gérant")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGO SUARL PV démission du gérant et nommination d'un nouveau gérant")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGO SUARL PV démission du gérant et nommination d'un nouveau gérant statutaire")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGE SUARL PV révocation du gérant et nommination d'un nouveau gérant statutaire")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGE SUARL PV nommination d'un nouveau gérant statutaire")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'AGE SUARL PV renouvellement du mandat gérant statutaire')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGO SUARL PV constatation décés du gérant et nommination d'un nouveau gérant")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGE SUARL PV constatation décés du gérant et nommination d'un nouveau gérant statutaire")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'pv révocation de gérant et nommination nouveau gérant')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'pv démission de gérant et nommination nouveau gérant')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'ago sarl pv constatation décés  de gérant et nommination nouveau gérant')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'pv révocation de gérant et nommination nouveau gérant statutaire')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'pv sarl nommination nouveau gérant statutaire')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'pv sarl démission de gérant et nommination nouveau gérant statutaire')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'age sarl pv constatation décés  de gérant et nommination nouveau gérant statutaire')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'AGO SARL PV renouvellement du mandat du gérant')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'AGO SARL PV renouvellement du mandat CAC')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'AGO SARL PV nommination du nouveau CAC')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'AGO SARL PV constatation du décés CAC et nommination du nouveau CAC')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'AGE SARL PV renouvellement du mandat du gérant statutaire')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (
      this.legalDocument.shortName ===
      'AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau avec distribution des dividendes'
    )
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (
      this.legalDocument.shortName === 'AGO Approbation des états financiers avec résultat bénéficiaire et distribution des dividendes'
    )
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === "AGO SARL pv nomination d'un nouveau gérant à la constitution")
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'AGO Approbation des états Financiers avec Resultat déficitaire avec report à nouveau')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (
      this.legalDocument.shortName === 'AGO Approbation des états Financiers avec Resultat déficitaire et distribution des dividendes'
    )
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'Proces verbal augmentataion de capital par conversion de créance')
      this.previewModalService.open(this.legalDocument.shortName);
    else if (this.legalDocument.shortName === 'PV AGE Augmentataion de capital numéraire')
      this.previewModalService.open(this.legalDocument.shortName);
  }
  hasPreview(): boolean {
    if (this.legalDocument !== null && this.legalDocument !== undefined) {
      return 'CDD' === this.legalDocument.shortName;
    } else {
      return false;
    }
  }
}
