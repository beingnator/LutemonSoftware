package main.lutemonsoftware;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BattleGroundActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_ground);


        // If there isn't exactly 2 chosen Lutemons to fight, one must be returned to main activity. Waits 4 seconds before.
        if ( Storage.getNumberOfSelectedLutemons() != 2 ) {
            Toast.makeText(context, "Valitse listauksesta -KAKSI- Lutemonia taistellaksesi", Toast.LENGTH_LONG).show();
            Thread closeActivity = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4000);
                        // Do some stuff
                    } catch (Exception e) {
                        e.getLocalizedMessage();
                    }
                }
                });
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }


    }

    public void startBattle(View view) {
        RadioGroup rgFighters = findViewById(R.id.rgFightingLutemons);
        CheckBox fighterOne = findViewById(R.id.checkFighter1);
        CheckBox fighterTwo = findViewById(R.id.checkFighter2);
        CheckBox fighterThree = findViewById(R.id.checkFighter3);
        CheckBox fighterFour = findViewById(R.id.checkFighter4);
        Button btnStartFight = findViewById(R.id.btnFight);
        TextView fightStats = findViewById(R.id.txtBattleStats);


    }


}