package com.examp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiceService {

    public int roll(int numberOfDice, String playerName) {
        if (numberOfDice <= 0) {
            return 0;
        }

        List<Integer> rolls = new ArrayList<>();
        int sum = 0;
        Dice die = Dice.getInstance();

        for (int i = 0; i < numberOfDice; i++) {
            int roll = die.roll();
            rolls.add(roll);
            sum += roll;
        }

        String rollsStr = rolls.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(">> " + playerName + " rolled " + numberOfDice + " dice: [" + rollsStr + "]. Total: " + sum);
        return sum;
    }
}