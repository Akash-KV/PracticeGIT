package Pom;

import java.io.FileInputStream;
import java.util.Properties;

//Page Object Model Class for OnlineAssessmentPreviewWindow
public class OnlineAssessmentPreviewWindow {
    private String beginTestButton;
    String dir;
    Properties properties = new Properties();
    FileInputStream input;
    private static String os = null;

    public OnlineAssessmentPreviewWindow() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_ActionMenu", "");
            input = new FileInputStream(dir + "\\Properties\\OnlineAssessmentPreviewWindow.properties");
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBeginTestButton() {
        beginTestButton = properties.getProperty("BEGIN_TEST_BUTTON");
        return beginTestButton;
    }
}
