package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private Player player;
    private PrintStream printStream;
    private Board board;
    private String playerNumber;
    private String mark;
    private MoveReader moveReader;
    private Player playerTwo;

    @Before
    public void setUp() throws IOException {
        moveReader = mock(MoveReader.class);
        when(moveReader.getOpenLocation(any())).thenReturn(1);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        playerNumber = "1";
        mark = "X";
        player = new Player(playerNumber, mark, board, printStream, moveReader);
        playerTwo = mock(Player.class);
    }

    @Test
    public void shouldPromptUserWhenMakingMove() {
        player.move();

        verify(printStream).println(contains("Player 1"));
    }

    @Test
    public void shouldReadInputWhenMakingMove() throws IOException {
        player.move();

        verify(moveReader).getOpenLocation(board);
    }

    @Test
    public void shouldMarkBoardWhenMakingMove() {
        player.move();

        verify(board).markLocation(1, mark);
    }

    @Test
    public void shouldRedrawBoardWhenMakingMove() {
        player.move();

        verify(board).draw();
    }
}
