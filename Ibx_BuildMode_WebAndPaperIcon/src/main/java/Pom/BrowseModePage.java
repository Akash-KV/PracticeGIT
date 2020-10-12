package Pom;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Page object model class for BrowseModePage
 **/
public class BrowseModePage {

    private String browse_ItemSection, closeSearch, searchTextField, itemSearch, webIcon, addItem, savingMessage;
    private String createButton, filters, bankFilterFirstCheckbox, browseModeFirstItem, createAssessment, assessmentName;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BrowseModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_WebAndPaperIcon", "");
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
     * Method to read data from property file
     **/

    public String getBrowse_ItemSection() {
        browse_ItemSection = properties.getProperty("BROWSE_ITEM_SECTION");
        return browse_ItemSection;
    }

    public String getCloseSearch() {
        closeSearch = properties.getProperty("BROWSE_CLOSE_SEARCH");
        return closeSearch;
    }

    public String getSearchTextField() {
        searchTextField = properties.getProperty("BROWSE_SEARCH_TEXT_FIELD");
        return searchTextField;
    }

    public String getItemSearch() {
        itemSearch = properties.getProperty("BROWSE_ITEM_SEARCH");
        return itemSearch;
    }

    public String getWebIcon() {
        webIcon = properties.getProperty("BROWSE_WEB_ICON");
        return webIcon;
    }

    public String getAddItem() {
        addItem = properties.getProperty("BROWSE_ADD_ITEM");
        return addItem;
    }

    public String getCreateAssessment() {
        createAssessment = properties.getProperty("BROWSE_CREATE_ASSESSMENT");
        return createAssessment;
    }

    public String getAssessmentName() {
        assessmentName = properties.getProperty("BROWSE_TITLE_IN_CREATE_ASSESSMENT_POPUP");
        return assessmentName;
    }

    public String getCreateButton() {
        createButton = properties.getProperty("BROWSE_CREATE_BUTTON");
        return createButton;
    }

    public String getFilters() {
        filters = properties.getProperty("BROWSE_FILTERS");
        return filters;
    }

    public String getBankFilterFirstCheckbox() {
        bankFilterFirstCheckbox = properties.getProperty("BROWSE_ITEM_BANK_TEXT_BOX");
        return bankFilterFirstCheckbox;
    }

    public String getBrowseModeFirstItem() {
        browseModeFirstItem = properties.getProperty("BROWSE_FIRST_ITEM");
        return browseModeFirstItem;
    }

    public String getSavingMessage() {
        savingMessage = properties.getProperty("BROWSE_SAVING_MESSAGE");
        return savingMessage;
    }
}