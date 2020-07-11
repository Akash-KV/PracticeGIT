package Pom;
/**** Dashboard *****/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*Page Object Model Class for Dashboard */
public class Dashboard {
    private String assessmentsNav, illuminateLogo;
    private String viewAssessmentsLink, viewAssessmentsHeader;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    {
        dir = System.getProperty("user.dir");
        dir = dir.replace("Ibx_ViewAssessmentsSidebar", "");
        System.out.println("dir: " + dir);
        os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            try {
                input = new FileInputStream(dir + "\\Properties\\Dashboard.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                input = new FileInputStream(dir + "/Properties/Dashboard.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //XPath
    public String getAssessmentsNav() {
        assessmentsNav = properties.getProperty("ASSESSMENT_NAV");
        return assessmentsNav;
    }

    //XPath
    public String getIlluminateLogo() {
        illuminateLogo = properties.getProperty("ILLUMINATE_LOGO");
        return illuminateLogo;
    }

    public String getViewAssessmentsHeader() {
        viewAssessmentsHeader = properties.getProperty("VIEW_ASSESSMENTS_HEADER");
        return viewAssessmentsHeader;
    }

    public String getViewAssessmentsLink() {
        viewAssessmentsLink = properties.getProperty("VIEW_ASSESSMENTS_LINK");
        return viewAssessmentsLink;
    }
}