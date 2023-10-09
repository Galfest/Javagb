package com.gb.java.hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MessageLogger extends JFrame implements ActionListener, KeyListener {
    private JTextField textField;
    private JTextArea logTextArea;

    public MessageLogger() {
        setTitle("Message Logger");

        // Создание текстового поля для ввода сообщения
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));
        textField.addActionListener(this);
        textField.addKeyListener(this);

        // Создание текстовой области для вывода лога
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);

        // Создание панели и добавление компонентов
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textField, BorderLayout.NORTH);
        panel.add(new JScrollPane(logTextArea), BorderLayout.CENTER);

        // Добавление панели на окно
        add(panel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == textField) {
            String message = textField.getText();
            logTextArea.append(message + "\n");
            textField.setText("");
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String message = textField.getText();
            logTextArea.append(message + "\n");
            textField.setText("");
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MessageLogger();
            }
        });
    }
}
