package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**** CSV Reader for BrowseMode - Create Assessment Button *****/
public class CSVDataReaderBuildSingleItemPassageRemove {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/BuildModeSingleItemPassageRemove.csv";
    private String assessmentName;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                assessmentName = readercsv.get("assessment");

                Maprecords.put("assessment", assessmentName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    //Method to read test data from CSV
    public String getassessment() {
        assessmentName = getCsv().get("assessment").trim();
        return assessmentName;
    }
}
