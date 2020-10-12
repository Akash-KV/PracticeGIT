package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**** CSV Reader for BrowseMode - Create Assessment Button *****/
public class CSVDataReaderBrowseModeCreateAssessmentModal {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/BuildModeCreateAssessmentModal.csv";
    private String assessmentName, assessmentAlphaNumericName;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                assessmentName = readercsv.get("assessment");
                assessmentAlphaNumericName = readercsv.get("assessmentAlphaNumeric");

                Maprecords.put("assessment", assessmentName);
                Maprecords.put("assessmentAlphaNumeric", assessmentAlphaNumericName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    public String getassessment() {
        assessmentName = getCsv().get("assessment").trim();
        return assessmentName;
    }

    public String getAssessmentAlphaNumericName() {
        assessmentAlphaNumericName = getCsv().get("assessmentAlphaNumeric").trim();
        return assessmentAlphaNumericName;
    }
}
