package com.gb.java.hw.hw3;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива и
возвращает true, если они одинаковые, и false в противном случае. Массивы могут
быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */

public class ArrayEqualizer  {

    //Task 2 test.
    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1,5,88,23,1,24,24};
        Integer[] arr2 = new Integer[]{1,5,88,23,1,24,24};
//        double[] arr2 = new double[]{12.2, 213, 12, 1231.213, 23.12};

        System.out.println(compareArrays(arr1, arr2));

    }

    public static <T> boolean compareArrays(T[] arr1, T[] arr2){
        if (arr1 == null && arr2 == null){
            return true;
        }else if (arr1 == null || arr2 == null){
            return false;
        }
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!(arr1[i].equals(arr2[i]))){
                return false;
            }
        }
        return true;
    }
}
