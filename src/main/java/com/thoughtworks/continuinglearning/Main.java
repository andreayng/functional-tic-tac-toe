package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> cells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> defaultCells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Board board = new Board(cells, defaultCells, System.out);
        BoardFullEndCondition boardFullEndCondition = new BoardFullEndCondition(cells, defaultCells);
        MoveReader moveReader = new MoveReader(System.out, new BufferedReader(new InputStreamReader(System.in)));
        Player playerOne = new Player("1", "X", board, System.out, moveReader);
        Player playerTwo = new Player("2", "O", board, System.out, moveReader);

        Game game = new Game(board, playerOne, playerTwo, System.out, Arrays.asList(boardFullEndCondition));
        game.start();
    }
}
