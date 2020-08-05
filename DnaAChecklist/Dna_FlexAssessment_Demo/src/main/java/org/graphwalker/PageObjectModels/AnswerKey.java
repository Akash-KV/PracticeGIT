package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model Class for AnswerKey
 **/
public class AnswerKey {
    private String answerKeyMc, answerKeyCrAdv, answerKeyCrExp, answerKeyCr, answerKeyMcPtl, answerKeyMcAdv, questionsSaved, multipleChoiceAdvanced;
    private String explicitConstructedResponseSecondInput, explicitConstructedResponseFirstInput, explicitConstructedResponseAddIcon, answerKeyAddQuestions, answerKeyQuestionQuantity, answerKeyAddButton;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AnswerKey() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Demo", "");
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

    public String getExplicitConstructedResponseAddIcon() {
        explicitConstructedResponseAddIcon = properties.getProperty("ANSWERKEY_EXPLICITCONSTRUCTEDRESPONSE_ADDICON");
        return explicitConstructedResponseAddIcon;
    }

    public String getExplicitConstructedResponseFirstInput() {
        explicitConstructedResponseFirstInput = properties.getProperty("ANSWERKEY_EXPLICITCONSTRUCTEDRESPONSE_FIRSTINPUT");
        return explicitConstructedResponseFirstInput;
    }

    public String getExplicitConstructedResponseSecondInput() {
        explicitConstructedResponseSecondInput = properties.getProperty("ANSWERKEY_EXPLICITCONSTRUCTEDRESPONSE_SECONDINPUT");
        return explicitConstructedResponseSecondInput;
    }

    public String getMultipleChoiceAdvanced() {
        multipleChoiceAdvanced = properties.getProperty("ANSWERKEY_MULTIPLECHOICEADVANCED");
        return multipleChoiceAdvanced;
    }

    public String getQuestionsSaved() {
        questionsSaved = properties.getProperty("ANSWERKEY_QUESTIONSSAVED");
        return questionsSaved;
    }

    public String getAnswerKeyMc() {
        answerKeyMc = properties.getProperty("ANSWERKEY_MC");
        return answerKeyMc;
    }

    public String getAnswerKeyCrAdv() {
        answerKeyCrAdv = properties.getProperty("ANSWERKEY_CRADV");
        return answerKeyCrAdv;
    }

    public String getAnswerKeyCrExp() {
        answerKeyCrExp = properties.getProperty("ANSWERKEY_CREXP");
        return answerKeyCrExp;
    }

    public String getAnswerKeyCr() {
        answerKeyCr = properties.getProperty("ANSWERKEY_CR");
        return answerKeyCr;
    }

    public String getAnswerKeyMcPtl() {
        answerKeyMcPtl = properties.getProperty("ANSWERKEY_MCPTL");
        return answerKeyMcPtl;
    }

    public String getAnswerKeyMcAdv() {
        answerKeyMcAdv = properties.getProperty("ANSWERKEY_MCADV");
        return answerKeyMcAdv;
    }
}