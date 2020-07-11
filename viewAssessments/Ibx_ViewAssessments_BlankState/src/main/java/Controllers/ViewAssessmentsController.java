package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.DashboardPage;
import Pom.ViewAssessmentsPage;
import Utils.Config;
import Utils.ConsoleLogger;
import Utils.DataReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.BrowserInitHelper.getInstance;
import static Helpers.JavascriptHelper.waitUntilAjaxLoaded;

//  Controller class For ViewAssessments
public class ViewAssessmentsController {

    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    BrowserInitHelper browserInitHelper = new BrowserInitHelper();
    DashboardPage dashboardPage = new DashboardPage();
    Config config = new Config();
    DataReader reader = new DataReader();

    //  To get background color of toggle Button
    public static boolean getElementBackgroundColor(String ID, WebDriver driver, String expectedBackgroundColor) {
        String actualBackgroundColor = driver.findElement(By.xpath("//*[@id = '" + ID + "']/following-sibling::label")).getCssValue("background-color");

        System.out.println("Expected Color :" + expectedBackgroundColor);
        System.out.println("Actual Color :" + actualBackgroundColor);

        if (actualBackgroundColor.equalsIgnoreCase(expectedBackgroundColor)) {
            return true;
        } else {
            return false;
        }
    }

    // To Handle Popup
    public void checkPopup() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getPopup())));
            WebElement popup = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getPopup()));
            Actions action = new Actions(BrowserInitHelper.getInstance());
            action.moveToElement(popup).click().perform();
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

    // To validate page
    public void validatePage(String pageName) {
        browserInitHelper.assertion(dashboardPage.getViewAssessmentsHeader(), pageName);
    }

    // To validate filters
    public void validateFilters() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewAssessmentsPage.getAddFilters())));
        WebElement element = getInstance().findElement(By.xpath(viewAssessmentsPage.getAddFilters()));
        Assert.assertTrue(DriverHelper.elementExistence(element, getInstance()));
        ConsoleLogger.SuccessLog("Add filter label is Present as per the test case");
    }

    // To validate search bar
    public void validateSearchBar() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewAssessmentsPage.getSearchAssessmentsBar())));
        WebElement element = getInstance().findElement(By.xpath(viewAssessmentsPage.getSearchAssessmentsBar()));
        String searchText = element.getText();
        Assert.assertTrue(element.getText().equalsIgnoreCase(""));
        ConsoleLogger.SuccessLog("Search textbox is empty as per the test case");
    }

    // To select data toggle button
    public void selectDataToggleButton() {
        //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton())));

        if (!JavascriptHelper.getToggleButtonState(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton()).equalsIgnoreCase("true")) {
            /*Click Show Assessments Without Data toggle button*/
            JavascriptHelper.ClickByID_Javascript(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton());

            /*Wait until loading icon disappears*/
            DriverHelper.waitUntilLoaderInvisible();
        }
    }

    // To validate selected data toggle button
    public void validateSelectedDataToggleButton() {
        config.readProperties();
        String browser = config.getBrowser();
        if (browser.equalsIgnoreCase("chrome")) {
            /*Validate the background color of Assessments Without Data toggle button when it is set to Show mode*/
            Assert.assertTrue(ViewAssessmentsController.getElementBackgroundColor(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton(),
                    getInstance(), reader.getShowAssessmentsWithoutDataBackgroundColorChrome()));
            ConsoleLogger.SuccessLog("Background color of Assessments Without Data toggle button is matching as per the test data");
        } else if (browser.equalsIgnoreCase("firefox")) {
            /*Validate the background color of Assessments Without Data toggle button when it is set to Show mode*/
            Assert.assertTrue(ViewAssessmentsController.getElementBackgroundColor(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton(),
                    getInstance(), reader.getShowAssessmentsWithoutDataBackgroundColorFirefox()));
            ConsoleLogger.SuccessLog("Background color of Assessments Without Data toggle button is matching as per the test data");
        }
    }
}
