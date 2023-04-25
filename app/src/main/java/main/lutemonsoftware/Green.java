package main.lutemonsoftware;

public class Green extends Lutemon {

    public Green(String lutemonName) {
        super(lutemonName, "Vihreä");
        attack = 6;
        defence = 3;
        maxHealth = health = 19;
        id = getNumberOfCreatedLutemons();
        numberOfCreatedLutemons = id + 1;
        image = R.drawable.green_flower;
    }
}
