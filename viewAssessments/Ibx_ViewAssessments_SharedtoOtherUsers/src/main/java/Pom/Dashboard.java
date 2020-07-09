package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for Dashboard Page
public class Dashboard {

    private String assessmentsNav, dashboardHeader, dashboardBody, illuminateLogo, assessmentsIcon, viewAssessmentsLink, viewAssessmentsHeader, signOut;
    private String firstLinkInAssessments, listAssessments, idInFirstRow, ownerFirstRow, titleInOverview, firstRow, toggle, onlyWithData;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public Dashboard() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_SharedtoOtherUsers", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\Dashboard.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/Dashboard.properties");
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

    public String getAssessmentsNav() {
        assessmentsNav = properties.getProperty("ASSESSMENTS_NAV");
        return assessmentsNav;
    }


    public String getDasdhboardHeader() {
        dashboardHeader = properties.getProperty("DASHBOARD_HEADER");
        return dashboardHeader;
    }

    public String getDashboardBody() {
        dashboardBody = properties.getProperty("DASHBOARD_BODY");
        return dashboardBody;
    }

    public String getIlluminateLogo() {
        illuminateLogo = properties.getProperty("ILLUMINATE_LOGO");
        return illuminateLogo;
    }

    public String getAssessmentsIcon() {
        assessmentsIcon = properties.getProperty("ASSESSMENTS_ICON");
        return assessmentsIcon;
    }

    public String getViewAssessmentsLink() {
        viewAssessmentsLink = properties.getProperty("VIEW_ASSESSMENTS_LINK");
        return viewAssessmentsLink;
    }

    public String getViewAssessmentsHeader() {
        viewAssessmentsHeader = properties.getProperty("VIEW_ASSESSMENTS_HEADER");
        return viewAssessmentsHeader;
    }

    public String getSignOut() {
        signOut = properties.getProperty("SIGN_OUT");
        return signOut;
    }

    public String getFirstLinkInAssessments() {
        firstLinkInAssessments = properties.getProperty("GET_FIRST_LINK_ASSESSMENTS");
        return firstLinkInAssessments;
    }

    public String getListAssessments() {
        listAssessments = properties.getProperty("GET_LIST_ASSESSMENTS");
        return listAssessments;
    }

    public String getIDInFirstRow() {
        idInFirstRow = properties.getProperty("GET_ID_FIRST_ROW");
        return idInFirstRow;
    }

    public String getOwnerFirstRow() {
        ownerFirstRow = properties.getProperty("GET_OWNER_FIRST_ROW");
        return ownerFirstRow;
    }

    public String getTitleInOverview() {
        titleInOverview = properties.getProperty("TITLE_OVERVIEW");
        return titleInOverview;
    }

    public String getFirstRow() {
        firstRow = properties.getProperty("GET_FIRST_ROW");
        return firstRow;
    }

    public String getToggle() {
        toggle = properties.getProperty("TOGGLE");
        return toggle;
    }

    public String getOnlyWithData() {
        onlyWithData = properties.getProperty("ONLY_WITH_DATA");
        return onlyWithData;
    }


}