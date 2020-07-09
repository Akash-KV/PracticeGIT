package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for ViewAssessmentsPage
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
            dir = dir.replace("Ibx_ListAssessments_CreateButtonDropdown", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ViewAssessmentPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ViewAssessmentPage.properties");
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


    public String getCreateButton() {
        createButton = properties.getProperty("CREATE_BUTTON");
        return createButton;
    }

    public String getCreateButtonDropdownAssessmentView() {
        createButtonDropdownAssessmentView = properties.getProperty("CREATE_BUTTON_DROPDOWN_ASSESSMENTS_VIEW");
        return createButtonDropdownAssessmentView;
    }
}