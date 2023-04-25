package main.lutemonsoftware;

public class Pink extends Lutemon {

    public Pink(String lutemonName) {
        super(lutemonName, "Pinkki");
        attack = 7;
        defence = 2;
        maxHealth = health = 18;
        id = getNumberOfCreatedLutemons();
        numberOfCreatedLutemons = id + 1;
        image = R.drawable.pink_cookie;
    }
}
