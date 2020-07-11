package Controllers;

import Helpers.BrowserInitHelper;
import Pom.Dashboard;
import Pom.ViewAssessmentsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

//Controller class for Dashboard controller
public class DashboardController {
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    Dashboard dashboardPOM = new Dashboard();


    //Validate Dashboard
    public void dashboard() {
        String TitleTile;
        boolean isExist = false;

        /*Wait till Illuminate Logo appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getIlluminateLogo());
        checkPopup();
        //Check the Popup

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = BrowserInitHelper.getInstance().findElements(By.xpath("//ul[@id = 'tile-holder']/li//div[@class = 'tile-title']"));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            TitleTile = TileTitleElement.get(i).getText().replaceAll("\n", " ");

            /*Validate if View Assessment tile is showing or not*/
            if (TitleTile.equalsIgnoreCase("View Assessments")) {
                isExist = true;
                break;
            }
        }
        TileTitleElement = null;
        Assert.assertTrue(isExist);
    }

    //Validate Assessments Dashboard
    public void validateAssessmentsDashboard() {
        String TitleTile;
        boolean isExist = false;

        /*Wait until Dashboard header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getDasdhboardHeader());

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = BrowserInitHelper.getInstance().findElements(By.xpath("//ul[@id = 'tile-holder']/li//div[@class = 'tile-title']"));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            TitleTile = TileTitleElement.get(i).getText().replaceAll("\n", " ");

            /*Validate if View Assessment tile is showing or not*/
            if (TitleTile.equalsIgnoreCase("View Assessments")) {
                isExist = true;
                break;
            }
        }
        TileTitleElement = null;
        Assert.assertTrue(isExist);
    }

    public void checkPopup() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getPopup())));
            WebElement popup = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getPopup()));
            Actions action = new Actions(BrowserInitHelper.getInstance());
            action.moveToElement(popup).click().perform();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled for alert popup.......");
        }
    }
}
