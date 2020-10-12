package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**** Utils class for Dynamic *****/
public class Dynamic {

    private static String url = null;
    private static String environment = null;
    private static String ticket = null;
    private static String authX = null;
    private static String headless = null;
    private static String local = null;
    private static String adminUser = null;
    private static String reScore = null;
    private static String browser = null;
    private static String waitTime = null;
    private static String logger = null;
    private static String dir = null;
    private static String os = null;

    private static Map<String, String> map = new HashMap<String, String>();

    private static Properties properties = new Properties();
    private static InputStream input = null;

    public static void readProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Description", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\dynamic.properties");
            } else {
                input = new FileInputStream(dir + "/dynamic.properties");
            }
            properties.load(input);
            browser = properties.getProperty("BROWSER");
            waitTime = properties.getProperty("WAIT_TIME");
            url = properties.getProperty("URL");
            ticket = properties.getProperty("TICKET");
            headless = properties.getProperty("HEADLESS");
            authX = properties.getProperty("AUTHX_ENABLED");
            adminUser = properties.getProperty("ADMIN_USER");
            local = properties.getProperty("LOGIN_PROVIDERS");
            environment = properties.getProperty("ENVIRONMENT");
            reScore = properties.getProperty("RESCORING");
            logger=properties.getProperty("LOGGER");
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

    public static String getTicket() {
        ticket = "mbt_" + ticket.toLowerCase() + "_";
        return ticket;
    }

    public static boolean getHeadless() {
        boolean headlessBoolean = Boolean.parseBoolean(headless);
        return headlessBoolean;
    }

    public static String getEnvironment() {
        environment = environment.toLowerCase();
        return environment;
    }

    public static String getLocal() {
        return local;
    }

    public static String getAuthX() {
        return authX;
    }

    public static String getAdminUser() {
        return adminUser;
    }

    public static String getReScore() {
        return reScore;
    }

    public static String getLogger(){ return logger;}
}
