package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BrowseModePage
 **/
public class BrowseModePage {

    private String browse_CreateAssessmentButton, standards_Selector_Header, browse_Title_In_CreateAssessmentPopup;
    private String browse_CreateButton_In_CreateAssessmentPopup, browse_ItemSection, filters;
    private String browse_First_Item_Content, browse_No_Items_Message, show_More_Standards_Popup_Overlay;
    private String browse_First_Item_Standards_Chip, browse_Items_Standards_List, browse_Create_Item_Button;
    private String browse_Search_Standard, show_More_Standards_link, bankFilterFirstCheckbox, browseModeFirstItem;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BrowseModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Standards", "");
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

    public String getBrowse_First_Item_Content() {
        browse_First_Item_Content = properties.getProperty("BROWSE_FIRST_ITEM_CONTENT");
        return browse_First_Item_Content;
    }

    public String getBrowse_No_Items_Message() {
        browse_No_Items_Message = properties.getProperty("BROWSE_NO_ITEMS_MESSAGE");
        return browse_No_Items_Message;
    }

    public String getBrowse_First_Item_Standards_Chip() {
        browse_First_Item_Standards_Chip = properties.getProperty("BROWSE_FIRST_ITEM_STANDARDS_CHIP");
        return browse_First_Item_Standards_Chip;
    }

    public String getBrowse_Items_Standards_List() {
        browse_Items_Standards_List = properties.getProperty("BROWSE_ITEM_STANDARDS_LIST");
        return browse_Items_Standards_List;
    }

    public String getBrowse_Create_Item_Button() {
        browse_Create_Item_Button = properties.getProperty("BROWSE_CREATE_ITEM_BUTTON");
        return browse_Create_Item_Button;
    }

    public String getBrowse_Search_Standard() {
        browse_Search_Standard = properties.getProperty("BROWSE_SEARCH_STANDARD");
        return browse_Search_Standard;
    }

    public String getBrowseModeFirstItem() {
        browseModeFirstItem = properties.getProperty("BROWSE_FIRST_ITEM");
        return browseModeFirstItem;
    }

    public String getFilters() {
        filters = properties.getProperty("BROWSE_FILTERS");
        return filters;
    }

    public String getBankFilterFirstCheckbox() {
        bankFilterFirstCheckbox = properties.getProperty("BROWSE_ITEM_BANK_TEXT_BOX");
        return bankFilterFirstCheckbox;
    }

    public String getShow_More_Standards_link() {
        show_More_Standards_link = properties.getProperty("BROWSE_SHOW_MORE_STANDARDS_LINK");
        return show_More_Standards_link;
    }

    public String getStandards_Selector_Header() {
        standards_Selector_Header = properties.getProperty("BROWSE_STANDARDS_SELECTOR_HEADER");
        return standards_Selector_Header;
    }

    public String getShow_More_Standards_Popup_Overlay() {
        show_More_Standards_Popup_Overlay = properties.getProperty("BROWSE_OVERLAY");
        return show_More_Standards_Popup_Overlay;
    }
}
