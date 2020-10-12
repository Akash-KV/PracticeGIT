
import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeWeight
 **/
@GraphWalker
public class BuildModeWeightTest extends ExecutionContext implements BuildModeWeight {

    BuildModeController buildModeController = new BuildModeController();
    BrowseModeController browseModeController = new BrowseModeController();

    // To validate Browse Mode
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    // To create assessment
    public void e_CreateAssessment() {
        buildModeController.createAssessment();
    }

    // To validate Build Mode navigation
    public void v_VerifyBuildNavigation() {
        buildModeController.verifyBuildModeNavigation();
    }

    // To validate weight default value
    public void v_VerifyWeightDefaultValue() {
        buildModeController.verifyWeightDefaultValue();
    }

    // To enter alphabet value in weight
    public void e_EnterAlphabetValueInWeight() {
        buildModeController.enterAlphabetValueWeight();
    }

    // To validate alphabet value in weight
    public void v_VerifyAlphabetValueInWeight() {
        buildModeController.verifyAlphabetValueInWeight();
    }

    // To enter Special Characters In Weight
    public void e_EnterSpecialCharactersInWeight() {
        buildModeController.enterSpecialCharactersInWeight();
    }

    // To validate Special Characters In Weight
    public void v_VerifySpecialCharactersInWeight() {
        buildModeController.verifySpecialCharactersInWeight();
    }

    //Entering the  Number with Plus Minus Symbol Value In Weight
    public void e_EnterNumberWithPlusMinusSymbolInWeight() {
        buildModeController.enterNumberWithPlusMinusSymbol();
    }

    //verifying the Number with Plus Minus Symbol Value In Weight
    public void v_VerifyNumberWithPlusMinusSymbolInWeight() {
        buildModeController.verifyNumberWithPlusMinusSymbol();
    }

    //Entering the  Less than Zero Value In Weight
    public void e_EnterLessThanZeroInWeight() {
        buildModeController.enterLessThanNumberInWeight();
    }

    //verifying the Less than Zero Value In Weight
    public void v_VerifyLessThanZeroInWeight() {
        buildModeController.verifyLessThanZeroInWeight();
    }

    //Entering the  More than Hundred Value In Weight
    public void e_EnterMoreThanHundredInWeight() {
        buildModeController.enterMoreThanHundredInWeight();
    }

    //verifying the More than Hundred Value In Weight
    public void v_VerifyMoreThanHundredInWeight() {
        buildModeController.validateMoreThanHundredInWeight();
    }

    //Entering the Decimal Value In Weight
    public void e_EnterDecimalValuesInWeight() {
        buildModeController.enterDecimalValueInWeight();
    }

    //verifying the Decimal Value In Weight
    public void v_VerifyDecimalValuesInWeight() {
        buildModeController.verifyDecimalValueInWeight();
    }
}
