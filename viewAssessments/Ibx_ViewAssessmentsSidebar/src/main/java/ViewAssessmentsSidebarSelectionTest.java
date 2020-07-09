import Controllers.ViewAssessmentsController;
import DataReaders.CSVDataReaderViewAssessmentsSidebar;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.ResultsPage;
import Pom.ViewAssessments;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static Helpers.JavascriptHelper.clickXpath_JS;
import static Helpers.JavascriptHelper.waitUntilAjaxLoaded;

@GraphWalker(value = "quick_random(edge_coverage(100))")
//Test Class for ViewAssessmentsSidebarSelectionTest
public class ViewAssessmentsSidebarSelectionTest extends ExecutionContext implements ViewAssessmentsSidebarSelection {

    //Declarations
    ViewAssessments viewAssessmentsPage = new ViewAssessments();
    DriverHelper Helper = new DriverHelper();
    CSVDataReaderViewAssessmentsSidebar csvDataReaderViewAssessmentsSidebar = new CSVDataReaderViewAssessmentsSidebar();
    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();
    ResultsPage resultsPage = new ResultsPage();

    boolean verifyAllAssessments = false;
    boolean verifyMyAssessments = false;
    boolean verifyCreatedByMe = false;
    boolean verifyFavorites = false;
    boolean verifyUnpublishedItemBank = false;
    boolean verifyTrash = false;
    boolean verifyDistrictIconFavorite = false;
    boolean verifyChangeAuthor = false;
    String firstLink;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(ViewAssessmentsSidebarSelectionTest.class);

    public void v_VerifyViewAssessmentsSidebar() {

    }

    public void e_ClickAllAssessments() {
        //Click All Assessments Link
        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_AllAssessmentsLink());
        waitUntilAjaxLoaded();

        //Condition 1 - Clear if any text is already present in search text box
        waitUntilAjaxLoaded();
        BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getSearchTextBox())).clear();

        //Click Search
        clickXpath_JS(viewAssessmentsPage.getSearchButtonInViewAssessments());
        waitUntilAjaxLoaded();

        //Condition 2 - Click on clear all link for filter, if any filter is already added
             DriverHelper.waitTill(2);
//            DriverHelper.clickXpath(viewAssessmentsPage.getClearAllInViewAssessments());
            DriverHelper.waitTill(2);
            waitUntilAjaxLoaded();
           }

    public void v_AllAssessments() {
        //Verify Assessment Created by logged in User AND Other users
        //First Search Assessment created by logged in user
        viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getCreatedBy());

        boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
        //if table is empty
        if (checkEmptyTable) {
            verifyAllAssessments = true;
        } else {
            waitUntilAjaxLoaded();

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch())));
            WebElement getFirstLinkAfterSearch = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch()));
            if (getFirstLinkAfterSearch.isDisplayed()) {
                //Get Owner of First Link
                String OwnerOfAssessment = DriverHelper.getText(viewAssessmentsPage.getFirstLinkOwnerNameAfterSearch());

                boolean check_Me = viewAssessmentsController.CheckAssertion(csvDataReaderViewAssessmentsSidebar.getCreatedBy(), OwnerOfAssessment);
                if (check_Me) {
                    verifyAllAssessments = true;
                    logger.info("Created By is Verified for -->" + OwnerOfAssessment);
                } else {
                    verifyAllAssessments = false;
                }
            }
        }


        //Second - Search Assessment created by Other Users
        viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getCreatedByOthers());

        boolean checkEmptyTable_OtherUsers = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
        //if table is empty
        if (checkEmptyTable_OtherUsers) {
            verifyAllAssessments = true;
        } else {
            waitUntilAjaxLoaded();

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch())));
            WebElement getFirstLinkAfterSearch = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch()));
            if (getFirstLinkAfterSearch.isDisplayed()) {
                //Get Owner of First Link
                String OwnerOfAssessment = DriverHelper.getText(viewAssessmentsPage.getFirstLinkOwnerNameAfterSearch());

                boolean check_OtherUser = viewAssessmentsController.CheckAssertion(csvDataReaderViewAssessmentsSidebar.getCreatedByOthers(), OwnerOfAssessment);
                if (check_OtherUser) {
                    verifyAllAssessments = true;
                    logger.info("Created By Others is Verified for -->" + OwnerOfAssessment);
                } else {
                    verifyAllAssessments = false;
                }
            }
        }
    }

    public void e_ClickMyAssessments() {
        //Click My Assessments Link
        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_MyAssessmentsLink());
        waitUntilAjaxLoaded();
    }

    public void v_MyAssessments() {
        boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
        //if table is empty
        if (checkEmptyTable) {
            verifyMyAssessments = true;
        } else {
            waitUntilAjaxLoaded();

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch())));
            WebElement getFirstLinkAfterSearch = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch()));
            if (getFirstLinkAfterSearch.isDisplayed()) {
                //Get Owner of First Link
                String OwnerOfAssessment = DriverHelper.getText(viewAssessmentsPage.getFirstLinkOwnerNameAfterSearch());

                boolean check_Me = viewAssessmentsController.CheckAssertion(csvDataReaderViewAssessmentsSidebar.getCreatedBy(), OwnerOfAssessment);
                if (check_Me) {
                    verifyMyAssessments = true;
                    logger.info("My Assessments is Verified for -->" + OwnerOfAssessment);
                }
            }
        }
    }

    public void e_ClickCreatedByMe() {
        //Click Created By Me Link
        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_CreatedByMeLink());
        waitUntilAjaxLoaded();
    }

    public void v_CreatedByMe() {
        boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
        //if table is empty
        if (checkEmptyTable) {
            verifyCreatedByMe = true;
        } else {
            waitUntilAjaxLoaded();

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch())));
            WebElement getFirstLinkAfterSearch = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch()));
            if (getFirstLinkAfterSearch.isDisplayed()) {
                //Get Owner of First Link
                String OwnerOfAssessment = DriverHelper.getText(viewAssessmentsPage.getFirstLinkOwnerNameAfterSearch());

                boolean check_Me = viewAssessmentsController.CheckAssertion(csvDataReaderViewAssessmentsSidebar.getCreatedBy(), OwnerOfAssessment);
                if (check_Me) {
                    verifyCreatedByMe = true;
                    logger.info("Created By Me is Verified for -->" + OwnerOfAssessment);
                }
            }
        }
    }

    public void e_ClickFavorites() {
        //Click Favorites Link
        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_FavoritesLink());
        waitUntilAjaxLoaded();
    }

    public void v_Favorites() {
        boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
        //if table is empty
        if (checkEmptyTable) {
            verifyFavorites = true;
        } else {
            waitUntilAjaxLoaded();

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch())));
            WebElement getFirstLinkAfterSearch = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch()));
            if (getFirstLinkAfterSearch.isDisplayed()) {
                //Click First Link in View Assessments Table
                clickXpath_JS(viewAssessmentsPage.getFirstLinkAfterSearch());

                //Check if district status OR user status of Favorite
                boolean UserStatus = viewAssessmentsController.checkFavoriteinOverview(resultsPage.getUserFavorite());
                boolean DistrictStatus = viewAssessmentsController.checkFavoriteinOverview(resultsPage.getDistrictFavorite());
                boolean CheckFavoriteForFlexible = viewAssessmentsController.checkFavoriteinOverview_Flexible(resultsPage.getUserFavoriteFlexible());

                System.out.println("UserStatus -->" + UserStatus);
                System.out.println("DistrictStatus -->" + DistrictStatus);
                System.out.println("FlexibleStatus -->" + CheckFavoriteForFlexible);

                if (CheckFavoriteForFlexible || UserStatus || DistrictStatus) {
                    verifyFavorites = true;
                }

                //Click Back button in Browser to navigate to View Assessments Page
                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();
            }
        }
    }

    public void e_ClickUnpublishedItemBank() {
        //Click Favorites Link
        DriverHelper.waitTill(2);
        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_UnpublishedItemBankLink());
        waitUntilAjaxLoaded();
    }

    public void v_UnpublishedItemBank() {
        boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());

        if (checkEmptyTable) {
            verifyUnpublishedItemBank = true;
        } else {
            try {
                waitUntilAjaxLoaded();

                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch())));
                WebElement getFirstLinkAfterSearch = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch()));
                if (getFirstLinkAfterSearch.isDisplayed()) {
                    //Click First Link in View Assessments Table
                    String FirstLinkType = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getFirstLinkTypeAfterSearch())).getText();

                    //Check Type = Item Bank
                    if (FirstLinkType.equalsIgnoreCase("Item Bank")) {
                        //Click First Link in View Assessments Table
                        clickXpath_JS(viewAssessmentsPage.getFirstLinkAfterSearch());
                        //waitUntilAjaxLoaded();

                        //Verify for display of Legacy Itembank  - Step 1 Provide Basic Information
                        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getLegacyItemBankTitle())));
                        boolean LegacyItemBankTitle = viewAssessmentsController.checkLegacyItemBankTitle(viewAssessmentsPage.getLegacyItemBankTitle());

                        if (LegacyItemBankTitle) {
                            verifyUnpublishedItemBank = true;
                        }

                        String CurrentURL = BrowserInitHelper.getInstance().getCurrentUrl();

                        //Click Back button in Browser to navigate to View Assessments Page
                        if (CurrentURL.contains("#")) {
                            //Click Back button Twice
                            BrowserInitHelper.getInstance().navigate().back();
                            BrowserInitHelper.getInstance().navigate().back();
                            waitUntilAjaxLoaded();
                        } else {
                            BrowserInitHelper.getInstance().navigate().back();
                            waitUntilAjaxLoaded();
                        }
                    } else if (FirstLinkType.equalsIgnoreCase("Item Bank (New)")) {
                        //Click First Link in View Assessments Table
                        clickXpath_JS(viewAssessmentsPage.getFirstLinkAfterSearch());
                        //waitUntilAjaxLoaded();

                        //Verify for display of New Item bank  - Build page
                        System.out.println("Before item content....");
                        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getBuildItemContent())));
                        boolean buildPageItemContent = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getBuildItemContent())).isDisplayed();
                        System.out.println("After item content....");

                        if (buildPageItemContent) {
                            verifyUnpublishedItemBank = true;
                        }

                        String CurrentURL = BrowserInitHelper.getInstance().getCurrentUrl();

                        //Click Back button in Browser to navigate to View Assessments Page
                        if (CurrentURL.contains("#")) {
                            //Click Back button Twice
                            BrowserInitHelper.getInstance().navigate().back();
                            BrowserInitHelper.getInstance().navigate().back();
                            waitUntilAjaxLoaded();
                        } else {
                            BrowserInitHelper.getInstance().navigate().back();
                            waitUntilAjaxLoaded();
                        }
                    }
                }
            } catch (TimeoutException e) {
                System.out.println("TimeOutException handled...." + e);
                ConsoleLogger.FailedTestCase("Basic Information title is not shown on click of item bank inside draft item bank....");

                String CurrentURL = BrowserInitHelper.getInstance().getCurrentUrl();

                //Click Back button in Browser to navigate to View Assessments Page
                if (CurrentURL.contains("#")) {
                    //Click Back button Twice
                    BrowserInitHelper.getInstance().navigate().back();
                    BrowserInitHelper.getInstance().navigate().back();
                    waitUntilAjaxLoaded();
                } else {
                    BrowserInitHelper.getInstance().navigate().back();
                    waitUntilAjaxLoaded();
                }
            }
        }
    }

    public void e_ClickTrash() {

    }

    public void v_Trash() {
        //Click - Created By Me and Search assessment to Delete
        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_CreatedByMeLink());
        waitUntilAjaxLoaded();

        viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getAssessmentToDeleteANDRestore());

        boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
        //for empty table
        if (checkEmptyTable) {
            verifyUnpublishedItemBank = true;
        } else {
            waitUntilAjaxLoaded();

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch())));
            WebElement getFirstLinkAfterSearch = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch()));

            try {
                if (getFirstLinkAfterSearch.isDisplayed()) {
                    // Delete Assessment from Created By Me
//                    BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewAssessmentsPage.getFirstRowActionButton())));
                    Helper.clickXpath(viewAssessmentsPage.getFirstRowActionButton());
                    Helper.clickXpath(viewAssessmentsPage.getFirstRowDeleteLink());

                    Helper.clickXpath(viewAssessmentsPage.getDelete_Confirm());
                    Helper.clickXpath(viewAssessmentsPage.getDelete_Agree());

                    Helper.clickXpath(viewAssessmentsPage.getFinalDeleteAssessmentButton());
                    waitUntilAjaxLoaded();

                    //Check for Undo Link
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getUndoLinkAfterDelete())));

                    //Now click on Trash - Link
                    Helper.clickXpath(viewAssessmentsPage.getViewAssessments_TrashLink());
                    waitUntilAjaxLoaded();

                    // Search deleted assessment and Restore
                    viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getAssessmentToDeleteANDRestore());
                    waitUntilAjaxLoaded();

                    //Select assessment and Restore
                    Helper.clickXpath(viewAssessmentsPage.getFirstRowInput());
                    Helper.clickXpath("//td[.='"+csvDataReaderViewAssessmentsSidebar.getAssessmentToDeleteANDRestore()+"']/preceding::td[1]/input[1]");
                    Helper.clickXpath("//td[contains(.,'" + csvDataReaderViewAssessmentsSidebar.getAssessmentToDeleteANDRestore() + "')]/preceding::td[1]/input[1]");

                    Select SelectionDropDown = new Select(BrowserInitHelper.getInstance().findElement(By.name("update[action]")));
                    SelectionDropDown.selectByVisibleText("Restore");

                    //DriverHelper.clickXpath(viewAssessmentsPage.getFirstRowActionButton());
                    //JavascriptHelper.click_Xpath(viewAssessmentsPage.getClickOnRestore());
                    //ConsoleLogger.SuccessLog("Clicked Restore Button");
                    Helper.clickXpath(viewAssessmentsPage.getTrash_SubmitButton());
                    waitUntilAjaxLoaded();

                    Helper.clickXpath(viewAssessmentsPage.getDelete_Agree());
                    Helper.clickXpath(viewAssessmentsPage.getNo_Undo());

                    Helper.clickXpath(viewAssessmentsPage.getRestoreAssessmentButton());
                    waitUntilAjaxLoaded();

                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getRestoreMessage())));

                    //Verify assessment in Created By Me
                    Helper.clickXpath(viewAssessmentsPage.getViewAssessments_CreatedByMeLink());
                    waitUntilAjaxLoaded();

                    //Search restored assessment in Created By Me
                    viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getAssessmentToDeleteANDRestore());

                    if (checkEmptyTable) {
                        verifyTrash = false;
                    } else {
                        waitUntilAjaxLoaded();

                        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch())));
                        WebElement check_FirstLinkAfterSearch = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getFirstLinkAfterSearch()));

                        if (check_FirstLinkAfterSearch.isDisplayed()) {
                            if (check_FirstLinkAfterSearch.getText().trim().equalsIgnoreCase(csvDataReaderViewAssessmentsSidebar.getAssessmentToDeleteANDRestore())) {
                                //Deleted assessment is restored and displayed
                                verifyTrash = true;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception handled for method - v_Trash...."+e);
            }
        }
    }

    public void e_AddMyFavorite() {
        //Search Flexible assessment and click My Favorite
        //Click all assessments
        BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getViewAssessments_AllAssessmentsLink())).click();
        waitUntilAjaxLoaded();

        viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite());

        boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
        if (checkEmptyTable) {
            logger.info("No data avaliable is shown......");
        } else {
            waitUntilAjaxLoaded();

            //Click link and click My Favorite
            BrowserInitHelper.getInstance().findElement(By.linkText(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite())).click();
            waitUntilAjaxLoaded();

            //If My favorite is clicked or not
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getUserFavoriteFlexible())));
            WebElement getUserFavorite = BrowserInitHelper.getInstance().findElement(By.xpath(resultsPage.getUserFavoriteFlexible()));
            String UserFavorite = getUserFavorite.getAttribute("class");
            if (UserFavorite.contains("inactive")) {
                //Click
                getUserFavorite.click();
            } else {
                logger.info("UserFavorite icon is already clicked.....");
            }
        }

        //Click Back button in Browser to navigate to View Assessments Page
        BrowserInitHelper.getInstance().navigate().back();
        waitUntilAjaxLoaded();
    }

    public void v_CheckMyFavorite() {
        //Search in all assessments to Verify assessment name
        //Click on Favorites
        BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getViewAssessments_FavoritesLink())).click();
        waitUntilAjaxLoaded();

        //Search assessment
        viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite());
        boolean checkFavorite = false;

        boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());

        if (checkEmptyTable) {
            checkFavorite = false;
        } else {
            waitUntilAjaxLoaded();
            WebElement FavoriteAssessment = BrowserInitHelper.getInstance().findElement(By.linkText(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite()));
            if (FavoriteAssessment.isDisplayed()) {
                checkFavorite = true;
            }
        }
        //Assert.assertTrue(checkFavorite);

        //Now Remove Favorites after search
        //Click link
        WebElement FavoriteAssessment = BrowserInitHelper.getInstance().findElement(By.linkText(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite()));
        FavoriteAssessment.click();
        DriverHelper.waitTill(4);

        //Now un-select Favorite icon
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getUserFavoriteFlexible())));
        WebElement getUserFavorite = BrowserInitHelper.getInstance().findElement(By.xpath(resultsPage.getUserFavoriteFlexible()));
        String UserFavorite = getUserFavorite.getAttribute("class");
        if (UserFavorite.contains("active")) {
            //Click
            getUserFavorite.click();
           DriverHelper.waitTill(4);
        } else {
            logger.info("UserFavorite icon is already un-selected.....");
        }

        //Now search in Favorites to verify
        //Click Back button in Browser to navigate to View Assessments Page
        BrowserInitHelper.getInstance().navigate().back();
        waitUntilAjaxLoaded();

        viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite());
        boolean checkUnFlagFavorite = false;

        boolean checkEmptyTablewhenUnflag = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
        if (checkEmptyTablewhenUnflag) {
            checkUnFlagFavorite = true;
        } else {
            waitUntilAjaxLoaded();
            try {
                WebElement FavoriteAssessmentwhenUnflag = BrowserInitHelper.getInstance().findElement(By.linkText(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite()));
                if (FavoriteAssessmentwhenUnflag.isDisplayed()) {
                    checkUnFlagFavorite = false;
                }
            } catch (NoSuchElementException ne) {
                checkUnFlagFavorite = true;
            } catch (Exception e) {
                checkUnFlagFavorite = true;
            }
        }
        //Assert.assertTrue(checkUnFlagFavorite);
    }


    public void e_AddDistrictFavorite() {
        //Search Flexible assessment and click My Favorite
        //Click all assessments
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getViewAssessments_AllAssessmentsLink())));
        BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getViewAssessments_AllAssessmentsLink())).click();
        waitUntilAjaxLoaded();

        viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite());

        boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
        //for empty table
        if (checkEmptyTable) {
            logger.info("No data avaliable is shown......");
        } else {
            waitUntilAjaxLoaded();

            //Click link and click My Favorite
            BrowserInitHelper.getInstance().findElement(By.linkText(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite())).click();
            waitUntilAjaxLoaded();
            try {
                //If District favorite is clicked or not
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getDistrictFavoriteFlexible())));
                WebElement getDistrictFavorite = BrowserInitHelper.getInstance().findElement(By.xpath(resultsPage.getDistrictFavoriteFlexible()));
                String DistrictUserFavorite = getDistrictFavorite.getAttribute("class");
                if (DistrictUserFavorite.contains("inactive")) {
                    //Click
                    getDistrictFavorite.click();
                    verifyDistrictIconFavorite = true;
                } else {
                    logger.info("District Favorite icon is already clicked.....");
                    verifyDistrictIconFavorite = true;
                }
            } catch (NoSuchElementException ne) {
                //If district favorite icon is nor visible
                verifyDistrictIconFavorite = false;
            } catch (Exception e) {
                //If district favorite icon is nor visible
                verifyDistrictIconFavorite = false;
            }
        }

        //Click Back button in Browser to navigate to View Assessments Page
        BrowserInitHelper.getInstance().navigate().back();
        waitUntilAjaxLoaded();
    }

    public void v_CheckDistrictFavorite() {
        try {
            if (verifyDistrictIconFavorite) {
                //Search in all assessments to Verify assessment name
                //Click on Favorites
                BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getViewAssessments_FavoritesLink())).click();
                waitUntilAjaxLoaded();

                //Search assessment
                viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite());
                boolean checkFavorite = false;

                boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
                if (checkEmptyTable) {
                    checkFavorite = false;
                } else {
                    waitUntilAjaxLoaded();
                    WebElement FavoriteAssessment = BrowserInitHelper.getInstance().findElement(By.linkText(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite()));
                    if (FavoriteAssessment.isDisplayed()) {
                        checkFavorite = true;
                    }
                }
                //Assert.assertTrue(checkFavorite);

                //Now Remove Favorites after search
                //Click link
                WebElement FavoriteAssessment = BrowserInitHelper.getInstance().findElement(By.linkText(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite()));
                FavoriteAssessment.click();
                DriverHelper.waitTill(4);

                //Now un-select Favorite icon
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getDistrictFavoriteFlexible())));
                WebElement getDistrictFavorite = BrowserInitHelper.getInstance().findElement(By.xpath(resultsPage.getDistrictFavoriteFlexible()));
                String DistrictFavorite = getDistrictFavorite.getAttribute("class");
                if (DistrictFavorite.contains("active")) {
                    //Click
                    getDistrictFavorite.click();
                    DriverHelper.waitTill(4);
                } else {
                    logger.info("District Favorite icon is already un-selected.....");
                }

                //Now search in Favorites to verify
                //Click Back button in Browser to navigate to View Assessments Page
                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();

                viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite());
                boolean checkUnFlagFavorite = false;

                boolean checkEmptyTablewhenUnflag = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
                if (checkEmptyTablewhenUnflag) {
                    checkUnFlagFavorite = true;
                } else {
                    waitUntilAjaxLoaded();
                    try {
                        WebElement FavoriteAssessmentwhenUnflag = BrowserInitHelper.getInstance().findElement(By.linkText(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoCheckFavorite()));
                        if (FavoriteAssessmentwhenUnflag.isDisplayed()) {
                            checkUnFlagFavorite = false;
                        }
                    } catch (NoSuchElementException ne) {
                        checkUnFlagFavorite = true;
                    } catch (Exception e) {
                        checkUnFlagFavorite = true;
                    }
                }
                //Assert.assertTrue(checkUnFlagFavorite);
            } else {
                logger.info("District Favorite icon is not displayed......");
            }
        } catch (Exception e) {
            System.out.println("Exception handled for v_CheckDistrictFavorite...");
            ConsoleLogger.FailedTestCase("Exception in v_CheckDistrictFavorite method...." + e);
        }

        //Click Back button in Browser to navigate to View Assessments Page
        //BrowserInitHelper.getInstance().navigate().back();
        //waitUntilAjaxLoaded();
    }

    public void e_Publish() {
        //<< On hold , Step 6(Publish) not showing in QA Site for unpublished item bank assessments >>

    }

    public void v_CheckUnpublishedItemBankAssessments() {
        //<< On hold , Step 6(Publish) not showing in QA Site for unpublished item bank assessments >>

    }

    public void e_ChangeAuthor() {
        //Commented due to change author works only once because once author is changed, again assessment will not be visible for next test run

//        //Search Flexible assessment in Created By Me
//        BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getViewAssessments_CreatedByMeLink())).click();
//        waitUntilAjaxLoaded();
//
//        viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoChangeAuthor());
//        boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
//        if (checkEmptyTable) {
//            logger.info("Flexible assessment Not displayed......");
//            verifyChangeAuthor = false;
//        } else {
//            waitUntilAjaxLoaded();
//
//            //Click Link
//            BrowserInitHelper.getInstance().findElement(By.linkText(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoChangeAuthor())).click();
//            waitUntilAjaxLoaded();
//
//            //Change Author
//            Boolean ChangeAuthor = viewAssessmentsController.ChangeAuthorforFlexible(csvDataReaderViewAssessmentsSidebar.getNewAuthorName());
//            //Assert.assertTrue(ChangeAuthor);
//            verifyChangeAuthor = true;
//        }
    }

    public void v_CheckCreatedByMeAssessments() {
        //Commented due to change author works only once because once author is changed, again assessment will not be visible for next test run

//        if (verifyChangeAuthor) {
//            //Now search assessment for which author was changed in Created By Me
//            BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getViewAssessments_CreatedByMeLink())).click();
//            waitUntilAjaxLoaded();
//
//            viewAssessmentsController.VerifyViewAssessmentSearch(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoChangeAuthor());
//            boolean checkEmptyTable = viewAssessmentsController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
//            if (checkEmptyTable) {
//                logger.info("Flexible assessment Not displayed after change of author......");
//                ConsoleLogger.SuccessLog("{Test Case passed - Flexible Assessment not shown after changing author.......}");
//            } else {
//                waitUntilAjaxLoaded();
//
//                try {
//                    WebElement FlexibleAssessment = BrowserInitHelper.getInstance().findElement(By.linkText(csvDataReaderViewAssessmentsSidebar.getFlexibleAssessmenttoChangeAuthor()));
//                    if (FlexibleAssessment.isDisplayed()) {
//                        ConsoleLogger.FailedTestCase("Flexible assessment is shown even after change of author......!!!");
//                    }
//                } catch (NoSuchElementException e) {
//                    ConsoleLogger.SuccessLog("Flexible assessment is NOT shown after change of author......!!!");
//                } catch (Exception e) {
//                    ConsoleLogger.SuccessLog("Flexible assessment is NOT shown after change of author......!!!");
//                }
//            }
//        } else {
//            logger.info("verifyChangeAuthor is false......");
//        }
    }
}
