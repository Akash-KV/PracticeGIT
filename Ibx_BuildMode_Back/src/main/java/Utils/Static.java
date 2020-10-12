package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utils Class for Static properties
 **/
public class Static {

    private static String closeBrowser = null;
    private static String multiSite = null;
    private static String screenshots = null;
    private static String chrome = null;
    private static String firefox = null;

    private static String dir = null;
    private static String os = null;

    private static Map<String, String> map = new HashMap<String, String>();

    private static Properties properties = new Properties();
    private static InputStream input = null;

    public static void readProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Back", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\static.properties");
            } else {
                input = new FileInputStream(dir + "/static.properties");
            }
            properties.load(input);
            closeBrowser = properties.getProperty("CLOSE_BROWSER");
            multiSite = properties.getProperty("MULTI_SITE");
            screenshots = properties.getProperty("SCREENSHOTS");
            chrome = properties.getProperty("CHROME");
            firefox = properties.getProperty("FIREFOX");

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

    public static String getCloseBrowser() {
        closeBrowser.toLowerCase();
        return closeBrowser;
    }

    public static String getMultiSite() {
        multiSite.toLowerCase();
        return multiSite;
    }

    public static String getScreenshots() {
        screenshots.toLowerCase();
        return screenshots;
    }

    public static String getChrome() {
        chrome = chrome.toLowerCase();
        return chrome;
    }

    public static String getFirefox() {
        return firefox;
    }


}
