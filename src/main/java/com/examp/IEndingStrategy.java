package com.examp;

public interface IEndingStrategy {
    boolean hasGameEnded(Game game);
    IPlayer getWinner(Game game);
}