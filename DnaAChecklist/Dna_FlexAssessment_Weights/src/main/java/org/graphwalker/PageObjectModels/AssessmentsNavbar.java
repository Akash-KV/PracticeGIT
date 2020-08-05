package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class AssessmentsNavbar extends PageObjectModelBase {
    private String viewAssessment;
    private String itembankAssessment;
    private String assessmentNavBarAssessmentViewPage, assessmentNavBarViewAssessment;
    private String assessmentNavBarNavBarAssessments;
    private String assessmentNavBarViewAssessmentView;
    private String assessmentNavBarCreateButton;
    
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AssessmentsNavbar() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Weights", "");
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

    /*
    Methods to read the data from Property file
    */
    public String getViewAssessment() {
        viewAssessment = reader.getData("viewAssessment");
        return viewAssessment;
    }

    public String getItembankAssessment() {
        itembankAssessment = reader.getData("createNewItembankLink");
        return itembankAssessment;
    }

    public String getAssessmentNavBarCreateButton() {
        assessmentNavBarCreateButton = properties.getProperty("ASSESSMENTNAVBAR_CREATEBUTTON");
        return assessmentNavBarCreateButton;
    }

    public String getAssessmentNavBarNavBarAssessments() {
        assessmentNavBarNavBarAssessments = properties.getProperty("ASSESSMENTNAVBAR_NAVBARASSESSMENTS");
        return assessmentNavBarNavBarAssessments;
    }

    public String getAssessmentNavBarAssessmentViewPage() {
        assessmentNavBarAssessmentViewPage = properties.getProperty("ASSESSMENTNAVBAR_ASSESSMENTVIEW_PAGE");
        return assessmentNavBarAssessmentViewPage;
    }

    public String getAssessmentNavBarViewAssessment() {
        assessmentNavBarViewAssessment = properties.getProperty("ASSESSMENTSNAVBAR_VIEWASSESSMENT");
        return assessmentNavBarViewAssessment;
    }

    public String getAssessmentNavBarViewAssessmentView() {
        assessmentNavBarViewAssessmentView = properties.getProperty("ASSESSMENTNAVBAR_VIEWASSESSMENTVIEW");
        return assessmentNavBarViewAssessmentView;
    }
}