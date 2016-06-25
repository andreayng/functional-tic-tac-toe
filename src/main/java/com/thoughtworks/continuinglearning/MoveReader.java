package com.thoughtworks.continuinglearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class MoveReader {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;

    public MoveReader(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public int getOpenLocation(Board board) {
        int moveLocation = Integer.parseInt(getString());
        return board.isOpenLocation(moveLocation).orElseGet(() -> {
            printStream.println("Location already taken");
            return getOpenLocation(board);
        });
    }

    private String getString() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

