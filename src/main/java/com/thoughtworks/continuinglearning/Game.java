package com.thoughtworks.continuinglearning;

public class Game {

    private final Board board;
    private final Player playerOne;
    private final Player playerTwo;

    public Game(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        board.draw();
        playerOne.move();
        playerTwo.move();
    }
}
