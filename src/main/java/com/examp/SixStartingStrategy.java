package com.examp;

public class SixStartingStrategy implements IStartingStrategy {
    @Override
    public boolean canPlayerStart(IPlayer player, int diceRoll) {
        if (player.getPosition() == 0) {
            return diceRoll == 6;
        }
        return true;
    }
}