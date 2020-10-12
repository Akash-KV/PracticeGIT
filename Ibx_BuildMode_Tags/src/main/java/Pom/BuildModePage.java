package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BuildModePage
 **/
public class BuildModePage {

    private static String build_Item_Section, build_TagsLink, build_TagsAssessmentSettingsPopupHeader, build_TagsAssessmentSettingsPopupCloseIcon;
    private static String build_TagsAssessmentSettingsPopupAssessmentYearInput, build_TagsAssessmentSettingsPopupSubjectsInput, build_TagsAssessmentSettingsPopupGradeLevelsInput;
    private static String build_Mode_Tags_First_Date_Administer, build_TagsAssessmentSettingsPopupFirstDateAdministeredInput;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Tags", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\BuildModePage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/BuildModePage.properties");
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
     * Methods to read locators from Property file
     **/

    public String getBuild_Item_Section() {
        build_Item_Section = properties.getProperty("BUILD_ITEM_SECTION");
        return build_Item_Section;
    }

    public String getBuild_TagsLink() {
        build_TagsLink = properties.getProperty("BUILD_TAGSLINK");
        return build_TagsLink;
    }

    public String getBuild_TagsAssessmentSettingsPopupHeader() {
        build_TagsAssessmentSettingsPopupHeader = properties.getProperty("BUILD_TAGS_ASSESSMENTSETTINGSPOPUPHEADER");
        return build_TagsAssessmentSettingsPopupHeader;
    }

    public String getBuild_TagsAssessmentSettingsPopupCloseIcon() {
        build_TagsAssessmentSettingsPopupCloseIcon = properties.getProperty("BUILD_TAGS_ASSESSMENTSETTINGSPOPUPCLOSEICON");
        return build_TagsAssessmentSettingsPopupCloseIcon;
    }

    public String getBuild_TagsAssessmentSettingsPopupAssessmentYearInput() {
        build_TagsAssessmentSettingsPopupAssessmentYearInput = properties.getProperty("BUILD_TAGS_ASSESSMENTSETTINGSPOPUPASSESSMENTYEARINPUT");
        return build_TagsAssessmentSettingsPopupAssessmentYearInput;
    }

    public String getBuild_TagsAssessmentSettingsPopupSubjectsInput() {
        build_TagsAssessmentSettingsPopupSubjectsInput = properties.getProperty("BUILD_TAGS_ASSESSMENTSETTINGSPOPUPSUBJECTSINPUT");
        return build_TagsAssessmentSettingsPopupSubjectsInput;
    }

    public String getBuild_TagsAssessmentSettingsPopupGradeLevelsInput() {
        build_TagsAssessmentSettingsPopupGradeLevelsInput = properties.getProperty("BUILD_TAGS_ASSESSMENTSETTINGSPOPUPGRADELEVELSINPUT");
        return build_TagsAssessmentSettingsPopupGradeLevelsInput;
    }

    public String getBuild_TagsAssessmentSettingsPopupFirstDateAdministeredInput() {
        build_TagsAssessmentSettingsPopupFirstDateAdministeredInput = properties.getProperty("BUILD_TAGS_ASSESSMENTSETTINGSPOPUPFIRSTDATEADMINISTEREDINPUT");
        return build_TagsAssessmentSettingsPopupFirstDateAdministeredInput;
    }

    public String getBuild_Mode_Tags_First_Date_Administer() {
        build_Mode_Tags_First_Date_Administer = properties.getProperty("BUILD_MODE_TAGS_FIRST_DATE_ADMINISTER");
        return build_Mode_Tags_First_Date_Administer;
    }
}