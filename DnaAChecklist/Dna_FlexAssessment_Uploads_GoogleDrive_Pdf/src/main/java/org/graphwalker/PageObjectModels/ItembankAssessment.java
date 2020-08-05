package org.graphwalker.PageObjectModels;

//Page object model class for ItembankAssessment
public class ItembankAssessment extends PageObjectModelBase {
    private String quickMode;
    private String nextButton;
    private String titleInput;
    private String createButton;
    private String standardDocument;
    private String standards;
    private String standardSubject;
    private String subject;
    private String standardCategory;
    private String category;
    private String standardItems;
    private String verifyStandards;
    private String continueButton;
    private String add;
    private String assessmentTitle;
    private String generateQuestions;
    private String verifyQuestions;
    private String readyToPublish;
    private String publishAdminister;

    //ItembankAssessment methods
    public String getQuickMode() {
        quickMode = reader.getData("quickMode");
        return quickMode;
    }

    public String getNextButton() {
        nextButton = reader.getData("nextButton");
        return nextButton;
    }

    public String getTitleInput() {
        titleInput = reader.getData("titleInput");
        return titleInput;
    }

    public String getCreateButton() {
        createButton = reader.getData("createButton");
        return createButton;
    }

    public String getStandardDocument() {
        standardDocument = reader.getData("standardDocument");
        return standardDocument;
    }

    public String getStandards() {
        standards = reader.getData("standards");
        return standards;
    }

    public String getStandardSubject() {
        standardSubject = reader.getData("standardSubject");
        return standardSubject;
    }


    public String getSubject() {
        subject = reader.getData("subject");
        return subject;
    }

    public String getStandardCategory() {
        standardCategory = reader.getData("standardCategory");
        return standardCategory;
    }

    public String getCategory() {
        category = reader.getData("category");
        return category;
    }

    public String getStandardItems() {
        standardItems = reader.getData("standardItems");
        return standardItems;
    }

    public String getVerifyStandards() {
        verifyStandards = reader.getData("verifyStandards");
        return verifyStandards;
    }

    public String getContinueButton() {
        continueButton = reader.getData("continueButton");
        return continueButton;
    }

    public String getAdd() {
        add = reader.getData("add");
        return add;
    }

    public String getAssessmentTitle() {
        assessmentTitle = reader.getData("assessmentTitle");
        return assessmentTitle;
    }

    public String getGenerateQuestions() {
        generateQuestions = reader.getData("generateQuestions");
        return generateQuestions;
    }

    public String getVerifyQuestions() {
        verifyQuestions = reader.getData("verifyQuestions");
        return verifyQuestions;
    }

    public String getReadyToPublish() {
        readyToPublish = reader.getData("readyToPublish");
        return readyToPublish;
    }

    public String getPublishAdminister() {
        publishAdminister = reader.getData("publishAdminister");
        return publishAdminister;
    }
}