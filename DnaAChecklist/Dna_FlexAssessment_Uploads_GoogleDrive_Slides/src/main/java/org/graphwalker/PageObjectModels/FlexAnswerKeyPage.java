package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for FlexAnswerKeyPage
public class FlexAnswerKeyPage {
    private String flexAnswerKeyCreateAssessment, flexAnswerKeyFlexible, flexAnswerKeyUploadButton, flexAnswerKeyUploadType;
    private String flexAnswerKeyResourcesRow, flexAnswerKeyPreviewUnAvailableMessage, flexAnswerKeyGoogleDrive, flexAnswerKeyDialogFrame, flexAnswerKeySearchTerms, flexAnswerKeySearchTermsImage;
    private String flexAnswerKeyIdentifierID, flexAnswerKeyIdentifierNext, flexAnswerKeyPassword, flexAnswerKeyPasswordNext, flexAnswerKeyUploadSuccess;
    private String flexAnswerKeyDisplayValidationComponent, flexAnswerKeyExitUploadMaterialsModel, flexAnswerKeyAssessmentTitle, flexAnswerKeyCreate, flexAnswerKeyDoneButton;
    private String flexAnswerKeyAdministerButton, flexAnswerKeyOnlineTesting;
    private String flexAnswerKeyCloseButton, flexAnswerKeyIlluminateUser, flexAnswerKeyPdfConfirmation, flexAnswerKeyPdfConfirmationModel, flexAnswerKeyTestGoogleDoc, flexAnswerKeyFlexColumnClose;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public FlexAnswerKeyPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Uploads_GoogleDrive_Slides", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\FlexAnswerKeyPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/FlexAnswerKeyPage.properties");
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

    public String getFlexAnswerKeyCloseButton() {
        flexAnswerKeyCloseButton = properties.getProperty("FLEXANSWERKEY_CANCELBUTTON");
        return flexAnswerKeyCloseButton;
    }

    public String getFlexAnswerKeyCreateAssessment() {
        flexAnswerKeyCreateAssessment = properties.getProperty("FLEXANSWERKEY_CREATEASSESSMENT");
        return flexAnswerKeyCreateAssessment;
    }

    public String getFlexAnswerKeyFlexible() {
        flexAnswerKeyFlexible = properties.getProperty("FLEXANSWERKEY_FLEXIBLE");
        return flexAnswerKeyFlexible;
    }


    public String getFlexAnswerKeyUploadButton() {
        flexAnswerKeyUploadButton = properties.getProperty("FLEXANSWERKEY_UPLOADBUTTON");
        return flexAnswerKeyUploadButton;
    }

    public String getFlexAnswerKeyUploadType() {
        flexAnswerKeyUploadType = properties.getProperty("FLEXANSWERKEY_UPLOADTYPE");
        return flexAnswerKeyUploadType;
    }

    public String getFlexAnswerKeyResourcesRow() {
        flexAnswerKeyResourcesRow = properties.getProperty("FLEXANSWERKEY_RESOURCES_ROW");
        return flexAnswerKeyResourcesRow;
    }

    public String getFlexAnswerKeyPreviewUnAvailableMessage() {
        flexAnswerKeyPreviewUnAvailableMessage = properties.getProperty("FLEXANSWERKEY_PREVIEWUNAVAILABLEMESSAGE");
        return flexAnswerKeyPreviewUnAvailableMessage;
    }

    public String getFlexAnswerKeyGoogleDrive() {
        flexAnswerKeyGoogleDrive = properties.getProperty("FLEXANSWERKEY_GOOGLEDRIVE");
        return flexAnswerKeyGoogleDrive;
    }

    public String getFlexAnswerKeyDialogFrame() {
        flexAnswerKeyDialogFrame = properties.getProperty("FLEXANSWERKEY_DIALOGFRAME");
        return flexAnswerKeyDialogFrame;
    }

    public String getFlexAnswerKeySearchTerms() {
        flexAnswerKeySearchTerms = properties.getProperty("FLEXANSWERKEY_SEARCHTERMS");
        return flexAnswerKeySearchTerms;
    }

    public String getFlexAnswerKeySearchTermsImage() {
        flexAnswerKeySearchTermsImage = properties.getProperty("FLEXANSWERKEY_SEARCHTERMSIMAGE");
        return flexAnswerKeySearchTermsImage;
    }

    public String getFlexAnswerKeyIdentifierID() {
        flexAnswerKeyIdentifierID = properties.getProperty("FLEXANSWERKEY_IDENTIFIERID");
        return flexAnswerKeyIdentifierID;
    }

    public String getFlexAnswerKeyIdentifierNext() {
        flexAnswerKeyIdentifierNext = properties.getProperty("FLEXANSWERKEY_IDENTIFIERNEXT");
        return flexAnswerKeyIdentifierNext;
    }

    public String getFlexAnswerKeyPassword() {
        flexAnswerKeyPassword = properties.getProperty("FLEXANSWERKEY_PASSWORD");
        return flexAnswerKeyPassword;
    }

    public String getFlexAnswerKeyPasswordNext() {
        flexAnswerKeyPasswordNext = properties.getProperty("FLEXANSWERKEY_PASSWORDNEXT");
        return flexAnswerKeyPasswordNext;
    }

    public String getFlexAnswerKeyUploadSuccess() {
        flexAnswerKeyUploadSuccess = properties.getProperty("FLEXANSWERKEY_UPLOADSUCCESS");
        return flexAnswerKeyUploadSuccess;
    }

    public String getFlexAnswerKeyDisplayValidationComponent() {
        flexAnswerKeyDisplayValidationComponent = properties.getProperty("FLEXANSWERKEY_DISPLAYVALIDATIONSCOMPONENT");
        return flexAnswerKeyDisplayValidationComponent;
    }

    public String getFlexAnswerKeyExitUploadMaterialsModel() {
        flexAnswerKeyExitUploadMaterialsModel = properties.getProperty("FLEXANSWERKEY_EXITUPLOADMATERIALSMODEL");
        return flexAnswerKeyExitUploadMaterialsModel;
    }

    public String getFlexAnswerKeyAssessmentTitle() {
        flexAnswerKeyAssessmentTitle = properties.getProperty("FLEXANSWERKEY_ADDASSESSMENTTITLE");
        return flexAnswerKeyAssessmentTitle;
    }

    public String getFlexAnswerKeyCreate() {
        flexAnswerKeyCreate = properties.getProperty("FLEXANSWERKEY_CREATE");
        return flexAnswerKeyCreate;
    }

    public String getFlexAnswerKeyDoneButton() {
        flexAnswerKeyDoneButton = properties.getProperty("FLEXANSWERKEY_DONEBUTTON");
        return flexAnswerKeyDoneButton;
    }

    public String getFlexAnswerKeyAdministerButton() {
        flexAnswerKeyAdministerButton = properties.getProperty("FLEXANSWERKEY_ADMINISTERBUTTON");
        return flexAnswerKeyAdministerButton;
    }

    public String getFlexAnswerKeyOnlineTesting() {
        flexAnswerKeyOnlineTesting = properties.getProperty("FLEXANSWERKEY_ONLINETESTING");
        return flexAnswerKeyOnlineTesting;
    }


    public String getFlexAnswerKeyIlluminateUser() {
        flexAnswerKeyIlluminateUser = properties.getProperty("FLEXANSWERKEY_ILLUMINATETESTUSER");
        return flexAnswerKeyIlluminateUser;
    }

    public String getFlexAnswerKeyPdfConfirmation() {
        flexAnswerKeyPdfConfirmation = properties.getProperty("FLEXANSWERKEY_PDFCONFIRMATION");
        return flexAnswerKeyPdfConfirmation;
    }

    public String getFlexAnswerKeyPdfConfirmationModel() {
        flexAnswerKeyPdfConfirmationModel = properties.getProperty("FLEXANSWERKEY_PDFCONFIRMATIONMODEL");
        return flexAnswerKeyPdfConfirmationModel;
    }

    public String getFlexAnswerKeyTestGoogleDoc() {
        flexAnswerKeyTestGoogleDoc = properties.getProperty("FLEXANSWERKEY_TESTGOOGLEDOC");
        return flexAnswerKeyTestGoogleDoc;
    }

    public String getFlexAnswerKeyFlexColumnClose() {
        flexAnswerKeyFlexColumnClose = properties.getProperty("FLEXANSWERKEY_FLEXCOLUMNCLOSE");
        return flexAnswerKeyFlexColumnClose;
    }
}
