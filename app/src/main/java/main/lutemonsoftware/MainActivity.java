package main.lutemonsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Storage s = Storage.getInstance();
        s.loadLutemons(this);
    }

    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToListLutemon(View view) {
        Intent intent = new Intent(this, LutemonListActivity.class);
        startActivity(intent);
    }

    public void switchToBattleGround(View view) {
        Intent intent = new Intent(this, BattleGroundActivity.class);
        startActivity(intent);
    }
}

// Moi! Jos sait tämän näkymään niin kaikki toimii!!!!!

// Tässä päässä kaikki toimii! ! !

// Toimii