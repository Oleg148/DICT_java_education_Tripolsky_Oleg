package CoffeeMachine;

public class Coffee {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cost;
    private int amountOfMilk = 0;
    private int amountOfWater = 0;
    private int numberOfCoffeeBeans = 0;
    private int numberOfCups = 0;
    private int amountOfMoney = 0;

    private void espresso(){
        water = 250;
        milk = 0;
        coffeeBeans = 16;
        cost = 4;
    }

    private void latte(){
        water = 350;
        milk = 75;
        coffeeBeans = 20;
        cost = 7;
    }

    private void cappuccino(){
        water = 200;
        milk = 100;
        coffeeBeans = 12;
        cost = 6;
    }

    private void order(){
        amountOfWater = amountOfWater - water;
        amountOfMilk = amountOfMilk - milk;
        numberOfCoffeeBeans = numberOfCoffeeBeans - coffeeBeans;
        amountOfMoney = amountOfMoney + cost;
        numberOfCups = numberOfCups - 1;

        if (amountOfWater > 0 && amountOfMilk > 0 && numberOfCoffeeBeans > 0 && numberOfCups > 0 ){
            System.out.println("I have enough resources, making you a coffee!");
        }
        else {
            amountOfWater = amountOfWater + water;
            amountOfMilk = amountOfMilk + milk;
            numberOfCoffeeBeans = numberOfCoffeeBeans + coffeeBeans;
            amountOfMoney = amountOfMoney - cost;
            numberOfCups = numberOfCups + 1;
            System.out.println("Not enough ingredients");
        }
    }

    public void buy(int userInput){
        switch (userInput){
            case 1:
                espresso();
                order();
                break;

            case 2:
                latte();
                order();
                break;

            case 3:
                cappuccino();
                order();
                break;
        }
    }
    public void fill(int addWater, int addMilk, int addCoffeeBeans, int addCups){
        amountOfMilk = amountOfMilk + addMilk;
        amountOfWater = amountOfWater + addWater;
        numberOfCoffeeBeans = numberOfCoffeeBeans + addCoffeeBeans;
        numberOfCups = numberOfCups + addCups;
    }

    public void take() {
        System.out.println("I gave you " + amountOfMoney);
        amountOfMoney = 0;
    }

    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(amountOfWater + " of water");
        System.out.println(amountOfMilk + " of milk");
        System.out.println(numberOfCoffeeBeans + " of coffee beans");
        System.out.println(numberOfCups + " of disposable cups");
        System.out.println(amountOfMoney + " of money");
    }
}
