package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model class for ViewAssessmentsPage
 **/
public class ViewAssessmentsPage {
    private String demographicTitle, demographic, createButton;
    private String demographicSave, other;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_DemographicAssessment", "");
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

    public String getOther() {
        other = properties.getProperty("VIEWASSESSMENTS_OTHER");
        return other;
    }

    public String getDemographic() {
        demographic = properties.getProperty("VIEWASSESSMENTS_DEMOGRAPHIC");
        return demographic;
    }

    public String getDemographicSave() {
        demographicSave = properties.getProperty("VIEWASSESSMENTS_DEMOGRAPHICSAVE");
        return demographicSave;
    }

    public String getDemographicTitle() {
        demographicTitle = properties.getProperty("VIEWASSESSMENTS_DEMOGRAPHICTITLE");
        return demographicTitle;
    }
}
