package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for ViewAssessments Page
public class ViewAssessmentsPage {
    private String popup, searchTextBox, viewAssessmentSearchtextbox, searchTextBoxButton, loader, pagingInfo, firstRowTypeColumn, clearAllFilters;
    private String unpublishedIteBank, viewAssessmentPageHeader, unpublishedIteBankPageHeader, nodataAvailableinTable, showAssessmentsWithoutDataToggleButton;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_SearchAssessments", "");
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

    /**
     * Methods to read the locators from property file
     **/

    //id
    public String getViewAssessmentSearchtextbox() {
        viewAssessmentSearchtextbox = "search_string";
        return viewAssessmentSearchtextbox;
    }

    //id
    public String getViewAssessmentSearchtextboxButton() {
        searchTextBoxButton = "direct_search";
        return searchTextBoxButton;
    }

    public String getloader() {
        loader = properties.getProperty("LOADER");
        return loader;
    }

    public String getPagingInfo() {
        pagingInfo = properties.getProperty("PAGING_INFO");
        return pagingInfo;
    }

    //getting all type except flexible
    public String getFirstRowTypeColumn() {
        firstRowTypeColumn = properties.getProperty("FIRST_ROW_TYPE_COLUMN");
        return firstRowTypeColumn;
    }

    public String getUnpublishedItemBank() {
        unpublishedIteBank = properties.getProperty("UNPUBLISHED_ITEM_BANK");
        return unpublishedIteBank;
    }

    public String getUnpublishedIteBankPageHeader() {
        unpublishedIteBankPageHeader = properties.getProperty("UNPUBLISHED_ITEM_BANK_PAGE_HEADER");
        return unpublishedIteBankPageHeader;
    }

    public String getNodataAvailableinTable() {
        nodataAvailableinTable = properties.getProperty("NO_DATA_AVAILABLE_IN_TABLE");
        return nodataAvailableinTable;
    }

    public String getPopup() {
        popup = properties.getProperty("POPUP");
        return popup;
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

    public String getViewAssessmentPageHeader() {
        viewAssessmentPageHeader = properties.getProperty("VIEWASSESSMENTS_PAGE_HEADER");
        return viewAssessmentPageHeader;
    }
}
