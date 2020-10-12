package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BuildModePage
 **/
public class BuildModePage {

    private String build_SelectedItem_Header, build_NumOfItems_Selected, build_RemoveItem;
    private String build_NoItems, build_ItemCounter, build_Button;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_MassApply", "");
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

    //methods to read date from property file
    public String getBuild_SelectedItem_Header() {
        build_SelectedItem_Header = properties.getProperty("BUILD_SELECTEDITEMSHEADER");
        return build_SelectedItem_Header;
    }

    public String getBuild_NumOfItems_Selected() {
        build_NumOfItems_Selected = properties.getProperty("BUILD_NUMOFITEMSSELECTED");
        return build_NumOfItems_Selected;
    }

    public String getBuild_RemoveItem() {
        build_RemoveItem = properties.getProperty("BUILD_REMOVEITEM");
        return build_RemoveItem;
    }

    public String getBuild_NoItems() {
        build_NoItems = properties.getProperty("BUILD_NO_ITEMS");
        return build_NoItems;
    }

    public String getBuild_ItemCounter() {
        build_ItemCounter = properties.getProperty("BUILD_ITEMCOUNTER");
        return build_ItemCounter;
    }

    public String getBuild_Button() {
        build_Button = properties.getProperty("BUILD_BUTTON");
        return build_Button;
    }

}