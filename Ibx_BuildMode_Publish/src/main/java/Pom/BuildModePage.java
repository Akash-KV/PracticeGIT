package Pom;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Page Object Model Class for BuildModePage
 **/
public class BuildModePage {

    private String doneButton, donePopup, discardButton, discardText, discardChanges, deleteButton;
    private String browsePage, saveDraftButton, assessmentPage, publishButton, publishText;
    private String assessmentTabPage, administerButton, administerText, onlineTesting, assessmentOnlineTestingPage;
    private String backToAssessments, viewButton, weightButton, changesDone, allOptions, assessPage;
    private String draftItemWarning, publishTextButton, buildToggle, checkDiscard, checkSaveDraft, checkPublish, saveDraftText;
    private String view, buildModeFirstDoneButton;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Publish", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\BuildModePage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/BuildModePage.properties");
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
     * method to read the data from property file
     **/

    public String getDoneButton() {
        doneButton = properties.getProperty("BUILD_DONE_BUTTON");
        return doneButton;
    }

    public String getDonePopup() {
        donePopup = properties.getProperty("BUILD_DONE_POPUP");
        return donePopup;
    }

    public String getDiscardButton() {
        discardButton = properties.getProperty("BUILD_DISCARD_BUTTON");
        return discardButton;
    }

    public String getDiscardText() {
        discardText = properties.getProperty("BUILD_DISCARD_TEXT");
        return discardText;
    }

    public String getDiscardChanges() {
        discardChanges = properties.getProperty("BUILD_DISCARD_CHANGES");
        return discardChanges;
    }

    public String getDeleteButton() {
        deleteButton = properties.getProperty("BUILD_DELETE_BUTTON");
        return deleteButton;
    }

    public String getBrowsePage() {
        browsePage = properties.getProperty("BUILD_BROWSE_PAGE");
        return browsePage;
    }

    public String getSaveDraftButton() {
        saveDraftButton = properties.getProperty("BUILD_SAVE_DRAFT_BUTTON");
        return saveDraftButton;
    }

    public String getSaveDraftText() {
        saveDraftText = properties.getProperty("BUILD_SAVE_DRAFT_TEXT");
        return saveDraftText;
    }

    public String getAssessmentPage() {
        assessmentPage = properties.getProperty("BUILD_ASSESSMENT_PAGE");
        return assessmentPage;
    }

    public String getPublishButton() {
        publishButton = properties.getProperty("BUILD_PUBLISH");
        return publishButton;
    }

    public String getPublishText() {
        publishText = properties.getProperty("BUILD_PUBLISH_TEXT");
        return publishText;
    }

    public String getAssessmentTabPage() {
        assessmentTabPage = properties.getProperty("BUILD_ASSESSMENT_TAB_PAGE");
        return assessmentTabPage;
    }

    public String getAdministerButton() {
        administerButton = properties.getProperty("BUILD_ADMINISTER_BUTTON");
        return administerButton;
    }

    public String getAdministerText() {
        administerText = properties.getProperty("BUILD_ADMINISTER_TEXT");
        return administerText;
    }

    public String getAssessmentOnlineTestingPage() {
        assessmentOnlineTestingPage = properties.getProperty("BUILD_ASSESSMENT_ONLINE_TESTING_PAGE");
        return assessmentOnlineTestingPage;
    }

    public String getBackToAssessments() {
        backToAssessments = properties.getProperty("BUILD_BACK_TO_ASSESSMENTS");
        return backToAssessments;
    }

    public String getViewButton() {
        viewButton = properties.getProperty("BUILD_VIEW_BUTTON");
        return viewButton;
    }

    public String getWeightButton() {
        weightButton = properties.getProperty("BUILD_WEIGHT_BUTTON");
        return weightButton;
    }

    public String getChangesDone() {
        changesDone = properties.getProperty("BUILD_CHANGES_DONE");
        return changesDone;
    }

    public String getAllOptions() {
        allOptions = properties.getProperty("BUILD_ALL_OPTIONS");
        return allOptions;
    }

    public String getAssessPage() {
        assessPage = properties.getProperty("BUILD_ASSESSMENT_TAB_PAGE");
        return assessPage;
    }

    public String getDraftItemWarning() {
        draftItemWarning = properties.getProperty("BUILD_DRAFT_ITEM_WARNING");
        return draftItemWarning;
    }

    public String getPublishTextButton() {
        publishTextButton = properties.getProperty("BUILD_PUBLISH_TEXT_BUTTON");
        return publishTextButton;
    }

    public String getBuildToggle() {
        buildToggle = properties.getProperty("BUILD_NAVIGATE_TO_BUILD");
        return buildToggle;
    }

    public String getCheckDiscard() {
        checkDiscard = properties.getProperty("BUILD_CHECK_DISCARD");
        return checkDiscard;
    }

    public String getCheckSaveDraft() {
        checkSaveDraft = properties.getProperty("BUILD_CHECK_SAVE_DRAFT");
        return checkSaveDraft;
    }

    public String getCheckPublish() {
        checkPublish = properties.getProperty("BUILD_PUBLISH_TEXT_BUTTON");
        return checkPublish;
    }

    public String getOnlineTesting() {
        onlineTesting = properties.getProperty("BUILD_ONLINE_TESTING");
        return onlineTesting;
    }

    public String getView() {
        view = properties.getProperty("BUILD_VIEW");
        return view;
    }

    public String getBuildModeFirstDoneButton() {
        buildModeFirstDoneButton = properties.getProperty("BUILD_FIRST_DONE_BUTTON");
        return buildModeFirstDoneButton;
    }
}


