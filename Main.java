package com.dariuszboc.day4;


import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        do {
            game.startGame();
            System.out.println("\n\nDo you want to play once again [Y/n].");
        } while (sc.next().equalsIgnoreCase("y"));
    }
}
