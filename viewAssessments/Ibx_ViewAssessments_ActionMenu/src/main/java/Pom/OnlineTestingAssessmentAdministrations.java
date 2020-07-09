package Pom;

import java.io.FileInputStream;
import java.util.Properties;

//Page Object Model Class for OnlineTestingAssessmentAdministrations
public class OnlineTestingAssessmentAdministrations {
    String onlineTestingHeader;
    String dir;
    Properties properties = new Properties();
    FileInputStream input;
    private static String os = null;

    public OnlineTestingAssessmentAdministrations() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_ActionMenu", "");
            input = new FileInputStream(dir + "\\Properties\\OnlineTestingAssessmentAdministrations.properties");
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOnlineTestingHeader() {
        onlineTestingHeader = properties.getProperty("ONLINE_TESTING_HEADER");
        return onlineTestingHeader;
    }
}
