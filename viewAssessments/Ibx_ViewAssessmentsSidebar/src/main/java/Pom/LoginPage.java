package Pom;
/*Page Object Model Class for LoginPage */

public class LoginPage {
    private static String username, password, signInButton, illuminatorLoginButton, samlLoginButton, googleLoginButton;

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
}