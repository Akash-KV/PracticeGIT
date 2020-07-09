package Pom;

import Helpers.BrowserInitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Page Object Model class for ViewAssessmentsPage
 **/

public class ViewAssessmentsPage {
    private String createButton, popup;
    private String createButtonDropdownAssessmentView, dataTableEmpty, firstLinkTypeAfterSearch, dateCreated, firstLinkDateCreatedAfterSearch;
    private String viewAssessmentsHeader, addFilterButton, filterButtonAfterSearch, firstLinkAfterSearch, firstLinkOwnerNameAfterSearch;
    private String dateCreatedMessage, addFilterAfterReset, searchTextBox, searchButtonInViewAssessments, clearAllInViewAssessments;
    private String allAssessmentsLink, checkTableEmptyRowcount, myAssessmentsLink, createdByMeLink, favoritesLink, viewAssessmentsDataGreyCircle, unpublishedItemBankLink, shared_withMeLink, trashLink;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_Filters", "");
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
     * Methods to read Locators from Property file
     **/

    public String getCreateButton() {
        createButton = properties.getProperty("CREATE_BUTTON");
        return createButton;
    }

    public String getCreateButtonDropdownAssessmentView() {
        createButtonDropdownAssessmentView = properties.getProperty("CREATE_BUTTON_DROPDOWN_ASSESSMENTS_VIEW");
        return createButtonDropdownAssessmentView;
    }

    public String getViewAssessmentsHeader() {
        viewAssessmentsHeader = properties.getProperty("VIEW_ASSESSMENTS_HEADER");
        return viewAssessmentsHeader;
    }

    public String getAddFilterButton() {
        addFilterButton = properties.getProperty("ADD_FILTERS");
        return addFilterButton;
    }

    public String getFilterButtonAfterSearch() {
        filterButtonAfterSearch = properties.getProperty("FILTER_BUTTON_AFTER_SEARCH");
        return filterButtonAfterSearch;
    }

    public String getFirstLinkAfterSearch() {
        firstLinkAfterSearch = properties.getProperty("FIRST_LINK_AFTER_SEARCH");
        return firstLinkAfterSearch;
    }

    public String getFirstLinkOwnerNameAfterSearch() {
        firstLinkOwnerNameAfterSearch = properties.getProperty("FIRST_LINK_OWNER_NAME_AFTER_SEARCH");
        return firstLinkOwnerNameAfterSearch;
    }

    public String getFirstLinkTypeAfterSearch() {
        firstLinkTypeAfterSearch = properties.getProperty("FIRST_LINK_TYPE_AFTER_SEARCH");
        return firstLinkTypeAfterSearch;
    }

    public String getDataTableEmpty() {
        dataTableEmpty = properties.getProperty("DATA_TABLE_EMPTY");
        return dataTableEmpty;
    }

    public String getDateCreatedMessage() {
        dateCreatedMessage = properties.getProperty("DATE_CREATED_MSG");
        return dateCreatedMessage;
    }

    public String getDateCreated() {
        dateCreated = properties.getProperty("DATE_CREATED");
        return dateCreated;
    }

    public String getFirstLinkDateCreatedAfterSearch() {
        firstLinkDateCreatedAfterSearch = properties.getProperty("FIRST_LINK_DATE_CREATED_AFTER_SEARCH");
        return firstLinkDateCreatedAfterSearch;
    }

    public String getAddFilterAfterReset() {

        addFilterAfterReset = properties.getProperty("ADD_FILTER_AFTER_RESET");
        return addFilterAfterReset;
    }

    public String getSearchTextBox() {
        searchTextBox = properties.getProperty("SEARCH_ASSESSMENTSBAR");
        return searchTextBox;
    }

    public String getSearchButtonInViewAssessments() {
        searchButtonInViewAssessments = properties.getProperty("SEARCH_BUTTON_IN_VIEW_ASSESSMENTS");
        return searchButtonInViewAssessments;
    }

    public String getClearAllInViewAssessments() {
        clearAllInViewAssessments = properties.getProperty("CLEAR_ALL_IN_VIEW_ASSESSMENTS");
        return clearAllInViewAssessments;
    }

    public String getAllAssessmentsLink() {
        allAssessmentsLink = properties.getProperty("ALL_ASSESSMENTS_LINK");
        return allAssessmentsLink;
    }

    public String getMyAssessmentsLink() {
        myAssessmentsLink = properties.getProperty("MY_ASSESSMENTS_LINK");
        return myAssessmentsLink;
    }

    public String getCreatedByMeLink() {
        createdByMeLink = properties.getProperty("CREATED_BY_ME_LINK");
        return createdByMeLink;
    }

    public String getFavoritesLink() {
        favoritesLink = properties.getProperty("FAVORITES_LINK");
        return favoritesLink;
    }

    public String getUnpublishedItemBankLink() {
        unpublishedItemBankLink = properties.getProperty("UNPUBLISHED_ITEMBANK_LINK");
        return unpublishedItemBankLink;
    }

    public String getSharedwithMeLink() {
        shared_withMeLink = properties.getProperty("SHARED_WITH_ME_LINK");
        return shared_withMeLink;
    }

    public String getTrashLink() {
        trashLink = properties.getProperty("TRASH_LINK");
        return trashLink;
    }

    public String getPopup() {
        popup = properties.getProperty("POPUP");
        return popup;
    }

    public String getViewAssessmentsDataGreyCircle() {
        viewAssessmentsDataGreyCircle = properties.getProperty("VIEW_ASSESSMENTS_GREY_DATA_CIRCLE");
        return viewAssessmentsDataGreyCircle;
    }

    public String getCheckTableEmptyRowcount() {
        checkTableEmptyRowcount = properties.getProperty("CHECK_TABLE_EMPTY_ROWCOUNT");
        return checkTableEmptyRowcount;
    }
}
