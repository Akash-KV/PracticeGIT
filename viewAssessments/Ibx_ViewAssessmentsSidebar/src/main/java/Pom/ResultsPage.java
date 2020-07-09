package Pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*Page Object Model class for ResultsPage */
public class ResultsPage {
    private String userFavorite, districtFavorite, gearIcon, changeAssessmentAuthor, alertSuccessonChangeAuthor;
    private String selectNewAuthor, agree_change_author, understand_no_undo, selectNewAuthorInput;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    {
        dir = System.getProperty("user.dir");
        dir = dir.replace("Ibx_ViewAssessmentsSidebar", "");
        System.out.println("dir: " + dir);
        os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            try {
                input = new FileInputStream(dir + "\\Properties\\ResultsPage.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                input = new FileInputStream(dir + "/Properties/ResultsPage.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //XPath
    }

    public String getUserFavorite() {
        userFavorite = properties.getProperty("USER_FAVORITE");
        return userFavorite;
    }

    //XPath
    public String getDistrictFavorite() {
        districtFavorite = properties.getProperty("DISTRICT_FAVORITE");
        return districtFavorite;
    }

    //XPath
    public String getUserFavoriteFlexible() {
        userFavorite = properties.getProperty("USER_FAVORITE_FLEXIBLE");
        return userFavorite;
    }

    //XPath
    public String getDistrictFavoriteFlexible() {
        userFavorite = properties.getProperty("DISTRICT_FAVORITE_FLEXIBLE");
        return userFavorite;
    }

    //XPath
    public String getGearIcon() {
        gearIcon = properties.getProperty("GEAR_ICON");
        return gearIcon;
    }

    //XPath
    public String getChangeAssessmentAuthorLink() {
        changeAssessmentAuthor = properties.getProperty("CHANGE_ASSESSMENT_AUTHOR");
        return changeAssessmentAuthor;
    }

    //XPath
    public String getSelectNewAuthorDropdown() {
        selectNewAuthor = properties.getProperty("SELECT_NEW_AUTHOR");
        return selectNewAuthor;
    }

    //XPath
    public String getAgree_change_author() {
        agree_change_author = properties.getProperty("AGREE_CHANGE_AUTHOR");
        return agree_change_author;
    }

    //XPath
    public String getUnderstand_no_undo() {
        understand_no_undo = properties.getProperty("UNDERSTAND_NO_UNDO");
        return understand_no_undo;
    }

    //XPath
    public String getSelectNewAuthorInput() {
        selectNewAuthorInput = properties.getProperty("SELECT_NEW_AUTHOR_INPUT");
        return selectNewAuthorInput;
    }

    //XPath
    public String getChangeAuthorButton() {
        selectNewAuthorInput = properties.getProperty("CHANGE_ASSESSMENT_AUTHOR");
        return selectNewAuthorInput;
    }

    //XPath
    public String getAlertSuccessonChangeAuthor() {
        alertSuccessonChangeAuthor = properties.getProperty("ALERT_SUCCESS_ON_CHANGE_AUTHOR");
        return alertSuccessonChangeAuthor;
    }
}