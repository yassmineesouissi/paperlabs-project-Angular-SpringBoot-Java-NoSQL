package com.apeiron.docflow.service.impl;

import com.apeiron.docflow.domain.Bookmark;
import com.apeiron.docflow.domain.Input;
import com.apeiron.docflow.domain.InputData;
import com.apeiron.docflow.service.DocumentGenerationService;
import com.apeiron.docflow.service.FileManipulationService;
import com.apeiron.docflow.service.FileValidationService;
import com.apeiron.docflow.service.InputProcessingService;

import org.apache.commons.math3.analysis.function.Add;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

import java.io.*;
import java.net.URL;
import java.nio.file.FileSystemException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Service class for managing document generation.
 */
@Service
public class DocumentGenerationServiceImpl implements DocumentGenerationService {
    private final FileManipulationService fileManipulationService;
    private final FileValidationService fileValidationService;
    private final InputProcessingService inputProccesingService;
    private static final String BOOKMARK_TYPE_DEFAULT = "DEFAULT";
    private static final String BOOKMARK_TYPE_PARAGRAPH_WITH_BOOKMARKS = "PARAGRAPH_WITH_BOOKMARKS";
    private static final String BOOKMARK_TYPE_PAGE_WITH_BOOKMARKS = "PAGE_WITH_BOOKMARKS";
    private static final String BOOKMARK_TYPE_USER_INPUT = "USER_INPUT";
    private static final String BOOKMARK_TYPE_INPUT_GENERATOR = "INPUT_GENERATOR";
    private static final String SIMPLE_TYPES_KEY = "text";
    private final List<String> simpleTypes = new ArrayList<>(Arrays.asList("TEXT", "EMAIL", "IMAGE", "NUMBER", "TEXTAREA", "DATE", "TIME", "COUNTRY","CIN"));
    private final List<String> multiValueTypes = new ArrayList<>(Arrays.asList("CONVERT","SELECT", "RADIO", "CHECKBOX", "SELECT_INPUT_GENERATOR"));
    private Map<String, InputData> stepperData; // contains inputs returned from stepper form
    private Map<String, Input> inputsWithBookmarks = new HashMap<>();
    private Map<String, InputData> stepperDataWithBookmarks;
    private Map<String, Bookmark> allCustomBookmarks = new HashMap<>();
    private Map<String, String> paragraphsWithBookmarksToDelete; // bookmark list of bookmarks that contain other bookmarks
    private Map<String, String> pagesWithBookmarksToDelete;
    private Map<String, String> customBookmarksValues;


    private int numberOfBlocs; // number of times a bloc should be duplicated
    private List<String> generatedBlocListBySelectInputGeneratorId;
    private List<String> listInputsByBlocId; // list of inputs in a given bloc
    private List<String> listConcernedInputsOfSelectInputGenerator; // list that contains all concerned input contained in concerned blocs of a given select_input_generator
    private List<Bookmark> selectInputGeneratorCustomBookmarksList;
    private List<String> bookmarkConcernedInputsList; // we convert value attribute's value (input prefix) to string list ["input_nom_prÃ©nom_associÃ©_", "input_nombre_parts_associÃ©_"]
    private String paragraphToDuplicate;
    private String paragraphAfterDuplication; // resulting paragraph after duplication
    private List<String> inputValuesListToFillDuplicatedParagraphWith;
    
    
    


    private XWPFDocument document = new XWPFDocument();
    private List<String> bookmarkIdListFoundInDocXFile;
    private URL urlStepper;
    private String filledFileName;
    
    
     // private static final String FILLED_FILE_NAME_PREFIX="D:/Rami-Paperlabs/Paperlabs/paper-labs/webapp/target/classes/static/folder/";
      //private static final String FILLED_FILE_NAME_PREFIX="C:/awatef/paperlabsnewv/webapp/target/classes/static/folder/";
    
      //  private static final String FILLED_FILE_NAME_PREFIX="D:/hamza/paperlabs/paperlabsnewv/webapp/target/classes/static/folder/";

        private static final String FILLED_FILE_NAME_PREFIX="D:/hamza/paperlabsnewv/webapp/target/classes/static/folder/";

     // private static final String FILLED_FILE_NAME_PREFIX="/var/www/html/static/folder/";

    public DocumentGenerationServiceImpl(FileManipulationService fileManipulationService, FileValidationService fileValidationService, InputProcessingService inputProccesingService) {
        this.fileManipulationService = fileManipulationService;
        this.fileValidationService = fileValidationService;
        this.inputProccesingService = inputProccesingService;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public String generateDocXFile(Map<String, InputData> stepperData, URL urlStepper, String urlDocument, URL urlWorkflow) throws IOException{
    	   System.out.println("lllllllllllllllllllll 81 doc");
        String[] bookmarksReferences;
        Input inputWithBookmarks;
        this.urlStepper = urlStepper;
        this.stepperData = inputProccesingService.refactorInput(stepperData);
        paragraphsWithBookmarksToDelete = new HashMap<>();
        pagesWithBookmarksToDelete = new HashMap<>();
        customBookmarksValues= new HashMap<>();
        if(this.stepperData == null) {
            throw new NullPointerException("Unable to generate document, stepper data cannot be null.");
        }
        if(urlStepper == null) {
            throw new NullPointerException("Unable to generate document, stepper URL cannot be null.");
        }
        if(urlDocument == null) {
            throw new NullPointerException("Unable to generate document, ms Word (.docx) model URL cannot be null.");
        }
        allCustomBookmarks = this.fileManipulationService.getAllCustomBookmarks(urlStepper);
        filterInputsWithBookmarks();
        filterStepperDataInputsWithBookmarks();
        openFile(urlDocument);

        List<String> selectInputGeneratorList = getInputIdsOfTypeSelectGeneratedInput(); // get list of inputs of type select_generated_input
        selectInputGeneratorList.forEach(inputId -> {
            FileReader fileReader;
            try {
            	  System.out.println("lllllllllllllllllllll 107 doc");
                generatedBlocListBySelectInputGeneratorId = new ArrayList<>();
                fileReader = new FileReader(urlWorkflow.getPath());
                fileManipulationService.getConstraintsByInputIdAndValue(inputId, "select_input_generator", fileReader).forEach(constraint ->  //get list of bloc constraints
                    generatedBlocListBySelectInputGeneratorId.add(constraint.getElementId())
                );
                listConcernedInputsOfSelectInputGenerator = new ArrayList<>();
                generatedBlocListBySelectInputGeneratorId.forEach(blocId -> { // get list of inputs in a given bloc
                    listInputsByBlocId = getInputIdsByBlocId(blocId);
                    // add bloc's list of inputs to the select_generated_input's related inputs list
                    listConcernedInputsOfSelectInputGenerator.addAll(listInputsByBlocId);
                });
                selectInputGeneratorCustomBookmarksList = getBookmarksByInputOfTypeSelectGeneratedInput(inputId, this.stepperData.get(inputId).getValue()); // list of select_generated_input's related bookmarks
                selectInputGeneratorCustomBookmarksList.forEach(bookmark -> {
                            List<XWPFParagraph> paragraphs = document.getParagraphs();
                            boolean found = false;
                            for (XWPFParagraph paragraph1 : paragraphs)
                            {
                                CTP ctp = paragraph1.getCTP();
                                List<CTBookmark> bookmarks = ctp.getBookmarkStartList();
                                for(CTBookmark bookmark1 : bookmarks)
                                {
                                    if(bookmark1.getName().equals(bookmark.getBookmarkId()))
                                    {
                                        paragraphToDuplicate = paragraph1.getText();
                                        found = true;
                                        break;
                                    }
                                }
                                if(found) break;
                            }
                    numberOfBlocs = Integer.parseInt(this.stepperData.get(inputId).getValue()); // get number of repetitions
                    StringBuilder stringBuilder = new StringBuilder();
                    for(int i=0; i< numberOfBlocs; i++) { // duplicate the paragraph
                        stringBuilder.append(paragraphToDuplicate);
                        stringBuilder.append("\n");
                    }
                    paragraphAfterDuplication = stringBuilder.toString();
                    bookmarkConcernedInputsList = getBookmarkValuePrefixArray(bookmark.getValue());
                    inputValuesListToFillDuplicatedParagraphWith = new ArrayList<>();
                    for(int i=1; i<=numberOfBlocs; i++) { // create list of values inputs to fill duplicated paragraph
                        final int j = i;
                        bookmarkConcernedInputsList.forEach(concernedInputPrefix ->
                            inputValuesListToFillDuplicatedParagraphWith.add(this.stepperData.get(concernedInputPrefix+j) !=null ?
                                    this.stepperData.get(concernedInputPrefix+j).getValue() : "_______________ ")
                                                                                               
                        );
                    }
                    inputValuesListToFillDuplicatedParagraphWith.forEach(res ->
                            paragraphAfterDuplication = paragraphAfterDuplication.replaceFirst("_______________ ", res) // fill duplicated paragraph with data
                    );
                    updateGeneratedInputBookmarksInCustomBookmarksList(bookmark.getBookmarkId(), paragraphAfterDuplication); // update bookmark value with new one in all custom bookmarks list
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        for(Map.Entry<String, InputData> stepperDataWithBookmarkDataEntry : this.stepperDataWithBookmarks.entrySet()) {
            inputWithBookmarks = this.inputsWithBookmarks.get(stepperDataWithBookmarkDataEntry.getKey());
            bookmarksReferences = getBookmarksReferencesPerInputByInputValue(inputWithBookmarks, stepperDataWithBookmarkDataEntry.getValue().getValue());
            groupInputBookmarksByBookmarkType(bookmarksReferences, stepperDataWithBookmarkDataEntry.getValue().getValue());
        }
        System.out.println("lllllllllllllllllllll sort du for doc");
        
        //filledFileName = new SimpleDateFormat("'docx_filled_'yyyyMMddHHmmss'.docx'").format(new Date());
        filledFileName = new SimpleDateFormat("'docx_filled_'yyyyMMddHHmm'.docx'").format(new Date());
        getBookmarkIdListFoundInDocXFile();
        for (String s:bookmarkIdListFoundInDocXFile) {
			System.out.println("***********************s==> "+s);
		}
     
        
     // CDI
        bookmarkIdListFoundInDocXFile.add("prénom_du_representant_de_la_societé");
        bookmarkIdListFoundInDocXFile.add("prénom_employeur");
        bookmarkIdListFoundInDocXFile.add("nom_employeur");
        bookmarkIdListFoundInDocXFile.add("nom_de_lemployé");
        bookmarkIdListFoundInDocXFile.add("prénom_de_lemployé");
        bookmarkIdListFoundInDocXFile.add("nom_du_representant_de_la_societé");
        // CDI simple
        bookmarkIdListFoundInDocXFile.add("Salaire_mensuel_net_de_lemployé_chiffres");
        bookmarkIdListFoundInDocXFile.add("Article11_texte1");
        bookmarkIdListFoundInDocXFile.add("Dénomination_de_la_societé");
        bookmarkIdListFoundInDocXFile.add("Article11_texte2");
        bookmarkIdListFoundInDocXFile.add("Article11_texte3");
        bookmarkIdListFoundInDocXFile.add("Régime_de_travail_de_lemployé");
        bookmarkIdListFoundInDocXFile.add("Article11_texte4");
        bookmarkIdListFoundInDocXFile.add("Type_de_la_societé");
        bookmarkIdListFoundInDocXFile.add("Num_CIN_de_lemployé");
        bookmarkIdListFoundInDocXFile.add("Date_début_du_contrat");
        bookmarkIdListFoundInDocXFile.add("NomPrénom_representant_societé_signature");
        bookmarkIdListFoundInDocXFile.add("Adresse_de_employeur_physique");
        bookmarkIdListFoundInDocXFile.add("Article8_texte3");
        bookmarkIdListFoundInDocXFile.add("Article2_titre");
        bookmarkIdListFoundInDocXFile.add("CIN_de_employeur_physique");
        bookmarkIdListFoundInDocXFile.add("Article2_texte3");
        bookmarkIdListFoundInDocXFile.add("Article9_texte2");
        bookmarkIdListFoundInDocXFile.add("Adresse_de_lemployé");
        bookmarkIdListFoundInDocXFile.add("Article2_texte1");
        bookmarkIdListFoundInDocXFile.add("Article8_texte2");
        bookmarkIdListFoundInDocXFile.add("Adresse_de_la_societé");
        bookmarkIdListFoundInDocXFile.add("Salaire_mensuel_net_de_lemployé_lettres");
        bookmarkIdListFoundInDocXFile.add("Article2_texte2");
        bookmarkIdListFoundInDocXFile.add("Article8_texte1");
        bookmarkIdListFoundInDocXFile.add("Article9_texte1");
        bookmarkIdListFoundInDocXFile.add("Article10_titre");
        bookmarkIdListFoundInDocXFile.add("Nom_et_prénom_de_lemployé");
        bookmarkIdListFoundInDocXFile.add("Infos_employeur_physique");
        bookmarkIdListFoundInDocXFile.add("Article8_titre");
        bookmarkIdListFoundInDocXFile.add("Identifiant_unique_de_la_societé");
        bookmarkIdListFoundInDocXFile.add("Capital_social_de_la_societé");
        bookmarkIdListFoundInDocXFile.add("Article9_titre");
        bookmarkIdListFoundInDocXFile.add("Article11_titre");
        bookmarkIdListFoundInDocXFile.add("Infos_employeur_moral");
        bookmarkIdListFoundInDocXFile.add("Article10_texte3");
        bookmarkIdListFoundInDocXFile.add("Poste_de_lemployé");
        bookmarkIdListFoundInDocXFile.add("Durée_de_la_période_dessai");
        bookmarkIdListFoundInDocXFile.add("Article10_texte2");
        bookmarkIdListFoundInDocXFile.add("Article10_texte1");

        // Formulaire status 
        bookmarkIdListFoundInDocXFile.add("total_part_social");
        bookmarkIdListFoundInDocXFile.add("prenom_representant");
        bookmarkIdListFoundInDocXFile.add("prenom_Nom");
        bookmarkIdListFoundInDocXFile.add("date_passport");
        bookmarkIdListFoundInDocXFile.add("Societe");
        bookmarkIdListFoundInDocXFile.add("villenaissance_associe1");
        bookmarkIdListFoundInDocXFile.add("nationalite_associe1");
        bookmarkIdListFoundInDocXFile.add("pieceidentité_associe1");
        bookmarkIdListFoundInDocXFile.add("cin_associe1");
        bookmarkIdListFoundInDocXFile.add("prenom_Nom_ass1");
        bookmarkIdListFoundInDocXFile.add("prenom_Nom_ass2");
        bookmarkIdListFoundInDocXFile.add("denomination");
        bookmarkIdListFoundInDocXFile.add("lieu_signature");
        bookmarkIdListFoundInDocXFile.add("total_lettres");
        bookmarkIdListFoundInDocXFile.add("adress_associe1");
        bookmarkIdListFoundInDocXFile.add("identifiant_unique");
        bookmarkIdListFoundInDocXFile.add("siege_social");
        bookmarkIdListFoundInDocXFile.add("montant_lettre");
        bookmarkIdListFoundInDocXFile.add("date_cin");
        bookmarkIdListFoundInDocXFile.add("num_cin_representant");
        bookmarkIdListFoundInDocXFile.add("total_chiffre");
        bookmarkIdListFoundInDocXFile.add("num_passport");
        bookmarkIdListFoundInDocXFile.add("lieudelivrance");
        bookmarkIdListFoundInDocXFile.add("nom_representant");
        bookmarkIdListFoundInDocXFile.add("qualite_representant");
        bookmarkIdListFoundInDocXFile.add("date_signature");
        bookmarkIdListFoundInDocXFile.add("Dénomination_sociale");
        bookmarkIdListFoundInDocXFile.add("datenaissance_associe1");
        bookmarkIdListFoundInDocXFile.add("numerotation_sociale");
        bookmarkIdListFoundInDocXFile.add("objet");
        bookmarkIdListFoundInDocXFile.add("num_passport_representant");
        bookmarkIdListFoundInDocXFile.add("forme");
        bookmarkIdListFoundInDocXFile.add("adresse_siege_social");
        bookmarkIdListFoundInDocXFile.add("part_social_lettre");
        bookmarkIdListFoundInDocXFile.add("cin_representant");
        bookmarkIdListFoundInDocXFile.add("montant_chiffre");
        bookmarkIdListFoundInDocXFile.add("prenom_associe1");
        bookmarkIdListFoundInDocXFile.add("total_part_social");
        bookmarkIdListFoundInDocXFile.add("part_social_chiffre");
        bookmarkIdListFoundInDocXFile.add("capital_social");
        bookmarkIdListFoundInDocXFile.add("Nationalite");
        bookmarkIdListFoundInDocXFile.add("immatriculation");
        bookmarkIdListFoundInDocXFile.add("employeur_physique");
        bookmarkIdListFoundInDocXFile.add("employeur_moral");

        
        // ARACT
        bookmarkIdListFoundInDocXFile.add("forme_juridique_de_la_societe");
        bookmarkIdListFoundInDocXFile.add("nationalite_employe");
        bookmarkIdListFoundInDocXFile.add("numero_de_identifiant_unique");
        bookmarkIdListFoundInDocXFile.add("nom_prenom_employe");
        bookmarkIdListFoundInDocXFile.add("nom_du_representant_legal_de_la_societe");
        bookmarkIdListFoundInDocXFile.add("date_de_naissance_employe");
        bookmarkIdListFoundInDocXFile.add("adresse_employe");
        bookmarkIdListFoundInDocXFile.add("lieu_de_naissance_employe");
        bookmarkIdListFoundInDocXFile.add("date_de_conclusion_de_laccord");
        bookmarkIdListFoundInDocXFile.add("numero_cin");
        bookmarkIdListFoundInDocXFile.add("nom_de_la_societe");
        bookmarkIdListFoundInDocXFile.add("valeur_du_capital_de_la_societe");
        bookmarkIdListFoundInDocXFile.add("emission_cin");
        bookmarkIdListFoundInDocXFile.add("adresse_de_la_societe");

        // Lettre de demicion gerant 
        bookmarkIdListFoundInDocXFile.add("gerant1");
        bookmarkIdListFoundInDocXFile.add("denomination_social");
        bookmarkIdListFoundInDocXFile.add("denomination_social_2");
        bookmarkIdListFoundInDocXFile.add("dsiege_social");
        bookmarkIdListFoundInDocXFile.add("denomination_social_3");
        bookmarkIdListFoundInDocXFile.add("denomination_social_1");
        bookmarkIdListFoundInDocXFile.add("gerant_adresse");
        bookmarkIdListFoundInDocXFile.add("denomination_social_4");
        bookmarkIdListFoundInDocXFile.add("lieu_gerant");
        bookmarkIdListFoundInDocXFile.add("date_gerant");
        // NDA 
        bookmarkIdListFoundInDocXFile.add("Quelle_juridiction");
        bookmarkIdListFoundInDocXFile.add("adresse_du_siège_social_d");
        bookmarkIdListFoundInDocXFile.add("quelle_activité_partie_emettrice");
        bookmarkIdListFoundInDocXFile.add("pays_émetteur_de_passeport");
        bookmarkIdListFoundInDocXFile.add("dénomination_sociale_mt");
        bookmarkIdListFoundInDocXFile.add("pays_d'immatriculation");
        bookmarkIdListFoundInDocXFile.add("Infos_personne_physique_tunisienne");
        bookmarkIdListFoundInDocXFile.add("forme_SA_SARL_SUARL");
        bookmarkIdListFoundInDocXFile.add("nationalité");
        bookmarkIdListFoundInDocXFile.add("forme_SA_SARL_SUARL_LLP_GMBH");
        bookmarkIdListFoundInDocXFile.add("nom_pe_d");
        bookmarkIdListFoundInDocXFile.add("numéro_de_passport");
        bookmarkIdListFoundInDocXFile.add("numéro_de_passport_d");
        bookmarkIdListFoundInDocXFile.add("identifiant_unique_d");
        bookmarkIdListFoundInDocXFile.add("quelle_activité_partie_destinaire");
        bookmarkIdListFoundInDocXFile.add("dénomination_sociale_mt_d");
        bookmarkIdListFoundInDocXFile.add("nom_du_représentant_signataire_du_document");
        bookmarkIdListFoundInDocXFile.add("prénom_pt_d");
        bookmarkIdListFoundInDocXFile.add("Infos_personne_morale_tunisienne_d");
        bookmarkIdListFoundInDocXFile.add("prénom_du_représentant_me_d");
        bookmarkIdListFoundInDocXFile.add("numéro_de_la_carte_d'identité_nationale_d");
        bookmarkIdListFoundInDocXFile.add("nationalité_d");
        bookmarkIdListFoundInDocXFile.add("no");
        bookmarkIdListFoundInDocXFile.add("dénomination_sociale_me_d");
        bookmarkIdListFoundInDocXFile.add("adresse_domicilisation_pt_d");
        bookmarkIdListFoundInDocXFile.add("Infos_personne_morale_tunisienne");
        bookmarkIdListFoundInDocXFile.add("pays_émetteur_de_passeport_d");
        bookmarkIdListFoundInDocXFile.add("numéro_de_la_carte_d'identité_nationale");
        bookmarkIdListFoundInDocXFile.add("forme_SA_SARL_SUARL_LLP_GMBH_d");
        bookmarkIdListFoundInDocXFile.add("Infos_personne_physique_tunisienne_d");
        bookmarkIdListFoundInDocXFile.add("nom_du_représentant_signataire_du_document_d");
        bookmarkIdListFoundInDocXFile.add("nom_pe");
        bookmarkIdListFoundInDocXFile.add("Infos_personne_morale_étrangère");
        bookmarkIdListFoundInDocXFile.add("pourquoi_est_ce_que_parties_contractent");
        bookmarkIdListFoundInDocXFile.add("numéro_d'immatriculation_dans_le_pays_d'origine");
        bookmarkIdListFoundInDocXFile.add("nom_pt");
        bookmarkIdListFoundInDocXFile.add("adresse_du_siège_social");
        bookmarkIdListFoundInDocXFile.add("prénom_pe_d");
        bookmarkIdListFoundInDocXFile.add("Infos_personne_physique_étrangère");
        bookmarkIdListFoundInDocXFile.add("adresse_domicilisation_pe");
        bookmarkIdListFoundInDocXFile.add("numéro_d'immatriculation_dans_le_pays_d'origine_d");
        bookmarkIdListFoundInDocXFile.add("adresse_domicilisation_pt");
        bookmarkIdListFoundInDocXFile.add("prénom_du_représentant_me");
        bookmarkIdListFoundInDocXFile.add("Infos_personne_morale_étrangère_d");
        bookmarkIdListFoundInDocXFile.add("nom_du_représentant signataire_du_document_d");
        bookmarkIdListFoundInDocXFile.add("Quelle_siège_tribunal_arbitral");
        bookmarkIdListFoundInDocXFile.add("nom_du_représentant_signataire_du_document");
        bookmarkIdListFoundInDocXFile.add("nom_du_représentant signataire_du_document");
        bookmarkIdListFoundInDocXFile.add("prénom_du_représentant_mt_d");
        bookmarkIdListFoundInDocXFile.add("prénom_pe");
        bookmarkIdListFoundInDocXFile.add("pays_d'immatriculation_d");
        bookmarkIdListFoundInDocXFile.add("dénomination_sociale_me");
        bookmarkIdListFoundInDocXFile.add("adresse_domicilisation_pe_d");
        bookmarkIdListFoundInDocXFile.add("forme_SA_SARL_SUARL_d");
        bookmarkIdListFoundInDocXFile.add("prénom_pt");
        bookmarkIdListFoundInDocXFile.add("nom_pt_d");
        bookmarkIdListFoundInDocXFile.add("Infos_personne_physique_étrangère_d");
        bookmarkIdListFoundInDocXFile.add("prénom_du_représentant_mt");
        // CDD
        bookmarkIdListFoundInDocXFile.add("date_debut");
        bookmarkIdListFoundInDocXFile.add("date_fin");
        bookmarkIdListFoundInDocXFile.add("duree_contrat");
        // Attestaion de domicilisation
        bookmarkIdListFoundInDocXFile.add("A");
        bookmarkIdListFoundInDocXFile.add("dénomination_sociale");
        bookmarkIdListFoundInDocXFile.add("B");
        bookmarkIdListFoundInDocXFile.add("C");
        bookmarkIdListFoundInDocXFile.add("D");
        bookmarkIdListFoundInDocXFile.add("adresse_local");
        bookmarkIdListFoundInDocXFile.add("nom_du_représentant_signataire_du_document_e");
        bookmarkIdListFoundInDocXFile.add("prénom_du_représentant");
        bookmarkIdListFoundInDocXFile.add("denomination_sociale_domicilie");
        bookmarkIdListFoundInDocXFile.add("adresse_domicilisation");
        bookmarkIdListFoundInDocXFile.add("est_ce_domicilisation_proprietaire");
        bookmarkIdListFoundInDocXFile.add("forme_SA_SARL_SUARL_domicilitie");
        // Contrat Bail commercial 
        bookmarkIdListFoundInDocXFile.add("model");
        // Convocation ago
        bookmarkIdListFoundInDocXFile.add("denomination_convocation");
        bookmarkIdListFoundInDocXFile.add("siege_social_convocation");
        bookmarkIdListFoundInDocXFile.add("cin_nouveau_gerant");
        bookmarkIdListFoundInDocXFile.add("nom_prenom_ancien_gerant");
        bookmarkIdListFoundInDocXFile.add("date_reunion");
        bookmarkIdListFoundInDocXFile.add("rémunération");
        bookmarkIdListFoundInDocXFile.add("duree_mandat");
        bookmarkIdListFoundInDocXFile.add("passport_nouveau_gerant");
        bookmarkIdListFoundInDocXFile.add("heure_fin");
        bookmarkIdListFoundInDocXFile.add("qualite_emetteur_convocation");
        bookmarkIdListFoundInDocXFile.add("nationalite_passport_nouveau_gerant");
        bookmarkIdListFoundInDocXFile.add("liste_associes");
        bookmarkIdListFoundInDocXFile.add("date_convocation");
        bookmarkIdListFoundInDocXFile.add("heure_convocation");
        bookmarkIdListFoundInDocXFile.add("nom_prenom_emetteur_convocation");
        bookmarkIdListFoundInDocXFile.add("nom_prenom_nouveau_gerant");
        // AGO-NNG
        bookmarkIdListFoundInDocXFile.add("NomPrénom_du_nouveau_gérant_2");
        bookmarkIdListFoundInDocXFile.add("NomPrénom_du_nouveau_gérant_3");
        bookmarkIdListFoundInDocXFile.add("NomPrénom_du_nouveau_gérant_4");
        bookmarkIdListFoundInDocXFile.add("NomPrénom_du_nouveau_gérant_5");
        bookmarkIdListFoundInDocXFile.add("Démission_du_précédent_gérant_4");
        bookmarkIdListFoundInDocXFile.add("Décès_du_précédent_gérant_2");
        bookmarkIdListFoundInDocXFile.add("Démission_du_précédent_gérant_3");
        bookmarkIdListFoundInDocXFile.add("Siège_sociale_de_la_societé");
        bookmarkIdListFoundInDocXFile.add("Démission_du_précédent_gérant_5");
        bookmarkIdListFoundInDocXFile.add("Décès_du_précédent_gérant_3");
        bookmarkIdListFoundInDocXFile.add("NomPrénom_du_nouveau_gérant");
        bookmarkIdListFoundInDocXFile.add("Num_passeport_du_nouveau_gérant");
        bookmarkIdListFoundInDocXFile.add("Démission_du_précédent_gérant_2");
        bookmarkIdListFoundInDocXFile.add("Révocation_du_précédent_gérant_2");
        bookmarkIdListFoundInDocXFile.add("Révocation_du_précédent_gérant_3");
        bookmarkIdListFoundInDocXFile.add("Décès_du_précédent_gérant");
        bookmarkIdListFoundInDocXFile.add("Durée_mandat_en_années_2");
        bookmarkIdListFoundInDocXFile.add("Nom_prénom_émetteur_convocation");
        bookmarkIdListFoundInDocXFile.add("Gérant_rémunéré_non");
        bookmarkIdListFoundInDocXFile.add("Dém_nom_prénom_ancien_gérant");
        bookmarkIdListFoundInDocXFile.add("Déc_nom_prénom_ancien_gérant_2");
        bookmarkIdListFoundInDocXFile.add("Natio_passeport_du_nouveau_gérant_2");
        bookmarkIdListFoundInDocXFile.add("Durée_mandat_en_années_4");
        bookmarkIdListFoundInDocXFile.add("Durée_mandat_en_années_3");
        bookmarkIdListFoundInDocXFile.add("Convocations_assemblée_non");
        bookmarkIdListFoundInDocXFile.add("Convocations_assemblée_non_2");
        bookmarkIdListFoundInDocXFile.add("Associés_plus_50_capitalSocial_non");
        bookmarkIdListFoundInDocXFile.add("Nouveau_gérant_tunisien_non");
        bookmarkIdListFoundInDocXFile.add("Date_convocations_assemblée");
        bookmarkIdListFoundInDocXFile.add("Date_de_réunion_de_lassemblée");
        bookmarkIdListFoundInDocXFile.add("Dénomination_sociale_7");
        bookmarkIdListFoundInDocXFile.add("Dénomination_sociale_8");
        bookmarkIdListFoundInDocXFile.add("Dénomination_sociale_5");
        bookmarkIdListFoundInDocXFile.add("Dénomination_sociale_6");
        bookmarkIdListFoundInDocXFile.add("Dénomination_sociale_9");
        bookmarkIdListFoundInDocXFile.add("Heure_début_réunion_assemblée");
        bookmarkIdListFoundInDocXFile.add("Autre_personnes_non_2");
        bookmarkIdListFoundInDocXFile.add("Dénomination_sociale_10");
        bookmarkIdListFoundInDocXFile.add("Dénomination_sociale_3");
        bookmarkIdListFoundInDocXFile.add("Durée_mandat_en_années");
        bookmarkIdListFoundInDocXFile.add("Dénomination_sociale_4");
        bookmarkIdListFoundInDocXFile.add("NomPrénom_personne_préside_lassemblée");
        bookmarkIdListFoundInDocXFile.add("NomPrénom_personne_préside_lassemblée_2");
        bookmarkIdListFoundInDocXFile.add("Dénomination_sociale_2");
        bookmarkIdListFoundInDocXFile.add("Num_CIN_du_nouveau_gérant");
        bookmarkIdListFoundInDocXFile.add("Heure_début_réunion_assemblée_2");




        fileValidationService.checkDocXFileCustomBookmarksListIntegrity(bookmarkIdListFoundInDocXFile, allCustomBookmarks);
        insertAtBookmark();
        saveAs(filledFileName);
        return FILLED_FILE_NAME_PREFIX+filledFileName;
    }

    /**
     * For each stepperDataWithBookmark object get the bookmarks references array from inputsWithBookmarks.
     * <p>
     * In case of input of type text, number or text area, input's bookmarkIdPerValue attribute contains only
     * one entry with "text" as key and get("text") will return String array of bookmarkReferences of that
     * input if it has any. (see any text input is stepper JSON config).
     *
     * @param inputWithBookmarks input object to get bookmark references extracted from
     * @param stepperDataInputValue input value returned from stepper
     * @return bookmarksReferences array of the given input's bookmark references
     * */
    private String[] getBookmarksReferencesPerInputByInputValue(Input inputWithBookmarks, String stepperDataInputValue) {
        String[] bookmarksReferences;
        if(simpleTypes.contains(inputWithBookmarks.getType().toUpperCase())) {
            bookmarksReferences = inputWithBookmarks.getBookmarkIdPerValue().get(SIMPLE_TYPES_KEY);
            System.out.println("lllllllllllllllllllll 194 doc"+bookmarksReferences);
        }else if(multiValueTypes.contains(inputWithBookmarks.getType().toUpperCase())){
        	  
            bookmarksReferences = inputWithBookmarks.getBookmarkIdPerValue().get(stepperDataInputValue); // get input's bookmarkReferences String array using input's value as key.
            System.out.println("lllllllllllllllllllll 198 doc"+inputWithBookmarks.getType());
        }else {
        	System.out.println("lllllllllllllllllllll 200 doc"+inputWithBookmarks.getType());
            throw new NoSuchElementException(String.format("Unknown input type: \"%s\"", inputWithBookmarks.getType()));
        }
        return bookmarksReferences;
    }

    /**
     * Gets the list of bookmarks returned from the .docx file.
     * */
    private void getBookmarkIdListFoundInDocXFile() {
        bookmarkIdListFoundInDocXFile = new ArrayList<>();
        this.document.getParagraphs().forEach(p -> p.getCTP().getBookmarkStartList().forEach(bookmark ->
                bookmarkIdListFoundInDocXFile.add(bookmark.getName())
        ));
    }

    
    /**
     * Check if bookmark is of type DEFAULT(default text needs to be used) or USER_INPUT (user's text needs to be used).
     * <p>
     * When bookmark is of type DEFAULT, default value will be used and in this case it can't be null. (empty String is accepted but not null)
     *
     * @param bookmarksReferences bookmarksReferences array of the given input's bookmark references
     * @param stepperDataInputValue input value returned from stepper
     * */
    private void groupInputBookmarksByBookmarkType(String[] bookmarksReferences, String stepperDataInputValue) {
        Bookmark bookmark;
        String bookmarkValue;
        
        
        //System.out.println("***************************** "+bookmarksReferences);
		//List<String> list = new ArrayList<>(Arrays.asList(bookmarksReferences));
		//while (list.remove(null)) { 
		//} 
        if(bookmarksReferences==null){
        	System.out.println("**************nulllllllllllllllllllllllll***************");
        	return;
        }
        for (int i=0;i< bookmarksReferences.length;i++) {
        	System.out.println("*************** "+bookmarksReferences[i]+"************************");
		}
        for (String bookmarksReference : bookmarksReferences) {
       // 	System.out.println("//////////////////////// "+bookmarksReference);
            bookmark = this.allCustomBookmarks.get(bookmarksReference);
        //    System.out.println("+++++++++++++++++++++++++++++++ "+bookmark.getType());
            
            switch (bookmark.getType()) {
                case BOOKMARK_TYPE_DEFAULT:
                    bookmarkValue = bookmark.getValue();
                    customBookmarksValues.put(bookmark.getBookmarkId(), bookmarkValue);
                    break;
                case BOOKMARK_TYPE_USER_INPUT:
                    customBookmarksValues.put(bookmark.getBookmarkId(), stepperDataInputValue);
                    break;
                case BOOKMARK_TYPE_PARAGRAPH_WITH_BOOKMARKS:
                    bookmarkValue = bookmark.getValue();
                    paragraphsWithBookmarksToDelete.put(bookmark.getBookmarkId(), bookmarkValue);
                    break;
                case BOOKMARK_TYPE_INPUT_GENERATOR:
                    customBookmarksValues.put(bookmark.getBookmarkId(), bookmark.getValue());
                    break;
                case BOOKMARK_TYPE_PAGE_WITH_BOOKMARKS:
                    bookmarkValue = bookmark.getValue();
                    pagesWithBookmarksToDelete.put(bookmark.getBookmarkId(), bookmarkValue);
                    break;
                default:
                    throw new NullPointerException("Bookmark type cannot be null while configuring a bookmark in .JSON configuration file.");
            }
        }
    }

    /**
     * Filters all inputs to keep only those with bookmarks
     * */
    private void filterInputsWithBookmarks()throws IOException{
        Map<String, Input> allInputs = this.fileManipulationService.getAllInputs(urlStepper);
        for(Map.Entry<String, Input> inputEntry : allInputs.entrySet()) {
            if(inputEntry.getValue().getBookmarkIdPerValue().size() != 0) {
                this.inputsWithBookmarks.put(inputEntry.getKey(), inputEntry.getValue());
            }
        }
    }

    /**
     * Filters stepperDataInputs to keep only those with bookmarks using inputsWithBookmarks
     * */
    private void filterStepperDataInputsWithBookmarks(){
        stepperDataWithBookmarks = new HashMap<>();
        for(Map.Entry<String, InputData> inputEntry : this.stepperData.entrySet()) {
            if(this.inputsWithBookmarks.get(inputEntry.getKey()) != null) {
                this.stepperDataWithBookmarks.put(inputEntry.getKey(), inputEntry.getValue());
            }
        }
    }

    /**
     * Opens a .docx file given a url.
     *
     * @param fileName name of the model file.
     * */
    private void openFile(String fileName) throws IOException {
        File file = new File(fileName);
        try (FileInputStream fis = new FileInputStream(file)) {
            this.document = new XWPFDocument(fis);
        }
    }

    /**
     * Generates a .docx file.
     *
     * @param fileName name of file to generate.
     * */
    private void saveAs(String fileName) throws IOException {
        File generatedDocDirectoryPath = new File(FILLED_FILE_NAME_PREFIX);
        boolean directoryIsCreated = true;
        if (!generatedDocDirectoryPath.exists()) {
            directoryIsCreated = generatedDocDirectoryPath.mkdir();
        }
        if (directoryIsCreated) {
            File file = new File(FILLED_FILE_NAME_PREFIX+fileName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                this.document.write(fos);
            }
        }
        else {
            throw new FileSystemException("Error creating directory with path: " + FILLED_FILE_NAME_PREFIX);
        }
    }

    /**
     * Deletes the given paragraph.
     *
     * @param para the paragraph to delete.
     * */
    private void deleteParagraphWithBookmarks(XWPFParagraph para) throws IOException{
        this.document.removeBodyElement(this.document.getPosOfParagraph(para));
        try (OutputStream fos = new FileOutputStream(filledFileName)){
            this.document.write(fos);
        }
    }

    /**
     * Configures the given run according to the configuration of the given custom bookmark.
     *
     * @param run run that contains text to replace bookmark's one.
     * @param configuredBookmark custom bookmark configured in the stepper configuration file.
     * */
    private void createCustomRun(XWPFRun run, Bookmark configuredBookmark) {
        run.setBold(configuredBookmark.isBold());
        run.setCapitalized(configuredBookmark.isCapitalized());
        run.setItalic(configuredBookmark.isItalic());
        run.setUnderline(getUnderlinePatternsByName(configuredBookmark.getUnderline()));
        if(configuredBookmark.getFontSize() != 0) {
            run.setFontSize(configuredBookmark.getFontSize());
        }
        if(configuredBookmark.getFontFamily() != null) {
            run.setFontFamily(configuredBookmark.getFontFamily());
        }
        if(configuredBookmark.getColor() != null) {
            run.setColor(configuredBookmark.getColor());
        }
    }

    private UnderlinePatterns getUnderlinePatternsByName(String underlinePatternsName) {
        if (underlinePatternsName != null) {
            switch (underlinePatternsName.toUpperCase()) {
                case "SINGLE":
                    return UnderlinePatterns.SINGLE;
                case "DOUBLE":
                    return UnderlinePatterns.DOUBLE;
                case "DASH":
                    return UnderlinePatterns.DASH;
                default:
                    return UnderlinePatterns.NONE;
            }
        }
        else {
            return UnderlinePatterns.NONE;
        }
    }

    /**
     * Returns the list of input ids for a given bloc id
     *
     * @param blocId bloc id
     * @return list of bloc's inputs
     */
    private List<String> getInputIdsByBlocId(String blocId) {
        List<String> inputIdByBlocId = new ArrayList<>();
        try {
            inputIdByBlocId = this.fileManipulationService.getInputsByBlocId(blocId, urlStepper);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputIdByBlocId;
    }

    /**
     * Returns list of input ids of type 'select_input_generator'
     *
     * @return list of input ids of type 'select_input_generator'
     */
    private List<String> getInputIdsOfTypeSelectGeneratedInput() {
        List<String> inputIdOfTypeSelectGeneratedInput = new ArrayList<>();

        for (Map.Entry<String, InputData> input : this.stepperData.entrySet()) {
            try {
                Input in = this.fileManipulationService.getInputByInputId(input.getKey(), urlStepper);
                if ("select_input_generator".equals(in.getType())) {
                    inputIdOfTypeSelectGeneratedInput.add(in.getId());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inputIdOfTypeSelectGeneratedInput;
    }

    /**
     * Returns list of bookmarks related to a given input id
     *
     * @return list of bookmarks
     */
    private List<Bookmark> getBookmarksByInputOfTypeSelectGeneratedInput(String inputId, String inputValue) {
        String[] array;
        List<Bookmark> list = new ArrayList<>();
        try {
            array = this.fileManipulationService.getInputByInputId(inputId, urlStepper).getBookmarkIdPerValue().get(inputValue);
            for(String arrayEntry: array) {
                list.add(this.fileManipulationService.getBookmarkByBookmarkId(arrayEntry, urlStepper));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  list;
    }

    /**
     * Returns list of generated input id prefixes extracted from a bookmark's value attribute
     *
     * @param value bookmark's value attribute
     * @return list of generated input id prefixes
     */
    private List<String> getBookmarkValuePrefixArray(String value) {
        List<String> list = new ArrayList<>();
        String[] separated = value.split(" ");
        Collections.addAll(list, separated);
        return list;
    }

    /**
     * Update bookmarks related to a generated input value in the list containing all custom bookmarks
     *
     * @param bookmarkId bookmark id
     * @param bookmarkValue bookmark's value attribute
     */
    private void updateGeneratedInputBookmarksInCustomBookmarksList(String bookmarkId, String bookmarkValue) {
        Bookmark bookmark = allCustomBookmarks.get(bookmarkId);
        bookmark.setValue(bookmarkValue);
        allCustomBookmarks.replace(bookmarkId, bookmark);
    }

    /**
     * Applies the actual changes (bookmarkValue) on the actual bookmark(bookmarkName) for each bookmark in the .docx file that matches a bookmark of the given list
     * DocX file contain generated bookmarks (example _GoBack bookmark) that needs to be ignored.
     * <p>
     * There are three types of custom bookmarks, USER_INPUT, DEFAULT and PARAGRAPH_WITH_BOOKMARKS.
     * <ul>
     * <li>USER_INPUT : when the bookmark is applied, used input is used.</li>
     * <li>DEFAULT : when the bookmark is applied, its default value is used.</li>
     * <li>PARAGRAPH_WITH_BOOKMARKS : when the bookmark's content to delete contains other bookmarks. </li>
     * <p>
     * .docx file may contain other bookmarks other than the custom ones manually configured.
     * </ul>
     */
    private void insertAtBookmark() throws IOException{
        LinkedList<XWPFParagraph> paraList;
        ListIterator<XWPFParagraph> paraIter;
        XWPFParagraph para;
        List<CTBookmark> bookmarkListFoundInOneDocXFileParagraph;
        Iterator<CTBookmark> bookmarkIter;
        CTBookmark docXBookmark;
        Bookmark customBookmark;
        XWPFRun run;
        paraList = new LinkedList<>(this.document.getParagraphs());
        paraIter = paraList.listIterator();
        bookmarkIdListFoundInDocXFile = new ArrayList<>();

        while (paraIter.hasNext()) {
            para = paraIter.next();
            bookmarkListFoundInOneDocXFileParagraph = para.getCTP().getBookmarkStartList();
            bookmarkIter = bookmarkListFoundInOneDocXFileParagraph.iterator();
            Node nextNode;
            while (bookmarkIter.hasNext()) {
                docXBookmark = bookmarkIter.next();
                customBookmark = allCustomBookmarks.get(docXBookmark.getName());
                if (customBookmarksValues.containsKey(docXBookmark.getName())) {
                    run = para.createRun();

                    if(customBookmarksValues.get(docXBookmark.getName()).contains("\n")) {
                        String[] separated = customBookmarksValues.get(docXBookmark.getName()).split("\n");
                        for(String sep: separated) {
                            if(sep.contains("-")) {
                                run.addTab();
                            }
                            run.setText(sep);
                            run.addCarriageReturn();
                        }
                    }else {
                         run.setText(customBookmarksValues.get(docXBookmark.getName()));
                    }
                    createCustomRun(run, customBookmark);
                    nextNode = docXBookmark.getDomNode().getNextSibling();
                    while (!(nextNode.getNodeName().contains("bookmarkEnd"))) {
                        para.getCTP().getDomNode().removeChild(nextNode);
                        nextNode = docXBookmark.getDomNode().getNextSibling();
                    }
                    para.getCTP().getDomNode().insertBefore(run.getCTR().getDomNode(), docXBookmark.getDomNode());
                } else if (paragraphsWithBookmarksToDelete.containsKey(docXBookmark.getName())) {
                    deleteParagraphWithBookmarks(para);
                    paraIter.remove();
                    if (paraIter.hasNext()) {
                        XWPFParagraph nextPara = paraIter.next();
                        if (nextPara.getText().isEmpty()) {
                            deleteParagraphWithBookmarks(nextPara);
                            paraIter.remove();
                            paraIter.next();
                        }
                        paraIter.previous();
                    }
                    break;
                } else if (pagesWithBookmarksToDelete.containsKey(docXBookmark.getName())) {
                    while (paraIter.hasNext()) {
                        deleteParagraphWithBookmarks(para);
                        XWPFParagraph nextPara = paraIter.next();
                        paraIter.previous();
                        if (!nextPara.getRuns().isEmpty() && nextPara.getRuns().get(0).getText(0) == null) {
                            break;
                        }
                        para = paraIter.next();
                        paraIter.remove();
                    }
                    if (!paraIter.hasNext()) {
                        deleteParagraphWithBookmarks(para);
                    }
                    break;
                }
            }
        }
    }

}
