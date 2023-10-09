package com.gb.java.hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;


public class ChatServer extends JFrame {
    private static final int WINDOW_HEIGHT = 333;
    private static final int WINDOW_WIDTH = 555;
    JButton btnStart, btnStop;
    JTextArea logTextArea;
    private static final String srvIP = "127.0.0.1";
    private static final int srvPort = 5555;
    private static boolean socketIsOnline = false;
    Socket socket;

    public static void newSocket(String srvIP, int srvPort){
        try{
            Socket socket = new Socket(srvIP, srvPort);
        } catch (IOException e){
            e.printStackTrace();
            System.err.println("Socket is down!");
        }
    }
    ChatServer(){
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Chat server");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (socket != null && !socket.isClosed()){
//                    try{
//                        socket.close();
//                    }catch (IOException e2){
//                        e2.printStackTrace();
//                    }
//                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChatClient();
//                newSocket(srvIP, srvPort);
//                setVisible(false); //Разкомментирвоать для клиенов.
            }
        });

        // Создание текстовой области для вывода лога
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        logTextArea.setEditable(false);

        JPanel adminPanel = new JPanel(new GridLayout(1,2));
        adminPanel.add(btnStart);
        adminPanel.add(btnStop);
        add(logTextArea, BorderLayout.CENTER);
        add(adminPanel, BorderLayout.SOUTH);

        setVisible(true);

    }
}
