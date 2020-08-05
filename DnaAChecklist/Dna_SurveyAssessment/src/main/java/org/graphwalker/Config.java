package org.graphwalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
    private static String authX = null;
    private static String local = null;

    String dir = null;
    Map<String, String> map = new HashMap<String, String>();

    Properties properties = new Properties();
    InputStream input = null;

    public void readProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_SurveyAssessment", "");
            input = new FileInputStream(dir + "config.properties");
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
            ticket = properties.getProperty("TICKET"); //added 01/10/19
            headless = properties.getProperty("HEADLESS");
            chrome = properties.getProperty("CHROME");
            authX = properties.getProperty("AUTHX_ENABLED");
            local = properties.getProperty("LOCAL_ENABLED");
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
        ticket = ticket.toLowerCase();
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

    public static String getAuthX() {
        authX = authX.toLowerCase();
        return authX;
    }

    public static String getLocal() {
        return local;
    }

}
