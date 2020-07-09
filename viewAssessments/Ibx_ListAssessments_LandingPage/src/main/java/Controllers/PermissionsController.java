package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.AssessmentViewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//Controllers class for PermissionsController
public class PermissionsController {
    public static AssessmentViewPage assessmentViewPage = new AssessmentViewPage();

    //Method to Search User
    public static void searchForUser(String firstName, String lastName) {
        DriverHelper.clickXpath(assessmentViewPage.getScopeSelector());
        DriverHelper.waitUntil(assessmentViewPage.getUserButton());
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(assessmentViewPage.getUserGrantee()));
        Actions actions = new Actions(BrowserInitHelper.getInstance());
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(firstName + " " + lastName + Keys.ENTER);
        element = BrowserInitHelper.getInstance().findElement(By.xpath(assessmentViewPage.getUserButton()));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
        DriverHelper.waitUntil(assessmentViewPage.getAdminPermissinHeader());


        for (int i = 1; i <= BrowserInitHelper.getInstance().findElements(By.xpath(assessmentViewPage.getTbody())).size(); i++) {
            String text = DriverHelper.getText("//tbody/tr[" + Integer.toString(i) + "]/td/div");
            if (text.contains("Create Demographics") || text.contains("Create Summary Assessments") || text.contains("Create Surveys") || text.contains("Create Assessment Views")) {
                System.out.println(Integer.toString(i) + " " + text);
                DriverHelper.clickXpath("//tbody/tr[" + Integer.toString(i) + "]/td[2]/label/input");
            }
        }
        DriverHelper.clickXpath(assessmentViewPage.getSave());
    }
}