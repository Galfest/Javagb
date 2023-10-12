package com.gb.java.hw.hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer extends JFrame {
    private static final int WINDOW_HEIGHT = 333;
    private static final int WINDOW_WIDTH = 555;
    JButton btnStart, btnStop;
    JTextArea logTextArea;
    private BufferedReader chatHistoryReader;
    private JButton duplicateLogButton;
    private static final String srvIP = "127.0.0.1";
    private static final int srvPort = 5555;
    private static boolean socketIsOnline = false;
    private static ServerSocket serverSocket;
    private static Socket clientSocket;


    ChatServer() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat server");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        // Создание текстовой области для вывода лога
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        logTextArea.setEditable(false);

        JPanel adminPanel = new JPanel(new GridLayout(1, 2));
        adminPanel.add(btnStart);
        adminPanel.add(btnStop);
        add(logTextArea, BorderLayout.CENTER);
        add(adminPanel, BorderLayout.SOUTH);

        loadChatHistory();

        setVisible(true);

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (serverSocket == null) {
                        System.out.println("Server is already stopped.");
                    } else {
                        System.out.println("Stopping a server.");
                        serverSocket.close();
                    }
                } catch (IOException e2) {
                    System.err.println("An error detected while stopping a server.");
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChatClient();
//                newSocket(srvPort);
            }
        });


    }

    public static void newSocket(int srvPort) {
        try {
            serverSocket = new ServerSocket(srvPort);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Socket ClientSocket = null;
            Thread clientThread = new Thread(() -> handleClient(ClientSocket));
            clientThread.start();
        }
    }


    private static void handleClient(Socket clientSocket) {
        try {
            // Код для работы с подключением от клиента
            clientSocket.close(); // Закрытие сокета после использования
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private void loadChatHistory() {
        try {
            chatHistoryReader = new BufferedReader(new FileReader("chat_history.txt"));
            String line;
            while ((line = chatHistoryReader.readLine()) != null) {
                logTextArea.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (chatHistoryReader != null) {
                try {
                    chatHistoryReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
