package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for ControlPanelPage
 **/
public class ControlPanelPage {
    private String controlPanelIcon, controlPanelHeader, controlPanelModal, loginInformation, notificationPreferenceLink;
    private String notificationPreferenceHeader, changePasswordLink, changePasswordHeader, substituteTeacherLink, signOutLink;
    private String selectTeacherHeader, illuminateHelpCenterLink, helpEmailLink, positiveFeedbackHeader, badgesHeader, scheduledJobsHeader;
    private String feedbackLink, viewMyBadgesLink, scheduledJobsLink, privacyPolicyLink, enrollElementDateTextBox;
    private String notificationIcon, siteDropDown, studentGroupDropDown, saveChangesButton, cancelButton, changeButton, setCustomFiltersButton;
    private String dateImage, todayButton, dateField, clearNotification, controlPanelPopup, signOut, notificationCleared;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ControlPanelPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_ControlPanel", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ControlPanelPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ControlPanelPage.properties");
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

    /**
     * Methods to read the data from Property file
     **/

    public String getControlPanelIcon() {
        controlPanelIcon = properties.getProperty("CONTROL_PANEL_ICON");
        return controlPanelIcon;
    }

    public String getControlPanelModal() {
        controlPanelModal = properties.getProperty("CONTROL_PANEL_MODEL");
        return controlPanelModal;
    }

    public String getControlPanelHeader() {
        controlPanelHeader = properties.getProperty("CONTROL_PANEL_HEADER");
        return controlPanelHeader;
    }

    public String getLoginInformation() {
        loginInformation = properties.getProperty("LOGIN_INFORMATION");
        return loginInformation;
    }

    public String getNotificationPreferenceLink() {
        notificationPreferenceLink = properties.getProperty("NOTIFICATION_PREFERENCE_LINK");
        return notificationPreferenceLink;
    }

    public String getNotificationPreferenceHeader() {
        notificationPreferenceHeader = properties.getProperty("NOTIFICATION_PREFERENCE_HEADER");
        return notificationPreferenceHeader;
    }

    public String getChangePasswordLink() {
        changePasswordLink = properties.getProperty("CHANGE_PASSWORD_LINK");
        return changePasswordLink;
    }

    public String getChangePasswordHeader() {
        changePasswordHeader = properties.getProperty("CHANGE_PASSWORD_HEADER");
        return changePasswordHeader;
    }

    public String getControlPanelPopup() {
        controlPanelPopup = properties.getProperty("CONTROLPANEL_POPUP");
        return controlPanelPopup;
    }

    public String getSubstituteTeacherLink() {
        substituteTeacherLink = properties.getProperty("SUBSTITUTE_TEACHER_LINK");
        return substituteTeacherLink;
    }

    public String getSelectTeacherHeader() {
        selectTeacherHeader = properties.getProperty("SELECT_TEACHER_HEADER");
        return selectTeacherHeader;
    }

    public String getSignOutLink() {
        signOutLink = properties.getProperty("SIGNOUT_LINK");
        return signOutLink;
    }

    public String getIlluminateHelpCenterLink() {
        illuminateHelpCenterLink = properties.getProperty("ILLUMINATE_HELP_CENTER_LINK");
        return illuminateHelpCenterLink;
    }

    public String getHelpEmailLink() {
        helpEmailLink = properties.getProperty("HELP_EMAIL_LINK");
        return helpEmailLink;
    }

    public String getFeedbackLink() {
        feedbackLink = properties.getProperty("FEEDBACK_LINK");
        return feedbackLink;
    }

    public String getPositiveFeedbackHeader() {
        positiveFeedbackHeader = properties.getProperty("POSITIVE_FEEDBACK_HEADER");
        return positiveFeedbackHeader;
    }

    public String getViewMyBadgesLink() {
        viewMyBadgesLink = properties.getProperty("VIEW_MY_BADGES_LINK");
        return viewMyBadgesLink;
    }

    public String getBadgesHeader() {
        badgesHeader = properties.getProperty("BADGES_HEADER");
        return badgesHeader;
    }

    public String getScheduledJobsLink() {
        scheduledJobsLink = properties.getProperty("SHEDULED_JOBS_LINK");
        return scheduledJobsLink;
    }

    public String getScheduledJobsHeader() {
        scheduledJobsHeader = properties.getProperty("SELECT_JOBS_HEADER");
        return scheduledJobsHeader;
    }

    public String getPrivacyPolicyLink() {
        privacyPolicyLink = properties.getProperty("PRIVACY_POLICY_LINK");
        return privacyPolicyLink;
    }

    public String getEnrollElementDateTextBox() {
        enrollElementDateTextBox = properties.getProperty("ENROLLMENT_DATE_TEXTBOX");
        return enrollElementDateTextBox;
    }

    public String getSiteDropDown() {
        siteDropDown = properties.getProperty("SITE_DROPDOWN");
        return siteDropDown;
    }

    public String getStudentGroupDropDown() {
        studentGroupDropDown = properties.getProperty("STUDENT_GROUP_DROPDOWN");
        return studentGroupDropDown;
    }

    public String getSaveChangesButton() {
        saveChangesButton = properties.getProperty("SAVE_CHANGES_BUTTON");
        return saveChangesButton;
    }

    public String getCancelButton() {
        cancelButton = properties.getProperty("CANCEL_BUTTON");
        return cancelButton;
    }

    public String getChangeButton() {
        changeButton = properties.getProperty("CHANGE_BUTTON");
        return changeButton;
    }

    public String getSetCustomFiltersButton() {
        setCustomFiltersButton = properties.getProperty("SET_CUSTEMER_FILTER_BUTTON");
        return setCustomFiltersButton;
    }

    public String getNotificationIcon() {
        notificationIcon = properties.getProperty("NOTIFICATION_ICON");
        return notificationIcon;
    }

    public String getDateImage() {
        dateImage = properties.getProperty("DATE_IMAGE");
        return dateImage;
    }

    public String getTodayButton() {
        todayButton = properties.getProperty("TODAY_BUTTON");
        return todayButton;
    }

    public String getDateField() {
        dateField = properties.getProperty("DATE_FIELD");
        return dateField;
    }

    public String getClearNotification() {
        clearNotification = properties.getProperty("CLEAR_NOTIFICATION");
        return clearNotification;
    }

    public String getNotificationCleared() {
        notificationCleared = properties.getProperty("NOTIFICATION_CLEARED");
        return notificationCleared;
    }

    public String getSignOut() {
        signOut = properties.getProperty("SIGN_OUT");
        return signOut;
    }


}
