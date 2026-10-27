package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;

public class PayRollCalculatorApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Array to store input and output file names
        String[] fileNames = new String[2];

        System.out.println("===== PAYROLL CALCULATOR =====");

        // Ask user for the employee file
        System.out.println("Enter employee file name: ");
        fileNames[0] = scanner.nextLine();

        // Ask user for the payroll file
        System.out.println("Enter payroll file name: ");
        fileNames[1] = scanner.nextLine();

        // Load employee information from the file
        List<Employee> employees = loadEmployees(fileNames);

        // Display employee information in different formats
        printEmployeeTable(employees);
        printEmployeeRow(employees);

    }

    private static List<Employee> loadEmployees(String[] fileNames) {
        List<Employee> employees = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileNames[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Create the payroll file for writing
            FileWriter fileWriter = new FileWriter(fileNames[1]);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the header for the payroll file
            bufferedWriter.write("id|name|gross pay\n");

            String line;

            // Read each employee until the end of the file
            while ((line = bufferedReader.readLine()) != null) {

                // Separate employee information using the pipe
                String[] fields = line.split(Pattern.quote ("|"));

                // Convert employee information into correct data types
                int employeeId = Integer.parseInt(fields[0]);
                String name = (fields[1]);
                double  hoursWorked = Double.parseDouble(fields[2]);
                double payRate = Double.parseDouble(fields[3]);

                // Create an employee object and add it to the list
                Employee employee = new Employee (employeeId, name, hoursWorked, payRate);
                employees.add(employee);

                // Write the employee's gross pay to the payroll file
                bufferedWriter.write(employee.toPayrollCSV());

            }

            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("payroll file created: " + fileNames[1]);


        } catch (IOException e) {
            System.out.println("there was an error reading or writing the file.");
        }
        return employees;
    }

    private static void printEmployeeRow(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toCard());
        }
    }

    private static void printEmployeeTable(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toRow());
        }
    }

}

