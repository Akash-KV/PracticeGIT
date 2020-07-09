package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model Class for Dashboard Page
 **/
public class Dashboard {

    private String assessmentsNav, illuminateLogo, viewAssessmentsLink, viewAssessmentsHeader;
    private String toggle, onlyWithData;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public Dashboard() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ListAssessments_LocalIdentifier", "");
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


    public String getIlluminateLogo() {
        illuminateLogo = properties.getProperty("ILLUMINATE_LOGO");
        return illuminateLogo;
    }


    public String getViewAssessmentsLink() {
        viewAssessmentsLink = properties.getProperty("VIEW_ASSESSMENTS_LINK");
        return viewAssessmentsLink;
    }

    public String getViewAssessmentsHeader() {
        viewAssessmentsHeader = properties.getProperty("VIEW_ASSESSMENTS_HEADER");
        return viewAssessmentsHeader;
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