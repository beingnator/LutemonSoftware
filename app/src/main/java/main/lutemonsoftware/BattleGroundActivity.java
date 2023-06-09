package main.lutemonsoftware;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BattleGroundActivity extends AppCompatActivity {

    private Lutemon lutemon1;
    private Lutemon lutemon2;
    long wait = 3000;
    private Context context = this;
    private int firstRunIndicator = 0;
    private int turn = 1;

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



    public void startBattle(View view) throws Exception {

        Random random = new Random();


        // In first run we want to get random lutemon to start with attack.
        if ( firstRunIndicator  == 0 ) {
            if ( random.nextBoolean() ) {
                turn = 2;
            }
            firstRunIndicator = 1;
        }

        // if turn is zero, means  that fight has ended and return to main activity
        if ( turn != 0 ) {
            turn = fight(turn);
            Storage.saveLutemons(this);
        }
        else{
            firstRunIndicator = 0;
            turn = 1;
            Storage.saveLutemons(this);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }


    }


    private int fight(int turn) throws Exception {

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


        // The attacking side changes after every turn and we have to check which one is attacking, 1st or 2nd
        if ( turn == 1 ) {
            lutemon1Action.setImageResource(R.drawable.sword_icon16);
            lutemon2Action.setImageResource(R.drawable.shield_icon_png_10);

            attackDamage = lutemon1.attack + Math.round(lutemon1.experienceAttack * random.nextInt(101) / 100);
            defence = lutemon2.defence + Math.round(lutemon2.experienceDefence * random.nextInt(101) / 100);

            txtLutemon1Action.setText( String.valueOf(attackDamage) );

            // If defence potential is greater than attack potential, sum is 0, cant do negative damage.
            if ( attackDamage <= defence) {
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


            turn = 2; // change turn to the other lutemon

        }

        else {
            lutemon2Action.setImageResource(R.drawable.sword_icon16);
            lutemon1Action.setImageResource(R.drawable.shield_icon_png_10);


            attackDamage = lutemon1.attack + Math.round(lutemon1.experienceAttack * random.nextInt(101) / 100);
            defence = lutemon2.defence + Math.round(lutemon2.experienceDefence * random.nextInt(101) / 100);

            txtLutemon2Action.setText( String.valueOf(attackDamage) );

            // If defence potential is greater than attack potential, sum is 0, cant do negative damage.
            if ( attackDamage <= defence) {
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

            turn = 1; // change turn to the other lutemon

        }


        // Operations after other lutemon has won
        if ( lutemon1.health <= 0 | lutemon2.health <= 0 ) {
            // After battle the lutemon that died must be handled according to lutemonDeathHandler
            if ( lutemon1.health <= 0 ) {
                lutemon1.lutemonDeathHandler();
                lutemon1.setBattlesLost( lutemon1.getBattlesLost() + 1 );
                lutemon2.setBattlesWon( lutemon2.getBattlesWon() + 1 );
                Toast.makeText(context, "Taistelu on päättynyt, " + lutemon1.getName() + " hävisi ja menetti kokemuksensa.", Toast.LENGTH_LONG).show();
                txtLutemon1Health.setText("Elämä: 0");  // life doesn't go below 0
            } else {
                lutemon2.lutemonDeathHandler();
                lutemon2.setBattlesLost( lutemon2.getBattlesLost() + 1 );
                lutemon1.setBattlesWon( lutemon1.getBattlesWon() + 1 );
                Toast.makeText(context, "Taistelu on päättynyt, " + lutemon2.getName() + " hävisi ja menetti kokemuksensa.", Toast.LENGTH_LONG).show();
                txtLutemon2Health.setText("Elämä: 0"); // life doesn't go below 0
            }


            turn = 0;
        }

        return turn;
    }

}
