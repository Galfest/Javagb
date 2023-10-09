package draft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class ChatClient extends JFrame implements ActionListener, KeyListener {
    private JTextField textField;
    private JTextArea logTextArea;
    private BufferedWriter historyWriter;

    public ChatClient() {
        setTitle("Chat Client");
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));
        textField.addActionListener(this);
        textField.addKeyListener(this);

        logTextArea = new JTextArea();
        logTextArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textField, BorderLayout.NORTH);
        panel.add(new JScrollPane(logTextArea), BorderLayout.CENTER);

        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        try {
            File historyFile = new File("chat_history.txt");
            if (historyFile.exists()) {
                BufferedReader historyReader = new BufferedReader(new FileReader(historyFile));
                String line;
                while ((line = historyReader.readLine()) != null) {
                    logTextArea.append(line + "\n");
                }
                historyReader.close();
            }
            historyWriter = new BufferedWriter(new FileWriter(historyFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        sendMessage();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            sendMessage();
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    private void sendMessage() {
        String message = textField.getText();
        if (!message.isEmpty()) {
            logTextArea.append(message + "\n");
            textField.setText("");

            try {
                historyWriter.write(message);
                historyWriter.newLine();
                historyWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChatClient();
            }
        });
    }
}