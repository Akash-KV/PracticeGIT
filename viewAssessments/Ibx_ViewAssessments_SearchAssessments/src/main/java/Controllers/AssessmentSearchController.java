package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;

import Pom.ViewAssessmentsPage;
import Utils.ConsoleLogger;
import Utils.DataReaderViewAssessmentsSearch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Helpers.JavascriptHelper.*;

//Controller class for AssessmentSearch
public class AssessmentSearchController {

    ViewAssessmentsPage viewAssessment = new ViewAssessmentsPage();
    DataReaderViewAssessmentsSearch viewassessmentsdatareader = new DataReaderViewAssessmentsSearch();
    DriverHelper driverHelper = new DriverHelper();
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    //Verify ViewAssessment Search field
    public void VerifyViewAssessmentSearch(String SearchText) {
        // Sending the value to the Search box
        DriverHelper.sendKeysId(viewAssessment.getViewAssessmentSearchtextbox(), SearchText, BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        //clicking on the search button
        DriverHelper.clickId(viewAssessment.getViewAssessmentSearchtextboxButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        //DriverHelper.getElementByXpath(viewAssessment.getloader());
        DriverHelper.waitUntilElementInvisible_ByXPath(viewAssessment.getloader());
        waitUntilAjaxLoaded();
    }

    //Verify the View Assessment Search using Tabkey
    public void VerifyViewAssessmentSearchUsingTABKey(String SearchText) {
        // Sending the value to the Search box
        DriverHelper.sendKeysId(viewAssessment.getViewAssessmentSearchtextbox(), SearchText, BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());

        //clicking on the search button Using TAB Key
        WebElement ViewAssessmentSearchtextboxButton = BrowserInitHelper.getInstance().findElement(By.id("direct_search"));

        ViewAssessmentSearchtextboxButton.sendKeys(Keys.TAB);
        System.out.println("TAB Clicked");
        ViewAssessmentSearchtextboxButton.sendKeys(Keys.ENTER);


        //DriverHelper.getElementByXpath(viewAssessment.getloader());
        //DriverHelper.waitUntilElementInvisible_ByXPath(viewAssessment.getloader());

        waitUntilAjaxLoaded();

        System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]")).getText());
    }

    //Verify Searched Valid Assessment Title
    public boolean verifySearchedValidViewAssessmentTitleandOverview(String SearchText) {
        boolean bvalue = false;
        if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).getText().equalsIgnoreCase(SearchText)) {
            log.info("Title matched in View Assessment Page");
           /* //clikcing on the Assessment name
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
            try{
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='modal-backdrop  in']")))).click();
            }
            catch (Exception e){

            }
            //checking the Assessment name in the overview page
            if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='assessment-info']//p[@class='lead']")))).getText().equalsIgnoreCase(SearchText)) {
                log.info("Title matched in Overview Page");
                bvalue = true;
            }

            else
            {
                log.info("Title matched is not matched in Overview Page ");
            }*/

            if (DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Item Bank") || DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Assessment")) {

                //clikcing on the Assessment name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
                waitUntilAjaxLoaded();

                //waiting till the element clickable
                try {
                    DriverHelper.waitandclickID("assessment-info");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //checking the Assessment name in the overview page
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='assessment-info']//p[@class='lead']")))).getText().equalsIgnoreCase(SearchText)) {
                    log.info("Title matched in Overview Page");
                    bvalue = true;
                } else {
                    log.info("Title matched is not matched in Overview Page ");
                }

                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();
            } else if (DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("State Assessment")) {
                //clikcing on the Assessment name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
                waitUntilAjaxLoaded();
                //waiting till the element clickable
                try {
                    DriverHelper.waitandclickxpath("//div[@class='dataTables_caption']");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //checking the Assessment name in the overview page
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='dataTables_caption']")))).getText().equalsIgnoreCase(SearchText)) {
                    log.info("Title matched in Overview Page");
                    bvalue = true;
                } else {
                    log.info("Title matched is not matched in Overview Page ");
                }

                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();

            } else if (DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Physical Fitness Test") ||
                    DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Assessment View") ||
                    DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Pool Assessment") ||
                    DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Skills Assessment") ||
                    DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("DIBELS Next") ||
                    DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("DIBELS Sixth") ||
                    DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("DIBELS IDEL") ||
                    DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Summary Assessment") ||
                    DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Demographic") ||
                    DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Survey")
            ) {
                //clikcing on the Assessment name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
                waitUntilAjaxLoaded();
                try {
                    DriverHelper.waitandclickxpath("//div[@id='subactions']/h3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //checking the Assessment name in the overview page
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='subactions']/h3")))).getText().equalsIgnoreCase(SearchText)) {
                    log.info("Title matched in Overview Page");
                    bvalue = true;
                } else {
                    log.info("Title matched is not matched in Overview Page ");
                }

                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();

            } else if (DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Flexible")) {
                //clikcing on the Assessment name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
                waitUntilAjaxLoaded();
                try {
                    DriverHelper.waitandclickxpath("//div[@class='title header-font']");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //checking the Assessment name in the overview page
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='title header-font']")))).getText().equalsIgnoreCase(SearchText)) {
                    log.info("Title matched in Overview Page");
                    bvalue = true;
                } else {
                    log.info("Title matched is not matched in Overview Page ");
                }

                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();

            } else if (DriverHelper.getElementByXpath(viewAssessment.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Fluence")) {
                //clikcing on the Assessment name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
                waitUntilAjaxLoaded();
                try {
                    DriverHelper.waitandclickxpath("//div[@class='title header-font']");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //checking the Assessment name in the overview page
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='subactions']/h3/abbr")))).getText().contains(SearchText)) {
                    log.info("Title matched in Overview Page");
                    bvalue = true;
                } else {
                    log.info("Title matched is not matched in Overview Page ");
                }

                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();

            }


            //bvalue = true;
        }
        //Assert.assertTrue(bvalue);
        return bvalue;
    }

    //Verify Searched View Assessment First row
    public boolean verifySearchedViewAssessmentFirstRow(String SearchText) {

        boolean bvalue = false;

        driverHelper.getElementByXpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]");
        log.info("waited till first row loading");
        List<WebElement> rowelements = BrowserInitHelper.getInstance().findElements(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td"));
        log.info("Size of List: " + rowelements.size());

        for (WebElement element : rowelements) {
            if (element.getText().contains(SearchText)) {
                log.info("Matched sucessfully --> " + element.getText());
                bvalue = true;
            } else if (element.getText().equalsIgnoreCase("No data available in table")) {
                log.info("No data available in table is displaying for the search");
                bvalue = true;
            }
        }

        return bvalue;
    }

    //Verify Searched View Assessment First row Title
    public boolean verifySearchedViewAssessmentFirstRowTitle(String SearchText) {

        boolean bvalue = false;
        WebElement FirstRowTitle = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a"));
        WebElement NoDataMessage = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td"));


        if (FirstRowTitle.getText().trim().contains(SearchText)) {
            log.info("Matched sucessfully --> " + FirstRowTitle.getText());
            bvalue = true;
        } else if (NoDataMessage.getText().trim().equalsIgnoreCase("No data available in table")) {
            log.info("No data available in table is displaying for the search");
            bvalue = true;
        }

        return bvalue;
    }

    //Verify Searched View Assessment First row Local Identifier
    public boolean verifySearchedViewAssessmentFirstRowLocalIdentifier(String SearchText) {

        boolean bvalue = false;
        WebElement FirstRowLocalIdentifier = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[4]"));
        WebElement NoDataMessage = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td"));


        if (FirstRowLocalIdentifier.getText().trim().equalsIgnoreCase(SearchText)) {
            log.info("Matched sucessfully --> " + FirstRowLocalIdentifier.getText());
            bvalue = true;
        } else if (NoDataMessage.getText().trim().equalsIgnoreCase("No data available in table")) {
            log.info("No data available in table is displaying for the search");
            bvalue = true;
        }
        return bvalue;
    }

    //Verify Searched View Assessment First row Owner
    public boolean verifySearchedViewAssessmentFirstRowOwner(String SearchText) {

        boolean bvalue = false;
        WebElement FirstRowOwner = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[5]"));
        WebElement NoDataMessage = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td"));


        if (FirstRowOwner.getText().trim().contains(SearchText)) {
            log.info("Matched sucessfully --> " + FirstRowOwner.getText());
            bvalue = true;
        } else if (NoDataMessage.getText().trim().equalsIgnoreCase("No data available in table")) {
            log.info("No data available in table is displaying for the search");
            bvalue = true;
        }
        return bvalue;
    }

    public static boolean getFirstRow() {
        boolean checkFirstRowData = false;
        try {
            if (BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td"))).size() > 0) {
                checkFirstRowData = true;
            }
        } catch (Exception e) {
            ConsoleLogger.FailedTestCase("No data available in table");
        }

        return checkFirstRowData;
    }

    //Check Element is displayed
    public boolean checkDisplay(String xpath) {
        boolean value = false;

        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
            if (element.isDisplayed()) {
                value = true;
            }
        } catch (TimeoutException te) {
            log.info("{checkDisplay method failed....}");
        } catch (Exception e) {
            log.info("{checkDisplay method failed....}");
        }
        return value;
    }

    //Check for the Popup
    public void checkPopup() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessment.getPopup())));
            WebElement popup = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessment.getPopup()));
            Actions action = new Actions(BrowserInitHelper.getInstance());
            action.moveToElement(popup).click().perform();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled for alert popup.......");
        }
    }

}
