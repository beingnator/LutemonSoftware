package main.lutemonsoftware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class TrainingGroundActivity extends AppCompatActivity {
    private Context context;
    private ArrayList<Lutemon> lutemons;
    private LutemonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_ground);

        lutemons = Storage.getInstance().getLutemons();

        adapter = new LutemonListAdapter(this, lutemons);

    }

    public void startTraining(View view) {
        RadioGroup rgFighters = findViewById(R.id.rgFighters);
        RadioGroup rgAttDef = findViewById(R.id.rgAttDef);

        int fighterIndex = -1;
        int attDefValue = -1;

        switch (rgFighters.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                fighterIndex = 0;
                break;
            case R.id.rbGreen:
                fighterIndex = 1;
                break;
            case R.id.rbPink:
                fighterIndex = 2;
                break;
            case R.id.rbOrange:
                fighterIndex = 3;
                break;
            case R.id.rbBlack:
                fighterIndex = 4;
                break;
            default:
                break;
        }

        switch (rgAttDef.getCheckedRadioButtonId()) {
            case R.id.rbAttack:
                attDefValue = 0;
                break;
            case R.id.rbDefense:
                attDefValue = 1;
                break;
            default:
                break;
        }

        if (fighterIndex >= 0 && fighterIndex < lutemons.size()) {
            Lutemon lutemon = lutemons.get(fighterIndex);
            lutemon.train(attDefValue);
            lutemons.set(fighterIndex, lutemon);
            adapter.notifyDataSetChanged();
        }

        // After training, the user get's notification that the training was successful!
        context = TrainingGroundActivity.this;
        Toast.makeText(context, "Treenaus suoritettu!", Toast.LENGTH_LONG).show();
    }

}
