package main.lutemonsoftware;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public static Lutemon getLutemon(int pos) {
        return storage.lutemons.get(pos);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("lutemon.data", Context.MODE_PRIVATE));
            userWriter.writeObject(lutemons);
            userWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen ei onnistunut.");
        }
    }

    public void loadLutemons(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("lutemon.data"));
            lutemons = (ArrayList<Lutemon>) userReader.readObject();
            userReader.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
        }
    }

}
