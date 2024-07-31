package Roulette;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account myAccount = new Account();
        myAccount.setAccountBalance(5000);
        System.out.println("=============================");
        System.out.println("Welcome to classic european roulette");
        System.out.println("Your account balance is: " + myAccount.getAccountBalance());
        System.out.println("=============================");

        System.out.println("Pusty commit");
        int bet;
        int drawnNumber;
        int actions;
        String color;
        String colorBet;
        Scanner action = new Scanner(System.in);
        Scanner type = new Scanner(System.in);
        do {
            if(myAccount.getAccountBalance()>0){
            System.out.println("Select action: ");
            System.out.println("(1) Keep playing");
            System.out.println("(2) Show my account balance");
            System.out.println("(3) Leave the casino");
                actions = action.nextInt();


            switch (actions) {
                case 1:
                    System.out.println("Enter the amount of bet");
                    bet = type.nextInt();
                    if (bet > myAccount.getAccountBalance() || bet<0) {
                        do {
                            System.out.println("Enter the correct amount of bet");
                            bet = type.nextInt();
                        } while (bet > myAccount.accountBalance() || bet<0);
                    }
                    myAccount.setAccountBalance(myAccount.getAccountBalance()-bet);
                    System.out.println("Choose the color you want to bet on: green, red or black");
                    colorBet = type.next();
                    if(!colorBet.equals("green") && !colorBet.equals("red") && !colorBet.equals("black")){
                        do{
                            System.out.println("Choose the correct color: green, red or black");
                            colorBet = type.next();
                        }while(!colorBet.equals("green") && !colorBet.equals("red") && !colorBet.equals("black"));
                    }
                    drawnNumber = rouletteStart();
                    if (drawnNumber == 0) {
                        color = "green";
                    } else if (drawnNumber % 2 == 1) {
                        color = "red";
                    } else {
                        color = "black";
                    }
                    if (drawnNumber == 0 && colorBet.equals("green")){
                        bet = bet * 36;
                        System.out.println("You won " + bet + " dollars");
                        myAccount.setAccountBalance(myAccount.getAccountBalance() + bet);
                        bet = 0;
                    } else if (drawnNumber == 0) {
                        bet = 0;
                        System.out.println("You lost, the color was " + color);
                    } else if (drawnNumber % 2 == 1 && colorBet.equals("red")) {
                        bet = bet * 2;
                        System.out.println("You won " + bet + " dollars");
                        myAccount.setAccountBalance(myAccount.getAccountBalance() + bet);
                        bet = 0;
                    } else if (drawnNumber % 2 == 1 && !colorBet.equals("red")) {
                        bet = 0;
                        System.out.println("You lost, the color was " + color);
                    } else if (drawnNumber % 2 == 0 && colorBet.equals("black")) {
                        bet = bet * 2;
                        System.out.println("You won " + bet + " dollars");
                        myAccount.setAccountBalance(myAccount.getAccountBalance() + bet);
                        bet = 0;
                    } else if (drawnNumber % 2 == 0 && !colorBet.equals("black")) {
                        bet = 0;
                        System.out.println("You lost, the color was " + color);
                    }
                    break;
                case 2:
                    System.out.println("Your account balance is: " + myAccount.getAccountBalance() + " dollars");
                    break;
                case 3:
                    System.out.println("You left the casino with an amount of: " + myAccount.getAccountBalance() + " dollars");
                    break;
                default:
                    System.out.println("Select the correct action");
                    System.out.println("(1) Keep playing");
                    System.out.println("(2) Show my account balance");
                    System.out.println("(3) Leave the casino");
                    break;
            }
        }
            else{
                System.out.println("You lost all your money");
                break;
            }
            }while(actions != 3);
        action.close();
        type.close();
    }

            public static int rouletteStart() {
                Random rnd = new Random();
                int rouletteNumberDrawn = rnd.nextInt(37);
                System.out.println("The field drawn is: " + rouletteNumberDrawn);
                return rouletteNumberDrawn;
            }

    }