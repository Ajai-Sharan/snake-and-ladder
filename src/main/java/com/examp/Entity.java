package com.examp;

public abstract class Entity {
    protected int start;
    protected int end;

    public Entity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public abstract String getEncounterMessage();
}