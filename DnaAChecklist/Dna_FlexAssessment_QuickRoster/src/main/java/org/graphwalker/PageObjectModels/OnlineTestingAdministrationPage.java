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
    private String onlineTestingAdministrationassessmentPanel, onlineTestingAdministrationviewType, onlineTestingAdministrationfindStudents;
    private String onlineTestingAdministrationQuickRosterButton, onlineTestingAdministrationAccessCode, onlineTestingAdministrationStudentLogin, olineTestingAdministrationNextButton, onlineTestingAdministrationStatusBox, onlineTestingAdministrationForword, onlineTestingAdministrationConfirmButton;
    private String quickRosterExit, backToAssessmentButton, onlineTestingAdministrationTestFinish, onlineTestingAdministrationTestSixthAnswer, onlineTestingAdministrationTestFifthAnswer, onlineTestingAdministrationTestFourthAnswer, onlineTestingAdministrationTestThirdAnswer, onlineTestingAdministrationTestSecondAnswer, onlineTestingAdministrationTestFirstAnswer, onlineTestingAdministrationLiveProctoring;
    private String quickRosterQuestion, quickRosterMc, quickRosterCrAdv, quickRosterCrExp, quickRosterCr, quickRosterMcPtl, quickRosterMcAdv, quickRosterNext;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public OnlineTestingAdministrationPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_QuickRoster", "");
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

    public String getOnlineTestingAdministrationSuccess() {
        onlineTestingAdministrationSuccess = properties.getProperty("ONLINETESTINGADMINISTRATION_SUCCESS");
        return onlineTestingAdministrationSuccess;
    }

    public String getOnlineTestingAdministrationLiveProctoring() {
        onlineTestingAdministrationLiveProctoring = properties.getProperty("ONLINETESTINGADMINISTRATION_LIVEPROCTORING");
        return onlineTestingAdministrationLiveProctoring;
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

    public String getOnlineTestingAdministrationQuickRosterButton() {
        onlineTestingAdministrationQuickRosterButton = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERBUTTON");
        return onlineTestingAdministrationQuickRosterButton;
    }

    public String getQuickRosterExit() {
        quickRosterExit = properties.getProperty("ONLINETESTINGADMINISTRATION_TESTWITHQUICKCODEPOSTCREATIONMODALEXITBUTTON");
        return quickRosterExit;
    }

    public String getOnlineTestingAdministrationAccessCode() {
        onlineTestingAdministrationAccessCode = properties.getProperty("ONLINETESTINGADMINISTRATION_ACCESSCODE");
        return onlineTestingAdministrationAccessCode;
    }

    public String getOnlineTestingAdministrationStudentLogin() {
        onlineTestingAdministrationStudentLogin = properties.getProperty("ONLINETESTINGADMINISTRATION_STUDENTLOGIN");
        return onlineTestingAdministrationStudentLogin;
    }

    public String getOnlineTestingAdministrationNextButton() {
        olineTestingAdministrationNextButton = properties.getProperty("ONLINETESTINGADMINISTRATION_NEXTBUTTON");
        return olineTestingAdministrationNextButton;
    }

    public String getOnlineTestingAdministrationConfirmButton() {
        onlineTestingAdministrationConfirmButton = properties.getProperty("ONLINETESTINGADMINISTRATION_CONFIRMBUTTON");
        return onlineTestingAdministrationConfirmButton;
    }

    public String getOnlineTestingAdministrationForward() {
        onlineTestingAdministrationForword = properties.getProperty("ONLINETESTINGADMINISTRATION_FORWORD");
        return onlineTestingAdministrationForword;
    }

    public String getQuickRosterMc() {
        quickRosterMc = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERMC");
        return quickRosterMc;
    }

    public String getQuickRosterCrAdv() {
        quickRosterCrAdv = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERCRADV");
        return quickRosterCrAdv;
    }

    public String getQuickRosterCrExp() {
        quickRosterCrExp = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERCREXP");
        return quickRosterCrExp;
    }

    public String getQuickRosterCr() {
        quickRosterCr = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERCR");
        return quickRosterCr;
    }

    public String getQuickRosterMcPtl() {
        quickRosterMcPtl = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERMCPTL");
        return quickRosterMcPtl;
    }

    public String getQuickRosterMcAdv() {
        quickRosterMcAdv = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERMCADV");
        return quickRosterMcAdv;
    }

    public String getQuickRosterNext() {
        quickRosterNext = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERNEXT");
        return quickRosterNext;
    }

    public String getQuickRosterQuestion() {
        quickRosterQuestion = properties.getProperty("ONLINETESTINGADMINISTRATION_QUICKROSTERQUESTION");
        return quickRosterQuestion;
    }
}
