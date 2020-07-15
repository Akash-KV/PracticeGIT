package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.Dashboard;
import Utils.ConsoleLogger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DashBoardController {
    Dashboard dashboardPOM = new Dashboard();

    public DashBoardController() {
        dashboardPOM.readProperties();
    }


    public void validateDashBoard() {
        System.out.println(dashboardPOM.getIlluminateLogo());
        String TitleTile;
        boolean isExist = false;

        /*Wait till Illuminate Logo appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getIlluminateLogo());

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = BrowserInitHelper.getInstance().findElements(By.xpath(dashboardPOM.getDashboardTileTitleElement()));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            TitleTile = TileTitleElement.get(i).getText().replaceAll("\n", " ");

            /*Validate if View Assessment tile is showing or not*/
            if (TitleTile.equalsIgnoreCase("View Assessments")) {
                isExist = true;
                ConsoleLogger.SuccessLog("View Assessments displayed in dashboard...");
                break;
            }
        }
        TileTitleElement = null;
        //Assert.assertTrue(isExist);
    }

    public void clickNavBar() {
        DriverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());
    }

    public void validateNavBar() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboardPOM.getAssessmentsModal())));
        Assert.assertTrue(DriverHelper.elementExistenceXpath(dashboardPOM.getAssessmentsModal()));
    }

    public void navigateToItemBankAssessment() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboardPOM.getCreateAssessmentLink())));
        DriverHelper.clickXpath(dashboardPOM.getCreateAssessmentLink());

        /*Click Item Bank*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboardPOM.getCreateItemBankLink())));
        DriverHelper.clickXpath(dashboardPOM.getCreateItemBankLink());
    }


}
