package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for ViewAssessmentsPage
public class ViewAssessmentsPage {
    private String createdByMe, createdByMeHeader, addFilters, flexibleActionList, itemBankDuplicateClose, ptfAssessmentStudentResponse;
    private String assessmentsDataTable, actionDropDown, actionDropDownOption, showDropdown, assessmentActionDropDown, flexibleActionDropDown, fluenceActionDropDown;
    private String surveyActionDropDown, demographicsActionDropDown, summaryActionDropDown, assessmentViewActionDropDown, skillsAssessmentActionDropDown, pftAssessmentActionDropDown, actionDropDownOptions;
    private String assessmentActionDropDownOptions, flexibleActionDropDownOptions, fluenceActionDropDownOptions, surveyActionDropDownOptions, demographicsActionDropDownOptions, summaryActionDropDownOptions, assessmentViewActionDropDownOptions, skillsAssessmentActionDropDownOptions, pftAssessmentActionDropDownOptions;
    private String onlineAssessmentPreviewHeader, previewButton, itemBankActionMenuOptionsScan;
    private String showAssessmentsWithoutDataToggleButton, hasStudentResponse, itemBankActionMenuOptionsDuplicate, itemBankActionMenuOptionsDelete;
    private String deleteAlertMessage, deleteAssessementButton, deleteUnderstandCheckbox, deleteAgreeCheckbox;
    private String alertSuccess, assessmentsList, functionDropDown, submitButton, itemBankActionMenuOptionsViewResult;
    private String editAssessmentModal, closeEditAssessmentModalIcon, alertContainer, nevermindButton;
    private String unpublishedItemBankLink, unpublishedItemBankHeader, returnToIlluminateIcon, itmBankActionList;
    private String itemBankActionDropDownOptionsList, assessmentActionDropDownOptionsList, flexibleActionDropDownOptionsList, fluenceActionDropDownOptionsList, surveyActionDropDownOptionsList;
    private String demographicsActionDropDownOptionsList, summaryActionDropDownOptionsList, assessmentViewActionDropDownOptionsList, skillsAssessmentActionDropDownOptionsList, pftAssessmentActionDropDownOptionsList;
    private String pftStudentResponseHeader;

    private String searchText;
    private String addFilter;
    private String viewResult;
    private String itemBank;
    private String skillsAssessmentDuplicateButton;
    private String itemBankActionMenuOptionsShare;
    private String itemBankActionMenuOptionsAdminister;
    private String itemBankActionMenuOptionsPreview;

    private String typeAssessment;
    private String assessmentTitle;
    private String actionDropDownOptionsEdit;
    private String summaryAssessment;
    private String assessmentView;
    private String skillsAssessment;
    private String poolAssessment;
    private String stateAndNationalPublisher;
    private String typePFT;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_ActionMenu", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ViewAssessmentsPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ViewAssessmentsPage.properties");
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

    public String getSkillsDuplicate() {
        skillsDuplicate = properties.getProperty("SKILLS_DUPLICATE");
        return skillsDuplicate;
    }

    private String skillsDuplicate;

    public String getItemBankDuplicateDismiss() {
        DuplicateDismiss = properties.getProperty("ITEMBANK_DUPLICATE_DISSMISS");
        return DuplicateDismiss;
    }

    private String DuplicateDismiss;

    public String getItembankDuplicate() {
        itembankDuplicate = properties.getProperty("ITEMBANK_DUPLICATE");
        return itembankDuplicate;
    }

    private String itembankDuplicate;

    public String getPublishItemBank() {
        publishItemBank = properties.getProperty("PUBLISH_ITEMBANK");
        return publishItemBank;
    }

    private String publishItemBank;

    public String getNoDataAvailableInTable() {
        noDataAvailableInTable = properties.getProperty("NO_DATA_AVAILABLE_IN_TABLE");
        return noDataAvailableInTable;
    }

    private String noDataAvailableInTable;

    public String getItemBankTitle() {
        itemBankTitle = properties.getProperty("ITEMBANK_TITLE");
        return itemBankTitle;
    }

    private String itemBankTitle;

    public String getAssessmentViewTitle() {
        assessmentViewTitle = properties.getProperty("ASSESSMENT_VIEW_TITLE");
        return assessmentViewTitle;
    }

    private String assessmentViewTitle;

    public String getSummaryCopyTitle() {
        summaryCopyTitle = properties.getProperty("SUMMARY_COPY_TITEL");
        return summaryCopyTitle;
    }

    private String summaryCopyTitle;

    public String getMassCheckBox() {
        massCheckBox = properties.getProperty("MASS_CHECKBOX");
        return massCheckBox;
    }

    private String massCheckBox;

    public String getMassSubmit() {
        massSubmit = properties.getProperty("MASS_SUBMIT");
        return massSubmit;
    }

    private String massSubmit;

    public String getMassDropdown() {
        massDropdown = properties.getProperty("MASS_DROPDOWN");
        return massDropdown;
    }

    private String massDropdown;

    public String getSummaryTitle() {
        summaryTitle = properties.getProperty("SUMMARY_TITLE");
        return summaryTitle;
    }

    private String summaryTitle;

    public String getFlexibleTitle() {
        flexibleTitle = properties.getProperty("FLEXIBLE_TITLE");
        return flexibleTitle;
    }

    private String flexibleTitle;

    public String getCancelAddFilter() {
        cancelAddFilter = properties.getProperty("CANCEL_ADD_FILTER");
        return cancelAddFilter;
    }

    private String cancelAddFilter;

    public String getSearchButton() {
        searchButton = properties.getProperty("SEARCH_TEXT_BOX_BUTTON");
        return searchButton;
    }

    private String searchButton;

    public String getSearchText() {
        searchText = properties.getProperty("SEARCH_ASSESSMENTSBAR");
        return searchText;
    }


    public String getItemBankActionMenuOptionsShare() {
        itemBankActionMenuOptionsShare = properties.getProperty("ITEMBANK_ACTON_DROPDOWN_OPTIONS_SHARE");
        return itemBankActionMenuOptionsShare;
    }

    public String getitemBankActionMenuOptionsAdminister() {
        itemBankActionMenuOptionsAdminister = properties.getProperty("ITEMBANK_ACTON_DROPDOWN_OPTIONS_ADMINISTER");
        return itemBankActionMenuOptionsAdminister;
    }

    public String getitemBankActionMenuOptionsPreview() {
        itemBankActionMenuOptionsPreview = properties.getProperty("ITEMBANK_ACTON_DROPDOWN_OPTIONS_PREVIEW");
        return itemBankActionMenuOptionsPreview;
    }

    public String getitemBankActionMenuOptionsScan() {
        itemBankActionMenuOptionsScan = properties.getProperty("ITEMBANK_ACTON_DROPDOWN_OPTIONS_SCAN");
        return itemBankActionMenuOptionsScan;
    }

    public String getitemBankActionMenuOptionsViewResult() {
        itemBankActionMenuOptionsViewResult = properties.getProperty("ITEMBANK_ACTON_DROPDOWN_OPTIONS_VIEW_RESULT");
        return itemBankActionMenuOptionsViewResult;
    }

    public String getitemBankActionMenuOptionsDuplicate() {
        itemBankActionMenuOptionsDuplicate = properties.getProperty("ITEMBANK_ACTON_DROPDOWN_OPTIONS_DUPLICATE");
        return itemBankActionMenuOptionsDuplicate;
    }

    public String getitemBankDuplicateClose() {
        itemBankDuplicateClose = properties.getProperty("ITEMBANK_DUPLICATE_CLOSE");
        return itemBankDuplicateClose;
    }

    public String getitemBankActionMenuOptionsDelete() {
        itemBankActionMenuOptionsDelete = properties.getProperty("ITEMBANK_ACTON_DROPDOWN_OPTIONS_DELETE");
        return itemBankActionMenuOptionsDelete;
    }

    public String getCreatedByMe() {
        createdByMe = properties.getProperty("CREATED_BY_ME");
        return createdByMe;
    }

    public String getCreatedByMeHeader() {
        createdByMeHeader = properties.getProperty("CREATED_BY_ME_HEADER");
        return createdByMeHeader;
    }

    public String getAddFilters() {
        addFilters = properties.getProperty("ADD_FILTERS");
        return addFilters;
    }

    public String getShowDropdown() {
        showDropdown = properties.getProperty("SHOW_DROPDOWN");
        return showDropdown;
    }

    public String getAssessmentsDataTable() {
        assessmentsDataTable = properties.getProperty("ASSESSMENT_DATA_TABLE");
        return assessmentsDataTable;
    }

    public String getActionDropDown() {
        actionDropDown = properties.getProperty("ITEMBANK_ACTON_DROPDOWN_OPTIONS_LIST");
        return actionDropDown;
    }

    public String getViewResultActionDropdown() {
        viewResult = properties.getProperty("ITEMBANK_VIEW_RESULT_ACTION_DROPDOWN");
        return viewResult;
    }

    public String getFlexibleActionList() {
        flexibleActionList = properties.getProperty("FLEXIBLE_ACTION_LIST");
        return flexibleActionList;
    }

    public String getAssessmentActionDropDown() {
        assessmentActionDropDown = properties.getProperty("ASSESSMENT_ACTON_DROPDOWN_OPTIONS_LIST");
        return assessmentActionDropDown;
    }

    public String getFlexibleActionDropDown() {
        flexibleActionDropDown = properties.getProperty("FLEXIBLE_ACTON_DROPDOWN");
        return flexibleActionDropDown;
    }

    public String getAddFilter() {
        addFilter = properties.getProperty("ADD_FILTER");
        return addFilter;
    }

    public String getTypeItemBank() {
        itemBank = properties.getProperty("TYPE_ITEMBANK");
        return itemBank;
    }

    public String getAssessmentTitle() {
        assessmentTitle = properties.getProperty("ASSESSMENT_TITLE");
        return assessmentTitle;
    }

    public String getTypeAssessment() {
        typeAssessment = properties.getProperty("TYPE_ASSESSMENT");
        return typeAssessment;
    }

    public String getTypeSummaryAssessment() {
        summaryAssessment = properties.getProperty("TYPE_SUMMARY_ASSESSMENT");
        return summaryAssessment;
    }

    public String getTypeAssessmentView() {
        assessmentView = properties.getProperty("TYPE_ASSESSMENT_VIEW");
        return assessmentView;
    }

    public String getTypeSkillsAssessment() {
        skillsAssessment = properties.getProperty("TYPE_SKILLS_ASSESSMENT");
        return skillsAssessment;
    }

    public String getTypePoolAssessment() {
        poolAssessment = properties.getProperty("TYPE_POOL_ASSESSMENT");
        return poolAssessment;
    }

    public String getTypeStateAndNationalPublisher() {
        stateAndNationalPublisher = properties.getProperty("TYPE_STATE_AND_NATIONAL_PUBLISHER");
        return stateAndNationalPublisher;
    }

    public String getTypePFT() {
        typePFT = properties.getProperty("TYPE_PFT");
        return typePFT;
    }

    public String getFluenceActionDropDown() {
        fluenceActionDropDown = properties.getProperty("FLUENCE_ACTION_DROPDOWN");
        return fluenceActionDropDown;
    }

    public String getSurveyActionDropDown() {
        surveyActionDropDown = properties.getProperty("SURVEY_ACTION_DROPDOWN");
        return surveyActionDropDown;
    }

    public String getDemographicsActionDropDown() {
        demographicsActionDropDown = properties.getProperty("DEMOGRAPHIC_ACTION_LIST");
        return demographicsActionDropDown;
    }

    public String getSummaryActionDropDown() {
        summaryActionDropDown = properties.getProperty("SUMMARY_ACTON_DROPDOWN_OPTIONS_LIST");
        return summaryActionDropDown;
    }

    public String getAssessmentViewActionDropDown() {
        assessmentViewActionDropDown = properties.getProperty("ASSESSMENT_VIEW_ACTON_DROPDOWN_OPTIONS_LIST");
        return assessmentViewActionDropDown;
    }

    public String getSkillsAssessmentActionDropDown() {
        skillsAssessmentActionDropDownOptions = properties.getProperty("SKILLS_ASSESSMENTS_ACTION_LIST");
        return skillsAssessmentActionDropDownOptions;
    }

    public String getPFTAssessmentActionDropDown() {
        pftAssessmentActionDropDownOptions = properties.getProperty("PTF_ASSESSMENT_ACTION_LIST");
        return pftAssessmentActionDropDownOptions;
    }

    public String getActionDropDownOption(String option) {
        actionDropDownOptions = properties.getProperty("ITEMBANK_ACTON_DROPDOWN_OPTIONS_ADMINISTER");
        return actionDropDownOptions;
    }

    public String getDraftItembankDropDownOptionEdit(String option) {
        actionDropDownOptionsEdit = properties.getProperty("DRAFT_ITEM_BANK_EDIT");
        return actionDropDownOptionsEdit;
    }

    public String getAssessmentActionDropDownOptions(String option) {
        assessmentActionDropDownOptions = properties.getProperty("ASSESSMENT_ACTION_LIST");
        return assessmentActionDropDownOptions;
    }

    public String getFlexibleActionDropDownOptions(String option) {
        flexibleActionDropDownOptions = properties.getProperty("FLEXIBLE_ACTON_DROPDOWN_OPTION");
        return flexibleActionDropDownOptions;
    }

    public String getFluenceActionDropDownOptions(String option) {
        fluenceActionDropDownOptions = properties.getProperty("FLUENCE_ACTION_DROPDOWN_OPTIONS");
        return fluenceActionDropDownOptions;
    }

    public String getSurveyActionDropDownOptions(String option) {
        surveyActionDropDownOptions = properties.getProperty("SURVEY_ACTION_DROPDOWN_OPTIONS");
        return surveyActionDropDownOptions;
    }

    public String getDemographicsActionDropDownOptions(String option) {
        demographicsActionDropDownOptions = properties.getProperty("DEMOGRAPHICS_ACTION_DROPDOWN_OPTIONS");
        return demographicsActionDropDownOptions;
    }

    public String getSummaryActionDropDownOptions(String option) {
        summaryActionDropDownOptions = properties.getProperty("SUMMARY_ACTION_DROPDOWN_OPTIONS");
        return summaryActionDropDownOptions;
    }

    public String getAssessmentViewActionDropDownOptions(String option) {
        assessmentViewActionDropDownOptions = properties.getProperty("ASSESSMENT_VIEW_ACTION_DROPDOWN_OPTIONS");
        return assessmentViewActionDropDownOptions;
    }

    public String getSkillsAssessmentActionDropDownOptions(String option) {
        skillsAssessmentActionDropDownOptions = properties.getProperty("SKILLS_ASSESSEMENT_ACTION_DROPDOWN_OPTIONS");
        return skillsAssessmentActionDropDownOptions;
    }

    public String getPFTAssessmentActionDropDownOptions(String option) {
        pftAssessmentActionDropDownOptions = properties.getProperty("PTF_ASSESSMENT_DROPDOWN_OPTIONS");
        return pftAssessmentActionDropDownOptions;
    }

    public String getPFTAssessmentStudentResponseDropdownOption() {
        ptfAssessmentStudentResponse = properties.getProperty("STUDENT_RESPONSE_DROPDOWN");
        return ptfAssessmentStudentResponse;
    }

    public String getOnlineAssessmentPreviewHeader() {
        onlineAssessmentPreviewHeader = properties.getProperty("ONLINE_ASSESSMENT_PREVIEW_HEADER");
        return onlineAssessmentPreviewHeader;
    }

    public String getPreviewButton() {
        previewButton = properties.getProperty("PREVIEW_BUTTON");
        return previewButton;
    }

    public String getHasStudentResponse() {
        hasStudentResponse = properties.getProperty("HAS_STUDENT_RESPONSE");
        return hasStudentResponse;
    }

    public String getShowAssessmentsWithoutDataToggleButton() {
        showAssessmentsWithoutDataToggleButton = properties.getProperty("SHOW_ASSESSMENT_WITHOUT_DATA_TOGGLE_BUTTON");
        return showAssessmentsWithoutDataToggleButton;
    }

    public String getDeleteAlertMessage() {
        deleteAlertMessage = properties.getProperty("DELETE_ALERT_MESSAGE");
        return deleteAlertMessage;
    }

    public String getDeleteAssessementButton() {
        deleteAssessementButton = properties.getProperty("DELETE_ASSESSMENT_BUTTON");
        return deleteAssessementButton;
    }

    public String getDeleteUnderstandCheckbox() {
        deleteUnderstandCheckbox = properties.getProperty("DELETE_UNDERSTAND_CHECKBOX");
        return deleteUnderstandCheckbox;
    }

    public String getDeleteAgreeCheckbox() {
        deleteAgreeCheckbox = properties.getProperty("GET_DELETE_AGREE_CHECKBOX");
        return deleteAgreeCheckbox;
    }

    public String getAlertSuccess() {
        alertSuccess = properties.getProperty("ALERT_SUCCESS");
        return alertSuccess;
    }

    public String getAssessmentsList() {
        assessmentsList = properties.getProperty("ASSESSMENTS_LIST");
        return assessmentsList;
    }

    public String getFunctionDropDown() {
        functionDropDown = properties.getProperty("FUNCTION_DROPDOWN");
        return functionDropDown;
    }

    public String getSubmitButton() {
        submitButton = properties.getProperty("SUBMIT_BUTTON");
        return submitButton;
    }

    public String getEditAssessmentModal() {
        editAssessmentModal = properties.getProperty("EDIT_ASSESSMENT_MODEL");
        return editAssessmentModal;
    }

    public String getCloseEditAssessmentModalIcon() {
        closeEditAssessmentModalIcon = properties.getProperty("CLOSE_EDIT_ASSESSMENT_MODEL_ICON");
        return closeEditAssessmentModalIcon;
    }

    public String getAlertContainer() {
        alertContainer = properties.getProperty("ALERT_CONTAINER");
        return alertContainer;
    }

    public String getNevermindButton() {
        nevermindButton = properties.getProperty("NEVER_MIND_BUTTON");
        return nevermindButton;
    }

    public String getUnpublishedItemBankLink() {
        unpublishedItemBankLink = properties.getProperty("UNPUBLISHED_ITEMBANK_HEADER");
        return unpublishedItemBankLink;
    }

    public String getUnpublishedItemBankHeader() {
        unpublishedItemBankHeader = properties.getProperty("UNPUBLISHED_ITEMBANK_HEADER");
        return unpublishedItemBankHeader;
    }

    public String getReturnToIlluminateIcon() {
        returnToIlluminateIcon = properties.getProperty("RETURN_TO_ILLUMINATE_ICON");
        return returnToIlluminateIcon;
    }

    public String getPftStudentResponseHeader() {
        pftStudentResponseHeader = properties.getProperty("PTF_STUDENT_RESPONSE_HEADER");
        return pftStudentResponseHeader;
    }

    public String getSkillsAssessmentDuplicateButton() {
        skillsAssessmentDuplicateButton = properties.getProperty("SKILLS_ASSESSMENT_DUPLICATE_BUTTON");
        return skillsAssessmentDuplicateButton;
    }

    public String getItemBankActionDropDownOptionsList() {
        itemBankActionDropDownOptionsList = properties.getProperty("ITEMBANK_ACTON_DROPDOWN_OPTIONS_LIST");
        return itemBankActionDropDownOptionsList;
    }

    public String getAssessmentActionDropDownOptionsList() {
        assessmentActionDropDownOptionsList = properties.getProperty("ASSESSMENT_ACTION_DROPDOWN_OPTIONS_LIST");
        return assessmentActionDropDownOptionsList;
    }

    public String getFlexibleActionDropDownOptionsList() {
        flexibleActionDropDownOptionsList = ("FLEXIBLE_ACTON_DROPDOWN_OPTIONS_LIST");
        return flexibleActionDropDownOptionsList;
    }

    public String getFluenceActionDropDownOptionsList() {
        fluenceActionDropDownOptionsList = properties.getProperty("FLUENCE_ACTION_DROPDOWN_OPTIONS_LIST");
        return fluenceActionDropDownOptionsList;
    }

    public String getSurveyActionDropDownOptionsList() {
        surveyActionDropDownOptionsList = properties.getProperty("SURVEY_ACTION_DROPDOWN_OPTIONS_LIST");
        return surveyActionDropDownOptionsList;
    }

    public String getDemographicsActionDropDownOptionsList() {
        demographicsActionDropDownOptionsList = properties.getProperty("DEMOGRAPHICS_ACTION_DROPDOWN_OPTIONS_LIST");
        return demographicsActionDropDownOptionsList;
    }

    public String getSummaryActionDropDownOptionsList() {
        summaryActionDropDownOptionsList = properties.getProperty("SUMMARY_ACTION_DROPDOWN_OPTIONS_LIST");
        return summaryActionDropDownOptionsList;
    }

    public String getAssessmentViewActionDropDownOptionsList() {
        assessmentViewActionDropDownOptionsList = properties.getProperty("ASSESSMENT_VIEW_ACTION_DROPDOWN_OPTIONS_LIST");
        return assessmentViewActionDropDownOptionsList;
    }

    public String getSkillsAssessmentActionDropDownOptionsList() {
        skillsAssessmentActionDropDownOptionsList = properties.getProperty("SKILLS_ASSESSEMENT_ACTION_DROPDOWN_OPTIONS_LIST");
        return skillsAssessmentActionDropDownOptionsList;
    }

    public String getItemBankActionList() {
        itmBankActionList = properties.getProperty("ITEMBANK_ACTION_LIST");
        return itmBankActionList;
    }

    public String getPFTAssessmentActionDropDownOptionsList() {
        pftAssessmentActionDropDownOptionsList = properties.getProperty("PTF_ASSESSMENT_ACTION_DROPDOWN_OPTIONS_LIST");
        return pftAssessmentActionDropDownOptionsList;
    }
}
