package com.examp;

import java.util.List;

public class KillOnExactLandingStrategy implements IKillingStrategy {
    @Override
    public void apply(Board board, IPlayer currentPlayer, List<IPlayer> allPlayers) {
        for (IPlayer otherPlayer : allPlayers) {
            if (otherPlayer != currentPlayer && otherPlayer.getPosition() == currentPlayer.getPosition()) {
                otherPlayer.setPosition(0);
                System.out.println("💥 " + currentPlayer.getName() + " landed on " + otherPlayer.getName() +
                        " and sent them back to the start!");
            }
        }
    }
}