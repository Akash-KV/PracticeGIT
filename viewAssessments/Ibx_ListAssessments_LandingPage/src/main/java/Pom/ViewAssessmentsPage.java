package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for ViewAssessmentsPage
public class ViewAssessmentsPage {
    private String createButton;
    private String createButtonDropdownAssessmentView;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ListAssessments_LandingPage", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ViewAssessmentsPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ViewAssessmentsPage.properties");
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
    Methods to read the locators from property file
    */

    public String getCreateButton() {
        createButton = properties.getProperty("CREATE_BUTTON");
        return createButton;
    }

    public String getCreateButtonDropdownAssessmentView() {
        createButtonDropdownAssessmentView = properties.getProperty("CREATE_BUTTON_DROPDOWN_ASSESSMENTS_VIEW");
        return createButtonDropdownAssessmentView;

    }
}