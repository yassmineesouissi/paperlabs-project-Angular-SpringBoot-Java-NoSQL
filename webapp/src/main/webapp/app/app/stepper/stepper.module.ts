import { NgModule } from '@angular/core';
import { InputComponent } from './input/input.component';
import { BlocComponent } from './bloc/bloc.component';
import { BlocArComponent } from './bloc-ar/bloc-ar.component';
import { StepComponent } from './step/step.component';
import { StepArComponent } from './step-ar/step-ar.component';
import { PaperlabsSharedModule } from 'app/shared/shared.module';
import { StepperComponent } from './stepper/stepper.component';
import { RouterModule } from '@angular/router';
import { stepperRoutes } from 'app/stepper/stepper.route';
import { GenerateDocumentComponent } from './generate-document/generate-document.component';
import { PaymentStepComponent } from './payment-step/payment-step.component';
import { JhiAutoFillModalComponent } from './auto-fill-modal/auto-fill-modal.component';
import { PreviewComponent } from './preview/preview.component';
import { PreviewModalComponent } from './preview/preview-modal/preview-modal.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { ComponentSoldeToutCompteComponent } from './preview/component-solde-tout-compte/component-solde-tout-compte.component';
import { ComponentCddComponent } from './preview/component-cdd/component-cdd.component';
import { ComponentFormulaireStatusComponent } from './preview/component-formulaire-status/component-formulaire-status.component';
import { ComponentDemissionGerantCorporateComponent } from './preview/component-demission-gerant-corporate/component-demission-gerant-corporate.component';
import { ComponentConvocationAgoComponent } from './preview/component-convocation-ago/component-convocation-ago.component';
import { ComponentAccordConfidentialiteComponent } from './preview/component-accord-confidentialite/component-accord-confidentialite.component';
import { ComponentDemissionCorporateComponent } from './preview/component-demission-corporate/component-demission-corporate.component';
import { ComponentCautionSolidaireComponent } from './preview/component-caution-solidaire/component-caution-solidaire.component';
import { ComponentPrestatioServiceComponent } from './preview/component-prestatio-service/component-prestatio-service.component';
import { ComponentReconnaissanceDetteComponent } from './preview/component-reconnaissance-dette/component-reconnaissance-dette.component';
import { ComponentCessionCreanceComponent } from './preview/component-cession-creance/component-cession-creance.component';
import { ComponentContratBailCommercialBauxComponent } from './preview/component-contrat-bail-commercial-baux/component-contrat-bail-commercial-baux.component';
import { ComponentAccordResiliationAmiableComponent } from './preview/component-accord-resiliation-amiable/component-accord-resiliation-amiable.component';
import { ComponentContratBailBauxComponent } from './preview/component-contrat-bail-baux/component-contrat-bail-baux.component';
import { ComponentApprobationDesComptesComponent } from './preview/component-approbation-des-comptes/component-approbation-des-comptes.component';
import { InputArComponent } from './input-ar/input-ar.component';
import { ComponentConcessionDetteArabComponent } from './preview/component-concession-dette-arab/component-concession-dette-arab.component';
import { ComponentSivpComponent } from './preview/component-sivp/component-sivp.component';
import { ComponentQuitanceLoyerComponent } from './preview/component-quitance-loyer/component-quitance-loyer.component';
import { ComponentContratSousLocationComponent } from './preview/component-contrat-sous-location/component-contrat-sous-location.component';
import { ComponentNantissementPsComponent } from './preview/component-nantissement-ps/component-nantissement-ps.component';
import { ComponentNantissementFDCComponent } from './preview/component-nantissement-fdc/component-nantissement-fdc.component';
import { ComponentNantissementMeubleCorporelComponent } from './preview/component-nantissement-meuble-corporel/component-nantissement-meuble-corporel.component';
import { ComponentNantissementEquipementComponent } from './preview/component-nantissement-equipement/component-nantissement-equipement.component';
import { ComponentContratAgentCommercialComponent } from './preview/component-contrat-agent-commercial/component-contrat-agent-commercial.component';
import { ComponentNantissementActionsComponent } from './preview/component-nantissement-actions/component-nantissement-actions.component';
import { ComponentGageMeubleCorporelComponent } from './preview/component-gage-meuble-corporel/component-gage-meuble-corporel.component';
import { ComponentSuarlConstataionNomminationNvCACComponent } from './preview/component-suarl-constataion-nommination-nv-cac/component-suarl-constataion-nommination-nv-cac.component';
import { ComponentSuarlPVNvCACComponent } from './preview/component-suarl-pv-nv-cac/component-suarl-pv-nv-cac.component';
import { ComponentRenouvellementCACComponent } from './preview/component-renouvellement-cac/component-renouvellement-cac.component';
import { ComponentAGOSuarlPvRenouvellementMondatGerantComponent } from './preview/component-ago-suarl-pv-renouvellement-mondat-gerant/component-ago-suarl-pv-renouvellement-mondat-gerant.component';
import { ComponentNominationNvGerComponent } from './preview/component-nomination-nv-ger/component-nomination-nv-ger.component';
import { ComponentSualPvTRervocationNomminationNvGerantComponent } from './preview/component-sual-pv-t-rervocation-nommination-nv-gerant/component-sual-pv-t-rervocation-nommination-nv-gerant.component';
import { AgoSuarlPvDemissionGerantNomminationNouveauGerantComponent } from './preview/ago-suarl-pv-demission-gerant-nommination-nouveau-gerant/ago-suarl-pv-demission-gerant-nommination-nouveau-gerant.component';
import { AgoSuarlPvDemissionGerantNomminationNouveauGerantStatutaireComponent } from './preview/ago-suarl-pv-demission-gerant-nommination-nouveau-gerant-statutaire/ago-suarl-pv-demission-gerant-nommination-nouveau-gerant-statutaire.component';
import { PvSuarlAgeRevocationGerantStatutaireComponent } from './preview/pv-suarl-age-revocation-gerant-statutaire/pv-suarl-age-revocation-gerant-statutaire.component';
import { PvAgeSuarlNomminationNouveauGerantStatutaireComponent } from './preview/pv-age-suarl-nommination-nouveau-gerant-statutaire/pv-age-suarl-nommination-nouveau-gerant-statutaire.component';
import { PvAgeSuarlRenouvellementMandatGerantStatutaireComponent } from './preview/pv-age-suarl-renouvellement-mandat-gerant-statutaire/pv-age-suarl-renouvellement-mandat-gerant-statutaire.component';
import { PvSuarlAgoConstatationNomminationGerantComponent } from './preview/pv-suarl-ago-constatation-nommination-gerant/pv-suarl-ago-constatation-nommination-gerant.component';
import { PvAgeSuarlConstatationDecesGerantNomminationNouveauGerantStatutaireComponent } from './preview/pv-age-suarl-constatation-deces-gerant-nommination-nouveau-gerant-statutaire/pv-age-suarl-constatation-deces-gerant-nommination-nouveau-gerant-statutaire.component';
import { PvSarlRevocationGerantNomminationNouveauGerantComponent } from './preview/pv-sarl-revocation-gerant-nommination-nouveau-gerant/pv-sarl-revocation-gerant-nommination-nouveau-gerant.component';

import { AgoApprobationEtatsFinanciersBenificairesReportNvDistribDividendesComponent } from './preview/ago-approbation-etats-financiers-benificaires-report-nv-distrib-dividendes/ago-approbation-etats-financiers-benificaires-report-nv-distrib-dividendes.component';

import { PvSarlDemissionGerantNomminationNouveauGerantComponent } from './preview/pv-sarl-demission-gerant-nommination-nouveau-gerant/pv-sarl-demission-gerant-nommination-nouveau-gerant.component';
import { AgoSarlPvConstatationDecesGerantNomminationNouveauGerantComponent } from './preview/ago-sarl-pv-constatation-deces-gerant-nommination-nouveau-gerant/ago-sarl-pv-constatation-deces-gerant-nommination-nouveau-gerant.component';
import { PvSarlRevocationGerantNomminationNouveauGerantStatutaireComponent } from './preview/pv-sarl-revocation-gerant-nommination-nouveau-gerant-statutaire/pv-sarl-revocation-gerant-nommination-nouveau-gerant-statutaire.component';
import { PvSarlNomminationNouveauGerantStatutaireComponent } from './preview/pv-sarl-nommination-nouveau-gerant-statutaire/pv-sarl-nommination-nouveau-gerant-statutaire.component';
import { AgeSarlPvDemissionGerantNomminationNouveauGerantStatutaireComponent } from './preview/age-sarl-pv-demission-gerant-nommination-nouveau-gerant-statutaire/age-sarl-pv-demission-gerant-nommination-nouveau-gerant-statutaire.component';
import { AgeSarlPvConstatationDecesGerantNomminationNouveauGerantStatutaireComponent } from './preview/age-sarl-pv-constatation-deces-gerant-nommination-nouveau-gerant-statutaire/age-sarl-pv-constatation-deces-gerant-nommination-nouveau-gerant-statutaire.component';
import { AgoSarlPvRenouvellementMandatGerantComponent } from './preview/ago-sarl-pv-renouvellement-mandat-gerant/ago-sarl-pv-renouvellement-mandat-gerant.component';
import { AgoSarlPvRenouvellementMandatCacComponent } from './preview/ago-sarl-pv-renouvellement-mandat-cac/ago-sarl-pv-renouvellement-mandat-cac.component';
import { AgoSarlPvNomminationNouveauCacComponent } from './preview/ago-sarl-pv-nommination-nouveau-cac/ago-sarl-pv-nommination-nouveau-cac.component';
import { AgoSarlPvConstatationDecesCacNomminationNouveauCacComponent } from './preview/ago-sarl-pv-constatation-deces-cac-nommination-nouveau-cac/ago-sarl-pv-constatation-deces-cac-nommination-nouveau-cac.component';
import { AgeSarlPvRenouvellementMandatGerantStatutaireComponent } from './preview/age-sarl-pv-renouvellement-mandat-gerant-statutaire/age-sarl-pv-renouvellement-mandat-gerant-statutaire.component';
import { ApprobationEtatsFinanciersResultatsBeneficiaireAvecReportANouveauComponent } from './preview/approbation-etats-financiers-resultats-beneficiaire-avec-report-a-nouveau/approbation-etats-financiers-resultats-beneficiaire-avec-report-a-nouveau.component';
import { AGOApprobationEtatsFinanciersResultatBeneficiaireDistributionDividendesComponent } from './preview/ago-approbation-etats-financiers-resultat-beneficiaire-distribution-dividendes/ago-approbation-etats-financiers-resultat-beneficiaire-distribution-dividendes.component';
import { AGOSARLPvNominationNouveauGerantALaConstitutionComponent } from './preview/ago-sarl-pv-nomination-nouveau-gerant-a-la-constitution/ago-sarl-pv-nomination-nouveau-gerant-a-la-constitution.component';
import { AgoSarlApprobationEtatFinancierDeficitaireReportNouveauComponent } from './preview/ago-sarl-approbation-etat-financier-deficitaire-report-nouveau/ago-sarl-approbation-etat-financier-deficitaire-report-nouveau.component';
import { SarlApprobationDeficitaireDistributionDividendesComponent } from './preview/sarl-approbation-deficitaire-distribution-dividendes/sarl-approbation-deficitaire-distribution-dividendes.component';
import { AgoSarlApprobationDeficitaireReportNouveauBeneficesDividendesComponent } from './preview/ago-sarl-approbation-deficitaire-report-nouveau-benefices-dividendes/ago-sarl-approbation-deficitaire-report-nouveau-benefices-dividendes.component';
import { SarlAugmentationCapitalConversionCreanceComponent } from './preview/sarl-augmentation-capital-conversion-creance/sarl-augmentation-capital-conversion-creance.component';
import { PvAgeAugmentationDeCapitalNumeraireComponent } from './preview/pv-age-augmentation-de-capital-numeraire/pv-age-augmentation-de-capital-numeraire.component';

@NgModule({
  declarations: [
    InputComponent,
    InputArComponent,
    BlocComponent,
    BlocArComponent,
    StepComponent,
    StepArComponent,
    StepperComponent,
    GenerateDocumentComponent,
    PaymentStepComponent,
    PreviewComponent,
    PreviewModalComponent,
    JhiAutoFillModalComponent,
    ComponentSivpComponent,
    ComponentCddComponent,
    ComponentSoldeToutCompteComponent,
    ComponentFormulaireStatusComponent,
    ComponentDemissionGerantCorporateComponent,
    ComponentConvocationAgoComponent,
    ComponentAccordConfidentialiteComponent,
    ComponentDemissionCorporateComponent,
    ComponentCautionSolidaireComponent,
    ComponentPrestatioServiceComponent,
    ComponentReconnaissanceDetteComponent,
    ComponentCessionCreanceComponent,
    ComponentContratBailCommercialBauxComponent,
    ComponentContratBailBauxComponent,
    ComponentAccordResiliationAmiableComponent,
    ComponentApprobationDesComptesComponent,
    ComponentConcessionDetteArabComponent,
    ComponentQuitanceLoyerComponent,
    ComponentContratSousLocationComponent,
    ComponentNantissementPsComponent,
    ComponentNantissementPsComponent,
    ComponentNantissementFDCComponent,
    ComponentNantissementFDCComponent,
    ComponentNantissementMeubleCorporelComponent,
    ComponentNantissementMeubleCorporelComponent,
    ComponentNantissementEquipementComponent,
    ComponentContratAgentCommercialComponent,
    ComponentNantissementActionsComponent,
    ComponentGageMeubleCorporelComponent,
    ComponentSuarlConstataionNomminationNvCACComponent,
    ComponentSuarlPVNvCACComponent,
    ComponentRenouvellementCACComponent,
    ComponentAGOSuarlPvRenouvellementMondatGerantComponent,
    ComponentNominationNvGerComponent,
    ComponentSualPvTRervocationNomminationNvGerantComponent,
    AgoSuarlPvDemissionGerantNomminationNouveauGerantComponent,
    AgoSuarlPvDemissionGerantNomminationNouveauGerantStatutaireComponent,
    PvSuarlAgeRevocationGerantStatutaireComponent,
    PvAgeSuarlNomminationNouveauGerantStatutaireComponent,
    PvAgeSuarlRenouvellementMandatGerantStatutaireComponent,
    PvSuarlAgoConstatationNomminationGerantComponent,
    PvAgeSuarlConstatationDecesGerantNomminationNouveauGerantStatutaireComponent,
    PvSarlRevocationGerantNomminationNouveauGerantComponent,
    AgoApprobationEtatsFinanciersBenificairesReportNvDistribDividendesComponent,
    PvSarlDemissionGerantNomminationNouveauGerantComponent,
    AgoSarlPvConstatationDecesGerantNomminationNouveauGerantComponent,
    PvSarlRevocationGerantNomminationNouveauGerantStatutaireComponent,
    PvSarlNomminationNouveauGerantStatutaireComponent,
    AgeSarlPvDemissionGerantNomminationNouveauGerantStatutaireComponent,
    AgeSarlPvConstatationDecesGerantNomminationNouveauGerantStatutaireComponent,
    AgoSarlPvRenouvellementMandatGerantComponent,
    AgoSarlPvRenouvellementMandatCacComponent,
    AgoSarlPvNomminationNouveauCacComponent,
    AgoSarlPvConstatationDecesCacNomminationNouveauCacComponent,
    AgeSarlPvRenouvellementMandatGerantStatutaireComponent,
    ApprobationEtatsFinanciersResultatsBeneficiaireAvecReportANouveauComponent,
    AGOApprobationEtatsFinanciersResultatBeneficiaireDistributionDividendesComponent,
    AGOSARLPvNominationNouveauGerantALaConstitutionComponent,
    AgoSarlApprobationEtatFinancierDeficitaireReportNouveauComponent,
    SarlApprobationDeficitaireDistributionDividendesComponent,
    AgoSarlApprobationDeficitaireReportNouveauBeneficesDividendesComponent,
    SarlAugmentationCapitalConversionCreanceComponent,
    PvAgeAugmentationDeCapitalNumeraireComponent
  ],
  exports: [InputComponent, InputArComponent, BlocComponent, BlocArComponent, StepComponent, StepArComponent, StepperComponent],
  imports: [PaperlabsSharedModule, RouterModule.forChild(stepperRoutes), BsDatepickerModule.forRoot()],
  entryComponents: [
    PreviewModalComponent,
    JhiAutoFillModalComponent,
    ComponentDemissionGerantCorporateComponent,
    ComponentApprobationDesComptesComponent,
    ComponentAccordResiliationAmiableComponent,
    ComponentContratBailCommercialBauxComponent,
    ComponentConcessionDetteArabComponent,
    ComponentCessionCreanceComponent,
    ComponentSivpComponent,
    ComponentReconnaissanceDetteComponent,
    ComponentPrestatioServiceComponent,
    ComponentCautionSolidaireComponent,
    ComponentDemissionCorporateComponent,
    ComponentAccordConfidentialiteComponent,
    ComponentConvocationAgoComponent,
    ComponentFormulaireStatusComponent,
    ComponentCddComponent,
    ComponentSoldeToutCompteComponent,
    ComponentContratBailBauxComponent,
    ComponentQuitanceLoyerComponent,
    ComponentContratSousLocationComponent,
    ComponentNantissementPsComponent,
    ComponentNantissementFDCComponent,
    ComponentNantissementMeubleCorporelComponent,
    ComponentNantissementEquipementComponent,
    ComponentContratAgentCommercialComponent,
    ComponentNantissementActionsComponent,
    ComponentGageMeubleCorporelComponent,
    ComponentSuarlConstataionNomminationNvCACComponent,
    ComponentSuarlPVNvCACComponent,
    ComponentRenouvellementCACComponent,
    ComponentAGOSuarlPvRenouvellementMondatGerantComponent,
    ComponentNominationNvGerComponent,
    ComponentSualPvTRervocationNomminationNvGerantComponent,
    AgoSuarlPvDemissionGerantNomminationNouveauGerantComponent,
    AgoSuarlPvDemissionGerantNomminationNouveauGerantStatutaireComponent,
    PvSuarlAgeRevocationGerantStatutaireComponent,
    PvAgeSuarlNomminationNouveauGerantStatutaireComponent,
    PvAgeSuarlRenouvellementMandatGerantStatutaireComponent,
    PvSuarlAgoConstatationNomminationGerantComponent,
    PvAgeSuarlConstatationDecesGerantNomminationNouveauGerantStatutaireComponent,

    PvSarlRevocationGerantNomminationNouveauGerantComponent,

    PvSarlRevocationGerantNomminationNouveauGerantComponent,
    PvSarlDemissionGerantNomminationNouveauGerantComponent,
    AgoSarlPvConstatationDecesGerantNomminationNouveauGerantComponent,
    PvSarlRevocationGerantNomminationNouveauGerantStatutaireComponent,
    PvSarlNomminationNouveauGerantStatutaireComponent,
    AgeSarlPvDemissionGerantNomminationNouveauGerantStatutaireComponent,
    AgeSarlPvConstatationDecesGerantNomminationNouveauGerantStatutaireComponent,
    AgoSarlPvRenouvellementMandatGerantComponent,
    AgoSarlPvRenouvellementMandatCacComponent,
    AgoSarlPvNomminationNouveauCacComponent,
    AgoSarlPvConstatationDecesCacNomminationNouveauCacComponent,
    AgeSarlPvRenouvellementMandatGerantStatutaireComponent,
    AgoApprobationEtatsFinanciersBenificairesReportNvDistribDividendesComponent,
    AGOApprobationEtatsFinanciersResultatBeneficiaireDistributionDividendesComponent,
    ApprobationEtatsFinanciersResultatsBeneficiaireAvecReportANouveauComponent,
    AGOSARLPvNominationNouveauGerantALaConstitutionComponent,
    AgoSarlApprobationEtatFinancierDeficitaireReportNouveauComponent,
    SarlApprobationDeficitaireDistributionDividendesComponent,
    AgoSarlApprobationDeficitaireReportNouveauBeneficesDividendesComponent,
    SarlAugmentationCapitalConversionCreanceComponent,
    PvAgeAugmentationDeCapitalNumeraireComponent
  ]
})
export class StepperModule {}
