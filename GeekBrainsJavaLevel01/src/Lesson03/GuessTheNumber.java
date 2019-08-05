package Lesson03;

import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        int a = 0;
        int b = 9;
        int cont;
        do {
            int randomNumber = a + (int) (Math.random() * b);
            cont = guessTheNumber(randomNumber);
        } while (cont == 1);
    }

    public static int guessTheNumber (int randomNumber) {
        Scanner sc = new Scanner(System.in);
        int guessedNumber;
        int playAgain;

        for (int i = 0; i < 3; i++) {
            System.out.print("Guess the number: ");
            guessedNumber = sc.nextInt();

            if (guessedNumber == randomNumber) {
                System.out.println("Well Done! You have guessed the number!");
                System.out.print("Would you like to play again? 1 - yes, 0 - no: ");
                playAgain = sc.nextInt();
                if(playAgain == 1) {
                    return playAgain;
                } else if(playAgain == 0) {
                    return playAgain;
                }
            } else if (guessedNumber != randomNumber && i == 2) {
                System.out.println("You lost! The number was: " + randomNumber);
                System.out.print("Would you like to play again? 1 - yes, 0 - no: ");
                playAgain = sc.nextInt();
                if(playAgain == 1) {
                    return playAgain;
                } else if(playAgain == 0) {
                    return playAgain;
                }
            } else if (guessedNumber < randomNumber) {
                System.out.println("My number is greater than " + guessedNumber + ", try again!");
            } else if (guessedNumber > randomNumber) {
                System.out.println("My number is less than " + guessedNumber + ", try again!");
            }
        }
        return 0;
    }
}