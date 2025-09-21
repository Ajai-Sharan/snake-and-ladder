package com.examp;

import java.util.Comparator;

public class TimedEndingStrategy implements IEndingStrategy {
    private final long timeLimitMillis;
    private long startTime;
    private boolean timerStarted;

    public TimedEndingStrategy(int seconds) {
        this.timeLimitMillis = seconds * 1000L;
        this.timerStarted = false;
    }

    @Override
    public boolean hasGameEnded(Game game) {
        if (!timerStarted) {
            startTime = System.currentTimeMillis();
            timerStarted = true;
            System.out.println("⏳ Timer started! Game will end in " + (timeLimitMillis / 1000) + " seconds.");
        }

        for (IPlayer p : game.getPlayers()) {
            if (p.getPosition() == game.getBoard().getTotalSize()) {
                return true;
            }
        }

        return (System.currentTimeMillis() - startTime) >= timeLimitMillis;
    }

    @Override
    public IPlayer getWinner(Game game) {
        return game.getPlayers().stream()
                .max(Comparator.comparingInt(IPlayer::getPosition))
                .orElse(null);
    }
}