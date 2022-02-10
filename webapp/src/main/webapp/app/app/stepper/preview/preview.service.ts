import { Injectable } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { PreviewModalComponent } from 'app/stepper/preview/preview-modal/preview-modal.component';
import { ComponentSoldeToutCompteComponent } from './component-solde-tout-compte/component-solde-tout-compte.component';
import { ComponentCddComponent } from './component-cdd/component-cdd.component';
import { ComponentFormulaireStatusComponent } from './component-formulaire-status/component-formulaire-status.component';
import { ComponentDemissionGerantCorporateComponent } from './component-demission-gerant-corporate/component-demission-gerant-corporate.component';
import { ComponentConvocationAgoComponent } from './component-convocation-ago/component-convocation-ago.component';
import { ComponentAccordConfidentialiteComponent } from './component-accord-confidentialite/component-accord-confidentialite.component';
import { ComponentDemissionCorporateComponent } from './component-demission-corporate/component-demission-corporate.component';
import { ComponentCautionSolidaireComponent } from './component-caution-solidaire/component-caution-solidaire.component';
import { ComponentPrestatioServiceComponent } from './component-prestatio-service/component-prestatio-service.component';
import { ComponentReconnaissanceDetteComponent } from './component-reconnaissance-dette/component-reconnaissance-dette.component';
import { ComponentCessionCreanceComponent } from './component-cession-creance/component-cession-creance.component';
import { ComponentContratBailCommercialBauxComponent } from './component-contrat-bail-commercial-baux/component-contrat-bail-commercial-baux.component';
import { ComponentAccordResiliationAmiableComponent } from './component-accord-resiliation-amiable/component-accord-resiliation-amiable.component';
import { ComponentContratBailBauxComponent } from './component-contrat-bail-baux/component-contrat-bail-baux.component';
import { ComponentApprobationDesComptesComponent } from './component-approbation-des-comptes/component-approbation-des-comptes.component';
import { ComponentConcessionDetteArabComponent } from './component-concession-dette-arab/component-concession-dette-arab.component';
import { ComponentSivpComponent } from './component-sivp/component-sivp.component';
import { ComponentQuitanceLoyerComponent } from './component-quitance-loyer/component-quitance-loyer.component';
import { ComponentContratSousLocationComponent } from './component-contrat-sous-location/component-contrat-sous-location.component';
import { ComponentNantissementPsComponent } from './component-nantissement-ps/component-nantissement-ps.component';
import { ComponentNantissementFDCComponent } from './component-nantissement-fdc/component-nantissement-fdc.component';
import { ComponentNantissementMeubleCorporelComponent } from './component-nantissement-meuble-corporel/component-nantissement-meuble-corporel.component';
import { ComponentNantissementEquipementComponent } from './component-nantissement-equipement/component-nantissement-equipement.component';
import { ComponentContratAgentCommercialComponent } from './component-contrat-agent-commercial/component-contrat-agent-commercial.component';
import { ComponentNantissementActionsComponent } from './component-nantissement-actions/component-nantissement-actions.component';
import { ComponentGageMeubleCorporelComponent } from './component-gage-meuble-corporel/component-gage-meuble-corporel.component';
import { ComponentSuarlConstataionNomminationNvCACComponent } from './component-suarl-constataion-nommination-nv-cac/component-suarl-constataion-nommination-nv-cac.component';
import { ComponentSuarlPVNvCACComponent } from './component-suarl-pv-nv-cac/component-suarl-pv-nv-cac.component';
import { ComponentRenouvellementCACComponent } from './component-renouvellement-cac/component-renouvellement-cac.component';

import { ComponentAGOSuarlPvRenouvellementMondatGerantComponent } from './component-ago-suarl-pv-renouvellement-mondat-gerant/component-ago-suarl-pv-renouvellement-mondat-gerant.component';
import { ComponentNominationNvGerComponent } from './component-nomination-nv-ger/component-nomination-nv-ger.component';
import { ComponentSualPvTRervocationNomminationNvGerantComponent } from './component-sual-pv-t-rervocation-nommination-nv-gerant/component-sual-pv-t-rervocation-nommination-nv-gerant.component';
import { AgoSuarlPvDemissionGerantNomminationNouveauGerantComponent } from './ago-suarl-pv-demission-gerant-nommination-nouveau-gerant/ago-suarl-pv-demission-gerant-nommination-nouveau-gerant.component';
import { AgoSuarlPvDemissionGerantNomminationNouveauGerantStatutaireComponent } from './ago-suarl-pv-demission-gerant-nommination-nouveau-gerant-statutaire/ago-suarl-pv-demission-gerant-nommination-nouveau-gerant-statutaire.component';
import { PvSuarlAgeRevocationGerantStatutaireComponent } from './pv-suarl-age-revocation-gerant-statutaire/pv-suarl-age-revocation-gerant-statutaire.component';
import { PvAgeSuarlNomminationNouveauGerantStatutaireComponent } from './pv-age-suarl-nommination-nouveau-gerant-statutaire/pv-age-suarl-nommination-nouveau-gerant-statutaire.component';
import { PvAgeSuarlRenouvellementMandatGerantStatutaireComponent } from './pv-age-suarl-renouvellement-mandat-gerant-statutaire/pv-age-suarl-renouvellement-mandat-gerant-statutaire.component';

import { PvSuarlAgoConstatationNomminationGerantComponent } from './pv-suarl-ago-constatation-nommination-gerant/pv-suarl-ago-constatation-nommination-gerant.component';
import { PvAgeSuarlConstatationDecesGerantNomminationNouveauGerantStatutaireComponent } from './pv-age-suarl-constatation-deces-gerant-nommination-nouveau-gerant-statutaire/pv-age-suarl-constatation-deces-gerant-nommination-nouveau-gerant-statutaire.component';
import { PvSarlRevocationGerantNomminationNouveauGerantComponent } from './pv-sarl-revocation-gerant-nommination-nouveau-gerant/pv-sarl-revocation-gerant-nommination-nouveau-gerant.component';
import { PvSarlDemissionGerantNomminationNouveauGerantComponent } from './pv-sarl-demission-gerant-nommination-nouveau-gerant/pv-sarl-demission-gerant-nommination-nouveau-gerant.component';
import { PvSarlRevocationGerantNomminationNouveauGerantStatutaireComponent } from './pv-sarl-revocation-gerant-nommination-nouveau-gerant-statutaire/pv-sarl-revocation-gerant-nommination-nouveau-gerant-statutaire.component';
import { PvSarlNomminationNouveauGerantStatutaireComponent } from './pv-sarl-nommination-nouveau-gerant-statutaire/pv-sarl-nommination-nouveau-gerant-statutaire.component';
import { AgeSarlPvConstatationDecesGerantNomminationNouveauGerantStatutaireComponent } from './age-sarl-pv-constatation-deces-gerant-nommination-nouveau-gerant-statutaire/age-sarl-pv-constatation-deces-gerant-nommination-nouveau-gerant-statutaire.component';
import { AgoSarlPvRenouvellementMandatGerantComponent } from './ago-sarl-pv-renouvellement-mandat-gerant/ago-sarl-pv-renouvellement-mandat-gerant.component';
import { AgoSarlPvRenouvellementMandatCacComponent } from './ago-sarl-pv-renouvellement-mandat-cac/ago-sarl-pv-renouvellement-mandat-cac.component';
import { AgoSarlPvNomminationNouveauCacComponent } from './ago-sarl-pv-nommination-nouveau-cac/ago-sarl-pv-nommination-nouveau-cac.component';
import { AgoSarlPvConstatationDecesCacNomminationNouveauCacComponent } from './ago-sarl-pv-constatation-deces-cac-nommination-nouveau-cac/ago-sarl-pv-constatation-deces-cac-nommination-nouveau-cac.component';
import { AgeSarlPvRenouvellementMandatGerantStatutaireComponent } from './age-sarl-pv-renouvellement-mandat-gerant-statutaire/age-sarl-pv-renouvellement-mandat-gerant-statutaire.component';
import { AgoApprobationEtatsFinanciersBenificairesReportNvDistribDividendesComponent } from './ago-approbation-etats-financiers-benificaires-report-nv-distrib-dividendes/ago-approbation-etats-financiers-benificaires-report-nv-distrib-dividendes.component';
import { ApprobationEtatsFinanciersResultatsBeneficiaireAvecReportANouveauComponent } from './approbation-etats-financiers-resultats-beneficiaire-avec-report-a-nouveau/approbation-etats-financiers-resultats-beneficiaire-avec-report-a-nouveau.component';
import { AGOApprobationEtatsFinanciersResultatBeneficiaireDistributionDividendesComponent } from './ago-approbation-etats-financiers-resultat-beneficiaire-distribution-dividendes/ago-approbation-etats-financiers-resultat-beneficiaire-distribution-dividendes.component';
import { AGOSARLPvNominationNouveauGerantALaConstitutionComponent } from './ago-sarl-pv-nomination-nouveau-gerant-a-la-constitution/ago-sarl-pv-nomination-nouveau-gerant-a-la-constitution.component';
import { AgoSarlApprobationEtatFinancierDeficitaireReportNouveauComponent } from './ago-sarl-approbation-etat-financier-deficitaire-report-nouveau/ago-sarl-approbation-etat-financier-deficitaire-report-nouveau.component';
import { SarlApprobationDeficitaireDistributionDividendesComponent } from './sarl-approbation-deficitaire-distribution-dividendes/sarl-approbation-deficitaire-distribution-dividendes.component';
import { AgoSarlApprobationDeficitaireReportNouveauBeneficesDividendesComponent } from './ago-sarl-approbation-deficitaire-report-nouveau-benefices-dividendes/ago-sarl-approbation-deficitaire-report-nouveau-benefices-dividendes.component';
import { SarlAugmentationCapitalConversionCreanceComponent } from './sarl-augmentation-capital-conversion-creance/sarl-augmentation-capital-conversion-creance.component';
import { PvAgeAugmentationDeCapitalNumeraireComponent } from './pv-age-augmentation-de-capital-numeraire/pv-age-augmentation-de-capital-numeraire.component';

@Injectable({ providedIn: 'root' })
export class PreviewModalService {
  private isOpen = false;
  constructor(private modalService: NgbModal) {}

  open(legalDocumentShortName: string): NgbModalRef {
    if (this.isOpen) {
      return;
    }
    this.isOpen = true;
    let modalRef: NgbModalRef;

    if (legalDocumentShortName === 'Contrat à durée indéterminée') {
      modalRef = this.modalService.open(PreviewModalComponent);
    } else if (legalDocumentShortName === 'Contrat à durée déterminée') {
      modalRef = this.modalService.open(ComponentCddComponent);
    } else if (legalDocumentShortName === 'Solde de tout compte') {
      modalRef = this.modalService.open(ComponentSoldeToutCompteComponent);
    } /* else if (legalDocumentShortName === 'Formulaire status') {
      modalRef = this.modalService.open(ComponentFormulaireStatusComponent);
    }  */ else if (
      legalDocumentShortName === 'Lettre de demission gérant'
    ) {
      modalRef = this.modalService.open(ComponentDemissionGerantCorporateComponent);
    } else if (legalDocumentShortName === 'Convocation assemblée générale ordinaire') {
      modalRef = this.modalService.open(ComponentConvocationAgoComponent);
    } else if (legalDocumentShortName === 'Accord de confidentialité') {
      modalRef = this.modalService.open(ComponentAccordConfidentialiteComponent);
    } else if (legalDocumentShortName === 'Lettre de démission') {
      modalRef = this.modalService.open(ComponentDemissionCorporateComponent);
    } else if (legalDocumentShortName === 'Caution solidaire') {
      modalRef = this.modalService.open(ComponentCautionSolidaireComponent);
    } else if (legalDocumentShortName === 'Contrat de prestation de services') {
      modalRef = this.modalService.open(ComponentPrestatioServiceComponent);
    } else if (legalDocumentShortName === 'Reconnaissance de dette') {
      modalRef = this.modalService.open(ComponentReconnaissanceDetteComponent);
    } else if (legalDocumentShortName === 'Contrat de cession de créance') {
      modalRef = this.modalService.open(ComponentCessionCreanceComponent);
    } else if (legalDocumentShortName === 'Contrat de bail commercial') {
      modalRef = this.modalService.open(ComponentContratBailCommercialBauxComponent);
    } else if (legalDocumentShortName === 'Accord de résiliation amiable') {
      modalRef = this.modalService.open(ComponentAccordResiliationAmiableComponent);
    } else if (legalDocumentShortName === 'Contrat de bail') {
      modalRef = this.modalService.open(ComponentContratBailBauxComponent);
    } else if (legalDocumentShortName === 'Approbation des comptes') {
      modalRef = this.modalService.open(ComponentApprobationDesComptesComponent);
    } else if (legalDocumentShortName === 'Concession de dette') {
      modalRef = this.modalService.open(ComponentConcessionDetteArabComponent);
    } else if (legalDocumentShortName === "Stage d'initiation à la vie professionnelle") {
      modalRef = this.modalService.open(ComponentSivpComponent);
    } else if (legalDocumentShortName === 'Quitance de loyer') {
      modalRef = this.modalService.open(ComponentQuitanceLoyerComponent);
    } else if (legalDocumentShortName === 'Contrat de sous-location') {
      modalRef = this.modalService.open(ComponentContratSousLocationComponent);
    } else if (legalDocumentShortName === 'Nantissement PS') {
      modalRef = this.modalService.open(ComponentNantissementPsComponent);
    } else if (legalDocumentShortName === 'Nantissement F.D.C') {
      modalRef = this.modalService.open(ComponentNantissementFDCComponent);
    } else if (legalDocumentShortName === 'Nantissement meuble incorporel') {
      modalRef = this.modalService.open(ComponentNantissementMeubleCorporelComponent);
    } else if (legalDocumentShortName === 'Nantissement equipement') {
      modalRef = this.modalService.open(ComponentNantissementEquipementComponent);
    } else if (legalDocumentShortName === "Contrat d'agent commercial") {
      modalRef = this.modalService.open(ComponentContratAgentCommercialComponent);
    } else if (legalDocumentShortName === 'Nantissement Actions') {
      modalRef = this.modalService.open(ComponentNantissementActionsComponent);
    } else if (legalDocumentShortName === 'Gage meuble corporel') {
      modalRef = this.modalService.open(ComponentGageMeubleCorporelComponent);
    } else if (legalDocumentShortName === 'Formulaire statuts') {
      modalRef = this.modalService.open(ComponentFormulaireStatusComponent);
    } else if (legalDocumentShortName === "AGO SUARL PV constatation décès du CAC et nommination d'un nouveau CAC") {
      modalRef = this.modalService.open(ComponentSuarlConstataionNomminationNvCACComponent);
    } else if (legalDocumentShortName === "AGO SUARL PV nommination d'un nouveau CAC") {
      modalRef = this.modalService.open(ComponentSuarlPVNvCACComponent);
    } else if (legalDocumentShortName === 'AGO SUARL PV renouvellement du mandat du CAC') {
      modalRef = this.modalService.open(ComponentRenouvellementCACComponent);
    } else if (legalDocumentShortName === 'AGO SUARL PV renouvellement du mandat du gérant') {
      modalRef = this.modalService.open(ComponentAGOSuarlPvRenouvellementMondatGerantComponent);
    } else if (legalDocumentShortName === "AGO SUARL PV nommination d'un nouveau gérant") {
      modalRef = this.modalService.open(ComponentNominationNvGerComponent);
    } else if (legalDocumentShortName === "AGO SUARL PV révocation du gérant et nommination d'un nouveau gérant") {
      modalRef = this.modalService.open(ComponentSualPvTRervocationNomminationNvGerantComponent);
    } else if (legalDocumentShortName === "AGO SUARL PV démission du gérant et nommination d'un nouveau gérant") {
      modalRef = this.modalService.open(AgoSuarlPvDemissionGerantNomminationNouveauGerantComponent);
    } else if (legalDocumentShortName === "AGO SUARL PV démission du gérant et nommination d'un nouveau gérant statutaire") {
      modalRef = this.modalService.open(AgoSuarlPvDemissionGerantNomminationNouveauGerantStatutaireComponent);
    } else if (legalDocumentShortName === "AGE SUARL PV révocation du gérant et nommination d'un nouveau gérant statutaire") {
      modalRef = this.modalService.open(PvSuarlAgeRevocationGerantStatutaireComponent);
    } else if (legalDocumentShortName === "AGE SUARL PV révocation du gérant et nommination d'un nouveau gérant statutaire") {
      modalRef = this.modalService.open(PvSuarlAgeRevocationGerantStatutaireComponent);
    } else if (legalDocumentShortName === "AGE SUARL PV nommination d'un nouveau gérant statutaire") {
      modalRef = this.modalService.open(PvAgeSuarlNomminationNouveauGerantStatutaireComponent);
    } else if (legalDocumentShortName === 'AGE SUARL PV renouvellement du mandat gérant statutaire') {
      modalRef = this.modalService.open(PvAgeSuarlRenouvellementMandatGerantStatutaireComponent);
    } else if (legalDocumentShortName === "AGO SUARL PV constatation décés du gérant et nommination d'un nouveau gérant") {
      modalRef = this.modalService.open(PvSuarlAgoConstatationNomminationGerantComponent);
    } else if (legalDocumentShortName === "AGE SUARL PV constatation décés du gérant et nommination d'un nouveau gérant statutaire") {
      modalRef = this.modalService.open(PvAgeSuarlConstatationDecesGerantNomminationNouveauGerantStatutaireComponent);
    } else if (legalDocumentShortName === 'pv révocation de gérant et nommination nouveau gérant') {
      modalRef = this.modalService.open(PvSarlRevocationGerantNomminationNouveauGerantComponent);
    } else if (legalDocumentShortName === 'pv démission de gérant et nommination nouveau gérant') {
      modalRef = this.modalService.open(PvSarlDemissionGerantNomminationNouveauGerantComponent);
    } else if (legalDocumentShortName === 'ago sarl pv constatation décés  de gérant et nommination nouveau gérant') {
      modalRef = this.modalService.open(PvSarlDemissionGerantNomminationNouveauGerantComponent);
    } else if (legalDocumentShortName === 'pv révocation de gérant et nommination nouveau gérant statutaire') {
      modalRef = this.modalService.open(PvSarlRevocationGerantNomminationNouveauGerantStatutaireComponent);
    } else if (legalDocumentShortName === 'pv sarl nommination nouveau gérant statutaire') {
      modalRef = this.modalService.open(PvSarlNomminationNouveauGerantStatutaireComponent);
    } else if (legalDocumentShortName === 'pv sarl démission de gérant et nommination nouveau gérant statutaire') {
      modalRef = this.modalService.open(PvSarlNomminationNouveauGerantStatutaireComponent);
    } else if (legalDocumentShortName === 'age sarl pv constatation décés  de gérant et nommination nouveau gérant statutaire') {
      modalRef = this.modalService.open(AgeSarlPvConstatationDecesGerantNomminationNouveauGerantStatutaireComponent);
    } else if (legalDocumentShortName === 'AGO SARL PV renouvellement du mandat du gérant') {
      modalRef = this.modalService.open(AgoSarlPvRenouvellementMandatGerantComponent);
    } else if (legalDocumentShortName === 'AGO SARL PV renouvellement du mandat CAC') {
      modalRef = this.modalService.open(AgoSarlPvRenouvellementMandatCacComponent);
    } else if (legalDocumentShortName === 'AGO SARL PV nommination du nouveau CAC') {
      modalRef = this.modalService.open(AgoSarlPvNomminationNouveauCacComponent);
    } else if (legalDocumentShortName === 'AGO SARL PV constatation du décés CAC et nommination du nouveau CAC') {
      modalRef = this.modalService.open(AgoSarlPvConstatationDecesCacNomminationNouveauCacComponent);
    } else if (legalDocumentShortName === 'AGE SARL PV renouvellement du mandat du gérant statutaire') {
      modalRef = this.modalService.open(AgeSarlPvRenouvellementMandatGerantStatutaireComponent);
    } else if (
      legalDocumentShortName ===
      'AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau avec distribution des dividendes'
    ) {
      modalRef = this.modalService.open(AgoApprobationEtatsFinanciersBenificairesReportNvDistribDividendesComponent);
    } else if (legalDocumentShortName === 'AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau') {
      modalRef = this.modalService.open(ApprobationEtatsFinanciersResultatsBeneficiaireAvecReportANouveauComponent);
    } else if (
      legalDocumentShortName === 'AGO Approbation des états financiers avec résultat bénéficiaire et distribution des dividendes'
    ) {
      modalRef = this.modalService.open(AGOApprobationEtatsFinanciersResultatBeneficiaireDistributionDividendesComponent);
    } else if (legalDocumentShortName === "AGO SARL pv nomination d'un nouveau gérant à la constitution") {
      modalRef = this.modalService.open(AGOSARLPvNominationNouveauGerantALaConstitutionComponent);
    } else if (legalDocumentShortName === 'AGO Approbation des états Financiers avec Resultat déficitaire avec report à nouveau') {
      modalRef = this.modalService.open(AgoSarlApprobationEtatFinancierDeficitaireReportNouveauComponent);
    } else if (legalDocumentShortName === 'AGO Approbation des états Financiers avec Resultat déficitaire et distribution des dividendes') {
      modalRef = this.modalService.open(SarlApprobationDeficitaireDistributionDividendesComponent);
    } else if (
      legalDocumentShortName ===
      'AGO Approbation des états Financiers avec Resultat déficitaire avec report nouveau avec distribution des dividendes'
    ) {
      modalRef = this.modalService.open(AgoSarlApprobationDeficitaireReportNouveauBeneficesDividendesComponent);
    } else if (legalDocumentShortName === 'Proces verbal augmentataion de capital par conversion de créance') {
      modalRef = this.modalService.open(SarlAugmentationCapitalConversionCreanceComponent);
    } else if (legalDocumentShortName === 'PV AGE Augmentataion de capital numéraire') {
      modalRef = this.modalService.open(PvAgeAugmentationDeCapitalNumeraireComponent);
    }
    modalRef.result.then(
      result => {
        this.isOpen = false;
      },
      reason => {
        this.isOpen = false;
      }
    );
    return modalRef;
  }
}
