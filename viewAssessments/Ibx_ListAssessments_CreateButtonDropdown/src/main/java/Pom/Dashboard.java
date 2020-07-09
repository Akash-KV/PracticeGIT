package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for Dashboard
public class Dashboard {
    private String assessmentsNav, attendanceNav, behaviorNav, counselorNav, gradebookNav, gradesNav, healthNav, languageNav, reportsNav;
    private String schedulingNav, clickBackManualHybrid, manualHybridClose, surveyClick, clickOtherTabTwo;
    private String specEdNav, legacyCreateModel, legacyText, legacyCreateModelTwo, legacyTextTwo, checkLegacyTab, manualHybridAssessment;
    private String studentsNav, skillsCreate, clickCreateButton, clickOtherTab, otherCreateAssessmentTab, summaryCreateModel, demographicCreateModel;
    private String dropdown, listOfAssessment, onTheFlyAssement, clickBack, createAssessmentModel, flexibleCreateModelBody, itemBankCreateModelBody;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public Dashboard() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ListAssessments_CreateButtonDropdown", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\Dashboard.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/Dashboard.properties");
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

    public String getAssessmentsNav() {
        assessmentsNav = properties.getProperty("ASSESSMENT_NAV");
        return assessmentsNav;
    }

    public String getAttendanceNav() {
        return attendanceNav;
    }

    public String getCounselorNav() {
        return counselorNav;
    }

    public String getGradebookNav() {
        return gradebookNav;
    }

    public String getGradesNav() {
        return gradesNav;
    }

    public String getHealthNav() {
        return healthNav;
    }

    public String getLanguageNav() {
        return languageNav;
    }

    public String getReportsNav() {
        return reportsNav;
    }

    public String getSchedulingNav() {
        return schedulingNav;
    }

    public String getSpecEdNav() {
        return specEdNav;
    }

    public String getStudentsNav() {
        return studentsNav;
    }

    public String getDropdown() {
        dropdown = properties.getProperty("DROPDOWN");
        return dropdown;
    }

    public String getListOfAssessment() {
        listOfAssessment = properties.getProperty("LIST_OF_ASSESSMENT");
        return listOfAssessment;
    }

    public String getOnTheFlyAssement() {
        onTheFlyAssement = properties.getProperty("ON_THE_FLY_ASSESSMENT");
        return onTheFlyAssement;
    }

    public String getClickBack() {
        clickBack = properties.getProperty("CLICK_BACK");
        return clickBack;
    }

    public String getCreateAssessmentModel() {
        createAssessmentModel = properties.getProperty("CREATE_ASSESSMENT_MODEL");
        return createAssessmentModel;
    }

    public String getFlexibleCreateModelBody() {
        flexibleCreateModelBody = properties.getProperty("FLEXIBLE_CREATE_MODEL_BODY");
        return flexibleCreateModelBody;
    }

    public String getItemBankCreateModelBody() {
        itemBankCreateModelBody = properties.getProperty("ITEMBANK_CREATE_MODEL_BODY");
        return itemBankCreateModelBody;
    }

    public String getSkillsCreate() {
        skillsCreate = properties.getProperty("SKILLS_CREATE");
        return skillsCreate;
    }

    public String getClickCreateButton() {
        clickCreateButton = properties.getProperty("CLICK_CREATE_BUTTON");
        return clickCreateButton;
    }

    public String getClickOtherTab() {
        clickOtherTab = properties.getProperty("CLICK_OTHER_TAB");
        return clickOtherTab;
    }

    public String getClickOtherTabTwo() {
        clickOtherTabTwo = properties.getProperty("CLICK_OTHER_TAB_TWO");
        return clickOtherTabTwo;
    }

    public String getOtherCreateAssessmentTab() {
        otherCreateAssessmentTab = properties.getProperty("OTHER_CREATE_ASSESSMENT_TAB");
        return otherCreateAssessmentTab;
    }

    public String getSummaryCreateModel() {
        summaryCreateModel = properties.getProperty("SUMMARY_CREATE_MODEL");
        return summaryCreateModel;
    }

    public String getDemographicCreateModel() {
        demographicCreateModel = properties.getProperty("DEMOGRAPHIC_CREATE_MODEL");
        return demographicCreateModel;
    }

    public String getLegacyCreateModel() {
        legacyCreateModel = properties.getProperty("LEGACY_CREATE_MODEL");
        return legacyCreateModel;
    }

    public String getLegacyText() {
        legacyText = properties.getProperty("LEGACY_TEXT");
        return legacyText;
    }

    public String getLegacyCreateModelTwo() {
        legacyCreateModelTwo = properties.getProperty("LEGACY_CREATE_MODEL_TWO");
        return legacyCreateModelTwo;
    }

    public String getLegacyTextTwo() {
        legacyTextTwo = properties.getProperty("LEGACY_TEXT_TWO");
        return legacyTextTwo;
    }

    public String getCheckLegacyTab() {
        checkLegacyTab = properties.getProperty("CHECK_LEGACY_TAB");
        return checkLegacyTab;
    }

    public String getManualHybridAssessment() {
        manualHybridAssessment = properties.getProperty("MANUAL_HYBRID_ASSESSMENT");
        return manualHybridAssessment;
    }

    public String getClickBackManualHybrid() {
        clickBackManualHybrid = properties.getProperty("CLICK_BACK_MANUAL_HYBRID");
        return clickBackManualHybrid;
    }

    public String getManualHybridClose() {
        manualHybridClose = properties.getProperty("MANUAL_HYBRID_CLOSE");
        return manualHybridClose;
    }

    public String getSurveyClick() {
        surveyClick = properties.getProperty("SURVEY_CLICK");
        return surveyClick;
    }
}