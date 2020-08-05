package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model class for Dashboard
 **/
public class ItembankAssessment {
    private String quickMode, nextButton, titleInput, createButton, standardDocument, standards, standardSubject, subject, standardCategory, category, standardItems, verifyStandards, continueButton, add, assessmentTitle, generateQuestions, verifyQuestions, readyToPublish, publishAdminister;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ItembankAssessment() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_DemographicAssessment", "");
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
}