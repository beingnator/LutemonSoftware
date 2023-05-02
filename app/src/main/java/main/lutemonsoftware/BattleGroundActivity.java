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

    private Lutemon lutemon1;
    private Lutemon lutemon2;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lutemon1 = Storage.getFirstSelectedLutemon();
        lutemon2 = Storage.getSecondSelectedLutemon();

        TextView lutemon1Name = findViewById(R.id.txtLutemon1Name);
        TextView lutemon2Name = findViewById(R.id.txtLutemon2Name);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_ground);


        // If there isn't exactly 2 chosen Lutemons to fight, one must be returned to main activity.

        if ( Storage.getNumberOfSelectedLutemons() != 2 ) {
            Toast.makeText(context, "Valitse listauksesta -KAKSI- Lutemonia taistellaksesi", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }


        lutemon1Name.setText(lutemon1.getName());
        lutemon2Name.setText(lutemon1.getName());



    }

    public void startBattle(View view) {

        Button btnStartFight = findViewById(R.id.btnFight);
        TextView fightStats = findViewById(R.id.txtBattleStats);



    }


}