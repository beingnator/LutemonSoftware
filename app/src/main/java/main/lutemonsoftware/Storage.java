package main.lutemonsoftware;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Storage {
    private static ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static Storage storage = null;
    private static int numberOfSelecterdLutemons=0;
    private static int i;

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
        return lutemons.get(pos);
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

    public static int getNumberOfSelectedLutemons() {
        numberOfSelecterdLutemons = 0;
        for ( Lutemon lutemon : lutemons ) {
            if ( lutemon.getSelectionStatus() == 1 ) {
                numberOfSelecterdLutemons = numberOfSelecterdLutemons + 1;
            }
        }
        return numberOfSelecterdLutemons;
    }

    public static Lutemon getFirstSelectedLutemon() {
        for (i=0 ; i < lutemons.size() ; i++ ) {
            System.out.println("Eka arvo on " + i);

            if ( lutemons.get(i).getSelectionStatus() == 1 ) {
                System.out.println("toka arvo on " + i);
                break;
            }
        }

        System.out.println("viimeinen arvo on " + i);
        return lutemons.get(i);
    }

    public static Lutemon getSecondSelectedLutemon() {
        for (i=lutemons.size()-1 ; i > -1 ; i-- ) {
            if ( lutemons.get(i).getSelectionStatus() == 1 ) {
                break;
            }
        }
        return lutemons.get(i);
    }

}
