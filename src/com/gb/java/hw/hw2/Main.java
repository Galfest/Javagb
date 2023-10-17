package com.gb.java.hw.hw2;


import com.gb.java.hw.hw2.client.ui.ClientGUI;
import com.gb.java.hw.hw2.server.ui.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
