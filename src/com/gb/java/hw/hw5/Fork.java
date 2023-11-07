package com.gb.java.hw.hw5;

import java.util.concurrent.Semaphore;

class Fork extends Semaphore {

    private static final long serialVersionUID = -9092936681187449008L;

    public Fork(int permits) {
        super(permits);
    }

    public Fork(int permits, boolean fair) {
        super(permits, fair);
    }
}
