package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/****POM Class for ItembankAssessment******/
public class ItembankAssessment {
    private String quickMode, nextButton, titleInput, createButton, itemBankAssessmentStandardSubjectOption, itemBankAssessmentStandardDocumentOption, standardDocument, stepOnecreateAssessmentButton, standards, itemBankStandardAssessmentCheckbox;
    private String itemBankCreateAssessmentTab, standardSubject, subject, itemBankAssessmentPublishAndAdministerButton, itemBankAssessmentItemTypes, itemBankAssessmentItemAndStandards, itemBankAssessmentPrintOptionHeader, itemBankAssessmentShuffleAnswerButton, itemBankAssessmentItemTypesMultipleChoice, itemBankAssessmentItemTypesModal, itemBankAssessmentItemSearchResult, itemBankAssessmentPassageUpdateFilter, itemBankAssessmentReturnPassage, itemBankAssessmentWithoutPassageLabel, itemBankAssessmentPassageSearchModal, itemBankAssessmentPassage, itemBankAssessmentNumberOfItems, itemBankAssessmentUpdatefilterButton, itemBankAssessmentItemBanks, itemBankAssessmentItemBankMyItemFilter, itemBankAssessmentStepTwoContinueButton, itemBankAssessmentNumberOfStandards, standardCategory, category, itemBankAssessmentStandardCategoryOption, standardItems, verifyStandards, continueButton, add, assessmentTitle, generateQuestions, verifyQuestions, readyToPublish, publishAdminister;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ItembankAssessment() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ItembankAssessment_StandardMode_Portal", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ItembankAssessment.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ItembankAssessment.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Methods to read locators from Property file
     **/

    public String getQuickMode() {
        quickMode = properties.getProperty("ITEMBANKASSESSMENT_QUICKMODE");
        return quickMode;
    }

    public String getNextButton() {
        nextButton = properties.getProperty("ITEMBANKASSESSMENT_NEXTBUTTON");
        return nextButton;
    }

    public String getTitleInput() {
        titleInput = properties.getProperty("ITEMBANKASSESSMENT_TITLEINPUT");
        return titleInput;
    }

    public String getCreateButton() {
        createButton = properties.getProperty("ITEMBANKASSESSMENT_CREATEBUTTON");
        return createButton;
    }

    public String getStandardDocument() {
        standardDocument = properties.getProperty("ITEMBANKASSESSMENT_STANDARDDOCUMENT");
        return standardDocument;
    }

    public String getStandards() {
        standards = properties.getProperty("ITEMBANKASSESSMENT_STANDARDS");
        return standards;
    }

    public String getStandardSubject() {
        standardSubject = properties.getProperty("ITEMBANKASSESSMENT_STANDARDSUBJECT");
        return standardSubject;
    }


    public String getSubject() {
        subject = properties.getProperty("ITEMBANKASSESSMENT_SUBJECT");
        return subject;
    }

    public String getStandardCategory() {
        standardCategory = properties.getProperty("ITEMBANKASSESSMENT_STANDARDCATEGORY");
        return standardCategory;
    }

    public String getCategory() {
        category = properties.getProperty("ITEMBANKASSESSMENT_CATEGORY");
        return category;
    }

    public String getStandardItems() {
        standardItems = properties.getProperty("ITEMBANKASSESSMENT_STANDARDITEM");
        return standardItems;
    }

    public String getVerifyStandards() {
        verifyStandards = properties.getProperty("ITEMBANKASSESSMENT_VERIFYSTANDARDS");
        return verifyStandards;
    }

    public String getContinueButton() {
        continueButton = properties.getProperty("ITEMBANKASSESSMENT_CONTINUEBUTTON");
        return continueButton;
    }

    public String getAdd() {
        add = properties.getProperty("ITEMBANKASSESSMENT_ADD");
        return add;
    }

    public String getAssessmentTitle() {
        assessmentTitle = properties.getProperty("ITEMBANKASSESSMENT_ASSESSMENTTITLE");
        return assessmentTitle;
    }

    public String getGenerateQuestions() {
        generateQuestions = properties.getProperty("ITEMBANKASSESSMENT_GENERATEQUESTIONS");
        return generateQuestions;
    }

    public String getVerifyQuestions() {
        verifyQuestions = properties.getProperty("ITEMBANKASSESSMENT_VERIFYQUESTIONS");
        return verifyQuestions;
    }

    public String getReadyToPublish() {
        readyToPublish = properties.getProperty("ITEMBANKASSESSMENT_READYTOPUBLISH");
        return readyToPublish;
    }

    public String getPublishAdminister() {
        publishAdminister = properties.getProperty("ITEMBANKASSESSMENT_PUBLISHADMINISTER");
        return publishAdminister;
    }

    public String getItemBankCreateAssessmentTab() {
        itemBankCreateAssessmentTab = properties.getProperty("ITEMBANKASSESSMENT_CREATEASSESSMENTTAB");
        return itemBankCreateAssessmentTab;
    }

    public String getItemBankStandardAssessmentCheckbox() {
        itemBankStandardAssessmentCheckbox = properties.getProperty("ITEMBANKASSESSMENT_STANDARDASSESSMENTCHECKBOX");
        return itemBankStandardAssessmentCheckbox;
    }

    public String getStepOnecreateAssessmentButton() {
        stepOnecreateAssessmentButton = properties.getProperty("ITEMBANKASSESSMENT_CREATEASSESSMENTBUTTON");
        return stepOnecreateAssessmentButton;
    }

    public String getItemBankStandardDocumentOption() {
        itemBankAssessmentStandardDocumentOption = properties.getProperty("ITEMBANKASSESSMENT_STANDARDDOCUMENTOPTION");
        return itemBankAssessmentStandardDocumentOption;
    }

    public String getItemBankAssessmentStandardSubjectOption() {
        itemBankAssessmentStandardSubjectOption = properties.getProperty("ITEMBANKASSESSMENT_STANDARDSUBJECTOPTION");
        return itemBankAssessmentStandardSubjectOption;
    }

    public String getItemBankAssessmentStandardCategoryOption() {
        itemBankAssessmentStandardCategoryOption = properties.getProperty("ITEMBANKASSESSMENT_STANDARDCATEGORYOPTION");
        return itemBankAssessmentStandardCategoryOption;
    }

    public String getItemBankAssessmentNumberOfStandards() {
        itemBankAssessmentNumberOfStandards = properties.getProperty("ITEMBANKASSESSMENT_NUMBEROFSTANDARDS");
        return itemBankAssessmentNumberOfStandards;
    }

    public String getItemBankAssessmentStepTwoContinueButton() {
        itemBankAssessmentStepTwoContinueButton = properties.getProperty("ITEMBANKASSESSMENT_STEPTWOCONTINUEBUTTON");
        return itemBankAssessmentStepTwoContinueButton;
    }

    public String getItemBankAssessmentItemBanks() {
        itemBankAssessmentItemBanks = properties.getProperty("ITEMBANKASSESSMENT_ITEMBANKS");
        return itemBankAssessmentItemBanks;
    }

    public String getItemBankAssessmentItemBankMyItemFilter() {
        itemBankAssessmentItemBankMyItemFilter = properties.getProperty("ITEMBANKASSESSMENT_ITEMBANK_MYITEMS");
        return itemBankAssessmentItemBankMyItemFilter;
    }

    public String getItemBankAssessmentUpdatefilterButton() {
        itemBankAssessmentUpdatefilterButton = properties.getProperty("ITEMBANKASSESSMENT_UPDATEFILTERBUTTON");
        return itemBankAssessmentUpdatefilterButton;
    }

    public String getItemBankAssessmentNumberOfItems() {
        itemBankAssessmentNumberOfItems = properties.getProperty("ITEMBANKASSESSMENT_NUMBEROFITEMS");
        return itemBankAssessmentNumberOfItems;
    }

    public String getItemBankAssessmentPassage() {
        itemBankAssessmentPassage = properties.getProperty("ITEMBANKASSESSMENT_PASSAGE");
        return itemBankAssessmentPassage;
    }

    public String getItemBankAssessmentReturnPassage() {
        itemBankAssessmentReturnPassage = properties.getProperty("ITEMBANKASSESSMENT_RETURNPASSAGE");
        return itemBankAssessmentReturnPassage;
    }

    public String getItemBankAssessmentPassageSearchModal() {
        itemBankAssessmentPassageSearchModal = properties.getProperty("ITEMBANKASSESSMENT_PASSAGESEARCHMODAL");
        return itemBankAssessmentPassageSearchModal;
    }

    public String getItemBankAssessmentWithoutPassageLabel() {
        itemBankAssessmentWithoutPassageLabel = properties.getProperty("ITEMBANKASSESSMENT_WITHOUTPASSAGELABEL");
        return itemBankAssessmentWithoutPassageLabel;
    }

    public String getItemBankAssessmentPassageUpdateFilter() {
        itemBankAssessmentPassageUpdateFilter = properties.getProperty("ITEMBANKASSESSMENT_UPDATEPASSAGEMODALFILTERBUTTON");
        return itemBankAssessmentPassageUpdateFilter;
    }

    public String getItemBankAssessmentItemSearchResult() {
        itemBankAssessmentItemSearchResult = properties.getProperty("ITEMBANKASSESSMENT_ITEMSEARCHRESULT");
        return itemBankAssessmentItemSearchResult;
    }

    public String getItemBankAssessmentItemTypes() {
        itemBankAssessmentItemTypes = properties.getProperty("ITEMBANKASSESSMENT_ITEMTYPES");
        return itemBankAssessmentItemTypes;
    }

    public String getItemBankAssessmentItemTypesModal() {
        itemBankAssessmentItemTypesModal = properties.getProperty("ITEMBANKASSESSMENT_ITEMTYPESMODAL");
        return itemBankAssessmentItemTypesModal;
    }

    public String getItemBankAssessmentItemTypesMultipleChoice() {
        itemBankAssessmentItemTypesMultipleChoice = properties.getProperty("ITEMBANKASSESSMENT_ITEMTYPES_MULTIPLECHOICE");
        return itemBankAssessmentItemTypesMultipleChoice;
    }

    public String getItemBankAssessmentShuffleAnswerButton() {
        itemBankAssessmentShuffleAnswerButton = properties.getProperty("ITEMBANKASSESSMENT_SHUFFLEANSWERBUTTON");
        return itemBankAssessmentShuffleAnswerButton;
    }

    public String getItemBankAssessmentPrintOptionHeader() {
        itemBankAssessmentPrintOptionHeader = properties.getProperty("ITEMBANKASSESSMENT_PRINTOPTIONHEADER");
        return itemBankAssessmentPrintOptionHeader;
    }

    public String getItemBankAssessmentItemAndStandards() {
        itemBankAssessmentItemAndStandards = properties.getProperty("ITEMBANKASSESSMENT_ADDITEMSANDSTANDARDS");
        return itemBankAssessmentItemAndStandards;
    }

    public String getItemBankAssessmentPublishAndAdministerButton() {
        itemBankAssessmentPublishAndAdministerButton = properties.getProperty("ITEMBANKASSESSMENT_PUBLISHANDADMINISTERBUTTON");
        return itemBankAssessmentPublishAndAdministerButton;
    }


}