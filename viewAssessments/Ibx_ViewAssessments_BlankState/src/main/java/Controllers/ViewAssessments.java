package Controllers;

import Helpers.BrowserInitHelper;
import Pom.ViewAssessmentsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

//  Controller class For ViewAssessments
public class ViewAssessments {

    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();

    //  To get background color of toggle Button
    public static boolean getElementBackgroundColor(String ID, WebDriver driver, String expectedBackgroundColor) {
        String actualBackgroundColor = driver.findElement(By.xpath("//*[@id = '" + ID + "']/following-sibling::label")).getCssValue("background-color");

        System.out.println("Expected Color :" + expectedBackgroundColor);
        System.out.println("Actual Color :" + actualBackgroundColor);

        if (actualBackgroundColor.equalsIgnoreCase(expectedBackgroundColor)) {
            return true;
        } else {
            return false;
        }
    }

    // To Handle Popup
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
