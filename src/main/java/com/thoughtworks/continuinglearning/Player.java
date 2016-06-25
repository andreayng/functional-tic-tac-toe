package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private final String playerNumber;
    private final String mark;
    private final Board board;
    private final PrintStream printStream;
    private final MoveReader moveReader;

    public Player(String playerNumber, String mark, Board board, PrintStream printStream, MoveReader moveReader) {
        this.playerNumber = playerNumber;
        this.mark = mark;
        this.board = board;
        this.printStream = printStream;
        this.moveReader = moveReader;
    }

    public void move() {
        printStream.println("Player " + playerNumber + ", make your move:");
        int validMove = moveReader.getOpenLocation(board);
        board.markLocation(validMove, mark);
        board.draw();
    }

}
