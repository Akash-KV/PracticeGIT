package org.graphwalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//Config class
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
    private static String studentQrId = null;
    private static String studentPortalUn = null;
    private static String studentPortalPw = null;
    private static String environment = null;
    private static String chrome = null;
    private static String studentLastFirst = null;
    private static String rescore = null;
    private static String dir = null;
    private static String emailid = null;
    private static String emailPassword = null;
    private static String authX = null;
    private static String local = null;

    private static Map<String, String> map = new HashMap<String, String>();

    private static Properties properties = new Properties();
    private static InputStream input = null;

    public static void readProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Uploads_GoogleDrive_Pdf", "");
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
            ticket = properties.getProperty("TICKET");
            headless = properties.getProperty("HEADLESS");
            studentQrId = properties.getProperty("STUDENT_QR_ID");
            studentPortalUn = properties.getProperty("STUDENT_PORTAL_UN");
            studentPortalPw = properties.getProperty("STUDENT_PORTAL_PW");
            environment = properties.getProperty("ENVIRONMENT");
            chrome = properties.getProperty("CHROME");
            studentLastFirst = properties.getProperty("STUDENT_LAST_FIRST");
            rescore = properties.getProperty("RESCORING");
            emailid = properties.getProperty("EMAILID");
            emailPassword = properties.getProperty("EMAILPASSWORD");
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

    /*
    Method to read the date from Config
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

    public static String getStudentQrId() {
        studentQrId = studentQrId.toLowerCase();
        return studentQrId;
    }

    public static String getStudentPortalUn() {
        studentPortalUn = studentPortalUn.toLowerCase();
        return studentPortalUn;
    }

    public static String getStudentPortalPw() {
        return studentPortalPw;
    }

    public static String getEnvironment() {
        environment = environment.toLowerCase();
        return environment;
    }

    public static boolean getHeadless() {
        boolean headlessBoolean = Boolean.parseBoolean(headless);
        return headlessBoolean;
    }

    public static String getChrome() {
        chrome = chrome.toLowerCase();
        return chrome;
    }

    public static String getStudentLastFirst() {
        return studentLastFirst;
    }

    public static String getRescore() {
        return rescore;
    }

    public static String getEmailID() {
        return emailid;
    }

    public static String getEmailPassword() {
        return emailPassword;
    }

    public static String getAuthX() {
        authX = authX.toLowerCase();
        return authX;
    }

    public static String getLocal() {
        return local;
    }
}
