package com.examp;

public class DifficultyFactory {
    public static Difficulty createDifficulty(String level) {
        if (level == null) {
            return new MediumDifficulty();
        }
        switch (level.toLowerCase()) {
            case "easy":
                return new EasyDifficulty();
            case "hard":
                return new HardDifficulty();
            case "medium":
            default:
                return new MediumDifficulty();
        }
    }
}