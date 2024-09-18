package com.jspiders.practise.serialization;


//self
import java.io.*;
import java.text.*;
import java.util.*;

public class CSVDateFormatter {
    public static void main(String[] args)  {
        try {
            // Read the courses.csv file
            BufferedReader reader = new BufferedReader(new FileReader("C:\\File\\TEST\\courses.csv"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\File\\TEST\\coursesFixed.csv"));
            String line;
            
            // Skip the header line
            writer.write(reader.readLine() + "\n");
            
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String startDate=null;
				try {
					startDate = formatDate(data[3]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Assuming start date is at index 3
                String endDate=null;
				try {
					endDate = formatDate(data[4]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   // Assuming end date is at index 4
                // Write the updated data to the new file
                writer.write(data[0] + "," + data[1] + "," + data[2] + "," + startDate + "," + endDate + "," + data[5] + "\n");
            }
            
            reader.close();
            writer.close();
            
            System.out.println("Dates formatted and saved to coursesFixed.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to format date from various formats to "yyyy-MM-dd"
    private static String formatDate(String dateStr) throws ParseException {
        DateFormat[] dateFormats = {
            new SimpleDateFormat("MMM/dd/yyyy", Locale.ENGLISH),
            new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH),
            new SimpleDateFormat("MM/dd/yyyy"),
            new SimpleDateFormat("MM-dd-yyyy"),
            new SimpleDateFormat("# MM/dd/yyyy #"),
            new SimpleDateFormat("# MM-dd-yyyy #")
        };
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        for (DateFormat inputFormat : dateFormats) {
            try {
                Date date = inputFormat.parse(dateStr);
                return outputFormat.format(date);
            } catch (ParseException e) {
                // If parsing with current format fails, try the next one
            }
        }
        
        // If none of the formats match, throw ParseException
        throw new ParseException("Unparseable date: " + dateStr, 0);
    }
}

