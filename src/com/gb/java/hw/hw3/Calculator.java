package com.gb.java.hw.hw3;

/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические
методы: sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа
разного типа (но необязательно разного между собой), над которыми должна быть произведена операция.
 */


import java.text.NumberFormat;
import java.util.Locale;

public class Calculator {

        public static <T extends Number> double multiply(T a, T b){
            return a.doubleValue() * b.doubleValue();
        }

        public static <T extends Number, V extends Number> double sum(T a, V b) {
            return a.doubleValue() + b.doubleValue();
        }

        public static <T extends Number, V extends Number> double subtraction(T a, V b) {
            return a.doubleValue() - b.doubleValue();
        }

        public static <T extends Number, V extends Number> double divide(T a, V b) {
            return a.doubleValue() / b.doubleValue();
        }


        //Task 1 test.
    public static void main(String[] args) {

        System.out.println(Calculator.divide(54, 15.5));
        System.out.println(Calculator.sum((short) 5, 158L));
        System.out.println(Calculator.multiply((byte) 8, 7.0f));
        System.out.println(Calculator.subtraction((long) 17, (short) 15));
    }
}
