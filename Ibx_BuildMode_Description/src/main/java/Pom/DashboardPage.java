package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for DashboardPage
 **/
public class DashboardPage {
    private String assessmentsNav, illuminateLogo, browseItemBank, settingsIcon;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public DashboardPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Description", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\DashboardPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/DashboardPage.properties");
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

    /**
     * methods to read date from property file
     **/

    public String getAssessmentsNav() {
        assessmentsNav = properties.getProperty("ASSESSMENTS_NAV");
        return assessmentsNav;
    }

    public String getBrowseItemBank() {
        browseItemBank = properties.getProperty("BROWSE_ITEM_BANK");
        return browseItemBank;
    }

    public String getIlluminateLogo() {
        illuminateLogo = properties.getProperty("ILLUMINATE_LOGO");
        return illuminateLogo;
    }

    public String getSettingsIcon() {
        settingsIcon = properties.getProperty("SETTINGS_ICON");
        return settingsIcon;
    }
}