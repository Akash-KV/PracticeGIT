package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model class for AssessmentViewPage
 **/
public class AssessmentViewPage {
    private String titleInputField;
    private String descriptionInputField;
    private String chooseAssessmentsButton;
    private String saveButton, viewAssessmentOverview, demographicOverview;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AssessmentViewPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_DemographicAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\AssessmentViewPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/AssessmentViewPage.properties");
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

    public String getDemographicOverview() {
        demographicOverview = properties.getProperty("ASSESSMENTVIEW_DEMOGRAPHIC_OVERVIEW");
        return demographicOverview;
    }
}
