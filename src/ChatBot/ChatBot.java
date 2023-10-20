package ChatBot;
import java.util.Scanner;

public class ChatBot {
    public static void main (String[] args) {
        Scanner user = new Scanner(System.in);

        String first_name;
        int remainder3;
        int remainder5;
        int remainder7;
        int age;
        int num;
        int your_answer;

        System.out.println("""
                Hello! My name is DICT_Bot.
                I was created in 2023.
                Please, remind me your name.""");

        first_name = user.next();

        System.out.println("What a great name you have, " + first_name);

        System.out.println("Let me guess your age.\n" +
                "Enter remainders of dividing your age by 3, 5 and 7.");

        remainder3 = user.nextInt();
        remainder5 = user.nextInt();
        remainder7 = user.nextInt();
        age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.println("Your age is " + age + "; that's a good time to start programming!");

        System.out.println("Now I will prove to you that I can count to any number you want!");

        num = user.nextInt();

        for (int i = 0; i <= num; i++){
            System.out.println(i + " !");
        }

        System.out.println("""
                Let's test your programming knowledge.
                Why do we use methods?
                1. To repeat a statement multiple times.
                2. To decompose a program into several small subroutines.
                3. To determine the execution time of a program.
                4. To interrupt the execution of a program.""");

        for (;;){
            your_answer = user.nextInt();
            if (your_answer == 2) {
                break;
            }
            else {
                System.out.println("Please, try again.");
            }
        }
        System.out.println("Goodbye, have a nice day!");
    }
}