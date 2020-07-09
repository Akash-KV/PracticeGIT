package Pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*Page Object Model class for ResultsPage */
public class ViewAssessments {
    private String ViewAssessmentsFilters, dataTableEmpty, searchTextBox, searchButton, firstLinkOwnerNameAfterSearch, lastAccessedTitle;
    private String allAssessmentsLink, myAssessmentsLink, createdByMeLink, favoritesLink, firstLinkAfterSearch, assessmentWithDataToggle, currentDataTitle;
    private String unpublishedItemBankLink, trashItemBankLink, viewAssessmentsHeader, firstRowInput, trash_SubmitButton, firstRowCurrentDataGreen;
    private String dateCreated, firstLinkDateCreatedAfterSearch, firstLinkTypeAfterSearch, legacyItemBankTitle, firstRowCurrentDataGrey;
    private String firstRowActionButton, firstRowDeleteLink, finalDeleteAssessmentButton, undoLinkAfterDelete, popup, noDataAvailableInTable;
    private String no_Undo, restoreAssessmentButton, delete_Confirm, checkHorizontalLineWhenToggleOFF, firstRow, userFavoriteFlexible, firstRowTypeColumn, ownerTitle, firstIDafterSearch, typeTitle, firstRowTypeForFlexible, delete_Agree, restoreMessage, clearAllInViewAssessments;
    private String tableList;
    private static String checkAssessmentWithDataToggle;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    {
        dir = System.getProperty("user.dir");
        dir = dir.replace("Ibx_ViewAssessmentsSidebarPagesColumnSort", "");
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
    public String getCheckAssessmentWithDataToggle() {
        checkAssessmentWithDataToggle = properties.getProperty("CHECK_ASSESSMENT_WITH_DATA_TOGGLE");
        return checkAssessmentWithDataToggle;
    }

    //XPath
    public String getAssessmentWithDataToggle() {
        assessmentWithDataToggle = properties.getProperty("ASSESSMENT_WITH_DATA_TOGGLE");
        return assessmentWithDataToggle;
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
        allAssessmentsLink = properties.getProperty("ALL_ASSESSMENT_LINK");
        return allAssessmentsLink;
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
        //Changed to Draft Item Bank as shown in site
        //unpublishedItemBankLink = "//a[text()[normalize-space() = 'Unpublished Item Bank']]";
        unpublishedItemBankLink = properties.getProperty("UNPUBLISHED_ITEMBANK_LINK");
        return unpublishedItemBankLink;
    }

    //XPath
    public String getViewAssessments_SharedwithMeLink() {
        unpublishedItemBankLink = properties.getProperty("SHARED_WITH_ME_LINK");
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

    //XPath
    public String getFirstLinkAfterSearch() {
        firstLinkAfterSearch = properties.getProperty("FIRST_LINK_AFTER_SEARCH");
        return firstLinkAfterSearch;
    }

    //XPath
    public String getFirstLinkOwnerNameAfterSearch() {
        firstLinkOwnerNameAfterSearch = properties.getProperty("FIRST_LINK_OWNER_NAME_AFTER_SEARCH");
        return firstLinkOwnerNameAfterSearch;
    }

    //XPath
    public String getViewAssessmentsTable_DateCreated() {
        dateCreated = properties.getProperty("DATE_CREATED");
        return dateCreated;
    }

    //XPath
    public String getViewAssessmentsTable_TitleHeader() {
        dateCreated = properties.getProperty("VIEW_ASSESSMENT_TABLE_TITLE_HEADER");
        return dateCreated;
    }

    //XPath
    public String getFirstLinkDateCreatedAfterSearch() {
        firstLinkDateCreatedAfterSearch = properties.getProperty("FIRST_LINK_DATE_CREATED_AFTER_SEARCH");
        return firstLinkDateCreatedAfterSearch;
    }

    //XPath
    public String getFirstLinkTypeAfterSearch() {
        firstLinkTypeAfterSearch = properties.getProperty("FIRST_LINK_TYPE_AFTER_SEARCH");
        return firstLinkTypeAfterSearch;
    }

    //XPath
    public String getLegacyItemBankTitle() {
        legacyItemBankTitle = properties.getProperty("LEGACY_ITEMBANK_TITLE");
        return legacyItemBankTitle;
    }

    //XPath
    public String getFirstRowActionButton() {
        firstRowActionButton = properties.getProperty("ACTION_BUTTON_FOR_THE_FIRST_LINK");
        return firstRowActionButton;
    }

    //XPath
    public String getFirstRowDeleteLink() {
        firstRowDeleteLink = properties.getProperty("FIRST_ROW_DELETE_LINK");
        return firstRowDeleteLink;
    }

    //XPath
    //Yes, I am sure that the assessment is the one I want to delete
    public String getDelete_Confirm() {
        delete_Confirm = properties.getProperty("DELETE_UNDERSTAND_CHECKBOX");
        return delete_Confirm;
    }

    //XPath
    //Yes, Delete the assessment
    public String getDelete_Agree() {
        delete_Agree = properties.getProperty("GET_DELETE_AGREE_CHECKBOX");
        return delete_Agree;
    }

    //XPath
    public String getFinalDeleteAssessmentButton() {
        finalDeleteAssessmentButton = properties.getProperty("FINAL_DELETE_ASSESSMENT_BUTTON");
        return finalDeleteAssessmentButton;
    }

    //XPath
    public String getUndoLinkAfterDelete() {
        undoLinkAfterDelete = properties.getProperty("UNDO_LINK_AFTER_DELETE");
        return undoLinkAfterDelete;
    }

    //XPath
    public String getFirstRowInput() {
        firstRowInput = properties.getProperty("FIRST_ROW_INPUT");
        return firstRowInput;
    }

    //XPath
    public String getTrash_SubmitButton() {
        trash_SubmitButton = properties.getProperty("SUBMIT_BUTTON");
        return trash_SubmitButton;
    }

    //XPath
    //Yes, I understand that this CAN NOT be undone.
    public String getNo_Undo() {
        no_Undo = properties.getProperty("UNDERSTAND_NO_UNDO");
        return no_Undo;
    }

    //XPath
    public String getRestoreAssessmentButton() {
        restoreAssessmentButton = properties.getProperty("RESTORE_ASSESSMENT_BUTTON");
        return restoreAssessmentButton;
    }

    //XPath
    public String getRestoreMessage() {
        restoreMessage = properties.getProperty("RESTORE_MESSAGE");
        return restoreMessage;
    }

    //XPath
    public String getClearAllInViewAssessments() {
        clearAllInViewAssessments = properties.getProperty("CLEAR_ALL_IN_VIEW_ASSESSMENTS");
        return clearAllInViewAssessments;
    }

    //XPath
    public String getPopup() {
        popup = properties.getProperty("POPUP");
        return popup;
    }

    public String getFirstRowCurrentDataGreen() {
        firstRowCurrentDataGreen = properties.getProperty("FIRST_ROW_CURRENT_DATA_GREEN");
        return firstRowCurrentDataGreen;
    }

    public String getFirstRowCurrentDataGrey() {
        firstRowCurrentDataGrey = properties.getProperty("FIRST_ROW_CURRENT_DATA_GREY");
        return firstRowCurrentDataGrey;
    }

    public String getNoDataAvailableInTable() {
        noDataAvailableInTable = properties.getProperty("NO_DATA_AVAILABLE_IN_TABLE");
        return noDataAvailableInTable;
    }

    public String getFirstRowTypeForFlexible() {
        firstRowTypeForFlexible = properties.getProperty("FIRST_ROW_TYPE_FOR_FLEXIBLE");
        return firstRowTypeForFlexible;
    }

    public String getFirstRowTypeColumn() {
        firstRowTypeColumn = properties.getProperty("FIRST_ROW_TYPE_COLUMN");
        return firstRowTypeColumn;
    }

    public String getFirstRow() {
        firstRow = properties.getProperty("FIRST_ROW");
        return firstRow;
    }

    public String getFirstIDafterSearch() {
        firstIDafterSearch = properties.getProperty("FIRST_ID_AFTER_SEARCH");
        return firstIDafterSearch;
    }

    public String getTypeTitle() {
        typeTitle = properties.getProperty("TYPE_TITLE");
        return typeTitle;
    }

    public String getOwnerTitle() {
        ownerTitle = properties.getProperty("OWNER_TITLE");
        return ownerTitle;
    }

    public String getCheckHorizontalLineWhenToggleOFF() {
        checkHorizontalLineWhenToggleOFF = properties.getProperty("CHECK_HORIZONTAL_LINE_WHEN_TOGGLE_OFF");
        return checkHorizontalLineWhenToggleOFF;
    }

    public String getTableList() {
        tableList = properties.getProperty("TABLE_LIST");
        return tableList;
    }

    public String getLastAccessedTitle() {
        lastAccessedTitle = properties.getProperty("LAST_ACCESSED_TITLE");
        return lastAccessedTitle;
    }

    public String getCurrentDataTitle() {
        currentDataTitle = properties.getProperty("CURRENT_DATA_TITLE");
        return currentDataTitle;
    }

    public String getUserFavoriteFlexible() {
        userFavoriteFlexible = properties.getProperty("USER_FAVORITE_FLEXIBLE");
        return userFavoriteFlexible;
    }


}