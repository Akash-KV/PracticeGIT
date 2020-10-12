package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BrowseModePage
 **/
public class BrowseModePage {

    private static String browse_CreateAssessmentButton, browse_Title_In_CreateAssessmentPopup;
    private static String filters, bankFilterFirstCheckbox, browse_AddItem_List, browse_First_Item_Content, browse_ViewAssessments_Navigation;
    private static String browseModeFirstItem, browse_CreateButton_In_CreateAssessmentPopup, browse_ItemSection;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BrowseModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Back", "");
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
     * Methods to read locators from Property file
     **/

    public String getCreateAssessmentButton() {
        browse_CreateAssessmentButton = properties.getProperty("BROWSE_CREATE_ASSESSMENT_BUTTON");
        return browse_CreateAssessmentButton;
    }

    public String getBrowse_Title_In_CreateAssessmentPopup() {
        browse_Title_In_CreateAssessmentPopup = properties.getProperty("BROWSE_TITLE_IN_CREATE_ASSESSMENT_POPUP");
        return browse_Title_In_CreateAssessmentPopup;
    }

    public String getBrowse_CreateButton_In_CreateAssessmentPopup() {
        browse_CreateButton_In_CreateAssessmentPopup = properties.getProperty("BROWSE_CREATE_BUTTON_IN_CREATE_ASSESSMENT_POPUP");
        return browse_CreateButton_In_CreateAssessmentPopup;
    }

    public String getBrowse_ItemSection() {
        browse_ItemSection = properties.getProperty("BROWSE_ITEM_SECTION");
        return browse_ItemSection;
    }

    public String getBrowse_AddItem_List() {
        browse_AddItem_List = properties.getProperty("BROWSE_ADDITEM_LIST");
        return browse_AddItem_List;
    }

    public String getBrowse_First_Item_Content() {
        browse_First_Item_Content = properties.getProperty("BROWSE_FIRST_ITEM_CONTENT");
        return browse_First_Item_Content;
    }

    public String getBrowse_ViewAssessments_Navigation() {
        browse_ViewAssessments_Navigation = properties.getProperty("BROWSE_VIEWASSESSMENTS_NAVIGATION");
        return browse_ViewAssessments_Navigation;
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
}
