package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
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
    private String manualAssessmentPageGoBackToStepThree;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ManualAssessmentPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_Weights", "");
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
    public String getManualAssessmentPageGoBackToStepThree() {
        manualAssessmentPageGoBackToStepThree = properties.getProperty("MANUALASSESSMENTOVERVIEW_GOBACKTOSTEPTHREE");
        return manualAssessmentPageGoBackToStepThree;
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
