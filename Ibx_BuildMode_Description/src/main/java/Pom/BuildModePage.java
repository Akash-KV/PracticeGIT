package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BuildModePage
 **/
public class BuildModePage {

    private static String build_Description_SaveButton, build_Description_CancelButton, build_Item_Section, build_BuildButton;
    private static String build_BrowseButton, build_Description_PopupTitle, build_Description_PopupWindow, build_Description_TextBox, build_Description_Button;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Description", "");
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

    public String getBuild_Description_Button() {
        build_Description_Button = properties.getProperty("BUILD_DESCRIPTION_BUTTON");
        return build_Description_Button;
    }

    public String getBuild_Description_TextBox() {
        build_Description_TextBox = properties.getProperty("BUILD_DESCRIPTION_TEXTBOX");
        return build_Description_TextBox;
    }

    public String getBuild_Description_PopupWindow() {
        build_Description_PopupWindow = properties.getProperty("BUILD_DESCRIPTION_POPUPWINDOW");
        return build_Description_PopupWindow;
    }

    public String getBuild_Description_CancelButton() {
        build_Description_CancelButton = properties.getProperty("BUILD_DESCRIPTION_CANCELBUTTON");
        return build_Description_CancelButton;
    }

    public String getBuild_Description_SaveButton() {
        build_Description_SaveButton = properties.getProperty("BUILD_DESCRIPTION_SAVEBUTTON");
        return build_Description_SaveButton;
    }

    public String getBuild_Description_Popuptitle() {
        build_Description_PopupTitle = properties.getProperty("BUILD_DESCRIPTION_POPUPTITLE");
        return build_Description_PopupTitle;
    }

    public String getBuild_BrowseButton() {
        build_BrowseButton = properties.getProperty("BUILD_BROWSEBUTTON");
        return build_BrowseButton;
    }

    public String getBuild_BuildButton() {
        build_BuildButton = properties.getProperty("BUILD_BUILDBUTTON");
        return build_BuildButton;
    }


}