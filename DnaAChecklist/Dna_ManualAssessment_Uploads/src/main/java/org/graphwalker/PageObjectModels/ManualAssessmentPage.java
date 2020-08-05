package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for ManualAssessmentPage
public class ManualAssessmentPage {
    private String stepOneTitle;
    private String nextButton;
    private String stepTwoSubjectArea;
    private String stepTwoSubjectAreaDropdownOptionChosen;
    private String stepTwoSearch;
    private String stepTwoSearchResultFirstOptionChosen;
    private String stepTwoLinkSelectedStandardsButton;
    private String stepSevenTabButton;
    private String stepSevenExitCreationModeButton;
    private String manualAssessmentUploadDetailsSetUpFile;
    private String manualAssessmentUploadFromDetailsSetupCanvas;
    private String manualAssessmentUploadFromSetUpMaterials;
    private String manualAssessmentUploadFromSetUp;
    private String manualAssessmentUploadFromDetailsCanvas;
    private String manualAssessmentUploadFromDetailsFile;
    private String manualAssessmentCanvasUpload;
    private String manualAssessmentUploadFromDetailsPath;
    private String manualAssessmentContainer;
    private String manualAssessmentStepThree;
    private String manualAssessmentAssessmentInfo;
    private String manualAssessmentStepNext;
    private String manualAssessmentNextOne;
    private String manualAssessmentUploadButton;
    private String manualAssessmentFile;
    private String manualAssessmentUploadPath;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ManualAssessmentPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_Uploads", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ManualAssessmentPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ManualAssessmentPage.properties");
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
    public String getManualAssessmentUploadDetailsSetUpFile() {
        manualAssessmentUploadDetailsSetUpFile = properties.getProperty("MANUALASSESSMENT_UPLOADFROMSETUPFILE");
        return manualAssessmentUploadDetailsSetUpFile;
    }

    public String getManualAssessmentUploadFromDetailsSetupCanvas() {
        manualAssessmentUploadFromDetailsSetupCanvas = properties.getProperty("MANUALASSESSMENT_UPLOADFROMDETAILSSETUPCANVAS");
        return manualAssessmentUploadFromDetailsSetupCanvas;
    }

    public String getManualAssessmentUploadFromSetUpMaterials() {
        manualAssessmentUploadFromSetUpMaterials = properties.getProperty("MANUALASSESSMENT_UPLOADFROMSETUPMATERIALS");
        return manualAssessmentUploadFromSetUpMaterials;
    }

    public String getManualAssessmentUploadFromSetUp() {
        manualAssessmentUploadFromSetUp = properties.getProperty("MANUALASSESSMENT_UPLOADFROMSETUP");
        return manualAssessmentUploadFromSetUp;
    }

    public String getManualAssessmentUploadFromDetailsCanvas() {
        manualAssessmentUploadFromDetailsCanvas = properties.getProperty("MANUALASSESSMENT_UPLOADFROMDETAILSCANVAS");
        return manualAssessmentUploadFromDetailsCanvas;
    }

    public String getManualAssessmentUploadFromDetailsFile() {
        manualAssessmentUploadFromDetailsFile = properties.getProperty("MANUALASSESSMENT_UPLOADFROMDETAILSFILE");
        return manualAssessmentUploadFromDetailsFile;
    }

    public String getManualAssessmentCanvasUpload() {
        manualAssessmentCanvasUpload = properties.getProperty("MANUALASSESSMENT_CANVASUPLOAD");
        return manualAssessmentCanvasUpload;
    }

    public String getManualAssessmentUploadFromDetailsPath() {
        manualAssessmentUploadFromDetailsPath = properties.getProperty("MANUALASSESSMENT_UPLOADFROMDETAILSPATH");
        return manualAssessmentUploadFromDetailsPath;
    }

    public String getManualAssessmentContainer() {
        manualAssessmentContainer = properties.getProperty("MANUALASSESSMENT_CONTAINER");
        return manualAssessmentContainer;
    }

    public String getManualAssessmentStepThree() {
        manualAssessmentStepThree = properties.getProperty("MANUALASSESSMENT_STEPTHREE");
        return manualAssessmentStepThree;
    }

    public String getManualAssessmentAssessmentInfo() {
        manualAssessmentAssessmentInfo = properties.getProperty("MANUALASSESSMENT_ASSESSMENTINFO");
        return manualAssessmentAssessmentInfo;
    }

    public String getManualAssessmentStepNext() {
        manualAssessmentStepNext = properties.getProperty("MANUALASSESSMENT_STEPNEXT");
        return manualAssessmentStepNext;
    }

    public String getManualAssessmentNextOne() {
        manualAssessmentNextOne = properties.getProperty("MANUALASSESSMENT_NEXTONE");
        return manualAssessmentNextOne;
    }

    public String getManualAssessmentUploadButton() {
        manualAssessmentUploadButton = properties.getProperty("MANUALASSESSMENT_UPLOADBUTTON");
        return manualAssessmentUploadButton;
    }

    public String getManualAssessmentFile() {
        manualAssessmentFile = properties.getProperty("MANUALASSESSMENT_FILE");
        return manualAssessmentFile;
    }

    public String getManualAssessmentUploadPath() {
        manualAssessmentUploadPath = properties.getProperty("MANUALASSESSMENT_UPLOADPATH");
        return manualAssessmentUploadPath;
    }

    public String getStepOneTitle() {
        stepOneTitle = properties.getProperty("MANUALASSESSMENT_STEPONETITLE");
        return stepOneTitle;
    }

    public String getNextButton() {
        nextButton = properties.getProperty("MANUALASSESSMENT_NEXTBUTTON");
        return nextButton;
    }

    public String getStepTwoSubjectArea() {
        stepTwoSubjectArea = properties.getProperty("MANUALASSESSMENT_STEPTWOSUBJECTAREA");
        return stepTwoSubjectArea;
    }

    public String getStepTwoSubjectAreaDropdownOptionChosen() {
        stepTwoSubjectAreaDropdownOptionChosen = properties.getProperty("MANUALASSESSMENT_STEPTWOSUBJECTAERADROPDOWNOPTIONCHOSEN");
        return stepTwoSubjectAreaDropdownOptionChosen;
    }

    public String getStepTwoSearch() {
        stepTwoSearch = properties.getProperty("MANUALASSESSMENT_STEPTWOSEARCH");
        return stepTwoSearch;
    }

    public String getStepTwoSearchResultFirstOptionChosen() {
        stepTwoSearchResultFirstOptionChosen = properties.getProperty("MANUALASSESSMENT_STEPTWOSEARCHRESULTFIRSTOPRIONCHOSEN");
        return stepTwoSearchResultFirstOptionChosen;
    }

    public String getStepTwoLinkSelectedStandardsButton() {
        stepTwoLinkSelectedStandardsButton = properties.getProperty("MANUALASSESSMENT_STEPTWOLINKSELECTEDSTANDARDSBUTTON");
        return stepTwoLinkSelectedStandardsButton;
    }

    public String getStepSevenTabButton() {
        stepSevenTabButton = properties.getProperty("MANUALASSESSMENT_STEPSEVENTABBUTTON");
        return stepSevenTabButton;
    }

    public String getStepSevenExitCreationModeButton() {
        stepSevenExitCreationModeButton = properties.getProperty("MANUALASSESSMENT_STEPSEVENEXITCREATIONMODEBUTTON");
        return stepSevenExitCreationModeButton;
    }
}
