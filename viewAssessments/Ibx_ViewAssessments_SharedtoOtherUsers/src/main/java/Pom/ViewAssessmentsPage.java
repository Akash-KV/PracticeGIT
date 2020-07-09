package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//Page Object Model Class for ViewAssessments Page
public class ViewAssessmentsPage {
    private String createButton, popup;
    private String createButtonDropdownAssessmentView, searchTextBox, searchTextBoxButton, loader, pagingInfo;
    private String sharedwithMeLink, allAssessmentLink, sharedwithMeTitle, addFilterButton, resetIDButton, dataTableEmpty, dateCreated, firstLinkDateCreatedAfterSearch;
    private String sharewithdropdown, filterButtonAfterSearch, dateCreatedMessage, firstLinkAfterSearch, firstLinkShareIconAfterSearch, currentPermissionModelTitle, currentPermissionModelcloseButton;
    private String actionButtonfortheFirstLink, shareCurrentPermissionHeader, shareOptioninActionButtonfortheFirstLink, siteSelectiondropdowntextbox;
    private String shareButton, sharesuccessmessage, controlPanelSettingoption, controlPanelSitedropdown, controlPanelSaveChangesbutton, siteheader, controlPanelSitedropdownsearchbox;
    private String shareMask, typecolumn, shareIcon, addEditFilterButton;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_SharedtoOtherUsers", "");
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

    public String getSharedwithMeLink() {
        sharedwithMeLink = properties.getProperty("SHARED_WITH_ME_LINK");
        return sharedwithMeLink;
    }

    public String getAllAssessmentLink() {
        allAssessmentLink = properties.getProperty("ALL_ASSESSMENT_LINK");
        return allAssessmentLink;
    }

    public String getSharedwithMeTitle() {
        sharedwithMeTitle = properties.getProperty("SHARED_WITH_ME_TITLE");
        return sharedwithMeTitle;
    }

    public String getAddFilterButton() {
        addFilterButton = properties.getProperty("ADD_FILTERS");
        return addFilterButton;
    }

    public String getAddEditFilterButton() {
        addEditFilterButton = properties.getProperty("ADD_EDIT_FILTERS");
        return addEditFilterButton;
    }

    public String getResetIDButton() {

        resetIDButton = "reset-btn";
        return resetIDButton;
    }

    public String getDataTableEmpty() {
        dataTableEmpty = properties.getProperty("DATA_TABLE_EMPTY");
        return dataTableEmpty;
    }

    public String getDateCreated() {
        dateCreated = properties.getProperty("DATE_CREATED");
        return dateCreated;
    }

    public String getFirstLinkDateCreatedAfterSearch() {
        firstLinkDateCreatedAfterSearch = properties.getProperty("FIRST_LINK_DATE_CREATED_AFTER_SEARCH");
        return firstLinkDateCreatedAfterSearch;
    }

    public String getFilterButtonAfterSearch() {
        filterButtonAfterSearch = properties.getProperty("FILTER_BUTTON_AFTER_SEARCH");
        return filterButtonAfterSearch;
    }

    public String getDateCreatedMessage() {
        dateCreatedMessage = properties.getProperty("DATE_CREATED_MSG");
        return dateCreatedMessage;
    }

    public String getFirstLinkAfterSearch() {
        firstLinkAfterSearch = properties.getProperty("FIRST_LINK_AFTER_SEARCH");
        return firstLinkAfterSearch;
    }

    public String getFirstLinkShareIconAfterSearch() {
        firstLinkShareIconAfterSearch = properties.getProperty("FIRST_LINK_SHARE_ICON_AFTER_SEARCH");
        return firstLinkShareIconAfterSearch;
    }

    public String getCurrentPermissionModelTitle() {
        currentPermissionModelTitle = properties.getProperty("CURRENT_PERMISSION_MODEL_TITLE");
        return currentPermissionModelTitle;
    }

    public String getCurrentPermissionModelcloseButton() {
        currentPermissionModelcloseButton = properties.getProperty("CURRENT_PERMISSION_MODEL_CLOSE_BUTTON");
        return currentPermissionModelcloseButton;
    }

    public String getActionButtonfortheFirstLink() {
        actionButtonfortheFirstLink = properties.getProperty("ACTION_BUTTON_FOR_THE_FIRST_LINK");
        return actionButtonfortheFirstLink;
    }

    public String getShareOptioninActionButtonfortheFirstLink() {
        shareOptioninActionButtonfortheFirstLink = properties.getProperty("SHARE_OPTION_IN_ACTION_BUTTON_FOR_THE_FIRST_LINK");
        return shareOptioninActionButtonfortheFirstLink;
    }

    public String getShareCurrentPermissionHeader() {
        shareCurrentPermissionHeader = properties.getProperty("CURRENT_PERMISSION_MODEL_TITLE2");
        return shareCurrentPermissionHeader;
    }

    public String getSharewithdropdown() {
        sharewithdropdown = "share_by";
        return sharewithdropdown;
    }

    public String getSiteSelectiondropdowntextbox() {
        siteSelectiondropdowntextbox = "s2id_autogen1";
        return siteSelectiondropdowntextbox;
    }

    public String getShareButton() {
        shareButton = "add_permissions";
        return shareButton;
    }

    public String getSharesuccessmessage() {
        sharesuccessmessage = properties.getProperty("SHARE_SUCCESS_MESSAGE");
        return sharesuccessmessage;
    }

    public String getControlPanelSettingoption() {
        controlPanelSettingoption = properties.getProperty("CONTROL_PANEL_SETTING_OPTION");
        return controlPanelSettingoption;
    }

    public String getControlPanelSitedropdown() {
        controlPanelSitedropdown = "s2id_site_id";
        return controlPanelSitedropdown;
    }

    public String getControlPanelSitedropdownsearchbox() {
        controlPanelSitedropdownsearchbox = properties.getProperty("CONTROL_PANEL_SITE_DROPDOWN_SEARCHBOX");
        return controlPanelSitedropdownsearchbox;
    }


    public String getControlPanelSaveChangesbutton() {
        controlPanelSaveChangesbutton = "save_changes";
        return controlPanelSaveChangesbutton;
    }

    public String getSiteheader() {
        siteheader = properties.getProperty("SITE_HEADER");
        return siteheader;
    }

    public String getShareMask() {
        shareMask = "select2-drop-mask";
        return shareMask;
    }

    public String getTypeColumn() {
        typecolumn = properties.getProperty("TYPE_COLUMN");
        return typecolumn;
    }


    public String getShareIcon(int i) {
        shareIcon = "(//table[starts-with(@id,'assessment_list_data_table')]//td[3]/preceding::td[1]/i)[" + i + "]";
        return shareIcon;
    }

    public String getPopup() {
        popup = properties.getProperty("POPUP");
        return popup;
    }

}
