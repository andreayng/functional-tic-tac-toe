package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Optional;

import static java.util.Optional.empty;
import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private Player playerOne;
    private Board board;
    private Player playerTwo;
    private PrintStream printStream;
    private BoardFullEndCondition boardFullEndCondition;

    @Before
    public void setUp() {
        board = mock(Board.class);
        boardFullEndCondition = mock(BoardFullEndCondition.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        printStream = mock(PrintStream.class);
        game = new Game(board, playerOne, playerTwo, printStream, Arrays.asList(boardFullEndCondition));
    }

    @Test
    public void shouldDrawBoardWhenStarting() {
        when(boardFullEndCondition.isMet()).thenReturn(true);
        game.start();

        verify(board).draw();
    }

    @Test
    public void shouldNotMakeMoveWhenBoardIsFull() {
        when(boardFullEndCondition.isMet()).thenReturn(true);

        game.start();

        verify(playerOne, never()).move();
    }

    @Test
    public void shouldMakeMoveWhenBoardIsNotFull() {
        when(boardFullEndCondition.isMet()).thenReturn(false).thenReturn(true);

        game.start();

        verify(playerOne, times(1)).move();
        verify(playerTwo, never()).move();
    }
}
