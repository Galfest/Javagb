package com.gb.java.classwork.l2;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite{
    private static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;


    Ball(){
        halfHeight = 20 + (float)(Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float)(Math.random() * 200f);
        vY = 100f + (float)(Math.random() * 200f);
    }

    @Override
    void render(MainCanvas canvas, Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval((int)getLeft(), (int)getTop(), (int)getHeight(), (int)getWidth());
    }

}
