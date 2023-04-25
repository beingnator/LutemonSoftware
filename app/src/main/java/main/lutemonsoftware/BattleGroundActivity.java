package main.lutemonsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BattleGroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_ground);
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