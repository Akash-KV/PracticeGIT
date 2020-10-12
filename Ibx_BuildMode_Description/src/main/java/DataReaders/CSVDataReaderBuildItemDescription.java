package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**
 * CSV Reader for Build mode Description
 **/
public class CSVDataReaderBuildItemDescription {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/BuildModeAddDescription.csv";
    private String assessmentName, LessThanTwoHundredFiftyFiveCountString, alphaNumeric, moreThanTwoHundredFiftyFiveCountString;
    private String twoHundredFiftyFiveCountString, specialCharactersString, validStringForNavigationSave;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                assessmentName = readercsv.get("assessment");
                LessThanTwoHundredFiftyFiveCountString = readercsv.get("LessThanTwoHundredFivtyFiveCountString");
                alphaNumeric = readercsv.get("AlphaNewmric");
                moreThanTwoHundredFiftyFiveCountString = readercsv.get("MorethanTwoHundredFivtyFiveCountString");
                twoHundredFiftyFiveCountString = readercsv.get("TwoHundredFivtyFiveCountString");
                specialCharactersString = readercsv.get("SpecialcharactersString");
                validStringForNavigationSave = readercsv.get("ValidStringforNavigationSave");

                Maprecords.put("assessment", assessmentName);
                Maprecords.put("LessThanTwoHundredFivtyFiveCountString", LessThanTwoHundredFiftyFiveCountString);
                Maprecords.put("AlphaNewmric", alphaNumeric);
                Maprecords.put("MorethanTwoHundredFivtyFiveCountString", moreThanTwoHundredFiftyFiveCountString);
                Maprecords.put("TwoHundredFivtyFiveCountString", twoHundredFiftyFiveCountString);
                Maprecords.put("SpecialcharactersString", specialCharactersString);
                Maprecords.put("ValidStringforNavigationSave", validStringForNavigationSave);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    /**
     * Methods to read CSV data
     **/
    public String getAssessment() {
        assessmentName = getCsv().get("assessment").trim();
        return assessmentName;
    }

    public String getLessThanTwoHundredFiftyFiveCount() {
        LessThanTwoHundredFiftyFiveCountString = getCsv().get("LessThanTwoHundredFivtyFiveCountString").trim();
        return LessThanTwoHundredFiftyFiveCountString;
    }

    public String getAlphanumeric() {
        alphaNumeric = getCsv().get("AlphaNewmric").trim();
        return alphaNumeric;
    }

    public String getMoreThanTwoHundredFiftyFiveCountString() {
        moreThanTwoHundredFiftyFiveCountString = getCsv().get("MorethanTwoHundredFivtyFiveCountString").trim();
        return moreThanTwoHundredFiftyFiveCountString;
    }

    public String getTwoHundredFiftyFiveCountString() {
        twoHundredFiftyFiveCountString = getCsv().get("TwoHundredFivtyFiveCountString").trim();
        return twoHundredFiftyFiveCountString;
    }

    public String getSpecialCharactersString() {
        specialCharactersString = getCsv().get("SpecialcharactersString").trim();
        return specialCharactersString;
    }

    public String getValidStringForNavigationSave() {
        validStringForNavigationSave = getCsv().get("ValidStringforNavigationSave").trim();
        return validStringForNavigationSave;
    }
}
