package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PayRollCalculatorApp {
    public static void main(String[] args) {

        //  Scanner scanner = new Scanner(System.in);

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // read a line into line, then check it isn't null, all in one step
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("there was an error reading the file.");
        }

    }
}
