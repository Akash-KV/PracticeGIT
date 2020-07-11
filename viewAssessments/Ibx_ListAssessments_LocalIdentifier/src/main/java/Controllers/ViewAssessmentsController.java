package Controllers;

import DataReaders.CSVDataReaderLocalIdentifier;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.ViewAssessmentsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.JavascriptHelper.waitUntilAjaxLoaded;

public class ViewAssessmentsController {

    Dashboard dashboard = new Dashboard();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    CSVDataReaderLocalIdentifier csvDataReaderLocalIdentifier = new CSVDataReaderLocalIdentifier();

    // To Navigate ViewAssessments Page
    public void navigateToViewAssessments() {
        DriverHelper.clickXpath(dashboard.getAssessmentsNav());
        DriverHelper.clickXpath(dashboard.getViewAssessmentsLink());
    }

    // To validate ViewAssessments page
    public void verifyViewAssessments() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboard.getViewAssessmentsHeader())));
        boolean header = DriverHelper.checkElementDisplayByXpath(dashboard.getViewAssessmentsHeader(), "ViewAssessment");
        Assert.assertTrue(header);
    }

    // To Search Manual Hybrid
    public void selectManualHybridType() {
        AddFilterController.clearSearch(csvDataReaderLocalIdentifier.getManualHybridAssessment());
        AddFilterController.toggleOff();
    }

    // To Validate Manual Hybrid Assessment
    public void verifyManualHybridLocalIdentifier() {
        boolean title = AddFilterController.isElementClickable(viewAssessmentsPage.getFirstLinkAfterSearch(), "Manualhybrid Assessment Title");
        Assert.assertTrue(title);
        boolean ID = AddFilterController.isElementNotClickable(viewAssessmentsPage.getLocalidentifierforfirstlink(), "Manualhybrid Assessment Local Identifier");
        Assert.assertTrue(ID);
    }

    // To search Flexible Assessment
    public void selectFlexibleType() {
        AddFilterController.clearSearch(csvDataReaderLocalIdentifier.getFlexibleAssessment());
        AddFilterController.toggleOff();
    }

    // To validate Flexible Assessment
    public void verifyFlexibleLocalIdentifier() {
        boolean title = AddFilterController.isElementClickable(viewAssessmentsPage.getFirstLinkAfterSearch(), "Flexible Assessment Title");
        Assert.assertTrue(title);
        boolean ID = AddFilterController.isElementNotClickable(viewAssessmentsPage.getLocalidentifierforfirstlink(), "Flexible Assessment Local Identifier");
        Assert.assertTrue(ID);
    }

    // To turn off toggle button
    public void turnOFFToggleButton() {
        if (JavascriptHelper.getToggleButtonState(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton()).equalsIgnoreCase("true")) {
            /*Click Show Assessments Without Data toggle button*/
            JavascriptHelper.ClickByID_Javascript(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton());


        }
    }

    // To clear added filter
    public void clearAddedFilter() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getClearAllFilters())))).click();
            waitUntilAjaxLoaded();
        } catch (Exception e) {
            System.out.println("Exception handled for clear all link...");
        }
    }

    // To clear search text box
    public void clearSearchTextBox() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchTextBox()))).clear();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextboxButton()))).click();
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),viewAssessmentsPage.getViewAssessmentPageHeader());

        } catch (Exception e) {
            System.out.println("Exception handled for clearing search text box");
        }
    }
}
