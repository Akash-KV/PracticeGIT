package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**** CSV Reader for Build Mode - Weight *****/
public class CSVDataReaderBuildItemWeight {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/BuildModeWeight.csv";
    private String assessmentName, alphabetValue;
    private String specialcharacterValue;
    private String plusSymbolValue;
    private String lessThanZeroValue;
    private String morethanHundredValue;
    private String decimalValueOne;
    private String decimalValueTwo;
    private String decimalValueThree;
    private String decimalValueFour;
    private String decimalValueFive;
    private String decimalValueSix;
    private String decimalValueSeven;
    private String decimalValueEight;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                assessmentName = readercsv.get("assessment");
                alphabetValue = readercsv.get("AlphabetValue");
                specialcharacterValue = readercsv.get("SpecialcharacterValue");
                plusSymbolValue = readercsv.get("PlusSymbolValue");
                lessThanZeroValue = readercsv.get("LessThanZeroValue");
                morethanHundredValue = readercsv.get("MorethanHundredValue");
                decimalValueOne = readercsv.get("DecimalValueOne");
                decimalValueTwo = readercsv.get("DecimalValueTwo");
                decimalValueThree = readercsv.get("DecimalValueThree");
                decimalValueFour = readercsv.get("DecimalValueFour");
                decimalValueFive = readercsv.get("DecimalValueFive");
                decimalValueSix = readercsv.get("DecimalValueSix");
                decimalValueSeven = readercsv.get("DecimalValueSeven");
                decimalValueEight = readercsv.get("DecimalValueEight");


                Maprecords.put("assessment", assessmentName);
                Maprecords.put("AlphabetValue", alphabetValue);
                Maprecords.put("SpecialcharacterValue", specialcharacterValue);
                Maprecords.put("PlusSymbolValue", plusSymbolValue);
                Maprecords.put("LessThanZeroValue", lessThanZeroValue);
                Maprecords.put("MorethanHundredValue", morethanHundredValue);
                Maprecords.put("DecimalValueOne", decimalValueOne);
                Maprecords.put("DecimalValueTwo", decimalValueTwo);
                Maprecords.put("DecimalValueThree", decimalValueThree);
                Maprecords.put("DecimalValueFour", decimalValueFour);
                Maprecords.put("DecimalValueFive", decimalValueFive);
                Maprecords.put("DecimalValueSix", decimalValueSix);
                Maprecords.put("DecimalValueSeven", decimalValueSeven);
                Maprecords.put("DecimalValueEight", decimalValueEight);


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

    public String getAlphabetValue() {
        alphabetValue = getCsv().get("AlphabetValue").trim();
        return alphabetValue;
    }

    public String getSpecialcharacterValue() {
        specialcharacterValue = getCsv().get("SpecialcharacterValue").trim();
        return specialcharacterValue;
    }

    public String getPlusSymbolValue() {
        plusSymbolValue = getCsv().get("PlusSymbolValue").trim();
        return plusSymbolValue;
    }

    public String getLessThanZeroValue() {
        lessThanZeroValue = getCsv().get("LessThanZeroValue").trim();
        return lessThanZeroValue;
    }

    public String getMorethanHundredValue() {
        morethanHundredValue = getCsv().get("MorethanHundredValue").trim();
        return morethanHundredValue;
    }

    public String getDecimalValueOne() {
        decimalValueOne = getCsv().get("DecimalValueOne").trim();
        return decimalValueOne;
    }

    public String getDecimalValueTwo() {
        decimalValueTwo = getCsv().get("DecimalValueTwo").trim();
        return decimalValueTwo;
    }

    public String getDecimalValueThree() {
        decimalValueThree = getCsv().get("DecimalValueThree").trim();
        return decimalValueThree;
    }

    public String getDecimalValueFour() {
        decimalValueFour = getCsv().get("DecimalValueFour").trim();
        return decimalValueFour;
    }

    public String getDecimalValueFive() {
        decimalValueFive = getCsv().get("DecimalValueFive").trim();
        return decimalValueFive;
    }

    public String getDecimalValueSix() {
        decimalValueSix = getCsv().get("DecimalValueSix").trim();
        return decimalValueSix;
    }

    public String getDecimalValueSeven() {
        decimalValueSeven = getCsv().get("DecimalValueSeven").trim();
        return decimalValueSeven;
    }

    public String getDecimalValueEight() {
        decimalValueEight = getCsv().get("DecimalValueEight").trim();
        return decimalValueEight;
    }


}
