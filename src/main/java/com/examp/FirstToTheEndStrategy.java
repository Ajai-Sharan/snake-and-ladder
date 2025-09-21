package com.examp;

public class FirstToTheEndStrategy implements IEndingStrategy {
    private IPlayer winner;

    @Override
    public boolean hasGameEnded(Game game) {
        int boardSize = game.getBoard().getTotalSize();
        for (IPlayer player : game.getPlayers()) {
            if (player.getPosition() == boardSize) {
                this.winner = player;
                return true;
            }
        }
        return false;
    }

    @Override
    public IPlayer getWinner(Game game) {
        return winner;
    }
}