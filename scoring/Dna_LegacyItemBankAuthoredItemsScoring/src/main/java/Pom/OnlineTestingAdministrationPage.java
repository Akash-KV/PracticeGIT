package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model OnlineTestingAdministrationPage
public class OnlineTestingAdministrationPage {
    private String onlineTestingAdministrationassessmentPanel, onlineTestingAdministrationMultiPartWrongAnswer,onlineTestingAdministrationLiveProctoring,onlineTestingAdministrationDragandDropClasifyIncorrect, onlineTestingAdministrationOnlineTestingCRBox, onlineTestingAdministrationOnlineTestingFifthAnswer, onlineTestingAdministrationOnlineTestingFourthAnswer, onlineTestingAdministrationOnlineTestingThirdAnswer, onlineTestingAdministrationOnlineTestingSecondAnswer, onlineTestingAdministrationOnlineTestingFirstAnswer, onlineTestingAdministrationAdministration, onlineTestingAdministrationOverview, onlineTestingAdministrationNumberOfQuestions;
    private String onlineTestingAdministrationOnlineTestingSixthAnswer, onlineTestingAdministrationOnlineTestingSeventhAnswer, onlineTestingAdministrationAnswerForExplicitConstructiveResponse, onlineTestingAdministrationAnswerBoxForExplicitConstructiveResponse, onlineTestingAdministrationAnswerBoxForConstructiveResponse, onlineTestingAdministrationAnswerForConstructiveResponse, onlineTestingAdministrationIncorrectThirdAnswer, onlineTestingAdministrationPartialFourthAnswer, onlineTestingAdministrationPartialThirdAnswer, onlineTestingAdministrationOnlineTestingfinish;
    private String onlineTestingAdministrationGridSave, onlineTestingAdministrationHundredPercent, onlineTestingAdministrationOnlineTesting, onlineTestingAdministrationAdministrationButton, onlineTestingAdministrationRemoveMessage, onlineTestingAdministrationRemoveStudentResponseButton, onlineTestingAdministrationRemoveStudentResponses, onlineTestingAdministrationConfirmRemove, onlineTestingAdministrationAgreeRemove, onlineTestingAdministrationRemoveButton, onlineTestingAdministrationRemoveAllResponses, onlineTestingAdministrationAdvanced, onlineTestingAdministrationZeroPercent, onlineTestingAdministrationParcialPercent;
    private String onlineTestingAdministrationWrongAnswerForExplicitConstructiveResponse,onlineTestingAdministrationMultiPort,onlineTestingAdministrationMultiPortCorrect,onlineTestingAdministrationDragAndDrop,onlineTestingAdministrationDragAndDropCorrecr,onlineTestingAdministrationDragAndDropOrder,onlineTestingAdministrationDragAndDropOrderCorrect,onlineTestingAdministrationSelectHighlight,onlineTestingAdministrationSelectHighlightCorrect,onlineTestingAdministrationWrongAnswer,onlineTestingAdministrationWrongAnswerDrag,onlineTestingAdministrationWrongAnswerDragClassify;
    private  String onlineTestingAdministrationWrongAnswerDragPartial,onlineTestingAdministrationDismiss,onlineTestingAdministrationDragAndDropCorrect;
    private  String onlineTestingAdministrationDragandDropClassifyAnswer,onlineTestingAdministrationMultiPart,onlineTestingAdministrationDragandDropClasifyCorrectAnswer;
    private  String onlineTestingAdministrationConfirmFinish,onlineTestingAdministrationHighlightSelectableText,onlineTestingAdministrationDragAndDropFirstAnswer,onlineTestingAdministrationDragAndDropSecondAnswer,onlineTestingAdministrationDragAndDropThirdAnswer;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public OnlineTestingAdministrationPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_LegacyItemBankAuthoredItemsScoring", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\OnlineTestingAdministrationPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/OnlineTestingAdministrationPage.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    Methods to read the data from Property file
    */

    public String getOnlineTestingAdministrationassessmentPanel() {
        onlineTestingAdministrationassessmentPanel = properties.getProperty("ONLINETESTINGADMINISTRATION_ASSESSMENTPANEL");
        return onlineTestingAdministrationassessmentPanel;
    }

    public String getOnlineTestingAdministrationLiveProctoring() {
        onlineTestingAdministrationLiveProctoring = properties.getProperty("ONLINETESTINGADMINISTRATION_LIVEPROCTORING");
        return onlineTestingAdministrationLiveProctoring;
    }

    public String getOnlineTestingAdministrationNumberOfQuestions() {
        onlineTestingAdministrationNumberOfQuestions = properties.getProperty("ONLINETESTINGADMINISTRATION_NUMBEROF_QUESTIONS");
        return onlineTestingAdministrationNumberOfQuestions;
    }

    public String getOnlineTestingAdministrationOverview() {
        onlineTestingAdministrationOverview = properties.getProperty("ONLINETESTINGADMINISTRATION_OVERVIEW");
        return onlineTestingAdministrationOverview;
    }

    public String getOnlineTestingAdministrationAdministration() {
        onlineTestingAdministrationAdministration = properties.getProperty("ONLINETESTINGADMINISTRATION_ADMINISTRATION");
        return onlineTestingAdministrationAdministration;
    }

    public String getOnlineTestingAdministrationGridSave() {
        onlineTestingAdministrationGridSave = properties.getProperty("ONLINETESTINGADMINISTRATION_GRIDSAVE");
        return onlineTestingAdministrationGridSave;
    }

    public String getOnlineTestingAdministrationHundredPercent() {
        onlineTestingAdministrationHundredPercent = properties.getProperty("ONLINETESTINGADMINISTRATION_HUNDREDPERCENT");
        return onlineTestingAdministrationHundredPercent;
    }

    public String getOnlineTestingAdministrationZeroPercent() {
        onlineTestingAdministrationZeroPercent = properties.getProperty("ONLINETESTINGADMINISTRATION_ZEROPERCENT");
        return onlineTestingAdministrationZeroPercent;
    }

    public String getOnlineTestingAdministrationParcialPercent() {
        onlineTestingAdministrationParcialPercent = properties.getProperty("ONLINETESTINGADMINISTRATION_PARCIALPERCENT");
        return onlineTestingAdministrationParcialPercent;
    }

    public String getOnlineTestingAdministrationAdvanced() {
        onlineTestingAdministrationAdvanced = properties.getProperty("ONLINETESTINGADMINISTRATION_ADVANCED");
        return onlineTestingAdministrationAdvanced;
    }

    public String getOnlineTestingAdministrationRemoveAllResponses() {
        onlineTestingAdministrationRemoveAllResponses = properties.getProperty("ONLINETESTINGADMINISTRATION_REMOVEALLRESPONSES");
        return onlineTestingAdministrationRemoveAllResponses;
    }

    public String getOnlineTestingAdministrationRemoveButton() {
        onlineTestingAdministrationRemoveButton = properties.getProperty("ONLINETESTINGADMINISTRATION_REMOVEBUTTON");
        return onlineTestingAdministrationRemoveButton;
    }

    public String getOnlineTestingAdministrationAgreeRemove() {
        onlineTestingAdministrationAgreeRemove = properties.getProperty("AGREE_REMOVE");
        return onlineTestingAdministrationAgreeRemove;
    }

    public String getOnlineTestingAdministrationConfirmRemove() {
        onlineTestingAdministrationConfirmRemove = properties.getProperty("CONFIRM_REMOVE");
        return onlineTestingAdministrationConfirmRemove;
    }

    public String getOnlineTestingAdministrationRemoveStudentResponses() {
        onlineTestingAdministrationRemoveStudentResponses = properties.getProperty("ONLINETESTINGADMINISTRATION_REMOVESTUDENTRESPONSES");
        return onlineTestingAdministrationRemoveStudentResponses;
    }

    public String getOnlineTestingAdministrationRemoveStudentResponseButton() {
        onlineTestingAdministrationRemoveStudentResponseButton = properties.getProperty("REMOVE_STUDENTRESPONSE_BUTTON");
        return onlineTestingAdministrationRemoveStudentResponseButton;
    }

    public String getOnlineTestingAdministrationRemoveMessage() {
        onlineTestingAdministrationRemoveMessage = properties.getProperty("ONLINETESTINGADMINISTRATION_REMOVEMESSAGE");
        return onlineTestingAdministrationRemoveMessage;
    }

    public String getOnlineTestingAdministrationAdministrationButton() {
        onlineTestingAdministrationAdministrationButton = properties.getProperty("ONLINETESTINGADMINISTRATION_ADMISTRATION");
        return onlineTestingAdministrationAdministrationButton;
    }

    public String getOnlineTestingAdministrationOnlineTesting() {
        onlineTestingAdministrationOnlineTesting = properties.getProperty("ONLINETESTINGADMINISTRATION_ONLINETESTING");
        return onlineTestingAdministrationOnlineTesting;
    }

    public String getOnlineTestingAdministrationOnlineTestingFirstAnswer() {
        onlineTestingAdministrationOnlineTestingFirstAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_ONLINETESTINGFIRSTANSWER");
        return onlineTestingAdministrationOnlineTestingFirstAnswer;
    }

    public String getOnlineTestingAdministrationOnlineTestingSecondAnswer() {
        onlineTestingAdministrationOnlineTestingSecondAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_ONLINETESTINGSECONDANSWER");
        return onlineTestingAdministrationOnlineTestingSecondAnswer;
    }

    public String getOnlineTestingAdministrationOnlineTestingThirdAnswer() {
        onlineTestingAdministrationOnlineTestingThirdAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_ONLINETESTINGTHIRDANSWER");
        return onlineTestingAdministrationOnlineTestingThirdAnswer;
    }

    public String getOnlineTestingAdministrationOnlineTestingFourthAnswer() {
        onlineTestingAdministrationOnlineTestingFourthAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_ONLINETESTINGFOURTHANSWER");
        return onlineTestingAdministrationOnlineTestingFourthAnswer;
    }

    public String getOnlineTestingAdministrationOnlineTestingFifthAnswer() {
        onlineTestingAdministrationOnlineTestingFifthAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_ONLINETESTINGFIFTHANSWER");
        return onlineTestingAdministrationOnlineTestingFifthAnswer;
    }

    public String getOnlineTestingAdministrationOnlineTestingCRBox() {
        onlineTestingAdministrationOnlineTestingCRBox = properties.getProperty("ONLINETESTINGADMINISTRATION_ONLINETESTING_CRBOX");
        return onlineTestingAdministrationOnlineTestingCRBox;
    }

    public String getOnlineTestingAdministrationOnlineTestingSixthAnswer() {
        onlineTestingAdministrationOnlineTestingSixthAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_ONLINETESTINGSIXTHANSWER");
        return onlineTestingAdministrationOnlineTestingSixthAnswer;
    }

    public String getOnlineTestingAdministrationOnlineTestingSeventhAnswer() {
        onlineTestingAdministrationOnlineTestingSeventhAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_ONLINETESTINGSEVENTHANSWER");
        return onlineTestingAdministrationOnlineTestingSeventhAnswer;
    }

    public String getOnlineTestingAdministrationOnlineTestingfinish() {
        onlineTestingAdministrationOnlineTestingfinish = properties.getProperty("ONLINETESTINGADMINISTRATION_ONLINETESTINGFINISH");
        return onlineTestingAdministrationOnlineTestingfinish;
    }

    public String getOnlineTestingAdministrationPartialThirdAnswer() {
        onlineTestingAdministrationPartialThirdAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_PARTIALTHIRDANSWER");
        return onlineTestingAdministrationPartialThirdAnswer;
    }

    public String getOnlineTestingAdministrationPartialFourthAnswer() {
        onlineTestingAdministrationPartialFourthAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_PARTIALFOURTHANSWER");
        return onlineTestingAdministrationPartialFourthAnswer;
    }

    public String getOnlineTestingAdministrationIncorrectThirdAnswer() {
        onlineTestingAdministrationIncorrectThirdAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_INCORRECTTHIRDANSWER");
        return onlineTestingAdministrationIncorrectThirdAnswer;
    }

    public String getOnlineTestingAdministrationAnswerForConstructiveResponse() {
        onlineTestingAdministrationAnswerForConstructiveResponse = properties.getProperty("ONLINETESTINGADMINISTRATION_ANSWERFORCONSTRUCTIVERESPONSE");
        return onlineTestingAdministrationAnswerForConstructiveResponse;
    }

    public String getOnlineTestingAdministrationAnswerBoxForConstructiveResponse() {
        onlineTestingAdministrationAnswerBoxForConstructiveResponse = properties.getProperty("ONLINETESTINGADMINISTRATION_ANSWERBOXFORCONSTRUCTIVERESPONSE");
        return onlineTestingAdministrationAnswerBoxForConstructiveResponse;
    }

    public String getOnlineTestingAdministrationAnswerForExplicitConstructiveResponse() {
        onlineTestingAdministrationAnswerForExplicitConstructiveResponse = properties.getProperty("ONLINETESTINGADMINISTRATION_ANSWERFOREXPLICITCONSTRUCTIVERESPONSE");
        return onlineTestingAdministrationAnswerForExplicitConstructiveResponse;
    }

    public String getOnlineTestingAdministrationAnswerBoxForExplicitConstructiveResponse() {
        onlineTestingAdministrationAnswerBoxForExplicitConstructiveResponse = properties.getProperty("ONLINETESTINGADMINISTRATION_ANSWERBOXFOREXPLICITCONSTRUCTIVERESPONSE");
        return onlineTestingAdministrationAnswerBoxForExplicitConstructiveResponse;
    }

    public String getOnlineTestingAdministrationWrongAnswerForExplicitConstructiveResponse() {
        onlineTestingAdministrationWrongAnswerForExplicitConstructiveResponse = properties.getProperty("ONLINETESTINGADMINISTRATION_WRONGANSWERFOREXPLICITCONSTRUCTIVERESPONSE");
        return onlineTestingAdministrationWrongAnswerForExplicitConstructiveResponse;
    }

    public String getOnlineTestingAdministrationMultiPort() {
        onlineTestingAdministrationMultiPort = properties.getProperty("ONLINETESTINGADMINISTRATION_MULTIPORT");
        return onlineTestingAdministrationMultiPort;
    }

    public String getOnlineTestingAdministrationMultiPortCorrect() {
        onlineTestingAdministrationMultiPortCorrect = properties.getProperty("ONLINETESTINGADMINISTRATION_MULTIPORTCORRECT");
        return onlineTestingAdministrationMultiPortCorrect;
    }

    public String getOnlineTestingAdministrationDragAndDrop() {
        onlineTestingAdministrationDragAndDrop = properties.getProperty("ONLINETESTINGADMINISTRATION_DRAGANDDROP");
        return onlineTestingAdministrationDragAndDrop;
    }

    public String getOnlineTestingAdministrationDragAndDropCorrect() {
        onlineTestingAdministrationDragAndDropCorrect = properties.getProperty("ONLINETESTINGADMINISTRATION_DRAGANDDROPCORRECT");
        return onlineTestingAdministrationDragAndDropCorrect;
    }

    public String getOnlineTestingAdministrationDragAndDropOrder() {
        onlineTestingAdministrationDragAndDropOrder= properties.getProperty("ONLINETESTINGADMINISTRATION_DRAGANDDROPORDER");
        return onlineTestingAdministrationDragAndDropOrder;
    }
    public String getOnlineTestingAdministrationDragAndDropOrderCorrect() {
        onlineTestingAdministrationDragAndDropOrderCorrect = properties.getProperty("ONLINETESTINGADMINISTRATION_DRAGANDDROPORDERCORRECT");
        return onlineTestingAdministrationDragAndDropOrderCorrect;
    }
    public String getOnlineTestingAdministrationSelectHighlight() {
        onlineTestingAdministrationSelectHighlight = properties.getProperty("ONLINETESTINGADMINISTRATION_SELECTHIGHLIGHT");
        return onlineTestingAdministrationSelectHighlight;
    }

    public String getOnlineTestingAdministrationSelectHighlightCorrect() {
        onlineTestingAdministrationSelectHighlightCorrect = properties.getProperty("ONLINETESTINGADMINISTRATION_SELECTHIGHLIGHTCORRECT");
        return onlineTestingAdministrationSelectHighlightCorrect;
    }

    public String getOnlineTestingAdministrationWrongAnswer() {
        onlineTestingAdministrationWrongAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_WRONGANSWER");
        return onlineTestingAdministrationWrongAnswer;
    }
    public String getOnlineTestingAdministrationWrongAnswerDrag() {
        onlineTestingAdministrationWrongAnswerDrag = properties.getProperty("ONLINETESTINGADMINISTRATION_WRONGANSWERDRAG");
        return onlineTestingAdministrationWrongAnswerDrag;
    }
    public String getOnlineTestingAdministrationWrongAnswerDragClassify() {
        onlineTestingAdministrationWrongAnswerDragClassify = properties.getProperty("ONLINETESTINGADMINISTRATION_DRAGANDDROPCLASSIFY");
        return onlineTestingAdministrationWrongAnswerDragClassify;
    }

    public String getOnlineTestingAdministrationWrongAnswerDragPartial() {
        onlineTestingAdministrationWrongAnswerDragPartial = properties.getProperty("ONLINETESTINGADMINISTRATION_DRAGANDDROPPARTIAL");
        return onlineTestingAdministrationWrongAnswerDragPartial;
    }


    public String getOnlineTestingAdministrationDismiss() {
        onlineTestingAdministrationDismiss= properties.getProperty("ONLINETESTINGADMINISTRATION_DISMISS");
        return onlineTestingAdministrationDismiss;
    }

    public String getOnlineTestingAdministrationDragandDropClassifyAnswer() {
        onlineTestingAdministrationDragandDropClassifyAnswer= properties.getProperty("ONLINETESTINGADMINISTRATION_DRAGANDDROPCLASSIFYANSWER");
        return onlineTestingAdministrationDragandDropClassifyAnswer;
    }


    public String getOnlineTestingAdministrationDragandDropClassifyCorrectAnswer() {
        onlineTestingAdministrationDragandDropClasifyCorrectAnswer= properties.getProperty("ONLINETESTINGADMINISTRATION_DRAGANDDROPCLASSIFYCORRECTANSWER");
        return onlineTestingAdministrationDragandDropClasifyCorrectAnswer;
    }

    public String getOnlineTestingAdministrationDragandDropClassifyIncorrect() {
        onlineTestingAdministrationDragandDropClasifyIncorrect= properties.getProperty("ONLINETESTINGADMINISTRATION_DARGANDDROPCLASIFYINCORRECT");
        return onlineTestingAdministrationDragandDropClasifyIncorrect;
    }
    public String getOnlineTestingAdministrationConfirmFinish() {
        onlineTestingAdministrationConfirmFinish= properties.getProperty("ONLINETESTINGADMINISTRATION_CONFIRMFINISH");
        return onlineTestingAdministrationConfirmFinish;
    }
    public String getOnlineTestingAdministrationDragAndDropFirstAnswer() {
        onlineTestingAdministrationDragAndDropFirstAnswer= properties.getProperty("ONLINETESTINGADMINISTRATION_DRAGANDDROPORDERFIRSRANSWER");
        return onlineTestingAdministrationDragAndDropFirstAnswer;
    }
    public String getOnlineTestingAdministrationDragAndDropSecondAnswer() {
        onlineTestingAdministrationDragAndDropSecondAnswer= properties.getProperty("ONLINETESTINGADMINISTRATION_DARGANDDROPORDERSECONDANSWER");
        return onlineTestingAdministrationDragAndDropSecondAnswer;
    }
    public String getOnlineTestingAdministrationDragAndDropThirdAnswer() {
        onlineTestingAdministrationDragAndDropThirdAnswer= properties.getProperty("ONLINETESTINGADMINISTRATION_DRAGANDDROPORDERTHIRDANSWER");
        return onlineTestingAdministrationDragAndDropThirdAnswer;
    }
    public String getOnlineTestingAdministrationHighlightSelectableText() {
        onlineTestingAdministrationHighlightSelectableText= properties.getProperty("ONLINETESTINGADMINISTRATION_HIGHLIGHTSELECTABLETEXT");
        return onlineTestingAdministrationHighlightSelectableText;
    }
    public String getOnlineTestingAdministrationMultiPart() {
        onlineTestingAdministrationMultiPart= properties.getProperty("ONLINETESTINGADMINISTRATION_MULTIPART");
        return onlineTestingAdministrationMultiPart;
    }
    public String getOnlineTestingAdministrationMultiPartWrongAnswer() {
        onlineTestingAdministrationMultiPartWrongAnswer= properties.getProperty("ONLINETESTINGADMINISTRATION_MULTIPARTWRONGANSWER");
        return onlineTestingAdministrationMultiPartWrongAnswer;
    }
}