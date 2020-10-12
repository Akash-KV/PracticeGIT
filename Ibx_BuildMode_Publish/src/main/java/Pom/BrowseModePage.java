package Pom;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BrowseModePage
 **/
public class BrowseModePage {
    private String browse_ItemSection, navigateToBrowse, assessmentsTab, doneButton;
    private String filters, bankFilterFirstCheckbox, browseModeFirstItem;
    private String addItems, createAssessments, assessmentName, createButton, browseToggle;
    private String closeSearch, searchItemId, itemSearch, removeItem, moreVert, addItemById;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BrowseModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Publish", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\BrowseModePage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/BrowseModePage.properties");
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
     * method to read the data from property file
     **/

    public String getBrowse_ItemSection() {
        browse_ItemSection = properties.getProperty("BROWSE_ITEM_SECTION");
        return browse_ItemSection;
    }

    public String getFilters() {
        filters = properties.getProperty("BROWSE_FILTERS");
        return filters;
    }

    public String getAddItems() {
        addItems = properties.getProperty("BROWSE_ADD_ITEMS");
        return addItems;
    }

    public String getBrowseModeFirstItem() {
        browseModeFirstItem = properties.getProperty("BROWSE_FIRST_ITEM");
        return browseModeFirstItem;
    }

    public String getCreateAssessments() {
        createAssessments = properties.getProperty("BROWSE_CREATE_ASSESSMENT_BUTTON");
        return createAssessments;
    }

    public String getAssessmentName() {
        assessmentName = properties.getProperty("BROWSE_TITLE_IN_CREATE_ASSESSMENT_POPUP");
        return assessmentName;
    }

    public String getCreateButton() {
        createButton = properties.getProperty("BROWSE_CREATE_BUTTON");
        return createButton;
    }

    public String getCloseSearch() {
        closeSearch = properties.getProperty("BROWSE_CLOSE_SEARCH");
        return closeSearch;
    }

    public String getSearchItemId() {
        searchItemId = properties.getProperty("BROWSE_SEARCH_TEXT_FIELD");
        return searchItemId;
    }

    public String getItemSearch() {
        itemSearch = properties.getProperty("BROWSE_ITEM_SEARCH");
        return itemSearch;
    }

    public String getAssessmentsTab() {
        assessmentsTab = properties.getProperty("BROWSE_ASSESSMENTS_TAB");
        return assessmentsTab;
    }

    public String getNavigateToBrowse() {
        navigateToBrowse = properties.getProperty("BROWSE_NAVIGATE_TO_BROWSE");
        return navigateToBrowse;
    }

    public String getAddItemById() {
        addItemById = properties.getProperty("BROWSE_ADD_ITEM_BY_ID");
        return addItemById;
    }

    public String getMoreVert() {
        moreVert = properties.getProperty("BROWSE_MORE_VERT");
        return moreVert;
    }

    public String getRemoveItem() {
        removeItem = properties.getProperty("BROWSE_REMOVE_ITEM");
        return removeItem;
    }

    public String getBrowseToggle() {
        browseToggle = properties.getProperty("BROWSE_TOGGLE_BUTTON");
        return browseToggle;
    }

    public String getDoneButton() {
        doneButton = properties.getProperty("BROWSE_DONE_BUTTON");
        return doneButton;
    }

    public String getBankFilterFirstCheckbox() {
        bankFilterFirstCheckbox = properties.getProperty("BROWSE_ITEM_BANK_TEXT_BOX");
        return bankFilterFirstCheckbox;
    }

}