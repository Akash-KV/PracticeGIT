package Pom;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//page object model class for Item bank Assessments page
public class ItemBankAssessmentPage {
    String createNewAssessmentHeader, assessmentNameTextbox, createButton, addItemFlashButton, addQuestionsInput, addQuestionsOKButton, createItemRemoveChoice;
    String questionsTable, filterStandardsButton, standardModel, standardsHeader, selectMessageStandardsPopup, providersButton, providersFirstOption;
    String providersFirstLabel, providersClearButton, subjectsButton, subjectsFirstOption, subjectsFirstLabel, subjectsClearButton, gradeButton;
    String gradeFirstOption, gradeFirstLabel, gradeClearButton, firstStandardInPopup, savedMessageInPopup, closePopup, messageSavedFlex, createItemItemBanks;
    String headerContent, uploadMaterialsButton, uploadFromMyComputerButton, itemBankAssessmentViewType;
    String uploadSuccess, uploadConfirmationCloseButton, uploadMaterialsCloseButton, addItemsIcon, itemsCountTextbox, addQuestionOKButton;
    String previewIcon, beginTestButton, questionContainer, testReviewFinishButton, confirmFinishButton, alertFinishButton, completedTestLabel;
    String answerSavedMessage, addButton, doneButton, administerButton, onlineTestingButton, testWithQuickCodeButton, accessCode, quickRosterPopup;
    String illuminateLink, studentIDLoginInput, nextButton, confirmButton, closeAccessPopup, createItemCreateRadioButton, createItemBankPopup, createItemBankPopupNextButton, itemBankAssessmentNTItem;
    String itemBankAssessmentName, assessmentDescription, grade, subject, createButtonStep1;
    private String itemBankAssessmentFilterStanderds, itemBankAssessmentFirstStanderd, itemBankAssessmentAddAnswers, itemBankAssessmentSelectDropdown, itemBankAssessmentUploadButton, itemBankAssessmentFilterType;
    private String itemBankAssessmentSuccessModel, itemBankAssessmentStanderdsAdded,itemBankAssessmentValidationComponent, CreateItemNoItemsFound,itemBankAssessmentFindStudents;
    private String itemBankAssessmentYear, itemBankAssessmentYearInputBox, itemBankAssessmentAcademicYear, itemBankAssessmentSubjectInputBox, itemBankAssessmentStepOne, itemBankAssessmentStandardDocument;
    private String itemBankAssessmentStandardSubject, itemBankAssessmentStandardCategory, itemBankAssessmentNext, itemBankAssessmentAddItems, itemBankAssessmentPassages, itemBankAssessmentItemSearchModel;
    private String itemBankAssessmentSelectResponse, itemBankAssessmentUpdatefilters, itemBankAssessmentAdditemStanderds, itemBankAssessmentStepQuestions, itemBankAssessmentPrintOptions, itemBankAssessmentPublishyourAssessment;
    private String itemBankAssessmentPreviewItemOnline, itemBankAssessmentReturntoStepThree, itemBankAssessmentItemonSearch, itemBankAssessmentSearchResults, itemBankAssessmentAddButton, itemBankAssessmentAddSecondButton;
    private String itemBankAssessmentPublihAdminButton, itemBankAssessmentOnlineTesting, itemBankAssessmentStudentResponseContainerSecond, itemBankAssessmentStudentResponseContainerThird, itemBankAssessmentExit;
    private String itemBankAssessmentAssessmentsAdministrations, itemBankAssessmentFilterPassages, itemBankAssessmentItemSearchResults, itemBankAssessmentSelectItemTypes, itemBankAssessmentItemTypeSearchModel;
    private String createItemRadioButton, createItemStemFrame, createItemStemBody, createItemSaveandContinue, createItemAnswerChoices, createItemSelectFirstAnswer, createItemSaveButton, createItemStepThree, createItemStepSix;
    private String createItemPublish, createItemPreview, createItemSelectSecondAnswer, createItemSaveMessage, createItemSelectFirstAnswerText, createItemSelectThirdAnswerText, createItemSelectSecondAnswerText, createItemSelectFourthAnswerText;
    private String createItemSaveRubric, createItemSaveConfirmationMsg, createItemRemoveRubricChoiceOne, createItemThirdDropDownText, createItemSecondDropDownText, createItemAnswerMathTextbox, createItemFirstDropDownText;
    private String createItemItemtype, createItemCreate, createItemFourthDropDownText, createItemRubricArrowUp, itemBankAssessmentEnter, itemBankAssessmentMathQuestion, itemBankAssessmentMERItem, itemBankAssessmentExplicitResponse, itemBankAssessmentECRItem, itemBankAssessmentCRItem, itemBankAssessmentSDItem, itemBankAssessmentConstructedResponse, itemBankAssessmentHSTItem, itemBankAssessmentHighlightST, itemBankAssessmentNonTraditional, itemBankUpdateFilters, itemBankAssessmentMCItem, itemBankAssessmentItemType;
    private String itemBankAssessmenStanderds,itemBankAssessmentStanderdHeader,itemBankAssessmentUnselectStanderds,itemBankAssessmentUpdateStanderds;
    private  String itemBankAssessmentSelectItem,itemBankAssessmenentEBSR,itemBankAssessmenAddStanderds,itemBankAssessmentHighlightSelectableText,itemBankAssessmentMultiport,itemBankAssessmentDragAndDropclassify,itemBankAssessmentDragAndDropOrder;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ItemBankAssessmentPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_LegacyItemBankAuthoredItemsScoring", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ItemBankAssessmentPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ItemBankAssessmentPage.properties");
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


    public String getCreateNewAssessmentHeader() {
        createNewAssessmentHeader = properties.getProperty("CREATE_NEW_ASSESSMENT_MODAL");
        return createNewAssessmentHeader;
    }

    public String getAssessmentNameTextbox() {
        assessmentNameTextbox = properties.getProperty("CREATE_NEW_ASSESSMENT_NAMETEXTBOX");
        return assessmentNameTextbox;
    }

    public String getCreateButton() {
        createButton = properties.getProperty("CREATE_NEW_ASSESSMENT_CREATEBUTTON");
        return createButton;
    }

    public String getAddItemFlashButton() {
        addItemFlashButton = properties.getProperty("ADDITEM_FLASH");
        return addItemFlashButton;
    }

    public String getAddQuestionsInput() {
        addQuestionsInput = properties.getProperty("ADDQUESTIONS_INPUT");
        return addQuestionsInput;
    }

    public String getAddQuestionsOKButton() {
        addQuestionsOKButton = properties.getProperty("ADDQUESTIONS_OKBUTTON");
        return addQuestionsOKButton;
    }

    public String getQuestionsTable() {

        questionsTable = properties.getProperty("QUESTIONS_TABLE");
        return questionsTable;
    }

    public String getFilterStandardsButton() {
        filterStandardsButton = properties.getProperty("FILTER_STANDARDS_BUTTON");
        return filterStandardsButton;
    }

    public String getStandardModel() {
        standardModel = properties.getProperty("STANDARDS_MODEL");
        return standardModel;
    }

    public String getStandardsHeader() {
        standardsHeader = properties.getProperty("STANDARDS_HEADER");
        return standardsHeader;
    }

    public String getSelectMessageStandardsPopup() {
        selectMessageStandardsPopup = properties.getProperty("SELECT_MESSAGE_STANDARDS_POPUP");
        return selectMessageStandardsPopup;
    }

    public String getProvidersButton() {
        providersButton = properties.getProperty("PROVIDERS_BUTTON");
        return providersButton;
    }

    public String getProvidersFirstOption() {
        providersFirstOption = properties.getProperty("PROVIDERS_FIRST_OPTION");
        return providersFirstOption;
    }

    public String getProvidersFirstLabel() {
        providersFirstLabel = properties.getProperty("PROVIDERS_FIRST_LABEL");
        return providersFirstLabel;
    }

    public String getProvidersClearButton() {
        providersClearButton = properties.getProperty("PROVIDERS_CLEAR_BUTTON");
        return providersClearButton;
    }

    public String getSubjectsButton() {
        subjectsButton = properties.getProperty("SUBJECTS_BUTTON");
        return subjectsButton;
    }

    public String getSubjectsFirstOption() {
        subjectsFirstOption = properties.getProperty("SUBJECTS_FIRST_OPTION");
        return subjectsFirstOption;
    }

    public String getSubjectsFirstLabel() {
        subjectsFirstLabel = properties.getProperty("SUBJECTS_FIRST_LABEL");
        return subjectsFirstLabel;
    }

    public String getSubjectsClearButton() {
        subjectsClearButton = properties.getProperty("SUBJECTS_CLEAR_BUTTON");
        return subjectsClearButton;
    }

    public String getGradeButton() {
        gradeButton = properties.getProperty("GRADE_BUTTON");
        return gradeButton;
    }

    public String getGradeFirstOption() {
        gradeFirstOption = properties.getProperty("GRADE_FIRST_OPTION");
        return gradeFirstOption;
    }

    public String getGradeFirstLabel() {
        gradeFirstLabel = properties.getProperty("GRADE_FIRST_LABEL");
        return gradeFirstLabel;
    }

    public String getGradeClearButton() {
        gradeClearButton = properties.getProperty("GRADE_CLEAR_BUTTON");
        return gradeClearButton;
    }

    public String getFirstStandardInPopup() {
        firstStandardInPopup = properties.getProperty("FIRST_STANDARD_IN_POPUP");
        return firstStandardInPopup;
    }

    public String getSavedMessageInPopup() {
        savedMessageInPopup = properties.getProperty("SAVED_MESSAGE_IN_POPUP");
        return savedMessageInPopup;
    }

    public String getClosePopup() {
        closePopup = properties.getProperty("CLOSE_POPUP");
        return closePopup;
    }

    public String getMessageSavedItemBank() {
        messageSavedFlex = properties.getProperty("MESSAGE_SAVED_FLEX");
        return messageSavedFlex;
    }

    public String getHeaderContent() {
        headerContent = properties.getProperty("HEADER_CONTENT");
        return headerContent;
    }

    public String getUploadMaterialsButton() {
        uploadMaterialsButton = properties.getProperty("UPLOAD_MATERIALS");
        return uploadMaterialsButton;
    }

    public String getUploadFromMyComputerButton() {
        uploadFromMyComputerButton = properties.getProperty("UPLOAD_FROM_MY_COMPUTER");
        return uploadFromMyComputerButton;
    }

    public String getUploadSuccess() {
        uploadSuccess = properties.getProperty("UPLOAD_SUCCESS");
        return uploadSuccess;
    }

    public String getUploadConfirmationCloseButton() {
        uploadConfirmationCloseButton = properties.getProperty("UPLOAD_CONFIRMATION_CLOSE_BUTTON");
        return uploadConfirmationCloseButton;
    }

    public String getUploadMaterialsCloseButton() {
        uploadMaterialsCloseButton = properties.getProperty("UPLOAD_MATERIALS_CLOSE_BUTTON");
        return uploadMaterialsCloseButton;
    }

    public String getAddItemsIcon() {
        addItemsIcon = properties.getProperty("ADD_ITEMS_ICON");
        return addItemsIcon;
    }

    public String getItemsCountTextbox() {
        itemsCountTextbox = properties.getProperty("ITEMS_COUNT_TEXTBOX");
        return itemsCountTextbox;
    }

    public String getAddQuestionOKButton() {
        addQuestionOKButton = properties.getProperty("ADD_QUESTIONS_OK_BUTTON");
        return addQuestionOKButton;
    }

    public String getPreviewIcon() {
        previewIcon = properties.getProperty("PREVIEW");
        return previewIcon;
    }

    public String getBeginTestButton() {
        beginTestButton = properties.getProperty("BEGIN_TEST");
        return beginTestButton;
    }

    public String getQuestionContainer() {
        questionContainer = properties.getProperty("QUESTION_CONTAINER");
        return questionContainer;
    }

    public String getTestReviewFinishButton() {
        testReviewFinishButton = properties.getProperty("TEST_REVIEW_FINISH_BUTTON");
        return testReviewFinishButton;
    }

    public String getConfirmFinishButton() {
        confirmFinishButton = properties.getProperty("CONFIRM_FINISH_BUTTON");
        return confirmFinishButton;
    }

    public String getAlertFinishButton() {
        alertFinishButton = properties.getProperty("ALERT_FINISH_BUTTON");
        return alertFinishButton;
    }

    public String getCompletedTestLabel() {
        completedTestLabel = properties.getProperty("COMPLETED_TEST_LABEL");
        return completedTestLabel;
    }

    public String getAnswerSavedMessage() {
        answerSavedMessage = properties.getProperty("ANSWER_SAVED_MESSAGE");
        return answerSavedMessage;
    }

    public String getAddButton() {
        addButton = properties.getProperty("ADD_BUTTON");
        return addButton;
    }

    public String getDoneButton() {
        doneButton = properties.getProperty("DONE_BUTTON");
        return doneButton;
    }

    public String getAdministerButton() {
        administerButton = properties.getProperty("ADMINISTER_BUTTON");
        return administerButton;
    }

    public String getOnlineTestingButton() {
        onlineTestingButton = properties.getProperty("ONLINE_TESTING");
        return onlineTestingButton;
    }

    public String getTestWithQuickCodeButton() {
        testWithQuickCodeButton = properties.getProperty("TEST_WITH_QUICK_CODE_BUTTON");
        return testWithQuickCodeButton;
    }

    public String getAccessCode() {
        accessCode = properties.getProperty("ACCESS_CODE");
        return accessCode;
    }

    public String getQuickRosterPopup() {
        quickRosterPopup = properties.getProperty("QUICK_ROSTER_POPUP");
        return quickRosterPopup;
    }

    public String getIlluminateLink() {
        illuminateLink = properties.getProperty("ILLUMINATE_LINK");
        return illuminateLink;
    }

    public String getStudentIDLoginInput() {
        studentIDLoginInput = properties.getProperty("STUDENTID_LOGIN");
        return studentIDLoginInput;
    }

    public String getNextButton() {
        nextButton = properties.getProperty("NEXT_BUTTON");
        return nextButton;
    }

    public String getConfirmButton() {
        confirmButton = properties.getProperty("CONFIRM_BUTTON");
        return confirmButton;
    }

    public String getCloseAccessPopup() {
        closeAccessPopup = properties.getProperty("CLOSE_ACCESS_POPUP");
        return closeAccessPopup;
    }

    public String getCreateItemBankPopup() {
        createItemBankPopup = properties.getProperty("CREATE_ITEMBANK_POPUP");
        return createItemBankPopup;
    }

    public String getCreateItemBankPopupNextButton() {
        createItemBankPopupNextButton = properties.getProperty("CREATE_ITEMBANK_POPUP_NEXTBUTTON");
        return createItemBankPopupNextButton;
    }

    public String getItemBankAssessmentName() {
        itemBankAssessmentName = properties.getProperty("ITEMBANK_ASSESSMENTNAME");
        return itemBankAssessmentName;
    }

    public String getAssessmentDescription() {
        assessmentDescription = properties.getProperty("ASSESSMENT_DESCRIPTION");
        return assessmentDescription;
    }

    public String getGrade() {
        grade = properties.getProperty("GRADE");
        return grade;
    }

    public String getSubject() {
        subject = properties.getProperty("SUBJECT");
        return subject;
    }

    public String getCreateButtonStep1() {
        createButtonStep1 = properties.getProperty("CREATE_BUTTON");
        return createButtonStep1;
    }

    public String getItemBankAssessmentFilterStanderds() {
        itemBankAssessmentFilterStanderds = properties.getProperty("ITEMBANKASSESSMENT_FILTERSTANDERDS");
        return itemBankAssessmentFilterStanderds;
    }

    public String getItemBankAssessmentFirstStanderd() {
        itemBankAssessmentFirstStanderd = properties.getProperty("ITEMBANKASSESSMENT_FIRSTSTANDERD");
        return itemBankAssessmentFirstStanderd;
    }

    public String getItemBankAssessmentAddAnswers() {
        itemBankAssessmentAddAnswers = properties.getProperty("ITEMBANKASSESSMENT_ADDANSWERS");
        return itemBankAssessmentAddAnswers;
    }

    public String getItemBankAssessmentUploadButton() {
        itemBankAssessmentUploadButton = properties.getProperty("ITEMBANKASSESSMENT_UPLOADBUTTON");
        return itemBankAssessmentUploadButton;
    }

    public String getItemBankAssessmentFileType() {
        itemBankAssessmentFilterType = properties.getProperty("ITEMBANKASSESSMENT_FILETYPE");
        return itemBankAssessmentFilterType;
    }

    public String getItemBankAssessmentSuccessModel() {
        itemBankAssessmentSuccessModel = properties.getProperty("ITEMBANKASSESSMENT_SUCCESSMODEL");
        return itemBankAssessmentSuccessModel;
    }

    public String getItemBankAssessmentYear() {
        itemBankAssessmentYear = properties.getProperty("ITEMBANKASSESSMENT_YEAR");
        return itemBankAssessmentYear;
    }

    public String getItemBankAssessmentYearInputBox() {
        itemBankAssessmentYearInputBox = properties.getProperty("ITEMBANKASSESSMENT_YEARINPUTBOX");
        return itemBankAssessmentYearInputBox;
    }

    public String getItemBankAssessmentAcademicYear() {
        itemBankAssessmentAcademicYear = properties.getProperty("ITEMBANKASSESSMENT_ACADEMICYEAR");
        return itemBankAssessmentAcademicYear;
    }

    public String getItemBankAssessmentSubjectInputBox() {
        itemBankAssessmentSubjectInputBox = properties.getProperty("ITEMBANKASSESSMENT_SUBJECTINPUTBOX");
        return itemBankAssessmentSubjectInputBox;
    }

    public String getItemBankAssessmentStepOne() {
        itemBankAssessmentStepOne = properties.getProperty("ITEMBANKASSESSMENT_STEPONE");
        return itemBankAssessmentStepOne;
    }

    public String getItemBankAssessmentStandardDocument() {
        itemBankAssessmentStandardDocument = properties.getProperty("ITEMBANKASSESSMENT_STANDARDDOCUMENT");
        return itemBankAssessmentStandardDocument;
    }

    public String getitemBankAssessmentStandardSubject() {
        itemBankAssessmentStandardSubject = properties.getProperty("ITEMBANKASSESSMENT_STANDERDSUBJECT");
        return itemBankAssessmentStandardSubject;
    }

    public String getitemBankAssessmentStandardCategory() {
        itemBankAssessmentStandardCategory = properties.getProperty("ITEMBANKASSESSMENT_STANDERDCATEGORY");
        return itemBankAssessmentStandardCategory;
    }

    public String getItemBankAssessmentNext() {
        itemBankAssessmentNext = properties.getProperty("ITEMBANKASSESSMENT_NEXT");
        return itemBankAssessmentNext;
    }

    public String getItemBankAssessmentAddItems() {
        itemBankAssessmentAddItems = properties.getProperty("ITEMBANKASSESSMENT_ADDITEMS");
        return itemBankAssessmentAddItems;
    }

    public String getItemBankAssessmentPassages() {
        itemBankAssessmentPassages = properties.getProperty("ITEMBANKASSESSMENT_PASSAGES");
        return itemBankAssessmentPassages;
    }

    public String getItemBankAssessmentItemSearchModel() {
        itemBankAssessmentItemSearchModel = properties.getProperty("ITEMBANKASSESSMENT_ITEMSEARCHMODEL");
        return itemBankAssessmentItemSearchModel;
    }

    public String getItemBankAssessmentFilterPassages() {
        itemBankAssessmentFilterPassages = properties.getProperty("ITEMBANKASSESSMENT_FILERPASSAGES");
        return itemBankAssessmentFilterPassages;
    }

    public String getItemBankAssessmentItemSearchResults() {
        itemBankAssessmentItemSearchResults = properties.getProperty("ITEMBANKASSESSMENT_ITEMSEARCHRESULTS");
        return itemBankAssessmentItemSearchResults;
    }

    public String getItemBankAssessmentSelectItemTypes() {
        itemBankAssessmentSelectItemTypes = properties.getProperty("ITEMBANKASSESSMENT_SELECTITEMTYPES");
        return itemBankAssessmentSelectItemTypes;
    }

    public String getItemBankAssessmentItemTypeSearchModel() {
        itemBankAssessmentItemTypeSearchModel = properties.getProperty("ITEMBANKASSESSMENT_ITEMTYPESEARCHMODEL");
        return itemBankAssessmentItemTypeSearchModel;
    }

    public String getItemBankAssessmentSelectResponse() {
        itemBankAssessmentSelectResponse = properties.getProperty("ITEMBANKASSESSMENT_SELECTRESPONSE");
        return itemBankAssessmentSelectResponse;
    }

    public String getItemBankAssessmentUpdatefilters() {
        itemBankAssessmentUpdatefilters = properties.getProperty("ITEMBANKASSESSMENT_UPDATEFILTERS");
        return itemBankAssessmentUpdatefilters;
    }

    public String getItemBankAssessmentAdditemStanderds() {
        itemBankAssessmentAdditemStanderds = properties.getProperty("ITEMBANKASSESSMENT_ADDITEMANDSTANDERDS");
        return itemBankAssessmentAdditemStanderds;
    }

    public String getitemBankAssessmentStepQuestions() {
        itemBankAssessmentStepQuestions = properties.getProperty("ITEMBANKASSESSMENT_STEPQUESTIONS");
        return itemBankAssessmentStepQuestions;
    }

    public String getitemBankAssessmentPrintOptions() {
        itemBankAssessmentPrintOptions = properties.getProperty("ITEMBANKASSESSMENT_PRINTOPTIONS");
        return itemBankAssessmentPrintOptions;
    }

    public String getItemBankAssessmentPublishyourAssessment() {
        itemBankAssessmentPublishyourAssessment = properties.getProperty("ITEMBANKASSESSMENT_PUBLISHYOURASSESSMENT");
        return itemBankAssessmentPublishyourAssessment;
    }

    public String getItemBankAssessmentPreviewItemOnline() {
        itemBankAssessmentPreviewItemOnline = properties.getProperty("ITEMBANKASSESSMENT_PREVIEWITEMONLINE");
        return itemBankAssessmentPreviewItemOnline;
    }

    public String getItemBankAssessmentReturntoStepThree() {
        itemBankAssessmentReturntoStepThree = properties.getProperty("ITEMBANKASSESSMENT_RETURNTOSTEPTHREE");
        return itemBankAssessmentReturntoStepThree;
    }

    public String getItemBankAssessmentItemonSearch() {
        itemBankAssessmentItemonSearch = properties.getProperty("ITEMBANKASSESSMENT_ITEMBUTTONSEARCH");
        return itemBankAssessmentItemonSearch;
    }

    public String getItemBankAssessmentSearchResults() {
        itemBankAssessmentSearchResults = properties.getProperty("ITEMBANKASSESSMENT_SEARCHRESULTS");
        return itemBankAssessmentSearchResults;
    }

    public String getItemBankAssessmentAddButton() {
        itemBankAssessmentAddButton = properties.getProperty("ITEMBANKASSESSMENT_ADDBUTTON");
        return itemBankAssessmentAddButton;
    }

    public String getItemBankAssessmentAddSecondButton() {
        itemBankAssessmentAddSecondButton = properties.getProperty("ITEMBANKASSESSMENT_ADDSECANDBUTTON");
        return itemBankAssessmentAddSecondButton;
    }

    public String getitemBankAssessmentPublihAdminButton() {
        itemBankAssessmentPublihAdminButton = properties.getProperty("ITEMBANKASSESSMENT_PUBLISHADMINBUTTON");
        return itemBankAssessmentPublihAdminButton;
    }

    public String getItemBankAssessmentOnlineTesting() {
        itemBankAssessmentOnlineTesting = properties.getProperty("ITEMBANKASSESSMENT_ONLINETESTING");
        return itemBankAssessmentOnlineTesting;
    }

    public String getItemBankAssessmentStudentResponseContainerSecond() {
        itemBankAssessmentStudentResponseContainerSecond = properties.getProperty("ITEMBANKASSESSMENT_STUDENTRESPONSECONTAINERSECOND");
        return itemBankAssessmentStudentResponseContainerSecond;
    }

    public String getItemBankAssessmentValidationComponent() {
        itemBankAssessmentValidationComponent = properties.getProperty("ITEMBANKASSESSMENT_VALIDATIONSCOMPONENT");
        return itemBankAssessmentValidationComponent;
    }


    public String getItemBankAssessmentStudentResponseContainerThird() {
        itemBankAssessmentStudentResponseContainerThird = properties.getProperty("ITEMBANKASSESSMENT_STUDENTRESPONSECONTAINERTHIRD");
        return itemBankAssessmentStudentResponseContainerThird;
    }

    public String getItemBankAssessmentExit() {
        itemBankAssessmentExit = properties.getProperty("ITEMBANKASSESSMENT_EXIT");
        return itemBankAssessmentExit;
    }

    public String getItemBankAssessmentAssessmentsAdministrations() {
        itemBankAssessmentAssessmentsAdministrations = properties.getProperty("ITEMBANKASSESSMENT_ASSESSMENTADMINISTRATIONS");
        return itemBankAssessmentAssessmentsAdministrations;
    }

    public String getCreateItemFourthDropDownText() {
        createItemFourthDropDownText = properties.getProperty("CREATEITEM_FOURTHDROPDOWNTEXT");
        return createItemFourthDropDownText;
    }

    public String getcreateItemThirdDropDownText() {
        createItemThirdDropDownText = properties.getProperty("CREATEITEM_THIRDDROPDOWNTEXT");
        return createItemThirdDropDownText;
    }

    public String getCreateItemSecondDropDownText() {
        createItemSecondDropDownText = properties.getProperty("CREATEITEM_SECONDDROPDOWNTEXT");
        return createItemSecondDropDownText;
    }

    public String getCreateItemFirstDropDownText() {
        createItemFirstDropDownText = properties.getProperty("CREATEITEM_FIRSTDROPDOWNTEXT");
        return createItemFirstDropDownText;
    }

    public String getCreateItemSelectSecondAnswer() {
        createItemSelectSecondAnswer = properties.getProperty("CREATEITEM_SELECTSECONDANSWER");
        return createItemSelectSecondAnswer;
    }

    public String getCreateItemPreview() {
        createItemPreview = properties.getProperty("CREATEITEM_PREVIEW");
        return createItemPreview;
    }

    public String getCreateItemPublish() {
        createItemPublish = properties.getProperty("CREATEITEM_PUBLISH");
        return createItemPublish;
    }

    public String getCreateItemStepSix() {
        createItemStepSix = properties.getProperty("CREATEITEM_STEPSIX");
        return createItemStepSix;
    }

    public String getCreateItemStepThree() {
        createItemStepThree = properties.getProperty("CREATEITEM_STEPTHREE");
        return createItemStepThree;
    }

    public String getCreateItemSaveButton() {
        createItemSaveButton = properties.getProperty("CREATEITEM_SAVEBUTTON");
        return createItemSaveButton;
    }

    public String getCreateItemSelectFirstAnswer() {
        createItemSelectFirstAnswer = properties.getProperty("CREATEITEM_SELECTFIRSTANSWER");
        return createItemSelectFirstAnswer;
    }

    public String getCreateItemAnswerChoices() {
        createItemAnswerChoices = properties.getProperty("CREATEITEM_ANSWERCHOICES");
        return createItemAnswerChoices;
    }

    public String getCreateItemSaveandContinue() {
        createItemSaveandContinue = properties.getProperty("CREATEITEM_SAVEANDCONTINUE");
        return createItemSaveandContinue;
    }

    public String getCreateItemStemBody() {
        createItemStemBody = properties.getProperty("CREATEITEM_STEMBODY");
        return createItemStemBody;
    }

    public String getCreateItemStemFrame() {
        createItemStemFrame = properties.getProperty("CREATEITEM_STEMFRAME");
        return createItemStemFrame;
    }

    public String getCreateItemRadioButton() {
        createItemRadioButton = properties.getProperty("CREATEITEM_RADIOBUTTON");
        return createItemRadioButton;
    }

    public String getCreateItemAnswerMathTextbox() {
        createItemAnswerMathTextbox = properties.getProperty("CREATEITEM_ANSWERMATHTEXTBOX");
        return createItemAnswerMathTextbox;
    }

    public String getCreateItemItemtype() {
        createItemItemtype = properties.getProperty("CREATEITEM_ITEMTYPE");
        return createItemItemtype;
    }

    public String getCreateItemCreate() {
        createItemCreate = properties.getProperty("CREATEITEM_CREATE");
        return createItemCreate;
    }

    public String getCreateItemRubricArrowUp() {
        createItemRubricArrowUp = properties.getProperty("CREATEITEM_RUBRICARROWUP");
        return createItemRubricArrowUp;
    }

    public String getCreateItemSaveRubric() {
        createItemSaveRubric = properties.getProperty("CREATEITEM_SAVERUBRIC");
        return createItemSaveRubric;
    }

    public String getCreateItemSaveConfirmationMsg() {
        createItemSaveConfirmationMsg = properties.getProperty("CREATEITEM_SAVECONFIRMATIONMSG");
        return createItemSaveConfirmationMsg;
    }

    public String getCreateItemRemoveChoice() {
        createItemRemoveChoice = properties.getProperty("CREATEITEM_REMOVECHOICE");
        return createItemRemoveChoice;
    }

    public String getCreateItemItemBanks() {
        createItemItemBanks = properties.getProperty("ITEMBANKASSESSMENT_ITEMBANKS");
        return createItemItemBanks;
    }

    public String getItemBankUpdateFilters() {
        itemBankUpdateFilters = properties.getProperty("ITEMBANKASSESSMENT_ITEMBANKUPDATEFILTERS");
        return itemBankUpdateFilters;
    }

    public String getItemBankAssessmentMCItem() {
        itemBankAssessmentMCItem = properties.getProperty("ITEMBANKASSESSMENT_MCITEM");
        return itemBankAssessmentMCItem;
    }

    public String getItemBankAssessmentItemType() {
        itemBankAssessmentItemType = properties.getProperty("ITEMBANKASSESSMENT_ITEMTYPE");
        return itemBankAssessmentItemType;
    }

    public String getItemBankAssessmentNonTraditional() {
        itemBankAssessmentNonTraditional = properties.getProperty("ITEMBANKASSESSMENT_NONTRADITIONAL");
        return itemBankAssessmentNonTraditional;
    }

    public String getItemBankAssessmentNTItem() {
        itemBankAssessmentNTItem = properties.getProperty("ITEMBANKASSESSMENT_NTITEM");
        return itemBankAssessmentNTItem;
    }

    public String getItemBankAssessmentHighlightST() {
        itemBankAssessmentHighlightST = properties.getProperty("ITEMBANKASSESSMENT_HIGHLIGHTST");
        return itemBankAssessmentHighlightST;
    }

    public String getitemBankAssessmentHSTItem() {
        itemBankAssessmentHSTItem = properties.getProperty("ITEMBANKASSESSMENT_HSTITEM");
        return itemBankAssessmentHSTItem;
    }

    public String getItemBankAssessmentSelectDropdown() {
        itemBankAssessmentSelectDropdown = properties.getProperty("ITEMBANKASSESSMENT_SELECTDROPDOWN");
        return itemBankAssessmentSelectDropdown;
    }

    public String getItemBankAssessmentSDItem() {
        itemBankAssessmentSDItem = properties.getProperty("ITEMBANKASSESSMENT_SDITEM");
        return itemBankAssessmentSDItem;
    }

    public String getItemBankAssessmentConstructedResponse() {
        itemBankAssessmentConstructedResponse = properties.getProperty("ITEMBANKASSESSMENT_CONSTRUCTEDRESPONSE");
        return itemBankAssessmentConstructedResponse;
    }

    public String getItemBankAssessmentCRItem() {
        itemBankAssessmentCRItem = properties.getProperty("ITEMBANKASSESSMENT_CRITEM");
        return itemBankAssessmentCRItem;
    }

    public String getItemBankAssessmentExplicitResponse() {
        itemBankAssessmentExplicitResponse = properties.getProperty("ITEMBANKASSESSMENT_EXPLICITRESPONSE");
        return itemBankAssessmentExplicitResponse;
    }

    public String getItemBankAssessmentECRItem() {
        itemBankAssessmentECRItem = properties.getProperty("ITEMBANKASSESSMENT_ECRITEM");
        return itemBankAssessmentECRItem;
    }

    public String getItemBankAssessmentMathQuestion() {
        itemBankAssessmentMathQuestion = properties.getProperty("ITEMBANKASSESSMENT_MATHEQUATION");
        return itemBankAssessmentMathQuestion;
    }

    public String getItemBankAssessmentMERItem() {
        itemBankAssessmentMERItem = properties.getProperty("ITEMBANKASSESSMENT_MERITEM");
        return itemBankAssessmentMERItem;
    }

    public String getCreateItemSaveMessage() {
        createItemSaveMessage = properties.getProperty("CREATEITEM_SAVEMESSAGE");
        return createItemSaveMessage;
    }

    public String getCreateItemCreateRadioButton() {
        createItemCreateRadioButton = properties.getProperty("CREATEITEM_CREATERADIOBUTTON");
        return createItemCreateRadioButton;
    }

    public String getCreateItemNoItemsFound() {
        CreateItemNoItemsFound = properties.getProperty("CREATEITEM_NOITEMSFOUND");
        return CreateItemNoItemsFound;
    }

    public String getItemBankAssessmentEnter() {
        itemBankAssessmentEnter = properties.getProperty("ITEMBANKASSESSMENT_ENTER");
        return itemBankAssessmentEnter;
    }

    public String getItemBankAssessmentViewType() {
        itemBankAssessmentViewType = properties.getProperty("ITEMBANKASSESSMENT_VIEWTYPE");
        return itemBankAssessmentViewType;
    }

    public String getItemBankAssessmentFindStudents() {
        itemBankAssessmentFindStudents = properties.getProperty("ITEMBANKASSESSMENT_FINDSTUDENTS");
        return itemBankAssessmentFindStudents;
    }
    public String getItemBankAssessmentStanderds() {
        itemBankAssessmenStanderds = properties.getProperty("ITEMBANKASSESSMENT_STANDERDS");
        return itemBankAssessmenStanderds;
    }
    public String getItemBankAssessmentStanderdHeader() {
        itemBankAssessmentStanderdHeader = properties.getProperty("ITEMBANKASSESSMENT_STANDERDHEADER");
        return itemBankAssessmentStanderdHeader;
    }
    public String getItemBankAssessmentUnselectStaderds() {
        itemBankAssessmentUnselectStanderds = properties.getProperty("ITEMBANKASSESSMENT_UNSELECTSTANDERDS");
        return itemBankAssessmentUnselectStanderds;
    }
    public String getItemBankAssessmentUpdateStanderds() {
        itemBankAssessmentUpdateStanderds = properties.getProperty("ITEMBANKASSESSMENT_UPDATESTANDERDS");
        return itemBankAssessmentUpdateStanderds;
    }

    public String getItemBankAssessmentSelectItem() {
        itemBankAssessmentSelectItem = properties.getProperty("ITEMBANKASSESSMENT_SELECTITEMTYPE");
        return itemBankAssessmentSelectItem;
    }

    public String getItemBankAssessmenentEBSR() {
        itemBankAssessmenentEBSR = properties.getProperty("ITEMBANKASSESSMENT_EVIDENCEBASEDSELECTEDRESPONSE");
        return itemBankAssessmenentEBSR;
    }

    public String getItemBankAssessmenAddStanderds() {
        itemBankAssessmenAddStanderds = properties.getProperty("ITEMBANKASSESSMENT_ADDSTANDERDS");
        return itemBankAssessmenAddStanderds;
    }

    public String getItemBankAssessmentHSTItem() {
        itemBankAssessmentHighlightSelectableText = properties.getProperty("ITEMBANKASSESSMENT_HIGHLIGHTSELECTABLETEXT");
        return itemBankAssessmentHighlightSelectableText;
    }

    public String getItemBankAssessmentMultiport() {
        itemBankAssessmentMultiport = properties.getProperty("ITEMBANKASSESSMENT_MULTIPORT");
        return itemBankAssessmentMultiport;
    }

    public String getItemBankAssessmentDragAndDropclassify() {
        itemBankAssessmentDragAndDropclassify = properties.getProperty("ITEMBANKASSESSMENT_DRAGANDDROPCLASSIFY");
        return itemBankAssessmentDragAndDropclassify;
    }

    public String getItemBankAssessmentDragAndDropOrder() {
        itemBankAssessmentDragAndDropOrder = properties.getProperty("ITEMBANKASSESSMENT_DRAGANDDROPORDER");
        return itemBankAssessmentDragAndDropOrder;
    }
    public String getItemBankAssessmentStanderdsAdded() {
        itemBankAssessmentStanderdsAdded= properties.getProperty("ITEMBANKASSESSMENT_STANDERDSADDED");
        return itemBankAssessmentStanderdsAdded;
    }
}




