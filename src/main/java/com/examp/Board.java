package com.examp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Board {
    private int rows;
    private int cols;
    private Map<Integer, Entity> entities;

    public Board(int rows, int cols, Difficulty difficulty) {
        this.rows = rows;
        this.cols = cols;
        this.entities = new HashMap<>();
        generateEntities(difficulty);
    }

    private void generateEntities(Difficulty difficulty) {
        int totalSize = rows * cols;
        int numSnakes = difficulty.getNumSnakes();
        int numLadders = difficulty.getNumLadders();
        Random rand = new Random();
        Set<Integer> occupiedCells = new HashSet<>();

        for (int i = 0; i < numSnakes; i++) {
            while (true) {
                int start = rand.nextInt(totalSize - 2) + 2;
                int end = rand.nextInt(start - 1) + 1;
                if (!occupiedCells.contains(start) && !occupiedCells.contains(end) && start != end) {
                    entities.put(start, new Snake(start, end));
                    occupiedCells.add(start);
                    occupiedCells.add(end);
                    break;
                }
            }
        }

        for (int i = 0; i < numLadders; i++) {
            while (true) {
                int start = rand.nextInt(totalSize - 2) + 2;
                int end = rand.nextInt(totalSize - start) + start + 1;
                if (!occupiedCells.contains(start) && !occupiedCells.contains(end) && start != end) {
                    entities.put(start, new Ladder(start, end));
                    occupiedCells.add(start);
                    occupiedCells.add(end);
                    break;
                }
            }
        }
    }

    public int getTotalSize() {
        return rows * cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Map<Integer, Entity> getEntities() {
        return entities;
    }

    public int getNextPosition(int currentPosition, int diceRoll) {
        int newPosition = currentPosition + diceRoll;
        if (newPosition > getTotalSize()) {
            return currentPosition;
        }
        if (entities.containsKey(newPosition)) {
            Entity entity = entities.get(newPosition);
            System.out.println(entity.getEncounterMessage());
            return entity.getEnd();
        }
        return newPosition;
    }
}