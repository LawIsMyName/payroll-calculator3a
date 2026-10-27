package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PayRollCalculatorApp {
    public static void main(String[] args) {

        //  Scanner scanner = new Scanner(System.in);

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

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
                System.out.println(employee);


            }
        } catch (IOException e) {
            System.out.println("there was an error reading the file.");
        }



    }
}
