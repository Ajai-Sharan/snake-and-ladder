package com.examp;

public class HardDifficulty implements Difficulty {
    @Override
    public int getNumSnakes() {
        return 12;
    }

    @Override
    public int getNumLadders() {
        return 6;
    }
}