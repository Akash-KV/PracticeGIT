package Pom;

import java.io.FileInputStream;
import java.util.Properties;

//Page Object Model Class for AssessmentSharePage
public class AssessmentSharePage {
    private String shareCanvas;
    String dir;
    Properties properties = new Properties();
    FileInputStream input;
    private static String os = null;

    public AssessmentSharePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_ActionMenu", "");
            input = new FileInputStream(dir + "\\Properties\\AssessmentSharePage.properties");
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getShareCanvas() {
        shareCanvas = properties.getProperty("SHARE_CANVAS");
        return shareCanvas;
    }
}
