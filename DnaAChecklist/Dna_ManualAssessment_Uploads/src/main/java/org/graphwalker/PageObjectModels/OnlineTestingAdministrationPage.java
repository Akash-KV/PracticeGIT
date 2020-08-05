package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for OnlineTestingAdministrationPage
public class OnlineTestingAdministrationPage {
    private String testWithQuickCodeButton;
    private String testWithQuickCodePostCreationModalExitButton;
    private String onlineTestingAdministrationCheckPreview;
    private String onlineTestingAdministrationUploadPreview;
    private String onlineTestingAdministrationCheckPreviewPageLoad;
    private String onlineTestingAdministrationAssessmentRoster;
    private String onlineTestingAdministrationCheckOnlineTesting;
    private String onlineTestingAdministrationCheckPreviewIfPDF;
    private String onlineTestingAdministrationSaveAndReturn;
    private String onlineTestingAdministrationStudentLogin;
    private String onlineTestingAdministrationNext;
    private String onlineTestingAdministrationConfirm;
    private String onlineTestingAdministrationSuccess;
    private String onlineTestingAdministrationQuickRoster;
    private String onlineTestingAdministrationCompleteBarText;
    private String onlineTestingAdministrationCheckPreviewDropdown;
    private String onlineTestingAdministrationCheckPreviewLinkSuccess;
    private String onlineTestingAdministrationCheckPreviewDropdownSelect;
    private String onlineTestingAdministrationPreviewAssessment, onlineTestingAdministrationPreviewButton, onlineTestingAdministrationType, onlineTestingAdministrationCancel, onlineTestingAdministrationBPPage;
    private String onlineTestingAdministrationportalButton, onlineTestingAdministrationcompleteBar, onlineTestingAdministrationassessmentPanel, onlineTestingAdministrationlistItem, onlineTestingAdministrationviewType, onlineTestingAdministrationfindStudents;
    private String onlineTestingAdministrationQuickRosterButton, onlineTestingAdministrationAccessCode, olineTestingAdministrationNextButton, onlineTestingAdministrationStatusBox, onlineTestingAdministrationForword, onlineTestingAdministrationConfirmButton;
    private String onlineTestingAdministrationUsername, onlineTestingAdministrationPassword, onlineTestingAdministrationLogin, onlineTestingAdministrationResetPassword, onlineTestingAdministrationResetPasswordFirst, onlineTestingAdministrationResetPasswordSecond, onlineTestingAdministrationResetPasswordSubmit, onlineTestingAdministrationResetPasswordTakeAssessment;
    private String onlineTestingAdministrationResponse, onlineTestingAdministrationContentType, onlineTestingAdministrationAnswerChoice;
    private String onlineTestingAdministrationSave;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public OnlineTestingAdministrationPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_Uploads", "");
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
    public String getOnlineTestingAdministrationCheckPreview() {
        onlineTestingAdministrationCheckPreview = properties.getProperty("ONLINETESTINGADMINISTRATION_PREVIEWASSESSMENT");
        return onlineTestingAdministrationCheckPreview;
    }

    public String getOnlineTestingAdministrationUploadPreview() {
        onlineTestingAdministrationUploadPreview = properties.getProperty("ONLINETESTINGADMINISTRATION_UPLOADPREVIEW");
        return onlineTestingAdministrationUploadPreview;
    }

    public String getOnlineTestingAdministrationCheckPreviewPageLoad() {
        onlineTestingAdministrationCheckPreviewPageLoad = properties.getProperty("ONLINETESTINGADMINISTRATION_BPPAGE");
        return onlineTestingAdministrationCheckPreviewPageLoad;
    }

    public String getOnlineTestingAdministrationAssessmentRoster() {
        onlineTestingAdministrationAssessmentRoster = properties.getProperty("ONLINETESTINGADMINISTRATION_ASSESSMENTROSTER");
        return onlineTestingAdministrationAssessmentRoster;
    }

    public String getOnlineTestingAdministrationCheckOnlineTesting() {
        onlineTestingAdministrationCheckOnlineTesting = properties.getProperty("ONLINETESTINGADMINISTRATION_CHECKONLINETESTING");
        return onlineTestingAdministrationCheckOnlineTesting;
    }

    public String getOnlineTestingAdministrationCheckPreviewIfPDF() {
        onlineTestingAdministrationCheckPreviewIfPDF = properties.getProperty("ONLINETESTINGADMINISTRATION_TYPE");
        return onlineTestingAdministrationCheckPreviewIfPDF;
    }

    public String getOnlineTestingAdministrationSaveAndReturn() {
        onlineTestingAdministrationSaveAndReturn = properties.getProperty("ONLINETESTINGADMINISTRATION_SAVEANDRETURN");
        return onlineTestingAdministrationSaveAndReturn;
    }

    public String getOnlineTestingAdministrationStudentLogin() {
        onlineTestingAdministrationStudentLogin = properties.getProperty("ONLINETESTINGADMINISTRATION_STUDENTLOGIN");
        return onlineTestingAdministrationStudentLogin;
    }

    public String getOnlineTestingAdministrationNext() {
        onlineTestingAdministrationNext = properties.getProperty("ONLINETESTINGADMINISTRATION_NEXTBUTTON");
        return onlineTestingAdministrationNext;
    }

    public String getOnlineTestingAdministrationConfirm() {
        onlineTestingAdministrationConfirm = properties.getProperty("ONLINETESTINGADMINISTRATION_CONFIRMBUTTON");
        return onlineTestingAdministrationConfirm;
    }

    public String getOnlineTestingAdministrationSuccess() {
        onlineTestingAdministrationSuccess = properties.getProperty("ONLINETESTINGADMINISTRATION_SUCCESS");
        return onlineTestingAdministrationSuccess;
    }

    public String getOnlineTestingAdministrationQuickRoster() {
        onlineTestingAdministrationQuickRoster = properties.getProperty("ONLINETESTINGADMINISTRATION_ACCESSCODE");
        return onlineTestingAdministrationQuickRoster;
    }

    public String getOnlineTestingAdministrationCompleteBarText() {
        onlineTestingAdministrationCompleteBarText = properties.getProperty("ONLINETESTINGADMINISTRATION_COMPLETEBAR");
        return onlineTestingAdministrationCompleteBarText;
    }

    public String getOnlineTestingAdministrationCheckPreviewDropdown() {
        onlineTestingAdministrationCheckPreviewDropdown = properties.getProperty("ONLINETESTINGADMINISTRATION_CHECKPREVIEWDROPDOWN");
        return onlineTestingAdministrationCheckPreviewDropdown;
    }

    public String getOnlineTestingAdministrationCheckPreviewLinkSuccess() {
        onlineTestingAdministrationCheckPreviewLinkSuccess = properties.getProperty("ONLINETESTINGADMINISTRATION_SUCCESS");
        return onlineTestingAdministrationCheckPreviewLinkSuccess;
    }

    public String getOnlineTestingAdministrationCheckPreviewDropdownSelect() {
        onlineTestingAdministrationCheckPreviewDropdownSelect = properties.getProperty("ONLINETESTINGADMINISTRATION_CHECKPREVIEWDROPDOWNSELECT");
        return onlineTestingAdministrationCheckPreviewDropdownSelect;
    }

    public String getTestWithQuickCodeButton() {
        testWithQuickCodeButton = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERBUTTON");
        return testWithQuickCodeButton;
    }

    public String getTestWithQuickCodePostCreationModalExitButton() {
        testWithQuickCodePostCreationModalExitButton = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTWITHQUICKCODEPOSTCREATIONMODALEXITBUTTON");
        return testWithQuickCodePostCreationModalExitButton;
    }

    public String getOnlineTestingAdministrationPreviewAssessment() {
        onlineTestingAdministrationPreviewAssessment = properties.getProperty("ONLINETESTINGADMINISTRATION_PREVIEWASSESSMENT");
        return onlineTestingAdministrationPreviewAssessment;
    }

    public String getOnlineTestingAdministrationPreviewButton() {
        onlineTestingAdministrationPreviewButton = properties.getProperty("ONLINETESTINGADMINISTRATION_PREVIEWBUTTON");
        return onlineTestingAdministrationPreviewButton;
    }

    public String getOnlineTestingAdministrationType() {
        onlineTestingAdministrationType = properties.getProperty("ONLINETESTINGADMINISTRATION_TYPE");
        return onlineTestingAdministrationType;
    }

    public String getOnlineTestingAdministrationCancel() {
        onlineTestingAdministrationCancel = properties.getProperty("ONLINETESTINGADMINISTRATION_CANCEL");
        return onlineTestingAdministrationCancel;
    }

    public String getOnlineTestingAdministrationBPPage() {
        onlineTestingAdministrationBPPage = properties.getProperty("ONLINETESTINGADMINISTRATION_BPPAGE");
        return onlineTestingAdministrationBPPage;
    }

    public String getOnlineTestingAdministrationportalButton() {
        onlineTestingAdministrationportalButton = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALBUTTON");
        return onlineTestingAdministrationportalButton;
    }

    public String getOnlineTestingAdministrationcompleteBar() {
        onlineTestingAdministrationcompleteBar = properties.getProperty("ONLINETESTINGADMINISTRATION_COMPLETEBAR");
        return onlineTestingAdministrationcompleteBar;
    }

    public String getOnlineTestingAdministrationassessmentPanel() {
        onlineTestingAdministrationassessmentPanel = properties.getProperty("ONLINETESTINGADMINISTRATION_ASSESSMENTPANEL");
        return onlineTestingAdministrationassessmentPanel;
    }

    public String getOnlineTestingAdministrationlistItem() {
        onlineTestingAdministrationlistItem = properties.getProperty("ONLINETESTINGADMINISTRATION_LISTITEM");
        return onlineTestingAdministrationlistItem;
    }

    public String getOnlineTestingAdministrationviewType() {
        onlineTestingAdministrationviewType = properties.getProperty("ONLINETESTINGADMINISTRATION_VIEWTYPE");
        return onlineTestingAdministrationviewType;
    }

    public String getOnlineTestingAdministrationFindStudents() {
        onlineTestingAdministrationfindStudents = properties.getProperty("ONLINETESTINGADMINISTRATION_VIEWTYPE");
        return onlineTestingAdministrationfindStudents;
    }

    public String getOnlineTestingAdministrationQuickRosterButton() {
        onlineTestingAdministrationQuickRosterButton = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERBUTTON");
        return onlineTestingAdministrationQuickRosterButton;
    }

    public String getOnlineTestingAdministrationAccessCode() {
        onlineTestingAdministrationAccessCode = properties.getProperty("ONLINETESTINGADMINISTRATION_ACCESSCODE");
        return onlineTestingAdministrationAccessCode;
    }

    public String getOlineTestingAdministrationNextButton() {
        olineTestingAdministrationNextButton = properties.getProperty("ONLINETESTINGADMINISTRATION_NEXTBUTTON");
        return olineTestingAdministrationNextButton;
    }

    public String getOnlineTestingAdministrationConfirmButton() {
        onlineTestingAdministrationConfirmButton = properties.getProperty("ONLINETESTINGADMINISTRATION_CONFIRMBUTTON");
        return onlineTestingAdministrationConfirmButton;
    }

    public String getOnlineTestingAdministrationStatusBox() {
        onlineTestingAdministrationStatusBox = properties.getProperty("ONLINETESTINGADMINISTRATION_STATUSBOX");
        return onlineTestingAdministrationStatusBox;
    }

    public String getOnlineTestingAdministrationForword() {
        onlineTestingAdministrationForword = properties.getProperty("ONLINETESTINGADMINISTRATION_FORWORD");
        return onlineTestingAdministrationForword;
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

    public String getOnlineTestingAdministrationResetPasswordTakeAssessment() {
        onlineTestingAdministrationResetPasswordTakeAssessment = properties.getProperty("ONLINETESTINGADMINISTRATION_TAKEASSESSMENT");
        return onlineTestingAdministrationResetPasswordTakeAssessment;
    }

    public String getOnlineTestingAdministrationResponse() {
        onlineTestingAdministrationResponse = properties.getProperty("ONLINETESTINGADMINISTRATION_RESPONSE");
        return onlineTestingAdministrationResponse;
    }

    public String getOnlineTestingAdministrationContentType() {
        onlineTestingAdministrationContentType = properties.getProperty("ONLINETESTINGADMINISTRATION_CONTENTTYPE");
        return onlineTestingAdministrationContentType;
    }

    public String getOnlineTestingAdministrationAnswerChoice() {
        onlineTestingAdministrationAnswerChoice = properties.getProperty("ONLINETESTINGADMINISTRATION_ANSWERCHOICE");
        return onlineTestingAdministrationAnswerChoice;
    }

    public String getOnlineTestingAdministrationSave() {
        onlineTestingAdministrationSave = properties.getProperty("ONLINETESTINGADMINISTRATION_SAVE");
        return onlineTestingAdministrationSave;
    }
}
