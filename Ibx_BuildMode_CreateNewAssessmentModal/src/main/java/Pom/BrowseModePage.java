package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BrowseModePage
 **/
public class BrowseModePage {
    private String browse_ItemSection, createAssessmentButton, createAssessmentButtonPopup, overlay, TitleInCreateAssessmentPopup, browseFilters, browseRemoveItemList;
    private String createButton_CreateAssessmentPopup, browseMode_Items, myItemCheckBox;
    private String browseModeFirstItem, filters, bankFilterFirstCheckbox, browseCreateAssessmentCount;
    private String browseFilterItemType, cancelButton_CreateAssessmentPopup;
    private String bankShowMoreLink, browseAddItemList, browseModeToggleButton;
    private String warningCharacterLimitMessage;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_CreateNewAssessmentModal", "");
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

    //XPath
    public String getCreateAssessmentButton() {
        createAssessmentButton = properties.getProperty("BROWSE_CREATE_ASSESSMENT_BUTTON");
        return createAssessmentButton;
    }

    //XPath
    public String getCreateAssessmentButtonPopup() {
        createAssessmentButtonPopup = properties.getProperty("BROWSE_CREATE_ASSESSMENT_BUTTON_POPUP");
        return createAssessmentButtonPopup;
    }

    //XPath
    public String getOverlay() {
        overlay = properties.getProperty("BROWSE_OVERLAY");
        return overlay;
    }

    //XPath
    public String getTitleInCreateAssessmentPopup() {
        TitleInCreateAssessmentPopup = properties.getProperty("BROWSE_TITLE_IN_CREATE_ASSESSMENT_POPUP");
        return TitleInCreateAssessmentPopup;
    }

    //XPath
    public String getCreateButton_CreateAssessmentPopup() {
        createButton_CreateAssessmentPopup = properties.getProperty("BROWSE_CREATE_BUTTON_IN_CREATE_ASSESSMENT_POPUP");
        return createButton_CreateAssessmentPopup;
    }

    public String getBrowseMode_Items() {
        browseMode_Items = properties.getProperty("BROWSE_ITEM_SECTION");
        return browseMode_Items;
    }

    //XPath
    public String getCancelButton_CreateAssessmentPopup() {
        cancelButton_CreateAssessmentPopup = properties.getProperty("BROWSE_CANCEL_BUTTON_IN_CANCEL_ASSESSMENT_POPUP");
        return cancelButton_CreateAssessmentPopup;
    }

    public String getBrowseFilters() {
        browseFilters = properties.getProperty("BROWSE_FILTERS");
        return browseFilters;
    }

    public String getMyItemCheckBox() {
        myItemCheckBox = properties.getProperty("BROWSE_ITEM_BANK_TEXT_BOX");
        return myItemCheckBox;
    }

    public String getBrowseAddItemList() {
        browseAddItemList = properties.getProperty("BROWSE_ADDITEM_LIST");
        return browseAddItemList;
    }

    public String getBrowseCreateAssessmentCount() {
        browseCreateAssessmentCount = properties.getProperty("BROWSE_CREATE_ASSESSMENT_COUNT");
        return browseCreateAssessmentCount;
    }

    public String getBrowseRemoveItemList() {
        browseRemoveItemList = properties.getProperty("BROWSE_REMOVEITEM_LIST");
        return browseRemoveItemList;
    }

    public String getWarningCharacterLimitMessage() {
        warningCharacterLimitMessage = properties.getProperty("BROWSE_WARNING_CHARACTER_LIMIT_MESSAGE");
        return warningCharacterLimitMessage;
    }

    public String getBrowseModeToggleButton() {
        browseModeToggleButton = properties.getProperty("BROWSE_TOGGLE_BUTTON");
        return browseModeToggleButton;
    }

    public String getBankShowMoreLink() {
        bankShowMoreLink = properties.getProperty("BROWSE_BANK_SHOW_MORE_LINK");
        return bankShowMoreLink;
    }

    public String getBrowseFilterItemType() {
        browseFilterItemType = properties.getProperty("BROWSE_FILTERS_ITEM_TYPE");
        return browseFilterItemType;
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

    public String getBrowse_ItemSection() {
        browse_ItemSection = properties.getProperty("BROWSE_ITEM_SECTION");
        return browse_ItemSection;
    }
}
