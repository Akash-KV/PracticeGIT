package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class OnlineTestingAdministrationPage {
    private String testWithQuickCodeButton;
    private String testWithQuickCodePostCreationModalExitButton;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public OnlineTestingAdministrationPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_Weights", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\OnlineTestingAdministrationPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/OnlineTestingAdministrationPage.properties");
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
    Methods to read the data from Property file
    */
    public String getTestWithQuickCodeButton() {
        testWithQuickCodeButton = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERBUTTON");
        return testWithQuickCodeButton;
    }

    public String getTestWithQuickCodePostCreationModalExitButton() {
        testWithQuickCodePostCreationModalExitButton = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTWITHQUICKCODEPOSTCREATIONMODALEXITBUTTON");
        return testWithQuickCodePostCreationModalExitButton;
    }
}
