package main.lutemonsoftware;

public class White extends Lutemon {

    public White() {
        attack = 5;
        defence = 4;
        maxHealth = health = 20;
        id = getNumberOfCreatedLutemons();
        numberOfCreatedLutemons = id + 1;
    }
}
