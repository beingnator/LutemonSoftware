package main.lutemonsoftware;

public class Orange extends Lutemon {

    public Orange() {
        attack = 8;
        defence = 1;
        maxHealth = health = 17;
        id = getNumberOfCreatedLutemons();
        numberOfCreatedLutemons = id + 1;


    }
}
