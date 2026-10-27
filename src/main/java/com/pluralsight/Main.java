package com.pluralsight;

import java.io.*;
import java.util.regex.*;

public class Main {
    static FileReader fileReader;
    static Employee[] employees = {new Employee(), new Employee(), new Employee(),
            new Employee(), new Employee(), new Employee(), new Employee(),
            new Employee()};

    public static void read() {
        try {
            fileReader = new FileReader("employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String line;
            boolean isFull = true;

            for (Employee employee: employees) {

                if (!employee.isEmployeeExist()) {

                    while ((line = bufReader.readLine()) != null) {
                        isFull = false;
                        System.out.println(line);
                        String[] textSheet = line.split(Pattern.quote("|"));

                        for (String text : textSheet) {System.out.println(text);}
                        if (line.equals("id|name|hours-worked|pay-rate")) {continue;}

                        int id = Integer.parseInt(textSheet[0]);
                        String name = textSheet[1];
                        double hoursWorked = Double.parseDouble(textSheet[2]);
                        double payRate = Double.parseDouble(textSheet[2]);

                        employee.setEmployeeExist(true);
                        employee.setEmployeeId(id);
                        employee.setName(name);
                        employee.setHoursWorked(hoursWorked);
                        employee.setPayRate(payRate);
                    }
                }
            }
            for (Employee employee: employees) {
                if (!employee.isEmployeeExist()) {System.out.println(employee);}
            }
            if (isFull) {System.out.print("register is full");}
            bufReader.close();
        }
        catch(IOException e) {
            System.out.print("java.io.FileNotFoundException: employes.csv (No such file or directory)\n");
        }
    }

    public static void main(String[] args) {
        read();
        printEmployeeCard();
        printEmployeeRow();
    }

    private static void printEmployeeRow() {

    }

    private static void printEmployeeCard() {

    }
}