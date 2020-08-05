package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class OnlineTestingAdministrationPage {

    private String portalButton, success, exit, answertext, firstAnswerBox, secondAnswerBox, thirdAnswerBox, assessmentPanel, finishButton, onlineTestingAdministrationStudentId;
    private String liveProctoring, statusBox, secondAnswer, thirdAnswer, firstAnswer, nextQuestionButton, firstChoice, studentsSecondOption, takeAssessment, resetPasswordSubmit;
    private String resetPasswordFirst, resetPasswordSecond, resetPassword, username, password, login, completeBar, windowStart, windowEnd, portalSave;
    private String onlineTestingAdministrationStartDateHour, onlineTestingAdministrationStartDateMin, onlineTestingAdministrationStartDateTime;
    private String onlineTestingAdministrationEndDateHour, onlineTestingAdministrationEndDateMin, onlineTestingAdministrationEndDateTime;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public OnlineTestingAdministrationPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ItembankAssessment_Rostering", "");
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

    public String getPortalButton() {
        portalButton = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALBUTTON");
        return portalButton;
    }

    public String getStudentsSecondOption() {
        studentsSecondOption = properties.getProperty("ONLINETESTINGADMINISTRATION_STUDENTS_SECONDOPTION");
        return studentsSecondOption;
    }

    public String getWindowStart() {
        windowStart = properties.getProperty("ONLINETESTINGADMINISTRATION_WINDOWSTART");
        return windowStart;
    }

    public String getWindowEnd() {
        windowEnd = properties.getProperty("ONLINETESTINGADMINISTRATION_WINDOWEND");
        return windowEnd;
    }

    public String getPortalSave() {
        portalSave = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALSAVE");
        return portalSave;
    }

    public String getCompleteBar() {
        completeBar = properties.getProperty("ONLINETESTINGADMINISTRATION_COMPLETEBAR");
        return completeBar;
    }

    public String getUsername() {
        username = properties.getProperty("ONLINETESTINGADMINISTRATION_USERNAME");
        return username;
    }

    public String getLogin() {
        login = properties.getProperty("ONLINETESTINGADMINISTRATION_LOGIN");
        return login;
    }

    public String getPassword() {
        password = properties.getProperty("ONLINETESTINGADMINISTRATION_PASSWORD");
        return password;
    }

    public String getResetPassword() {
        resetPassword = properties.getProperty("ONLINETESTINGADMINISTRATION_RESETPASSWORD");
        return resetPassword;
    }

    public String getResetPasswordSecond() {
        resetPasswordSecond = properties.getProperty("ONLINETESTINGADMINISTRATION_RESETPASSWORDSECOND");
        return resetPasswordSecond;
    }

    public String getResetPasswordFirst() {
        resetPasswordFirst = properties.getProperty("ONLINETESTINGADMINISTRATION_RESETPASSWORDFIRST");
        return resetPasswordFirst;
    }

    public String getResetPasswordSubmit() {
        resetPasswordSubmit = properties.getProperty("ONLINETESTINGADMINISTRATION_RESETPASSWORDSUBMIT");
        return resetPasswordSubmit;
    }

    public String getTakeAssessment() {
        takeAssessment = properties.getProperty("ONLINETESTINGADMINISTRATION_TAKEASSESSMENT");
        return takeAssessment;
    }

    public String getSuccess() {
        success = properties.getProperty("ONLINETESTINGADMINISTRATION_SUCCESS");
        return success;
    }

    public String getFirstChoice() {
        firstChoice = properties.getProperty("ONLINETESTINGADMINISTRATION_FIRSTCHOICE");
        return firstChoice;
    }

    public String getStatusBox() {
        statusBox = properties.getProperty("ONLINETESTINGADMINISTRATION_STATUSBOX");
        return statusBox;
    }

    public String getNextQuestionButton() {
        nextQuestionButton = properties.getProperty("ONLINETESTINGADMINISTRATION_NEXTQUESTIONBUTTON");
        return nextQuestionButton;
    }

    public String getFirstAnswer() {
        firstAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_FIRSTANSWER");
        return firstAnswer;
    }

    public String getThirdAnswer() {
        thirdAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_THIRDANSWER");
        return thirdAnswer;
    }

    public String getSecondAnswer() {
        secondAnswer = properties.getProperty("ONLINETESTINGADMINISTRATION_SECONDANSWER");
        return secondAnswer;
    }

    public String getFinishButton() {
        finishButton = properties.getProperty("ONLINETESTINGADMINISTRATION_FINISHBUTTON");
        return finishButton;
    }

    public String getLiveProctoring() {
        liveProctoring = properties.getProperty("ONLINETESTINGADMINISTRATION_LIVEPROCTORING");
        return liveProctoring;
    }

    public String getAssessmentPanel() {
        assessmentPanel = properties.getProperty("ONLINETESTINGADMINISTRATION_ASSESSMENTPANEL");
        return assessmentPanel;
    }

    public String getThirdAnswerBox() {
        thirdAnswerBox = properties.getProperty("ONLINETESTINGADMINISTRATION_THIRDANSWERBOX");
        return thirdAnswerBox;
    }

    public String getSecondAnswerBox() {
        secondAnswerBox = properties.getProperty("ONLINETESTINGADMINISTRATION_SECONDANSWERBOX");
        return secondAnswerBox;
    }

    public String getFirstAnswerBox() {
        firstAnswerBox = properties.getProperty("ONLINETESTINGADMINISTRATION_FIRSTANSWERBOX");
        return firstAnswerBox;
    }

    public String getExit() {
        exit = properties.getProperty("ONLINETESTINGADMINISTRATION_EXIT");
        return exit;
    }

    public String getAnswertext() {
        answertext = properties.getProperty("ONLINETESTINGADMINISTRATION_ANSWERTEXT");
        return answertext;
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
