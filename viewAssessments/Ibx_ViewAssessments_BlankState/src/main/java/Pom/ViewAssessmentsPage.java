package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Page Object Model class for ViewAssessments Page
public class ViewAssessmentsPage {
    private String createButton, popup;
    private String createButtonDropdownAssessmentView;
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

    public String getCreateButton() {
        createButton = properties.getProperty("CREATE_BUTTON");
        return createButton;
    }

    public String getCreateButtonDropdownAssessmentView() {
        createButtonDropdownAssessmentView = properties.getProperty("CREATE_BUTTON_DROPDOWN_ASSESSMENTS_VIEW");
        return createButtonDropdownAssessmentView;
    }

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

}
