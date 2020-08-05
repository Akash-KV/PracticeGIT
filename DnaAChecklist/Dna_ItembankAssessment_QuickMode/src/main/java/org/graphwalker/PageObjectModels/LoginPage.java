package org.graphwalker.PageObjectModels;

import org.graphwalker.DataReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class LoginPage {
    private static String username, password, signInButton, illuminatorLoginButton, samlLoginButton, googleLoginButton;
    public static DataReader reader = new DataReader();
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public LoginPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ItembankAssessment_QuickMode", "");
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
    public static String getUsername() {
        username = reader.getData("USERNAME");
        return username;
    }

    public static String getPassword() {
        password = reader.getData("PASSWORD");
        return password;
    }

    public static String getSignInButton() {
        signInButton = reader.getData("signInButton");
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
}