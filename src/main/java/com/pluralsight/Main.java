package com.pluralsight;

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class Main {
    static FileReader fileReader;
    static List<Employee> employeesList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void write() {
        try {
            FileWriter writer = new FileWriter("payroll-sept-2023.csv");
            writer.write("id|name|GrossPay\n");
            for (Employee employee: employeesList) {
                writer.write(employee.toRow()+"\n");
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
            while ((line = bufReader.readLine()) != null) {
                Employee employee = new Employee();
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
        String answer = "false";
        while (answer.equals("false")) {
            System.out.print("do you wish to write this (Y/N): ");
            answer = scanner.nextLine().toLowerCase();
            if (answer.equals("y") || answer.equals("n")){
                if (answer.equals("y")) {
                    System.out.println("writing file");
                    write();
                }
            } else {
                System.out.println("Error invalid input");
                answer = "false";
            }
        }
        scanner.close();
    }

    private static void printEmployeeRow() {
        for (Employee employee: employeesList){
            System.out.printf("%n" + employee.toRow());
        }
    }

    private static void printEmployeeCard() {
        for (Employee employee: employeesList){
            System.out.printf(employee.toCard());
        }
    }
}