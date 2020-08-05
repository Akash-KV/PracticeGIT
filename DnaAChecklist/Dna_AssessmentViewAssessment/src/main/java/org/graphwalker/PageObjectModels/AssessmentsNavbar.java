package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model class for AssessmentsNavbar
 **/
public class AssessmentsNavbar {
    private String viewAssessment;
    private String assessmentView;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AssessmentsNavbar() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_AssessmentViewAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\AssessmentsNavbar.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/AssessmentsNavbar.properties");
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

    public String getViewAssessment() {
        viewAssessment = properties.getProperty("ASSESSMENTSNAVBAR_VIEWASSESSMENT");
        return viewAssessment;
    }

    public String getAssessmentView() {
        //assessmentView = "//div[@class='navigation-group']//li[6]";
        assessmentView = properties.getProperty("ASSESSMENTSNAVBAR_ASSESSMENTVIEW");
        return assessmentView;
    }
}