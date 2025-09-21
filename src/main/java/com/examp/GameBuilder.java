package com.examp;

import java.util.List;

public class GameBuilder {
    // private Board board; // REMOVED
    private int rows, cols; // ADDED
    private List<IPlayer> players;
    private Difficulty difficulty;
    private IKillingStrategy killingStrategy;
    private IEndingStrategy endingStrategy;
    private IStartingStrategy startingStrategy;
    private int numberOfDice = 1;

    public GameBuilder setBoardDimensions(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        return this;
    }

    public GameBuilder setPlayers(List<IPlayer> players) {
        this.players = players;
        return this;
    }

    public GameBuilder setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public GameBuilder setKillingStrategy(IKillingStrategy killingStrategy) {
        this.killingStrategy = killingStrategy;
        return this;
    }

    public GameBuilder setEndingStrategy(IEndingStrategy endingStrategy) {
        this.endingStrategy = endingStrategy;
        return this;
    }

    public GameBuilder setStartingStrategy(IStartingStrategy startingStrategy) {
        this.startingStrategy = startingStrategy;
        return this;
    }

    public GameBuilder setNumberOfDice(int numberOfDice) {
        if (numberOfDice < 1) {
            throw new IllegalArgumentException("Number of dice must be at least 1.");
        }
        this.numberOfDice = numberOfDice;
        return this;
    }

    public Game build() {
        if (rows <= 0 || cols <= 0 || players == null || players.size() < 2) {
            throw new IllegalStateException("Game requires board dimensions and at least two players.");
        }

        if (killingStrategy == null) killingStrategy = new NoKillingStrategy();
        if (endingStrategy == null) endingStrategy = new FirstToTheEndStrategy();
        if (startingStrategy == null) startingStrategy = new SixStartingStrategy();
        if (difficulty == null) difficulty = DifficultyFactory.createDifficulty("medium");

        // The builder now creates the board using the settings provided.
        Board board = new Board(rows, cols, difficulty);

        return new Game(board, players, killingStrategy, endingStrategy, startingStrategy, numberOfDice);
    }
}