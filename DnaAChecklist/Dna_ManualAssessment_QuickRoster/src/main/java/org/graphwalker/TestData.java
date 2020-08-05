package org.graphwalker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/*****TestData Class for Dna_ManualAssessment_QuickRoster*******/
public class TestData {

    private static HashMap<String, String> data = new HashMap<>();

    public static HashMap<String, String> loginData() {
        String dir = System.getProperty("user.dir");
        String csvFile = dir + "/src/main/resources/org/graphwalker/data.csv";
        String line = "";
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] pair = line.split(splitBy);
                data.put(pair[1], pair[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
