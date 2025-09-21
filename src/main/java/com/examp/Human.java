package com.examp;

import java.util.Scanner;

public class Human implements IPlayer {
    private static final Scanner scanner = new Scanner(System.in);
    private String name;
    private int position;

    public Human(String name) {
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
        System.out.println(this.name + " (P:" + this.position + "), press Enter to roll the dice.");
        scanner.nextLine();
    }
}