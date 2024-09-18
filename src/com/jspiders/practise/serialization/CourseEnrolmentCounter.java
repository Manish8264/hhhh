package com.jspiders.practise.serialization;

import java.io.*;
import java.util.*;

public class CourseEnrolmentCounter {
    public static void main(String[] args) {
        // Store course_id and user_id pairs in a set to eliminate duplicates
        Set<String> enrolments = new HashSet<>();
        
        try {
            // Read the enrolments.csv file
            BufferedReader reader = new BufferedReader(new FileReader("C:\\File\\TEST\\enrolments.csv"));
            String line;
            
            // Skip the header line
            reader.readLine();
            
            // Read each line and add course_id and user_id pair to the set
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String courseId = data[0];
                String userId = data[1];
                enrolments.add(courseId + "-" + userId);
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Count the number of unique students for each course
        Map<String, Integer> courseEnrolmentCounts = new HashMap<>();
        for (String enrolment : enrolments) {
            String courseId = enrolment.split("-")[0];
            courseEnrolmentCounts.put(courseId, courseEnrolmentCounts.getOrDefault(courseId, 0) + 1);
        }
        
        // Output the number of students taking each course
        System.out.println("Number of students taking each course:");
        for (Map.Entry<String, Integer> entry : courseEnrolmentCounts.entrySet()) {
            System.out.println("Course ID: " + entry.getKey() + ", Number of students: " + entry.getValue());
        }
    }
}
