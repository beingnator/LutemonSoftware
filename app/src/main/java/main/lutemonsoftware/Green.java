package main.lutemonsoftware;

public class Green extends Lutemon {

    public Green() {
        attack = 6;
        defence = 3;
        maxHealth = health = 19;
        id = getNumberOfCreatedLutemons();
        numberOfCreatedLutemons = id + 1;
    }
}
