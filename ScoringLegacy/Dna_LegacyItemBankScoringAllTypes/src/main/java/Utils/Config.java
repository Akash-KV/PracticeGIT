package Utils;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//Utils class for Config
public class Config {
    private static String browser = null;
    private static String waitTime = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
    private static String closeBrowser = null;
    private static String multiSite = null;
    private static String screenshots = null;
    private static String ticket = null; //added 01/10/19
    private static String headless = null;
    private static String chrome = null;
    private static String firefox = null;
    private static String districtname = null;
    private static String anotherUser = null;
    private static String authX = null;
    private static String os = null;
    private static String studentLastName = null;
    private static String studentUserName = null;
    private static String emailid = null;
    private static String emailPassword = null;

    String dir = null;
    Map<String, String> map = new HashMap<String, String>();

    private static Properties properties = new Properties();
    InputStream input = null;

    public void readProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_LegacyItemBankScoringAllTypes", "");
            System.out.println("Dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + DriverHelper.getPath("\\config.properties"));
            } else {
                input = new FileInputStream(dir + "/config.properties");
            }

            properties.load(input);
            browser = properties.getProperty("BROWSER");
            waitTime = properties.getProperty("WAIT_TIME");
            url = properties.getProperty("URL");
            username = properties.getProperty("USERNAME");
            password = properties.getProperty("PASSWORD");
            closeBrowser = properties.getProperty("CLOSE_BROWSER");
            multiSite = properties.getProperty("MULTI_SITE");
            ticket = properties.getProperty("TICKET");
            screenshots = properties.getProperty("SCREENSHOTS");
            headless = properties.getProperty("HEADLESS");
            chrome = properties.getProperty("CHROME");
            firefox = properties.getProperty("FIREFOX");
            districtname = properties.getProperty("DISTRICTNAME");
            anotherUser = properties.getProperty("ANOTHERUSER");
            authX = properties.getProperty("AUTHX_ENABLED");
            emailid = properties.getProperty("EMAILID");
            emailPassword = properties.getProperty("EMAILPASSWORD");
            studentLastName = properties.getProperty("STUDENT_LAST_FIRST");
            studentUserName = properties.getProperty("STUDENT_PORTAL_UN");

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
    Method to read the data from Config
    */
    public static Properties getProperties() {
        return properties;
    }

    public static String getBrowser() {
        browser.toLowerCase();
        return browser;
    }

    public static Integer getWaitTime() {
        int waitTimeInt = Integer.parseInt(waitTime);
        return waitTimeInt;
    }

    public static String getURL() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDistrictname() {
        return districtname;
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

    //added 01/10/19
    public static String getTicket() {
        ticket = "mbt_" + ticket.toLowerCase() + "_";
        return ticket;
    }

    public static boolean getHeadless() {
        boolean headlessBoolean = Boolean.parseBoolean(headless);
        return headlessBoolean;
    }

    public static String getChrome() {
        chrome = chrome.toLowerCase();
        return chrome;
    }

    public static String getFirefox() {
        return firefox;
    }

    public static String getAnotherUser() {
        return anotherUser;
    }

    public static String getAuthX() {
        return authX;
    }
    public static String getEmailID() {
        return emailid;
    }

    public static String getEmailPassword() {
        return emailPassword;
    }


    public static String getStudentLastName() {
        return studentLastName;
    }

    public static String getStudentUserName() {
        return studentUserName;
    }

}
