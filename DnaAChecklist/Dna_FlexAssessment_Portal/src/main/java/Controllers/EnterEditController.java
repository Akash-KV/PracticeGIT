package Controllers;

import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Controllers class for EnterEdit
 **/
public class EnterEditController {
    private static WebElement element;
    private static Actions actions;
    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

    // To get students with data
    public static void getStudentsWithData(WebDriverWait waiter, WebDriver driver) {
        element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationviewType()));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Students With Data");
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFindStudents(), waiter, driver);
    }

    // To set response score
    public static void setResponseScore(int question, int scoreIndex, WebDriverWait waiter, WebDriver driver) {
        Helper.wait(0.25);
        actions = new Actions(driver);
        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[@id='grid-container']//tr//td[" + Integer.toString(question + 5) + "]")));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[" + Integer.toString(scoreIndex) + "]")));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }
}
