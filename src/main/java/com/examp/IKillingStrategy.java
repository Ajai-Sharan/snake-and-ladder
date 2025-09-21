package com.examp;

import java.util.List;

public interface IKillingStrategy {
    void apply(Board board, IPlayer currentPlayer, List<IPlayer> allPlayers);
}