package com.thoughtworks.continuinglearning;

import java.util.List;
import java.util.Optional;

public class BoardFullEndCondition {

    private final List<String> cells;
    private final List<String> defaultCells;

    public BoardFullEndCondition(List<String> cells, List<String> defaultCells) {
        this.cells = cells;
        this.defaultCells = defaultCells;
    }

    public boolean isMet() {
        return !cells.stream()
                .filter(currentMark -> defaultCells.contains(currentMark))
                .findFirst()
                .isPresent();
    }

    public String getMessage() {
        return "Game ended in draw";
    }

}

