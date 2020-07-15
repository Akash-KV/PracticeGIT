package Pom;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for Login Page
public class LoginPage {
    private String username, password;
    private String loginUsername, loginPassword, loginSignInButton,loginIlluminateLogoForDemo,loginIlluminateLogoForIBXon,loginGoogleEmail,loginGooglePassword;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    public void readProperties() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_LegacyItemBankScoringAllTypes", "");
            input = new FileInputStream(dir + DriverHelper.getPath("\\Properties\\LoginPage.properties"));
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



    /*
    Methods to read the data from Property file
    */

    public String getloginUsername() {
        loginUsername = properties.getProperty("LOGIN_USERNAME");
        return loginUsername;
    }

    public String getloginPassword() {
        loginPassword = properties.getProperty("LOGIN_PASSWORD");
        return loginPassword;
    }

    public String getloginSignInButton() {
        loginSignInButton = properties.getProperty("LOGIN_SIGNINBUTTON");
        return loginSignInButton;
    }
    public String getLoginIlluminateLogoForDemo() {
        loginIlluminateLogoForDemo = properties.getProperty("LOGIN_ILLUMINATELOGO_FOR_DEMO");
        return loginIlluminateLogoForDemo;
    }

    public String getLoginIlluminateLogoForIBXon() {
        loginIlluminateLogoForIBXon = properties.getProperty("LOGIN_ILLUMINATELOGO_FOR_IBXON");
        return loginIlluminateLogoForIBXon;
    }

    public String getLoginGoogleEmail () {
        loginGoogleEmail = properties.getProperty("LOGIN_GOOGLE_EMAIL");
        return loginGoogleEmail;
    }
    public String getLoginGooglePassword () {
        loginGooglePassword = properties.getProperty("LOGIN_GOOGLE_PASSWORD");
        return loginGooglePassword;
    }
}