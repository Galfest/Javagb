package com.gb.java.hw.hw5;

import java.util.Random;

class Philosopher implements Runnable {

    private final float chanceToEat = 0.3f;
    private final float chanceToThink = 0.3f;

    private int number;

    private Fork leftFork;
    private Fork rightFork;

    private Random random;

    private STATES state;

    private enum STATES {
        THINKING,
        EATING;
    }

    public Philosopher(int number, Fork leftFork, Fork rightFork) {
        this.number = number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;

        random = new Random(System.nanoTime());
        state = STATES.THINKING;
    }

    boolean isTimeToEat() {
        return random.nextFloat() < chanceToEat;
    }

    boolean isTimeToThink() {
        return random.nextFloat() < chanceToThink;
    }

    @Override
    public void run() {
        System.out.println("Philosopher № " + number + " is thinking.");
        while(true) {
            try {
                switch(state) {
                    case THINKING:  if(isTimeToEat()) {
                        boolean wait = true;
                        int i = 0;
                        while(wait) {
                            synchronized(leftFork) {
                                synchronized(rightFork) {
                                    if(leftFork.availablePermits() > 0 && rightFork.availablePermits() > 0) {
                                        leftFork.acquire();
                                        rightFork.acquire();
                                        wait = false;
                                        System.out.println("Philosopher № " + number + " is eating.");
                                        state = STATES.EATING;
                                    }
                                    else {
                                        if(i++ == 0) {
                                            System.out.println("Philosopher № " + number + " is waiting.");
                                        }
                                        if(i > 100) {
                                            System.out.println("DEADLOCK\tDEADLOCK\tDEADLOCK\tDEADLOCK\tDEADLOCK\t");
                                        }
                                        Thread.sleep(500);
                                    }
                                }
                            }
                        }
                    }
                        break;

                    case EATING:    if(isTimeToThink()) {
                        leftFork.release();
                        rightFork.release();
                        System.out.println("Philosopher № " + number + " is thinking.");
                        state = STATES.THINKING;
                    }
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}