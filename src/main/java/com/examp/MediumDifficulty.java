package com.examp;

public class MediumDifficulty implements Difficulty {
    @Override
    public int getNumSnakes() {
        return 8;
    }

    @Override
    public int getNumLadders() {
        return 8;
    }
}