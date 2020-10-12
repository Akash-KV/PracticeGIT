package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**** CSV Reader for BrowseMode - Question Groups*****/
public class CSVDataReaderBuildModeQuestionGroups {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/BuildModeQuestionGroups.csv";
    private String assessmentName, new_Question_Group, passage_MetaData, itemID;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                assessmentName = readercsv.get("assessment");
                new_Question_Group = readercsv.get("newQuestionGroup");
                passage_MetaData = readercsv.get("passageMetadata");
                itemID = readercsv.get("ItemID");
                Maprecords.put("assessment", assessmentName);
                Maprecords.put("newQuestionGroup", new_Question_Group);
                Maprecords.put("passageMetadata", passage_MetaData);
                Maprecords.put("ItemID", itemID);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    /*
    Methods to Read the Data from CSV
    */
    public String getAssessment() {
        assessmentName = getCsv().get("assessment").trim();
        return assessmentName;
    }

    public String getNew_Question_Group() {
        new_Question_Group = getCsv().get("newQuestionGroup").trim();
        return new_Question_Group;
    }

    public String getPassage_MetaData() {
        new_Question_Group = getCsv().get("passageMetadata").trim();
        return new_Question_Group;
    }

    public String getItemID() {
        itemID = getCsv().get("ItemID").trim();
        return itemID;
    }
}
