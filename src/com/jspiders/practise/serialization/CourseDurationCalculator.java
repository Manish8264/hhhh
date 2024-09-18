package com.jspiders.practise.serialization;

import java.io.*;
import java.text.*;
import java.util.*;

public class CourseDurationCalculator {
    public static void main(String[] args) {
        try {
            // Read the courses.csv file
            BufferedReader reader = new BufferedReader(new FileReader("C:\\File\\TEST\\courses.csv"));
            String line;
            
            // Skip the header line
            reader.readLine();
            
            // Print the header for the output
            System.out.println("Course Code\tDuration (Days)");
            
            // Read each line and calculate the duration for each section
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String courseCode = data[2];
                String startDateStr = data[3];
                String endDateStr = data[4];
                
                // Parse start date and end date
                Date startDate = parseDate(startDateStr);
                Date endDate = parseDate(endDateStr);
                
                // Calculate duration in days if parsing successful
                if (startDate != null && endDate != null) {
                    long durationInMilliseconds = endDate.getTime() - startDate.getTime();
                    long durationInDays = durationInMilliseconds / (1000 * 60 * 60 * 24);
                    
                    // Print course code and duration
                    System.out.println(courseCode + "\t\t" + durationInDays);
                } else {
                    System.out.println(courseCode + "\t\t" + "Invalid date format");
                }
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Method to parse date with multiple formats
    private static Date parseDate(String dateStr) {
        SimpleDateFormat[] dateFormats = {
            new SimpleDateFormat("MM-dd-yyyy"),
            new SimpleDateFormat("MMM/dd/yyyy"),
            new SimpleDateFormat("MMM-dd-yyyy"),
            new SimpleDateFormat("MM/dd/yyyy"),
            new SimpleDateFormat("# MM/dd/yyyy #"),
            new SimpleDateFormat("# MM-dd-yyyy #")
        };
        
        for (SimpleDateFormat dateFormat : dateFormats) {
            try {
                return dateFormat.parse(dateStr);
            } catch (ParseException e) {
                // Try next format if parsing fails
            }
        }
        
        // Return null if none of the formats match
        return null;
    }
}
