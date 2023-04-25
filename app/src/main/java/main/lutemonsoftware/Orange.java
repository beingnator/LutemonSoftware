package main.lutemonsoftware;

public class Orange extends Lutemon {

    public Orange(String lutemonName) {
        super(lutemonName, "Oranssi");
        attack = 8;
        defence = 1;
        maxHealth = health = 17;
        id = getNumberOfCreatedLutemons();
        numberOfCreatedLutemons = id + 1;


    }
}
