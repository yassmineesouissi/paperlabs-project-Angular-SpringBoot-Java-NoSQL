
package com.apeiron.paperlabs.config.dbmigrations.paperlabs;

import com.apeiron.paperlabs.config.dbmigrations.paperlabs.constants.AuthorsConstants;
import com.apeiron.paperlabs.domain.Company;
import com.apeiron.paperlabs.domain.DescriptionSection;
import com.apeiron.paperlabs.domain.Employer;
import com.apeiron.paperlabs.domain.LegalDocument;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.Instant;
import java.util.*;

/**
 * Creates the initial LegalDocument entities.
 */
@ChangeLog(order = "01")
public class LegalDocumentMigration {


    @ChangeSet(order = "001", author = AuthorsConstants.RHIMI_RAMI , id = "001-addAccordDeConfidentialiteLegalDocument")
    public void addAccordDeConfidentialiteLegalDocument(MongoTemplate mongoTemplate) {
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyPrestataireAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> companyBeneficiaireAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();

        companyPrestataireAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé_prestataire");
        companyPrestataireAutoFillInputIdsByFieldName.put("companyCapital", "input_capital_social_de_la_societé_prestataire");
        companyPrestataireAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé_prestataire");
        companyPrestataireAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé_prestataire");
        companyPrestataireAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé_prestataire");
        companyPrestataireAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé_prestataire");
        companiesAutoFillInputIdsByFieldName.add(companyPrestataireAutoFillInputIdsByFieldName);

        companyBeneficiaireAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé_bénéficiaire");
        companyBeneficiaireAutoFillInputIdsByFieldName.put("companyCapital", "input_capital_social_de_la_societé_bénéficiaire");
        companyBeneficiaireAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé_bénéficiaire");
        companyBeneficiaireAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé_bénéficiaire");
        companyBeneficiaireAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé_bénéficiaire");
        companyBeneficiaireAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé_bénéficiaire");

        companiesAutoFillInputIdsByFieldName.add(companyBeneficiaireAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02aff8");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setShortName("Accord de confidentialité");
        legalDocument.setFullName("Accord de confidentialité");
        legalDocument.setKeywords("Acc Conf");
        legalDocument.setDescription("MODÈLE D'ACCORD DE CONFIDENTIALITE");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("accord_de_confidentialite_docx_model.docx");
        legalDocument.setStepperConfigFilePath("accord_de_confidentialite_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("accord_de_confidentialite_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);

      
        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }

   
   @ChangeSet(order = "002", author = AuthorsConstants.RHIMI_RAMI , id = "002-addCDDLegalDocument")
    public void addCDDLegalDocument(MongoTemplate mongoTemplate) {     
	   LegalDocument legalDocument;

       List<DescriptionSection> descriptionSections = new ArrayList<>();
       DescriptionSection descriptionSection;
       List<String> autoFillConcernedEntities = new ArrayList<>();
       Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
       Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
       List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
       List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

       companyAutoFillInputIdsByFieldName.put("companyName", "input_denomination_personne_morale_tunisienne_caution");
       companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_personne_morale_tunisienne_caution");
       companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nom_personne_morale_tunisienne_caution");
       companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_siege_personne_morale_tunisienne_caution");
       companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

       employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_numero_cin_personne_physique_tunisienne_caution");
       employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_personne_physique_tunisienne_caution");
       employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_personne_physique_tunisienne_caution");
       employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

       autoFillConcernedEntities.add(Company.class.getSimpleName());
       autoFillConcernedEntities.add(Employer.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa97");
        legalDocument.setShortName("Contrat à durée déterminée");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Contrat à durée déterminée");
        legalDocument.setKeywords("droit de travail cdd");
        legalDocument.setDescription("Contrat à durée déterminée");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("cdd_docx_model.docx");
        legalDocument.setStepperConfigFilePath("cdd_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("cdd_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);

        descriptionSection = new DescriptionSection();
        descriptionSection.setTitle("Création de CDD:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre CDD en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    } 
    @ChangeSet(order = "003", author = AuthorsConstants.RHIMI_RAMI , id = "003-addStatusCDILegalDocument")
    public void addStatusCDILegalDocument(MongoTemplate mongoTemplate) {     
    	LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa99");
        legalDocument.setShortName("Contrat à durée indéterminée");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Contrat à durée indéterminée");
        legalDocument.setKeywords("droit de travail cdi");
        legalDocument.setDescription("Contrat à durée indéterminée");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("status_cdi_docx_model.docx");
        legalDocument.setStepperConfigFilePath("status_cdi_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("status_cdi_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        
        descriptionSection = new DescriptionSection();
        descriptionSection.setTitle("Création de CDI:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre CDI en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }
   @ChangeSet(order = "004", author = AuthorsConstants.RHIMI_RAMI , id = "004-addSIVPLegalDocument")
    public void addCIVPLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());


        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa95");
        legalDocument.setShortName("Stage d'initiation à la vie professionnelle");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("SIVP_ar");
        legalDocument.setKeywords("droit de travail sivp");
        legalDocument.setDescription("MODÈLE DE STAGE D'INITIATION A LA VIE PROFESSIONNELLE");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("civp_docx_model.docx");
        legalDocument.setStepperConfigFilePath("civp_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("civp_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);

        descriptionSection = new DescriptionSection();
        descriptionSection.setTitle("Création de CIVP:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre CIVP en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    } 
    @ChangeSet(order = "005", author = AuthorsConstants.RHIMI_RAMI , id = "005-addSoldeCompteLegalDocument")
    public void addSoldeCompteLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());
       
        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa90");
        legalDocument.setShortName("Solde de tout compte");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Solde de tout compte");
        legalDocument.setKeywords(" SOLDE DE TOUT COMPTE créer droit de travail");
        legalDocument.setDescription("MODÈLE Solde de tout compte");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("solde_de_tout_compte_model.docx");
        legalDocument.setStepperConfigFilePath("solde_compte_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("solde_compte_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);

        descriptionSection = new DescriptionSection();
        descriptionSection.setTitle("Création de Solde de tout compte:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Solde de tout compte en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }
   
   /* @ChangeSet(order = "006", author = AuthorsConstants.RHIMI_RAMI , id = "006-addPVconseilLegalDocument")
    public void addPVconseilLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();

        autoFillConcernedEntities.add(Company.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa233");
        legalDocument.setShortName("-PV conseil de discipline");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("PV conseil de discipline");
        legalDocument.setKeywords("droit de travail");
        legalDocument.setDescription("MODÈLE DE PV CONSEIL DE DISCIPLINE");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("pv_conseil_docx_model.docx");
        legalDocument.setStepperConfigFilePath("pv_conseil_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("pv_conseil_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");

        descriptionSection = new DescriptionSection();
        descriptionSection.setTitle("Création de PV conseil de discipline:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV conseil de discipline en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    } */
    
  
    @ChangeSet(order = "007", author = AuthorsConstants.RHIMI_RAMI , id = "007-addAccordResiliationLegalDocument")
    public void addAccordResiliationLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());
        
        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa914");
        legalDocument.setShortName("Accord de résiliation amiable");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Accord de résiliation amiable de contrat de travail");
        legalDocument.setKeywords("droit de travail resil");
        legalDocument.setDescription("ACCORD DE RESILIATION AMIABLE DE CONTRAT DE TRAVAIL");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("accord_amiable_docx_model.docx");
        legalDocument.setStepperConfigFilePath("accord_amiable_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("accord_amiable_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        descriptionSection = new DescriptionSection();
        
        descriptionSection.setTitle("Création de Accord de résiliation amiable de contrat de travail:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Accord de résiliation amiable de contrat de travail en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);
        List<String> documentsRecommendationId = new ArrayList<>();
        legalDocument.setDocumentsRecommendationId(documentsRecommendationId);
        mongoTemplate.save(legalDocument);
        }
    
   /* @ChangeSet(order = "008", author = AuthorsConstants.RHIMI_RAMI , id = "008-addLettrededomicilisationLegalDocument")
    public void addLettrededomicilisationLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();
        
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa915");
        legalDocument.setShortName("Attestaion de domicilisation");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("ATTESTATION DE DOMICILIATION");
        legalDocument.setKeywords(" atttestaion de domicilisation gérer baux");
        legalDocument.setDescription("ATTESTATION DE DOMICILIATION");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("attestation_de_domicilisation_docx_model.docx");
        legalDocument.setStepperConfigFilePath("attestation_de_domicilisation_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("attestation_de_domicilisation_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        legalDocument.setCreatedDate(Instant.now());
        descriptionSection = new DescriptionSection();
        
       
      
        descriptionSection.setTitle("Création de ATTESTATION DE DOMICILIATION:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre ATTESTATION DE DOMICILIATION en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }*/

    
    
    
  
     
   @ChangeSet(order = "009", author = AuthorsConstants.RHIMI_RAMI , id = "009-addFormulairestatusLegalDocument")
    public void addFormulairestatusLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;
  
        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();
        
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa933");
        legalDocument.setShortName("Statuts SARL");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Statuts SARL");
        legalDocument.setKeywords("FORMULAIRE STATUS");
        legalDocument.setDescription("FORMULAIRE STATUS");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("formulaire_statuts_docx_model.docx");
        legalDocument.setStepperConfigFilePath("formulaire_statuts_docx_model_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("formulaire_statuts_docx_model_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        legalDocument.setCreatedDate(Instant.now());
        descriptionSection = new DescriptionSection();
            
       
      
        descriptionSection.setTitle("Statuts SARL :");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Statuts SAR en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    } 
   
    @ChangeSet(order = "010", author = AuthorsConstants.RHIMI_RAMI , id = "010-addconvocationagoLegalDocument")

    public void addconvocationagoLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa937");
        legalDocument.setShortName("Convocation assemblée générale ordinaire");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Convocation Ago nomination de gérant");
        legalDocument.setKeywords("Convocation ago remunerations gr");
        legalDocument.setDescription("Convocation ago");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("convocation_AGO_nomination_de_gérant_docx_model.docx");
        legalDocument.setStepperConfigFilePath("convocation_ago_docx_model_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("convocation_ago_docx_model_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        descriptionSection = new DescriptionSection();
        
       
      
        descriptionSection.setTitle("Convocation Ago:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Convocation Ago en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }
    
  /*  @ChangeSet(order = "011", author = AuthorsConstants.RHIMI_RAMI , id = "011-addapprobationdescomptesLegalDocument")

    public void addapprobationdescomptesLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa939");
        legalDocument.setShortName("Approbation des comptes");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Approbation des comptes");
        legalDocument.setKeywords("Approbation des comptes   remunerations gr");
        legalDocument.setDescription("Approbation des comptes");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("approbation_des_comptes.docx");
        legalDocument.setStepperConfigFilePath("approbation_des_comptes_docx_model_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("approbation_des_comptes_docx_model_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        descriptionSection = new DescriptionSection();
        
       
      
        descriptionSection.setTitle("Approbation des comptes:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Approbation des Comptes en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }*/
    
   /* @ChangeSet(order = "012", author = AuthorsConstants.RHIMI_RAMI , id = "012-addAGONominationNouveauGerantLegalDocument")
    public void addAGONominationNouveauGerantLegalDocument(MongoTemplate mongoTemplate) {
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dde43ffd02a3b36803e18b88");
        legalDocument.setShortName("AGO-NNG");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("AGO : Nomination d'un Nouveau Gérant");
        legalDocument.setKeywords("AGO nng remunerations gr");
        legalDocument.setDescription("AGO : NOMINATION D'UN NOUVEAU GÉRANT");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("AGO_nomination d'un  nouveau gérant.docx");
        legalDocument.setStepperConfigFilePath("ago_nomination_nouveau_gerant_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("ago_nomination_nouveau_gerant_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        legalDocument.setCreatedDate(Instant.now());

        descriptionSection = new DescriptionSection();
        descriptionSection.setTitle("Création de Procès-Verbal :AGO Nomination d'un Nouveau Gérant :");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre document en toute simplicité.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(10.59f);

        List<String> documentsRecommendationId = new ArrayList<>();
        legalDocument.setDocumentsRecommendationId(documentsRecommendationId);

        mongoTemplate.save(legalDocument);

    }*/
   
    
   @ChangeSet(order = "013", author = AuthorsConstants.RHIMI_RAMI , id = "013-addLettreDeDemissionGerantLegalDocument")
    public void addLettreDeDemissionGerantLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa96");
        legalDocument.setShortName("Lettre de demission gérant");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Lettre de demission GERANT");
        legalDocument.setKeywords("lettre de demission gerant remunerations gr");
        legalDocument.setDescription("MODÈLE LETTRE DE DEMISSION");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("lettre_de_démission_gérant.docx");
        legalDocument.setStepperConfigFilePath("lettre_de_demission_gerant_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("lettre_de_demission_gerant_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
      
        descriptionSection = new DescriptionSection();
        descriptionSection.setTitle("Création de LETTRE DE DEMISSION GERANT:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Lettre de demission gérant en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);    

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    } 
   
    @ChangeSet(order = "014", author = AuthorsConstants.RHIMI_RAMI , id = "014-addDemissionLegalDocument")
    public void addDemissionLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;
        
        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());
        
        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa89");
        legalDocument.setShortName("Lettre de démission");
		legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Lettre de démission");
        legalDocument.setKeywords(" Demission créer droit de travail");
        legalDocument.setDescription("Lettre de démission");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("demission_model.docx");
        legalDocument.setStepperConfigFilePath("demission_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("demission_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        
        
        
        legalDocument.setPrice(49.99f);
        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }
   @ChangeSet(order = "015", author = AuthorsConstants.RHIMI_RAMI , id = "015-addcontratbailcommercialLegalDocument")
    public void addcontratbailcommercialLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        
        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());
        

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa916");
        legalDocument.setShortName("Bail commercial");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Bail commercial");
        legalDocument.setKeywords(" Contrat Bail Commercial gérer baux");
        legalDocument.setDescription("Bail commercial");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("contrat_bail_commercial_model.docx");
        legalDocument.setStepperConfigFilePath("contrat_bail_commercial_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("Contrat_bail_commercial_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        descriptionSection = new DescriptionSection();
        
       
      
        descriptionSection.setTitle("Création de Contrat Bail Commercial:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Contrat Bail Commercial en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }
    
    
  @ChangeSet(order = "016", author = AuthorsConstants.RHIMI_RAMI , id = "016-addcontratbailLegalDocument")
    public void addcontratbailLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        
        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());
        

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa917");
        legalDocument.setShortName("Contrat de bail");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Contrat de Bail ");
        legalDocument.setKeywords(" Contrat de Bail gérer baux");
        legalDocument.setDescription("Contrat de Bail");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("contrat_bail__model.docx");
        legalDocument.setStepperConfigFilePath("contrat_bail__stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("Contrat_bail_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        descriptionSection = new DescriptionSection();
        
       
      
        descriptionSection.setTitle("Création de Contrat De Bail:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Contrat De Bail  en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }
    
    
    @ChangeSet(order = "017", author = AuthorsConstants.RHIMI_RAMI , id = "017-addcontratcessioncreanceLegalDocument")
    public void addcontratcessioncreanceLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa918");
        legalDocument.setShortName("Contrat de cession de créance");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Contrat Cession Creance ");
        legalDocument.setKeywords("Contrat Cession Creance comm");
        legalDocument.setDescription("Contrat Cession Creance");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("contrat_cession_creance__model.docx");
        legalDocument.setStepperConfigFilePath("contrat_cession_creance_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("contrat_cession_creance_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        descriptionSection = new DescriptionSection();
        
       
      
        descriptionSection.setTitle("CONTRAT DE CESSION DE CREANCES:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Contrat de cession de créance en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }
    
    
    
    @ChangeSet(order = "018", author = AuthorsConstants.RHIMI_RAMI , id = "018-addcontratprestationserviceLegalDocument")
    public void addcontratprestationserviceLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        
       

        autoFillConcernedEntities.add(Company.class.getSimpleName());

        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa919");
        legalDocument.setShortName("Contrat de prestation de services");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Contrat prestation service ");
        legalDocument.setKeywords("Contrat prestation service comm");
        legalDocument.setDescription("Contrat prestation service");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("contrat_prestation_service__model.docx");
        legalDocument.setStepperConfigFilePath("contrat_prestation_service_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("contrat_prestation_service_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        descriptionSection = new DescriptionSection();
        
       
      
        descriptionSection.setTitle("CONTRAT DE PRESTATION DE SERVICE:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Contrat de prestation de services en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }
    
    
    
   @ChangeSet(order = "019", author = AuthorsConstants.RHIMI_RAMI , id = "019-addreconnaissancededetteLegalDocument")
    public void addreconnaissancededetteLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());
        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa920");
        legalDocument.setShortName("Reconnaissance de dette");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Reconnaissance de dette ");
        legalDocument.setKeywords("Reconnaissance de dette comm");
        legalDocument.setDescription("Reconnaissance de dette");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("reconnaissance_de_dette__model.docx");
        legalDocument.setStepperConfigFilePath("reconnaissance_de_dette_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("reconnaissance_de_dette_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        descriptionSection = new DescriptionSection();
       
      
        descriptionSection.setTitle("RECONNAISSANCE DE DETTE:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Reconnaissance de dette en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }
    
    
 @ChangeSet(order = "020", author = AuthorsConstants.RHIMI_RAMI , id = "020-addcautionsolidaireLegalDocument")
    public void addcautionsolidaireLegalDocument(MongoTemplate mongoTemplate) {     
        LegalDocument legalDocument;

        List<DescriptionSection> descriptionSections = new ArrayList<>();
        DescriptionSection descriptionSection;
        List<String> autoFillConcernedEntities = new ArrayList<>();
        Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
        List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
        List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

        companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
        companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
        companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

        employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
        employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
        employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

        autoFillConcernedEntities.add(Company.class.getSimpleName());
        autoFillConcernedEntities.add(Employer.class.getSimpleName());
        legalDocument = new LegalDocument();
        legalDocument.setId("5dad0d7dd1a76c479c02affa921");
        legalDocument.setShortName("Caution solidaire");
        legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
        legalDocument.setFullName("Caution solidaire ");
        legalDocument.setKeywords("Caution solidaire comm");
        legalDocument.setDescription("Caution solidaire");
        legalDocument.setTemplatePreviewPath("empty_preview");
        legalDocument.setTemplateFilePath("caution_solidaire_model.docx");
        legalDocument.setStepperConfigFilePath("caution_solidaire_stepper_configuration.json");
        legalDocument.setWorkflowConfigFilePath("caution_solidaire_workflow_configuration.json");
        legalDocument.setCategoryId("empty_category");
        legalDocument.setLawyerId("empty_lawyer");
        legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
        legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
        descriptionSection = new DescriptionSection();
        
       
      
        descriptionSection.setTitle("Caution solidaire:");
        descriptionSection.setContent("Procédure 100% en ligne pour créer votre Caution Solidaire  en toute simplicité.\n" +
            "Statuts générés en 10mn.");
        descriptionSections.add(descriptionSection);

        legalDocument.setDescriptionSections(descriptionSections);

        legalDocument.setPrice(49.99f);

        legalDocument.setDocumentsRecommendationId(new ArrayList<>());

        mongoTemplate.save(legalDocument);
    }
 @ChangeSet(order = "021", author = AuthorsConstants.RHIMI_RAMI , id = "021-addconfessionLegalDocument")
 public void addCofessionLegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     Map<String, String> companyAutoFillInputIdsByFieldName = new LinkedHashMap<>();
     Map<String, String> employerAutoFillInputIdsByFieldName = new LinkedHashMap<>();
     List<Map<String, String>> companiesAutoFillInputIdsByFieldName = new LinkedList<>();
     List<Map<String, String>> employersAutoFillInputIdsByFieldName = new LinkedList<>();

     companyAutoFillInputIdsByFieldName.put("companyName", "input_dénomination_de_la_societé");
     companyAutoFillInputIdsByFieldName.put("companyUniqueIdentification", "input_identifiant_unique_de_la_societé");
     companyAutoFillInputIdsByFieldName.put("companyRepresentativeFullName", "input_nomPrénom_du_representant_de_la_societé");
     companyAutoFillInputIdsByFieldName.put("companyFullAddress", "input_adresse_de_la_societé");
     companyAutoFillInputIdsByFieldName.put("companyType", "input_type_de_la_societé");
     companiesAutoFillInputIdsByFieldName.add(companyAutoFillInputIdsByFieldName);

     employerAutoFillInputIdsByFieldName.put("employerCinNumber", "input_num_CIN_de_lemployé");
     employerAutoFillInputIdsByFieldName.put("employerFullName", "input_nom_de_lemployé");
     employerAutoFillInputIdsByFieldName.put("employerFullAddress", "input_adresse_de_lemployé");
     employersAutoFillInputIdsByFieldName.add(employerAutoFillInputIdsByFieldName);

     autoFillConcernedEntities.add(Company.class.getSimpleName());
     autoFillConcernedEntities.add(Employer.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02affa92116");
     legalDocument.setShortName("Concession de dette");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Concession de dette_ar");
     legalDocument.setKeywords("Concession de dette comm");
     legalDocument.setDescription("Concession de dette");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("confession_une_dette_model.docx");
     legalDocument.setStepperConfigFilePath("confession_une_dette_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("confession_une_dette_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setEmployersAutoFillInputIdsByFieldName(employersAutoFillInputIdsByFieldName);
     legalDocument.setCompaniesAutoFillInputIdsByFieldName(companiesAutoFillInputIdsByFieldName);
     descriptionSection = new DescriptionSection();
     
    
   
     descriptionSection.setTitle("Concession de dette:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Concession de dette en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);

     legalDocument.setDescriptionSections(descriptionSections);

     legalDocument.setPrice(49.99f);

     legalDocument.setDocumentsRecommendationId(new ArrayList<>());

     mongoTemplate.save(legalDocument);
 }
 
  @ChangeSet(order = "022", author = AuthorsConstants.RHIMI_RAMI , id = "022-addcontratsouslocationLegalDocument")
 public void addcontratsouslocationLegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     
     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02affa92116001");
     legalDocument.setShortName("Contrat de sous-location");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Contrat de sous-location");
     legalDocument.setKeywords("Contrat de sous-location gérer baux");
     legalDocument.setDescription("Contrat de sous-location");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("contrat_sous_location_model.docx");
     legalDocument.setStepperConfigFilePath("contrat_sous_location_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("contrat_sous_location_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Contrat de sous-location:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Contrat de sous-location en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }
 @ChangeSet(order = "023", author = AuthorsConstants.RHIMI_RAMI , id = "023-addQuitancedeLoyerLegalDocument")
 public void addQuitancedeLoyerLegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02affa92116002");
     legalDocument.setShortName("Quittance de loyer");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Quittance de loyer");
     legalDocument.setKeywords("Quitance de loyer gérer baux");
     legalDocument.setDescription("Quittance de loyer");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("quitance_de_loyer_model.docx");
     legalDocument.setStepperConfigFilePath("quitance_de_loyer_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("quitance_de_loyer_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Quittance de loyer:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Quittance de loyer en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 /*
 
 @ChangeSet(order = "026", author = AuthorsConstants.RHIMI_RAMI , id = "026-addPV_AGO_NominationNvGerantLegalDocument")
 public void addPV_AGO_NominationNvGerantLegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty01");
     legalDocument.setShortName("PV AGO Nomination d'un nouveau gérantXXXXXXXXXXX");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Nomination d'un nouveau gérant");
     legalDocument.setKeywords("remunerations gr");
     legalDocument.setDescription("PV AGO Nomination d'un nouveau gérant");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("PV_AGO_Nomination_d_un_nouveau_gérant.docx");
     legalDocument.setStepperConfigFilePath("PV_AGO_Nomination_d_un_nouveau_gérant_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("PV_AGO_Nomination_d_un_nouveau_gérant_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Nomination d'un nouveau gérantu :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Nomination d'un nouveau gérant en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }*/
 
 

 /*@ChangeSet(order = "027", author = AuthorsConstants.RHIMI_RAMI , id = "027-addLettreDemissionGerantGeranceLegalDocument")
 public void addLettreDemissionGerantGeranceLegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty02");
     legalDocument.setShortName("Lettre de démission gérantXXXXXXXXXXX");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Lettre de démission gérant");
     legalDocument.setKeywords("remunerations gr");
     legalDocument.setDescription("Lettre de démission gérant");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("Lettre_de_démission_gérant_gerance.docx");
     legalDocument.setStepperConfigFilePath("Lettre_de_démission_gérant_gerance_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("Lettre_de_démission_gérant_gerance_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Lettre de démission gérant :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Lettre de démission gérant en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }
 
 @ChangeSet(order = "028", author = AuthorsConstants.RHIMI_RAMI , id = "028-addConvocation_AGO_nomination_de_gérant_geranceLegalDocument")
 public void addConvocation_AGO_nomination_de_gérant_geranceLegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty03");
     legalDocument.setShortName("Convocation AGO nomination de gérant XXXXXXXXXXX");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Convocation AGO nomination de gérant");
     legalDocument.setKeywords("remunerations gr");
     legalDocument.setDescription("Convocation AGO nomination de gérant");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("Convocation_AGO_nomination_de_gérant_gerance.docx");
     legalDocument.setStepperConfigFilePath("Convocation_AGO_nomination_de_gérant_gerance_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("Convocation_AGO_nomination_de_gérant_gerance_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Convocation AGO nomination de gérant:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Convocation AGO nomination de gérant en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }*/
 
 
 
 @ChangeSet(order = "029", author = AuthorsConstants.GHABI_HAMZA , id = "029-addPvAGE_Augmentation_capitale_numLegalDocument")
 public void addPvAGE_Augmentation_capitale_numLegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty04");
     legalDocument.setShortName("PV AGE Augmentation de capital numéraire");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGE Augmentation de capital numéraire");
     legalDocument.setKeywords("cap SARL");
     legalDocument.setDescription("PV AGE Augmentation de capital numéraire");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("PV_AGE_Augmentataion_de_capital_numeraire.docx");
     legalDocument.setStepperConfigFilePath("PV_AGE_Augmentataion_de_capital_numeraire_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("PV_AGE_Augmentataion_de_capital_numeraires_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGE Augmentation de capital numéraire:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Augmentation de capital numéraire en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 @ChangeSet(order = "068", author = AuthorsConstants.GHABI_HAMZA , id = "068-Proces_verbal_augmentation_de_capital_par_conversion_de_creance_numLegalDocument")
 public void Proces_verbal_augmentation_de_capital_par_conversion_de_creance_numLegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty044");
     legalDocument.setShortName("PV AGE Augmentation de capital par conversion de créance");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGE Augmentation de capital par conversion de créance");
     legalDocument.setKeywords("Proces verbal augmentataion de capital par conversion de créance");
     legalDocument.setDescription("PV AGE Augmentation de capital par conversion de créance");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("Proces_verbal_augmentation_de_capital_par_conversion_de_creance.docx");
     legalDocument.setStepperConfigFilePath("Proces_verbal_augmentation_de_capital_par_conversion_de_creance_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("Proces_verbal_augmentation_de_capital_par_conversion_de_creance_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGE Augmentation de capital par conversion de créance :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Augmentation de capital par conversion de créance en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 
 
 
 /*@ChangeSet(order = "030", author = AuthorsConstants.RHIMI_RAMI , id = "030-formulaire_AGE_Augmentation_cap_num_LegalDocument")
 public void formulaire_AGE_Augmentation_cap_num_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty05");
     legalDocument.setShortName("Formulaire AGE Augmentation de capital numéraire");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Formulaire AGE Augmentation de capital numéraire");
     legalDocument.setKeywords("remunerations gr");
     legalDocument.setDescription("Formulaire AGE Augmentation de capital numéraire");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("Formulaire_AGE_Augmentation_de_capital_numeraire.docx");
     legalDocument.setStepperConfigFilePath("Formulaire_AGE_Augmentation_de_capital_numeraire_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("Formulaire_AGE_Augmentation_de_capital_numeraire_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Formulaire AGE Augmentation de capital numéraire:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Formulaire AGE Augmentation de capital numéraire en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } */
 
 
 
 
 
 
 @ChangeSet(order = "031", author = AuthorsConstants.RHIMI_RAMI , id = "031_contrat_agent_comercial_LegalDocument")
 public void contrat_agent_comercial_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty06");
     legalDocument.setShortName("Contrat d'agence commerciale");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Contrat d'agence commerciale");
     legalDocument.setKeywords("comm agent");
     legalDocument.setDescription("Contrat d'agence commerciale");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("contrat_agent_commercial.docx");
     legalDocument.setStepperConfigFilePath("contrat_agent_commercial_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("contrat_agent_commercial_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Contrat d'agence commerciale:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Contrat d'agence commerciale en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 
 
 @ChangeSet(order = "032", author = AuthorsConstants.RHIMI_RAMI , id = "032_nantissement_equipement_LegalDocument")
 public void nantissement_equipement_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty07");
     legalDocument.setShortName("Nantissement equipement");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Nantissement equipement");
     legalDocument.setKeywords("comm nan2");
     legalDocument.setDescription("Nantissement equipement");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("Nantissement_equipement.docx");
     legalDocument.setStepperConfigFilePath("Nantissement_equipement_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("Nantissement_equipement_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Nantissement equipement:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Nantissement equipement en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 @ChangeSet(order = "033", author = AuthorsConstants.RHIMI_RAMI , id = "033_nantissement_meuble_incorporel_LegalDocument")
 public void nantissement_meuble_incorporel_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty08");
     legalDocument.setShortName("Nantissement meuble incorporel");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Nantissement meuble incorporel");
     legalDocument.setKeywords("comm nan4");
     legalDocument.setDescription("Nantissement meuble incorporel");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("Nantissement_meuble_incorporel.docx");
     legalDocument.setStepperConfigFilePath("Nantissement_meuble_incorporel_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("Nantissement_meuble_incorporel_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Nantissement meuble incorporel:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Nantissement meuble incorporel en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 @ChangeSet(order = "034", author = AuthorsConstants.RHIMI_RAMI , id = "034_nantissement_F_D_C_LegalDocument")
 public void nantissement_F_D_C_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty09");
     legalDocument.setShortName("Nantissement F.D.C");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Nantissement F.D.C");
     legalDocument.setKeywords("comm nan3");
     legalDocument.setDescription("Nantissement F.D.C");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("Nantissement_f_d_c.docx");
     legalDocument.setStepperConfigFilePath("Nantissement_f_d_c_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("Nantissement_f_d_c_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Nantissement F.D.C:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Nantissement F.D.C en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 @ChangeSet(order = "035", author = AuthorsConstants.RHIMI_RAMI , id = "035_nantissement_P_S_LegalDocument")
 public void nantissement_P_S_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty10");
     legalDocument.setShortName("Nantissement PS");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Nantissement PS");
     legalDocument.setKeywords("comm nan5");
     legalDocument.setDescription("Nantissement PS");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("Nantissement_p_s.docx");
     legalDocument.setStepperConfigFilePath("Nantissement_p_s_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("Nantissement_p_s_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Nantissement PS :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Nantissement PS en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 
 @ChangeSet(order = "036", author = AuthorsConstants.RHIMI_RAMI , id = "036_nantissement_actions_LegalDocument")
 public void nantissement_actions_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty11");
     legalDocument.setShortName("Nantissement Actions");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Nantissement Actions");
     legalDocument.setKeywords("comm nan1");
     legalDocument.setDescription("Nantissement Actions");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("Nantissement_actions.docx");
     legalDocument.setStepperConfigFilePath("Nantissement_actions_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("Nantissement_actions_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Nantissement Actions :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Nantissement Actions en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 @ChangeSet(order = "037", author = AuthorsConstants.RHIMI_RAMI , id = "037_gage_meuble_corporel_LegalDocument")
 public void gage_meuble_corporel_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty12");
     legalDocument.setShortName("Gage meuble corporel");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("Gage meuble corporel");
     legalDocument.setKeywords("comm gage");
     legalDocument.setDescription("Gage meuble corporel");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("gage_meuble_corporel.docx");
     legalDocument.setStepperConfigFilePath("gage_meuble_corporel_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("gage_meuble_corporel_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("Gage meuble corporel :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre Gage meuble corporel en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 
 @ChangeSet(order = "038", author = AuthorsConstants.RHIMI_RAMI , id = "038_AGO_SUARL_PV_constatation_deces_du_CAC_et_nomminatio_dun_nouveau_CAC_LegalDocument")
 public void AGO_SUARL_PV_constatation_deces_du_CAC_et_nomminatio_dun_nouveau_CAC_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty13");
     legalDocument.setShortName("PV AGO Constatation décès du commissaire aux comptes et nomination d’un nouveau CAC");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Constatation décès du commissaire aux comptes et nomination d’un nouveau CAC");
     legalDocument.setKeywords("AGO  nouveau CAC");
     legalDocument.setDescription("PV AGO Constatation décès du commissaire aux comptes et nomination d’un nouveau CAC");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("AGO_SUARL_PV_constatation_deces_du_CAC_et_nomminatio_dun_nouveau_CAC.docx");
     legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_constatation_deces_du_CAC_et_nomminatio_dun_nouveau_CAC_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_constatation_deces_du_CAC_et_nomminatio_dun_nouveau_CAC_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Constatation décès du commissaire aux comptes et nomination d’un nouveau CAC :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Constatation décès du commissaire aux comptes et nomination d’un nouveau CAC en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 
 @ChangeSet(order = "039", author = AuthorsConstants.RHIMI_RAMI , id = "039_AGO_SUARL_PV_nommination_dun_nouveau_CAC_LegalDocument")
 public void AGO_SUARL_PV_nommination_dun_nouveau_CAC_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty14");
     legalDocument.setShortName("PV AGO Nomination d’un nouveau commissaire aux comptes");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Nomination d’un nouveau commissaire aux comptes");
     legalDocument.setKeywords("const SUARL");
     legalDocument.setDescription("PV AGO Nomination d’un nouveau commissaire aux comptes");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("AGO_SUARL_PV_nommination_dun_nouveau_CAC.docx");
     legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_nommination_dun_nouveau_CAC_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_nommination_dun_nouveau_CAC_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Nomination d’un nouveau commissaire aux comptes :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Nomination d’un nouveau commissaire aux comptes en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 
 @ChangeSet(order = "040", author = AuthorsConstants.RHIMI_RAMI , id = "040_AGO_SUARL_PV_renouvellement_du_mandat_du_CAC_LegalDocument")
 public void AGO_SUARL_PV_renouvellement_du_mandat_du_CAC_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty15");
     legalDocument.setShortName("PV AGO Renouvellement du mandat du commissaire aux comptes");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Renouvellement du mandat du commissaire aux comptes");
     legalDocument.setKeywords("AGO SUARL PV renouvellement du mandat du CAC");
     legalDocument.setDescription("PV AGO Renouvellement du mandat du commissaire aux comptes");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("AGO_SUARL_PV_renouvellement_du_mandat_du_CAC.docx");
     legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_renouvellement_du_mandat_du_CAC_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_renouvellement_du_mandat_du_CAC_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Renouvellement du mandat du commissaire aux comptes :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Renouvellement du mandat du commissaire aux comptes en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 
 @ChangeSet(order = "041", author = AuthorsConstants.RHIMI_RAMI , id = "041_PV_AGO_renouvellement_mondat_gerant_LegalDocument")
 public void PV_AGO_renouvellement_mondat_gerant_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty16");
     legalDocument.setShortName("PV AGO Renouvellement du mandat du gérant");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Renouvellement du mandat du gérant");
     legalDocument.setKeywords("ren1 ger SUARL");
     legalDocument.setDescription("PV AGO Renouvellement du mandat du gérant");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("AGO_SUARL_PV_renouvellement_du_mandat_du_gerant.docx");
     legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_renouvellement_du_mandat_du_gerant_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_renouvellement_du_mandat_du_gerant_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Renouvellement du mandat du gérant :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Renouvellement du mandat du gérant en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 
 @ChangeSet(order = "042", author = AuthorsConstants.RHIMI_RAMI , id = "042_PV_AGO_nommination_nv_gerant_LegalDocument")
 public void PV_AGO_nommination_nv_gerant_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty17");
     legalDocument.setShortName("PV AGO Nomination d’un nouveau gérant");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Nomination d’un nouveau gérant");
     legalDocument.setKeywords("nom1 ger SUARL");
     legalDocument.setDescription("PV AGO Nomination d’un nouveau gérant");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("AGO_SUARL_PV_nommination_d_un_nouveau_gerant.docx");
     legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_nommination_d_un_nouveau_gerant_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_nommination_d_un_nouveau_gerant_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Nomination d’un nouveau gérant :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Nomination d’un nouveau gérant en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 
 
 @ChangeSet(order = "043", author = AuthorsConstants.GHABI_HAMZA , id = "043_PV_AGO_revocation_gerant_nommination_nv_gerant_LegalDocument")
 public void PV_AGO_revocation_gerant_nommination_nv_gerant_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty18");
     legalDocument.setShortName("PV AGO Révocation du gérant et nomination d’un nouveau gérant");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Révocation du gérant et nomination d’un nouveau gérant");
     legalDocument.setKeywords("rev1 ger SUARL");
     legalDocument.setDescription("PV AGO Révocation du gérant et nomination d’un nouveau gérant");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("AGO_SUARL_PV_revocation_gerant_nommination_d_un_nouveau_gerant.docx");
     legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_revocation_gerant_nommination_d_un_nouveau_gerant_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_revocation_gerant_nommination_d_un_nouveau_gerant_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Révocation du gérant et nomination d’un nouveau gérant :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Révocation du gérant et nomination d’un nouveau gérant en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 
 
 @ChangeSet(order = "044", author = AuthorsConstants.GHABI_HAMZA , id = "044_PV_AGO_demission_gerant_nommination_nv_gerant_LegalDocument")
 public void PV_AGO_demission_gerant_nommination_nv_gerant_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty19");
     legalDocument.setShortName("PV AGO Démission du gérant et nomination d’un nouveau gérant");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Démission du gérant et nomination d’un nouveau gérant");
     legalDocument.setKeywords("dem ger SUARL");
     legalDocument.setDescription("PV AGO Démission du gérant et nomination d’un nouveau gérant");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("AGO_SUARL_PV_demission_gerant_nommination_d_un_nouveau_gerant.docx");
     legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_demission_gerant_nommination_d_un_nouveau_gerant_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_demission_gerant_nommination_d_un_nouveau_gerant_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Démission du gérant et nomination d’un nouveau gérant :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Démission du gérant et nomination d’un nouveau gérant en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 @ChangeSet(order = "045", author = AuthorsConstants.GHABI_HAMZA , id = "045_PV_AGO_demission_gerant_nommination_nv_gerant_statutaire_LegalDocument")
 public void PV_AGO_demission_gerant_nommination_nv_gerant_statutaire_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty20");
     legalDocument.setShortName("PV AGE Démission du gérant et nomination d’un nouveau gérant statutaire");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGE Démission du gérant et nomination d’un nouveau gérant statutaire");
     legalDocument.setKeywords("demission stat");
     legalDocument.setDescription("PV AGE Démission du gérant et nomination d’un nouveau gérant statutaire");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("AGO_SUARL_PV_demission_gerant_nommination_d_un_nouveau_gerant_statutaire.docx");
     legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_demission_gerant_nommination_d_un_nouveau_gerant_statutaire_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_demission_gerant_nommination_d_un_nouveau_gerant_statutaire_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGE Démission du gérant et nomination d’un nouveau gérant statutaire :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Démission du gérant et nomination d’un nouveau gérant statutaire en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 
 @ChangeSet(order = "046", author = AuthorsConstants.GHABI_HAMZA , id = "046_PV_AGE_revocation_gerant_nommination_nv_gerant_statutaire_LegalDocument")
 public void PV_AGE_revocation_gerant_nommination_nv_gerant_statutaire_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty21");
     legalDocument.setShortName("PV AGE Révocation du gérant et nomination d’un nouveau gérant statutaire");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGE Révocation du gérant et nomination d’un nouveau gérant statutaire");
     legalDocument.setKeywords("rev2 ger SUARL");
     legalDocument.setDescription("PV AGE Révocation du gérant et nomination d’un nouveau gérant statutaire");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("PV_AGE_revocation_gerant_nommination_nv_gerant_statutaire.docx");
     legalDocument.setStepperConfigFilePath("PV_AGE_revocation_gerant_nommination_nv_gerant_statutaire_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("PV_AGE_revocation_gerant_nommination_nv_gerant_statutaire_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGE Révocation du gérant et nomination d’un nouveau gérant statutaire :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Révocation du gérant et nomination d’un nouveau gérant statutaire en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 } 
 
 @ChangeSet(order = "047", author = AuthorsConstants.GHABI_HAMZA , id = "047_PV_AGE_SUARL_nommination_nv_gerant_statutaire_LegalDocument")
 public void PV_AGE_SUARL_nommination_nv_gerant_statutaire_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty22");
     legalDocument.setShortName("PV AGE Nomination nouveau gérant statutaire");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGE Nomination nouveau gérant statutaire");
     legalDocument.setKeywords("nom2 ger SUARL");
     legalDocument.setDescription("PV AGE Nomination nouveau gérant statutaire");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("PV_AGE_SUARL_nommination_nv_gerant_statutaire.docx");
     legalDocument.setStepperConfigFilePath("PV_AGE_SUARL_nommination_nv_gerant_statutaire_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("PV_AGE_SUARL_nommination_nv_gerant_statutaire_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGE Nomination nouveau gérant statutaire :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Nomination nouveau gérant statutaire en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }
 @ChangeSet(order = "048", author = AuthorsConstants.GHABI_HAMZA , id = "048_PV_AGE_SUARL_renouvellement_mandat_gerant_statutaire_LegalDocument")
 public void PV_AGE_SUARL_renouvellement_mandat_gerant_statutaire_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty23");
     legalDocument.setShortName("PV AGE Renouvellement du mandat du gérant statutaire");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGE Renouvellement du mandat du gérant statutaire");
     legalDocument.setKeywords("ren2 ger SUARL");
     legalDocument.setDescription("PV AGE Renouvellement du mandat du gérant statutaire");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("PV_AGE_SUARL_renouvellement_mandat_gerant_statutaire.docx");
     legalDocument.setStepperConfigFilePath("PV_AGE_SUARL_renouvellement_mandat_gerant_statutaire_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("PV_AGE_SUARL_renouvellement_mandat_gerant_statutaire_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGE Renouvellement du mandat du gérant statutaire :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Renouvellement du mandat du gérant statutaire en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }
 
 
 @ChangeSet(order = "049", author = AuthorsConstants.GHABI_HAMZA , id = "049_PV_AGO_SUARL_constatation_deces_gerant_nommination_nouveau_gerant_LegalDocument")
 public void PV_AGO_SUARL_constatation_deces_gerant_nouveau_gerant_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty24");
     legalDocument.setShortName("PV AGO Constatation du décès du gérant et nomination d’un nouveau gérant");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Constatation du décès du gérant et nomination d’un nouveau gérant");
     legalDocument.setKeywords("AGO dec ger SUARL");
     legalDocument.setDescription("PV AGO Constatation du décès du gérant et nomination d’un nouveau gérant");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("PV_AGO_SUARL_constatation_deces_gerant_nommination_nouveau_gerant.docx");
     legalDocument.setStepperConfigFilePath("PV_AGO_SUARL_constatation_deces_gerant_nommination_nouveau_gerant_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("PV_AGO_SUARL_constatation_deces_gerant_nommination_nouveau_gerant_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Constatation du décès du gérant et nomination d’un nouveau gérant :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Constatation du décès du gérant et nomination d’un nouveau gérant en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }
 
 
 @ChangeSet(order = "050", author = AuthorsConstants.GHABI_HAMZA , id = "050_PV_AGE_SUARL_constatation_deces_gerant_nommination_nouveau_gerant_statutaire_LegalDocument")
 public void PV_AGE_SUARL_constatation_deces_gerant_nommination_nouveau_gerant_statutaire_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty26");
     legalDocument.setShortName("PV AGE Décès du gérant et nomination d’un nouveau gérant statutaire");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGE Décès du gérant et nomination d’un nouveau gérant statutaire");
     legalDocument.setKeywords("AGE dec ger SUARL");
     legalDocument.setDescription("PV AGE Décès du gérant et nomination d’un nouveau gérant statutaire");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("PV_AGE_SUARL_constatation_deces_gerant_nommination_nouveau_gerant_statutaire.docx");
     legalDocument.setStepperConfigFilePath("PV_AGE_SUARL_constatation_deces_gerant_nommination_nouveau_gerant_statutaire_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("PV_AGE_SUARL_constatation_deces_gerant_nommination_nouveau_gerant_statutaire_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGE Décès du gérant et nomination d’un nouveau gérant statutaire :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Décès du gérant et nomination d’un nouveau gérant statutaire en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }
 
 @ChangeSet(order = "052", author = AuthorsConstants.GHABI_HAMZA , id = "052_pv_revocation_gerant_nommination_nouveau_gerant_LegalDocument")
 public void pv_revocation_gerant_nommination_nouveau_gerant_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty28");
     legalDocument.setShortName("PV AGO Révocation gérant");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("pv révocation de gérant et nommination nouveau gérant");
     legalDocument.setKeywords("pv révocation 1");
     legalDocument.setDescription("PV AGO Révocation gérant");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("pv_revocation_gerant_nommination_nouveau_gerant.docx");
     legalDocument.setStepperConfigFilePath("pv_revocation_gerant_nommination_nouveau_gerant_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("pv_revocation_gerant_nommination_nouveau_gerant_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Révocation gérant:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Révocation gérant en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }
 
 @ChangeSet(order = "053", author = AuthorsConstants.GHABI_HAMZA , id = "053_pv_demission_gerant_nommination_nouveau_gerant_LegalDocument")
 public void pv_demission_gerant_nommination_nouveau_gerant_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02azerty29");
     legalDocument.setShortName("PV AGO Démission gérant et nomination nouveau gérant");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Démission gérant et nomination nouveau gérant");
     legalDocument.setKeywords("pv démission de gérant 2");
     legalDocument.setDescription("PV AGO Démission gérant et nomination nouveau gérant");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("pv_demission_gerant_nommination_nouveau_gerant.docx");
     legalDocument.setStepperConfigFilePath("pv_demission_gerant_nommination_nouveau_gerant_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("pv_demission_gerant_nommination_nouveau_gerant_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Démission gérant et nomination nouveau gérant:");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Démission gérant et nomination nouveau gérant en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }
 
 
 
@ChangeSet(order = "054", author = AuthorsConstants.GHABI_HAMZA , id = "054_AGE_SARL_PV_renouvellement_du_mandat_du_gerant_statutaire_LegalDocument")
public void AGE_SARL_PV_renouvellement_du_mandat_du_gerant_statutaire_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty30");
    legalDocument.setShortName("PV AGE Renouvellement du mandat du gérant statutaire");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGE Renouvellement du mandat du gérant statutaire");
    legalDocument.setKeywords(" ren ger SARL sat");
    legalDocument.setDescription("PV AGE Renouvellement du mandat du gérant statutaire");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGE_SARL_PV_renouvellement_du_mandat_du_gerant_statutaire.docx");
    legalDocument.setStepperConfigFilePath("AGE_SARL_PV_renouvellement_du_mandat_du_gerant_statutaire_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGE_SARL_PV_renouvellement_du_mandat_du_gerant_statutaire_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("APV AGE Renouvellement du mandat du gérant statutaire:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Renouvellement du mandat du gérant statutaire en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}


@ChangeSet(order = "055", author = AuthorsConstants.BEN_ROMDHANE_AWATEF , id = "055_AGO_SARL_pv_nomination_d_un_nouveau_gerant_a_la_constitution_LegalDocument")
public void AGO_SARL_pv_nomination_d_un_nouveau_gerant_a_la_constitution_LegalDocument(MongoTemplate mongoTemplate) {     
 LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());
 
	
    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty31");
    legalDocument.setShortName("PV AGO Nomination gérant à la constitution");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Nomination gérant à la constitution");
    legalDocument.setKeywords("nom ger SARL");
    legalDocument.setDescription("PV AGO Nomination gérant à la constitution");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SARL_pv_nomination_d_un_nouveau_gerant_a_la_constitution.docx");
    legalDocument.setStepperConfigFilePath("AGO_SARL_pv_nomination_d_un_nouveau_gerant_a_la_constitution_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SARL_pv_nomination_d_un_nouveau_gerant_a_la_constitution_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    descriptionSection.setTitle("PV AGO Nomination gérant à la constitution");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Nomination gérant à la constitution en toute simplicité.\n" +

    "Statuts générés en 10mn.");

    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}




@ChangeSet(order = "057", author = AuthorsConstants.GHABI_HAMZA , id = "057_ago_sarl_pv_constatation_deces_gerant_nommination_nouveau_gerant_LegalDocument")
public void ago_sarl_pv_constatation_deces_gerant_nommination_nouveau_gerant_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();

    
    legalDocument.setId("5dad0d7dd1a76c479c02azerty33");
    legalDocument.setShortName("PV AGO Constatation décès du gérant et nomination d'un nouveau gérant");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Constatation décès du gérant et nomination d'un nouveau gérant");
    legalDocument.setKeywords("ago sarl pv constatation décés  de gérant et nommination nouveau gérant");
    legalDocument.setDescription("PV AGO Constatation décès du gérant et nomination d'un nouveau gérant");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("ago_sarl_pv_constatation_deces_gerant_nommination_nouveau_gerant.docx");
    legalDocument.setStepperConfigFilePath("ago_sarl_pv_constatation_deces_gerant_nommination_nouveau_gerant_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("ago_sarl_pv_constatation_deces_gerant_nommination_nouveau_gerant_workflow_configuration.json");

    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    

    
    descriptionSection.setTitle("PV AGO Constatation décès du gérant et nomination d'un nouveau gérant:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votrePV AGO Constatation décès du gérant et nomination d'un nouveau gérant en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}


@ChangeSet(order = "058", author = AuthorsConstants.GHABI_HAMZA , id = "058_sarl_pv_revocation_gerant_nommination_nouveau_gerant_statutaire_LegalDocument")
public void sarl_pv_revocation_gerant_nommination_nouveau_gerant_statutaire_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty34");
    legalDocument.setShortName("PV AGE Révocation du gérant et nomination d'un nouveau gérant statutaire");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGE Révocation du gérant et nomination d'un nouveau gérant statutaire");
    legalDocument.setKeywords("pv révocation de gérant et nommination nouveau gérant statutaire");
    legalDocument.setDescription("PV AGE Révocation du gérant et nomination d'un nouveau gérant statutaire");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("sarl_pv_revocation_gerant_nommination_nouveau_gerant_statutaire.docx");
    legalDocument.setStepperConfigFilePath("sarl_pv_revocation_gerant_nommination_nouveau_gerant_statutaire_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("sarl_pv_revocation_gerant_nommination_nouveau_gerant_statutaire_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGE Révocation du gérant et nomination d'un nouveau gérant statutaire:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Révocation du gérant et nomination d'un nouveau gérant statutaire en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "059", author = AuthorsConstants.GHABI_HAMZA , id = "059_sarl_pv_nommination_nouveau_gerant_statutaire_LegalDocument")
public void sarl_pv_nommination_nouveau_gerant_statutaire_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty35");
    legalDocument.setShortName("PV AGE Nomination d'un nouveau gérant statutaire");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGE Nomination d'un nouveau gérant statutaire");
    legalDocument.setKeywords("pv sarl nommination nouveau gérant statutaire");
    legalDocument.setDescription("PV AGE Nomination d'un nouveau gérant statutaire");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("sarl_pv_nommination_nouveau_gerant_statutaire.docx");
    legalDocument.setStepperConfigFilePath("sarl_pv_nommination_nouveau_gerant_statutaire_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("sarl_pv_nommination_nouveau_gerant_statutaire_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGE Nomination d'un nouveau gérant statutaire:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Nomination d'un nouveau gérant statutaire en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "060", author = AuthorsConstants.GHABI_HAMZA , id = "060_pv_sarl_demission_gerant_nommination_nouveau_gerant-statutaire_LegalDocument")
public void pv_sarl_demission_gerant_nommination_nouveau_gerant_statutaire_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty36");
    legalDocument.setShortName("PV AGE Démission du gérant et nomination d'un nouveau gérant statutaire");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGE Démission du gérant et nomination d'un nouveau gérant statutaire");
    legalDocument.setKeywords("dem ger SARL");
    legalDocument.setDescription("PV AGE Démission du gérant et nomination d'un nouveau gérant statutaire");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("pv_sarl_demission_gerant_nommination_nouveau_gerant_statutaire.docx");
    legalDocument.setStepperConfigFilePath("pv_sarl_demission_gerant_nommination_nouveau_gerant_statutaire.json");
    legalDocument.setWorkflowConfigFilePath("pv_sarl_demission_gerant_nommination_nouveau_gerant_statutaire.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGE Démission du gérant et nomination d'un nouveau gérant statutaire:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Démission du gérant et nomination d'un nouveau gérant statutaire en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "061", author = AuthorsConstants.GHABI_HAMZA , id = "061_age_sarl_pv_constatation_deces_gerant_nommination_nouveau_gerant_statutaire_LegalDocument")
public void age_sarl_pv_constatation_deces_gerant_nommination_nouveau_gerant_statutaire_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty37");
    legalDocument.setShortName("PV AGE Constatation décès du gérant et nomination d'un nouveau gérant statutaire");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGE Constatation décès du gérant et nomination d'un nouveau gérant statutaire");
    legalDocument.setKeywords("dec ger SARL");
    legalDocument.setDescription("PV AGE Constatation décès du gérant et nomination d'un nouveau gérant statutaire");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("age_sarl_pv_constatation_deces_gerant_nommination_nouveau_gerant_statutaire.docx");
    legalDocument.setStepperConfigFilePath("age_sarl_pv_constatation_deces_gerant_nommination_nouveau_gerant_statutaire_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("age_sarl_pv_constatation_deces_gerant_nommination_nouveau_gerant_statutaire_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGE Constatation décès du gérant et nomination d'un nouveau gérant statutaire:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Constatation décès du gérant et nomination d'un nouveau gérant statutaire en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "062", author = AuthorsConstants.GHABI_HAMZA , id = "062_AGO_SARL_PV_renouvellement_du_mandat_du_gerant_LegalDocument")
public void AGO_SARL_PV_renouvellement_du_mandat_du_gerant_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty38");
    legalDocument.setShortName("PV AGO Renouvellement mandats  ");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Renouvellement mandats");
    legalDocument.setKeywords("AGO SARL PV renouvellement du mandat du gérant");
    legalDocument.setDescription("PV AGO Renouvellement mandats");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SARL_PV_renouvellement_du_mandat_du_gerant.docx");
    legalDocument.setStepperConfigFilePath("AGO_SARL_PV_renouvellement_du_mandat_du_gerant_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SARL_PV_renouvellement_du_mandat_du_gerant_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Renouvellement mandats:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Renouvellement mandats en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "063", author = AuthorsConstants.GHABI_HAMZA , id = "063_AGO_SARL_PV_renouvellement_du_mandat_CAC_LegalDocument")
public void AGO_SARL_PV_renouvellement_du_mandat_CAC_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty39");
    legalDocument.setShortName("PV AGO Renouvellement CAC ");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Renouvellement CAC ");
    legalDocument.setKeywords("AGO SARL PV renouvellement du mandat CAC");
    legalDocument.setDescription("PV AGO Renouvellement CAC ");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SARL_PV_renouvellement_du_mandat_CAC.docx");
    legalDocument.setStepperConfigFilePath("AGO_SARL_PV_renouvellement_du_mandat_CAC_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SARL_PV_renouvellement_du_mandat_CAC_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Renouvellement CAC:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Renouvellement CAC en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "064", author = AuthorsConstants.GHABI_HAMZA , id = "064_AGO_SARL_PV_nommination_nouveau_CAC_LegalDocument")
public void AGO_SARL_PV_nommination_nouveau_CAC_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty40");
    legalDocument.setShortName("PV AGO Nomination CAC");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Nomination CAC");
    legalDocument.setKeywords("const SARL");
    legalDocument.setDescription("PV AGO Nomination CAC");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SARL_PV_nommination_nouveau_CAC.docx");
    legalDocument.setStepperConfigFilePath("AGO_SARL_PV_nommination_nouveau_CAC_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SARL_PV_nommination_nouveau_CAC_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Nomination CAC:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Nomination CAC en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "065", author = AuthorsConstants.GHABI_HAMZA , id = "065_AGO_SARL_PV_constatation_deces_CAC_nommination_nouveau_CAC_LegalDocument")
public void AGO_SARL_PV_constatation_deces_CAC_nommination_nouveau_CAC_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty41");
    legalDocument.setShortName("PV AGO Constatation du décès du CAC et nomination d’un nouveau CAC");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Constatation du décès du CAC et nomination d’un nouveau CAC");
    legalDocument.setKeywords("AGO SARL PV constatation du décés CAC et nommination du nouveau CAC");
    legalDocument.setDescription("PV AGO Constatation du décès du CAC et nomination d’un nouveau CAC");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SARL_PV_constatation_deces_CAC_nommination_nouveau_CAC.docx");
    legalDocument.setStepperConfigFilePath("AGO_SARL_PV_constatation_deces_CAC_nommination_nouveau_CAC_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SARL_PV_constatation_deces_CAC_nommination_nouveau_CAC_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Constatation du décès du CAC et nomination d’un nouveau CAC:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Constatation du décès du CAC et nomination d’un nouveau CAC en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "051", author = AuthorsConstants.GHABI_HAMZA , id = "051_AGO_Approbation_Etat_Financier_Resultat_deficitaire_Report_nouveau_LegalDocument")
public void AGO_Approbation_Etat_Financier_Resultat_deficitaire_Report_nouveau_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty27");
    legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat déficitaires et report à nouveau");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat déficitaires et report à nouveau");
    legalDocument.setKeywords("AGO Approbation 3");
    legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat déficitaires et report à nouveau");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_Approbation_Etat_Financier_Resultat_deficitaire_Report_nouveau.docx");
    legalDocument.setStepperConfigFilePath("AGO_Approbation_Etat_Financier_Resultat_deficitaire_Report_nouveau_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_Approbation_Etat_Financier_Resultat_deficitaire_Report_nouveau_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat déficitaires et report à nouveau :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat déficitaires et report à nouveau en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

 @ChangeSet(order = "024", author = AuthorsConstants.BEN_ROMDHANE_AWATEF , id = "024-addagoALegalDocument")
public void addagoALegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c01");
    legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau et distribution de dividendes");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau et distribution de dividendes");
    legalDocument.setKeywords("AGO Approbation 2 ");
    legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau et distribution de dividendes");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("ago_Approbation_des_etats_financiers_avec_resultat_beneficiaire_avec_report_a_nouveau_avec_distribution_des_dividendes.docx");
    legalDocument.setStepperConfigFilePath("ago_Approbation_des_etats_financiers_avec_resultat_beneficiaire_avec_report_a_nouveau_avec_distribution_des_dividendes_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("ago_Approbation_des_etats_financiers_avec_resultat_beneficiaire_avec_report_a_nouveau_avec_distribution_des_dividendes_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau et distribution de dividendes :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau et distribution de dividendes en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}


 @ChangeSet(order = "025", author = AuthorsConstants.BEN_ROMDHANE_AWATEF , id = "025-addagoBLegalDocument")
 public void addagoBLegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c02");
     legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat bénéficiaire et report à nouveau");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat bénéficiaire et report à nouveau");
     legalDocument.setKeywords("AGO Approbation report à nouveau 1");
     legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat bénéficiaire et report à nouveau");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("ago_Approbation_des_etats_financiers_avec_resultat_beneficiaire_avec_report_a_nouveau.docx");
     legalDocument.setStepperConfigFilePath("ago_Approbation_des_etats_financiers_avec_resultat_beneficiaire_avec_report_a_nouveau_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("ago_Approbation_des_etats_financiers_avec_resultat_beneficiaire_avec_report_a_nouveau_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat bénéficiaire et report à nouveau :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat bénéficiaire et report à nouveau en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }


 @ChangeSet(order = "069", author = AuthorsConstants.BEN_ROMDHANE_AWATEF , id = "069_AGO_Approbation_des_etats_financiers_avec_resultat_beneficiaire_et_distribution_des_dividendes_LegalDocument")
 public void AGO_Approbation_des_etats_financiers_avec_resultat_beneficiaire_et_distribution_des_dividendes_LegalDocument(MongoTemplate mongoTemplate) {     
     LegalDocument legalDocument;

     List<DescriptionSection> descriptionSections = new ArrayList<>();
     DescriptionSection descriptionSection;
     List<String> autoFillConcernedEntities = new ArrayList<>();
     autoFillConcernedEntities.add(Company.class.getSimpleName());

     legalDocument = new LegalDocument();
     legalDocument.setId("5dad0d7dd1a76c479c44");
     legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat bénéficiaire et distribution des dividendes");
     legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
     legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat bénéficiaire et distribution des dividendes");
     legalDocument.setKeywords("AGO Aapp bénéficiaire ");
     legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat bénéficiaire et distribution des dividendes");
     legalDocument.setTemplatePreviewPath("empty_preview");
     legalDocument.setTemplateFilePath("AGO_Approbation_des_etats_financiers_avec_resultat_beneficiaire_et_distribution_des_dividendes.docx");
     legalDocument.setStepperConfigFilePath("AGO_Approbation_des_etats_financiers_avec_resultat_beneficiaire_et_distribution_des_dividendes_stepper_configuration.json");
     legalDocument.setWorkflowConfigFilePath("AGO_Approbation_des_etats_financiers_avec_resultat_beneficiaire_et_distribution_des_dividendes_workflow_configuration.json");
     legalDocument.setCategoryId("empty_category");
     legalDocument.setLawyerId("empty_lawyer");
     legalDocument.setCreatedDate(Instant.now());
     descriptionSection = new DescriptionSection();
     
     descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat bénéficiaire et distribution des dividendes :");
     descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat bénéficiaire et distribution des dividendes en toute simplicité.\n" +
         "Statuts générés en 10mn.");
     descriptionSections.add(descriptionSection);
     legalDocument.setDescriptionSections(descriptionSections);
     legalDocument.setPrice(49.99f);
     legalDocument.setDocumentsRecommendationId(new ArrayList<>());
     mongoTemplate.save(legalDocument);
 }

@ChangeSet(order = "066", author = AuthorsConstants.GHABI_HAMZA , id = "066_AGO_Approbation_Etat_Financier_Resultat_deficitaire_distribution_dividendes_LegalDocument")
public void Approbation_Etat_Financier_Resultat_deficitaire_distribution_dividendes_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty42");
    legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat déficitaire et distribution des dividendes");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat déficitaire et distribution des dividendes");
    legalDocument.setKeywords("SARL AGO Approbation 4 ");
    legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat déficitaire et distribution des dividendes");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("Approbation_Etat_Financier_Resultat_deficitaire_distribution_dividendes.docx");
    legalDocument.setStepperConfigFilePath("Approbation_Etat_Financier_Resultat_deficitaire_distribution_dividendes_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("Approbation_Etat_Financier_Resultat_deficitaire_distribution_dividendes_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat déficitaire et distribution des dividendes :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat déficitaire et distribution des dividendes en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "067", author = AuthorsConstants.GHABI_HAMZA , id = "067_AGO_Approbation_Etat_Financier_Resultat_deficitaire_report_nouveau_distribution_dividendes_LegalDocument")
public void AGO_Approbation_Etat_Financier_Resultat_deficitaire_report_nouveau_distribution_dividendes_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty43");
    legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat déficitaires avec report à nouveau avec distribution des dividendes");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat déficitaires avec report à nouveau avec distribution des dividendes");
    legalDocument.setKeywords("AGO Approbation des états Financiers avec Resultat déficitaire avec report nouveau avec distribution des dividendes");
    legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat déficitaires avec report à nouveau avec distribution des dividendes");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_Approbation_Etat_Financier_Resultat_deficitaire_report_nouveau_distribution_dividendes.docx");
    legalDocument.setStepperConfigFilePath("AGO_Approbation_Etat_Financier_Resultat_deficitaire_report_nouveau_distribution_dividendes_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_Approbation_Etat_Financier_Resultat_deficitaire_report_nouveau_distribution_dividendes_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat déficitaires avec report à nouveau avec distribution des dividendes :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat déficitaires avec report à nouveau avec distribution des dividendes en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}


@ChangeSet(order = "070", author = AuthorsConstants.SOUISSI_YASSMINE , id = "070_Pv_age_changement_de_denomination_LegalDocument")
public void Pv_age_changement_de_denomination_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty44");
    legalDocument.setShortName("PV AGE Changement de denomination");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGE Changement de denomination");
    legalDocument.setKeywords("Pv Age Changement De Denomination");
    legalDocument.setDescription("PV AGE Changement de denomination");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("Pv-age-changement-de-denomination.docx");
    legalDocument.setStepperConfigFilePath("Pv_age_changement_de_denomination_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("Pv_age_changement_de_denomination_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGE Changement de denomination:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Changement de denomination en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "071", author = AuthorsConstants.SOUISSI_YASSMINE , id = "071_Pv_Age_Transfert_Du_Siege_LegalDocument")
public void Pv_Age_Transfert_Du_Siege_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty45");
    legalDocument.setShortName("PV AGE Transfert de siège social");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGE Transfert de siège social");
    legalDocument.setKeywords("Pv Age Transfert Du Siege");
    legalDocument.setDescription("PV AGE Transfert de siège social");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("Pv_Age_Transfert_Du_Siege.docx");
    legalDocument.setStepperConfigFilePath("Pv_Age_Transfert_Du_Siege_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("Pv_Age_Transfert_Du_Siege_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGE Transfert de siège social :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Transfert de siège social en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "072", author = AuthorsConstants.SOUISSI_YASSMINE , id = "072_PV_AGE_Sarl_Dissolution_Anticipee_LegalDocument")
public void PV_AGE_Sarl_Dissolution_Anticipee_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty46");
    legalDocument.setShortName("PV AGE Dissolution");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGE Dissolution");
    legalDocument.setKeywords("PV AGE Sarl Dissolution Anticipee");
    legalDocument.setDescription("PV AGE Sarl Dissolution");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("PV_AGE_Sarl_Dissolution_Anticipee.docx");
    legalDocument.setStepperConfigFilePath("pv_age_sarl_dissolution_anticipee_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("pv_age_sarl_dissolution_anticipee_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV_AGE_Sarl_Dissolution_Anticipee_LegalDocument:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Dissolution  en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}
@ChangeSet(order = "073", author = AuthorsConstants.BEN_HAMOUDA_TAREK , id = "073_AGE_SUARL_PV_transfert_du_siège_social_LegalDocument")
public void AGE_SUARL_PV_transfert_du_siège_social_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty47");
    legalDocument.setShortName("PV AGE Transfert du siège social");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGE Transfert du siège social");
    legalDocument.setKeywords("transfert siège SUARL");
    legalDocument.setDescription("PV AGE Transfert du siège social");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGE_SUARL_PV_transfert_du_siège_social.docx");
    legalDocument.setStepperConfigFilePath("AGE_SUARL_PV_transfert_du_siège_social_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGE_SUARL_PV_transfert_du_siège_social_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGE Transfert du siège social :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Transfert du siège social en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "074", author = AuthorsConstants.BEN_HAMOUDA_TAREK , id = "074_AGE_SUARL_PV_changement_de_dénomination_sociale_LegalDocument")
public void AGE_SUARL_PV_changement_de_dénomination_sociale_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty48");
    legalDocument.setShortName("PV AGE Changement de dénomination sociale");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGE Changement de dénomination sociale");
    legalDocument.setKeywords("dénomination SUARL");
    legalDocument.setDescription("PV AGE Changement de dénomination sociale");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGE_SUARL_PV_changement_de_dénomination_sociale.docx");
    legalDocument.setStepperConfigFilePath("AGE_SUARL_PV_changement_de_dénomination_sociale_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGE_SUARL_PV_changement_de_dénomination_sociale_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGE Changement de dénomination sociale :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGE Changement de dénomination sociale en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "075", author = AuthorsConstants.BEN_HAMOUDA_TAREK , id = "075_AGO_SUARL_PV_approbation_des_comptes_avec_résultat_bénéficiaire_et_report_a_nouveau_LegalDocument")
public void AGO_SUARL_PV_approbation_des_comptes_avec_résultat_bénéficiaire_et_report_a_nouveau_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty49");
    legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat bénéficiaire et report à nouveau");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat bénéficiaire et report à nouveau");
    legalDocument.setKeywords("AGO Approbation1 SUARL");
    legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat bénéficiaire et report à nouveau");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SUARL_PV_approbation_des_comptes_avec_résultat_bénéficiaire_et_report_a_nouveau.docx");
    legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_approbation_des_comptes_avec_résultat_bénéficiaire_et_report_a_nouveau_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_approbation_des_comptes_avec_résultat_bénéficiaire_et_report_a_nouveau_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat bénéficiaire et report à nouveau :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat bénéficiaire et report à nouveau  en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "076", author = AuthorsConstants.BEN_HAMOUDA_TAREK , id = "076_AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_bénéficiaire_et_distribution_de_dividendes_LegalDocument")
public void AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_bénéficiaire_et_distribution_de_dividendes_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty50");
    legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat bénéficiaire et distribution de dividendes");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat bénéficiaire et distribution de dividendes");
    legalDocument.setKeywords("AGO Approbation2 SUARL");
    legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat bénéficiaire et distribution de dividendes");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_bénéficiaire_et_distribution_de_dividendes.docx");
    legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_bénéficiaire_et_distribution_de_dividendes_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_bénéficiaire_et_distribution_de_dividendes_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat bénéficiaire et distribution de dividendes :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat bénéficiaire et distribution de dividendes en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "077", author = AuthorsConstants.BEN_HAMOUDA_TAREK , id = "077_AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_et_report_a_nouveau_LegalDocument")
public void AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_et_report_a_nouveau_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty51");
    legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat déficitaires et report à nouveau");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat déficitaires et report à nouveau");
    legalDocument.setKeywords("AGO Approbation3 SUARL");
    legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat déficitaires et report à nouveau");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_et_report_a_nouveau.docx");
    legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_et_report_a_nouveau_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_et_report_a_nouveau_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat déficitaires et report à nouveau :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat déficitaires et report à nouveau en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "078", author = AuthorsConstants.BEN_HAMOUDA_TAREK , id = "078_AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_avec_report_a_nouveau_et_distribution_des_dividendes_LegalDocument")
public void AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_avec_report_a_nouveau_et_distribution_des_dividendes_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty52");
    legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat déficitaire avec report à nouveau et distribution des dividendes");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat déficitaire avec report à nouveau et distribution des dividendes");
    legalDocument.setKeywords("AGO Approbation4 SUARL");
    legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat déficitaire avec report à nouveau et distribution des dividendes");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_avec_report_a_nouveau_et_distribution_des_dividendes.docx");
    legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_avec_report_a_nouveau_et_distribution_des_dividendes_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_avec_report_a_nouveau_et_distribution_des_dividendes_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat déficitaire avec report à nouveau et distribution des dividendes :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat déficitaire avec report à nouveau et distribution des dividendes en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "079", author = AuthorsConstants.BEN_HAMOUDA_TAREK , id = "079_AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_et_distribution_des_dividendes_LegalDocument")
public void AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_et_distribution_des_dividendes_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty53");
    legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat déficitaire et distribution des dividendes");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat déficitaire et distribution des dividendes");
    legalDocument.setKeywords("AGO Approbation5 SUARL");
    legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat déficitaire et distribution des dividendes");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_et_distribution_des_dividendes.docx");
    legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_et_distribution_des_dividendes_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_déficitaire_et_distribution_des_dividendes_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat déficitaire et distribution des dividendes :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat déficitaire et distribution des dividendes en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "080", author = AuthorsConstants.BEN_HAMOUDA_TAREK , id = "080_AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_bénéficiaire_avec_report_a_nouveau_et_distribution_des_dividendes_LegalDocument")
public void AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_bénéficiaire_avec_report_a_nouveau_et_distribution_des_dividendes_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty54");
    legalDocument.setShortName("PV AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau et distribution des dividendes");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("PV AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau et distribution des dividendes");
    legalDocument.setKeywords("AGO Approbation6 SUARL");
    legalDocument.setDescription("PV AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau et distribution des dividendes");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_bénéficiaire_avec_report_a_nouveau_et_distribution_des_dividendes.docx");
    legalDocument.setStepperConfigFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_bénéficiaire_avec_report_a_nouveau_et_distribution_des_dividendes_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGO_SUARL_PV_approbation_des_états_financiers_avec_résultat_bénéficiaire_avec_report_a_nouveau_et_distribution_des_dividendes_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("PV AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau et distribution des dividendes :");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre PV AGO Approbation des états financiers avec résultat bénéficiaire avec report à nouveau et distribution des dividendes en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "081", author = AuthorsConstants.BEN_HAMOUDA_TAREK , id = "081_AGE_SUARL_PV_Augmentation_de_capital_en_numéraire_LegalDocument")
public void AGE_SUARL_PV_Augmentation_de_capital_en_numéraire_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty55");
    legalDocument.setShortName("AGE SUARL PV augmentation de capital en numéraire");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("AGE SUARL PV augmentation de capital en numéraire");
    legalDocument.setKeywords("AGE augmentation en numéraire SUARL");
    legalDocument.setDescription("AGE SUARL PV augmentation de capital en numéraire");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGE_SUARL_PV_Augmentation_de_capital_en_numéraire.docx");
    legalDocument.setStepperConfigFilePath("AGE_SUARL_PV_Augmentation_de_capital_en_numéraire_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGE_SUARL_PV_Augmentation_de_capital_en_numéraire_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("AGE_SUARL_PV_Augmentation_de_capital_en_numéraire:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre AGE SUARL PV augmentation de capital en numéraire en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}

@ChangeSet(order = "082", author = AuthorsConstants.BEN_HAMOUDA_TAREK , id = "082_AGE_SUARL_PV_Augmentation_de_capital_par_conversion_de_créance_LegalDocument")
public void AGE_SUARL_PV_Augmentation_de_capital_par_conversion_de_créance_LegalDocument(MongoTemplate mongoTemplate) {     
    LegalDocument legalDocument;

    List<DescriptionSection> descriptionSections = new ArrayList<>();
    DescriptionSection descriptionSection;
    List<String> autoFillConcernedEntities = new ArrayList<>();
    autoFillConcernedEntities.add(Company.class.getSimpleName());

    legalDocument = new LegalDocument();
    legalDocument.setId("5dad0d7dd1a76c479c02azerty56");
    legalDocument.setShortName("AGE SUARL PV augmentation de capital par conversion de créance");
    legalDocument.setAutoFillConcernedEntities(autoFillConcernedEntities);
    legalDocument.setFullName("AGE SUARL PV augmentation de capital par conversion de créance");
    legalDocument.setKeywords("AGE augmentation par conversion de créance SUARL");
    legalDocument.setDescription("AGE SUARL PV augmentation de capital par conversion de créance");
    legalDocument.setTemplatePreviewPath("empty_preview");
    legalDocument.setTemplateFilePath("AGE_SUARL_PV_Augmentation_de_capital_par_conversion_de_créance.docx");
    legalDocument.setStepperConfigFilePath("AGE_SUARL_PV_Augmentation_de_capital_par_conversion_de_créance_stepper_configuration.json");
    legalDocument.setWorkflowConfigFilePath("AGE_SUARL_PV_Augmentation_de_capital_par_conversion_de_créance_workflow_configuration.json");
    legalDocument.setCategoryId("empty_category");
    legalDocument.setLawyerId("empty_lawyer");
    legalDocument.setCreatedDate(Instant.now());
    descriptionSection = new DescriptionSection();
    
    descriptionSection.setTitle("AGE_SUARL_PV_Augmentation_de_capital_par_conversion_de_créance:");
    descriptionSection.setContent("Procédure 100% en ligne pour créer votre AGE SUARL PV augmentation de capital par conversion de créance en toute simplicité.\n" +
        "Statuts générés en 10mn.");
    descriptionSections.add(descriptionSection);
    legalDocument.setDescriptionSections(descriptionSections);
    legalDocument.setPrice(49.99f);
    legalDocument.setDocumentsRecommendationId(new ArrayList<>());
    mongoTemplate.save(legalDocument);
}



}
 
 
 
 
 
  
 
 
 
 
 
 
 
 
 
 
    
   
