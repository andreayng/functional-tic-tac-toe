package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoveReaderTest {
    private BufferedReader bufferedReader;
    private MoveReader moveReader;
    private PrintStream printStream;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        moveReader = new MoveReader(printStream, bufferedReader);
    }

    @Test
    public void shouldReturnMoveIfOpen() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        assertThat(moveReader.getOpenLocation(new Board(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"), System.out)), is(1));
    }

    @Test
    public void shouldPrintWarningIfNotOpen() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1").thenReturn("2");

        assertThat(moveReader.getOpenLocation(new Board(Arrays.asList("X", "2", "3", "4", "5", "6", "7", "8", "9"), System.out)), is(2));
    }
}
