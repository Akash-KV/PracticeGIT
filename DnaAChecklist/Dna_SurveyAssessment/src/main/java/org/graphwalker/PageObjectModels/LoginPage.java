package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class LoginPage extends PageObjectModelBase {
    private String username, password;
    private String signInButton;
    private String illuminatorLoginButton;
    private String samlLoginButton;
    private String googleLoginButton;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public LoginPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_SurveyAssessment", "");
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
    public String getUsername() {
        username = reader.getData("USERNAME");
        return username;
    }

    public String getPassword() {
        password = reader.getData("PASSWORD");
        return password;
    }

    public String getSignInButton() {
        signInButton = reader.getData("signInButton");
        return signInButton;
    }

    public String getIlluminatorLoginButton() {
        return illuminatorLoginButton;
    }

    public String getSamlLoginButton() {
        return samlLoginButton;
    }

    public String getGoogleLoginButton() {
        return googleLoginButton;
    }
}