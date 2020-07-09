package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model class for ResultsPage
 **/

public class ResultsPage {
    private String createdBy, gradeLevels, gradeLevelsForFlexible, scope, scopeForFlexible, subject, subjectForFlexible, createdByForFlexible, userFavorite, districtFavorite;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ResultsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_Filters", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ResultsPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ResultsPage.properties");
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
     * Methods to read Locators from Property file
     **/

    public String getCreatedBy() {
        createdBy = properties.getProperty("CREATED_BY");
        return createdBy;
    }

    public String getGradeLevels() {
        gradeLevels = properties.getProperty("GRADE_LEVELS");
        return gradeLevels;
    }

    public String getGradeLevelsForFlexible() {
        gradeLevelsForFlexible = properties.getProperty("GRADE_LEVELS_FOR_FLEXIBLE");
        return gradeLevelsForFlexible;
    }

    public String getScope() {
        scope = properties.getProperty("SCOPE");
        return scope;
    }

    public String getScopeForFlexible() {
        scopeForFlexible = properties.getProperty("SCOPE_FOR_FLEXIBLE");
        return scopeForFlexible;
    }

    public String getSubject() {
        subject = properties.getProperty("SUBJECT");
        return subject;
    }

    public String getSubjectForFlexible() {
        subjectForFlexible = properties.getProperty("SUBJECT_FOR_FLEXIBLE");
        return subjectForFlexible;
    }


    public String getCreatedByForFlexible() {
        createdByForFlexible = properties.getProperty("CREATED_BY_FOR_FLEXIBLE");
        return createdByForFlexible;
    }

    public String getUserFavorite() {
        userFavorite = properties.getProperty("USER_FAVORITE");
        return userFavorite;
    }

    public String getDistrictFavorite() {
        districtFavorite = properties.getProperty("DISTRICT_FAVORITE");
        return districtFavorite;
    }

}
