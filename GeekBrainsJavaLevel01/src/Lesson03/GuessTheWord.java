package Lesson03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random r = new Random();
        int randomNumber = r.nextInt(words.length);
        String randomWord = words[randomNumber];
        guessTheWord(randomWord);

    }

    public static void guessTheWord(String word) {
        System.out.println(word);
        String guessedWord;
        Scanner sc = new Scanner(System.in);

        do {
            String damagedWord = "";
            System.out.print("Enter your guess: ");
            guessedWord = sc.nextLine();

            for (int i = 0; i < guessedWord.length() && i < word.length(); i++) {
                if (word.equals(guessedWord)) {
                    System.out.println("Nice, you got it!");
                    break;
                }
                if (word.charAt(i) == guessedWord.charAt(i)) {
                    damagedWord += word.charAt(i);
                }
            }
            System.out.println(damagedWord + "###############");
        } while (!word.equals(guessedWord));
    }
}
