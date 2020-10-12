package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import Helpers.DriverHelper;

/**
 * Page object model class for BuildModePage
 **/
public class BuildModePage {

    private String buildModeStandardsSaved,build_Mode_New_Aligned_Standard, buildModeFirstStandardsInModal, build_Mode_Base_Standard_Select, build_Mode_Standard_Hover, build_Mode_Aligned_Standard, build_Mode_Green_Tick;
    private String build_Mode_Back_Chevron_Button, build_Mode_Base_Standard_List, build_Mode_Create_Item_Close, build_Mode_Standard_Modal_Close, build_Mode_Standard_Modal_List, build_Mode_Standard_List;
    private String build_Mode_Show_More, build_Mode_Standard_Chip, build_Mode_Build_Button, build_Mode_Icon_Hover, build_Mode_Browse_Button, build_Mode_Standard_Modal_Header, build_Mode_Edit_Icon, build_Mode_Standard_Plus;
    private String build_Mode_Page_Header, build_Mode_Add_Item, build_Mode_Standard_Text_Box, build_Mode_Standard_Modal_Done, build_Mode_Selected_Standard, build_Common_Core_Standard, build_Standard_Subject;
    private String build_Mode_Add_More, align_Standards_Icon, buildModeBaseStandardsHeader, buildModeSelectedStandardsHeader, buildModeStandardsHeader, create_Item_Edit_Base_Standard, build_Question_Group_Hover, build_Standard_First_Grade;
    private String build_Standard_Grade_Clear, build_Standard_Grade_Level, build_Standard_First_Subject, build_Info_Icon, build_Standard_Subject_Clear, build_Standards_MyStandards, build_Standard_Providers, build_Standard_Clear;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Standards", "");
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

    public String getBuild_Info_Icon() {
        build_Info_Icon = properties.getProperty("BUILD_INFO_ICON");
        return build_Info_Icon;
    }

    public String getBuild_Standards_MyStandards() {
        build_Standards_MyStandards = properties.getProperty("BUILD_STANDARDS_MYSTANDARDS");
        return build_Standards_MyStandards;
    }

    public String getBuild_Standard_Providers() {
        build_Standard_Providers = properties.getProperty("BUILD_STANDARDS_PROVIDERS");
        return build_Standard_Providers;
    }

    public String getBuild_Standard_Clear() {
        build_Standard_Clear = properties.getProperty("BUILD_STANDARDS_CLEAR");
        return build_Standard_Clear;
    }

    public String getBuild_Common_Core_Standard() {
        build_Common_Core_Standard = properties.getProperty("BUILD_COMMON_CORE_STANDARD");
        return build_Common_Core_Standard;
    }

    public String getBuild_Standard_Subject() {
        build_Standard_Subject = properties.getProperty("BUILD_STANDARDS_SUBJECT");
        return build_Standard_Subject;
    }

    public String getBuild_Standard_Subject_Clear() {
        build_Standard_Subject_Clear = properties.getProperty("BUILD_STANDARDS_SUBJECT_CLEAR");
        return build_Standard_Subject_Clear;
    }

    public String getBuild_Standard_First_Subject() {
        build_Standard_First_Subject = properties.getProperty("BUILD_STANDARDS_FIRST_SUBJECT");
        return build_Standard_First_Subject;
    }

    public String getBuild_Standard_Grade_Level() {
        build_Standard_Grade_Level = properties.getProperty("BUILD_STANDARDS_GRADELEVEL");
        return build_Standard_Grade_Level;
    }

    public String getBuild_Standard_Grade_Clear() {
        build_Standard_Grade_Clear = properties.getProperty("BUILD_STANDARDS_GRADE_CLEAR");
        return build_Standard_Grade_Clear;
    }

    public String getBuild_Standard_First_Grade() {
        build_Standard_First_Grade = properties.getProperty("BUILD_STANDARDS_FIRST_GRADE");
        return build_Standard_First_Grade;
    }

    public String getBuild_Question_Group_Hover() {
        build_Question_Group_Hover = properties.getProperty("BUILD_QUESTION_GROUP_HOVER");
        return build_Question_Group_Hover;
    }

    public String getCreate_Item_Edit_Base_Standard() {
        create_Item_Edit_Base_Standard = properties.getProperty("BUILD_CREATE_ITEM_EDIT_BASE_STANDARD");
        return create_Item_Edit_Base_Standard;
    }

    public String getBuild_Mode_Add_More() {
        build_Mode_Add_More = properties.getProperty("BUILD_ADD_MORE");
        return build_Mode_Add_More;
    }

    public String getBuild_Mode_Selected_Standard() {
        build_Mode_Selected_Standard = properties.getProperty("BUILD_SELECTED_STANDARD");
        return build_Mode_Selected_Standard;
    }

    public String getBuild_Mode_Standard_Modal_Done() {
        build_Mode_Standard_Modal_Done = properties.getProperty("BUILD_STANDARD_MODAL_DONE");
        return build_Mode_Standard_Modal_Done;
    }

    public String getBuild_Mode_Standard_Text_Box() {
        build_Mode_Standard_Text_Box = properties.getProperty("BUILD_STANDARD_TEXT_BOX");
        return build_Mode_Standard_Text_Box;
    }

    public String getBuild_Mode_Add_Item() {
        build_Mode_Add_Item = properties.getProperty("BUILD_ADD_FIRST_ITEM");
        return build_Mode_Add_Item;
    }

    public String getBuild_Mode_Page_Header() {
        build_Mode_Page_Header = properties.getProperty("BUILD_PAGE_HEADER");
        return build_Mode_Page_Header;
    }

    public String getBuild_Mode_Standard_Plus() {
        build_Mode_Standard_Plus = properties.getProperty("BUILD_STANDARD_PLUS");
        return build_Mode_Standard_Plus;
    }

    public String getBuild_Mode_Edit_Icon() {
        build_Mode_Edit_Icon = properties.getProperty("BUILD_EDIT_ICON");
        return build_Mode_Edit_Icon;
    }

    public String getBuild_Mode_Standard_Modal_Header() {
        build_Mode_Standard_Modal_Header = properties.getProperty("BUILD_STANDARD_MODAL_HEADER");
        return build_Mode_Standard_Modal_Header;
    }

    public String getBuild_Mode_Browse_Button() {
        build_Mode_Browse_Button = properties.getProperty("BUILD_BROWSE_BUTTON");
        return build_Mode_Browse_Button;
    }

    public String getBuild_Mode_Icon_Hover() {
        build_Mode_Icon_Hover = properties.getProperty("BUILD_ICON_HOVER");
        return build_Mode_Icon_Hover;
    }

    public String getBuild_Mode_Build_Button() {
        build_Mode_Build_Button = properties.getProperty("BUILD_BUILD_BUTTON");
        return build_Mode_Build_Button;
    }

    public String getBuild_Mode_Standard_Chip() {
        build_Mode_Standard_Chip = properties.getProperty("BUILD_STANDARD_CHIP");
        return build_Mode_Standard_Chip;
    }

    public String getBuild_Mode_Show_More() {
        build_Mode_Show_More = properties.getProperty("BUILD_SHOW_MORE_LINK");
        return build_Mode_Show_More;
    }

    public String getBuild_Mode_Standard_List() {
        build_Mode_Standard_List = properties.getProperty("BUILD_STANDARDS_LIST");
        return build_Mode_Standard_List;
    }

    public String getBuild_Mode_Standard_Modal_List() {
        build_Mode_Standard_Modal_List = properties.getProperty("BUILD_STANDARD_MODAL_LIST");
        return build_Mode_Standard_Modal_List;
    }

    public String getBuild_Mode_Standard_Modal_Close() {
        build_Mode_Standard_Modal_Close = properties.getProperty("BUILD_STANDARD_MODAL_CLOSE");
        return build_Mode_Standard_Modal_Close;
    }

    public String getBuild_Mode_Create_Item_Close() {
        build_Mode_Create_Item_Close = properties.getProperty("BUILD_CREATE_ITEM_CLOSE");
        return build_Mode_Create_Item_Close;
    }

    public String getBuild_Mode_Base_Standard_List() {
        build_Mode_Base_Standard_List = properties.getProperty("BUILD_BASE_STANDARD_LIST");
        return build_Mode_Base_Standard_List;
    }

    public String getBuild_Mode_Back_Chevron_Button() {
        build_Mode_Back_Chevron_Button = properties.getProperty("BUILD_BACK_CHEVRON_BUTTON");
        return build_Mode_Back_Chevron_Button;
    }

    public String getBuild_Mode_Green_Tick() {
        build_Mode_Green_Tick = properties.getProperty("BUILD_GREEN_TICK");
        return build_Mode_Green_Tick;
    }

    public String getBuild_Mode_Aligned_Standard() {
        build_Mode_Aligned_Standard = properties.getProperty("BUILD_ALIGNED_STANDARD");
        return build_Mode_Aligned_Standard;
    }

    public String getBuild_Mode_Standard_Hover() {
        build_Mode_Standard_Hover = properties.getProperty("BUILD_STANDARD_HOVER");
        return build_Mode_Standard_Hover;
    }

    public String getBuild_Mode_Base_Standard_Select() {
        build_Mode_Base_Standard_Select = properties.getProperty("BUILD_BASE_STANDARD_SELECT");
        return build_Mode_Base_Standard_Select;
    }

    public String getBuild_Mode_New_Aligned_Standard() {
        build_Mode_New_Aligned_Standard = properties.getProperty("BUILD_NEW_ALIGNED_STANDARD");
        return build_Mode_New_Aligned_Standard;
    }

    public String getBuildModeFirstStandardsInModal() {
        buildModeFirstStandardsInModal = properties.getProperty("BUILD_FIRST_STANDARD_IN_MODAL");
        return buildModeFirstStandardsInModal;
    }

    public String getBuildModeStandardsHeader() {
        buildModeStandardsHeader = properties.getProperty("BUILD_STANDARDS_HEADER");
        return buildModeStandardsHeader;
    }

    public String getBuildModeBaseStandardsHeader() {
        buildModeBaseStandardsHeader = properties.getProperty("BUILD_BASE_STANDARD_HEADER");
        return buildModeBaseStandardsHeader;
    }

    public String getBuildModeSelectedStandardsHeader() {
        buildModeSelectedStandardsHeader = properties.getProperty("BUILD_SELECTED_STANDARDS_HEADER");
        return buildModeSelectedStandardsHeader;
    }

    public String getAlign_Standards_Icon() {
        align_Standards_Icon = properties.getProperty("BUILD_ALIGN_STANDARDS_ICON");
        return align_Standards_Icon;
    }

    public String getBuildModeStandardsSaved() {
        buildModeStandardsSaved = properties.getProperty("BUILD_STANDARDS_SAVED");
        return buildModeStandardsSaved;
    }
}
