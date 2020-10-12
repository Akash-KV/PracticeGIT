package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for LoginPage
 **/
public class LoginPage {

    private String usernameAuthxOff, passwordAuthxOff, signInAuthxOff;
    private String usernameAuthxOn, passwordAuthxOn, signInAuthxOn,localButton;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public LoginPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_ControlPanel", "");
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
        usernameAuthxOff = properties.getProperty("LOGIN_USERNAME_AUTHX_OFF");
        return usernameAuthxOff;
    }

    public String getPasswordAuthxOff() {
        passwordAuthxOff = properties.getProperty("LOGIN_PASSWORD_AUTHX_OFF");
        return passwordAuthxOff;
    }

    public String getSignInAuthxOff() {
        signInAuthxOff = properties.getProperty("LOGIN_SIGNIN_AUTHX_OFF");
        return signInAuthxOff;
    }

    public String getUsernameAuthxOn() {
        usernameAuthxOn = properties.getProperty("LOGIN_USERNAME_AUTHX_ON");
        return usernameAuthxOn;
    }

    public String getPasswordAuthxOn() {
        passwordAuthxOn = properties.getProperty("LOGIN_PASSWORD_AUTHX_ON");
        return passwordAuthxOn;
    }

    public String getSignInAuthxOn() {
        signInAuthxOn = properties.getProperty("LOGIN_SIGNIN_AUTHX_ON");
        return signInAuthxOn;
    }

    public String getLocalButton() {
        localButton = properties.getProperty("LOGIN_LOCAL_BUTTON_AUTHX_ON");
        return localButton;
    }
}
