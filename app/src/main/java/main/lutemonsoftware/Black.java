package main.lutemonsoftware;

public class Black extends Lutemon {

    public Black(String lutemonName) {
        super(lutemonName, "Musta");
        attack = 9;
        defence = 0;
        maxHealth = health = 16;
        id = getNumberOfCreatedLutemons();
        numberOfCreatedLutemons = id + 1;
    }
}
