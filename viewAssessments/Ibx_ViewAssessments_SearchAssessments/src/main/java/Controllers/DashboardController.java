package Controllers;

import Helpers.BrowserInitHelper;
import Pom.DashboardPage;
import Pom.ViewAssessmentsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Controller class for Dashboard
 **/
public class DashboardController {

    DashboardPage dashboardPagePOM = new DashboardPage();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();

    //Validate Dashboard
    public void dashboard() {
        //String TitleTile;
        boolean isExist = false;

        /*Wait till Illuminate Logo appears*/
        BrowserInitHelper.waitUntil(dashboardPagePOM.getIlluminateLogo());
        checkPopup();

        if (BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPagePOM.getDashboardBody())).isDisplayed()) {
            isExist = true;
        }
        Assert.assertTrue(isExist);
    }

    //Check for the Popup
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
