package com.examp;

public class Bot implements IPlayer {
    private String name;
    private int position;

    public Bot(String name) {
        this.name = name;
        this.position = 0;
    }

    @Override
    public int getPosition() { return position; }

    @Override
    public void setPosition(int position) { this.position = position; }

    @Override
    public String getName() { return name; }

    @Override
    public char getSymbol() { return this.name.charAt(0); }

    @Override
    public void prepareTurn() {
        System.out.println(this.name + " (P:" + this.position + ") is rolling the dice...");
    }
}