package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Page Object Model class for ViewAssessments Page
public class ViewAssessmentsPage {
    private String popup, clearAllFilters, searchTextBox,searchTextBoxButton,viewAssessmentPageHeader;
    private String addFilters, searchAssessmentsBar, showAssessmentsWithoutDataToggleButton;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_BlankState", "");
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

    public String getAddFilters() {
        addFilters = properties.getProperty("ADD_FILTERS");
        return addFilters;
    }

    public String getSearchAssessmentsBar() {
        searchAssessmentsBar = properties.getProperty("SEARCH_ASSESSMENTSBAR");
        return searchAssessmentsBar;
    }

    public String getShowAssessmentsWithoutDataToggleButton() {
        showAssessmentsWithoutDataToggleButton = properties.getProperty("SHOW_ASSESSMENTS_WITHOUT_DATATOGGLE_BUTTON");
        return showAssessmentsWithoutDataToggleButton;
    }

    public String getPopup() {
        popup = properties.getProperty("POPUP");
        return popup;
    }

    public String getClearAllFilters() {
        clearAllFilters = properties.getProperty("CLEAR_ALL_IN_VIEW_ASSESSMENTS");
        return clearAllFilters;
    }

    public String getViewAssessmentSearchTextBox() {
        searchTextBox = "search_string";
        return searchTextBox;
    }

    //id
    public String getViewAssessmentSearchtextboxButton() {
        searchTextBoxButton = "direct_search";
        return searchTextBoxButton;
    }

    public String getViewAssessmentPageHeader() {
        viewAssessmentPageHeader = properties.getProperty("VIEWASSESSMENTS_PAGE_HEADER");
        return viewAssessmentPageHeader;
    }
}
