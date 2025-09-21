package com.examp;

import java.util.List;

public class NoKillingStrategy implements IKillingStrategy {
    @Override
    public void apply(Board board, IPlayer currentPlayer, List<IPlayer> allPlayers) {
        // This strategy does nothing.
    }
}