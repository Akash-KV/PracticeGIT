package Pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*Page Object Model class for ResultsPage */
public class ViewAssessmentsPage {
    private String dataTableEmpty, searchTextBox, searchButton, lastAccessedTitle;
    private String allAssessmentsLink, firstLinkAfterSearch, assessmentWithDataToggle, currentDataTitle;
    private String viewAssessmentsHeader, firstRowCurrentDataGreen;
    private String dateCreated, firstRowCurrentDataGrey;
    private String searchTextBoxButton, viewAssessmentPageHeader, popup;
    private String checkHorizontalLineWhenToggleOFF, userFavoriteFlexible, firstRowTypeColumn, ownerTitle, firstIDafterSearch, typeTitle, clearAllInViewAssessments;
    private String tableList, showAssessmentsWithoutDataToggleButton, clearAllFilters;
    private static String checkAssessmentWithDataToggle;
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
                input = new FileInputStream(dir + "\\Properties\\ViewAssessmentsPage.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                input = new FileInputStream(dir + "/Properties/ViewAssessmentsPage.properties");
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
    public String getCheckAssessmentWithDataToggle() {
        checkAssessmentWithDataToggle = properties.getProperty("CHECK_ASSESSMENT_WITH_DATA_TOGGLE");
        return checkAssessmentWithDataToggle;
    }

    //XPath
    public String getAssessmentWithDataToggle() {
        assessmentWithDataToggle = properties.getProperty("ASSESSMENT_WITH_DATA_TOGGLE");
        return assessmentWithDataToggle;
    }

    //XPath
    public String getDataTableEmpty() {
        dataTableEmpty = properties.getProperty("DATA_TABLE_EMPTY");
        return dataTableEmpty;
    }

    //ID
    public String getViewAssessmentsSearchtextbox() {
        searchTextBox = properties.getProperty("SEARCH_TEXT_BOX");
        return searchTextBox;
    }

    //ID
    public String getViewAssessmentsSearchButton() {
        searchButton = properties.getProperty("SEARCH_TEXT_BOX_BUTTON");
        return searchButton;
    }

    //XPath
    public String getViewAssessments_AllAssessmentsLink() {
        allAssessmentsLink = properties.getProperty("ALL_ASSESSMENT_LINK");
        return allAssessmentsLink;
    }

    //XPath
    public String getViewAssessmentsHeader() {
        viewAssessmentsHeader = properties.getProperty("VIEW_ASSESSMENTS_HEADER");
        return viewAssessmentsHeader;
    }

    //XPath
    public String getFirstLinkAfterSearch() {
        firstLinkAfterSearch = properties.getProperty("FIRST_LINK_AFTER_SEARCH");
        return firstLinkAfterSearch;
    }

    //XPath
    public String getViewAssessmentsTable_DateCreated() {
        dateCreated = properties.getProperty("DATE_CREATED");
        return dateCreated;
    }

    //XPath
    public String getViewAssessmentsTable_TitleHeader() {
        dateCreated = properties.getProperty("VIEW_ASSESSMENT_TABLE_TITLE_HEADER");
        return dateCreated;
    }

    //XPath
    public String getClearAllInViewAssessments() {
        clearAllInViewAssessments = properties.getProperty("CLEAR_ALL_IN_VIEW_ASSESSMENTS");
        return clearAllInViewAssessments;
    }

    //XPath
    public String getPopup() {
        popup = properties.getProperty("POPUP");
        return popup;
    }

    public String getFirstRowCurrentDataGreen() {
        firstRowCurrentDataGreen = properties.getProperty("FIRST_ROW_CURRENT_DATA_GREEN");
        return firstRowCurrentDataGreen;
    }

    public String getFirstRowCurrentDataGrey() {
        firstRowCurrentDataGrey = properties.getProperty("FIRST_ROW_CURRENT_DATA_GREY");
        return firstRowCurrentDataGrey;
    }

    public String getFirstRowTypeColumn() {
        firstRowTypeColumn = properties.getProperty("FIRST_ROW_TYPE_COLUMN");
        return firstRowTypeColumn;
    }

    public String getFirstIDafterSearch() {
        firstIDafterSearch = properties.getProperty("FIRST_ID_AFTER_SEARCH");
        return firstIDafterSearch;
    }

    public String getTypeTitle() {
        typeTitle = properties.getProperty("TYPE_TITLE");
        return typeTitle;
    }

    public String getOwnerTitle() {
        ownerTitle = properties.getProperty("OWNER_TITLE");
        return ownerTitle;
    }

    public String getCheckHorizontalLineWhenToggleOFF() {
        checkHorizontalLineWhenToggleOFF = properties.getProperty("CHECK_HORIZONTAL_LINE_WHEN_TOGGLE_OFF");
        return checkHorizontalLineWhenToggleOFF;
    }

    public String getTableList() {
        tableList = properties.getProperty("TABLE_LIST");
        return tableList;
    }

    public String getLastAccessedTitle() {
        lastAccessedTitle = properties.getProperty("LAST_ACCESSED_TITLE");
        return lastAccessedTitle;
    }

    public String getCurrentDataTitle() {
        currentDataTitle = properties.getProperty("CURRENT_DATA_TITLE");
        return currentDataTitle;
    }

    public String getUserFavoriteFlexible() {
        userFavoriteFlexible = properties.getProperty("USER_FAVORITE_FLEXIBLE");
        return userFavoriteFlexible;
    }

    public String getShowAssessmentsWithoutDataToggleButton() {
        showAssessmentsWithoutDataToggleButton = properties.getProperty("SHOW_ASSESSMENTS_WITHOUT_DATATOGGLE_BUTTON");
        return showAssessmentsWithoutDataToggleButton;
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