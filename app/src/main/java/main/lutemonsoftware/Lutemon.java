package main.lutemonsoftware;

public class Lutemon {
    protected String name, color;
    protected int attack, defence, experienceAttack, experienceDefence, health, maxHealth, id, battlesWon, battlesLost, trainingDays, numberOfCreatedLutemons;

    public int getNumberOfCreatedLutemons() {
        return numberOfCreatedLutemons;
    }

    public void lutemonDeathHandler() {
        health = maxHealth;
        experienceAttack = 0;
        experienceDefence = 0;
    }
}
