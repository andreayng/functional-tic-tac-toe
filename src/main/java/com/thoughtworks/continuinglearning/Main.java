package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"), System.out);
        MoveReader moveReader = new MoveReader(System.out, new BufferedReader(new InputStreamReader(System.in)));
        Player playerOne = new Player("1", "X", board, System.out, moveReader);
        Player playerTwo = new Player("2", "O", board, System.out, moveReader);

        board.draw();
        playerOne.move(playerTwo);
    }
}
