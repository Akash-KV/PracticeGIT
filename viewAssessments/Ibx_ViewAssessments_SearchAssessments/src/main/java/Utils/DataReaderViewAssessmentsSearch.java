package Utils;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Utils class for DataReader ViewAssessmentsSearch
public class DataReaderViewAssessmentsSearch {

    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/ViewAssessmentsSearch.csv";


    private String validTitle, invalidTitle, specialCharecters, alphanewmeric, year, charactersSequencecount, substringtitlenamesearch;

    private String owner, localIdentifier, searchUsingTABKey, unPublishedItemBankAssessment;

    public Map<String, String> getCsv() {
        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {

                validTitle = readercsv.get("ValidTitle");
                invalidTitle = readercsv.get("InvalidTitle");
                specialCharecters = readercsv.get("SpecialCharecters");
                alphanewmeric = readercsv.get("Alphanewmeric");
                year = readercsv.get("Year");
                charactersSequencecount = readercsv.get("charactersSequencecount");
                substringtitlenamesearch = readercsv.get("Substringtitlenamesearch");
                localIdentifier = readercsv.get("LocalIdentifier");
                owner = readercsv.get("Owner");
                searchUsingTABKey = readercsv.get("SearchUsingTABKey");
                unPublishedItemBankAssessment = readercsv.get("UnPublishedItemBankAssessment");


                Maprecords.put("ValidTitle", validTitle);
                Maprecords.put("InvalidTitle", invalidTitle);
                Maprecords.put("SpecialCharecters", specialCharecters);
                Maprecords.put("Alphanewmeric", alphanewmeric);
                Maprecords.put("Year", year);
                Maprecords.put("charactersSequencecount", charactersSequencecount);

                Maprecords.put("Substringtitlenamesearch", substringtitlenamesearch);
                Maprecords.put("LocalIdentifier", localIdentifier);
                Maprecords.put("Owner", owner);
                Maprecords.put("SearchUsingTABKey", searchUsingTABKey);
                Maprecords.put("UnPublishedItemBankAssessment", unPublishedItemBankAssessment);


            }
            readercsv.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    /*
    Method to read the data from CSV files
    */
    public String getValidTitle() {
        validTitle = getCsv().get("ValidTitle");
        return validTitle;
    }

    public String getInvalidTitle() {
        invalidTitle = getCsv().get("InvalidTitle");
        return invalidTitle;
    }

    public String getSpecialCharecters() {
        specialCharecters = getCsv().get("SpecialCharecters");
        return specialCharecters;
    }

    public String getAlphanewmeric() {
        alphanewmeric = getCsv().get("Alphanewmeric");
        return alphanewmeric;
    }


    public String getYear() {
        year = getCsv().get("Year");
        return year;
    }

    public String getcharactersSequencecount() {
        charactersSequencecount = getCsv().get("charactersSequencecount");
        return charactersSequencecount;
    }

    public String getSubstringtitlenamesearch() {
        substringtitlenamesearch = getCsv().get("Substringtitlenamesearch");
        return substringtitlenamesearch;
    }

    public String getLocalIdentifier() {
        localIdentifier = getCsv().get("LocalIdentifier");
        return localIdentifier;
    }

    public String getOwner() {
        owner = getCsv().get("Owner");
        return owner;
    }

    public String getSearchUsingTABKey() {
        searchUsingTABKey = getCsv().get("SearchUsingTABKey");
        return searchUsingTABKey;
    }

    public String getUnPublishedItemBankAssessment() {
        unPublishedItemBankAssessment = getCsv().get("UnPublishedItemBankAssessment");
        return unPublishedItemBankAssessment;
    }
}
