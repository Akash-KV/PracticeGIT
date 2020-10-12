package Pom;

import Helpers.DriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BuildModePage
 **/
public class BuildModePage {

    private String build_Item_Section, build_First_Item_More_Button, build_First_Item_Remove_Button, build_First_Item_Content;
    private String build_No_Items_Message, build_Toggle_Button, build_Expand_Button, build_Collapse_Button;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_SingleItemPassageRemove", "");
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
     * method to read the data from property file
     **/

    public String getBuild_Item_Section() {
        build_Item_Section = properties.getProperty("BUILD_ITEM_SECTION");
        return build_Item_Section;
    }

    public String getBuild_First_Item_More_Button() {
        build_First_Item_More_Button = properties.getProperty("BUILD_FIRST_ITEM_MORE_BUTTON");
        return build_First_Item_More_Button;
    }

    public String getBuild_First_Item_Remove_Button() {
        build_First_Item_Remove_Button = properties.getProperty("BUILD_FIRST_ITEM_REMOVE_ITEM");
        return build_First_Item_Remove_Button;
    }

    public String getBuild_No_Items_Message() {
        build_No_Items_Message = properties.getProperty("BUILD_NO_ITEMS");
        return build_No_Items_Message;
    }

    public String getBuild_Toggle_Button() {
        build_Toggle_Button = properties.getProperty("BUILD_TOGGLE_BUTTON");
        return build_Toggle_Button;
    }

    public String getBuild_Expand_Button() {
        build_Expand_Button = properties.getProperty("BUILD_EXPAND_BUTTON");
        return build_Expand_Button;
    }

    public String getBuild_Collapse_Button() {
        build_Collapse_Button = properties.getProperty("BUILD_COLLAPSE_BUTTON");
        return build_Collapse_Button;
    }

    public String getBuild_First_Item_Content() {
        build_First_Item_Content = properties.getProperty("BUILD_FIRST_ITEM_CONTENT");
        return build_First_Item_Content;
    }
}