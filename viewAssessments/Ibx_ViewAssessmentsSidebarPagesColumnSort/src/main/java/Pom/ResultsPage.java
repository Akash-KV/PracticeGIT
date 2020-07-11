package Pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*Page Object Model class for ResultsPage */
public class ResultsPage {
    private String userFavorite, districtFavorite;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    {
        dir = System.getProperty("user.dir");
        dir = dir.replace("Ibx_ViewAssessmentsSidebarPagesColumnSort", "");
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

    }

    //XPath
    public String getUserFavorite() {
        userFavorite = properties.getProperty("USER_FAVORITE");
        return userFavorite;
    }

    //XPath
    public String getDistrictFavorite() {
        districtFavorite = properties.getProperty("DISTRICT_FAVORITE");
        return districtFavorite;
    }
}
