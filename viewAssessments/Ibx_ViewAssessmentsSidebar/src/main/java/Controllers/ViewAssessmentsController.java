package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.ResultsPage;
import Pom.ViewAssessmentsPage;
import Utils.ConsoleLogger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static Helpers.JavascriptHelper.*;
import static Helpers.JavascriptHelper.waitUntilAjaxLoaded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**** Test Class for ViewAssessmentsController *****/
public class ViewAssessmentsController {

    DriverHelper Helper = new DriverHelper();
    ViewAssessmentsPage viewassessmentspage = new ViewAssessmentsPage();
    ResultsPage resultsPage = new ResultsPage();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    Dashboard dashboard = new Dashboard();
    /**
     * LoggerFactory
     */
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);


    public void navigateToViewAssessments() {
        DriverHelper.clickXpath(dashboard.getAssessmentsNav());
        DriverHelper.clickXpath(dashboard.getViewAssessmentsLink());

    }

    // To validate Viewassessments page
    public void verifyViewAssessments() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboard.getViewAssessmentsHeader())));
        boolean header = DriverHelper.checkElementDisplayByXpath(dashboard.getViewAssessmentsHeader(), "ViewAssessment");
        Assert.assertTrue(header);
    }

    //Click Search Button
    public void clickSearch() {

    }

    //Check Assertion for Text
    public boolean CheckAssertion(String Actual, String Expected) {
        boolean value = false;

        if (Expected.contains(Actual)) {
            value = true;
            log.info("Expected Text -->" + Expected);
            log.info("Actual Text -->" + Actual);
        }
        return value;
    }

    //Assertion for Created Date when sorted in Ascending Order
    public boolean AssertCreatedDate_AscendingOrder(String YearToCheck) {
        boolean value = false;

        //Check if class contains asc
        waitUntilAjaxLoaded();
        boolean checkEmptyTable = checkViewAssessments_EmptyTable(viewassessmentspage.getDataTableEmpty());
        if (checkEmptyTable) {
            value = true;
        } else {
            WebElement DateCreated = BrowserInitHelper.getInstance().findElement(By.xpath(viewassessmentspage.getDateCreated()));

            //Click Date Created
            DateCreated.click();
            waitUntilAjaxLoaded();

            //Wait until Date Created is clickable
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewassessmentspage.getFirstLinkDateCreatedAfterSearch())));
            WebElement DateCreatedAfterClick = BrowserInitHelper.getInstance().findElement(By.xpath(viewassessmentspage.getDateCreated()));
            String className = DateCreatedAfterClick.getAttribute("class");
            log.info("className - ascending order-->" + className);

            if (className.contains("sorting_asc")) {
                log.info("Already in Ascending Order..");

                //Assert Year to Check
                String CreatedDateFirstLink = Helper.getText(viewassessmentspage.getFirstLinkDateCreatedAfterSearch());
                log.info("Created Date - First Link -->" + CreatedDateFirstLink);
                boolean check = CheckAssertion(YearToCheck, CreatedDateFirstLink);
                if (check) {
                    value = true;
                }
            } else {
                //Click on Date Created
                DateCreated.click();
                waitUntilAjaxLoaded();

                //Wait until Date Created is clickable
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewassessmentspage.getFirstLinkDateCreatedAfterSearch())));

                //Assert Year to Check
                String CreatedDateFirstLink = Helper.getText(viewassessmentspage.getFirstLinkDateCreatedAfterSearch());
                boolean check = CheckAssertion(YearToCheck, CreatedDateFirstLink);
                if (check) {
                    value = true;
                }
            }
        }
        return value;
    }

    //Assertion for Created Date when sorted in Descending Order
    public boolean AssertCreatedDate_DescendingOrder(String YearToCheck) {
        boolean value = false;

        //Check if class contains desc
        waitUntilAjaxLoaded();
        boolean checkEmptyTable = checkViewAssessments_EmptyTable(viewassessmentspage.getDataTableEmpty());
        if (checkEmptyTable) {
            value = true;
        } else {
            WebElement DateCreated = BrowserInitHelper.getInstance().findElement(By.xpath(viewassessmentspage.getDateCreated()));

            //Click DateCreated
            DateCreated.click();
            waitUntilAjaxLoaded();

            //Wait until Date Created is clickable
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewassessmentspage.getFirstLinkDateCreatedAfterSearch())));

            WebElement DateCreatedAfterClick = BrowserInitHelper.getInstance().findElement(By.xpath(viewassessmentspage.getDateCreated()));
            String className = DateCreatedAfterClick.getAttribute("class");
            log.info("className - descending order -->" + className);

            if (className.contains("sorting_desc")) {
                log.info("Already in Descending Order...");

                //Assert Year to Check
                String CreatedDateFirstLink = Helper.getText(viewassessmentspage.getFirstLinkDateCreatedAfterSearch());
                log.info("Created Date - First Link..." + CreatedDateFirstLink);
                boolean check = CheckAssertion(YearToCheck, CreatedDateFirstLink);
                if (check) {
                    value = true;
                }
            } else {
                //Click on Date Created
                DateCreated.click();
                waitUntilAjaxLoaded();

                //Wait until Date Created is clickable
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewassessmentspage.getFirstLinkDateCreatedAfterSearch())));

                //Assert Year to Check
                String CreatedDateFirstLink = Helper.getText(viewassessmentspage.getFirstLinkDateCreatedAfterSearch());
                boolean check = CheckAssertion(YearToCheck, CreatedDateFirstLink);
                if (check) {
                    value = true;
                }
            }
        }
        return value;
    }

    //To get Grade Value for assertion, based on csv value of grade
    public String getGradeValue(String Grade) {
        String gradeValue = "";

        if (Grade.equalsIgnoreCase("Kindergarten")) {
            gradeValue = "K";
        }

        if (Grade.matches(".*\\d.*")) {
            gradeValue = Grade.replaceAll("[*a-zA-Z]", "");
            gradeValue = gradeValue.trim();
            log.info("Grade Value..." + gradeValue);
        }

        return gradeValue;
    }

    //To get Year Value from Date
    public String getYearfromDate(String DateValue) {
        String Year = "";
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(DateValue);

            System.out.println("date ---------->" + date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int year = calendar.get(Calendar.YEAR);
            Year = Integer.toString(year);
            log.info("YEAR VALUE ==>" + Year);
        } catch (ParseException e) {

        }
        return Year;
    }

    //To check if View Assessments Table is Empty OR Not
    public boolean checkViewAssessments_EmptyTable(String XPath) {
        boolean value = false;
        waitUntilAjaxLoaded();

        try {
            BrowserInitHelper.getInstance().findElement(By.xpath(XPath)).click();
            value = true;
        } catch (ElementNotInteractableException e) {
            log.info("ElementNotInteractableException handled for checkViewAssessments_EmptyTable...");
        } catch (NoSuchElementException e) {
            log.info("NoSuchElementException handled for checkViewAssessments_EmptyTable...");
        } catch (Exception e) {
            log.info("Exception handled for checkViewAssessments_EmptyTable...");
        }
        System.out.println("value: " + value);
        return value;
    }

    //To Verify Favorite icon in Overview page
    public boolean checkFavoriteinOverview(String Xpath) {
        boolean check = false;

        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
            WebElement FavoriteIcon = BrowserInitHelper.getInstance().findElement(By.xpath(Xpath));
            check = true;
        } catch (ElementNotInteractableException e) {
            log.info("ElementNotInteractableException handled for checkFavoriteinOverview...");
        } catch (NoSuchElementException e) {
            log.info("NoSuchElementException handled for checkFavoriteinOverview...");
        } catch (TimeoutException e) {
            log.info("TimeoutException handled for checkFavoriteinOverview...");
        } catch (Exception e) {
            log.info("Exception handled for checkFavoriteinOverview...");
        }

        return check;
    }

    //To Search in View Assessments Page
    public void VerifyViewAssessmentSearch(String SearchText) {

        System.out.println("Searching the Assessment");

        // Sending the value to the Search box
        DriverHelper.sendKeysId(viewassessmentspage.getViewAssessmentsSearchtextbox(), SearchText);

        //clicking on the search button
        DriverHelper.clickId(viewassessmentspage.getViewAssessmentsSearchButton());
        waitUntilAjaxLoaded();
    }

    //To Verify Title in Legacy Item Bank  Page - Step 1 Provide Basic Information
    public boolean checkLegacyItemBankTitle(String Xpath) {
        boolean check = false;

        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
            WebElement FavoriteIcon = BrowserInitHelper.getInstance().findElement(By.xpath(Xpath));
            check = true;
        } catch (ElementNotInteractableException e) {
            log.info("ElementNotInteractableException handled for checkLegacyItemBankTitle...");
        } catch (NoSuchElementException e) {
            log.info("NoSuchElementException handled for checkLegacyItemBankTitle...");
        } catch (TimeoutException e) {
            log.info("TimeoutException handled for checkLegacyItemBankTitle...");
        } catch (Exception e) {
            log.info("Exception handled for checkLegacyItemBankTitle...");
        }

        return check;
    }

    //To Verify Favorite icon in Overview page
    public boolean checkFavoriteinOverview_Flexible(String Xpath) {
        boolean check = false;

        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
            WebElement FavoriteIcon = BrowserInitHelper.getInstance().findElement(By.xpath(Xpath));
            String className = FavoriteIcon.getAttribute("class");
            if (className.contains("icon-active")) {
                check = true;
            }
        } catch (ElementNotInteractableException e) {
            log.info("ElementNotInteractableException handled for checkFavoriteinOverview...");
        } catch (NoSuchElementException e) {
            log.info("NoSuchElementException handled for checkFavoriteinOverview...");
        } catch (TimeoutException e) {
            log.info("TimeoutException handled for checkFavoriteinOverview...");
        } catch (Exception e) {
            log.info("Exception handled for checkFavoriteinOverview...");
        }

        return check;
    }

    public boolean ChangeAuthorforFlexible(String NewAuthorName) {
        boolean value = false;

        try {
            //Click Gear icon
            highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getGearIcon()))));
            BrowserInitHelper.getInstance().findElement(By.xpath(resultsPage.getGearIcon())).click();

            highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getChangeAssessmentAuthorLink()))));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getChangeAssessmentAuthorLink()))).click();

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getSelectNewAuthorDropdown()))).click();
            try {
                DriverHelper.waitTillElement(resultsPage.getSelectNewAuthorInput());
                //BrowserInitHelper.getInstance().findElement(By.id("select2-drop-mask")).click();
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getSelectNewAuthorInput()))).sendKeys(NewAuthorName);
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getSelectNewAuthorInput()))).sendKeys(Keys.ENTER);
            } catch (TimeoutException te) {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='s2id_autogen1_search'][@class='select2-input']"))).sendKeys(NewAuthorName);
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getSelectNewAuthorInput()))).sendKeys(Keys.ENTER);
            }

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getAgree_change_author()))).click();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getUnderstand_no_undo()))).click();

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getChangeAuthorButton()))).click();
            waitUntilAjaxLoaded();

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(resultsPage.getAlertSuccessonChangeAuthor())));
            String SuccessMessage = BrowserInitHelper.getInstance().findElement(By.xpath(resultsPage.getAlertSuccessonChangeAuthor())).getText();
            if (SuccessMessage.contains("Changing assessment author was successful")) {
                ConsoleLogger.SuccessLog("{Test Case - Changing assessment author was successful alert displayed.....}");
                value = true;
            } else {
                ConsoleLogger.FailedTestCase("{Test Case - Changing assessment author was successful alert NOT displayed.....}");
            }
        } catch (Exception e) {
            log.info("Exception handled......" + e);
        }

        return value;
    }

    //for popup
    public void checkPopup() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getPopup())));
            WebElement popup = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getPopup()));
            Actions action = new Actions(BrowserInitHelper.getInstance());
            action.moveToElement(popup).click().perform();
            DriverHelper.waitTill(2);
        } catch (Exception e) {
            System.out.println("Exception handled for alert popup.......");
        }
    }

    // To turn off toggle button
    public void turnOFFToggleButton() {
        if (JavascriptHelper.getToggleButtonState(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton()).equalsIgnoreCase("true")) {
            /*Click Show Assessments Without Data toggle button*/
            JavascriptHelper.ClickByID_Javascript(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), viewAssessmentsPage.getViewAssessmentPageHeader());
        }
    }

    // To clear added filter
    public void clearAddedFilter() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getClearAllFilters())))).click();
            waitUntilAjaxLoaded();
        } catch (Exception e) {
            System.out.println("Exception handled for clear all link...");
        }
    }

    // To clear search text box
    public void clearSearchTextBox() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchTextBox()))).clear();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextboxButton()))).click();
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), viewAssessmentsPage.getViewAssessmentPageHeader());

        } catch (Exception e) {
            System.out.println("Exception handled for clearing search text box");
        }
    }

}