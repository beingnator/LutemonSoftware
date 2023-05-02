package main.lutemonsoftware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
        RadioGroup rgAttDef = findViewById(R.id.rgAttDef);

        int attDefValue = -1;
        Lutemon lutemon = Storage.getInstance().getFirstSelectedLutemon();
        context = TrainingGroundActivity.this;

        switch (rgAttDef.getCheckedRadioButtonId()) {
            case R.id.rbAttack:
                attDefValue = 0;
                lutemon.train(attDefValue);
                Toast.makeText(context, "Hyökkäyksen treenaus suoritettu!", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbDefense:
                attDefValue = 1;
                lutemon.train(attDefValue);
                Toast.makeText(context, "Puolustuksen treenaus suoritettu!", Toast.LENGTH_LONG).show();
                break;
        }

        adapter.notifyDataSetChanged();

    }

}
