package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoveReaderTest {
    private BufferedReader bufferedReader;
    private MoveReader moveReader;
    private PrintStream printStream;
    private List<String> cells;
    private List<String> defaultCells;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        moveReader = new MoveReader(printStream, bufferedReader);
        cells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        defaultCells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    @Test
    public void shouldReturnMoveIfOpen() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        assertThat(moveReader.getOpenLocation(new Board(cells, defaultCells, System.out)), is(1));
    }

    @Test
    public void shouldReturnOpenLocation() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("2");
        cells.set(0, "X");

        assertThat(moveReader.getOpenLocation(new Board(cells, defaultCells, System.out)), is(2));
    }

    @Test
    public void shouldPrintLocationTakenMessageWhenLocationTaken() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("2");
        cells.set(0, "X");

        moveReader.getOpenLocation(new Board(cells, defaultCells, System.out));

        verify(printStream).println(contains("Location already taken"));
    }
}
