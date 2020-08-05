package Controllers;

import org.graphwalker.Config;
import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.AnswerKey;
import org.graphwalker.PageObjectModels.FlexAnswerKeyPage;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

//Controller class for Flex assessment
public class FlexAssessmentController {

    public static AnswerKey answerKey = new AnswerKey();
    public static FlexAnswerKeyPage flexAnswerKeyPage = new FlexAnswerKeyPage();
    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

    //Method to add questions
    public static void addQuestions(int numberOfQuestions, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath(answerKey.getAnswerKeyAddQuestions(), waiter, driver);
        Helper.sendKeysXpath(answerKey.getAnswerKeyQuestionQuantity(), Integer.toString(numberOfQuestions), waiter, driver);
        Helper.clickXpath(answerKey.getAnswerKeyAddButton(), waiter, driver);
    }

    //Method to add multiple choice
    public static void addMultipleChoice(int questionNumber, String answerChoice, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[1]//span[@class='choice'][contains(text(),'" + answerChoice + "')]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/button[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }

    //Method to add multiple choice with no standerds
    public static void addMultipleChoiceNoStandards(int questionNumber, String answerChoice, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[1]//span[@class='choice'][contains(text(),'" + answerChoice + "')]", waiter, driver);
    }

    //Method to add MultipleChoice Partial Credit
    public static void addMultipleChoicePartialCredit(int questionNumber, String answerChoice, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//span[contains(text(),'Multiple Choice Partial Credit (MC Ptl)')]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[1]//span[@class='choice'][contains(text(),'" + answerChoice + "')]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }

    //Method to add ConstructedResponse
    public static void addConstructedResponse(int questionNumber, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//span[contains(text(),'Constructed Response (CR)')]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }

    //method to add addExplicitConstructedResponse
    public static void addExplicitConstructedResponse(int questionNumber, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//span[contains(text(),'Explicit Constructed Response (CR Exp)')]", waiter, driver);
        Helper.clickXpath(answerKey.getexplicitConstructedResponseAddIcon(), waiter, driver);
        Helper.sendKeysXpath(answerKey.getExplicitConstructedResponseFirstInput(), "co", waiter, driver);
        Helper.sendKeysXpath(answerKey.getExplicitConstructedResponseSecondInput(), "in", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }

    //method to add ConstructedResponseAdvanced
    public static void addConstructedResponseAdvanced(int questionNumber, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//span[@class='label'][contains(text(),'Constructed Response (CR Adv)')]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }
//method to add MultipleChoiceAdvanced

    public static void addMultipleChoiceAdvanced(int questionNumber, String[] answerChoices, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//span[contains(text(),'Multiple Choice Advanced (MC Adv)')]", waiter, driver);
        String drodownText = Helper.getText("//tr[" + Integer.toString(questionNumber) + "]//td[2]/div[1]/button[1]/div[1]", waiter, driver);
        while (!drodownText.equals("MC Adv")) {
            Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i", waiter, driver);
            Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//span[contains(text(),'Multiple Choice Advanced (MC Adv)')]", waiter, driver);
            drodownText = Helper.getText("//tr[6]//td[2]/div[1]/button[1]/div[1]", waiter, driver);
        }
        Helper.clickXpath(answerKey.getMultipleChoiceAdvanced(), waiter, driver);

        for (int i = 0; i <= answerChoices.length - 1; i++) {
            Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[1]//div[@class='wrapper']//div[" + Integer.toString(i + 1) + "]//div[1]//span[@class='choice'][contains(text(),'" + answerChoices[i].toString() + "')]", waiter, driver);
        }
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }

    public static void clearPopUpInAnswerKeyPage(WebDriverWait waiter, WebDriver driver) {
        try {
            Helper.wait(5.0);
            Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyCloseButton(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled add questions popup");
        }
    }

    //class upload
    public static class Uploads {
        //upload method
        public static void upload(String uploadPath, WebDriverWait waiter, WebDriver driver) {
            System.out.println(uploadPath);
            Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyUploadButton(), waiter, driver);
            waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyUploadType()))).sendKeys(uploadPath);
            Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyResourcesRow(), waiter, driver);
            Helper.waitUntil(flexAnswerKeyPage.getFlexAnswerKeyPreviewUnAvailableMessage(), waiter, driver);
        }

        //Method to upload to google drive
        public static void uploadGoogleDrive(String uploadName, WebDriverWait waiter, WebDriver driver) {
            if (driver.findElements(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyUploadButton())).size() != 0) {
                Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyUploadButton(), waiter, driver);
            } else {
                Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyUploadButton(), waiter, driver);
            }
            Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyGoogleDrive(), waiter, driver);

            String parentWindowHandler = uploadGoogleDriveLogin(waiter, driver);

            // Switch to iframe
            try {
                Helper.wait(20.0);
                int size = driver.findElements(By.tagName("iframe")).size();
                System.out.println("Here" + Integer.toString(size));

                driver.switchTo().frame(driver.findElement(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyDialogFrame())));
                Helper.sendKeysXpath(flexAnswerKeyPage.getFlexAnswerKeySearchTerms(), uploadName, waiter, driver);
                Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeySearchTermsImage(), waiter, driver);
                Helper.wait(4.0);
                try {
                    Helper.clickXpath("(//span[contains(text(),'" + uploadName + "')])[2]", waiter, driver);
                } catch (Exception e) {
                    Helper.clickXpath("(//span[contains(text(),'" + uploadName + "')])[1]", waiter, driver);
                }
                Helper.clickXpath(answerKey.getAnswerKeyUploads(), waiter, driver);
                driver.switchTo().parentFrame();

                uploadSuccessModal(waiter, driver);
                uploadGoogleDrivePdfConversionConfirmation(uploadName, waiter, driver);
                uploadGoogleDriveVerifyUploadIsListed(uploadName, waiter, driver);

                Helper.wait(3.0);
                driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
                Helper.wait(3.0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Method for google drive login
        public static String uploadGoogleDriveLogin(WebDriverWait waiter, WebDriver driver) {
            Helper.wait(10.0);
            String parentWindowHandler = Helper.switchToPopup(waiter, driver);
            Helper.sendKeysXpath(flexAnswerKeyPage.getFlexAnswerKeyIdentifierID(), Config.getEmailID(), waiter, driver);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyIdentifierNext())));
            //  Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyIdentifierNext(), waiter, driver);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyIdentifierNext()))).doubleClick().build().perform();
            Helper.sendKeysXpath(flexAnswerKeyPage.getFlexAnswerKeyPassword(), Config.getEmailPassword(), waiter, driver);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyPasswordNext())));
            actions.moveToElement(driver.findElement(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyPasswordNext()))).doubleClick().build().perform();

            //            Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyIdentifierNext(), waiter, driver);
//            Helper.sendKeysXpath(flexAnswerKeyPage.getFlexAnswerKeyPassword(), Config.getEmailPassword(), waiter, driver);
//            Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyPasswordNext(), waiter, driver);
            Helper.switchBackToOriginalWindowFromPopup(parentWindowHandler, waiter, driver);
            return parentWindowHandler;
        }

        //Method to upload GoogleDrive PdfConversionConfirmation
        public static void uploadGoogleDrivePdfConversionConfirmation(String uploadName, WebDriverWait waiter, WebDriver driver) {
            try {
                waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyPdfConfirmation())));
            } catch (Exception e) {
                System.out.println("PDF Conversion Confirmation modal did not display");
            }
            try {
                Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyPdfConfirmationModel(), waiter, driver);
            } catch (Exception e) {
                System.out.println("User was not able to exit Pdf Conversion Confirmation model");
            }
        }

        //method to uploadGoogleDrive VerifyUpload IsListed
        public static void uploadGoogleDriveVerifyUploadIsListed(String uploadName, WebDriverWait waiter, WebDriver driver) {
            try {
                waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyTestGoogleDoc())));
            } catch (Exception e) {
                System.out.println("Upload is not listed under List of materials");
            }
        }

        //method to get upload as success
        public static void uploadSuccessModal(WebDriverWait waiter, WebDriver driver) {
            waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyUploadSuccess())));
            Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyDisplayValidationComponent(), waiter, driver);
        }

        //method to exit upload material model
        public static void exitUploadMaterialsModal(WebDriverWait waiter, WebDriver driver) {
            try {
                Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyFlexColumnClose(), waiter, driver);
            } catch (Exception e) {
                System.out.println("Exception handled....");
            }
        }

        //method to check preview model
        public static void checkPreviewModal(WebDriverWait waiter, WebDriver driver) {
            Helper.wait(5.0);
            Helper.clickXpath(answerKey.getAnswerKeyMaterial(), waiter, driver);
            Helper.wait(3.0);
            WebElement icon = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(answerKey.getAnswerKeyResources())));
            Actions actions = new Actions(driver);
            actions.moveToElement(icon);
            actions.click();
            actions.build().perform();
            Helper.wait(2.0);

            try {
                Thread.sleep(5000);
                driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("Exception handled....");
            }
        }

        //method to check PreviewOnlineTesting FromAnswerKey
        public static void checkPreviewOnlineTestingFromAnswerKey(Boolean isPdf, WebDriverWait waiter, WebDriver driver) {
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationPreview(), waiter, driver);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSuccess(), waiter, driver);

            if (isPdf == true) {
                Helper.wait(3.0);
                String pdfUrl = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationType()))).getAttribute("src");
                try {
                    URL url = new URL(pdfUrl);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    if (200 != con.getResponseCode()) {
                        System.out.println("Response code not 200.");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationBPPage(), waiter, driver);
            }
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }

        //method to checkPreview OnlineTestingFromAdministrationPage
        public static void checkPreviewOnlineTestingFromAdministrationPage(Boolean isPdf, WebDriverWait waiter, WebDriver driver) {
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationPreviewAssessment(), waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationPreviewButton(), waiter, driver);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSuccess(), waiter, driver);


            if (isPdf == true) {
                Helper.wait(3.0);
                String pdfUrl = waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationType()))).getAttribute("src");
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
                Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationBPPage(), waiter, driver);
            }
            driver.close();
            driver.switchTo().window(tabs.get(0));
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationCancel(), waiter, driver);
        }

        //method to check online testing
        public static void checkOnlineTesting(Boolean isPdf, String quickRosterUrl, WebDriverWait waiter, WebDriver driver) {
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationQuickRosterButton(), waiter, driver);
            try {
                String completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationcompleteBar(), waiter, driver);
                while (!completeBar.equals("Complete")) {
                    // loop
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationcompleteBar(), waiter, driver);
                }
            } catch (Exception e) {
                System.out.println("Exception handled for complete bar...");
            }
            String quickRoster = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationAccessCode(), waiter, driver);


            driver.get(quickRosterUrl + quickRoster);
            Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationStudentLogin(), Config.getStudentQrId(), waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOlineTestingAdministrationNextButton(), waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationConfirmButton(), waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSuccess(), waiter, driver);

            if (isPdf == true) {
                Helper.wait(3.0);
                String pdfUrl = waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationType()))).getAttribute("src");
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
                Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationBPPage(), waiter, driver);
            }
        }
    }
}
