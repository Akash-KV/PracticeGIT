package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for DashboardPage
 **/
public class DashboardPage {
    private String assessmentsNav, illuminateLogo;
    private String settingsIcon, browseItemBank;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_WebAndPaperIcon", "");
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

    //XPath
    public String getAssessmentsNav() {
        assessmentsNav = properties.getProperty("ASSESSMENT_NAV");
        return assessmentsNav;
    }

    public String getBrowseItemBank() {
        browseItemBank = properties.getProperty("BROWSE_ITEM_BANK");
        return browseItemBank;
    }

    public String getSettingsIcon() {
        settingsIcon = properties.getProperty("SETTINGS_ICON");
        return settingsIcon;
    }

    //XPath
    public String getIlluminateLogo() {
        illuminateLogo = properties.getProperty("ILLUMINATE_LOGO");
        return illuminateLogo;
    }

}