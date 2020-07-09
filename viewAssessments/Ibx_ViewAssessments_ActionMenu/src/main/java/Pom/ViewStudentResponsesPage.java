package Pom;

import java.io.FileInputStream;
import java.util.Properties;

//Page Object Model Class for ViewStudentResponsesPage
public class ViewStudentResponsesPage {
    private String saveButton;
    String dir;
    Properties properties = new Properties();
    FileInputStream input;
    private static String os = null;

    public ViewStudentResponsesPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_ActionMenu", "");
            input = new FileInputStream(dir + "\\Properties\\ViewStudentResponsesPage.properties");
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSaveButton() {
        saveButton = properties.getProperty("SAVE_BUTTON");
        return saveButton;
    }
}
