package Controllers;

import org.graphwalker.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//controller class for FlexOverview
public class FlexOverviewController {
    //method to waitUntilDonutAppears
    public static void waitUntilDonutAppears(String expectedScore, WebDriverWait waiter, WebDriver driver) {
        String currentUrl = driver.getCurrentUrl();
        currentUrl = currentUrl.substring(0, currentUrl.length() - 6);
        int i = 0;
        while (driver.findElements(By.xpath("//a[contains(text(),'" + expectedScore + "')]")).size() == 0) {
            if (i == 75) {
                break;
            }
            try {
                Helper.wait(1.0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.navigate().refresh();
            driver.get(currentUrl);
            i++;
        }
        Helper.assertionText("//a[contains(text(),'" + expectedScore + "')]", expectedScore, waiter, driver);
    }
}
