package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginPage {
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    private String usernameAuthxOff, passwordAuthxOff, signInAuthxOff;
    private String usernameAuthxOn, passwordAuthxOn, signInAuthxOn;

    public LoginPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_NavigatingToPage", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\LoginPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/LoginPage.properties");
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
     * Methods to read locators from Property file
     **/


    public String getUsernameAuthxOff() {
        usernameAuthxOff = properties.getProperty("LOGINPAGE_USERNAME_AUTHX_OFF");
        return usernameAuthxOff;
    }

    public String getPasswordAuthxOff() {
        passwordAuthxOff = properties.getProperty("LOGINPAGE_PASSWORD_AUTHX_OFF");
        return passwordAuthxOff;
    }

    public String getSignInAuthxOff() {
        signInAuthxOff = properties.getProperty("LOGINPAGE_SIGNIN_AUTHX_OFF");
        return signInAuthxOff;
    }

    public String getUsernameAuthxOn() {
        usernameAuthxOn = properties.getProperty("LOGINPAGE_USERNAME_AUTHX_ON");
        return usernameAuthxOn;
    }

    public String getPasswordAuthxOn() {
        passwordAuthxOn = properties.getProperty("LOGINPAGE_PASSWORD_AUTHX_ON");
        return passwordAuthxOn;
    }

    public String getSignInAuthxOn() {
        signInAuthxOn = properties.getProperty("LOGINPAGE_SIGNIN_AUTHX_ON");
        return signInAuthxOn;
    }
}
