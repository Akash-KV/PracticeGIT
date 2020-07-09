import Controllers.ViewAssessmentsController;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.*;
import Utils.ConsoleLogger;
import Utils.DataReader;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Utils.Config;

import java.util.ArrayList;
import java.util.List;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ViewAssessmentsUnpublishedDropDownOptionsTest extends ExecutionContext implements ViewAssessmentsUnpublishedDropDownOptions {
    LoginPage loginPOM = new LoginPage();
    Dashboard dashboardPOM = new Dashboard();
    BrowserInitHelper browserHelper = new BrowserInitHelper();
    DataReader reader = new DataReader();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();

    public void v_VerifyUnpublishedItemBankHeader() {
        /*Wait until Unpublished Item Bank header is visible*/
        BrowserInitHelper.waitUntil(viewAssessmentsPage.getUnpublishedItemBankHeader());

        /*Validate the existence of Assessement Change Author modal*/
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getUnpublishedItemBankHeader()));
        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    public void e_ClickActionDropDown() {
        /*Click Action drop down*/
        DriverHelper.clickXpath(viewAssessmentsPage.getUnpublishedItemBankLink());
        DriverHelper.waitUntilLoaderInvisible();
        DriverHelper.clickXpath(viewAssessmentsPage.getActionDropDown());
    }

    public void v_VerifyActionDropDownOptions() {
        ConsoleLogger.DebugLog("No Dropdown Available here");
    }

    public void e_ClickActionDropDownAndSelectEditOption() {
        /*Click Edit option*/
        viewAssessmentsController.clickDraftitemBankOption("Edit");
    }

    public void v_VerifyItemBankAssessmentCreationWizard() {

    }

    public void e_ClickReturnToIlluminate() {
        /*Click Return to Illuminate icon*/
        DriverHelper.clickXpath(viewAssessmentsPage.getReturnToIlluminateIcon());
    }

    public void e_ClickActionDropDownAndSelectDeleteOption() {
        /*Click Edit option*/
        viewAssessmentsController.clickDraftItemBankOptionDelete("Delete");
    }

    public void v_VerifyViewAssessments() {
        /*Validate the display of View Assessments header*/
        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
    }

    public void e_ClickUnpublishedItemBank() {
        /*Click Unpublished Item Bank link*/
        DriverHelper.clickXpath(viewAssessmentsPage.getUnpublishedItemBankLink());
    }

    public void v_VerifyAssessmentDeleteModal() {
        /*Validate the existence of Assessment Delete alert*/
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getDeleteAlertMessage()));
        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    public void e_ClickDeleteButton() {
        /*Check Yes, I am sure that the assessment is the one I want to delete checkbox*/
        //DriverHelper.clickXpath(viewAssessmentsPage.getDeleteUnderstandCheckbox());

        /*Yes, Delete the assessment.*/
        //DriverHelper.clickXpath(viewAssessmentsPage.getDeleteAgreeCheckbox());

        /*Click Delete Assessment button*/
        //DriverHelper.clickXpath(viewAssessmentsPage.getDeleteAssessementButton());
    }

    public void v_VerifyAssessmentDelete() {
//        /*Validate the existence of Assessment Delete success message*/
//        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getAlertSuccess()));
//        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    public void e_ClickViewAssessments() {
        /*Click Assessments icon in Navigation sidebar*/
        DriverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());

        /*Click View Assessments Link*/
        DriverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
        ConsoleLogger.SuccessLog("Completed the ViewAssessmentsUnpublishedDropDownOptionsTest Java class");
    }
}
