package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BrowseModePage
 **/
public class BrowseModePage {

    private String createAssessment, assessmentName, browseModeFirstItem;
    private String createButton, filters, bankFilterFirstCheckbox, browse_ItemSection;
    private String createItemButton, createItem, createItemPage, closeButton;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BrowseModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_CreateItem", "");
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

    public String getCreateItemButton() {
        createItemButton = properties.getProperty("BROWSE_CREATE_ITEM_BUTTON");
        return createItemButton;
    }

    public String getCreateItem() {
        createItem = properties.getProperty("BROWSE_CREATE_ITEM_BUTTON");
        return createItem;
    }

    public String getCreateItemPage() {
        createItemPage = properties.getProperty("BROWSE_CREATE_ITEM_PAGE");
        return createItemPage;
    }

    public String getCloseButton() {
        closeButton = properties.getProperty("BROWSE_CLOSE_BUTTON");
        return closeButton;
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

    public String getBrowse_ItemSection() {
        browse_ItemSection = properties.getProperty("BROWSE_ITEM_SECTION");
        return browse_ItemSection;
    }
}