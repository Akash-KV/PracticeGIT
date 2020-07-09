package Utils;

import java.io.*;
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
    private static String authX = null;
    private static String closeBrowser = null;
    private static String multiSite = null;
    private static String screenshots = null;
    private static String ticket = null; //added 01/10/19
    private static String headless = null;
    private static String chrome = null;
    private static String firefox = null;
    private static String districtname = null;
    private static String anotherUser = null;
    private static String userlevel = null;
    private static String instance = null;
    private static String os = null;
    String dir = null;
    Map<String, String> map = new HashMap<String, String>();
    Properties properties = new Properties();
    InputStream input = null;


    public void readProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_ActionMenu", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\config.properties");
            } else {
                input = new FileInputStream(dir + "/config.properties");
            }
            properties.load(input);
            browser = properties.getProperty("BROWSER");
            waitTime = properties.getProperty("WAIT_TIME");
            url = properties.getProperty("URL");
            username = properties.getProperty("USERNAME");
            password = properties.getProperty("PASSWORD");
            authX = properties.getProperty("AUTHX");
            closeBrowser = properties.getProperty("CLOSE_BROWSER");
            multiSite = properties.getProperty("MULTI_SITE");
            ticket = properties.getProperty("TICKET");
            screenshots = properties.getProperty("SCREENSHOTS");
            headless = properties.getProperty("HEADLESS");
            chrome = properties.getProperty("CHROME");
            firefox = properties.getProperty("FIREFOX");
            districtname = properties.getProperty("DISTRICTNAME");
            anotherUser = properties.getProperty("ANOTHERUSER");
            userlevel = properties.getProperty("USER_LEVEL");
            instance = properties.getProperty("INSTANCE");
            System.out.println("Here....");
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

    public static String getAuthX() {
        return authX;
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

    public static String getDistrictname() {
        return districtname;
    }

    public static String getAnotherUser() {
        return anotherUser;
    }

    public static String getUserLevel() {
        return userlevel;
    }

    public static String getInstance() {
        return instance;
    }
}
