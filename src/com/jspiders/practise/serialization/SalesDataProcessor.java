
package com.jspiders.practise.serialization;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesDataProcessor {
    
    // Function to read CSV file and return list of lines
    public static List<String> readCSV(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
    
    // Function to write lines to CSV file
    public static void writeCSV(List<String> lines, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }

    // Function to find duplicates in salesDataA.csv in terms of order_id occurring in salesDataB.csv
    public static List<String> findDuplicates(List<String> salesDataA, List<String> salesDataB) {
        List<String> duplicates = new ArrayList<>();
        Map<String, Integer> orderCountMap = new HashMap<>();
        for (String line : salesDataB) {
            String[] parts = line.split(",");
            String orderId = parts[0]; // Assuming order_id is the first column
            orderCountMap.put(orderId, orderCountMap.getOrDefault(orderId, 0) + 1);
        }
        for (String line : salesDataA) {
            String[] parts = line.split(",");
            String orderId = parts[0]; // Assuming order_id is the first column
            if (orderCountMap.containsKey(orderId) && orderCountMap.get(orderId) > 1) {
                duplicates.add(line);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) throws IOException {
        // Read CSV files
        List<String> salesDataA = readCSV("C:\\File\\TEST\\salesDataA.csv");
        List<String> salesDataB = readCSV("C:\\File\\TEST\\salesDataB.csv");

        // Question 1: Find duplicates in salesDataA.csv in terms of order_id occurring in salesDataB.csv
        List<String> duplicates = findDuplicates(salesDataA, salesDataB);
        writeCSV(duplicates, "C:\\File\\TEST\\salesDataC.csv");

        // Question 2: Find lines that occur in salesDataB.csv for April 2019 and also occur in salesDataA.csv
        List<String> commonLinesApril = new ArrayList<>();
        for (String line : salesDataB) {
            String[] parts = line.split(",");
            String orderDate = parts[1]; // Assuming order_date is the second column
            if (orderDate.startsWith("4/2019")) {
                if (salesDataA.contains(line)) {
                    commonLinesApril.add(line);
                }
            }
        }
        // Print or manipulate commonLinesApril as needed
        for (String line : commonLinesApril) {
        	System.out.println("Question 2 solution:");
            System.out.println(line);
        }

        // Question 3: Find lines in salesDataA.csv where payment date is null in salesDataB.csv but the rest of the record is the same
        List<String> linesWithNullPayment = new ArrayList<>();
        for (String lineA : salesDataA) {
            String[] partsA = lineA.split(",");
            String orderIdA = partsA[0]; // Assuming order_id is the first column
            String orderDateA = partsA[1]; // Assuming order_date is the second column
            String orderValueA = partsA[3]; // Assuming order_value is the fourth column
            String itemNameA = partsA[4]; // Assuming item_name is the fifth column
            for (String lineB : salesDataB) {
                String[] partsB = lineB.split(",");
                String orderIdB = partsB[0]; // Assuming order_id is the first column
                String orderDateB = partsB[1]; // Assuming order_date is the second column
                String orderValueB = partsB[3]; // Assuming order_value is the fourth column
                String itemNameB = partsB[4]; // Assuming item_name is the fifth column
                if (orderIdA.equals(orderIdB) && orderDateA.equals(orderDateB) && orderValueA.equals(orderValueB) && itemNameA.equals(itemNameB)) {
                    if (partsB[2].isEmpty()) { // Assuming payment_date is the third column
                        linesWithNullPayment.add(lineA);
                    }
                }
            }
        }
        // Print or manipulate linesWithNullPayment as needed
        for (String line : linesWithNullPayment) {
        	System.out.println("Question 3 :");
            System.out.println(line);
        }
    }
}