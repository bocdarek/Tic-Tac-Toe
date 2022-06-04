package com.dariuszboc.day4;

import java.util.Arrays;
import java.util.Scanner;

public class Board {

    private char[][] board;
    private final Scanner sc = new Scanner(System.in);

    public Board() {
        clearBoard();
    }

    public void clearBoard() {
        board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, '-');
        }
    }

    public void displayBoard() {
        System.out.println("*".repeat(20) + "\n");
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
        System.out.println("\n" + "*".repeat(20));
    }

    public void setO() {
        System.out.println("Give coordinates for 'O':");
        int[] coordinates = takeCoordinates();
        setField('O', coordinates[0], coordinates[1]);
    }

    public void setX() {
        System.out.println("Give coordinates for 'X':");
        int[] coordinates = takeCoordinates();
        setField('X', coordinates[0], coordinates[1]);
    }

    private int[] takeCoordinates() {
        int row;
        int col;
        do{
            System.out.println("Number of row:");
            row = takeInt();
            System.out.println("Number of column:");
            col = takeInt();
        } while (!areCoordinateValid(row, col));
        return new int[]{row, col};
    }

    private boolean areCoordinateValid(int row, int col) {
        if (board[row][col] == '-') {
            return true;
        } else {
            System.out.println("Wrong coordinates. Let's try once again");
            return false;
        }
    }

    private void setField(char ch, int row, int col) {
        board[row][col] = ch;
    }

    public boolean isWinner() {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }

    private boolean checkHorizontal() {
        boolean isWon = false;
        for (char[] chars : board) {
            if (chars[0] != '-' && chars[0] == chars[1] && chars[1] == chars[2]) {
                isWon = true;
                break;
            }
        }
        return isWon;
    }

    private boolean checkVertical() {
        boolean isWon = false;
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                isWon = true;
                break;
            }
        }
        return isWon;
    }

    private boolean checkDiagonal() {
        if (board[1][1] == '-') {
            return false;
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        return board[0][2] == board[1][1] && board[1][1] == board[2][0];
    }

    private int takeInt() {
        int number;
        while (true) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                sc.nextLine();
                if (!coordinateInRange(number)) {
                    System.out.println("Number must be in range 0-2.");
                    continue;
                }
                break;
            }
            sc.nextLine();
            System.out.println("It must be integer number.");
        }
        return number;
    }

    private boolean coordinateInRange(int c) {
        return c >= 0 && c <= 2;
    }
}

