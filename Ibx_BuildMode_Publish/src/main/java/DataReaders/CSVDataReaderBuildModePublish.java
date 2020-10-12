package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**** CSV Reader for BrowseMode - Create Assessment Button *****/
public class CSVDataReaderBuildModePublish {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/BuildModePublish.csv";
    private String assessmentName, crItemID, msItemID, draftID;


    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                assessmentName = readercsv.get("assessment");
                crItemID = readercsv.get("CRItemID");
                msItemID = readercsv.get("MSItemID");
                draftID = readercsv.get("DraftID");
                Maprecords.put("assessment", assessmentName);
                Maprecords.put("CRItemID", crItemID);
                Maprecords.put("MSItemID", msItemID);
                Maprecords.put("DraftID", draftID);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    //Methods to read the Data from CSV
    public String getAssessment() {
        assessmentName = getCsv().get("assessment").trim();
        return assessmentName;
    }

    public String getCrItemID() {
        crItemID = getCsv().get("CRItemID").trim();
        return crItemID;
    }

    public String getMsItemID() {
        msItemID = getCsv().get("MSItemID").trim();
        return msItemID;
    }

    public String getDraftID() {
        draftID = getCsv().get("DraftID").trim();
        return draftID;
    }

}
