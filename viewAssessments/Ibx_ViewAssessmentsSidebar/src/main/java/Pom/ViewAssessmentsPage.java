package Pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for ViewAssessments
public class ViewAssessmentsPage {
    private String ViewAssessmentsFilters, dataTableEmpty, searchTextBox, viewAssessmentPageHeader, searchButton, firstLinkOwnerNameAfterSearch;
    private String allAssessmentsLink, myAssessmentsLink, createdByMeLink, favoritesLink, firstLinkAfterSearch;
    private String unpublishedItemBankLink, trashItemBankLink, viewAssessmentsHeader, firstRowInput, trash_SubmitButton;
    private String dateCreated, firstLinkDateCreatedAfterSearch, firstLinkTypeAfterSearch, legacyItemBankTitle;
    private String firstRowActionButton, firstRowDeleteLink, finalDeleteAssessmentButton, undoLinkAfterDelete, popup, buildPageItemContent;
    private String searchTextBoxButton, no_Undo, clearAllFilters, showAssessmentsWithoutDataToggleButton, restoreAssessmentButton, delete_Confirm, delete_Agree, restoreMessage, searchButtonInViewAssessments;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    {
        dir = System.getProperty("user.dir");
        dir = dir.replace("Ibx_ViewAssessmentsSidebar", "");
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
    public String getViewAssessmentsFilters() {
        ViewAssessmentsFilters = properties.getProperty("VIEW_ASSESSEMENTS_FILTER");
        return ViewAssessmentsFilters;
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
        allAssessmentsLink = properties.getProperty("ALL_ASSESSMENTS_LINK");
        return allAssessmentsLink;
    }

    public String getClearAllFilters() {
        clearAllFilters = properties.getProperty("CLEAR_ALL_FILTER");
        return clearAllFilters;
    }

    public String getViewAssessmentSearchTextBox() {
        searchTextBox = "search_string";
        return searchTextBox;
    }

    public String getShowAssessmentsWithoutDataToggleButton() {
        showAssessmentsWithoutDataToggleButton = properties.getProperty("SHOW_ASSESSMENTS_WITHOUT_DATATOGGLE_BUTTON");
        return showAssessmentsWithoutDataToggleButton;
    }

    //XPath
    public String getViewAssessments_MyAssessmentsLink() {
        myAssessmentsLink = properties.getProperty("MY_ASSESSMENTS_LINK");
        return myAssessmentsLink;
    }

    //XPath
    public String getViewAssessments_CreatedByMeLink() {
        createdByMeLink = properties.getProperty("CREATED_BY_ME_LINK");
        return createdByMeLink;
    }

    //XPath
    public String getViewAssessments_FavoritesLink() {
        favoritesLink = properties.getProperty("FAVORITES_LINK");
        return favoritesLink;
    }

    //XPath
    public String getViewAssessments_UnpublishedItemBankLink() {
        //Draft is shown in Site instead of UnPublished
        unpublishedItemBankLink = properties.getProperty("DRAFTITEMBANK_LINK");
        return unpublishedItemBankLink;
    }

    //XPath
    public String getViewAssessments_TrashLink() {
        trashItemBankLink = properties.getProperty("TRASH_LINK");
        return trashItemBankLink;
    }

    //XPath
    public String getViewAssessmentsHeader() {
        viewAssessmentsHeader = properties.getProperty("VIEW_ASSESSMENTS_HEADER");
        return viewAssessmentsHeader;
    }

    public String getFirstLinkAfterSearch() {
        firstLinkAfterSearch = properties.getProperty("FIRST_LINK_AFTER_SEARCH");
        return firstLinkAfterSearch;
    }

    public String getFirstLinkOwnerNameAfterSearch() {
        firstLinkOwnerNameAfterSearch = properties.getProperty("FIRST_LINK_OWNER_NAME_AFTER_SEARCH");
        return firstLinkOwnerNameAfterSearch;
    }

    public String getDateCreated() {
        dateCreated = properties.getProperty("DATE_CREATED");
        return dateCreated;
    }

    public String getFirstLinkDateCreatedAfterSearch() {
        firstLinkDateCreatedAfterSearch = properties.getProperty("FIRST_LINK_DATE_CREATED_AFTER_SEARCH");
        return firstLinkDateCreatedAfterSearch;
    }

    public String getFirstLinkTypeAfterSearch() {
        firstLinkTypeAfterSearch = properties.getProperty("FIRST_LINK_TYPE_AFTER_SEARCH");
        return firstLinkTypeAfterSearch;
    }

    public String getLegacyItemBankTitle() {
        legacyItemBankTitle = properties.getProperty("LEGACY_ITEMBANK_TITLE");
        return legacyItemBankTitle;
    }

    public String getFirstRowActionButton() {
        firstRowActionButton = properties.getProperty("ACTION_BUTTON_FOR_THE_FIRST_LINK");
        return firstRowActionButton;
    }

    public String getFirstRowDeleteLink() {
        firstRowDeleteLink = properties.getProperty("FIRST_ROW_DELETE_LINK");
        return firstRowDeleteLink;
    }

    //Yes, I am sure that the assessment is the one I want to delete
    public String getDelete_Confirm() {
        delete_Confirm = properties.getProperty("DELETE_UNDERSTAND_CHECKBOX");
        return delete_Confirm;
    }

    //Yes, Delete the assessment
    public String getDelete_Agree() {
        delete_Agree = properties.getProperty("GET_DELETE_AGREE_CHECKBOX");
        return delete_Agree;
    }

    public String getFinalDeleteAssessmentButton() {
        finalDeleteAssessmentButton = properties.getProperty("FINAL_DELETE_ASSESSMENT_BUTTON");
        return finalDeleteAssessmentButton;
    }

    public String getUndoLinkAfterDelete() {
        undoLinkAfterDelete = properties.getProperty("UNDO_LINK_AFTER_DELETE");
        return undoLinkAfterDelete;
    }

    public String getFirstRowInput() {
        firstRowInput = properties.getProperty("FIRST_ROW_INPUT");
        return firstRowInput;
    }

    public String getTrash_SubmitButton() {
        trash_SubmitButton = properties.getProperty("SUBMIT_BUTTON");
        return trash_SubmitButton;
    }

    //Yes, I understand that this CAN NOT be undone.
    public String getNo_Undo() {
        no_Undo = properties.getProperty("UNDERSTAND_NO_UNDO");
        return no_Undo;
    }

    public String getRestoreAssessmentButton() {
        restoreAssessmentButton = properties.getProperty("RESTORE_ASSESSMENT_BUTTON");
        return restoreAssessmentButton;
    }

    public String getRestoreMessage() {
        restoreMessage = properties.getProperty("RESTORE_MESSAGE");
        return restoreMessage;
    }

    public String getSearchTextBox() {
        searchTextBox = properties.getProperty("SEARCH_ASSESSMENTSBAR");
        return searchTextBox;
    }

    public String getSearchButtonInViewAssessments() {
        searchButtonInViewAssessments = properties.getProperty("SEARCH_BUTTON_IN_VIEW_ASSESSMENTS");
        return searchButtonInViewAssessments;
    }

    public String getPopup() {
        popup = properties.getProperty("POPUP");
        return popup;
    }

    public String getBuildItemContent() {
        buildPageItemContent = properties.getProperty("BUILD_PAGE_ITEM_CONTENT");
        return buildPageItemContent;
    }

    public String getViewAssessmentPageHeader() {
        viewAssessmentPageHeader = properties.getProperty("VIEWASSESSMENTS_PAGE_HEADER");
        return viewAssessmentPageHeader;
    }

    //id
    public String getViewAssessmentSearchtextboxButton() {
        searchTextBoxButton = "direct_search";
        return searchTextBoxButton;
    }

}
