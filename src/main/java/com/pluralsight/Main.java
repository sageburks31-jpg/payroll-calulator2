package com.pluralsight;

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class Main {
    static FileReader fileReader;
    static List<Employee> employeesList = new ArrayList<>();

    public static void write() {
        try {
            FileWriter writer = new FileWriter("employees.csv");
            writer.write("id|name|hours-worked|pay-rate\n");
            for (Employee employee: employeesList) {
                writer.write(employee.toRow());
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
        }
    }

    public static void read() {
        try {
            fileReader = new FileReader("employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String line;
            Employee employee = new Employee();

            while ((line = bufReader.readLine()) != null) {
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
                employeesList.add(employee);
            }
            for (Employee employed: employeesList) {
                if (!employed.isEmployeeExist()) {System.out.println(employed);}
            }
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
        for (Employee employee: employeesList){
            System.out.println(employee.toRow());
        }
    }

    private static void printEmployeeCard() {
        for (Employee employee: employeesList){
            System.out.println(employee.toCard());
        }
    }
}