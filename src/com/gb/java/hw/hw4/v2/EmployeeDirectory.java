package com.gb.java.hw.hw4.v2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {

    private List<Employee> employees;

    public EmployeeDirectory(){
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public List<Employee> searchByExp(int exp){
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getExp() == exp){
                result.add(employee);
            }
        }
        return result;
    }

    public List<String> getPhoneNumber(String name){
        List<String> result = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getName().equals(name)){
                result.add(employee.getPhoneNumber());
            }
        }
        return result;
    }

    public Employee searchByEmployeeID(int employeeId){
        for (Employee employee : employees){
            if (employee.getEmployeeId() == employeeId){
                return employee;
            }
        }
        return null; //Is there is no employee.
    }
}
