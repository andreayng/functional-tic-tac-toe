package com.thoughtworks.continuinglearning;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

public class Board {

    private final List<String> defaultBoard = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
    private final PrintStream printStream;
    private List<String> cells;

    public Board(List<String> cells, PrintStream printStream) {
        this.printStream = printStream;
        this.cells = cells;
    }

    public void draw() {
        String grid = format( "%s|%s|%s\n" +
                        "-----\n" +
                        "%s|%s|%s\n" +
                        "-----\n" +
                        "%s|%s|%s\n",
                cells.toArray());

        printStream.println(grid);
    }

    public void markLocation(int location, String mark) {
        cells.set(location - 1, mark);
    }

    public Optional<Integer> isOpenLocation(int location) {
        String cellMark = cells.get(location - 1);
        return defaultBoard.stream()
                .filter(defaultMark -> cellMark.equals(defaultMark))
                .map(markString -> Integer.parseInt(markString))
                .findFirst();
    }

}
