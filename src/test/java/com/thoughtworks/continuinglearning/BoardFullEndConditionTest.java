package com.thoughtworks.continuinglearning;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Optional.empty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardFullEndConditionTest {

    private List<String> cells;
    private List<String> defaultCells;
    private BoardFullEndCondition boardFullEndCondition;

    @Before
    public void setUp() {
        cells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        defaultCells = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        boardFullEndCondition = new BoardFullEndCondition(cells, defaultCells);
    }

    @Test
    public void shouldReturnFalseIfBoardIsNotFull() {
        assertFalse(boardFullEndCondition.isMet());
    }

    @Test
    public void shouldReturnNonEmptyIfBoardIsFull() {
        cells.replaceAll(s -> "*");

        assertTrue(boardFullEndCondition.isMet());
    }
}
