package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utils Class for Secure properties
 **/
public class Secure {

    private static String username = null;
    private static String password = null;
    private static String userFullName = null;
    private static String studentQrId = null;
    private static String studentPortalUn = null;
    private static String studentPortalPw = null;
    private static String studentLastFirst = null;
    private static String studentLastFirstWithInitial = null;
    private static String emailId = null;
    private static String emailPassword = null;
    private static String anotherUser = null;

    private static String dir = null;
    private static String os = null;

    private static Map<String, String> map = new HashMap<String, String>();

    private static Properties properties = new Properties();
    private static InputStream input = null;

    public static void readProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Tags", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\secure.properties");
            } else {
                input = new FileInputStream(dir + "/secure.properties");
            }
            properties.load(input);
            username = properties.getProperty("USERNAME");
            password = properties.getProperty("PASSWORD");
            studentQrId = properties.getProperty("STUDENT_QR_ID");
            studentPortalUn = properties.getProperty("STUDENT_PORTAL_UN");
            studentPortalPw = properties.getProperty("STUDENT_PORTAL_PW");
            studentLastFirst = properties.getProperty("STUDENT_LAST_FIRST");
            studentLastFirstWithInitial = properties.getProperty("STUDENT_LAST_FIRST_WITH_INITIAL");
            anotherUser = properties.getProperty("ANOTHERUSER");
            userFullName = properties.getProperty("USERFULLNAME");
            emailId = properties.getProperty("EMAILID");
            emailPassword = properties.getProperty("EMAILPASSWORD");

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

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getAnotherUser() {
        return anotherUser;
    }

    public static String getStudentLastFirst() {
        return studentLastFirst;
    }

    public static String getStudentLastFirstWithInitial() {
        return studentLastFirstWithInitial;
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

    public static String getUserFullName() {
        return userFullName;
    }

    public static String getEmailID() {
        return emailId;
    }

    public static String getEmailPassword() {
        return emailPassword;
    }
}
