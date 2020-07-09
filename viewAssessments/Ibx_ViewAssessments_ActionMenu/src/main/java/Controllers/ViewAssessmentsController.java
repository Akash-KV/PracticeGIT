package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.ViewAssessmentsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

//ViewAssessmentsController controller class
public class ViewAssessmentsController {
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    public static String mainWindow;

    public static boolean getElementBackgroundColor(String ID, WebDriver driver, String expectedBackgroundColor) {
        String actualBackgroundColor = driver.findElement(By.xpath("//*[@id = '" + ID + "']/following-sibling::label")).getCssValue("background-color");

        if (actualBackgroundColor.equalsIgnoreCase(expectedBackgroundColor)) {
            return true;
        } else {
            return false;
        }
    }

    //Clicking on Action Dropdown
    public void clickActionOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getActionDropDownOption(option));
    }

    //Clicking on ItemBank Delete Dropdown
    public void clickDraftItemBankOptionDelete(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDelete());
    }

    //Clicking on Draft ItemBank edit Dropdown
    public void clickDraftitemBankOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getDraftItembankDropDownOptionEdit(option));
    }

    //Clicking on Draft ItemBank edit Dropdown
    public void clickDeleteOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDelete());
    }

    public void clickDuplicateOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDuplicate());
    }

    //Clicking on ItemBank Share Dropdown
    public void clickShareOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getItemBankActionMenuOptionsShare());
    }

    //Clicking on ItemBank ViewResult Dropdown
    public void clickViewResultOption(String Option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsViewResult());
    }

    //Clicking on ItemBank Scan Dropdown
    public void clickScanOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsScan());
    }

    //Clicking on ItemBank Preview Dropdown
    public void clickPreviewOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsPreview());
    }

    public void clickAssessmentsActionOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getAssessmentActionDropDownOptions(option));
    }

    //Clicking on Assessment Delete Dropdown
    public void clickAssessmentsDeleteOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDelete());
    }

    //Clicking on Assessment Duplicate Dropdown
    public void clickAssessmentsDuplicateOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDuplicate());
    }

    //Clicking on Assessment Share Dropdown
    public void clickAssessmentsShareOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getItemBankActionMenuOptionsShare());
    }

    //Clicking on Assessment ViewResult Dropdown
    public void clickAssessmentsViewResultOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsViewResult());
    }

    //Clicking on Assessment Scan Dropdown
    public void clickAssessmentsScanOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsScan());
    }

    //Clicking on Assessment Preview Dropdown
    public void clickAssessmentsPreviewOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsPreview());
    }

    //Clicking on Assessment Administer Dropdown
    public void clickAssessmentsAdministerOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsAdminister());
    }

    public void clickFlexibleActionOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getFlexibleActionDropDownOptions(option));
    }

    //Clicking on Flexible Delete Dropdown
    public void clickFlexibleDeleteOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDelete());
    }

    //Clicking on Flexible Duplicate Dropdown
    public void clickFlexibleDuplicateOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDuplicate());
    }

    //Clicking on Flexible Share Dropdown
    public void clickFlexibleShareOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getItemBankActionMenuOptionsShare());
    }

    //Clicking on Flexible ViewResult Dropdown
    public void clickFlexibleViewResultOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsViewResult());
    }

    //Clicking on Flexible ViewResult Dropdown
    public void clickFlexibleView_ResultOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsViewResult());
    }

    //Clicking on Flexible Scan Dropdown
    public void clickFlexibleScanOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsScan());
    }

    //Clicking on Flexible Preview Dropdown
    public void clickFlexiblePreviewOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsPreview());
    }

    //Clicking on Flexible Administer Dropdown
    public void clickFlexibleAdministerOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsAdminister());
    }

    public void clickFluenceActionOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getFluenceActionDropDownOptions(option));
    }

    public void clickSurveyActionOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getSurveyActionDropDownOptions(option));
    }

    public void clickDemographicsScanOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsScan());
    }

    public void clickDemographicsActionOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getDemographicsActionDropDownOptions(option));
    }

    public void clickDemographicsViewResultOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsViewResult());
    }

    public void clickDemographicsAdministerOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsAdminister());
    }

    //Clicking on Summary Dropdown
    public void clickSummaryActionOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getSummaryActionDropDownOptions(option));
    }

    //Clicking on Summary Duplicate Dropdown
    public void clickSummaryDuplicateOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDuplicate());
    }

    //Clicking on Summary Share Dropdown
    public void clickSummaryShareOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getItemBankActionMenuOptionsShare());
    }

    //Clicking on Summary ViewResult Dropdown
    public void clickSummaryViewResultOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsViewResult());
    }

    //Clicking on Summary Scan Dropdown
    public void clickSummaryScanOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsScan());
    }

    //Clicking on Summary Administer Dropdown
    public void clickSummaryAdministerOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsAdminister());
    }

    //Clicking on AssessmentView Dropdown
    public void clickAssessmentViewActionOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getAssessmentViewActionDropDownOptions(option));
    }

    //Clicking on AssessmentView Delete Dropdown
    public void clickAssessmentViewDeleteOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDelete());
    }

    //Clicking on AssessmentView Duplicate Dropdown
    public void clickAssessmentViewDuplicateOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDuplicate());
    }

    //Clicking on AssessmentView Share Dropdown
    public void clickAssessmentViewShareOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getItemBankActionMenuOptionsShare());
    }

    //Clicking on SkillsAssessment Dropdown
    public void clickSkillsAssessmentActionOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getSkillsAssessmentActionDropDownOptions(option));
    }

    //Clicking on SkillsAssessment Duplicate Dropdown
    public void clickSkillsAssessmentDuplicateOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getitemBankActionMenuOptionsDuplicate());
    }

    //Clicking on PFTAssessment Dropdown
    public void clickPFTAssessmentActionOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getPFTAssessmentActionDropDownOptions(option));
    }

    //Clicking on PFTAssessment Share Dropdown
    public void clickPFTAssessmentShareOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getItemBankActionMenuOptionsShare());
    }

    //Clicking on PFTAssessment Student Response Dropdown
    public void clickPFTAssessmentStudentResponseOption(String option) {
        DriverHelper.clickXpath(viewAssessmentsPage.getPFTAssessmentStudentResponseDropdownOption());
    }

    // WindowHandle and SwitchWindow method
    public static void getWindowHandleAndSwitchWindow(WebDriver driver) {
        mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();

        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String childWindow = itr.next();

            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

    //method for verifyPreviewWindowElement
    public boolean verifyPreviewWindowElement(WebElement beginTestButton, WebDriver driver) {
        boolean isExist = DriverHelper.elementExistence(beginTestButton, driver);
        return isExist;
    }

    //method for switchToMainWindow
    public static void switchToMainWindow(WebDriver driver) {
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    //method for selectFewAssessments
    public static void selectFewAssessments(int assessmentCount, List<WebElement> assessmentCheckBoxes) {
        /*Select few Assessments*/
        for (int i = 0; i < assessmentCount; i++) {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(assessmentCheckBoxes.get(i)));
            assessmentCheckBoxes.get(i).click();
        }
    }
}
