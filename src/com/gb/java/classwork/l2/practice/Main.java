package com.gb.java.classwork.l2.practice;


import com.gb.java.classwork.l2.practice.client.ClientGUI;
import com.gb.java.classwork.l2.practice.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
