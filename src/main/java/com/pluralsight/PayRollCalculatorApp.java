package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PayRollCalculatorApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee file name: ");
        String inputFile = scanner.nextLine();

        System.out.println("Enter payroll file name: ");
        String outputFile = scanner.nextLine();


        List<Employee> employees = loadEmployees(inputFile, outputFile);
        System.out.println("Payroll file created: " + outputFile);

        printEmployeeTable(employees);
        printEmployeeRow(employees);

    }

    private static List<Employee> loadEmployees(String inputFile, String outputFile) {
        List<Employee> employees = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;

            String headerLine = bufferedReader.readLine(); // ignore header



            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

                String[] fields = line.split(Pattern.quote ("|"));

                int employeeId = Integer.parseInt(fields[0]);
                String name = (fields[1]);
                double  hoursWorked = Double.parseDouble(fields[2]);
                double payRate = Double.parseDouble(fields[3]);

                Employee employee = new Employee (employeeId, name, hoursWorked, payRate);
                employees.add(employee);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("there was an error reading the file.");
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

