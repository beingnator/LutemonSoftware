package main.lutemonsoftware;

public class White extends Lutemon {

    public White(String lutemonName) {
        super(lutemonName, "Valkoinen");
        attack = 5;
        defence = 4;
        maxHealth = health = 20;
        id = getNumberOfCreatedLutemons();
        numberOfCreatedLutemons = id + 1;
        image = R.drawable.white_bunny;
    }
}
