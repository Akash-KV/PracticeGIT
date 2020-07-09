package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for Login Page
public class LoginPage {
    private String username, password;
    private String loginUsername, loginPassword, loginSignInButton;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public LoginPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_LegacyItemBankAuthoredItemsScoring", "");
            System.out.println("dir: " + dir);
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
}