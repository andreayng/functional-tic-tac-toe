package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.empty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> cells;
    private List<String> defaultCells;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        cells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        defaultCells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        board = new Board(cells, defaultCells, printStream);
    }

    @Test
    public void shouldDrawGridWithLocationsWhenDrawing() {
        board.draw();

        verify(printStream).println(
                "1|2|3\n" +
                        "-----\n" +
                        "4|5|6\n" +
                        "-----\n" +
                        "7|8|9\n"
        );
    }

    @Test
    public void shouldDrawGridWithCorrectMarksWhenDrawing() {
        cells.replaceAll(s -> "*");

        board.draw();

        verify(printStream).println(
                "*|*|*\n" +
                        "-----\n" +
                        "*|*|*\n" +
                        "-----\n" +
                        "*|*|*\n"
        );
    }

    @Test
    public void shouldNotReturnLocationIfClosed() {
        board.markLocation(3, "X");

        assertFalse(board.isOpenLocation(3).isPresent());
    }

    @Test
    public void shouldReturnLocationIfOpen() {
        board.markLocation(3, "X");

        assertTrue(board.isOpenLocation(5).isPresent());
    }
}
