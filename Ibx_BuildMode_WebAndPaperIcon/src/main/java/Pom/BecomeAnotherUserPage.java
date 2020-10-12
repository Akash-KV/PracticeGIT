package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BecomeAnotherUserPage
 **/
public class BecomeAnotherUserPage {
    private String findUser, findUserInput, next, anotherUser;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BecomeAnotherUserPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_WebAndPaperIcon", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\BecomeAnotherUserPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/BecomeAnotherUserPage.properties");
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
     * Methods to read property file
     **/

    public String getFindUser() {
        findUser = properties.getProperty("FIND_USER");
        return findUser;
    }

    public String getFindUserInput() {
        findUserInput = properties.getProperty("FIND_USER_INPUT");
        return findUserInput;
    }

    public String getNext() {
        next = properties.getProperty("NEXT");
        return next;
    }

    public String getAnotherUser() {
        anotherUser = properties.getProperty("ANOTHER_USER");
        return anotherUser;
    }
}













