package main.lutemonsoftware;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BattleGroundActivity extends AppCompatActivity {

    private Lutemon lutemon1;
    private Lutemon lutemon2;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_ground);

        TextView lutemon1Name = findViewById(R.id.txtLutemon1Name);
        TextView lutemon2Name = findViewById(R.id.txtLutemon2Name);
        TextView lutemon1Health = findViewById(R.id.txtLutemon1Health);
        TextView lutemon2Health = findViewById(R.id.txtLutemon2Health);
        ImageView lutemon1Logo = findViewById(R.id.imgLutemon1Logo);
        ImageView lutemon2Logo = findViewById(R.id.imgLutemon2Logo);

        // If there isn't exactly 2 chosen Lutemons to fight, one must be returned to main activity.

        if ( Storage.getNumberOfSelectedLutemons() != 2 ) {
            Toast.makeText(context, "Valitse listauksesta -KAKSI- Lutemonia taistellaksesi", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);


        } else { // Setting up all the components in BattleGround

            lutemon1 = Storage.getFirstSelectedLutemon();
            lutemon2 = Storage.getSecondSelectedLutemon();

            lutemon1Name.setText(lutemon1.getName());
            lutemon2Name.setText(lutemon2.getName());

            lutemon1Health.setText( "Elämä: " + lutemon1.getHealth() );
            lutemon2Health.setText( "Elämä: " +  lutemon2.getHealth() );

            lutemon1Logo.setImageResource(lutemon1.getImage());
            lutemon2Logo.setImageResource(lutemon2.getImage());

        }



    }



    public void startBattle(View view) {

        Random random = new Random();

        int turn = 1; // which Lutemon has attacking turn, first or second




        if ( random.nextBoolean() ) {
            turn = 2;
        }

        fight(turn);

    }


    private void fight(int turn) {

        int finalDamage = 0;
        int attackDamage = 0;
        int defence = 0;

        Random random = new Random();
        TextView txtLutemon1Health = findViewById(R.id.txtLutemon1Health);
        TextView txtLutemon2Health = findViewById(R.id.txtLutemon2Health);
        TextView txtLutemon1Action = findViewById(R.id.txtLutemon1Action);
        TextView txtLutemon2Action = findViewById(R.id.txtLutemon2Action);
        TextView txtBattleLog = findViewById(R.id.txtBattleLog);
        ImageView lutemon1Action = findViewById(R.id.imgLutemon1Action);
        ImageView lutemon2Action = findViewById(R.id.imgLutemon2Action);


        if ( turn == 1 ) {
            lutemon1Action.setImageResource(R.drawable.sword_icon16);
            lutemon2Action.setImageResource(R.drawable.shield_icon_png_10);

            attackDamage = lutemon1.attack + Math.round(lutemon1.experienceAttack * random.nextInt(101) / 100);
            defence = lutemon2.defence + Math.round(lutemon2.experienceAttack * random.nextInt(101) / 100);

            txtLutemon1Action.setText( String.valueOf( attackDamage) );

            if ( attackDamage <= defence ) {
                finalDamage = 0;
                txtLutemon2Action.setText( String.valueOf( -attackDamage) );
                txtBattleLog.append(lutemon1.getName() + " hyökkää, mutta " + lutemon2.getName() + " torjuu kaiken vahingon!\n");

            } else {
                finalDamage = attackDamage - defence;
                txtLutemon2Action.setText( String.valueOf( -defence) );
                txtBattleLog.append(lutemon1.getName() + " hyökkää ja " + lutemon2.getName() + " menettää " + String.valueOf(finalDamage) + " elämäpistettä!\n");
            }

            lutemon2.health = lutemon2.health - finalDamage;

            txtLutemon2Health.setText( "Elämä: " + lutemon2.health );


            turn = 2;

        }

        else {
            lutemon2Action.setImageResource(R.drawable.sword_icon16);
            lutemon1Action.setImageResource(R.drawable.shield_icon_png_10);


            attackDamage = lutemon1.attack + Math.round(lutemon1.experienceAttack * random.nextInt(101) / 100);
            defence = lutemon2.defence + Math.round(lutemon2.experienceAttack * random.nextInt(101) / 100);

            txtLutemon2Action.setText( String.valueOf( attackDamage) );

            if ( attackDamage <= defence ) {
                finalDamage = 0;
                txtLutemon1Action.setText( String.valueOf( -attackDamage) );
                txtBattleLog.append(lutemon2.getName() + " hyökkää, mutta " + lutemon1.getName() + " torjuu kaiken vahingon!\n");

            } else {
                finalDamage = attackDamage - defence;
                txtLutemon1Action.setText( String.valueOf( -defence) );
                txtBattleLog.append(lutemon2.getName() + " hyökkää ja " + lutemon1.getName() + " menettää " + String.valueOf(finalDamage) + " elämäpistettä!\n");

            }

            lutemon1.health = lutemon1.health - finalDamage;

            txtLutemon1Health.setText( "Elämä: " + lutemon1.health );



            turn = 1;

        }
    }


}