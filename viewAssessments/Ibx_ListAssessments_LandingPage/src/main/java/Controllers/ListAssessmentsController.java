package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JSExecutorHelper;
import Pom.AssessmentViewPage;
import Utils.Config;
import Utils.ConsoleLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Controllers class for ListAssessmentsController
public class ListAssessmentsController {
    public static AssessmentViewPage assessmentViewPage = new AssessmentViewPage();

    //ShowAssessmentWithDataToggle class
    public static class ShowAssessmentWithDataToggle {
        //Method for Toggle On
        public static void toggleOn() {
            try {
                JSExecutorHelper.waitUntilDocumentIsReady();
                JSExecutorHelper.waitUntilAjaxLoaded();
                if (!BrowserInitHelper.getInstance().findElement(By.xpath(assessmentViewPage.getOnlyShowAsmtToggleInput())).isSelected()) {
                    DriverHelper.clickXpath(assessmentViewPage.getOnlyShowAsmtToggleLable());
                }
            } catch (Exception e) {
                System.out.println("handeled");

            }
        }

        //Method for Toggle off
        public static void toggleOff() {
            try {
                JSExecutorHelper.waitUntilDocumentIsReady();
                JSExecutorHelper.waitUntilAjaxLoaded();
                if (BrowserInitHelper.getInstance().findElement(By.xpath(assessmentViewPage.getOnlyShowAsmtToggleInput())).isSelected()) {
                    DriverHelper.clickXpath(assessmentViewPage.getOnlyShowAsmtToggleLable());
                }
            } catch (Exception e) {
                System.out.println("handled");
            }
        }
    }

    //Method for Create Button
    public static class CreateButton {
        private static Config config = new Config();
        private static String browser;

        public static void clickCreateButton() {
            try {
                DriverHelper.clickXpath(assessmentViewPage.getCreateButton());
            } catch (Exception e) {
                ConsoleLogger.ErrorLog("Create button not found");
            }
        }

        //Method for clickSpecificAssessment
        public static void clickSpecificAssessment(String assessmentType) {
            try {
                DriverHelper.clickXpath("//ul[@class='dropdown-menu']//a[contains(text(),'" + assessmentType + "')]");
            } catch (Exception e) {
                ConsoleLogger.ErrorLog(assessmentType + " not found!");
            }
        }

        //Method for CliclAll
        public static void clickAll() {
            config.readProperties();
            browser = config.getBrowser();
            String assessment = null;
            String currentUrl = BrowserInitHelper.getInstance().getCurrentUrl();
            int numberOfElements = BrowserInitHelper.getInstance().findElements(By.xpath(assessmentViewPage.getnumberOfAssessments())).size();
            for (int i = 1; i < numberOfElements + 1; i++) {
                try {
                    assessment = BrowserInitHelper.getInstance().findElement(By.xpath("//ul[@class='dropdown-menu']/li[" + Integer.toString(i) + "]/a")).getText();
                    DriverHelper.clickXpath("//ul[@class='dropdown-menu']/li[" + Integer.toString(i) + "]/a");
                    if (!browser.equals("safari")) {
                        JSExecutorHelper.waitUntilDocumentIsReady();
                    } else {
                        Thread.sleep(1000);
                        JSExecutorHelper.waitUntilDocumentIsReady();
                    }
                    BrowserInitHelper.getInstance().get(currentUrl);
                    clickCreateButton();
                } catch (Exception e) {
                    ConsoleLogger.ErrorLog(assessment + " not found!");
                }
                ConsoleLogger.SuccessLog(assessment + " displayed and able to navigate to the page");
            }
        }
    }

    //FilterModalController class
    public static class FilterModalController {
        //Method fot get Filter Model
        public static void getFilterModal() {
            DriverHelper.clickXpath(assessmentViewPage.getFilterModel());
            WebElement element = BrowserInitHelper.getInstance().findElement(By.id("reset-btn"));
            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
            DriverHelper.waitTill(5);
            DriverHelper.clickXpath(assessmentViewPage.getResetButton());
        }

        //Method to get Assessment Type
        public static void getAssessmentType(String assessmentType) {
            //WebElement scroll = BrowserInitHelper.getInstance().findElement(By.xpath("//body"));
            WebElement scroll = BrowserInitHelper.getInstance().findElement(By.id("date_created_start"));
            for (int i = 0; i < 5; i++) {
                scroll.sendKeys(Keys.PAGE_UP);
            }
            DriverHelper.waitTill(5);
//            WebElement element = BrowserInitHelper.getInstance().findElement(By.id("s2id_autogen1"));
//            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
//            DriverHelper.waitTill(3);
            DriverHelper.sendKeysXpath(assessmentViewPage.getAssessmentType(), assessmentType);
            //DriverHelper.clickXpath("//div[15]/ul[1]/li[1]/div[1]");
            DriverHelper.clickXpath(assessmentViewPage.getAssessmentTypeclick());
            clickSearch();
        }

        //Method for click Serach
        public static void clickSearch() {
            WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(assessmentViewPage.getSearch()));
            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
            DriverHelper.waitTill(3);
            Actions actions = new Actions(BrowserInitHelper.getInstance());
            actions.moveToElement(element);
            actions.click(element);
            actions.click(element);
            actions.build().perform();
            ResultsTableController.checkDataAvailable();
        }
    }

    //Method for FilterColumnsController
    public static class FilterColumnsController {

        public static void getAscDataColumn() {
            if (BrowserInitHelper.getInstance().findElement(By.xpath(assessmentViewPage.getAscDataColumn())).isDisplayed()) {
                DriverHelper.clickXpath(assessmentViewPage.getAscDataColumnClick());
            }
        }

        //Method to get DescDataColumn
        public static void getDescDataColumn() {
            if (BrowserInitHelper.getInstance().findElement(By.xpath(assessmentViewPage.getDesDataColumn())).isDisplayed()) {
                DriverHelper.clickXpath(assessmentViewPage.getdesDataColumnClick());
            }
        }
    }

    //ResultsTableController class
    public static class ResultsTableController {
        public static void getFirstRow() {
            try {


                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(assessmentViewPage.getFirstRow()))).size() > 0) {
                    DriverHelper.waitTill(3);
                    DriverHelper.clickXpath(assessmentViewPage.getFirstRowClick());
                }
            } catch (Exception e) {
//                WebDriverWait wait = new WebDriverWait(BrowserInitHelper.getInstance(),10);
//                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(assessmentViewPage.getFirstRow())));
//                DriverHelper.clickXpath(assessmentViewPage.getFirstRowClick());
                ConsoleLogger.FailedTestCase("No data available in table");
            }
        }

        public static boolean getFlexibleAssessment() {
            int i;
            boolean assessmentFound = false;
            try {
                DriverHelper.waitTill(3);
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(assessmentViewPage.getVisibalityOfAllElements())));
                int numberOfAssessmentsListed = BrowserInitHelper.getInstance().findElements(By.xpath(assessmentViewPage.getFlexibleElement())).size();
                for (i = 1; i < numberOfAssessmentsListed; i++) {
                    String assessmentType = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table_')]//tr[" + Integer.toString(i) + "]//td[3]")).getText().trim();
                    if (assessmentType.equals("Flexible")) {
                        DriverHelper.clickXpath("//table[1]/tbody[1]/tr[" + Integer.toString(i) + "]/td[2]/a[1]");
                        assessmentFound = true;
                        break;
                    }
                }
            } catch (Exception e) {
                ConsoleLogger.FailedTestCase("No data available in table or no flex found");
            }
            return assessmentFound;
        }

        public static boolean getManualHybridAssessmentWithData() {
            int i;
            boolean assessmentFound = false;
            boolean nextPage = true;
            try {
                while (nextPage) {
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(assessmentViewPage.getVisibalityOfAllElements())));
                    //int numberOfAssessmentsListed = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='assessment_list_data_table_wrapper']//tr")).size();
                    int numberOfAssessmentsListed = BrowserInitHelper.getInstance().findElements(By.xpath(assessmentViewPage.getFlexibleElement())).size();


                    for (i = 1; i < numberOfAssessmentsListed; i++) {
                        String assessmentType = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table_')]//tr[" + Integer.toString(i) + "]//td[3]")).getText().trim();
                        if (assessmentType.equals("Assessment")) {
                            DriverHelper.clickXpath("//table[1]/tbody[1]/tr[" + Integer.toString(i) + "]/td[2]/a[1]");
                            return true;
                        }
                    }
                    nextPage = getNextPage();
                }
            } catch (Exception e) {
                ConsoleLogger.FailedTestCase("No data available in table or no flex found");
            }
            return assessmentFound;
        }

        //Method to get Manual HybridAssessment Without Data
        public static boolean getManualHybridAssessmentWithoutData() {
            int i;
            boolean assessmentFound = false;
            boolean nextPage = true;
            try {
                while (nextPage) {
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(assessmentViewPage.getVisibalityOfAllElements())));
                    int numberOfAssessmentsListed = BrowserInitHelper.getInstance().findElements(By.xpath(assessmentViewPage.getFlexibleElement())).size();
                    for (i = 1; i < numberOfAssessmentsListed; i++) {
                        String assessmentType = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table_')]//tr[" + Integer.toString(i) + "]//td[3]")).getText().trim();
                        if (assessmentType.equals("Assessment") && BrowserInitHelper.getInstance().findElements(By.xpath("//tr[" + Integer.toString(i) + "]//td[8]//a[1]//span[@class='badge']")).size() > 0) {
                            DriverHelper.clickXpath("//table[1]/tbody[1]/tr[" + Integer.toString(i) + "]/td[2]/a[1]");
                            return true;
                        }
                    }
                    nextPage = getNextPage();

                }
            } catch (Exception e) {
                ConsoleLogger.FailedTestCase("No data available in table or no flex found");
            }
            return assessmentFound;
        }

        //Method to check Data Available
        public static void checkDataAvailable() {
            try {
                JSExecutorHelper.waitUntilDocumentIsReady();
                JSExecutorHelper.waitUntilAjaxLoaded();
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(assessmentViewPage.getVisibalityOfAllElements())));
            } catch (Exception e) {
                ConsoleLogger.FailedTestCase("No data available in table");
            }
        }

        //Method to get Next Page
        public static boolean getNextPage() {
            int numberOfElements = BrowserInitHelper.getInstance().findElements(By.xpath(assessmentViewPage.getNextPageNumberOfElements())).size();
            int currentPage = Integer.parseInt(BrowserInitHelper.getInstance().findElement(By.xpath(assessmentViewPage.getNextPageCurrentPage())).getText());
            if (!(numberOfElements > 3)) {
                return false;
            }
            try {
                ConsoleLogger.DebugLog(Integer.toString(currentPage + 2));
                DriverHelper.clickXpath("//a[@href='#'][contains(text(),'" + Integer.toString(currentPage + 1) + "')]");
            } catch (Exception e) {
                ConsoleLogger.FailedTestCase("Next page not found.");
                return false;
            }
            return true;
        }
    }
}

