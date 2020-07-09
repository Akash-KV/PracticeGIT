package Pom;

import java.io.FileInputStream;
import java.util.Properties;

//Page Object Model Class for CameraGraderPage
public class CameraGraderPage {
    private String cameraCanvas;

    public String getCameraItemBank() {
        cameraItemBank = properties.getProperty("CAMERA_ITEMBANK");
        return cameraItemBank;
    }

    private String cameraItemBank;
    String dir;
    Properties properties = new Properties();
    FileInputStream input;
    private static String os = null;

    public CameraGraderPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_ActionMenu", "");
            input = new FileInputStream(dir + "\\Properties\\CameraGraderPage.properties");
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCameraCanvas() {
        cameraCanvas = properties.getProperty("CAMERA_CANVAS");
        return cameraCanvas;
    }
}
