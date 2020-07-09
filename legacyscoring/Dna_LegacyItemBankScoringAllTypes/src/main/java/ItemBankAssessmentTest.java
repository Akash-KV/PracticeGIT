
import Controllers.*;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "quick_random(edge_coverage(100))")

//Test class for Item Bank Assessment
public class ItemBankAssessmentTest extends ExecutionContext implements ScoringItemBankLegacy {
    boolean correctCheck = false, incorrectCheck = false;
    OnlineTestingAdministrationController onlineTestingAdministrationController = new OnlineTestingAdministrationController();

    //validate administrationpage
    public void v_AdministrationPagePortal() {

    }

    //click on quickroster
    public void e_ClickQuickRoster() {
        onlineTestingAdministrationController.clickOnQuickRoster();
    }

    //validate StudentTakeQuickrosterAssessment
    public void v_StudentTakeQuickrosterAssessment() {

    }

    //click finish for partial answers
    public void e_ClickFinishForPartialAnswers() {

        onlineTestingAdministrationController.refresh();
    }

    public void v_AdministrationPage() {
        //Validate Administration page
        onlineTestingAdministrationController.validateAdministrationPage();
        correctCheck = (boolean) getAttribute("correctCheck");
        incorrectCheck = (boolean) getAttribute("incorrectCheck");
    }

    //click on enteredit
    public void e_ClickOnEnterEdit() {
        onlineTestingAdministrationController.clickOnEnterEdit();


    }

    //validate enter edit
    public void v_VerifyEnterEdit() {
        //set The response score for constructed response
        if (correctCheck) {
            onlineTestingAdministrationController.validateEnterEditForCorrectAnswers();


        } else if (incorrectCheck) {
            onlineTestingAdministrationController.validateEnterEditForInvalidAnswers();
        } else {
            onlineTestingAdministrationController.validEnterEditForPartialAnswers();
        }

        onlineTestingAdministrationController.validateEnterEdit();
    }

    //click on overview
    public void e_ClickOnOverview() {
        onlineTestingAdministrationController.clickOnOverview();
    }

    //validate score
    public void v_VerifyScore() {
        //validate score
        // for correct answer assertion code
        if (correctCheck) {
            onlineTestingAdministrationController.validateScoreForCorrectAnswers();
        }

        // for wrong answer assertion code
        else if (incorrectCheck) {
            onlineTestingAdministrationController.validateScoreForIncorrectAnswers();
        }

        // for partial answer assertion code
        else {
            onlineTestingAdministrationController.validateScoreForPartialAnswers();
        }

        //Remove Student Responses
        onlineTestingAdministrationController.removeStudentResponse();
    }

    //click on online Testing
    public void e_ClickOnOnlineTesting() {
        onlineTestingAdministrationController.clickOnOnlineTesting();
    }

    //validate online Testing
    public void v_OnlineTestingPage() {
        onlineTestingAdministrationController.validateOnlineTesting();
    }

    //click finish for correct answers
    public void e_ClickFinishForCorrectAnswers() {
        //Quick code button
        onlineTestingAdministrationController.clickFinishForCorrectAnswers();
    }

    //click finish for wrong answers
    public void e_ClickFinishForWrongAnswer() {
        onlineTestingAdministrationController.clickFinishForWrongAnswers();
    }

    public void e_ClickExit() {

    }
}