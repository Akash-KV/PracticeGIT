package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BuildModePage
 **/
public class BuildModePage {

    private String buildViewPage, assessmentName_BuildMode_Header, buildSaveCheckMark, buildModeToggleButton, build_First_Item_Content;
    private String itemHeader, buildModeFirstItemCheckBox, buildModeRemoveButton, buildModeTotalItems, build_Item_Section;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_CreateNewAssessmentModal", "");
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
     * methods to read date from property file
     **/

    public String getBuildViewPage() {
        buildViewPage = properties.getProperty("BUILD_VIEW_PAGE");
        return buildViewPage;
    }

    public String getAssessmentName_BuildMode_Header() {
        //assessmentName_BuildMode_Header = "//div[@class='header-title']/div[@class='title']";
        assessmentName_BuildMode_Header = properties.getProperty("BUILD_HEADER_ASSESSMENT_NAME");
        return assessmentName_BuildMode_Header;
    }

    public String getBuild_Item_Section() {
        build_Item_Section = properties.getProperty("BUILD_ITEM_SECTION");
        return build_Item_Section;
    }

    public String getBuild_First_Item_Content() {
        build_First_Item_Content = properties.getProperty("BUILD_FIRST_ITEM_CONTENT");
        return build_First_Item_Content;
    }

    public String getBuildModeToggleButton() {
        buildModeToggleButton = properties.getProperty("BUILD_TOGGLE_BUTTON");
        return buildModeToggleButton;
    }

    public String getBuildModeRemoveButton() {
        buildModeRemoveButton = properties.getProperty("BUILD_REMOVE_BUTTON");
        return buildModeRemoveButton;
    }

    public String getBuildModeTotalItems() {
        buildModeTotalItems = properties.getProperty("BUILD_TOTAL_ITEMS");
        return buildModeTotalItems;
    }

    public String getBuildModeFirstItemCheckBox() {
        buildModeFirstItemCheckBox = properties.getProperty("BUILD_FIRST_ITEM_CHECKBOX");
        return buildModeFirstItemCheckBox;
    }

    public String getBuildSaveCheckMark() {
        buildSaveCheckMark = properties.getProperty("BUILD_SAVE_CHECK_MARK");
        return buildSaveCheckMark;
    }

    public String getItemHeader() {
        itemHeader = properties.getProperty("BUILD_ITEM_HEADER");
        return itemHeader;
    }

}