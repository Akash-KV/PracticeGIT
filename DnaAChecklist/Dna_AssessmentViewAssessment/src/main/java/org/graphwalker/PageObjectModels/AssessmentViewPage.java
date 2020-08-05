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
    private String saveButton, overview;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AssessmentViewPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_AssessmentViewAssessment", "");
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

    public String getTitleInputField() {
        titleInputField = properties.getProperty("ASSESSMENTVIEW_TITLEINPUTFIELD_LINKNEW");
        return titleInputField;
    }

    public String getTitleInputFieldNew() {
        titleInputField = properties.getProperty("ASSESSMENTVIEW_TITLEINPUTFIELD");
        return titleInputField;
    }


    public String getSaveButton() {
        saveButton = properties.getProperty("ASSESSMENTVIEW_SAVEBUTTON");
        return saveButton;
    }

    public String getOverview() {
        overview = properties.getProperty("ASSESSMENTVIEW_VIEWASSESSMENTS_OVERVIEW");
        return overview;
    }

    public String getSelectAssessmentsButton() {
        overview = properties.getProperty("ASSESSMENTVIEW_SELECTASSESSMENTS_BUTTON");
        return overview;
    }

    public String getAddAssessmentsSearchBox() {
        overview = properties.getProperty("ASSESSMENTVIEW_ADDASSESSMENTS_SEARCHBOX");
        return overview;
    }

    public String getAddAssessmentsSearchButton() {
        overview = properties.getProperty("ASSESSMENTVIEW_ADDASSESSMENTS_SEARCHBUTTON");
        return overview;
    }

    public String getAddAssessmentsLoading() {
        overview = properties.getProperty("ASSESSMENTVIEW_ADDASSESSMENTS_LOADING");
        return overview;
    }

    public String getAddAssessmentsFirstCheckbox() {
        overview = properties.getProperty("ASSESSMENTVIEW_ADDASSESSMENTS_FIRST_CHECKBOX");
        return overview;
    }

    public String getAddAssessmentsAddButton() {
        overview = properties.getProperty("ASSESSMENTVIEW_ADDASSESSMENTS_ADDBUTTON");
        return overview;
    }

    public String getAssessmentsShowLink() {
        overview = properties.getProperty("ASSESSMENTVIEW_ASSESSMENTS_LINK");
        return overview;
    }


}
