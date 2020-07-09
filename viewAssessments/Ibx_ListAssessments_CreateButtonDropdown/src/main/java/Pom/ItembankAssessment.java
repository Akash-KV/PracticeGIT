package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for ItemBankAssessment
public class ItembankAssessment {
    private String quickMode, nextButton, titleInput, createButton, standardDocument, standards, standardSubject, subject, standardCategory, category, standardItems, verifyStandards, continueButton, add, assessmentTitle, generateQuestions, verifyQuestions, readyToPublish, publishAdminister;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ItembankAssessment() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ListAssessments_CreateButtonDropdown", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ItemBankAssessment.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ItemBankAssessment.properties");
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

    public String getQuickMode() {
        quickMode = properties.getProperty("QUICK_MODE");
        return quickMode;
    }

    public String getNextButton() {
        nextButton = properties.getProperty("NEXT_BUTTON");
        return nextButton;
    }

    public String getTitleInput() {
        titleInput = properties.getProperty("TITLE_INPUT");
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
        standards = properties.getProperty("STANDARDS");
        return standards;
    }

    public String getStandardSubject() {
        standardSubject = properties.getProperty("STANDARD_SUBJECT");
        return standardSubject;
    }


    public String getSubject() {
        subject = properties.getProperty("SUBJECT");
        return subject;
    }

    public String getStandardCategory() {
        standardCategory = properties.getProperty("STANDARD_CATEGORY");
        return standardCategory;
    }

    public String getCategory() {
        category = properties.getProperty("CATEGORY");
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