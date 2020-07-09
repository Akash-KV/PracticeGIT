package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for AssessmentsNavbar page
public class AssessmentsNavbar {
    private String viewAssessment;
    private String flexAssessment;
    private String createAssessment;
    private String summaryAssessment;
    private String assessmentView;
    private String plainTextAssessment;
    private String surveyAssessment;
    private String itembankAssessment;
    private String visitItembank;
    private String performanceBand;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AssessmentsNavbar() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ListAssessments_LandingPage", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\AssessmentsNavBar.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/AssessmentsNavBar.properties");
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
Methods to read the Locators from property file
*/

    public String getViewAssessment() {
        viewAssessment = properties.getProperty("VIEW_ASSESSMENTS");
        return viewAssessment;
    }

    public String getFlexAssessment() {
        return flexAssessment;
    }

    public String getCreateAssessment() {
        return createAssessment;
    }

    public String getSummaryAssessment() {
        return summaryAssessment;
    }

    public String getAssessmentView() {
        assessmentView = properties.getProperty("ASSESSMENT_VIEW");
        return assessmentView;
    }

    public String getPlainTextAssessment() {
        return plainTextAssessment;
    }

    public String getSurveyAssessment() {
        return surveyAssessment;
    }

    public String getItembankAssessment() {
        itembankAssessment = properties.getProperty("");
        return itembankAssessment;
    }

    public String getVisitItembank() {
        return visitItembank;
    }

    public String getPerformanceBand() {
        return performanceBand;
    }
}