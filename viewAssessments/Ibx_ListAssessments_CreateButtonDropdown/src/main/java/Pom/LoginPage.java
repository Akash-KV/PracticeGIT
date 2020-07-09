package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for LoginPage
public class LoginPage {
    private static String username, password, signInButton, illuminatorLoginButton, samlLoginButton, googleLoginButton;
    private String signin;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public LoginPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ListAssessments_CreateButtonDropdown", "");
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

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getSignInButton() {
        return signInButton;
    }

    public static String getIlluminatorLoginButton() {
        return illuminatorLoginButton;
    }

    public static String getSamlLoginButton() {
        return samlLoginButton;
    }

    public static String getGoogleLoginButton() {
        return googleLoginButton;
    }

    public String getSignin() {
        signin = properties.getProperty("SIGN_IN");
        return signin;
    }
}