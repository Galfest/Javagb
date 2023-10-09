package com.gb.java.hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatClient extends JFrame {
    private static final int WINDOW_HEIGHT = 333;
    private static final int WINDOW_WIDTH = 555;
    JButton btnLogin, btnSend;
    JTextField ipField, portField, textInput, userField, msgField;
    JPanel ipPanel, panelBottom, msgPanel;
    JPasswordField passField;
    JLabel emptySpace;

    ChatClient(){
        setTitle("Chat client");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnLogin = new JButton("Login");
        btnSend = new JButton("Send");
        setLocationRelativeTo(null);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Message send!");
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login to chat!");
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
        msgField = new JTextField();
        msgPanel.add(msgField);

        add(msgPanel);

        panelBottom = new JPanel(new BorderLayout());
        textInput = new JTextField();
        panelBottom.add(textInput);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(panelBottom, BorderLayout.SOUTH);

        setVisible(true);
    }
}
