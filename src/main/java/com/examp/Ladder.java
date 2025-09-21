package com.examp;

public class Ladder extends Entity {
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public String getEncounterMessage() {
        return "Yay! Climbed a ladder! 🪜";
    }
}