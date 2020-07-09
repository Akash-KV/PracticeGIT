package Pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*Page Object Model Class for AssessmentViewPage */
public class AssessmentViewPage {

    private String titleInputField;
    private String descriptionInputField;
    private String chooseAssessmentsButton;
    private String saveButton;

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
                input = new FileInputStream(dir + "\\Properties\\AssessmentViewPage.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                input = new FileInputStream(dir + "/Properties/AssessmentViewPage.properties");
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
        titleInputField = properties.getProperty("TITLE_INPUT_FIELD");
        return titleInputField;
    }

    public String getDescriptionInputField() {
        descriptionInputField = properties.getProperty("DESCRIPTION_INPUT_FIELD");
        return descriptionInputField;
    }

    public String getChooseAssessmentsButton() {
        chooseAssessmentsButton = properties.getProperty("CHOOSE_ASSESSMENTS_BUTTON");
        return chooseAssessmentsButton;
    }

    public String getSaveButton() {
        saveButton = properties.getProperty("SAVE_BUTTON");
        return saveButton;
    }
}