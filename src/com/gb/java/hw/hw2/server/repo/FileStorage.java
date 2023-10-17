package com.gb.java.hw.hw2.server.repo;

import java.io.FileReader;
import java.io.FileWriter;

public class FileStorage implements Repository<String> {
    private static final String LOG_PATH = "src/com/gb/java/hw/hw2/server/repo/history.txt";


    public void save(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String load(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
