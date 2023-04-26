package main.lutemonsoftware;

import java.io.Serializable;

public class Lutemon implements Serializable {
    protected String name, color;
    protected int attack, defence, experienceAttack = 0, experienceDefence = 0, health, maxHealth, id, battlesWon = 0, battlesLost = 0, trainingDays = 0;
    protected static int numberOfCreatedLutemons = 0;
    protected int image = 0;

    public static int getNumberOfCreatedLutemons() {
        return numberOfCreatedLutemons;
    }

    public Lutemon (String name, String color) {
        this.name = name;
        this.color = color;
        System.out.println("Lutemon-olio luotu!");
    }

    public void lutemonDeathHandler() {
        health = maxHealth;
        experienceAttack = 0;
        experienceDefence = 0;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public int getExperienceAttack() {
        return experienceAttack;
    }

    public int getExperienceDefence() {
        return experienceDefence;
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
