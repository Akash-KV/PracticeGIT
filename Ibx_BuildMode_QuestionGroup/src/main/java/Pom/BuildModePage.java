package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BuildModePage
 **/
public class BuildModePage {

    private String build_Item_Section, build_First_Item_Content, build_First_Item_Question_Groups_Button;
    private String build_First_Item_Question_Groups_List, build_First_Item_Question_Groups_Search;
    private String build_First_Item_Question_Groups_Count, build_Save_CheckMark, build_Question_Group_Tick_Mark;
    private String build_Question_Group_Hover, navigateToBrowse, closeSearch, searchById, itemSearch, addItems;
    private String navigateToBuild, questionGrp, settingsIcon, disabled, toggle, enabled;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_QuestionGroup", "");
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

    public String getBuild_First_Item_Content() {
        build_First_Item_Content = properties.getProperty("BUILD_FIRST_ITEM_CONTENT");
        return build_First_Item_Content;
    }

    public String getBuild_First_Item_Question_Groups_Button() {
        build_First_Item_Question_Groups_Button = properties.getProperty("BUILD_FIRST_ITEM_QUESTION_GROUPS_BUTTON");
        return build_First_Item_Question_Groups_Button;
    }

    public String getBuild_First_Item_Question_Groups_List() {
        build_First_Item_Question_Groups_List = properties.getProperty("BUILD_FIRST_ITEM_QUESTION_GROUPS_LIST");
        return build_First_Item_Question_Groups_List;
    }

    public String getBuild_First_Item_Question_Groups_Search() {
        build_First_Item_Question_Groups_Search = properties.getProperty("BUILD_FIRST_ITEM_QUESTION_GROUPS_SEARCH");
        return build_First_Item_Question_Groups_Search;
    }

    public String getBuild_First_Item_Question_Groups_Count() {
        build_First_Item_Question_Groups_Count = properties.getProperty("BUILD_FIRST_ITEM_QUESTION_GROUPS_COUNT");
        return build_First_Item_Question_Groups_Count;
    }

    public String getBuild_Save_CheckMark() {
        build_Save_CheckMark = properties.getProperty("BUILD_SAVE_CHECK_MARK");
        return build_Save_CheckMark;
    }

    public String getBuild_Question_Group_Tick_Mark() {
        build_Question_Group_Tick_Mark = properties.getProperty("BUILD_QUESTION_GROUP_TICK_MARK");
        return build_Question_Group_Tick_Mark;
    }

    public String getBuild_Question_Group_Hover() {
        build_Question_Group_Hover = properties.getProperty("BUILD_QUESTION_GROUP_HOVER");
        return build_Question_Group_Hover;
    }

    public String getNavigateToBrowse() {
        navigateToBrowse = properties.getProperty("BUILD_NAVIGATE_TO_BROWSE");
        return navigateToBrowse;
    }

    public String getCloseSearch() {
        closeSearch = properties.getProperty("BUILD_CLOSE_SEARCH");
        return closeSearch;
    }

    public String getSearchById() {
        searchById = properties.getProperty("BUILD_SEARCH_TEXT_BOX");
        return searchById;
    }

    public String getItemSearch() {
        itemSearch = properties.getProperty("BUILD_SEARCH_ITEM");
        return itemSearch;
    }

    public String getAddItems() {
        addItems = properties.getProperty("BUILD_ADD_ITEMS");
        return addItems;
    }

    public String getNavigateToBuild() {
        navigateToBuild = properties.getProperty("BUILD_NAVIGATE_TO_BUILD");
        return navigateToBuild;
    }

    public String getQuestionGrp() {
        questionGrp = properties.getProperty("BUILD_QUESTION_GROUP_BUTTON");
        return questionGrp;
    }

    public String getSettingsIcon() {
        settingsIcon = properties.getProperty("BUILD_QUESTION_GROUP_SETTINGS");
        return settingsIcon;
    }

    public String getDisabled() {
        disabled = properties.getProperty("BUILD_DISABLED");
        return disabled;
    }

    public String getToggle() {
        toggle = properties.getProperty("BUILD_TOGGLE");
        return toggle;
    }

    public String getEnabled() {
        enabled = properties.getProperty("BUILD_ENABLED");
        return enabled;
    }

}