import Controllers.ControlPanelController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for ControlPanel
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ControlPanelTest extends ExecutionContext implements ControlPanel {

    ControlPanelController controlPanelController = new ControlPanelController();

    //Validate Control panel
    public void v_VerifyControlPanel() {
    }

    //Click on e_ClickControl Panel Icon
    public void e_ClickControlPanelIcon() {
        controlPanelController.ClickControlPanelIcon();
    }

    //validate Login Information Elements
    public void v_VerifyLoginInformationElements() {
        controlPanelController.VerifyLoginInformationElements();
    }

    //click on Notification Preferences Link
    public void e_ClickNotificationPreferencesLink() {
        controlPanelController.ClickNotificationPreferencesLink();
    }

    //Validate Notification Preferences Page
    public void v_VerifyNotificationPreferencesPage() {
        controlPanelController.VerifyNotificationPreferencesPage();
    }

    //Click on change password link
    public void e_ClickChangePasswordLink() {
        controlPanelController.ClickChangePasswordLink();
    }

    //validate change password page
    public void v_VerifyChangePasswordPage() {
        controlPanelController.VerifyChangePasswordPage();
    }

    //Click Substitute Teacher Link
    public void e_ClickSubstituteTeacherLink() {
        controlPanelController.ClickSubstituteTeacherLink();
    }

    //validate substitute Teacher Page
    public void v_VerifySubstituteTeacherPage() {
        controlPanelController.VerifySubstituteTeacherPage();
    }

    //Click on Illuminate HelpCenter Link
    public void e_ClickIlluminateHelpCenterLink() {
        controlPanelController.ClickIlluminateHelpCenterLink();
    }

    //Verify HelpCenter Page
    public void v_VerifyHelpCenterPage() {
        controlPanelController.VerifyHelpCenterPage();
    }

    //Click on SendUs Positive FeedbackLink
    public void e_ClickSendUsPositiveFeedbackLink() {
        controlPanelController.ClickSendUsPositiveFeedbackLink();
    }

    //Verify FeedbackPage
    public void v_VerifyFeedbackPage() {
        controlPanelController.VerifyFeedbackPage();
    }

    //Click on ViewMyBadges Link
    public void e_ClickViewMyBadgesLink() {
        controlPanelController.ClickViewMyBadgesLink();
    }

    //Verify Badges Page
    public void v_VerifyBadgesPage() {
        controlPanelController.VerifyBadgesPage();
    }

    //Click Scheduled Jobs Link
    public void e_ClickScheduledJobsLink() {
        controlPanelController.ClickScheduledJobsLink();
    }

    //Verify Scheduled Jobs Page
    public void v_VerifyScheduledJobsPage() {
        controlPanelController.VerifyScheduledJobsPage();
    }

    //Click PrivacyPolicy Link
    public void e_ClickPrivacyPolicyLink() {
        controlPanelController.ClickPrivacyPolicyLink();
    }

    //Verify Privacy Policy Page
    public void v_VerifyPrivacyPolicyPage() {
        controlPanelController.VerifyPrivacyPolicyPage();
    }

    //Click SaveChanges Button
    public void e_ClickSaveChangesButton() {
        controlPanelController.ClickSaveChangesButton();
    }

    //Verify ControlPanel Modal
    public void v_VerifyControlPanelModal() {
        controlPanelController.VerifyControlPanelModal();
    }

    //Click Change Button
    public void e_ClickChangeButton() {
        controlPanelController.ClickChangeButton();
    }

    //Verify Custom FiltersPage
    public void v_VerifyCustomFiltersPage() {
        controlPanelController.VerifyCustomFiltersPage();
    }

    //Click Notification Icon
    public void e_ClickNotificationIcon() {
        controlPanelController.ClickNotificationIcon();
    }

    //Verify Notification Elements
    public void v_VerifyNotificationElements() {
        controlPanelController.VerifyNotificationElements();
    }
}

