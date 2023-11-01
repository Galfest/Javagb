package com.gb.java.hw.hw4.v2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        Employee employee1 = new Employee(123,"111-1111","Georgiy", 5);
        Employee employee2 = new Employee(321,"121-3222","Anastasia", 6);
        directory.addEmployee(employee1);
        directory.addEmployee(employee2);

        //Searching an employee.
        List<Employee> employeesWithExp5 = directory.searchByExp(5);
        System.out.println("Employees with exp. of 5 years: ");
        for (Employee employee : employeesWithExp5){
            System.out.printf("Id is %d\n", employee.getEmployeeId());
            System.out.printf("Name: " + employee.getName());
        }
    }
}
