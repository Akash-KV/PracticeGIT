package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class CreateAssessmentModal {
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public CreateAssessmentModal() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_SurveyAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\CreateAssessmentModal.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/CreateAssessmentModal.properties");
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
    private String legacyTab, clickSurvey, createSurveyName, createSurvey, saveChanges;

    public String getLegacyTab() {
        legacyTab = properties.getProperty("CREATEASSESSMENTMODEL_CLICKONLEGACYTAB");
        return legacyTab;
    }

    public String getClickSurvey() {
        clickSurvey = properties.getProperty("CREATEASSESSMENTMODEL_CLICKSURVEY");
        return clickSurvey;
    }

    public String getCreateSurveyName() {
        createSurveyName = properties.getProperty("CREATEASSESSMENTMODEL_CREATE_SURVEYNAME");
        return createSurveyName;
    }

    public String getCreateSurvey() {
        createSurvey = properties.getProperty("CREATEASSESSMENTMODEL_CREATE_SURVEY");
        return createSurvey;
    }

    public String getSaveChanges() {
        saveChanges = properties.getProperty("CREATEASSESSMENTMODEL_SAVE_CHANGES");
        return saveChanges;
    }
}
