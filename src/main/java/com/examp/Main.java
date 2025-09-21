package com.examp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IPlayer> players = new ArrayList<>();
        players.add(new Human("Alice"));
        players.add(new Bot("BobBot"));
        players.add(new Human("Charles"));

        // All configuration is now done in a single, fluent chain.
        Game game = new GameBuilder()
                .setBoardDimensions(8, 12) // Set board size here
                .setPlayers(players)
                .setNumberOfDice(2)
                .setDifficulty(DifficultyFactory.createDifficulty("hard")) // Set difficulty just once
                .setStartingStrategy(new SixStartingStrategy())
                .setEndingStrategy(new TimedEndingStrategy(120))
                .setKillingStrategy(new KillOnExactLandingStrategy())
                .build();

        game.startGame();
    }
}