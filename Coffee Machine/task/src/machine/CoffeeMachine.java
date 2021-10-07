package machine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

enum KindOfCoffee {

    ESPRESSO(250, 0, 16, 4),
    CAPPUCCINO(200, 100, 12, 6),
    LATTE(350, 75, 20, 7);

    private int water, milk, coffeeBeans, money;

    KindOfCoffee(int water, int milk , int coffeeBeans, int money) {

        this.coffeeBeans = coffeeBeans;
        this.milk = milk;
        this.water = water;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getMoney() {
        return money;
    }

}



public class CoffeeMachine {

    private static long
            water = 400,
            milk = 540,
            coffeeBeans = 120,
            cups = 9,
            money = 550;


    private static void showResult() {

        System.out.println("The coffee machine has:\n"
                + water + " of water\n"
                + milk + " of milk\n"
                + coffeeBeans + " of coffee beans\n"
                + cups + " disposable cups\n$"
                + money + " of money");
    }

    private static void makeKindOfCoffee(KindOfCoffee kind) {

        water -= kind.getWater();
        milk -= kind.getMilk();
        coffeeBeans -= kind.getCoffeeBeans();
        money += kind.getMoney();
        cups -= 1;
    }

    private static String getInput() {

        Scanner scanner = new Scanner(System.in);

        return scanner.next();
    }

    private static boolean checkIngredients(KindOfCoffee kindOfCoffee) {
        String result = "Sorry, not enough ";

        if (water <= kindOfCoffee.getWater()) {
            System.out.println(result + "water");
            return false;
        }
        if (milk <= kindOfCoffee.getMilk()) {
            System.out.println(result + "milk");
            return false;
        }
        if (coffeeBeans <= kindOfCoffee.getCoffeeBeans()) {
            System.out.println(result + "coffee beans");
            return false;
        }
        if (cups <= 0 ) {
            System.out.println(result + "cups");
            return false;
        }

        System.out.println("I have enough resources, making you a coffee!");

        return true;
    }

    private static void buy() {

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back to main menu:\n");
        String kindOfCoffee = getInput();

        switch (kindOfCoffee) {

            case "1": {
                if(checkIngredients(KindOfCoffee.ESPRESSO)) {
                    makeKindOfCoffee(KindOfCoffee.ESPRESSO);
                }
                break;
            }
            case "2": {
                if(checkIngredients(KindOfCoffee.LATTE)) {
                    makeKindOfCoffee(KindOfCoffee.LATTE);
                }
                break;
            }
            case "3": {
                if(checkIngredients(KindOfCoffee.CAPPUCCINO)) {
                    makeKindOfCoffee(KindOfCoffee.CAPPUCCINO);
                }
                break;
            }
            default: {
                return;
            }

        }

    }

    private static void fill() {

        System.out.println("Write how many ml of water you want to add:\n");
        int quantityWater = Integer.parseInt(getInput());
        System.out.println("Write how many ml of milk you want to add:\n");
        int quantityMilk = Integer.parseInt(getInput());
        System.out.println("Write how many grams of coffee beans you want to add:\n");
        int quantityCoffee = Integer.parseInt(getInput());
        System.out.println("Write how many disposable cups of coffee you want to add:\n");
        int quantityCups = Integer.parseInt(getInput());

        water += quantityWater;
        milk += quantityMilk;
        coffeeBeans += quantityCoffee;
        cups += quantityCups;

    }

    private static void take() {
        System.out.println("I gave you $" + money);
        money -= money;
    }

    private static void coffeeMachineActions() {

        boolean isActonBegin = true;

        while (isActonBegin) {
            System.out.println("Write action (buy, fill, take, remaining, exit):\n");
            String action = getInput();

            switch (action) {
                case "buy": {
                    buy();
                    break;
                }
                case "fill": {
                    fill();
                    break;
                }
                case "take": {
                    take();
                    break;
                }
                case "remaining": {
                    showResult();
                    break;
                }
                case "exit": {
                    isActonBegin = false;
                }
            }
        }
    }


    public static void main(String[] args) {

        coffeeMachineActions();
    }

}


