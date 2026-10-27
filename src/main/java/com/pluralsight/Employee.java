package com.pluralsight;

public class Employee {

    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;
    private boolean employeeExist = false;

    public Employee() {
    }
    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
        this.employeeExist=true;
    }

    public int getEmployeeId() {return employeeId;}

    public void setEmployeeId(int employeeId) {this.employeeId = employeeId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getHoursWorked() {return hoursWorked;}

    public void setHoursWorked(double hoursWorked) {this.hoursWorked = hoursWorked;}

    public double getPayRate() {return payRate;}

    public boolean isEmployeeExist() {return employeeExist;}

    public void setEmployeeExist(boolean employeeExist) {this.employeeExist = employeeExist;}

    public void setPayRate(double payRate) {this.payRate = payRate;}

    public double getGrossPay(double payRate, double hoursWorked){return payRate*hoursWorked;}

    public String toRow() {
        return getEmployeeId()+"|"+getName()+"|"+getHoursWorked()+"|"+getPayRate();}

    public String toCard() {return "";}
}
