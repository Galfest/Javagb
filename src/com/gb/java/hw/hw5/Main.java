package com.gb.java.hw.hw5;

public class Main {
    private final int count = 5;

    private Main() {

        Fork[] forks = new Fork[count];

        for(int i = 0; i < count; i++) {
            forks[i] = new Fork(1);
        }

        for(int i = 0; i < count; i++) {
            new Thread(new Philosopher(i, forks[(i + 1) % count], forks[i])).start();
        }

    }

    public static void main(String[] args) {
        new Main();
    }
}
