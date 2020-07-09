package Pom;

import java.io.FileInputStream;
import java.util.Properties;

//Page Object Model Class for Login Page
public class LoginPage {
    private String username, password;
    private String loginUsername, loginPassword, loginSignInButton;
    String dir;
    Properties properties = new Properties();
    FileInputStream input;
    private static String os = null;

    public LoginPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_ActionMenu", "");
            input = new FileInputStream(dir + "\\Properties\\LoginPage.properties");
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getloginUsername() {
        loginUsername = properties.getProperty("LOGIN_USERNAME");
        return loginUsername;
    }

    public String getloginPassword() {
        loginPassword = properties.getProperty("LOGIN_PASSWORD");
        return loginPassword;
    }

    public String getloginSignInButton() {
        loginSignInButton = properties.getProperty("LOGIN_SIGNIN_BUTTON");
        return loginSignInButton;
    }
}