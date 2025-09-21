package com.examp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDisplay {
    private final int rows;
    private final int cols;

    public BoardDisplay(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public void printBoard(Board board, Deque<IPlayer> players) {
        System.out.println("\n" + "-".repeat(cols * 9 + 1));
        Map<Integer, List<Character>> playerPositions = getPlayerPositions(players);
        Map<Integer, Entity> entities = board.getEntities();

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = 0; col < cols; col++) {
                int cellNumber = getCellNumber(row, col);
                String cellContent = getCellContent(cellNumber, playerPositions, entities);
                System.out.printf("| %-6s ", cellContent);
            }
            System.out.println("|");
            System.out.println("-".repeat(cols * 9 + 1));
        }
    }

    private int getCellNumber(int row, int col) {
        if (row % 2 == 0) { // Even rows (from bottom: 0, 2, ...) go left-to-right
            return row * cols + col + 1;
        } else { // Odd rows go right-to-left
            return row * cols + (cols - 1 - col) + 1;
        }
    }

    private String getCellContent(int cellNumber, Map<Integer, List<Character>> playerPositions, Map<Integer, Entity> entities) {
        if (playerPositions.containsKey(cellNumber)) {
            StringBuilder playersOnCell = new StringBuilder();
            for (char symbol : playerPositions.get(cellNumber)) {
                playersOnCell.append(symbol);
            }
            return "P:" + playersOnCell;
        }

        if (entities.containsKey(cellNumber)) {
            Entity entity = entities.get(cellNumber);
            if (entity instanceof Snake) {
                return "S->" + entity.getEnd();
            } else if (entity instanceof Ladder) {
                return "L->" + entity.getEnd();
            }
        }
        return String.valueOf(cellNumber);
    }

    private Map<Integer, List<Character>> getPlayerPositions(Deque<IPlayer> players) {
        Map<Integer, List<Character>> positions = new HashMap<>();
        for (IPlayer player : players) {
            if (player.getPosition() > 0) {
                positions.computeIfAbsent(player.getPosition(), k -> new ArrayList<>()).add(player.getSymbol());
            }
        }
        return positions;
    }
}