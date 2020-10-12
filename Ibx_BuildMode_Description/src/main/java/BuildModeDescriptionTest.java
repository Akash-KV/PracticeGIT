import Controllers.BuildModeController;
import Controllers.BrowseModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeAddDescription
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeDescriptionTest extends ExecutionContext implements BuildModeAddDescription {

    BrowseModeController browseModeController = new BrowseModeController();
    BuildModeController buildModeController = new BuildModeController();

    // To validate browse mode
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    // To create assessment
    public void e_CreateAssessment() {
        buildModeController.createAssessment();
    }

    // To validate Build Mode navigation
    public void v_VerifyBuildNavigation() {
        buildModeController.verifyBuildNavigation();
    }

    // To click add description button
    public void e_ClickAddDescriptionButton() {
        buildModeController.clickAddDescriptionButton();
    }

    // To validate add description window
    public void v_VerifyAddDescriptionWindow() {
        buildModeController.verifyAddDescriptionWindow();
    }

    public void e_ClickCloseButtonInAddDescriptionWindow() {
        //In Staging Site no close option hence waiting for the release
    }

    public void v_VerifyCloseButtonInAddDescriptionWindow() {
        //In Staging Site no close option hence waiting for the release
    }

    // To click cancel button in add description
    public void e_ClickCancelButtonInAddDescriptionWindow() {
        buildModeController.clickCancelButtonInAddDescriptionWindow();
    }

    // To validate cancel button in add description
    public void v_VerifyCancelButtonInAddDescriptionWindow() {
        buildModeController.verifyCancelButtonInAddDescriptionWindow();
    }

    // To give description text less than 255 words
    public void e_DescriptionTextLessThanTwoHundredFiftyFive() {
        buildModeController.descriptionTextLessThanTwoHundredFiftyFive();
    }

    // To validate Description text less than 255 words
    public void v_VerifyDescriptionTextLessThanTwoHundredFiftyFive() {
        buildModeController.verifyDescriptionTextLessThanTwoHundredFiftyFive();
    }

    // To delete description text
    public void e_DeleteDescriptionText() {
        buildModeController.deleteDescriptionText();
    }

    // To validate deleted description text
    public void v_VerifyDeleteDescriptionText() {
        buildModeController.verifyDeleteDescriptionText();
    }


    // To enter Alphanumeric in Description
    public void e_AlphanumericInDescription() {
        buildModeController.alphanumericInDescription();
    }


    // To validate Alphanumeric in Description
    public void v_VerifyAlphanumericInDescription() {
        buildModeController.verifyAlphanumericInDescription();
    }

    // To enter description text More than 255 words
    public void e_DescriptionTextMoreThanTwoHundredFiftyFive() {
        buildModeController.descriptionTextMoreThanTwoHundredFiftyFive();
    }

    // To validate Description text More than 255 words
    public void v_VerifyDescriptionTextMoreThanTwoHundredFiftyFive() {
        buildModeController.verifyDescriptionTextMoreThanTwoHundredFiftyFive();
    }

    // To enter Description text Exact 255 words
    public void e_DescriptionTextExactTwoHundredFiftyFive() {
        buildModeController.descriptionTextExactTwoHundredFiftyFive();
    }

    // To validate Description text Exact 255 words
    public void v_VerifyDescriptionTextExactTwoHundredFiftyFive() {
        buildModeController.verifyDescriptionTextExactTwoHundredFiftyFive();
    }

    // To enter Special characters For DescriptionText
    public void e_SpecialCharactersForDescriptionText() {
        buildModeController.specialCharactersForDescriptionText();
    }

    // To validate Special characters For Description Text
    public void v_VerifySpecialCharactersForDescriptionText() {
        buildModeController.verifySpecialCharactersForDescriptionText();
    }

    // To navigate Browse Page and Check Description Saved
    public void e_NavigateToBrowsePageAndCheckDescriptionSaved() {
        buildModeController.navigateToBrowsePageAndCheckDescriptionSaved();
    }

    // To validate Navigate to Browse and Check Description Saved
    public void v_VerifyNavigateToBrowseAndCheckDescriptionSaved() {
        buildModeController.verifyNavigateToBrowseAndCheckDescriptionSaved();
    }
}
