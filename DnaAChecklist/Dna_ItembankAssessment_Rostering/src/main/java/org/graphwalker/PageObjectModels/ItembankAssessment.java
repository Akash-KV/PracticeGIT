package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class ItembankAssessment {
    private String quickMode, printOptionHeader, itemSearchResult, shuffleAnswerButton, addItemsAndStandards, multipleChoice, itemTypesModal, itemTypes, updatePassageModalFilteringButton, withoutPassageLabel, createClick, passage, passageSearchModal, itemBankMyItems, numberOfItems, stepThree, successButton, filterItemBank, nextButton, continueButtonRostering, numberOfStandardsRostering, createAssessmentRostering, titleInput, itemBank, newItemBankAssessment, createButton, standardDocument, standards, standardSubject, subject, standardCategory, category, standardItems, verifyStandards, continueButton, add, assessmentTitle, generateQuestions, verifyQuestions, readyToPublish, publishAdminister;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ItembankAssessment() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ItembankAssessment_Rostering", "");
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

    /*
    Methods to read the data from Property file
    */
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

    public String getItemBank() {
        itemBank = properties.getProperty("ITEMBANKASSESSMENT_CREATEASSESSMENTTAB");
        return itemBank;
    }

    public String getCreateAssessmentRostering() {
        createAssessmentRostering = properties.getProperty("ITEMBANKASSESSMENT_CREATE_ASSESSMENT");
        return createAssessmentRostering;
    }

    public String getNewItemBankAssessment() {
        newItemBankAssessment = properties.getProperty("ITEMBANKASSESSMENT_STANDARDASSESSMENTCHECKBOX");
        return newItemBankAssessment;
    }

    public String getCreateClick() {
        createClick = properties.getProperty("ITEMBANKASSESSMENT_CREATEASSESSMENTBUTTON");
        return createClick;
    }

    private String optionOne, optionTwo, optionFive;

    public String getOptionOne() {
        optionOne = properties.getProperty("ITEMBANKASSESSMENT_OPTIONONE");
        return optionOne;
    }

    public String getOptionTwo() {
        optionTwo = properties.getProperty("ITEMBANKASSESSMENT_OPTIONTWO");
        return optionTwo;
    }

    public String getGradeFour() {
        optionFive = properties.getProperty("ITEMBANKASSESSMENT_STANDARDCATEGORYOPTION");
        return optionFive;
    }


    public String getNumberOfStandardsRostering() {
        numberOfStandardsRostering = properties.getProperty("ITEMBANKASSESSMENT_NUMBEROFSTANDARDS");
        return numberOfStandardsRostering;
    }

    public String getContinueButtonRostering() {
        continueButtonRostering = properties.getProperty("ITEMBANKASSESSMENT_STEPTWOCONTINUEBUTTON");
        return continueButtonRostering;
    }

    public String getStepThree() {
        stepThree = properties.getProperty("ITEMBANKASSESSMENT_ITEMBANKS");
        return stepThree;
    }

    public String getFilterItemBank() {
        filterItemBank = properties.getProperty("ITEMBANKASSESSMENT_ITEMBANK_MYITEMS_FILTER");
        return filterItemBank;
    }

    public String getItemBankMyItems() {
        itemBankMyItems = properties.getProperty("ITEMBANKASSESSMENT_ITEMBANK_MYITEMS");
        return itemBankMyItems;
    }

    public String getSuccessButton() {
        successButton = properties.getProperty("ITEMBANKASSESSMENT_UPDATEFILTERBUTTON");
        return successButton;
    }

    public String getNumberOfItems() {
        numberOfItems = properties.getProperty("ITEMBANKASSESSMENT_NUMBEROFITEMS");
        return numberOfItems;
    }

    public String getPassage() {
        passage = properties.getProperty("ITEMBANKASSESSMENT_PASSAGE");
        return passage;
    }

    public String getPassageSearchModal() {
        passageSearchModal = properties.getProperty("ITEMBANKASSESSMENT_PASSAGESEARCHMODAL");
        return passageSearchModal;
    }

    public String getWithoutPassageLabel() {
        withoutPassageLabel = properties.getProperty("ITEMBANKASSESSMENT_WITHOUTPASSAGELABEL");
        return withoutPassageLabel;
    }

    public String getUpdatePassageModalFilteringButton() {
        updatePassageModalFilteringButton = properties.getProperty("ITEMBANKASSESSMENT_UPDATEPASSAGEMODALFILTERBUTTON");
        return updatePassageModalFilteringButton;
    }

    public String getItemSearchResult() {
        itemSearchResult = properties.getProperty("ITEMBANKASSESSMENT_ITEMSEARCHRESULT");
        return itemSearchResult;
    }

    public String getItemTypes() {
        itemTypes = properties.getProperty("ITEMBANKASSESSMENT_ITEMTYPES");
        return itemTypes;
    }

    public String getItemTypesModal() {
        itemTypesModal = properties.getProperty("ITEMBANKASSESSMENT_ITEMTYPESMODAL");
        return itemTypesModal;
    }

    public String getMultipleChoice() {
        multipleChoice = properties.getProperty("ITEMBANKASSESSMENT_ITEMTYPES_MULTIPLECHOICE");
        return multipleChoice;
    }

    public String getAddItemsAndStandards() {
        addItemsAndStandards = properties.getProperty("ITEMBANKASSESSMENT_ADDITEMSANDSTANDARDS");
        return addItemsAndStandards;
    }

    public String getShuffleAnswerButton() {
        shuffleAnswerButton = properties.getProperty("ITEMBANKASSESSMENT_SHUFFLEANSWERBUTTON");
        return shuffleAnswerButton;
    }

    public String getPrintOptionHeader() {
        printOptionHeader = properties.getProperty("ITEMBANKASSESSMENT_PRINTOPTIONHEADER");
        return printOptionHeader;
    }
}