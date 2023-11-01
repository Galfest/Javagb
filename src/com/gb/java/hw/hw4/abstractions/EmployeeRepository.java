package com.gb.java.hw.hw4.abstractions;

import com.gb.java.hw.hw4.entities.Employee;

import java.util.Collection;

public class EmployeeRepository {

    // Добавить метод, который ищет сотрудника по стажу (может быть список)
    // Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    // Добавить метод, который ищет сотрудника по табельному номеру
    // Добавить метод добавление нового сотрудника в справочник сотрудников
    public interface EmployeeRepository1 extends Iterable<Employee> {
        Employee getById(int id);
        Collection<Employee> getByExperience(Integer experience);

        Collection<NamePhoneTuple> getPhonesByName(String namePattern);
        Collection<Employee> getByPhone(String phone);
        Employee add(Employee e);
        Employee add(String fullName, String phone, Integer experience);
        public static record NamePhoneTuple(String fullName, String phone){
        }
    }

}
