package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*******Page Object Model Class for ManualAssessmentOverviewPage***********/
public class ManualAssessmentOverviewPage {
    private String administrationTabButton, manualAssessmentOverviewSmallSlip, manualAssessmentOverviewViewInBrowser;
    private String administrationTabDropdownEnterEditOption, manualAssessmentOverviewReportsMessage, manualAssessmentOverviewAdministrationbutton;
    private String administrationTabDropdownOnlineTestingOption, manualAssessmentOverviewReports, manualAssessmentOverviewEdit, manualAssessmentOverviewCorrectAnswer;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ManualAssessmentOverviewPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_QuickRoster", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ManualAssessmentOverviewPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ManualAssessmentOverviewPage.properties");
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

    public String getAdministrationTabButton() {
        administrationTabButton = properties.getProperty("MANUALASSESSMENTOVERVIEW_ADMINISTRATIONTABBUTTON");
        return administrationTabButton;
    }

    public String getManualAssessmentOverviewReports() {
        manualAssessmentOverviewReports = properties.getProperty("MANUALASSESSMENTOVERVIEW_REPORTS");
        return manualAssessmentOverviewReports;
    }

    public String getManualAssessmentOverviewReportsMessage() {
        manualAssessmentOverviewReportsMessage = properties.getProperty("MANUALASSESSMENTOVERVIEW_REPORTSMESSAGE");
        return manualAssessmentOverviewReportsMessage;
    }

    public String getManualAssessmentOverviewSmallSlip() {
        manualAssessmentOverviewSmallSlip = properties.getProperty("MANUALASSESSMENTOVERVIEW_SMALLSLIP");
        return manualAssessmentOverviewSmallSlip;
    }

    public String getManualAssessmentOverviewViewInBrowser() {
        manualAssessmentOverviewViewInBrowser = properties.getProperty("MANUALASSESSMENTOVERVIEW_VIEWINBROWSER");
        return manualAssessmentOverviewViewInBrowser;
    }

    public String getManualAssessmentOverviewCorrectAnswer() {
        manualAssessmentOverviewCorrectAnswer = properties.getProperty("MANUALASSESSMENTOVERVIEW_CORRECTANSWER");
        return manualAssessmentOverviewCorrectAnswer;
    }

    public String getManualAssessmentOverviewAdministrationbutton() {
        manualAssessmentOverviewAdministrationbutton = properties.getProperty("MANUALASSESSMENTOVERVIEW_ADMINISTRATIONTABBUTTON");
        return manualAssessmentOverviewAdministrationbutton;
    }

    public String getManualAssessmentOverviewEdit() {
        manualAssessmentOverviewEdit = properties.getProperty("MANUALASSESSMENTOVERVIEW_EDIT");
        return manualAssessmentOverviewEdit;
    }

    public String getAdministrationTabDropdownOnlineTestingOption() {
        administrationTabDropdownOnlineTestingOption = properties.getProperty("MANUALASSESSMENTOVERVIEW_ADMINISTRATIONTABDROPDOWNONLINETESTINGOPTION");
        return administrationTabDropdownOnlineTestingOption;
    }

}
