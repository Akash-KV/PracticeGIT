package Controllers;
//import Controllers.LoginController;
import Helpers.BrowserInitHelper;
import Helpers.JavascriptHelper;
import Pom.*;
import Utils.Config;
import Utils.ConsoleLogger;
import com.csvreader.CsvReader;
import com.opencsv.CSVReader;
import com.opencsv.CSVReader.*;
import com.opencsv.CSVWriter;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Helpers.DriverHelper;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class CSVDataWriterScoringEvent {
    public static int rowIncrementer = 1;
    static String path = null;
    public static String getRevID() {
        String id = "";
        StringBuilder sbuilder = new StringBuilder();
        int count = 6;
        //Fetch Id from UI application
        int itemid = 33333;
        //Make a string with Pipeline
        for (int i = 0; i < count; i++) {
            sbuilder.append(itemid + i);
            if (i < count - 1) {
                sbuilder.append("|");
            }
        }
        id = sbuilder.toString();
        return id;
    }
    public static void WriteCSV(String Header, String ID) throws IOException {
        try {
            System.out.println("Header: "+Header);
            path = System.getProperty("user.dir");
            path = path + "/src/main/resources/ScoringEventData.csv";
            // Read existing file
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> csvBody = csvReader.readAll();
            // get CSV row column and replace with by using row and column
            for (int i = 0; i < csvBody.size()-1; i++) {
                System.out.println(csvBody.size());
                String[] strArray = csvBody.get(i);
                for (int j = 0; j < strArray.length; j++) {
                    System.out.println(strArray.length+"strength+>>>");
                    if (strArray[j].equalsIgnoreCase(Header)) { //String to be replaced
                        //String toAdd = getRevID();
                        System.out.println("ID: "+ID);
                        csvBody.get(i + rowIncrementer)[j] = ID; //Target replacement
                        //csvBody.get(i + 1)[j] = "22222|22222|22222"; //Target replacement
                        break;
                    }
                }
            }
            reader.close();
            // Write to CSV file which is open
            Writer writer = Files.newBufferedWriter(Paths.get(path));
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            csvWriter.writeAll(csvBody);
            csvWriter.flush();
            csvWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}