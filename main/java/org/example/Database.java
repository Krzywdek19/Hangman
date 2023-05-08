package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<String> words = new ArrayList<>();
    private File file;

    public Database(String filename){
        this.file = new File(filename);
    }


    public void addWordToDatabase(String word){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            while(reader.ready()){
                if(reader.readLine().equals(word)){
                    return;
                }
            }
        }catch (IOException e){
            System.err.println("Wystapil blad podczas odczytu z pliku");
        }
        try{
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.file, true)));
            writer.println(word);
            writer.close();
        }catch (IOException e){
            System.err.println("Wystąpił problem podczas zapisywania danych do pliku");
        }
    }

    public List<String> getWords(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            while(reader.ready()){
                this.words.add(reader.readLine());
            }
        }catch (IOException e){
            System.err.println("Wystapil blad podczas odczytu z pliku");
        }
        return this.words;
    }
}
