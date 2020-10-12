import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeCreateAssessmentModel
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeCreateNewAssessmentModalTest extends ExecutionContext implements BuildModeCreateAssessmentModel {

    //Logger and WebDrivers
    BuildModeController buildModeController = new BuildModeController();
    BrowseModeController browseModeController = new BrowseModeController();

    // To validate browse mode
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    // To click create assessment button
    public void e_ClickCreateAssessmentButton() {
        browseModeController.clickCreateAssessmentButton();
    }

    // To validate create assessment popup
    public void v_VerifyCreateAssessmentPopup() {
        browseModeController.verifyCreateAssessmentPopUp();
    }

    // To create assessment
    public void e_CreateAssessment() {
        buildModeController.createAssessment();
    }

    // To validate navigation to build mode
    public void v_VerifyNavigationToBuildPage() {
        buildModeController.verifyNavigateToBuild();
    }

    // To select close
    public void e_Close() {
        buildModeController.close();
    }

    // To validate navigation to browse mode
    public void v_VerifyNavigationToBrowseMode() {
        buildModeController.verifyBuildMode();
    }

    // To click create assessment button
    public void e_ClickCreateAssessment_Button() {
        browseModeController.clickCreateAssessment();
    }

    // To validate cancel button
    public void v_VerifyCancelButton() {
        browseModeController.verifyCancelButton();
    }

    // To click add item button
    public void e_ClickAddItemButton() {
        browseModeController.clickAddItemButton();
    }

    // To validate create assessment button count after add
    public void v_VerifyCreateAssessmentButtonCountAfterAdd() {
        browseModeController.verifyCreateAssessmentButtonCountAfterAdd();
    }

    // To click remove item button
    public void e_ClickRemoveItemButton() {
        buildModeController.clickRemoveItemButton();
    }

    // To validate create assessment button count after remove
    public void v_VerifyCreateAssessmentButtonCountAfterRemove() {
        buildModeController.createAssessmentButtonCountAfterRemove();
    }

    // To add N items
    public void e_AddNItems() {
        browseModeController.AddItems();
    }

    // To validate N items
    public void v_VerifyAddNItems() {
        browseModeController.verifyAddItems();
    }

    // To make changes in build mode
    public void e_MakeChangesInBuildMode() {
        buildModeController.makeChangesInBuildMode();
    }

    public void v_VerifyBuildModeAutoSave() {
    }

    // To validate creation of duplicate assessment
    public void v_VerifyCreationOfDuplicateAssessment() {
        browseModeController.verifyCreationOfDuplicateAssessment();
    }

    // To enter assessment name
    public void e_EnterAssessmentName() {
        browseModeController.enterAssessmentName();
    }

    // To validate creation with more characters
    public void v_VerifyCreationWithMoreCharacters() {
        browseModeController.verifyCreationWithMoreItems();
    }

    // To enter alpha numeric name
    public void e_EnterAlphaNumericName() {
        browseModeController.enterAlphaNumericName();
    }

    // To validate creation with alpha numeric
    public void v_VerifyCreationWithAlphaNumeric() {
        browseModeController.verifyCreationWithAlphanumeric();
    }

}
