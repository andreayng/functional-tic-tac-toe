package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    private Game game;
    private Player playerOne;
    private Board board;
    private Player playerTwo;

    @Before
    public void setUp() {
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        game = new Game(board, playerOne, playerTwo);
    }

    @Test
    public void shouldMakeFirstPlayerMoveWhenStarting() {
        game.start();

        verify(playerOne).move();
    }

    @Test
    public void shouldMakeSecondPlayerMoveWhenStarting() {
        game.start();

        verify(playerTwo).move();
    }

    @Test
    public void shouldDrawBoardWhenStarting() {
        game.start();

        verify(board).draw();
    }
}
