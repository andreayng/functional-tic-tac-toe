package com.thoughtworks.continuinglearning;

import java.io.PrintStream;
import java.util.List;

public class Game {

    private final Board board;
    private final Player playerOne;
    private final Player playerTwo;
    private final PrintStream printStream;
    private final List<BoardFullEndCondition> boardFullEndConditionList;

    public Game(Board board, Player playerOne, Player playerTwo, PrintStream printStream, List<BoardFullEndCondition> boardFullEndConditionList) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.printStream = printStream;
        this.boardFullEndConditionList = boardFullEndConditionList;
    }

    public void start() {
        board.draw();
        String gameEndMessage = makeMove(playerOne, playerTwo).getMessage();
        printStream.println(gameEndMessage);
    }

    private BoardFullEndCondition makeMove(Player player, Player opponent) {
        return boardFullEndConditionList.stream()
                .filter(condition -> condition.isMet())
                .findFirst()
                .orElseGet(() -> {
                    player.move();
                    return makeMove(opponent, player);
                });
    }
}
