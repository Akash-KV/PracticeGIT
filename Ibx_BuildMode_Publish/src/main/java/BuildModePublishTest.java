
import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModePublish
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModePublishTest extends ExecutionContext implements BuildModePublish {
    BrowseModeController browseModeController = new BrowseModeController();
    BuildModeController buildModeController = new BuildModeController();

    //Validate BrowseModeAddItem
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    //Click on create assessment
    public void e_CreateAssessment() {
        buildModeController.e_CreateAssessment();
    }

    //Validate Build Navigation Done Button
    public void v_VerifyBuildNavigationAndDoneButton() {
        buildModeController.verifyBuildNavigationAndDoneButton();
    }

    //click on Done button
    public void e_ClickOnDoneButton() {
        buildModeController.clickDone();
    }

    //Validate Done options
    public void v_VerifyDoneButtonOptions() {
        buildModeController.verifyDoneButtonOptions();
    }

    //Click on Discard changes
    public void e_ClickOnDiscardChangesButton() {
        buildModeController.clickOnDiscardChangesButton();
    }
    //validate return to browse item page

    public void v_VerifyReturnToBrowseItemPage() {
        buildModeController.verifyReturnToBrowseItemPage();
    }

    //Click on save Draft button
    public void e_ClickOnSaveDraft() {
        buildModeController.clickOnSaveDraft();
    }

    //Validate Navigate to view Assessment Page
    public void v_VerifyNavigateToViewAssessment() {
        buildModeController.verifyNavigateToViewAssessment();
    }

    //Click on Navigate to Browse mode
    public void e_ClickOnNavigateToBrowseMode() {
        buildModeController.navigateToBrowse();
    }

    //Validate create assessment Button
    public void v_VerifyCreateAssessmentButton() {
        buildModeController.verifyCreateAssessmentButton();
    }

    //Click on publish button
    public void e_ClickOnPublishButton() {
        buildModeController.clickOnPublishButton();
    }

    //Validate View Assessments page
    public void v_VerifyViewAssessmentsPageInATD() {
        buildModeController.verifyViewAssessmentsPageInATD();
    }

    //Click on administer now button
    public void e_ClickOnAdministerNowButton() {
        buildModeController.clickOnAdministerNowButton();
    }

    //Validate Administration page
    public void v_VerifyAdministrationPage() {
        buildModeController.verifyAdministrationPage();
    }

    //Click on Assessments and do changes
    public void e_ClickOnAssessmentAndClickDone() {
        buildModeController.clickOnAssessmentAndClickDone();
    }

    // To validate navigate to view item page with changes
    public void v_VerifyNavigateToViewItemPageWithChanges() {
        buildModeController.verifyNavigateToViewItemPageWithChanges();
    }

    //click on Done button
    public void e_ClickOnDone() {
        buildModeController.clickOnDone();
    }

    //validate all options
    public void v_VerifyAllOptions() {
        buildModeController.verifyAllOptions();
    }

    //Click on create item
    public void e_ClickOnCreateItem() {
        buildModeController.clickOnCreateItem();
    }

    //Validate View Assessment page
    public void v_VerifyViewAssessmentPage() {
        buildModeController.verifyViewAssessmentPage();
    }

    //Click on Assessment with out item
    public void e_ClickAssessmentWithoutItem() {
        buildModeController.clickAssessmentWithoutItem();
    }

    //Validate Not published item
    public void v_VerifyNotPublished() {
        buildModeController.verifyNotPublished();
    }
}






