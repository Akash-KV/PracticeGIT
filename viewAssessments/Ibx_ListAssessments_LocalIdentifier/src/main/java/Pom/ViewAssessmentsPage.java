package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Page Object Model Class for ViewAssessments Page
 **/
public class ViewAssessmentsPage {
    private String clearAllInViewAssessments, searchTextBox, searchTextBoxButton;
    private String firstLinkAfterSearch, localidentifierforfirstlink;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ListAssessments_LocalIdentifier", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ViewAssessmentsPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ViewAssessmentsPage.properties");
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
     * Methods to read locators from Property file
     **/

    //id
    public String getViewAssessmentSearchtextbox() {
        searchTextBox = "search_string";
        return searchTextBox;
    }

    //id
    public String getViewAssessmentSearchtextboxButton() {
        searchTextBoxButton = "direct_search";
        return searchTextBoxButton;
    }

    public String getFirstLinkAfterSearch() {
        firstLinkAfterSearch = properties.getProperty("FIRST_LINK_AFTER_SEARCH");
        return firstLinkAfterSearch;
    }


    public String getLocalidentifierforfirstlink() {
        localidentifierforfirstlink = properties.getProperty("LOCAL_IDENTIFIER_FOR_FIRST_LINK");
        return localidentifierforfirstlink;
    }

    public String getClearAllInViewAssessments() {
        clearAllInViewAssessments = properties.getProperty("CLEAR_ALL_IN_VIEW_ASSESSMENTS");
        return clearAllInViewAssessments;
    }
}
