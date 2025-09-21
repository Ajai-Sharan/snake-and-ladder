package com.examp;

public interface IPlayer {
    int getPosition();
    void setPosition(int position);
    String getName();
    char getSymbol();
    void prepareTurn();
}