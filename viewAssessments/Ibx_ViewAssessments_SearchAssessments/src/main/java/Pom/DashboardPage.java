package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for Dahboard page
public class DashboardPage {
    private String dashboardHeader, illuminateLogo, assessmentsIcon, viewAssessmentsLink, viewAssessmentsHeader;
    private String assessmentsNav, dashboardBody, navigationSidebarContent, navigationPanel, clearAllFilters, firstLinkInAssessments;
    private String listAssessments, getIDInFirstRow, idInFirstRow, ownerFirstRow;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public DashboardPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_SearchAssessments", "");
            System.out.println("dir: " + dir);
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
     * Methods to read the Locators from property file
     **/

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

    public String getDashboardBody() {
        dashboardBody = properties.getProperty("DASHBOARD_BODY");
        return dashboardBody;
    }

    public String getNavigationSidebarContent() {
        navigationSidebarContent = properties.getProperty("NAVIGATION_SIDEBAR_CONTENT");
        return navigationSidebarContent;
    }

    public String getNavigationPanel() {
        navigationPanel = properties.getProperty("NAVIGATION_PANEL");
        return navigationPanel;
    }

    public String getClearAllFilters() {
        clearAllFilters = properties.getProperty("CLEAR_ALL_FILTER");
        return clearAllFilters;
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
}