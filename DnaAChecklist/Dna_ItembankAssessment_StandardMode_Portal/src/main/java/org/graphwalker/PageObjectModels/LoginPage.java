package org.graphwalker.PageObjectModels;

import org.graphwalker.DataReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/****POM Class for LoginPage******/
public class LoginPage {
    private static String username, password, signInButton, login, illuminatorLoginButton, samlLoginButton, googleLoginButton;
    public static DataReader reader = new DataReader();
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    {
        dir = System.getProperty("user.dir");
        dir = dir.replace("Dna_ItembankAssessment_StandardMode_Portal", "");
        System.out.println("dir: " + dir);
        os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            try {
                input = new FileInputStream(dir + "\\Properties\\LoginPage.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                input = new FileInputStream(dir + "/Properties/LoginPage.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            properties.load(input);
            login = properties.getProperty("LOGIN_LOGINBUTTON");
            username = properties.getProperty("LOGIN_EMAIL");
            password = properties.getProperty("LOGIN_PASSWORD");
            signInButton = properties.getProperty("LOGIN_SUBMITBUTTON");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getSignInButton() {
        return signInButton;
    }

    public static String getLoginButton() {
        return login;
    }

    public static String getLoginEmail() {
        return username;
    }

    public static String getLoginPassword() {
        return password;
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