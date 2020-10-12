
package Utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**** Utils class for LoggerUtility *****/
public class LoggerUtility {

    public static Logger logger;
    public static Logger log;
    private static String dir = null;
    private static String os = null;
    private static InputStream input = null;

    public static void LoggerCall(String logMessage) {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_ControlPanel", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\log4j.properties");
            } else {
                input = new FileInputStream(dir + "/log4j.properties");
            }

            if (Dynamic.getLogger().equalsIgnoreCase("true")) {
                // configure log4j properties file
                PropertyConfigurator.configure(input);
                log = Logger.getLogger(LoggerUtility.class.getName());
                log.info(logMessage);
            } else {
                log.setLevel(Level.OFF);
            }
        } catch (NullPointerException ne) {
            //Do nothing
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
