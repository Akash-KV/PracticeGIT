package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for ManualAssessmentOverviewPage
public class ManualAssessmentOverviewPage {
    private String administrationTabButton;
    private String administrationTabDropdownEnterEditOption;
    private String administrationTabDropdownOnlineTestingOption;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ManualAssessmentOverviewPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_Uploads", "");
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

    /*
    Methods to read the data from Property file
    */
    public String getAdministrationTabButton() {
        administrationTabButton = properties.getProperty("MANUALASSESSMENTOVERVIEW_ADMINISTRATIONTABBUTTON");
        return administrationTabButton;
    }

    public String getAdministrationTabDropdownEnterEditOption() {
        administrationTabDropdownEnterEditOption = properties.getProperty("MANUALASSESSMENTOVERVIEW_ADMINISTRATIONTABDROPDOWNENTEREDITOPTION");
        return administrationTabDropdownEnterEditOption;
    }

    public String getAdministrationTabDropdownOnlineTestingOption() {
        administrationTabDropdownOnlineTestingOption = properties.getProperty("MANUALASSESSMENTOVERVIEW_ADMINISTRATIONTABDROPDOWNONLINETESTINGOPTION");
        return administrationTabDropdownOnlineTestingOption;
    }
}
