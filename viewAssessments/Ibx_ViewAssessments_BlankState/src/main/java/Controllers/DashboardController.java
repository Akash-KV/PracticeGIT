package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.DashboardPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Helpers.BrowserInitHelper.getInstance;

public class DashboardController {
    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();
    DashboardPage dashboardPage = new DashboardPage();

    // To validate dashboard
    public void validateDashboard() {
        String TitleTile;
        boolean isExist = false;

        /*Wait till Illuminate Logo appears*/
        BrowserInitHelper.waitUntil(dashboardPage.getIlluminateLogo());
        viewAssessmentsController.checkPopup();

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = getInstance().findElements(By.xpath("//ul[@id = 'tile-holder']/li//div[@class = 'tile-title']"));

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

    // To click viewAssessments Tile
    public void clickViewAssessmentsTile() {
        String TitleTile;

        /*Get all the Titles shown in Dashboard flip cards*/

        List<WebElement> TileTitleElement = getInstance().findElements(By.xpath("//ul[@id = 'tile-holder']/li//div[@class = 'tile-title']"));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            TitleTile = TileTitleElement.get(i).getText().replaceAll("\n", " ");

            /*Validate if View Assessment tile is showing or not*/
            if (TitleTile.equalsIgnoreCase("View Assessments")) {
                TileTitleElement.get(i).click();
                break;
            }
        }

        /*Wait until loading icon disappears*/
        viewAssessmentsController.checkPopup();
        DriverHelper.waitUntilLoaderInvisible();
    }
}
