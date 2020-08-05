package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model Class for FlexAnswerKeyPage
 **/
public class FlexAnswerKeyPage {
    private String flexAnswerKeyCreateAssessment, flexAnswerKeyFlexible, flexAnswerKeyCloseButton;
    private String flexAnswerKeyCreate, flexAnswerKeyDoneButton;
    private String studentSmallSlipsAfterEnterEdit, flexAnswerKeyAfterEnterEdit, studentSmallSlipsBeforeEnterEdit, flexAnswerKeyGridSave, studentSmallSlips, miniReport, report, enterEdit, flexAnswerKeyEditButton, flexAnswerKeyAdminister, flexAnswerKeyOnlineTesting;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public FlexAnswerKeyPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Portal", "");
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

    public String getFlexAnswerKeyCreateAssessment() {
        flexAnswerKeyCreateAssessment = properties.getProperty("FLEXANSWERKEY_CREATEASSESSMENT");
        return flexAnswerKeyCreateAssessment;
    }

    public String getFlexAnswerKeyFlexible() {
        flexAnswerKeyFlexible = properties.getProperty("FLEXANSWERKEY_FLEXIBLE");
        return flexAnswerKeyFlexible;
    }

    public String getFlexAnswerKeyCreate() {
        flexAnswerKeyCreate = properties.getProperty("FLEXANSWERKEY_CREATE");
        return flexAnswerKeyCreate;
    }

    public String getFlexAnswerKeyCloseButton() {
        flexAnswerKeyCloseButton = properties.getProperty("FLEXANSWERKEY_CANCELBUTTON");
        return flexAnswerKeyCloseButton;
    }

    public String getFlexAnswerKeyDoneButton() {
        flexAnswerKeyDoneButton = properties.getProperty("FLEXANSWERKEY_DONEBUTTON");
        return flexAnswerKeyDoneButton;
    }

    public String getFlexAnswerKeyAdminister() {
        flexAnswerKeyAdminister = properties.getProperty("FLEXANSWERKEY_ADMINISTER");
        return flexAnswerKeyAdminister;
    }

    public String getFlexAnswerKeyOnlineTesting() {
        flexAnswerKeyOnlineTesting = properties.getProperty("FLEXANSWERKEY_ONLINETESTING");
        return flexAnswerKeyOnlineTesting;
    }

    public String getFlexAnswerKeyEditButton() {
        flexAnswerKeyEditButton = properties.getProperty("FLEXANSWERKEY_EDITBUTTON");
        return flexAnswerKeyEditButton;
    }

    public String getEnterEdit() {
        enterEdit = properties.getProperty("FLEXANSWERKEY_ENTEREDIT");
        return enterEdit;
    }

    public String getReport() {
        report = properties.getProperty("FLEXANSWERKEY_REPORT");
        return report;
    }

    public String getMiniReport() {
        miniReport = properties.getProperty("FLEXANSWERKEY_MINIREPORT");
        return miniReport;
    }

    public String getStudentSmallSlips() {
        studentSmallSlips = properties.getProperty("FLEXANSWERKEY_STUDENTSMALLSLIPS");
        return studentSmallSlips;
    }

    public String getFlexAnswerKeyGridSave() {
        flexAnswerKeyGridSave = properties.getProperty("FLEXANSWERKEY_GRIDSAVE");
        return flexAnswerKeyGridSave;
    }

    public String getStudentSmallSlipsBeforeEnterEdit() {
        studentSmallSlipsBeforeEnterEdit = properties.getProperty("FLEXANSWERKEY_SMALLSLIPSBEFOREENTEREDIT");
        return studentSmallSlipsBeforeEnterEdit;
    }

    public String getFlexAnswerKeyAfterEnterEdit() {
        flexAnswerKeyAfterEnterEdit = properties.getProperty("FLEXANSWERKEY_AFTERENTEREDIT");
        return flexAnswerKeyAfterEnterEdit;
    }

    public String getStudentSmallSlipsAfterEnterEdit() {
        studentSmallSlipsAfterEnterEdit = properties.getProperty("FLEXANSWERKEY_SMALLSLIPSAFTERENTEREDIT");
        return studentSmallSlipsAfterEnterEdit;
    }
}
