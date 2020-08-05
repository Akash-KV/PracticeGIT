package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model Class for OnlineTestingAdministrationPage
 **/
public class OnlineTestingAdministrationPage {
    private String onlineTestingAdministrationSuccess;
    private String onlineTestingAdministrationportalButton, onlineTestingAdministrationcompleteBar, onlineTestingAdministrationassessmentPanel, onlineTestingAdministrationviewType, onlineTestingAdministrationfindStudents;
    private String onlineTestingAdministrationStatusBox, onlineTestingAdministrationStudentId;
    private String onlineTestingAdministrationUsername, onlineTestingAdministrationPassword, onlineTestingAdministrationLogin, onlineTestingAdministrationResetPassword, onlineTestingAdministrationResetPasswordFirst, onlineTestingAdministrationResetPasswordSecond, onlineTestingAdministrationResetPasswordSubmit;
    private String backToAssessmentButton, onlineTestingAdministrationTestFinish, onlineTestingAdministrationTestSixthAnswer, onlineTestingAdministrationTestFifthAnswer, onlineTestingAdministrationTestFourthAnswer, onlineTestingAdministrationTestThirdAnswer, onlineTestingAdministrationTestSecondAnswer, onlineTestingAdministrationTestFirstAnswer, onlineTestingAdministrationportalAssessmentLink, onlineTestingAdministrationLiveProctoring, popup, portalAssessment, portalAssessmentStudent, portalSave, windowEnd, windowStart, onlineTestingAdministrationResponse, onlineTestingAdministrationContentType, onlineTestingAdministrationAnswerChoice;
    private String onlineTestingAdministrationStartDateHour, onlineTestingAdministrationStartDateMin, onlineTestingAdministrationStartDateTime;
    private String onlineTestingAdministrationEndDateHour, onlineTestingAdministrationEndDateMin, onlineTestingAdministrationEndDateTime;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public OnlineTestingAdministrationPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Portal", "");
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

    public String getOnlineTestingAdministrationviewType() {
        onlineTestingAdministrationviewType = properties.getProperty("ONLINETESTINGADMINISTRATION_VIEWTYPE");
        return onlineTestingAdministrationviewType;
    }

    public String getOnlineTestingAdministrationFindStudents() {
        onlineTestingAdministrationfindStudents = properties.getProperty("ONLINETESTINGADMINISTRATION_FINDSTUDENTS");
        return onlineTestingAdministrationfindStudents;
    }

    public String getOnlineTestingAdministrationStatusBox() {
        onlineTestingAdministrationStatusBox = properties.getProperty("ONLINETESTINGADMINISTRATION_STATUSBOX");
        return onlineTestingAdministrationStatusBox;
    }

    public String getOnlineTestingAdministrationUsername() {
        onlineTestingAdministrationUsername = properties.getProperty("ONLINETESTINGADMINISTRATION_USERNAME");
        return onlineTestingAdministrationUsername;
    }

    public String getOnlineTestingAdministrationPassword() {
        onlineTestingAdministrationPassword = properties.getProperty("ONLINETESTINGADMINISTRATION_PASSWORD");
        return onlineTestingAdministrationPassword;
    }

    public String getOnlineTestingAdministrationSuccess() {
        onlineTestingAdministrationSuccess = properties.getProperty("ONLINETESTINGADMINISTRATION_SUCCESS");
        return onlineTestingAdministrationSuccess;
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

    public String getWindowStart() {
        windowStart = properties.getProperty("ONLINETESTINGADMINISTRATION_WINDOWSTART");
        return windowStart;
    }

    public String getPortalSave() {
        portalSave = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALSAVE");
        return portalSave;
    }

    public String getPortalAssessment() {
        portalAssessment = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALASSESSMENT");
        return portalAssessment;
    }

    public String getWindowEnd() {
        windowEnd = properties.getProperty("ONLINETESTINGADMINISTRATION_WINDOWEND");
        return windowEnd;
    }

    public String getPopup() {
        popup = properties.getProperty("ONLINETESTINGADMINISTRATION_POPUP");
        return popup;
    }

    public String getOnlineTestingAdministrationLiveProctoring() {
        onlineTestingAdministrationLiveProctoring = properties.getProperty("ONLINETESTINGADMINISTRATION_LIVEPROCTORING");
        return onlineTestingAdministrationLiveProctoring;
    }

    public String getOnlineTestingAdministrationportalAssessmentLink() {
        onlineTestingAdministrationportalAssessmentLink = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALASSESSMENTLINK");
        return onlineTestingAdministrationportalAssessmentLink;
    }

    public String getOnlineTestingAdministrationTestFirstAnswer() {
        onlineTestingAdministrationTestFirstAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTFIRSTANSWER");
        return onlineTestingAdministrationTestFirstAnswer;
    }

    public String getOnlineTestingAdministrationTestSixthAnswer() {
        onlineTestingAdministrationTestSixthAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTSIXTHANSWER");
        return onlineTestingAdministrationTestSixthAnswer;
    }

    public String getOnlineTestingAdministrationTestFifthAnswer() {
        onlineTestingAdministrationTestFifthAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTFIFTHANSWER");
        return onlineTestingAdministrationTestFifthAnswer;
    }

    public String getOnlineTestingAdministrationTestFourthAnswer() {
        onlineTestingAdministrationTestFourthAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTFOURTHANSWER");
        return onlineTestingAdministrationTestFourthAnswer;
    }

    public String getOnlineTestingAdministrationTestThirdAnswer() {
        onlineTestingAdministrationTestThirdAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTTHIRDANSWER");
        return onlineTestingAdministrationTestThirdAnswer;
    }

    public String getOnlineTestingAdministrationTestSecondAnswer() {
        onlineTestingAdministrationTestSecondAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTSECONDANSWER");
        return onlineTestingAdministrationTestSecondAnswer;
    }

    public String getOnlineTestingAdministrationTestFinish() {
        onlineTestingAdministrationTestFinish = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTFINISH");
        return onlineTestingAdministrationTestFinish;
    }

    public String getBackToAssessmentButton() {
        backToAssessmentButton = properties.getProperty("ONLINETESTINGADMINISTRATION_BACKTOASSESSMENTBUTTON");
        return backToAssessmentButton;
    }

    public String getOnlineTestingAdministrationStudentId() {
        onlineTestingAdministrationStudentId = properties.getProperty("ONLINETESTINGADMINISTRATION_STUDENTID");
        return onlineTestingAdministrationStudentId;
    }

    public String getOnlineTestingAdministrationStartDateHour() {
        onlineTestingAdministrationStartDateHour = properties.getProperty("ONLINETESTINGADMINISTRATION_STARTDATE_HOUR");
        return onlineTestingAdministrationStartDateHour;
    }

    public String getOnlineTestingAdministrationStartDateHourMin() {
        onlineTestingAdministrationStartDateMin = properties.getProperty("ONLINETESTINGADMINISTRATION_STARTDATE_MIN");
        return onlineTestingAdministrationStartDateMin;
    }

    public String getOnlineTestingAdministrationStartDateHourTime() {
        onlineTestingAdministrationStartDateTime = properties.getProperty("ONLINETESTINGADMINISTRATION_STARTDATE_TIME");
        return onlineTestingAdministrationStartDateTime;
    }

    public String getOnlineTestingAdministrationEndDateHour() {
        onlineTestingAdministrationEndDateHour = properties.getProperty("ONLINETESTINGADMINISTRATION_ENDDATE_HOUR");
        return onlineTestingAdministrationEndDateHour;
    }

    public String getOnlineTestingAdministrationEndDateHourMin() {
        onlineTestingAdministrationEndDateMin = properties.getProperty("ONLINETESTINGADMINISTRATION_ENDDATE_MIN");
        return onlineTestingAdministrationEndDateMin;
    }

    public String getOnlineTestingAdministrationEndDateHourTime() {
        onlineTestingAdministrationEndDateTime = properties.getProperty("ONLINETESTINGADMINISTRATION_ENDDATE_TIME");
        return onlineTestingAdministrationEndDateTime;
    }


}
