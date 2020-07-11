package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ViewAssessmentsPage {
    private String popup, viewAssessmentPageHeader,showAssessmentsWithoutDataToggleButton, searchTextBox, searchTextBoxButton, clearAllFilters;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_NavigatingToPage", "");
            System.out.println("dir: " + dir);
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

    public String getPopup() {
        popup = properties.getProperty("POPUP");
        return popup;
    }

    public String getShowAssessmentsWithoutDataToggleButton() {
        showAssessmentsWithoutDataToggleButton = properties.getProperty("SHOW_ASSESSMENTS_WITHOUT_DATATOGGLE_BUTTON");
        return showAssessmentsWithoutDataToggleButton;
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

    public String getClearAllFilters() {
        clearAllFilters = properties.getProperty("CLEAR_ALL_IN_VIEW_ASSESSMENTS");
        return clearAllFilters;
    }

    public String getViewAssessmentPageHeader() {
        viewAssessmentPageHeader = properties.getProperty("VIEWASSESSMENTS_PAGE_HEADER");
        return viewAssessmentPageHeader;
    }

}
