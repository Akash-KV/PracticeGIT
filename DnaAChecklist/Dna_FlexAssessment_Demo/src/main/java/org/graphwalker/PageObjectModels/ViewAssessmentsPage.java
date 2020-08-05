package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model Class for ViewAssessmentsPage
 **/
public class ViewAssessmentsPage {
    private String createButton;
    private String flexible, addAssessmentTitle;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Demo", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ViewAssessmentsPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ViewAssessmentsPage.properties");
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

    public String getCreateButton() {
        createButton = properties.getProperty("VIEWASSESSMENTS_CREATEBUTTON");
        return createButton;
    }

    public String getFlexible() {
        flexible = properties.getProperty("VIEWASSESSMENTS_FLEXIBLE");
        return flexible;
    }

    public String getAddAssessmentTitle() {
        addAssessmentTitle = properties.getProperty("VIEWASSESSMENTS_ADDASSESSMENTTITLE");
        return addAssessmentTitle;
    }
}
