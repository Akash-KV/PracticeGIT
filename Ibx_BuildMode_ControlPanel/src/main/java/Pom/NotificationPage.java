package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for NotificationPage
 **/
public class NotificationPage {
    String notificationHeader, viewAllNotificationsLink, clearLink;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public NotificationPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_ControlPanel", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\NotificationPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/NotificationPage.properties");
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
     * Methods to read the data from Property file
     **/

    public String getNotificationHeader() {
        notificationHeader = properties.getProperty("NOTIFICATION_HEADER");
        return notificationHeader;
    }

}
