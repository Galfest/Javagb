package com.gb.java.hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient extends JFrame {
    private static final int WINDOW_HEIGHT = 333;
    private static final int WINDOW_WIDTH = 555;
    private JButton btnLogin, btnSend;
    private static JTextField ipField, portField, textInput, userField, messageTextField;
    private JPanel ipPanel, panelBottom, msgPanel;
    private JPasswordField passField;
    private JLabel emptySpace;
    private BufferedWriter chatHistoryWriter;
    private static JTextArea logTextArea;
    private static Socket clientSocket;
    private int clientPort;

    ChatClient(){
        setTitle("Chat client");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnLogin = new JButton("Login");
        btnSend = new JButton("Send");
        setLocationRelativeTo(null);
        openChatHistoryFile();

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //----------------------------------------------------------------------------
            }
        });



        ipPanel = new JPanel(new GridLayout(2,3));
        ipField = new JTextField("192.168.0.1");
        portField = new JTextField("5555");
        emptySpace = new JLabel("");
        userField = new JTextField("Galfest");
        passField = new JPasswordField();
        ipPanel.add(ipField);
        ipPanel.add(portField);
        ipPanel.add(emptySpace);
        ipPanel.add(userField);
        ipPanel.add(passField);
        ipPanel.add(btnLogin);

        add(ipPanel, BorderLayout.NORTH);

        msgPanel = new JPanel(new BorderLayout());
        logTextArea = new JTextArea();
        msgPanel.add(logTextArea);

        add(msgPanel);

        panelBottom = new JPanel(new BorderLayout());
        textInput = new JTextField();
        panelBottom.add(textInput);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(panelBottom, BorderLayout.SOUTH);

        // Создание текстовой области для вывода лога
//        logTextArea = new JTextArea();
//        logTextArea.setEditable(false);
//        logTextArea.setEditable(false);

        setVisible(true);


    }
    private void sendMessage() {
        String message = textInput.getText();
        logTextArea.append(userField.getText() + message + "\n");
        logTextArea.setText("");

        writeChatHistory(message);
    }

    private void writeChatHistory(String message) {
        try {
            chatHistoryWriter.write("Me: " + message);
            chatHistoryWriter.newLine();
            chatHistoryWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openChatHistoryFile() {
        try {
            chatHistoryWriter = new BufferedWriter(new FileWriter("chat_history.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void sendMessage(String message) throws IOException {
//        // Отправка сообщения клиенту
//        OutputStream outputStream = clientSocket.getOutputStream();
//        outputStream.write(message.getBytes());
//        System.out.println("Сообщение успешно отправлено клиенту: " + message);
//    }


}
