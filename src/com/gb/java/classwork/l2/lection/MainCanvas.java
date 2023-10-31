package com.gb.java.classwork.l2.lection;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JFrame {
    private final MainWindow controller;
    private long lastFrameTime;

    MainCanvas(MainWindow controller){
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint();
    }

    public int getLeft(){return 0;}
    public int getRight(){return getWidth() - 1;}
    public int getTop(){return 0;}
    public int getBottom(){return getHeight() - 1;}
}
