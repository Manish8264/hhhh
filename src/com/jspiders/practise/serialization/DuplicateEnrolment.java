package com.jspiders.practise.serialization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DuplicateEnrolment {
    public static void main(String[] args) {
        String enrolmentsFile = "C:\\File\\TEST\\enrolments.csv";
        String coursesFile = "C:\\\\File\\\\TEST\\\\courses.csv";
        String studentsFile = "C:\\\\File\\\\TEST\\\\students.csv";

        Map<Integer, String> courseIdToName = readCourseNames(coursesFile);
        Map<Integer, String> studentIdToName = readStudentNames(studentsFile);
        List<String> duplicates = findDuplicates(enrolmentsFile, courseIdToName, studentIdToName);

        // Sort the list alphabetically by course name
        Collections.sort(duplicates);

        // Print the sorted list
        System.out.println("Course Name\tStudent Name");
        for (String entry : duplicates) {
            System.out.println(entry);
        }
    }

    // Read course names from courses.csv
    private static Map<Integer, String> readCourseNames(String coursesFile) {
        Map<Integer, String> courseIdToName = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(coursesFile))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                courseIdToName.put(Integer.parseInt(data[0]), data[1]);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return courseIdToName;
    }

    // Read student names from students.csv
    private static Map<Integer, String> readStudentNames(String studentsFile) {
        Map<Integer, String> studentIdToName = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(studentsFile))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                studentIdToName.put(Integer.parseInt(data[0]), data[1]);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return studentIdToName;
    }

    // Find duplicate enrolments and return as a list of strings
    private static List<String> findDuplicates(String enrolmentsFile, Map<Integer, String> courseIdToName, Map<Integer, String> studentIdToName) {
        Set<String> duplicates = new HashSet<>();
        Set<String> seen = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(enrolmentsFile))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String courseId = data[0];
                String studentId = data[1];
                String courseName = courseIdToName.get(Integer.parseInt(courseId));
                String studentName = studentIdToName.get(Integer.parseInt(studentId));
                String entry = courseName + "\t" + studentName;
                if (!seen.add(entry)) {
                    duplicates.add(entry);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(duplicates);
    }
}