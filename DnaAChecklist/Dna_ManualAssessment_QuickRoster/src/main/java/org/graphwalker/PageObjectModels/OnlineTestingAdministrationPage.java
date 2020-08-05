package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*******Page Object Model Class for OnlineTestingAdministrationPage***********/
public class OnlineTestingAdministrationPage {
    private String testWithQuickCodeButton, onlineTestingAdministrationConfirmButton, accessCode, onlineTestingAdministrationPreviewAssessment, onlineTestingAdministrationEditThirdAnswer, onlineTestingAdministrationviewType, onlineTestingAdministrationOverview, onlineTestingAdministrationThirdAnswerBox, onlineTestingAdministrationFirstAnswerBox, onlineTestingAdministrationassessmentPanel, onlineTestingAdministrationLiveProctoring, onlineTestingAdministrationFinishButton, onlineTestingAdministrationFirstAnswer, onlineTestingAdministrationSuccess;
    private String testWithQuickCodePostCreationModalExitButton, onlineAdministrationStudentLogin, QuickRosterButton, onlineTestingAdministrationOverviewAssessmentButton, onlineTestingAdministrationSaveEdited, onlineTestingAdministrationExit, onlineTestingAdministrationSecondAnswerBox, onlineTestingAdministrationSecondAnswer, onlineTestingAdministrationThirdAnswer;
    private String onlineTestingAdministrationMultipleChoiceAdvancedQuestion, olineTestingAdministrationNextButton, testWithQuickCodeCreationModalExitButton, onlineTestingAdministrationDeleteSubmit, onlineTestingAdministrationDeleteAlertPopup, onlineTestingAdministrationDeleteAgree, onlineTestingAdministrationDeleteAssessment, onlineTestingAdministrationAdvancedDropdown, onlineTestingAdministrationEditSecondAnswer, onlineTestingAdministrationEditFirstAnswer, onlineTestingAdministrationFindStudents, onlineTestingAdministrationStudentResponse, onlineTestingAdministrationAnswer, onlineTestingAdministrationConstructedResponseAnswerFrame, onlineTestingAdministrationNextQuestion, onlineTestingAdministrationConstructedResponseChangeFrame, onlineTestingAdministrationStatusBox, onlineTestingAdministrationFirstChoice, onlineTestingAdministrationPortalAssessmentStudent, onlineTestingAdministrationPortalAssessment, onlineTestingAdministrationResetPasswordSubmit, onlineTestingAdministrationResetPasswordSecond, onlineTestingAdministrationLogin, onlineTestingAdministrationResetPasswordFirst, onlineTestingAdministrationResetPassword, onlineTestingAdministrationUsername, onlineTestingAdministrationPassword, onlineTestingAdministrationSave, onlineTestingAdministrationcompleteBar, onlineTestingAdministrationWindowStart, onlineTestingAdministrationStudentId, onlineTestingAdministrationWindowEnd, onlineTestingAdministrationPreviewButton, onlineTestingAdministrationportalButton;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public OnlineTestingAdministrationPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_QuickRoster", "");
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
    public String getOnlineTestingAdministrationPreviewAssessment() {
        onlineTestingAdministrationPreviewAssessment = properties.getProperty("ONLINETESTINGADMINISTRATION_PREVIEWASSESSMENT");
        return onlineTestingAdministrationPreviewAssessment;
    }

    public String getOnlineTestingAdministrationPreviewButton() {
        onlineTestingAdministrationPreviewButton = properties.getProperty("ONLINETESTINGADMINISTRATION_PREVIEWBUTTON");
        return onlineTestingAdministrationPreviewButton;
    }

    public String getOnlineTestingAdministrationSuccess() {
        onlineTestingAdministrationSuccess = properties.getProperty("ONLINETESTINGADMINISTRATION_SUCCESS");
        return onlineTestingAdministrationSuccess;
    }

    public String getOnlineTestingAdministrationportalButton() {
        onlineTestingAdministrationportalButton = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALBUTTON");
        return onlineTestingAdministrationportalButton;
    }

    public String getOnlineTestingAdministrationWindowStart() {
        onlineTestingAdministrationWindowStart = properties.getProperty("ONLINETESTINGADMINISTRATION_WINDOWSTART");
        return onlineTestingAdministrationWindowStart;
    }

    public String getOnlineTestingAdministrationWindowEnd() {
        onlineTestingAdministrationWindowEnd = properties.getProperty("ONLINETESTINGADMINISTRATION_WINDOWEND");
        return onlineTestingAdministrationWindowEnd;
    }

    public String getOnlineTestingAdministrationStudentId() {
        onlineTestingAdministrationStudentId = properties.getProperty("ONLINETESTINGADMINISTRATION_STUDENTID");
        return onlineTestingAdministrationStudentId;
    }

    public String getOnlineTestingAdministrationSave() {
        onlineTestingAdministrationSave = properties.getProperty("ONLINETESTINGADMINISTRATION_SAVE");
        return onlineTestingAdministrationSave;
    }

    public String getOnlineTestingAdministrationcompleteBar() {
        onlineTestingAdministrationcompleteBar = properties.getProperty("ONLINETESTINGADMINISTRATION_COMPLETEBAR");
        return onlineTestingAdministrationcompleteBar;
    }

    public String getOnlineTestingAdministrationUsername() {
        onlineTestingAdministrationUsername = properties.getProperty("ONLINETESTINGADMINISTRATION_USERNAME");
        return onlineTestingAdministrationUsername;
    }

    public String getOnlineTestingAdministrationPassword() {
        onlineTestingAdministrationPassword = properties.getProperty("ONLINETESTINGADMINISTRATION_PASSWORD");
        return onlineTestingAdministrationPassword;
    }

    public String getOnlineTestingAdministrationLogin() {
        onlineTestingAdministrationLogin = properties.getProperty("ONLINETESTINGADMINISTRATION_LOGIN");
        return onlineTestingAdministrationLogin;
    }

    public String getOnlineTestingAdministrationResetPassword() {
        onlineTestingAdministrationResetPassword = properties.getProperty("ONLINETESTINGADMINISTRATION_RESETPASSWORD");
        return onlineTestingAdministrationResetPassword;
    }

    public String getOnlineTestingAdministrationResetPasswordFirst() {
        onlineTestingAdministrationResetPasswordFirst = properties.getProperty("ONLINETESTINGADMINISTRATION_RESETPASSWORDFIRST");
        return onlineTestingAdministrationResetPasswordFirst;
    }

    public String getOnlineTestingAdministrationResetPasswordSecond() {
        onlineTestingAdministrationResetPasswordSecond = properties.getProperty("ONLINETESTINGADMINISTRATION_RESETPASSWORDSECOND");
        return onlineTestingAdministrationResetPasswordSecond;
    }

    public String getOnlineTestingAdministrationResetPasswordSubmit() {
        onlineTestingAdministrationResetPasswordSubmit = properties.getProperty("ONLINETESTINGADMINISTRATION_RESETPASSWORDSUBMIT");
        return onlineTestingAdministrationResetPasswordSubmit;
    }

    public String getOnlineTestingAdministrationPortalAssessmentStudent() {
        onlineTestingAdministrationPortalAssessmentStudent = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALASSESSMENT_STUDENT");
        return onlineTestingAdministrationPortalAssessmentStudent;
    }

    public String getOnlineTestingAdministrationPortalAssessment() {
        onlineTestingAdministrationPortalAssessment = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALASSESSMENT");
        return onlineTestingAdministrationPortalAssessment;
    }

    public String getOnlineTestingAdministrationFirstChoice() {
        onlineTestingAdministrationFirstChoice = properties.getProperty("ONLINETESTINGADMINISTRATION_FIRSTCHOICE");
        return onlineTestingAdministrationFirstChoice;
    }

    public String getOnlineTestingAdministrationStatusBox() {
        onlineTestingAdministrationStatusBox = properties.getProperty("ONLINETESTINGADMINISTRATION_STATUSBOX");
        return onlineTestingAdministrationStatusBox;
    }

    public String getOnlineTestingAdministrationNextQuestion() {
        onlineTestingAdministrationNextQuestion = properties.getProperty("ONLINETESTINGADMINISTRATION_NEXTQUESTIONBUTTON");
        return onlineTestingAdministrationNextQuestion;
    }

    public String getOnlineTestingAdministrationConstructedResponseChangeFrame() {
        onlineTestingAdministrationConstructedResponseChangeFrame = properties.getProperty("ONLINETESTINGADMINISTRATION_CONSTRUCTEDRESPONSECHANGEFRAME");
        return onlineTestingAdministrationConstructedResponseChangeFrame;
    }

    public String getOnlineTestingAdministrationConstructedResponseAnswerFrame() {
        onlineTestingAdministrationConstructedResponseAnswerFrame = properties.getProperty("ONLINETESTINGADMINISTRATION_CONSTRUCTEDRESPONSEANSWERFRAME");
        return onlineTestingAdministrationConstructedResponseAnswerFrame;
    }

    public String getOnlineTestingAdministrationMultipleChoiceAdvancedQuestion() {
        onlineTestingAdministrationMultipleChoiceAdvancedQuestion = properties.getProperty("ONLINETESTINGADMINISTRATION_MULTIPLECHOICEADVANCEDQUESTION");
        return onlineTestingAdministrationMultipleChoiceAdvancedQuestion;
    }

    public String getOnlineTestingAdministrationFirstAnswer() {
        onlineTestingAdministrationFirstAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_FIRSTANSWER");
        return onlineTestingAdministrationFirstAnswer;
    }

    public String getOnlineTestingAdministrationSecondAnswer() {
        onlineTestingAdministrationSecondAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_SECONDANSWER");
        return onlineTestingAdministrationSecondAnswer;
    }

    public String getOnlineTestingAdministrationThirdAnswer() {
        onlineTestingAdministrationThirdAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_THIRDANSWER");
        return onlineTestingAdministrationThirdAnswer;
    }

    public String getOnlineTestingAdministrationFinishButton() {
        onlineTestingAdministrationFinishButton = properties.getProperty("ONLINETESTINGADMINISTRATION_FINISHBUTTON");
        return onlineTestingAdministrationFinishButton;
    }

    public String getOnlineTestingAdministrationLiveProctoring() {
        onlineTestingAdministrationLiveProctoring = properties.getProperty("ONLINETESTINGADMINISTRATION_LIVEPROCTORING");
        return onlineTestingAdministrationLiveProctoring;
    }

    public String getOnlineTestingAdministrationassessmentPanel() {
        onlineTestingAdministrationassessmentPanel = properties.getProperty("ONLINETESTINGADMINISTRATION_ASSESSMENTPANEL");
        return onlineTestingAdministrationassessmentPanel;
    }

    public String getOnlineTestingAdministrationAnswer() {
        onlineTestingAdministrationAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_ANSWER");
        return onlineTestingAdministrationAnswer;
    }

    public String getTestWithQuickCodeButton() {
        testWithQuickCodeButton = "//a[@class='ot_button ot_quickroster_button btn']";
        return testWithQuickCodeButton;
    }

    public String getOnlineTestingAdministrationFirstAnswerBox() {
        onlineTestingAdministrationFirstAnswerBox = properties.getProperty("ONLINETESTINGADMINISTRATION_FIRSTANSWERBOX");
        return onlineTestingAdministrationFirstAnswerBox;
    }

    public String getOnlineTestingAdministrationSecondAnswerBox() {
        onlineTestingAdministrationSecondAnswerBox = properties.getProperty("ONLINETESTINGADMINISTRATION_SECONDANSWERBOX");
        return onlineTestingAdministrationSecondAnswerBox;
    }

    public String getOnlineTestingAdministrationThirdAnswerBox() {
        onlineTestingAdministrationThirdAnswerBox = properties.getProperty("ONLINETESTINGADMINISTRATION_THIRDANSWERBOX");
        return onlineTestingAdministrationThirdAnswerBox;
    }

    public String getOnlineTestingAdministrationExit() {
        onlineTestingAdministrationExit = properties.getProperty("ONLINETESTINGADMINISTRATION_EXIT");
        return onlineTestingAdministrationExit;
    }

    public String getOnlineTestingAdministrationOverview() {
        onlineTestingAdministrationOverview = properties.getProperty("ONLINETESTINGADMINISTRATION_OVERVIEW");
        return onlineTestingAdministrationOverview;
    }

    public String getOnlineTestingAdministrationOverviewAssessmentButton() {
        onlineTestingAdministrationOverviewAssessmentButton = properties.getProperty("ONLINETESTINGADMINISTRATION_ASSESSMENTBUTTON");
        return onlineTestingAdministrationOverviewAssessmentButton;
    }

    public String getOnlineTestingAdministrationStudentResponse() {
        onlineTestingAdministrationStudentResponse = properties.getProperty("ONLINETESTINGADMINISTRATION_STUDENTRESPONSE");
        return onlineTestingAdministrationStudentResponse;
    }

    public String getOnlineTestingAdministrationviewType() {
        onlineTestingAdministrationviewType = properties.getProperty("ONLINETESTINGADMINISTRATION_VIEWTYPE");
        return onlineTestingAdministrationviewType;
    }

    public String getOnlineTestingAdministrationFindStudents() {
        onlineTestingAdministrationFindStudents = properties.getProperty("ONLINETESTINGADMINISTRATION_FINDSTUDENTS");
        return onlineTestingAdministrationFindStudents;
    }

    public String getOnlineTestingAdministrationEditFirstAnswer() {
        onlineTestingAdministrationEditFirstAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_EDITFIRSTANSWER");
        return onlineTestingAdministrationEditFirstAnswer;
    }

    public String getOnlineTestingAdministrationEditSecondAnswer() {
        onlineTestingAdministrationEditSecondAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_EDITSECONDANSWER");
        return onlineTestingAdministrationEditSecondAnswer;
    }

    public String getOnlineTestingAdministrationEditThirdAnswer() {
        onlineTestingAdministrationEditThirdAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_EDITTHIRDANSWER");
        return onlineTestingAdministrationEditThirdAnswer;
    }

    public String getOnlineTestingAdministrationSaveEdited() {
        onlineTestingAdministrationSaveEdited = properties.getProperty("ONLINETESTINGADMINISTRATION_SAVEEDIT");
        return onlineTestingAdministrationSaveEdited;
    }

    public String getOnlineTestingAdministrationAdvancedDropdown() {
        onlineTestingAdministrationAdvancedDropdown = properties.getProperty("ONLINETESTINGADMINISTRATION_ADVANCEDDROPDOWN");
        return onlineTestingAdministrationAdvancedDropdown;
    }

    public String getOnlineTestingAdministrationDeleteAssessment() {
        onlineTestingAdministrationDeleteAssessment = properties.getProperty("ONLINETESTINGADMINISTRATION_DELETEASSESSMENT");
        return onlineTestingAdministrationDeleteAssessment;
    }

    public String getOnlineTestingAdministrationDeleteAlertPopup() {
        onlineTestingAdministrationDeleteAlertPopup = properties.getProperty("ONLINETESTINGADMINISTRATION_DELETEALERTPOPUP");
        return onlineTestingAdministrationDeleteAlertPopup;
    }

    public String onlineTestingAdministrationDeleteAgree() {
        onlineTestingAdministrationDeleteAgree = properties.getProperty("ONLINETESTINGADMINISTRATION_DELETEAGREE");
        return onlineTestingAdministrationDeleteAgree;
    }

    public String getOnlineTestingAdministrationDeleteSubmit() {
        onlineTestingAdministrationDeleteSubmit = properties.getProperty("ONLINETESTINGADMINISTRATION_DELETESUBMIT");
        return onlineTestingAdministrationDeleteSubmit;
    }

    public String getTestWithQuickCodePostCreationModalExitButton() {
        testWithQuickCodePostCreationModalExitButton = "//*[@id=\"quick-code-message-modal\"]/div[1]/button";
        return testWithQuickCodePostCreationModalExitButton;
    }

    public String getQuickRosterButton() {
        QuickRosterButton = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERBUTTON");
        return QuickRosterButton;
    }

    public String getTestWithQuickCodeCreationModalExitButton() {
        testWithQuickCodeCreationModalExitButton = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTWITHQUICKCODEPOSTCREATIONMODALEXITBUTTON");
        return testWithQuickCodeCreationModalExitButton;
    }

    public String getAccessCode() {
        accessCode = properties.getProperty("ONLINETESTINGADMINISTRATION_ACCESSCODE");
        return accessCode;
    }

    public String getOnlineAdministrationStudentLogin() {
        onlineAdministrationStudentLogin = properties.getProperty("ONLINETESTINGADMINISTRATION_STUDENTLOGIN");
        return onlineAdministrationStudentLogin;
    }

    public String getOlineTestingAdministrationNextButton() {
        olineTestingAdministrationNextButton = properties.getProperty("ONLINETESTINGADMINISTRATION_NEXTBUTTON");
        return olineTestingAdministrationNextButton;
    }

    public String getOnlineTestingAdministrationConfirmButton() {
        onlineTestingAdministrationConfirmButton = properties.getProperty("ONLINETESTINGADMINISTRATION_CONFIRMBUTTON");
        return onlineTestingAdministrationConfirmButton;
    }
}
