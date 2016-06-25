package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    private PrintStream printStream;
    private Game game;
    private BufferedReader bufferedReader;
    private Board board;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        game = new Game(board, playerOne, playerTwo);
    }

    @Test
    public void shouldDrawBoardWhenStarting() {
        game.start();

        verify(board).draw();
    }

    @Test
    public void shouldMakePlayerOneMoveWhenStarting() {
        game.start();

        verify(playerOne).move();
    }

    @Test
    public void shouldMakePlayerTwoMoveWhenStarting() {
        game.start();

        verify(playerTwo).move();
    }

}