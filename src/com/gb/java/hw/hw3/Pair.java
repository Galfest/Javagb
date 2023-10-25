package com.gb.java.hw.hw3;

/*
Напишите обобщенный класс Pair, который представляет собой пару значений 
разного типа. Класс должен иметь методы getFirst(), getSecond() для получения 
значений каждого из составляющих пары, а также переопределение метода toString(), возвращающее 
строковое представление пары.
 */

public class Pair <K, V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.value = value;
        this.key = key;
    }

    public K getFirst() {
        return key;
    }
    public V getSecond(){
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + getFirst() +
                ", value=" + getSecond() +
                '}';
    }

    public static void main(String[] args) {

        Pair pair = new Pair<>("hero", 17);

        System.out.println(pair);
    }
}
