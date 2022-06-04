package com.dariuszboc.day4;

public class Game {

    Board board = new Board();
    int turn = 0;
    final int maxNumberOfTurns = 9;

    public void startGame() {
        board.clearBoard();
        turn = 0;
        while (!board.isWinner() && turn < maxNumberOfTurns) {
            if (turn % 2 == 0) {
                board.setX();
            } else {
                board.setO();
            }
            turn++;
            board.displayBoard();
        }
        if (turn == 9) {
            System.out.println("No Winner");
            return;
        }
        System.out.printf("The game is over! The winner is %c\n", turn % 2 == 0 ? 'O' : 'X');
    }
}
