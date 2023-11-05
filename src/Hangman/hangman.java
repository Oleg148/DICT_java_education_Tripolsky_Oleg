package Hangman;

import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {

        System.out.println("HANGMAN");
        while (true) {
            Random rand = new Random();
            Scanner in = new Scanner(System.in);

            while (true) {
                System.out.print("Type 'play' to play the game, 'exit' to quit: ");
                String PlayOrExit = in.next();
                if (PlayOrExit.equals("play")) {
                    System.out.println();
                    break;
                } else if (PlayOrExit.equals("exit")) {
                    System.exit(0);
                } else {
                    System.out.println("Enter the correct command");
                }
            }

            String[] listWords = {"python", "java", "javascript", "kotlin"};
            int num = rand.nextInt(listWords.length);
            String word = listWords[num];
            char[] correctAnswer = word.toCharArray();

            char[] answer = new char[correctAnswer.length];

            for (byte i = 0; i < correctAnswer.length; i++) {
                answer[i] = '-';
            }
            String li = new String(answer);
            byte attempt = 0;
            char[] arr = new char[1];

            while (true) {

                System.out.println(li);
                System.out.print("Input a letter: ");

//          проверка на количество букв
                String quantityCheck = in.next();

                char user_input = quantityCheck.charAt(0);

//          проверка на регистр
                boolean res;
                res = Character.isUpperCase(user_input);

//          проверка на повторение букв
                char[] newarr = new char[arr.length + 1];
                boolean CheckRepetition = false;

                for (char liter : arr) {
                    if (liter == user_input) {
                        CheckRepetition = true;
                        break;
                    }
                }
                if (!CheckRepetition) {
                    System.arraycopy(arr, 0, newarr, 0, arr.length);
                    newarr[arr.length - 1] = user_input;
                    arr = newarr;
                }

//          виполняет основную функцию программы
                byte i = 0;
                boolean ErrorChecking = true;

                for (char liter : correctAnswer) {
                    if (liter == user_input) {
                        answer[i] = user_input;
                        ErrorChecking = false;
                    }
                    i += 1;
                }
                li = new String(answer);

                if (li.equals(word)) {
                    System.out.println("You guessed the word " + word + '!');
                    System.out.println("You survived!");
                    break;

                } else if (quantityCheck.equals(word)) {
                    System.out.println("You guessed the word " + word + '!');
                    System.out.println("You survived!");
                    break;

                } else if (attempt == 8) {
                    System.out.println("You lost!");
                    break;

                } else if (res) {
                    System.out.println("Please enter a lowercase English letter.");

                } else if (quantityCheck.length() > 1) {
                    System.out.println("You should input a single letter.");

                } else if (CheckRepetition) {
                    System.out.println("You've already guessed this letter.");

                } else if (ErrorChecking) {
                    System.out.println("That letter doesn't appear in the word");
                    attempt += 1;

                }
            }
        }
    }
}

