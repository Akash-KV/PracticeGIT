package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model Class for OnlineTestingAdministrationPage
 **/
public class OnlineTestingAdministrationPage {
    private String onlineTestingAdministrationportalButton, onlineTestingAdministrationcompleteBar, onlineTestingAdministrationassessmentPanel, onlineTestingAdministrationlistItem, onlineTestingAdministrationviewType, onlineTestingAdministrationfindStudents;
    private String onlineTestingAdministrationStatusBox, onlineTestingAdministrationForword;
    private String onlineTestingAdministrationUsername, onlineTestingAdministrationPassword, onlineTestingAdministrationLogin, onlineTestingAdministrationResetPassword, onlineTestingAdministrationResetPasswordFirst, onlineTestingAdministrationResetPasswordSecond, onlineTestingAdministrationResetPasswordSubmit;
    private String portalAssessment, portalAssessmentStudent, portalSave, windowStart, onlineTestingAdministrationResponse, onlineTestingAdministrationContentType, onlineTestingAdministrationAnswerChoice;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public OnlineTestingAdministrationPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Demo", "");
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

    public String getPortalAssessmentStudent() {
        portalAssessmentStudent = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALASSESSMENT_STUDENT");
        return portalAssessmentStudent;
    }

    public String getPortalAssessment() {
        portalAssessment = properties.getProperty("ONLINETESTINGADMINISTRATION_PORTALASSESSMENT");
        return portalAssessment;
    }
}
