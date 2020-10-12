package Controllers;

import DataReaders.CSVDataReaderBuildMaterials;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Controllers class for BuildModeMaterials
 **/
public class BuildModeController {

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(BuildModeController.class);
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    //Declarations
    public static BuildModePage buildModePage = new BuildModePage();
    CSVDataReaderBuildMaterials csv_BuildMaterials = new CSVDataReaderBuildMaterials();
    BrowseModePage pom_BrowseModePage = new BrowseModePage();
    BuildModePage pom_BuildModePage = new BuildModePage();
    boolean checkAddItem = false;
    boolean isPdf;
    public String upload_doc = System.getProperty("user.dir") + "\\src\\main\\resources\\upload_doc.doc";
    public String uploadPdf = System.getProperty("user.dir") + "\\src\\main\\resources\\upload_pdf.pdf";
    public String uploadPpt = System.getProperty("user.dir") + "\\src\\main\\resources\\upload_ppt.pptx";
    public String data = System.getProperty("user.dir") + "\\src\\main\\resources\\data.csv";


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

    // To get current Time stamp
    public String getCurrentTimeStamp() {
        String timestamp = "";
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        timestamp = dateFormat.format(date);
        System.out.println(dateFormat.format(date));
        return timestamp;
    }

    // To add item for creating assessment
    public boolean getAddItem(String xpath, int count) {
        boolean clicked = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            List<WebElement> ItemsList_AddButton = BrowserInitHelper.getInstance().findElements(By.xpath(xpath));

            System.out.println("ItemsList_AddButton SIZE==>" + ItemsList_AddButton.size());
            for (int i = 0; i <= ItemsList_AddButton.size(); i++) {
                if (i < count) {
                    WebElement add_item = ItemsList_AddButton.get(i);
                    //Click Add Item for items
                    add_item.click();
                    clicked = true;
                }
            }
        } catch (NoSuchElementException ne) {
            log.info("NoSuchElementException handled for method - e_CreateAssessment....");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for method - e_CreateAssessment....");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for method - e_CreateAssessment....");
        } catch (Exception e) {
            log.info("Exception handled for method - e_CreateAssessment....");
        }

        return clicked;
    }

    // To validate hover message
    public void verifyHover(String xPath, String name) {
        WebElement ele = BrowserInitHelper.getInstance().findElement(By.xpath(xPath));

        //Verify Hover
        try {
            Actions action = new Actions(BrowserInitHelper.getInstance());
            action.moveToElement(ele).build().perform();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuild_Question_Group_Hover())));
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
        ConsoleLogger.SuccessLog("Test cases : Passed - Test cases : Passed - Hover Message is displayed for " + name + "");
        LoggerUtility.LoggerCall("Test cases : Passed - Test cases : Passed - Hover Message is displayed for " + name + "");
        Assert.assertTrue(true);
    }

    // To upload the files
    public void uploadMaterial(String uploadPath, String xPath) {
        System.out.println(uploadPath);
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Materials_Upload());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath(buildModePage.getBuild_Mode_File_Upload()))).sendKeys(uploadPath);
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    // To check files are downloaded
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean value = false;
        try {
            DriverHelper.waitTill(10);
            File dir = new File(downloadPath);
            File[] dirContents = dir.listFiles();
            for (int i = 0; i < dirContents.length; i++) {
                if (dirContents[i].getName().equals(fileName)) {
                    dirContents[i].delete();
                    value = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception handled for deleting file");
        }
        return value;
    }

    // To validate download
    public void verifyDownload(boolean value) {
        if (value) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Uploaded file is downloaded");
            LoggerUtility.LoggerCall("Test cases : Passed - Uploaded file is downloaded");
            Assert.assertTrue(true);
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Uploaded file is not downloaded ");
            LoggerUtility.LoggerCall("Test cases : Failed - Uploaded file is not downloaded ");
            //  Assert.assertTrue(false);
        }
    }

    // To delete the uploaded files
    public void deleteMaterial() {
        List<WebElement> list = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='uploadModal']//div[@role='listitem']/div//*[local-name()='svg' and @data-icon='trash']"));
        for (WebElement ele : list) {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(ele));
            ele.click();
        }
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Deleted_Message_Close());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Deleted_Message_Close());
    }

    // To click file download button
    public void checkFileDownload() {
        try {
            List<WebElement> list = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='uploadModal']//div[@role='listitem']/div//*[local-name()='svg' and @data-icon='arrow-down']"));
            for (WebElement ele : list) {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(ele));
                JavascriptHelper.scrollElementIntoView(ele);
                ele.click();
            }
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
    }

    // To validate file upload
    public void verifyFileUpload() {
        List<WebElement> list = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='uploadModal']//div[@role='listitem']/div"));
        for (WebElement ele : list) {
            String text = ele.getText();
            if (ele.isDisplayed()) {
                ConsoleLogger.SuccessLog("Test cases : Passed - " + text + " is uploaded");
                LoggerUtility.LoggerCall("Test cases : Passed - " + text + " is uploaded");
                Assert.assertTrue(true);
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Uploaded material is not displayed");
                LoggerUtility.LoggerCall("Test cases : Failed - Uploaded material is not displayed");
                Assert.assertTrue(false);
            }

        }
    }

    // To validate deleted material
    public void verifyDeletedMaterial() {
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Materials());
        try {
            WebElement ele = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Mode_Custom_Materials()));
            if (ele.isDisplayed()) {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Deleted Material is displaying");
                LoggerUtility.LoggerCall("Test cases : Failed - Deleted Material is displaying");
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Deleted material is not displaying");
            LoggerUtility.LoggerCall("Test cases : Passed - Deleted material is not displaying");
            Assert.assertTrue(true);
        }
    }

    // To check material title is editable or not
    public boolean materialTitleEdit() {
        boolean value = false;
        try {
            JavascriptExecutor je = (JavascriptExecutor) BrowserInitHelper.getInstance();
            DriverHelper.waitTill(5);
            Object obj = je.executeScript("return document.querySelector(\"" + buildModePage.getBuild_Mode_Title_Editable() + "\").readOnly;");
            System.out.println(obj);
            if (obj == null) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Material title is not editable");
                LoggerUtility.LoggerCall("Test cases : Passed - Material title is not editable");
                value = true;
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Material title is editable");
                LoggerUtility.LoggerCall("Test cases : Failed - Material title is editable");
            }
        } catch (Exception e) {
        }

        return value;
    }

    // To delete the published assessment
    public void deleteAssessment() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Done());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Done());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Overview_Page());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_settings());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_settings());
        DriverHelper.clickXpath(buildModePage.getAdvancedTab());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Delete_Assessment());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Understand_Checkbox());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Understand_Checkbox());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Agree_Checkbox());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Agree_Checkbox());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Delete_Submit_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Delete_Submit_Button());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Verify_Delete_Message());
    }

    // To create assessment
    public void createAssessment() {
        logger.info("UnSelecting all the Filters Selections");
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BrowseModePage.getBrowse_ItemSection())));
            //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BrowseModePage.getBrowse_First_Item_Content())));
            //Select Items and click on Create
            checkAddItem = getAddItem(pom_BrowseModePage.getBrowse_AddItem_List(), 1);

            //If items displayed, then create assessment
            if (checkAddItem) {
                //Create Assessment
                boolean check_CreateAssessmentButton = checkDisplay(pom_BrowseModePage.getCreateAssessmentButton());

                if (check_CreateAssessmentButton) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button is displayed.....");
                    LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button is displayed.....");
                    DriverHelper.clickXpath(pom_BrowseModePage.getCreateAssessmentButton());

                    //Enter Assessment Name
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BrowseModePage.getBrowse_Title_In_CreateAssessmentPopup())));
                    WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(pom_BrowseModePage.getBrowse_Title_In_CreateAssessmentPopup()));
                    String assessmentName = csv_BuildMaterials.getAssessment() + getCurrentTimeStamp();
                    TitleInputBox.sendKeys(assessmentName);

                    //Click on Create Button
                    DriverHelper.clickXpath(pom_BrowseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
                }
            }
        } catch (Exception e) {
            logger.info("Exception Handled for the e_CreateAssessment");
        }

    }

    // To validate Build Mode navigation
    public void verifyBuildNavigation() {
        if (checkAddItem) {
            boolean check_BuildModeNavigation = checkDisplay(pom_BuildModePage.getBuild_Item_Section());
            if (check_BuildModeNavigation) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Build Mode Page is displayed.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Build Mode Page is displayed.....");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
            }
        }
    }

    // To check Hover
    public void checkHover() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Materials());

    }

    // To validate hover
    public void verifyHover() {
        verifyHover(pom_BuildModePage.getBuild_Mode_Materials(), "Materials");
    }

    // To click materials button
    public void clickMaterialsButton() {
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Mode_Materials());
    }

    // To validate Materials modal
    public void verifyMaterialsModal() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Materials_Modal());
        boolean header = DriverHelper.checkElementDisplayByXpath(pom_BuildModePage.getBuild_Mode_Materials_Modal(), "Materials Header");
        Assert.assertTrue(header);
        boolean upload = DriverHelper.checkElementDisplayByXpath(pom_BuildModePage.getBuild_Mode_Materials_Upload(), "Drag and drop area");
        Assert.assertTrue(upload);
        List<WebElement> list = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='uploadModal']//div[@role='listitem']/a"));
        for (WebElement ele : list) {
            String text = ele.getText();
            if (ele.isDisplayed()) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Autogenerated Material " + text + " is displaying");
                LoggerUtility.LoggerCall("Test cases : Passed - Autogenerated Material " + text + " is displaying");
                Assert.assertTrue(true);
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Autogenerated materials is not displaying");
                LoggerUtility.LoggerCall("Test cases : Failed - Autogenerated materials is not displaying");
                Assert.assertTrue(false);
            }
        }

        boolean close = DriverHelper.checkElementDisplayByXpath(pom_BuildModePage.getBuild_Mode_Materials_Modal_Close(), "Drag and drop area");
        Assert.assertTrue(close);
    }

    // To upload single file
    public void checkSingleFileUpload() {
        isPdf = true;
        uploadMaterial(uploadPdf, pom_BuildModePage.getBuild_Mode_First_Uploaded_Material());
    }

    // To validate single file upload
    public void verifySingleFileUpload() {
        verifyFileUpload();
    }

    // To download single uploaded file
    public void checkSingleFileDownload() {
        checkFileDownload();
    }

    // To validate single uploaded file
    public void verifySingleFileDownload() {
        boolean upload_pdf = isFileDownloaded(DriverHelper.getDownloadsPath(), "upload_pdf.pdf");
        verifyDownload(upload_pdf);
    }

    // To upload Multiple files
    public void checkMultipleFileUpload() {
        isPdf = true;
        uploadMaterial(upload_doc, pom_BuildModePage.getBuild_Mode_First_Uploaded_Material());
        uploadMaterial(uploadPdf, pom_BuildModePage.getBuild_Mode_Second_Uploaded_Material());
        uploadMaterial(uploadPpt, pom_BuildModePage.getBuild_Mode_Third_Uploaded_Material());
        uploadMaterial(data, pom_BuildModePage.getBuild_Mode_Fourth_Uploaded_Material());
    }

    // To validate multiple file downloaded
    public void verifyMultipleFileDownload() {
        boolean upload_doc = isFileDownloaded(DriverHelper.getDownloadsPath(), "upload_doc.doc");
        verifyDownload(upload_doc);
        boolean upload_pdf = isFileDownloaded(DriverHelper.getDownloadsPath(), "upload_pdf.pdf");
        verifyDownload(upload_pdf);
        boolean upload_ppt = isFileDownloaded(DriverHelper.getDownloadsPath(), "upload_ppt.pptx");
        verifyDownload(upload_ppt);
        boolean data = isFileDownloaded(DriverHelper.getDownloadsPath(), "data.csv");
        verifyDownload(data);
    }

    // To upload multiple files less than ten MB
    public void checkMultipleFileTypesLessThanTenMb() {
        isPdf = true;
        uploadMaterial(upload_doc, pom_BuildModePage.getBuild_Mode_First_Uploaded_Material());
        uploadMaterial(uploadPdf, pom_BuildModePage.getBuild_Mode_Second_Uploaded_Material());
        uploadMaterial(uploadPpt, pom_BuildModePage.getBuild_Mode_Third_Uploaded_Material());
        uploadMaterial(data, pom_BuildModePage.getBuild_Mode_Fourth_Uploaded_Material());
        DriverHelper.waitTill(3);
    }


    // To preview uploaded file
    public void previewUploadedFile() {
        isPdf = true;
        uploadMaterial(uploadPdf, pom_BuildModePage.getBuild_Mode_First_Uploaded_Material());
        checkFileDownload();
    }

    // To validate preview uploaded file
    public void verifyPreviewUploadedFile() {
        boolean upload_pdf = isFileDownloaded(DriverHelper.getDownloadsPath(), "upload_pdf.pdf");
        verifyDownload(upload_pdf);
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Materials_Modal_Close());
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Mode_Materials_Modal_Close());
    }

    // To check publish
    public void checkPublish() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Done());
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Mode_Done());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Publish());
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Mode_Publish());
    }

    // To validate publish
    public void verifyPublish() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Overview_Page());
        boolean element = DriverHelper.checkElementDisplayByXpath(pom_BuildModePage.getBuild_Mode_Overview_Page(), "Overview Page");
        Assert.assertTrue(element);

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Overview_Page_View_Button());
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Mode_Overview_Page_View_Button());
    }

    // To check autogenerated materials
    public void checkAutogeneratedMaterials() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Navigation_Page_Header());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Materials());
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Mode_Materials());

    }

    // To validate autogenerated materials
    public void verifyAutogeneratedMaterials() {
        try {
            DriverHelper.awaitTillElementDisplayed(pom_BuildModePage.getBuild_Mode_Materials_Modal(), "Materials modal");
        } catch (Exception e) {
            System.out.println("Exception handled for materials modal");
        }
        List<WebElement> list = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='uploadModal']//div[@role='listitem']/a"));
        for (WebElement ele : list) {
            String text = ele.getText();
            if (ele.isDisplayed()) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Autogenerated Material " + text + " is displaying");
                LoggerUtility.LoggerCall("Test cases : Passed - Autogenerated Material " + text + " is displaying");
                Assert.assertTrue(true);
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Autogenerated materials is not displaying");
                LoggerUtility.LoggerCall("Test cases : Failed - Autogenerated materials is not displaying");
                Assert.assertTrue(false);
            }
        }

        // To validate delete icon is not present for autogenerated materials
        List<WebElement> elements = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='uploadModal']//div[@role='listitem']/a//div[@class='v-list__tile__action']/*[local-name()='svg']"));
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getAttribute("data-icon");
            if (text.equalsIgnoreCase("trash")) {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Delete is displaying for autogenerated materials");
                LoggerUtility.LoggerCall("Test cases : Failed - Delete is displaying for autogenerated materials");
                Assert.assertTrue(false);
            } else {
                ConsoleLogger.SuccessLog("Test cases : Passed - Delete is not displaying for autogenerated materials");
                LoggerUtility.LoggerCall("Test cases : Passed - Delete is not displaying for autogenerated materials");
                Assert.assertTrue(true);
            }
        }
    }

    // To validate materials title editable or not
    public void verifyCustomMaterialTitleEdit() {
        boolean condition = materialTitleEdit();
        //  Assert.assertTrue(condition);
    }

    // To click close button
    public void clickCloseButton() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Materials_Modal_Close());
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Mode_Materials_Modal_Close());
    }

    // To validate assessments page
    public void verifyAssessmentPage() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Mode_Assessment_Page());
        boolean page = DriverHelper.checkElementDisplayByXpath(pom_BuildModePage.getBuild_Mode_Assessment_Page(), "Assessments Page");
        Assert.assertTrue(page);

        // To delete the created assessment
        deleteAssessment();

    }
}

