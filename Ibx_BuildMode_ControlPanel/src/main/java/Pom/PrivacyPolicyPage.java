package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for PrivacyPolicyPage
 **/

public class PrivacyPolicyPage {
    String privacyPolicyHeader;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public PrivacyPolicyPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_ControlPanel", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\PrivacyPolicyPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/PrivacyPolicyPage.properties");
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
    public String getPrivacyPolicyHeader() {
        privacyPolicyHeader = properties.getProperty("Privacy_POLICY_HEADER");
        return privacyPolicyHeader;
    }
}
