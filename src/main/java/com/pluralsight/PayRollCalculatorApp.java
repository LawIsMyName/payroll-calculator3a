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

            // read a line into line, then check it isn't null, all in one step
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

                System.out.println("____________________");

                String[] fields = line.split(Pattern.quote ("|"));

                System.out.println(fields[0]);
                System.out.println(fields[1]);
                System.out.println(fields[2]);
                System.out.println(fields[3]);
                System.out.println("______________________");

            }
        } catch (IOException e) {
            System.out.println("there was an error reading the file.");
        }



    }
}
