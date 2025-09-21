package com.examp;

import java.util.Random;

public class Dice {
    private static final Dice INSTANCE = new Dice();
    private static final int MAX_VALUE = 6;
    private final Random rand = new Random();

    private Dice() {}

    public static Dice getInstance() {
        return INSTANCE;
    }

    public int roll() {
        return rand.nextInt(MAX_VALUE) + 1;
    }
}