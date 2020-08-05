package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class ItembankAssessment {
    private String quickMode, itemBank, optionOne, subActions, optionTwo, readyToPublishItemBnak, generateQuestionsForAll, quickQuestions, optionFive, gotoStepFour, stepTwoStandards, numberOfStandards, nextButton, titleInput, createButton, standardDocument, standards, standardSubject, subject, standardCategory, category, standardItems, verifyStandards, continueButton, add, assessmentTitle, generateQuestions, verifyQuestions, readyToPublish, publishAdminister;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ItembankAssessment() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ItembankAssessment_QuickMode", "");
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
        standardItems = properties.getProperty("ITEMBANKASSESSMENT_STANDARDITEMS");
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
        itemBank = properties.getProperty("ITEMBANKASSESSMENT_ITEMBANK");
        return itemBank;
    }

    public String getOptionOne() {
        optionOne = properties.getProperty("ITEMBANKASSESSMENT_OPTIONONE");
        return optionOne;
    }

    public String getOptionTwo() {
        optionTwo = properties.getProperty("ITEMBANKASSESSMENT_OPTIONTWO");
        return optionTwo;
    }

    public String getOptionFive() {
        optionFive = properties.getProperty("ITEMBANKASSESSMENT_OPTIONFIVE");
        return optionFive;
    }

    public String getNumberOfStandards() {
        numberOfStandards = properties.getProperty("ITEMBANKASSESSMENT_NUBEROFSTANDERDS");
        return numberOfStandards;
    }

    public String getStepTwoStandards() {
        stepTwoStandards = properties.getProperty("ITEMBANKASSESSMENT_STEPTWOSTANDARDS");
        return stepTwoStandards;
    }

    public String getGotoStepFour() {
        gotoStepFour = properties.getProperty("ITEMBANKASSESSMENT_GOTOSTEPFOUR");
        return gotoStepFour;
    }

    public String getQuickQuestions() {
        quickQuestions = properties.getProperty("ITEMBANKASSESSMENT_QUICKQUESTIONS");
        return quickQuestions;
    }

    public String getGenerateQuestionsForAll() {
        generateQuestionsForAll = properties.getProperty("ITEMBANKASSESSMENT_GENERATE_QUESTIONS");
        return generateQuestionsForAll;
    }

    public String getReadyToPublishItemBnak() {
        readyToPublishItemBnak = properties.getProperty("ITEMBANKASSESSMENT_ITEMBANKREADYTOPUBLISH");
        return readyToPublishItemBnak;
    }

    public String getSubActions() {
        subActions = properties.getProperty("ITEMBANKASSESSMENT_SUBACTIONS");
        return subActions;
    }
}