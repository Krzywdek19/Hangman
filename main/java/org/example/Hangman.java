package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Hangman {
    final private char[] word;
    private final Set<Character> lettersFromUser = new HashSet<>();

    private int trials = 8;
    private boolean isCorrect;


    public Hangman(Database db) {
        List<String> words = db.getWords();
        Random random = new Random();
        this.word = words.get(random.nextInt(0, words.size() - 1)).toCharArray();
        this.printWord();
    }

    public void printWord() {
        this.isCorrect = true;
        for (char c : word) {
            if (c == ' ') {
                System.out.print(c);
            } else {
                if (lettersFromUser.contains(c)) {
                    System.out.print(c);
                } else {
                    System.out.print('_');
                    this.isCorrect = false;
                }
            }
        }
        System.out.println();
        if (this.isCorrect) {
            System.out.println("Udało Ci się odgadąć hasło! Wygrałeś");
        }
    }

    public boolean guessLetter(BufferedReader reader) throws IOException {
        System.out.println();
        char letter;
        while (true){
            System.out.println("Podaj literke: ");
            try {
                letter = reader.readLine().charAt(0);
                break;
            }catch (StringIndexOutOfBoundsException e){
                System.out.println("Oczekiwano jednej litery - podałeś pustą wartość, wprowadź literkę jeszcze raz :>");
                System.out.println();
            }
        }
        this.letterHandler(letter);
        this.printWord();

        return this.trials >= 0;
    }

    public void letterHandler(char letter) {
        if (containLetter(letter)) {
            this.lettersFromUser.add(letter);
        } else {
            this.trials--;
            if (trials >= 0) {
                System.out.println("Zostało Ci " + this.trials + " prób");
            }
        }
    }

    public boolean containLetter(char letter) {
        for (char c : word) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    public void play(BufferedReader reader) throws IOException {
        while (!isCorrect) {
            if (!guessLetter(reader)) {
                System.out.println("Przykro mi, nie udało Ci się odgadnąć hasła - przegrałeś");
                return;
            }
        }
        System.out.println();
    }
}
