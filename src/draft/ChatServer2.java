package draft;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatClient2 extends JFrame {
    private JTextArea logTextArea;
    private JTextField messageTextField;
    private JButton sendButton;
    private BufferedWriter chatHistoryWriter;

    public ChatClient2() {
        setTitle("Chat Client");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        setListeners();

        setVisible(true);

        openChatHistoryFile();
    }

    private void initComponents() {
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logTextArea);

        messageTextField = new JTextField();

        sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(messageTextField, BorderLayout.NORTH);
        panel.add(sendButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void setListeners() {
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        messageTextField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {}

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });
    }

    private void sendMessage() {
        String message = messageTextField.getText();
        logTextArea.append("Me: " + message + "\n");
        messageTextField.setText("");

        writeChatHistory(message);
    }

    private void openChatHistoryFile() {
        try {
            chatHistoryWriter = new BufferedWriter(new FileWriter("chat_history.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) {
        new ChatClient();
    }
}



public class ChatServer2 extends JFrame {
    private JTextArea logTextArea;
    private JButton duplicateLogButton;
    private BufferedReader chatHistoryReader;

    public ChatServer2() {
        setTitle("Chat Server");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        setListeners();

        setVisible(true);

        loadChatHistory();
    }

    private void initComponents() {
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logTextArea);

        duplicateLogButton = new JButton("Duplicate Log");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(duplicateLogButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void setListeners() {
        duplicateLogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                duplicateLog();
            }
        });
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

    private void duplicateLog() {
        String log = logTextArea.getText();
        // Здесь можно добавить код для записи лога в файл или отправки на сервер

        System.out.println("Chat log duplicated: " + log);
    }

    public static void main(String[] args) {
        new ChatClient2();
    }
}