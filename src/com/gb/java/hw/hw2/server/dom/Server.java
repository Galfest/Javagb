package com.gb.java.hw.hw2.server.dom;


import com.gb.java.hw.hw2.client.dom.Client;
import com.gb.java.hw.hw2.server.repo.Repository;
import com.gb.java.hw.hw2.server.ui.ServerView;


import java.util.ArrayList;
import java.util.List;

public class Server {
    private boolean work;
    private ServerView serverView;
    private List<Client> clientList;
    private Repository repository;

    public Server(ServerView serverView, Repository repository) {
        this.serverView = serverView;
        this.repository = repository;
        clientList = new ArrayList<>();
    }

    public void start(){
        if (work){
            showOnWindow("Server is already start!");
        } else {
            work = true;
            showOnWindow("Server starts!");
        }
    }

    public void stop(){
        if (!work){
            showOnWindow("Server was already stopped!");
        } else {
            work = false;
            for (Client client: clientList){
                disconnectUser(client);
            }
            showOnWindow("Server is stopped!");
        }
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnectFromServer();
            showOnWindow(client.getName() + " disconnected from chat");
        }
    }


    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        showOnWindow(client.getName() + " connected to chat");
        return true;
    }

    public void message(String text){
        if (!work){
            return;
        }
        text += "";
        showOnWindow(text);
        answerAll(text);
        saveInHistory(text);
    }

    public String getHistory() {
        return (String) repository.load();
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.answerFromServer(text);
        }
    }

    private void showOnWindow(String text){
        serverView.showMessage(text + "\n");
    }

    private void saveInHistory(String text){
        repository.save(text);
    }

}
