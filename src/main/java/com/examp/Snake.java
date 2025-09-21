package com.examp;

public class Snake extends Entity {
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String getEncounterMessage() {
        return "Oh no! Bitten by a snake! 🐍";
    }
}