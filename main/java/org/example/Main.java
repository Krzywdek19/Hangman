package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Database db = new Database("words");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        boolean isPlaying = true;



        while(isPlaying){
            System.out.println("1 - dodaj slowko do puli \n2 - graj \n3 - zakoncz dzialanie aplikacji");
            try {
                index = Integer.parseInt(String.valueOf(reader.readLine().charAt(0)));
            }catch (Exception e){
                System.out.println("Wystapil problem podczas pobierania danych od uzytkownika");
            }
            switch (index) {
                case 1 -> {
                    try {
                        System.out.println("Wprowadź słowo: ");
                        db.addWordToDatabase(reader.readLine());
                    } catch (Exception e) {
                        System.out.println("Wystapil problem podczas pobierania danych od uzytkownika");
                    }
                }
                case 2 -> {
                    Hangman hangman = new Hangman(db);
                    try {
                        hangman.play(reader);
                    }catch (Exception e){
                        System.out.println("Wystapil problem podczas pobierania danych od uzytkownika");
                    }
                }
                case 3 -> isPlaying = false;
            }
        }
        reader.close();
    }
}