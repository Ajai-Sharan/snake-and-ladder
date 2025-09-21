package com.examp;

public class EasyDifficulty implements Difficulty {
    @Override
    public int getNumSnakes() {
        return 5;
    }

    @Override
    public int getNumLadders() {
        return 10;
    }
}