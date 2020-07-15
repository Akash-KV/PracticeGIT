package Pom;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

//Page Object Model Class for Dashboard
public class Dashboard {
    private String assessmentsIcon, illuminateLogo, assessmentsModal, createAssessmentLink, createFlexibleAssessmentLink, createItemBankLink;
    private String dashboardTileTitleElement;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;

    public void readProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_LegacyItemBankScoringAllTypes", "");
            input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\DashboardPage.properties"));
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
    public String getAssessmentsIcon() {
        assessmentsIcon = properties.getProperty("SIDEBAR_ASSESSMENTS_LINK");
        return assessmentsIcon;
    }

    public String getIlluminateLogo() {
        illuminateLogo = properties.getProperty("ILLUMINATE_LOGO");
        return illuminateLogo;
    }

    public String getAssessmentsModal() {
        assessmentsModal = properties.getProperty("ASSESSMENTS_MODAL");
        return assessmentsModal;
    }

    public String getCreateAssessmentLink() {
        createAssessmentLink = properties.getProperty("CREATE_ASSESSMENT_LINK");
        return createAssessmentLink;
    }

    public String getCreateFlexibleAssessmentLink() {
        createFlexibleAssessmentLink = properties.getProperty("CREATE_FLEXIBLE_ASSESSMENT_ICON");
        return createFlexibleAssessmentLink;
    }

    public String getCreateItemBankLink() {
        createItemBankLink = properties.getProperty("CREATE_ITEMBANK_ASSESSMENT_ICON");
        return createItemBankLink;
    }

    public String getDashboardTileTitleElement() {
        dashboardTileTitleElement = properties.getProperty("DASHBOARD_TILETITLEELEMENT");
        return dashboardTileTitleElement;
    }
}