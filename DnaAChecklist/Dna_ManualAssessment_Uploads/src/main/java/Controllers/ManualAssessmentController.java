package Controllers;

import org.graphwalker.Config;
import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.ManualAssessmentPage;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

//controller class for ManualAssessmentController
public class ManualAssessmentController {
    //Declarations
    static ManualAssessmentPage manualAssessmentPage = new ManualAssessmentPage();
    static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

    // Uploads class
    public static class Uploads {
        // method for upload
        public static void upload(String uploadPath, WebDriverWait waiter, WebDriver driver) {
            System.out.println(uploadPath);
            Helper.clickXpath(manualAssessmentPage.getManualAssessmentUploadPath(), waiter, driver);
            waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(manualAssessmentPage.getManualAssessmentFile()))).sendKeys(uploadPath);
            Helper.wait(5.0);
            Helper.clickXpath(manualAssessmentPage.getManualAssessmentUploadButton(), waiter, driver);
            Helper.waitUntil(manualAssessmentPage.getManualAssessmentContainer(), waiter, driver);
            Helper.wait(5.0);
        }

        // method for uploadFromDetails
        public static void uploadFromDetails(String uploadPath, WebDriverWait waiter, WebDriver driver) {
            System.out.println(uploadPath);
            Helper.clickXpath(manualAssessmentPage.getManualAssessmentUploadFromDetailsPath(), waiter, driver);
            WebElement element = driver.findElement(By.xpath(manualAssessmentPage.getManualAssessmentCanvasUpload()));
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.click();
            actions.build().perform();
            waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(manualAssessmentPage.getManualAssessmentUploadFromDetailsFile()))).sendKeys(uploadPath);
            Helper.wait(5.0);
            Helper.clickXpath(manualAssessmentPage.getManualAssessmentUploadButton(), waiter, driver);
            Helper.waitUntil(manualAssessmentPage.getManualAssessmentUploadFromDetailsCanvas(), waiter, driver);
            Helper.wait(8.0);
        }

        // method for uploadFromSetupTabMaterialsDrodown
        public static void uploadFromSetupTabMaterialsDrodown(String uploadPath, WebDriverWait waiter, WebDriver driver) {
            System.out.println(uploadPath);
            Helper.clickXpath(manualAssessmentPage.getManualAssessmentUploadFromSetUp(), waiter, driver);
            Helper.clickXpath(manualAssessmentPage.getManualAssessmentUploadFromSetUpMaterials(), waiter, driver);
            Helper.clickXpath(manualAssessmentPage.getManualAssessmentUploadFromDetailsSetupCanvas(), waiter, driver);
            waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(manualAssessmentPage.getManualAssessmentUploadDetailsSetUpFile()))).sendKeys(uploadPath);
            Helper.wait(5.0);
            Helper.clickXpath(manualAssessmentPage.getManualAssessmentUploadButton(), waiter, driver);
            Helper.wait(5.0);
            Helper.waitUntil(manualAssessmentPage.getManualAssessmentUploadFromDetailsCanvas(), waiter, driver);
            Helper.wait(8.0);
        }

        // method for checkPreviewOnlineTestingFromAdministrationPage
        public static void checkPreviewOnlineTestingFromAdministrationPage(String upload, Boolean isPdf, WebDriverWait waiter, WebDriver driver) {
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreview(), waiter, driver);
            Select dropdown = new Select(driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewDropdown())));
            dropdown.selectByVisibleText(upload);
            Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewDropdownSelect(),waiter,driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewDropdownSelect(), waiter, driver);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

            for (int i = 0; i <= 75; i++) {
                System.out.println(tabs.size());
                if (tabs.size() > 1) {
                    driver.switchTo().window(tabs.get(1));
                    break;
                }
                Helper.wait(1.0);
                tabs = new ArrayList<String>(driver.getWindowHandles());
            }
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewLinkSuccess(), waiter, driver);

            if (isPdf == true) {
                String pdfUrl = waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewIfPDF()))).getAttribute("src");

                try {
                    URL url = new URL(pdfUrl);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    if (200 != con.getResponseCode()) {
                        System.out.println("Response code not 200.");
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewPageLoad(), waiter, driver);
            }
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }

        // method for uploadPreviewOnlineTestingFromAdministrationPage
        public static void uploadPreviewOnlineTestingFromAdministrationPage(String upload, String uploadPath, Boolean isPdf, WebDriverWait waiter, WebDriver driver) {
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreview(), waiter, driver);

            WebElement element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationUploadPreview()));
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.click();
            actions.build().perform();
            waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(manualAssessmentPage.getManualAssessmentUploadFromDetailsFile()))).sendKeys(uploadPath);
            Helper.wait(5.0);
            Helper.clickXpath(manualAssessmentPage.getManualAssessmentUploadButton(), waiter, driver);

            Select dropdown = new Select(driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewDropdown())));
            dropdown.selectByVisibleText(upload);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewDropdownSelect(), waiter, driver);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

            for (int i = 0; i <= 75; i++) {
                System.out.println(tabs.size());
                if (tabs.size() > 1) {
                    driver.switchTo().window(tabs.get(1));
                    break;
                }
                Helper.wait(1.0);
                tabs = new ArrayList<String>(driver.getWindowHandles());
            }
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewLinkSuccess(), waiter, driver);

            if (isPdf == true) {
                String pdfUrl = waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewIfPDF()))).getAttribute("src");

                try {
                    URL url = new URL(pdfUrl);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    if (200 != con.getResponseCode()) {
                        System.out.println("Response code not 200.");
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewPageLoad(), waiter, driver);
            }
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }

        // method for checkOnlineTesting
        public static void checkOnlineTesting(String upload, String administrationPage, String quickRosterUrl, Boolean isPdf, WebDriverWait waiter, WebDriver driver) {
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckOnlineTesting(), waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAssessmentRoster(), waiter, driver);
            Select dropdown = new Select(driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewDropdown())));
            dropdown.selectByVisibleText(upload);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSaveAndReturn(), waiter, driver);

            try {
                String completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationCompleteBarText(), waiter, driver);
                while (!completeBar.equals("Complete")) {
                    // loop
                    try {
                        Helper.wait(1.0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationCompleteBarText(), waiter, driver);
                }
            } catch (Exception e) {
                System.out.println("Exception handled for complete bar....");
            }
            String quickRoster = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationQuickRoster(), waiter, driver);

            driver.get(quickRosterUrl + quickRoster);
            Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationStudentLogin(), Config.getStudentQrId(), waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationNext(), waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationConfirm(), waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSuccess(), waiter, driver);

            if (isPdf == true) {
                String pdfUrl = waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewIfPDF()))).getAttribute("src");
                try {
                    URL url = new URL(pdfUrl);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    if (200 != con.getResponseCode()) {
                        System.out.println("Response code not 200.");
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationCheckPreviewPageLoad(), waiter, driver);
            }
            driver.get(administrationPage);
        }
    }
}
