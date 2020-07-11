
package Pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*Page Object Model Class for AssessmentsNavbar */
public class AssessmentsNavbar {
    private String viewAssessment, clickAssessment;
    private String assessmentView;
    private String itembankAssessment;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    {
        dir = System.getProperty("user.dir");
        dir = dir.replace("Ibx_ViewAssessmentsSidebarPagesColumnSort", "");
        System.out.println("dir: " + dir);
        os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            try {
                input = new FileInputStream(dir + "\\Properties\\AssessmentsNavBar.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                input = new FileInputStream(dir + "/Properties/AssessmentsNavBar.properties");
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

    public String getViewAssessment() {
        viewAssessment = properties.getProperty("VIEW_ASSESSMENTS");
        return viewAssessment;
    }

    public String getClickAssessment() {
        clickAssessment = properties.getProperty("CLICK_ASSESSMENT");
        return clickAssessment;
    }

}