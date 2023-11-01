package com.gb.java.hw.hw4.v2;

public class Employee {

    private int employeeId;
    private String phoneNumber;
    private String name;
    private int exp;

    public Employee(int employeeId, String phoneNumber, String name, int exp){
        this.employeeId = employeeId;
        this.exp = exp;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getExp() {
        return exp;
    }
}
