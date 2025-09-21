package com.examp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Game {
    private Board board;
    private Deque<IPlayer> players;
    private IKillingStrategy killingStrategy;
    private IEndingStrategy endingStrategy;
    private IStartingStrategy startingStrategy;
    private final DiceService diceService;
    private final int numberOfDice;
    private BoardDisplay boardDisplay;

    Game(Board board, List<IPlayer> playerList,
         IKillingStrategy killingStrategy, IEndingStrategy endingStrategy,
         IStartingStrategy startingStrategy, int numberOfDice) { // Difficulty removed
        this.board = board;
        this.players = new ArrayDeque<>(playerList);
        // this.difficulty = difficulty; // REMOVED
        this.killingStrategy = killingStrategy;
        this.endingStrategy = endingStrategy;
        this.startingStrategy = startingStrategy;
        this.diceService = new DiceService();
        this.numberOfDice = numberOfDice;
        this.boardDisplay = new BoardDisplay(board.getRows(), board.getCols());
    }

    public void startGame() {
        System.out.println("--- 🚀 Game Starting with " + numberOfDice + " dice! ---");
        System.out.println("Board generated with snakes (S->) and ladders (L->). Players are marked with 'P:'.");

        while (!endingStrategy.hasGameEnded(this)) {
            boardDisplay.printBoard(board, players);
            IPlayer currentPlayer = players.removeFirst();
            System.out.println("\n--- It's " + currentPlayer.getName() + "'s turn. ---");

            currentPlayer.prepareTurn();
            int diceRoll = diceService.roll(this.numberOfDice, currentPlayer.getName());

            if (!startingStrategy.canPlayerStart(currentPlayer, diceRoll)) {
                System.out.println(">> " + currentPlayer.getName() + " needs a 6 to start and stays at 0.");
                players.addLast(currentPlayer);
                continue;
            }

            int newPosition = board.getNextPosition(currentPlayer.getPosition(), diceRoll);
            currentPlayer.setPosition(newPosition);

            System.out.println(">> " + currentPlayer.getName() + " moved to " + newPosition);

            killingStrategy.apply(board, currentPlayer, List.copyOf(players));
            players.addLast(currentPlayer);
        }
        endGame();
    }

    public void endGame() {
        System.out.println("\n--- 🎉 Game Over! ---");
        boardDisplay.printBoard(board, players);
        IPlayer winner = endingStrategy.getWinner(this);
        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + "!");
        } else {
            System.out.println("There was no winner.");
        }
    }

    public Board getBoard() { return board; }
    public Deque<IPlayer> getPlayers() { return players; }
}