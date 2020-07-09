package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model class for ItembankAssessment
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
            dir = dir.replace("Ibx_ViewAssessments_Filters", "");
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
     * Methods to read Locators from Property file
     **/


    public String getQuickMode() {
        quickMode = properties.getProperty("QUICK_MODE");
        return quickMode;
    }

    public String getNextButton() {
        nextButton = properties.getProperty("NEXT_BUTTON");
        return nextButton;
    }

    public String getTitleInput() {
        titleInput = "title";
        return titleInput;
    }

    public String getCreateButton() {
        createButton = properties.getProperty("CREATE_BUTTON");
        return createButton;
    }

    public String getStandardDocument() {
        standardDocument = properties.getProperty("STANDARD_DOCUMENT");
        return standardDocument;
    }

    public String getStandards() {
        standards = "Common Core State Standards";
        return standards;
    }

    public String getStandardSubject() {
        standardSubject = properties.getProperty("STANDARD_SUBJECT");
        return standardSubject;
    }


    public String getSubject() {
        subject = "English Language Arts/Literacy (2010)";
        return subject;
    }

    public String getStandardCategory() {
        standardCategory = properties.getProperty("STANDARD_CATEGORY");
        return standardCategory;
    }

    public String getCategory() {
        category = "Grade 1";
        return category;
    }

    public String getStandardItems() {
        standardItems = properties.getProperty("STANDARD_ITEMS");
        return standardItems;
    }

    public String getVerifyStandards() {
        verifyStandards = properties.getProperty("VERIFY_STANDARDS");
        return verifyStandards;
    }

    public String getContinueButton() {
        continueButton = properties.getProperty("CONTINUE_BUTTON");
        return continueButton;
    }

    public String getAdd() {
        add = properties.getProperty("ADD");
        return add;
    }

    public String getAssessmentTitle() {
        assessmentTitle = properties.getProperty("ASSESSMENT_TITLE");
        return assessmentTitle;
    }

    public String getGenerateQuestions() {
        generateQuestions = properties.getProperty("GENERATE_QUESTIONS");
        return generateQuestions;
    }

    public String getVerifyQuestions() {
        verifyQuestions = properties.getProperty("VERIFY_QUESTIONS");
        return verifyQuestions;
    }

    public String getReadyToPublish() {
        readyToPublish = properties.getProperty("READY_TO_PUBLISH");
        return readyToPublish;
    }

    public String getPublishAdminister() {
        publishAdminister = properties.getProperty("PUBLISH_ADMINISTER");
        return publishAdminister;
    }
}