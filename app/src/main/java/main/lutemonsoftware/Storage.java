package main.lutemonsoftware;

import java.util.ArrayList;

public class Storage {
    private String name;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static Storage storage = null;

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
}
