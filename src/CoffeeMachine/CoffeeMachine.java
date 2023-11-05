package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Coffee coffee = new Coffee();

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String userInput = in.next();

            switch (userInput){
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    int userInputCoffee = in.nextInt();
                    coffee.buy(userInputCoffee);
                    break;

                case "take":
                    coffee.take();
                    break;

                case "remaining":
                    coffee.remaining();
                    break;

                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int userInputWater = in.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    int userInputMilk = in.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int userInputCoffeeBeans = in.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int userInputCups = in.nextInt();

                    coffee.fill(userInputWater, userInputMilk, userInputCoffeeBeans, userInputCups);
                    break;

                case "exit":
                    System. exit(0);
            }
        }
    }
}
