package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/******************Page Object Model for AnswerKey**********************/
public class AnswerKey {
    private String answerKeyAddQuestions, answerKeyQuestionQuantity, answerKeyAddButton;
    private String answerKeyMaterial, answerKeyResources, explicitConstructedResponseAddIcon, explicitConstructedResponseFirstInput, explicitConstructedResponseSecondInput;
    private String multipleChoiceAdvanced, answerKeyUploads, dropDownText;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AnswerKey() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Uploads_Local_Doc", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\AnswerKey.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/AnswerKey.properties");
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

    public String getAnswerKeyAddQuestions() {
        answerKeyAddQuestions = properties.getProperty("ANSWERKEY_ADDQUESTIONS");
        return answerKeyAddQuestions;
    }

    public String getAnswerKeyQuestionQuantity() {
        answerKeyQuestionQuantity = properties.getProperty("ANSWERKEY_QUESTIONQUANTITY");
        return answerKeyQuestionQuantity;
    }

    public String getAnswerKeyAddButton() {
        answerKeyAddButton = properties.getProperty("ANSWERKEY_ADDBUTTON");
        return answerKeyAddButton;
    }

    public String getAnswerKeyMaterial() {
        answerKeyMaterial = properties.getProperty("ANSWERKEY_MATERIAL");
        return answerKeyMaterial;
    }

    public String getAnswerKeyResources() {
        answerKeyResources = properties.getProperty("ANSWERKEY_RESOURCES");
        return answerKeyResources;
    }

    public String getAnswerKeyUploads() {
        answerKeyUploads = properties.getProperty("ANSWERKEY_ADDBUTTON_UPLOADS");
        return answerKeyUploads;
    }


    public String getExplicitConstructedResponseFirstInput() {
        explicitConstructedResponseFirstInput = properties.getProperty("ANSWERKEY_EXPLICITCONSTRUCTEDRESPONSE_FIRSTINPUT");
        return explicitConstructedResponseFirstInput;
    }

    public String getexplicitConstructedResponseAddIcon() {
        explicitConstructedResponseAddIcon = properties.getProperty("ANSWERKEY_EXPLICITCONSTRUCTEDRESPONSE_ADDICON");
        return explicitConstructedResponseAddIcon;
    }

    public String getExplicitConstructedResponseSecondInput() {
        explicitConstructedResponseSecondInput = properties.getProperty("ANSWERKEY_EXPLICITCONSTRUCTEDRESPONSE_SECONDINPUT");
        return explicitConstructedResponseSecondInput;
    }

    public String getMultipleChoiceAdvanced() {
        multipleChoiceAdvanced = properties.getProperty("ANSWERKEY_MULTIPLECHOICEADVANCED");
        return multipleChoiceAdvanced;
    }

    public String getDropDownText() {
        dropDownText = properties.getProperty("ANSWERKEY_MULTIPLECHOICEADVANCED_DROPDOWNTEXT");
        return dropDownText;
    }


}
