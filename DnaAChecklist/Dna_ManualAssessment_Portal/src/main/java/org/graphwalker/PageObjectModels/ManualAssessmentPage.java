package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*******Page Object Model Class for ManualAssessmentPage***********/
public class ManualAssessmentPage {
    private String stepOneTitle, stepThreeMultipleChoiceAdvanced;
    private String nextButton, stepNext;
    private String stepTwoSubjectArea;
    private String stepTwoSubjectAreaDropdownOptionChosen;
    private String stepTwoSearch;
    private String stepTwoSearchResultFirstOptionChosen, stepThreeConstructedResponseNextOne;
    private String stepTwoLinkSelectedStandardsButton;
    private String stepSevenTabButton, stepThreeMultipleChoice;
    private String stepSevenExitCreationModeButton, stepThreeConstructedResponse, manualAssessmentInfo;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ManualAssessmentPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_Portal", "");
            System.out.println("dir: " + dir);
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

    public String getStepThreeMultipleChoice() {
        stepThreeMultipleChoice = properties.getProperty("MANUALASSESSMENT_STEPTHREE");
        return stepThreeMultipleChoice;
    }

    public String getStepThreeConstructedResponse() {
        stepThreeConstructedResponse = properties.getProperty("MANUALASSESSMENT_CONSTRUCTEDRESPONSE");
        return stepThreeConstructedResponse;
    }

    public String getStepThreeConstructedResponseNextOne() {
        stepThreeConstructedResponseNextOne = properties.getProperty("MANUALASSESSMENT_NEXTONE");
        return stepThreeConstructedResponseNextOne;
    }

    public String getStepThreeMultipleChoiceAdvanced() {
        stepThreeMultipleChoiceAdvanced = properties.getProperty("MANUALASSESSMENT_MULTIPLECHOICEADVANCED");
        return stepThreeMultipleChoiceAdvanced;
    }

    public String getStepNext() {
        stepNext = properties.getProperty("MANUALASSESSMENT_STEPNEXT");
        return stepNext;
    }

    public String getStepSevenTabButton() {
        stepSevenTabButton = properties.getProperty("MANUALASSESSMENT_STEPSEVENTABBUTTON");
        return stepSevenTabButton;
    }

    public String getStepSevenExitCreationModeButton() {
        stepSevenExitCreationModeButton = properties.getProperty("MANUALASSESSMENT_STEPSEVENEXITCREATIONMODEBUTTON");
        return stepSevenExitCreationModeButton;
    }

    public String getManualAssessmentInfo() {
        manualAssessmentInfo = properties.getProperty("MANUALASSESSMENT_ASSESSMENTINFO");
        return manualAssessmentInfo;
    }
}
