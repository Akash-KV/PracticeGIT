package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BuildModePage
 **/
public class BuildModePage {


    private String build_ExtraCredit_Checkbox, build_FirstItemContentSection, build_CompactView, build_CollapseView;
    private String build_BuildButton, build_BrowseButton, build_SaveCheckMark, build_ExtraCredit_CheckboxStatus;
    private String build_FirstItem_Section, buildModeMoreVert;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_ExtraCredit", "");
            System.out.println("dir: " + dir);
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
     * Method to read data from property file
     **/

    public String getBuildModeMoreVert() {
        buildModeMoreVert = properties.getProperty("BUILD_MODE_MORE_VERT");
        return buildModeMoreVert;
    }

    public String getBuild_FirstItem_Section() {
        build_FirstItem_Section = properties.getProperty("BUILD_FIRSTITEM_SECTION");
        return build_FirstItem_Section;
    }

    public String getBuild_ExtraCredit_Checkbox() {
        build_ExtraCredit_Checkbox = properties.getProperty("BUILD_EXTRACREDIT_CHECKBOX");
        return build_ExtraCredit_Checkbox;
    }

    public String getBuild_FirstItemContentSection() {
        build_FirstItemContentSection = properties.getProperty("BUILD_ITEM_CONTENTSECTION");
        return build_FirstItemContentSection;
    }

    public String getBuild_CompactView() {
        build_CompactView = properties.getProperty("BUILD_COMPACTVIEW_OPTION");
        return build_CompactView;
    }

    public String getBuild_CollapseView() {
        build_CollapseView = properties.getProperty("BUILD_COLLAPSEVIEW_OPTION");
        return build_CollapseView;
    }

    public String getBuild_BrowseButton() {
        build_BrowseButton = properties.getProperty("BUILD_BROWSEBUTTON");
        return build_BrowseButton;
    }

    public String getBuild_BuildButton() {
        build_BuildButton = properties.getProperty("BUILD_BUILDBUTTON");
        return build_BuildButton;
    }

    public String getBuild_SaveCheckMark() {
        build_SaveCheckMark = properties.getProperty("BUILD_SAVE_CHECK_MARK");
        return build_SaveCheckMark;
    }

    public String getBuild_ExtraCredit_CheckboxStatus() {
        build_ExtraCredit_CheckboxStatus = properties.getProperty("BUILD_EXTRACREDIT_CHECKBOXSTATUS");
        return build_ExtraCredit_CheckboxStatus;
    }

}