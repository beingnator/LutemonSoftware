package main.lutemonsoftware;

public class Lutemon {
    protected String name, color;
    protected int attack, defence, experienceAttack = 0, experienceDefence = 0, health, maxHealth, id, battlesWon = 0, battlesLost = 0, trainingDays = 0;
    protected static int numberOfCreatedLutemons = 0;

    public static int getNumberOfCreatedLutemons() {
        return numberOfCreatedLutemons;
    }

    public void lutemonDeathHandler() {
        health = maxHealth;
        experienceAttack = 0;
        experienceDefence = 0;
    }

    public int getBattlesWon() {
        return battlesWon;
    }

    public int getBattlesLost() {
        return battlesLost;
    }

    public int getTrainingDays() {
        return trainingDays;
    }
}
