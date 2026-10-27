package com.pluralsight;

public class Employee {

    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double calculateGrossPay() {
        return hoursWorked * payRate;
    }

    public String toRow() {
        return String.format(
                "+------+----------------------+------------+----------+%n" +
                        "| %-4d | %-20s | %10.2f | $%7.2f |%n" +
                        "+------+----------------------+------------+----------+",
                employeeId, name, hoursWorked, payRate);
    }

    public String toCard() {
        return String.format(
                "+--------------------------------+%n" +
                        "|        EMPLOYEE DETAILS        |%n" +
                        "+--------------------------------+%n" +
                        "| Employee ID:   %-15d |%n" +
                        "| Name:          %-15s |%n" +
                        "| Hours Worked:  %-15.2f |%n" +
                        "| Pay Rate:      $%-14.2f |%n" +
                        "+--------------------------------+",
                employeeId, name, hoursWorked, payRate);
    }

    public String toCSV() {
        return String.format("%d|%s|%s|%.2f",
                employeeId, name, hoursWorked, payRate);
    }

    public String toPayrollCSV() {
        return String.format("%d|%s|%.2f%n",
                employeeId, name, calculateGrossPay());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", payRate=" + payRate +
                '}';
    }
}



