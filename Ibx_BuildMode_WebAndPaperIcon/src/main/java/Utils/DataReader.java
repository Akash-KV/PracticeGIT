package Utils;

import com.csvreader.CsvReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utils class for DataReader
 **/
public class DataReader {
    private String val;
    private String assessment, ItemIdOnline, ItemOlineandPaper;

    public Map<String, String> getCsv() {
        Map<String, String> Maprecords = new HashMap<String, String>();
        String path = System.getProperty("user.dir");
        String CSVPath = path + "/src/main/resources/BuildModeWebAndPaper.csv";

        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                assessment = readercsv.get("assessment");
                ItemIdOnline = readercsv.get("ItemIdOnline");
                ItemOlineandPaper = readercsv.get("ItemOnlineandPaper");

                Maprecords.put("assessment", assessment);
                Maprecords.put("ItemIdOnline", ItemIdOnline);
                Maprecords.put("ItemOnlineandPaper", ItemOlineandPaper);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    /*Methods to get the Data From CSV*/
    public String getAssessment() {
        assessment = getCsv().get("assessment");
        return assessment;
    }

    public String getItemIdOnline() {
        ItemIdOnline = getCsv().get("ItemIdOnline");
        return ItemIdOnline;
    }

    public String getItemOnlineAndPaper() {
        ItemOlineandPaper = getCsv().get("ItemOnlineandPaper");
        return ItemOlineandPaper;
    }
}