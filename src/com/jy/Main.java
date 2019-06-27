package com.jy;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static int randValue()
    {
        int x;
        Random math = new Random();
        x = 1 + math.nextInt(36);
        return x;
    }

    public static int randColor()
    {
        int x;
        Random math = new Random();
        x = math.nextInt(2);
        return x;
    }

    public static void main(String[] args) {

        System.out.println("WELCOME! Let's play some Roulette!\n");
        Game player = new Game();
        Scanner in = new Scanner(System.in);

        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("black");

        int number;
        String color;
        int total = 0;
        int games_won = 0;
        int games_lost = 0;


        while(player.isReplay() == true)
        {
            number = randValue();

            color = colors.get(randColor());

            System.out.print("Enter the type of bet you would like to place (red|black|even|odd|high|low): ");
            player.setBet(in.nextLine());

            System.out.print("Enter in your bet amount: ");
            player.setAmount(in.nextInt());
            in.nextLine();

            System.out.println("The ball landed on: "+number+" "+color);

            if(player.getBet().equals("red") && color.equals("red"))
            {
                System.out.println("Congratulations, you've won.");
                total += player.getAmount()*2;
                System.out.println();
                System.out.println("You currently have: $"+total);
                games_won++;
            }
            else if(player.getBet().equals("black")&& color.equals("black"))
            {
                System.out.println("Congratulations, you've won.");
                total += player.getAmount()*2;
                System.out.println();
                System.out.println("You currently have: $"+total);
                games_won++;
            }
            else if(player.getBet().equals("even") && (number%2 == 0))
            {
                System.out.println("Congratulations, you've won.");
                total += player.getAmount()*2;
                System.out.println();
                System.out.println("You currently have: $"+total);
                games_won++;
            }
            else if(player.getBet().equals("odd") && (number%2 == 1))
            {
                System.out.println("Congratulations, you've won.");
                total += player.getAmount()*2;
                System.out.println();
                System.out.println("You currently have: $"+total);
                games_won++;
            }
            else if(player.getBet().equals("high") && (number >= 19))
            {
                System.out.println("Congratulations, you've won.");
                total += player.getAmount()*2;
                System.out.println();
                System.out.println("You currently have: $"+total);
                games_won++;
            }
            else if(player.getBet().equals("low")&& (number <= 18))
            {
                System.out.println("Congratulations, you've won.");
                total += player.getAmount()*2;
                System.out.println();
                System.out.println("You currently have: $"+total);
                games_won++;
            }
            else
            {
                System.out.println("Sorry, you've lost this bet.");
                System.out.println();
                total -= player.getAmount();
                System.out.println("You currently have: $"+total);
                System.out.println();
                games_lost++;
            }

            System.out.println("Would you like to play again (true|false)?");
            player.setReplay(in.nextBoolean());
            in.nextLine();
        }

        System.out.println("Thank you for playing!!");
        System.out.println("This is how much money you have remaining: $"+total);
        System.out.println("You've won "+games_won+" game(s) and lost "+games_lost+" game(s).");

    }
}
