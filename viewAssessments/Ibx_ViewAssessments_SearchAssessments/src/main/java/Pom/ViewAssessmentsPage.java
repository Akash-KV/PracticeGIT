package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for ViewAssessments Page
public class ViewAssessmentsPage {
    private String createButton, popup;
    private String createButtonDropdownAssessmentView, searchTextBox, searchTextBoxButton, loader, pagingInfo, firstRowTypeColumn, firstRowTypeForFlexible;
    private String unpublishedIteBank, unpublishedIteBankPageHeader, nodataAvailableinTable;
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

    /*
    Methods to read the locators from property file
    */
    public String getCreateButton() {
        createButton = properties.getProperty("CREATE_BUTTON");
        return createButton;
    }

    public String getCreateButtonDropdownAssessmentView() {
        createButtonDropdownAssessmentView = properties.getProperty("CREATE_BUTTON_DROPDOWN_ASSESSMENTS_VIEW");
        return createButtonDropdownAssessmentView;
    }

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

    public String getFirstRowTypeForFlexible() {
        firstRowTypeForFlexible = properties.getProperty("FIRST_ROW_TYPE_FOR_FLEXIBLE");
        return firstRowTypeForFlexible;
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

}
